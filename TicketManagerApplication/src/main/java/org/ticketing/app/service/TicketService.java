package org.ticketing.app.service;

import org.ticketing.app.api.request.RequestTicketBuy;
import org.ticketing.app.api.response.ResponseTicketBuy;
import org.ticketing.app.api.response.ResponseTicketSearch;

/**
 * A service interface for ticket management operations.
 *
 * @author Dogu Cakar
 * @since 1.0
 */
public interface TicketService {
	ResponseTicketSearch getTicket(String ticketNumber) throws Exception;
    ResponseTicketBuy buyTicket(RequestTicketBuy request) throws Exception;
    void cancelTicket(Long id) throws Exception;
}
