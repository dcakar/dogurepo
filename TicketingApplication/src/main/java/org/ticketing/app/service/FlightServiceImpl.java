package org.ticketing.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketing.app.api.request.RequestFlightList;
import org.ticketing.app.api.response.ResponseFlightList;
import org.ticketing.app.dao.entity.Flight;
import org.ticketing.app.dao.repository.FlightRepository;
import org.ticketing.app.service.mapper.CommonMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class FlightServiceImpl implements FlightService {
	private FlightRepository flightRepository;

	@Override
	public ResponseFlightList getFlightList() throws Exception {
		ResponseFlightList response = new ResponseFlightList();
		List<Flight> flightEntityList = flightRepository.findAll();
		response.setFlightDtoList(CommonMapper.INSTANCE.toFlightDtoList(flightEntityList));
		return response;
	}

	@Override
	public ResponseFlightList getFlightList(RequestFlightList request) throws Exception {
		ResponseFlightList response = new ResponseFlightList();
		List<Flight> flightEntityList = flightRepository.findByParams(request.getDeparture(), request.getArrival(),
				request.getAirlineCompanyId(), request.getAirportId(), request.getFlightStartDate(),
				request.getFlightEndDate());
		response.setFlightDtoList(CommonMapper.INSTANCE.toFlightDtoList(flightEntityList));
		return response;
	}

	@Override
	public ResponseFlightList getFlight(Long id) throws Exception {
		ResponseFlightList response = new ResponseFlightList();
		List<Flight> flightEntityList = new ArrayList<>();
		Optional<Flight> optionalFlight = flightRepository.findById(id);
		if (optionalFlight.isPresent()) {
			flightEntityList.add(optionalFlight.get());
		}
		response.setFlightDtoList(CommonMapper.INSTANCE.toFlightDtoList(flightEntityList));
		return response;
	}

	@Override
	public void cancelFlight(Long id) throws Exception {
		Optional<Flight> optionalFlight = flightRepository.findById(id);
		if (optionalFlight.isPresent()) {
			Flight flight = optionalFlight.get();
			flight.cancelFlight();
			flightRepository.save(flight);
		}
	}
}