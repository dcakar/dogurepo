package org.ticketing.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketing.app.api.request.RequestRouteAdd;
import org.ticketing.app.api.response.ResponseRouteList;
import org.ticketing.app.dao.entity.Route;
import org.ticketing.app.dao.repository.RouteRepository;
import org.ticketing.app.service.mapper.CommonMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class RouteServiceImpl implements RouteService {
	private RouteRepository routeRepository;

	@Override
	public ResponseRouteList getRouteList() throws Exception {
		ResponseRouteList response = new ResponseRouteList();
		List<Route> routeEntityList = routeRepository.findAll();
		response.setRouteDtoList(CommonMapper.INSTANCE.toRouteDtoList(routeEntityList));
		return response;
	}

	@Override
	public ResponseRouteList getRoute(Long id) throws Exception {
		ResponseRouteList response = new ResponseRouteList();
		Optional<Route> optionalRouteEntity = routeRepository.findById(id);
		if (optionalRouteEntity.isPresent()) {
			List<Route> routeEntityList = new ArrayList<>();
			routeEntityList.add(optionalRouteEntity.get());
			response.setRouteDtoList(CommonMapper.INSTANCE.toRouteDtoList(routeEntityList));
		}
		return response;
	}

	@Override
	public void addRoute(RequestRouteAdd request) {
		Route routeEntity = new Route();
		routeEntity.setArrival(request.getArrival());
		routeEntity.setDeparture(request.getDeparture());
		routeRepository.save(routeEntity);
	}
}