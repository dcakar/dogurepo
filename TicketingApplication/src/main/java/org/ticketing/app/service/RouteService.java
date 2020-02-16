package org.ticketing.app.service;

import org.ticketing.app.api.request.RequestRouteAdd;
import org.ticketing.app.api.response.ResponseRouteList;

/**
 * A service interface for route management operations.
 *
 * @author Dogu Cakar
 * @since 1.0
 */
public interface RouteService {
    ResponseRouteList getRouteList() throws Exception;
    ResponseRouteList getRoute(Long id) throws Exception;
	void addRoute(RequestRouteAdd request);
}
