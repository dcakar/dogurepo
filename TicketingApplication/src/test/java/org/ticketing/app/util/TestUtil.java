package org.ticketing.app.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ticketing.app.api.request.RequestAirlineCompanyAdd;
import org.ticketing.app.api.request.RequestAirportAdd;
import org.ticketing.app.api.request.RequestFlightList;
import org.ticketing.app.api.request.RequestRouteAdd;
import org.ticketing.app.api.request.RequestTicketBuy;
import org.ticketing.app.dao.entity.AirlineCompany;
import org.ticketing.app.dao.entity.Airport;
import org.ticketing.app.dao.entity.Flight;
import org.ticketing.app.dao.entity.Route;
import org.ticketing.app.dao.entity.Ticket;

public class TestUtil {
    public static final BigDecimal BIGDECIMAL_VAL = new BigDecimal(1000);
    public static final String STRING_VAL = "1";
    public static final String TEST = "TEST";
    public static final String VKN = "1111111111";
    public static final Long LONG_VAL = 111L;
    public static final Integer INT_VAL = 100;
    // CONTROLLER URL LIST
    public static final String URL_TICKET_GET = "/management/ticket/{ticketNumber}";
    public static final String URL_TICKET_BUY = "/management/ticket/buy";
    public static final String URL_TICKET_CANCEL = "/management/ticket/{id}/cancel";
    public static final String URL_AIRLINE_COMPANY_ADD = "/management/airline-company/add";
    public static final String URL_AIRLINE_COMPANY_LIST = "/management/airline-company/list";
    public static final String URL_AIRLINE_COMPANY_GET = "/management/airline-company/{id}";
    public static final String URL_AIRLINE_COMPANY_FLIGHT_ADD = "/management/airline-company/{id}/flights/add/{flightId}";
    public static final String URL_AIRLINE_COMPANY_FLIGHT_LIST = "/management/airline-company/{id}/flights/list";
    public static final String URL_AIRLINE_COMPANY_FLIGHT = "/management/airline-company/{id}/flights/{flightId}";
    public static final String URL_AIRPORT_ADD = "/management/airport/add";
    public static final String URL_AIRPORT_LIST= "/management/airport/list";
    public static final String URL_AIRPORT_GET = "/management/airport/{id}";
    public static final String URL_ROUTE_ADD = "/management/route/add";
    public static final String URL_ROUTE_LIST= "/management/route/list";
    public static final String URL_ROUTE_GET = "/management/route/{id}";
    public static final String URL_FLIGHT_LIST= "/management/flight/list";
    public static final String URL_FLIGHT_LIST_FILTER = "/management/flight/list/filter";
    public static final String URL_FLIGHT_GET = "/management/flight/{id}";
    public static final String URL_FLIGHT_CANCEL = "/management/flight/{id}/cancel";
    
    public static AirlineCompany createAirlineCompanyEntity() {
		Ticket ticket = new Ticket();
		ticket.setCancelFlag(INT_VAL);
		ticket.setTicketClass(STRING_VAL);
		ticket.setTicketNumber(STRING_VAL);
		List<Ticket> ticketList = new ArrayList<>();
		AirlineCompany airlineCompany = new AirlineCompany();
		airlineCompany.setName(STRING_VAL);
		Airport airport = new Airport();
		airport.setName(STRING_VAL);
		Route route = new Route();
		route.setArrival(STRING_VAL);
		route.setDeparture(STRING_VAL);
		List<Flight> flightList = new ArrayList<>();
		Flight flight = new Flight();
		flight.setId(LONG_VAL);
		flight.setAirport(airport);
		flight.setAirlineCompany(airlineCompany);
		flight.setFlightDate(new Date());
		flight.setPrice(INT_VAL);
		flight.setTicketsSold(0);
		flight.setTotalQuota(INT_VAL);
		flight.setAirlineCompany(airlineCompany);
		flight.setAirport(airport);
		flight.setRoute(route);
		ticket.setFlight(flight);
		ticketList.add(ticket);
		flight.setTicketList(ticketList);
		flightList.add(flight);
		airport.setFlightList(flightList);
		airlineCompany.setFlightList(flightList);
		airlineCompany.setFlightList(flightList);
		route.setFlightList(flightList);
		return airlineCompany;
	}
	
	public static Airport createAirportEntity() {
		Ticket ticket = new Ticket();
		ticket.setCancelFlag(INT_VAL);
		ticket.setTicketClass(STRING_VAL);
		ticket.setTicketNumber(STRING_VAL);
		List<Ticket> ticketList = new ArrayList<>();
		AirlineCompany airlineCompany = new AirlineCompany();
		airlineCompany.setName(STRING_VAL);
		Airport airport = new Airport();
		airport.setName(STRING_VAL);
		Route route = new Route();
		route.setArrival(STRING_VAL);
		route.setDeparture(STRING_VAL);
		List<Flight> flightList = new ArrayList<>();
		Flight flight = new Flight();
		flight.setAirport(airport);
		flight.setAirlineCompany(airlineCompany);
		flight.setFlightDate(new Date());
		flight.setPrice(INT_VAL);
		flight.setTicketsSold(0);
		flight.setTotalQuota(INT_VAL);
		flight.setAirlineCompany(airlineCompany);
		flight.setAirport(airport);
		flight.setRoute(route);
		ticket.setFlight(flight);
		ticketList.add(ticket);
		flight.setTicketList(ticketList);
		flightList.add(flight);
		airport.setFlightList(flightList);
		airlineCompany.setFlightList(flightList);
		airlineCompany.setFlightList(flightList);
		route.setFlightList(flightList);
		return airport;
	}
	
