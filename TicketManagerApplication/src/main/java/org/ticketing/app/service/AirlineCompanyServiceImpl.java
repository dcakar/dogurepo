package org.ticketing.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.ticketing.app.api.request.RequestAirlineCompanyAdd;
import org.ticketing.app.api.response.ResponseAirlineCompanyList;
import org.ticketing.app.dao.entity.AirlineCompany;
import org.ticketing.app.dao.entity.Flight;
import org.ticketing.app.dao.repository.AirlineCompanyRepository;
import org.ticketing.app.dao.repository.FlightRepository;
import org.ticketing.app.service.mapper.CommonMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class AirlineCompanyServiceImpl implements AirlineCompanyService {
	private AirlineCompanyRepository airlineCompanyRepository;
	private FlightRepository flightRepository;

	@Override
	public ResponseAirlineCompanyList getAirlineCompanyList() throws Exception {
		ResponseAirlineCompanyList response = new ResponseAirlineCompanyList();
		List<AirlineCompany> airlineCompanyEntityList = airlineCompanyRepository.findAll();
		response.setAirlineCompanyDtoList(CommonMapper.INSTANCE.toAirlineCompanyDtoList(airlineCompanyEntityList));
		return response;
	}

	@Override
	public ResponseAirlineCompanyList getAirlineCompany(Long id) throws Exception {
		ResponseAirlineCompanyList response = new ResponseAirlineCompanyList();
		Optional<AirlineCompany> optionalAirlineCompanyEntity = airlineCompanyRepository.findById(id);
		if (optionalAirlineCompanyEntity.isPresent()) {
			List<AirlineCompany> airlineCompanyEntityList = new ArrayList<>();
			airlineCompanyEntityList.add(optionalAirlineCompanyEntity.get());
			response.setAirlineCompanyDtoList(CommonMapper.INSTANCE.toAirlineCompanyDtoList(airlineCompanyEntityList));
		}
		return response;
	}

	@Override
	public void addAirlineCompany(RequestAirlineCompanyAdd request) throws Exception {
		AirlineCompany airlineCompanyEntity = new AirlineCompany();
		airlineCompanyEntity.setName(request.getName());
		airlineCompanyRepository.save(airlineCompanyEntity);
	}

	@Override
	public void addFlightToAirlineCompany(Long id, Long flightId) throws Exception {
		Optional<AirlineCompany> optionalAirlineCompanyEntity = airlineCompanyRepository.findById(id);
		if (optionalAirlineCompanyEntity.isPresent()) {
			Optional<Flight> optionalflightEntity = flightRepository.findById(flightId);
			AirlineCompany airlineCompanyEntity = optionalAirlineCompanyEntity.get();
			if (optionalflightEntity.isPresent()) {
				List<Flight> flightEntityList = new ArrayList<>();
				Flight flightEntity = optionalflightEntity.get();
				flightEntity.setAirlineCompany(airlineCompanyEntity);
				flightEntityList.add(optionalflightEntity.get());
				airlineCompanyEntity.setFlightList(flightEntityList);
				airlineCompanyRepository.save(airlineCompanyEntity);
			}
		}
	}

	@Override
	public ResponseAirlineCompanyList getAirlineCompanyFlightList(Long id) throws Exception {
		ResponseAirlineCompanyList response = new ResponseAirlineCompanyList();
		Optional<AirlineCompany> optionalAirlineCompanyEntity = airlineCompanyRepository.findById(id);
		if (optionalAirlineCompanyEntity.isPresent()) {
			response.setFlightDtoList(CommonMapper.INSTANCE.toFlightDtoList(optionalAirlineCompanyEntity.get().getFlightList()));
		}
		return response;
	}

	@Override
	public ResponseAirlineCompanyList getAirlineCompanyFlight(Long id, Long flightId) throws Exception {
		ResponseAirlineCompanyList response = new ResponseAirlineCompanyList();
		Optional<AirlineCompany> optionalAirlineCompanyEntity = airlineCompanyRepository.findById(id);
		if (optionalAirlineCompanyEntity.isPresent()) {
			AirlineCompany airlineCompanyEntity = optionalAirlineCompanyEntity.get();
			if (airlineCompanyEntity != null && !CollectionUtils.isEmpty(airlineCompanyEntity.getFlightList())) {
				Optional<Flight> optionalFlight = airlineCompanyEntity.getFlightList().stream().findFirst()
						.filter(e -> e.getId().equals(flightId));
				if (optionalFlight.isPresent()) {
					List<Flight> flightEntityList = new ArrayList<>();
					flightEntityList.add(optionalFlight.get());
					response.setFlightDtoList(CommonMapper.INSTANCE.toFlightDtoList(flightEntityList));
				}
			}
		}
		
		return response;
	}
}