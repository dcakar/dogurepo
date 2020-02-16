package org.ticketing.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketing.app.api.request.RequestAirportAdd;
import org.ticketing.app.api.response.ResponseAirportList;
import org.ticketing.app.dao.entity.Airport;
import org.ticketing.app.dao.repository.AirportRepository;
import org.ticketing.app.service.mapper.CommonMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class AirportServiceImpl implements AirportService {
	private AirportRepository airportRepository;

	@Override
	public ResponseAirportList getAirportList() throws Exception {
		ResponseAirportList response = new ResponseAirportList();
		List<Airport> airportEntityList = airportRepository.findAll();
		response.setAirportDtoList(CommonMapper.INSTANCE.toAirportDtoList(airportEntityList));
		return response;
	}

	@Override
	public ResponseAirportList getAirport(Long id) throws Exception {
		ResponseAirportList response = new ResponseAirportList();
		Optional<Airport> optionalAirportEntity = airportRepository.findById(id);
		if (optionalAirportEntity.isPresent()) {
			List<Airport> airportEntityList = new ArrayList<>();
			airportEntityList.add(optionalAirportEntity.get());
			response.setAirportDtoList(CommonMapper.INSTANCE.toAirportDtoList(airportEntityList));
		}
		return response;
	}

	@Override
	public void addAirport(RequestAirportAdd request) throws Exception {
		Airport airportEntity = new Airport();
		airportEntity.setName(request.getName());
		airportRepository.save(airportEntity);
	}
}