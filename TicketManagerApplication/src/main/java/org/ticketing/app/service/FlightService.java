package org.ticketing.app.service;

import org.ticketing.app.api.request.RequestFlightList;
import org.ticketing.app.api.response.ResponseFlightList;

/**
 * A service interface for flight management operations.
 *
 * @author Dogu Cakar
 * @since 1.0
 */
public interface FlightService {
	ResponseFlightList getFlightList() throws Exception;

	ResponseFlightList getFlightList(RequestFlightList request) throws Exception;

	ResponseFlightList getFlight(Long id) throws Exception;

	void cancelFlight(Long id) throws Exception;
}