package org.ticketing.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightDTO {
	private Long id;
	private String flightDate;
	private Integer totalQuota;
	private Integer ticketsSold;
	private Integer price;
	private Integer cancelFlag;
}