package org.ticketing.app.api.response;

import java.util.List;

import org.ticketing.app.dto.TicketDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTicketBuy {
	private List<TicketDTO> ticketList;
}
