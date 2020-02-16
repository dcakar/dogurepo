package org.ticketing.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ticketing.app.api.request.RequestAirportAdd;
import org.ticketing.app.api.response.ResponseAirportList;
import org.ticketing.app.service.AirportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Airport Management API")
@RestController
@RequestMapping("/management/airport")
public class AirportController {
	private AirportService airportService;

	@ApiOperation(value = "Add airport")
	@PostMapping(path = "/add")
	public ResponseEntity<Void> addAirport(@RequestBody RequestAirportAdd request) throws Exception {
		airportService.addAirport(request);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Get airport list")
	@GetMapping(path = "/list")
	public ResponseEntity<ResponseAirportList> getAirportList() throws Exception {
		ResponseAirportList response = airportService.getAirportList();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get airport by id")
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseAirportList> getAirport(@PathVariable Long id) throws Exception {
		ResponseAirportList response = airportService.getAirport(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
