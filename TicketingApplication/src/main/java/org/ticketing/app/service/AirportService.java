package org.ticketing.app.service;

import org.ticketing.app.api.request.RequestAirportAdd;
import org.ticketing.app.api.response.ResponseAirportList;

/**
 * A service interface for airport management operations.
 *
 * @author Dogu Cakar
 * @since 1.0
 */
public interface AirportService {
	ResponseAirportList getAirportList() throws Exception;

	ResponseAirportList getAirport(Long id) throws Exception;

	void addAirport(RequestAirportAdd request) throws Exception;
}