	public static Flight createFlightEntity() {
		Ticket ticket = new Ticket();
		ticket.setCancelFlag(INT_VAL);
		ticket.setTicketClass(STRING_VAL);
		ticket.setTicketNumber(STRING_VAL);
		List<Ticket> ticketList = new ArrayList<>();
		AirlineCompany airlineCompany = new AirlineCompany();
		airlineCompany.setName(STRING_VAL);
		Airport airport = new Airport();
		airport.setName(STRING_VAL);
		Route route = new Route();
		route.setArrival(STRING_VAL);
		route.setDeparture(STRING_VAL);
		List<Flight> flightList = new ArrayList<>();
		Flight flight = new Flight();
		flight.setAirport(airport);
		flight.setAirlineCompany(airlineCompany);
		flight.setCancelFlag(INT_VAL);
		flight.setFlightDate(new Date());
		flight.setId(LONG_VAL);
		flight.setPrice(INT_VAL);
		flight.setTicketsSold(0);
		flight.setTotalQuota(INT_VAL);
		flight.setAirlineCompany(airlineCompany);
		flight.setAirport(airport);
		flight.setRoute(route);
		ticket.setFlight(flight);
		ticketList.add(ticket);
		flight.setTicketList(ticketList);
		flightList.add(flight);
		airport.setFlightList(flightList);
		airlineCompany.setFlightList(flightList);
		airlineCompany.setFlightList(flightList);
		route.setFlightList(flightList);
		return flight;
	}

	public static Route createRouteEntity() {
		Ticket ticket = new Ticket();
		ticket.setCancelFlag(INT_VAL);
		ticket.setTicketClass(STRING_VAL);
		ticket.setTicketNumber(STRING_VAL);
		List<Ticket> ticketList = new ArrayList<>();
		AirlineCompany airlineCompany = new AirlineCompany();
		airlineCompany.setName(STRING_VAL);
		Airport airport = new Airport();
		airport.setName(STRING_VAL);
		Route route = new Route();
		route.setArrival(STRING_VAL);
		route.setDeparture(STRING_VAL);
		route.setId(LONG_VAL);
		List<Flight> flightList = new ArrayList<>();
		Flight flight = new Flight();
		flight.setAirport(airport);
		flight.setAirlineCompany(airlineCompany);
		flight.setFlightDate(new Date());
		flight.setPrice(INT_VAL);
		flight.setTicketsSold(0);
		flight.setTotalQuota(INT_VAL);
		flight.setAirlineCompany(airlineCompany);
		flight.setAirport(airport);
		flight.setRoute(route);
		ticket.setFlight(flight);
		ticketList.add(ticket);
		flight.setTicketList(ticketList);
		flightList.add(flight);
		airport.setFlightList(flightList);
		airlineCompany.setFlightList(flightList);
		airlineCompany.setFlightList(flightList);
		route.setFlightList(flightList);
		return route;
	}
	
	public static Ticket createTicketEntity() {
		Ticket ticket = new Ticket();
		ticket.setCancelFlag(INT_VAL);
		ticket.setTicketClass(STRING_VAL);
		ticket.setTicketNumber(STRING_VAL);
		List<Ticket> ticketList = new ArrayList<>();
		AirlineCompany airlineCompany = new AirlineCompany();
		airlineCompany.setName(STRING_VAL);
		Airport airport = new Airport();
		airport.setName(STRING_VAL);
		Route route = new Route();
		route.setArrival(STRING_VAL);
		route.setDeparture(STRING_VAL);
		List<Flight> flightList = new ArrayList<>();
		Flight flight = new Flight();
		flight.setAirport(airport);
		flight.setAirlineCompany(airlineCompany);
		flight.setFlightDate(new Date());
		flight.setPrice(INT_VAL);
		flight.setTicketsSold(0);
		flight.setTotalQuota(INT_VAL);
		flight.setAirlineCompany(airlineCompany);
		flight.setAirport(airport);
		flight.setRoute(route);
		ticket.setFlight(flight);
		ticketList.add(ticket);
		flight.setTicketList(ticketList);
		flightList.add(flight);
		airport.setFlightList(flightList);
		airlineCompany.setFlightList(flightList);
		airlineCompany.setFlightList(flightList);
		route.setFlightList(flightList);
		return ticket;
	}
	
	public static RequestTicketBuy createRequestTicketBuy() {
		RequestTicketBuy request = new RequestTicketBuy();
		request.setFlightId(LONG_VAL);
		request.setTicketClass(STRING_VAL);
		request.setTicketCount(10);
		return request;
	}
	
	public static RequestAirlineCompanyAdd createRequestAirlineCompanyAdd() {
		RequestAirlineCompanyAdd request = new RequestAirlineCompanyAdd();
		request.setName(STRING_VAL);
		return request;
	}
	
	public static RequestAirportAdd createRequestAirportAdd() {
		RequestAirportAdd request = new RequestAirportAdd();
		request.setName(STRING_VAL);
		return request;
	}
	
	public static RequestRouteAdd createRequestRouteAdd() {
		RequestRouteAdd request = new RequestRouteAdd();
		request.setArrival(STRING_VAL);
		request.setDeparture(STRING_VAL);
		return request;
	}
	
	public static RequestFlightList createRequestFlightList() {
		RequestFlightList request = new RequestFlightList();
		request.setAirlineCompanyId(LONG_VAL);
		request.setAirportId(LONG_VAL);
		request.setDeparture(STRING_VAL);
		request.setFlightStartDate(new Date());
		request.setFlightEndDate(new Date());
		return request;
	}
}
