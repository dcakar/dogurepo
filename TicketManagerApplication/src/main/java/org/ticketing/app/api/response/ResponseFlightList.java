package org.ticketing.app.api.response;

import java.util.List;

import org.ticketing.app.dto.FlightDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseFlightList {
	private List<FlightDTO> flightDtoList;
}
