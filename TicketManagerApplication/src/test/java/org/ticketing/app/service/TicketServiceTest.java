package org.ticketing.app.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.util.CollectionUtils;
import org.ticketing.app.api.response.ResponseTicketBuy;
import org.ticketing.app.api.response.ResponseTicketSearch;
import org.ticketing.app.dao.entity.Flight;
import org.ticketing.app.dao.entity.Ticket;
import org.ticketing.app.dao.repository.FlightRepository;
import org.ticketing.app.dao.repository.TicketRepository;
import org.ticketing.app.util.TestUtil;

public class TicketServiceTest extends AbstractServiceTest {
    private TicketService ticketService;
    @Mock
    private TicketRepository ticketRepository;
    @Mock
	private FlightRepository flightRepository;
   

    @Before
    public void setUp() {
    	ticketService = new TicketServiceImpl(ticketRepository, flightRepository);
    }
   
    @Test
    public void getTicketByTicketNumber_SuccessTest() throws Exception {
    	Ticket ticket = TestUtil.createTicketEntity();
        when(ticketRepository.findByTicketNumber(anyString())).thenReturn(Optional.of(ticket));
		ResponseTicketSearch response = ticketService.getTicket(TestUtil.STRING_VAL);
        verify(ticketRepository, times(1)).findByTicketNumber(anyString());
        assertNotNull(response);
        assertNotNull(response.getAirlineCompanyName());
    }
    
    @Test
    public void buyTicket_SuccessTest() throws Exception {
    	Flight flightEntity = TestUtil.createFlightEntity();
        when(flightRepository.findById(anyLong())).thenReturn(Optional.of(flightEntity));
        when(flightRepository.save(any(Flight.class))).thenReturn(flightEntity);
        ResponseTicketBuy response = ticketService.buyTicket(TestUtil.createRequestTicketBuy());
        verify(flightRepository, times(1)).findById(anyLong());
        verify(flightRepository, times(1)).save(any(Flight.class));
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getTicketList()));
    }
    
    @Test
    public void cancelTicket_SuccessTest() throws Exception {
    	Ticket ticketEntity = TestUtil.createTicketEntity();
        when(ticketRepository.findById(anyLong())).thenReturn(Optional.of(ticketEntity));
        ticketService.cancelTicket(TestUtil.LONG_VAL);
        verify(ticketRepository, times(1)).findById(anyLong());
    }
}
