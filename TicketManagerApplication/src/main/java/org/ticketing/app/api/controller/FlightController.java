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
import org.ticketing.app.api.request.RequestFlightList;
import org.ticketing.app.api.response.ResponseFlightList;
import org.ticketing.app.service.FlightService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Flight Management API")
@RestController
@RequestMapping("/management/flight")
public class FlightController {
	FlightService flightService;

	@ApiOperation(value = "Get flight list")
	@PostMapping(path = "/list")
	public ResponseEntity<ResponseFlightList> getFlightList() throws Exception {
		ResponseFlightList response = flightService.getFlightList();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get flight list by parameters")
	@PostMapping(path = "/list/filter")
	public ResponseEntity<ResponseFlightList> getFlightList(@RequestBody RequestFlightList request) throws Exception {
		ResponseFlightList response = flightService.getFlightList(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get flight by id")
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseFlightList> getFlight(@PathVariable Long id) throws Exception {
		ResponseFlightList response = flightService.getFlight(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Cancel flight by id")
	@PutMapping(path = "/{id}/cancel")
	public ResponseEntity<Void> cancelTicket(@PathVariable Long id) throws Exception {
		flightService.cancelFlight(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
