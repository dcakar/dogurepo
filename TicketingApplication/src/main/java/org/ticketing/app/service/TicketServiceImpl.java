package org.ticketing.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ticketing.app.api.request.RequestTicketBuy;
import org.ticketing.app.api.response.ResponseTicketBuy;
import org.ticketing.app.api.response.ResponseTicketSearch;
import org.ticketing.app.common.constant.Constants;
import org.ticketing.app.dao.entity.Flight;
import org.ticketing.app.dao.entity.Ticket;
import org.ticketing.app.dao.repository.FlightRepository;
import org.ticketing.app.dao.repository.TicketRepository;
import org.ticketing.app.service.mapper.CommonMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class TicketServiceImpl implements TicketService {
	private TicketRepository ticketRepository;
	private FlightRepository flightRepository;

	@Override
	public ResponseTicketSearch getTicket(String ticketNumber) throws Exception {
		ResponseTicketSearch responseTicketSearch = new ResponseTicketSearch();
		Optional<Ticket> optionalTicketEntity = ticketRepository.findByTicketNumber(ticketNumber);
		if (optionalTicketEntity.isPresent()) {
			Ticket ticketEntity = optionalTicketEntity.get();
			responseTicketSearch.setArrival(ticketEntity.getFlight().getRoute().getArrival());
			responseTicketSearch.setAirlineCompanyName(ticketEntity.getFlight().getAirlineCompany().getName());
			responseTicketSearch.setAirportName(ticketEntity.getFlight().getAirport().getName());
			responseTicketSearch.setDeparture(ticketEntity.getFlight().getRoute().getDeparture());
			responseTicketSearch.setFlightDate(ticketEntity.getFlight().getFlightDate());
			responseTicketSearch.setTicketClass(ticketEntity.getTicketClass());
			responseTicketSearch.setTicketNumber(ticketEntity.getTicketNumber());
		}
		return responseTicketSearch;
	}

	@Override
	public ResponseTicketBuy buyTicket(RequestTicketBuy request) throws Exception {
		ResponseTicketBuy response = new ResponseTicketBuy();
		Optional<Flight> optionalFlightEntity = flightRepository.findById(request.getFlightId());
		if (optionalFlightEntity.isPresent()) {
			Flight flightEntity = optionalFlightEntity.get();
			List<Ticket> ticketEntityList = new ArrayList<Ticket>();
			for (int i = 1; i <= request.getTicketCount(); i++) {
				Ticket ticketEntity = new Ticket();
				ticketEntity.setCancelFlag(0);
				ticketEntity.setFlight(flightEntity);
				ticketEntity.setTicketClass(request.getTicketClass());
				Random randomizer = new Random();
				int randomNumber = randomizer.ints(100000, 1000000).limit(1).findFirst().getAsInt();
				ticketEntity.setTicketNumber(Constants.TICKET_NUMBER_PREFIX.concat(String.valueOf(randomNumber)));
				ticketEntityList.add(ticketEntity);
			}
			flightEntity.setTicketList(ticketEntityList);
			flightEntity.increaseTicketsSold(request.getTicketCount());
			List<Double> percentageList = Arrays.asList(90d, 80d, 70d, 60d, 40d, 50d, 30d, 20d, 10d);
			if (percentageList.contains(
					(flightEntity.getTicketsSold().doubleValue() / flightEntity.getTotalQuota().doubleValue()) * 100)) {
				Double newPrice = flightEntity.getPrice() * 1.1;
				flightEntity.setPrice(newPrice.intValue());
			}
			flightRepository.save(flightEntity);
			response.setTicketList(CommonMapper.INSTANCE.toTicketDtoList(ticketEntityList));
		}
		return response;
	}

	@Override
	public void cancelTicket(Long id) throws Exception {
		Optional<Ticket> optionalTicket = ticketRepository.findById(id);
		if (optionalTicket.isPresent()) {
			Ticket ticketEntity = optionalTicket.get();
			ticketEntity.getFlight().decreaseTicketsSold(1);
			ticketEntity.setCancelFlag(1);
			ticketRepository.save(ticketEntity);
		}
	}
}