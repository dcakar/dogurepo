package org.ticketing.app.api.response;

import java.util.List;

import org.ticketing.app.dto.AirlineCompanyDTO;
import org.ticketing.app.dto.FlightDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAirlineCompanyList {
	private List<AirlineCompanyDTO> airlineCompanyDtoList;
	private List<FlightDTO> flightDtoList;
}
