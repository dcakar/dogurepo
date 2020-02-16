package org.ticketing.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO {
	private Long id;
	private String ticketNumber;
	private String ticketClass;
	private Integer cancelFlag;
	
}
