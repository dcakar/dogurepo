package org.ticketing.app.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.util.CollectionUtils;
import org.ticketing.app.api.response.ResponseAirportList;
import org.ticketing.app.dao.entity.Airport;
import org.ticketing.app.dao.repository.AirportRepository;
import org.ticketing.app.util.TestUtil;

public class AirportServiceTest extends AbstractServiceTest {
    private AirportService airportService;
    @Mock
    private AirportRepository airportRepository;
   

    @Before
    public void setUp() {
    	airportService = new AirportServiceImpl(airportRepository);
    }

    @Test
    public void getAiportList_SuccessTest() throws Exception {
    	Airport airportEntity = TestUtil.createAirportEntity();
    	List<Airport> airportEntityList = new ArrayList<>();
    	airportEntityList.add(airportEntity);
        when(airportRepository.findAll()).thenReturn(airportEntityList);
    	ResponseAirportList response = airportService.getAirportList();
        verify(airportRepository, times(1)).findAll();
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getAirportDtoList()));
    }

    @Test
    public void getAirportById_SuccessTest() throws Exception {
    	Airport airportEntity = TestUtil.createAirportEntity();
        when(airportRepository.findById(anyLong())).thenReturn(Optional.of(airportEntity));
    	ResponseAirportList response = airportService.getAirport(TestUtil.LONG_VAL);
        verify(airportRepository, times(1)).findById(anyLong());
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getAirportDtoList()));
    }
    
    @Test
    public void addAirport_SuccessTest() throws Exception {
    	Airport airportEntity = TestUtil.createAirportEntity();
        when(airportRepository.save(any(Airport.class))).thenReturn(airportEntity);
    	airportService.addAirport(TestUtil.createRequestAirportAdd());
        verify(airportRepository, times(1)).save(any(Airport.class));
    }
}
