package org.ticketing.app.api.response;

import java.util.List;

import org.ticketing.app.dto.AirportDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAirportList {
	private List<AirportDTO> airportDtoList;
}
