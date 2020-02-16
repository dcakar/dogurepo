package org.ticketing.app.service;

import org.ticketing.app.api.request.RequestAirlineCompanyAdd;
import org.ticketing.app.api.response.ResponseAirlineCompanyList;

/**
 * A service interface for airline company management operations.
 *
 * @author Dogu Cakar
 * @since 1.0
 */
public interface AirlineCompanyService {
	ResponseAirlineCompanyList getAirlineCompanyList() throws Exception;

	ResponseAirlineCompanyList getAirlineCompany(Long id) throws Exception;

	void addAirlineCompany(RequestAirlineCompanyAdd request) throws Exception;

	void addFlightToAirlineCompany(Long id, Long flightId) throws Exception;

	ResponseAirlineCompanyList getAirlineCompanyFlightList(Long id) throws Exception;

	ResponseAirlineCompanyList getAirlineCompanyFlight(Long id, Long flightId) throws Exception;
}
