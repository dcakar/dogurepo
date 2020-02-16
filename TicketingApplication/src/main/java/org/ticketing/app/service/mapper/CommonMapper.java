package org.ticketing.app.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.ticketing.app.dao.entity.AirlineCompany;
import org.ticketing.app.dao.entity.Airport;
import org.ticketing.app.dao.entity.Flight;
import org.ticketing.app.dao.entity.Route;
import org.ticketing.app.dao.entity.Ticket;
import org.ticketing.app.dto.AirlineCompanyDTO;
import org.ticketing.app.dto.AirportDTO;
import org.ticketing.app.dto.FlightDTO;
import org.ticketing.app.dto.RouteDTO;
import org.ticketing.app.dto.TicketDTO;

@Mapper(componentModel = "spring")
public interface CommonMapper {
	CommonMapper INSTANCE = Mappers.getMapper(CommonMapper.class);
	
	AirlineCompanyDTO toAirlineCompanyDto(AirlineCompany airlineCompany);
	
	List<AirlineCompanyDTO> toAirlineCompanyDtoList(List<AirlineCompany> airlineCompanyEntityList);

    AirportDTO toAirportDto(Airport airport);
    
    List<AirportDTO> toAirportDtoList(List<Airport> airportEntityList);

    FlightDTO toFlightDto(Flight flight);
    
    List<FlightDTO> toFlightDtoList(List<Flight> flightEntityList);
    
    RouteDTO toRouteDto(Route route);
    
    List<RouteDTO> toRouteDtoList(List<Route> routeEntityList);
    
    TicketDTO toTicketDto(Ticket ticket);
    
    List<TicketDTO> toTicketDtoList(List<Ticket> ticketEntityList);
    
    AirlineCompany toAirlineCompanyEntity(AirlineCompanyDTO airlineCompanyDto);
    
    List<AirlineCompany> toAirlineCompanyEntityList(List<AirlineCompanyDTO> airlineCompanyDtoList);

    Airport toAirportEntity(AirportDTO airportDto);
    
    List<Airport> toAirportEntityList(List<AirportDTO> airportDtoList);

    Flight toFlightEntity(FlightDTO flightDto);
    
    List<Flight> toFlightEntityList(List<FlightDTO> flightDtoList);
    
    Route toRouteEntity(RouteDTO routeDto);
    
    List<Route> toRouteEntityList(List<RouteDTO> routeDtoList);
    
    Ticket toTicketEntity(TicketDTO ticketDto);
    
    List<Ticket> toTicketEntityList(List<TicketDTO> ticketDtoList);
}
