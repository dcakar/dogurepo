package org.ticketing.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ticketing.app.api.request.RequestTicketBuy;
import org.ticketing.app.api.response.ResponseTicketBuy;
import org.ticketing.app.api.response.ResponseTicketSearch;
import org.ticketing.app.service.TicketService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Ticket Management API")
@RestController
@RequestMapping("/management/ticket")
public class TicketController {
	TicketService ticketService;

	@ApiOperation(value = "Get ticket by ticket number")
	@GetMapping(path = "/{ticketNumber}")
	public ResponseEntity<ResponseTicketSearch> getTicket(@PathVariable String ticketNumber) throws Exception {
		ResponseTicketSearch response = ticketService.getTicket(ticketNumber);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Buy ticket")
	@PostMapping(path = "/buy")
	public ResponseEntity<ResponseTicketBuy> buyTicket(@RequestBody RequestTicketBuy request) throws Exception {
		ResponseTicketBuy response = ticketService.buyTicket(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Cancel ticket by id")
	@PutMapping(path = "/{id}/cancel")
	public ResponseEntity<Void> cancelTicket(@PathVariable Long id) throws Exception {
		ticketService.cancelTicket(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
