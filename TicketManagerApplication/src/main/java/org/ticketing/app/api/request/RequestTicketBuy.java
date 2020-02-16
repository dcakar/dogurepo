package org.ticketing.app.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestTicketBuy {
	private Long flightId;
    private Integer ticketCount;
    private String ticketClass;
}
