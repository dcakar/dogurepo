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
import org.ticketing.app.api.response.ResponseAirlineCompanyList;
import org.ticketing.app.dao.entity.AirlineCompany;
import org.ticketing.app.dao.entity.Flight;
import org.ticketing.app.dao.repository.AirlineCompanyRepository;
import org.ticketing.app.dao.repository.FlightRepository;
import org.ticketing.app.util.TestUtil;

public class AirlineCompanyServiceTest extends AbstractServiceTest {
    private AirlineCompanyService airlineCompanyService;
    @Mock
    private AirlineCompanyRepository airlineCompanyRepository;
    @Mock
	private FlightRepository flightRepository;
   

    @Before
    public void setUp() {
    	airlineCompanyService = new AirlineCompanyServiceImpl(airlineCompanyRepository, flightRepository);
    }

    @Test
    public void getAirlineCompanyList_SuccessTest() throws Exception {
    	AirlineCompany airlineCompanyEntity = TestUtil.createAirlineCompanyEntity();
    	List<AirlineCompany> airlineCompanyEntityList = new ArrayList<>();
    	airlineCompanyEntityList.add(airlineCompanyEntity);
        when(airlineCompanyRepository.findAll()).thenReturn(airlineCompanyEntityList);
    	ResponseAirlineCompanyList response = airlineCompanyService.getAirlineCompanyList();
        verify(airlineCompanyRepository, times(1)).findAll();
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getAirlineCompanyDtoList()));
    }

    @Test
    public void getAirlineCompanyById_SuccessTest() throws Exception {
    	AirlineCompany airlineCompanyEntity = TestUtil.createAirlineCompanyEntity();
        when(airlineCompanyRepository.findById(anyLong())).thenReturn(Optional.of(airlineCompanyEntity));
    	ResponseAirlineCompanyList response = airlineCompanyService.getAirlineCompany(TestUtil.LONG_VAL);
        verify(airlineCompanyRepository, times(1)).findById(anyLong());
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getAirlineCompanyDtoList()));
    }
    
    @Test
    public void addAirlineCompany_SuccessTest() throws Exception {
    	AirlineCompany airlineCompanyEntity = TestUtil.createAirlineCompanyEntity();
        when(airlineCompanyRepository.save(any(AirlineCompany.class))).thenReturn(airlineCompanyEntity);
		airlineCompanyService.addAirlineCompany(TestUtil.createRequestAirlineCompanyAdd());
        verify(airlineCompanyRepository, times(1)).save(any(AirlineCompany.class));
    }
    
    @Test
    public void addFlightToAirlineCompany_SuccessTest() throws Exception {
        AirlineCompany airlineCompanyEntity = TestUtil.createAirlineCompanyEntity();
        Flight flightEntity = TestUtil.createFlightEntity();
    	when(airlineCompanyRepository.findById(anyLong())).thenReturn(Optional.of(airlineCompanyEntity));
        when(flightRepository.findById(anyLong())).thenReturn(Optional.of(flightEntity));
    	airlineCompanyService.addFlightToAirlineCompany(TestUtil.LONG_VAL, TestUtil.LONG_VAL);
        verify(airlineCompanyRepository, times(1)).findById(anyLong());
        verify(flightRepository, times(1)).findById(anyLong());
    }
    
    @Test
    public void getAirlineCompanyFlightList_SuccessTest() throws Exception {
    	AirlineCompany airlineCompanyEntity = TestUtil.createAirlineCompanyEntity();
    	when(airlineCompanyRepository.findById(anyLong())).thenReturn(Optional.of(airlineCompanyEntity));
    	ResponseAirlineCompanyList response = airlineCompanyService.getAirlineCompanyFlightList(TestUtil.LONG_VAL);
        verify(airlineCompanyRepository, times(1)).findById(anyLong());
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getFlightDtoList()));
    }
    
    @Test
    public void getAirlineCompanyFlight_SuccessTest() throws Exception {
    	AirlineCompany airlineCompanyEntity = TestUtil.createAirlineCompanyEntity();
    	when(airlineCompanyRepository.findById(anyLong())).thenReturn(Optional.of(airlineCompanyEntity));
    	ResponseAirlineCompanyList response = airlineCompanyService.getAirlineCompanyFlight(TestUtil.LONG_VAL, TestUtil.LONG_VAL);
    	verify(airlineCompanyRepository, times(1)).findById(anyLong());
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getFlightDtoList()));
    }
}
