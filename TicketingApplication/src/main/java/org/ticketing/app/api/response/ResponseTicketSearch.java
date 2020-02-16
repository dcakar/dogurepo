package org.ticketing.app.api.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTicketSearch {
	private String airlineCompanyName;
	private String airportName;
	private Date flightDate;
	private String departure;
	private String arrival;
	private String ticketNumber;
	private String ticketClass;
}
