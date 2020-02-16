package org.ticketing.app.api.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestFlightAdd {
	private String departure;
	private String arrival;
	private Long airportId;
	private Long airlineCompanyId;
	private Date flightStartDate;
	private Date flightEndDate;;
}
