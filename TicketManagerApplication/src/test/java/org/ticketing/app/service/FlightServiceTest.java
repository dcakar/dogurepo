package org.ticketing.app.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
import org.ticketing.app.api.request.RequestFlightList;
import org.ticketing.app.api.response.ResponseFlightList;
import org.ticketing.app.dao.entity.Flight;
import org.ticketing.app.dao.repository.FlightRepository;
import org.ticketing.app.util.TestUtil;

public class FlightServiceTest extends AbstractServiceTest {
    private FlightService flightService;
    @Mock
	private FlightRepository flightRepository;
   

    @Before
    public void setUp() {
    	flightService = new FlightServiceImpl(flightRepository);
    }

    @Test
    public void getFlightList_SuccessTest() throws Exception {
    	Flight flightEntity = TestUtil.createFlightEntity();
    	List<Flight> flightEntityList = new ArrayList<>();
    	flightEntityList.add(flightEntity);
        when(flightRepository.findAll()).thenReturn(flightEntityList);
    	ResponseFlightList response = flightService.getFlightList();
        verify(flightRepository, times(1)).findAll();
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getFlightDtoList()));
    }

    @Test
    public void getFlighListWithFilter_SuccessTest() throws Exception {
    	RequestFlightList request = TestUtil.createRequestFlightList();
    	Flight flightEntity = TestUtil.createFlightEntity();
    	List<Flight> flightEntityList = new ArrayList<>();
    	flightEntityList.add(flightEntity);
        when(flightRepository.findByParams(request.getDeparture(), request.getArrival(), request.getAirlineCompanyId(), request.getAirportId(), 
        		request.getFlightStartDate(), request.getFlightEndDate())).thenReturn(flightEntityList);
    	ResponseFlightList response = flightService.getFlightList(request);
        verify(flightRepository, times(1)).findByParams(request.getDeparture(), request.getArrival(), request.getAirlineCompanyId(), request.getAirportId(), 
        		request.getFlightStartDate(), request.getFlightEndDate());
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getFlightDtoList()));
    }
    
    @Test
    public void getFlightById_SuccessTest() throws Exception {
    	Flight flightEntity = TestUtil.createFlightEntity();
        when(flightRepository.findById(anyLong())).thenReturn(Optional.of(flightEntity));
		flightService.getFlight(TestUtil.LONG_VAL);
        verify(flightRepository, times(1)).findById(anyLong());
    }
    
    @Test
    public void cancelFlight_SuccessTest() throws Exception {
    	Flight flightEntity = TestUtil.createFlightEntity();
        when(flightRepository.findById(anyLong())).thenReturn(Optional.of(flightEntity));
		flightService.cancelFlight(TestUtil.LONG_VAL);
        verify(flightRepository, times(1)).findById(anyLong());
    }
}
