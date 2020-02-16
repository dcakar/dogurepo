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
import org.ticketing.app.api.request.RequestAirlineCompanyAdd;
import org.ticketing.app.api.response.ResponseAirlineCompanyList;
import org.ticketing.app.service.AirlineCompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Airline Company Management API")
@RestController
@RequestMapping("/management/airline-company")
public class AirlineCompanyController {
	private AirlineCompanyService airlineCompanyService;

	@ApiOperation(value = "Add airline company")
	@PostMapping(path = "/add")
	public ResponseEntity<Void> addAirlineCompany(@RequestBody RequestAirlineCompanyAdd request) throws Exception {
		airlineCompanyService.addAirlineCompany(request);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Get airline company list")
	@GetMapping(path = "/list")
	public ResponseEntity<ResponseAirlineCompanyList> getAirlineCompanyList() throws Exception {
		ResponseAirlineCompanyList response = airlineCompanyService.getAirlineCompanyList();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get airline company by id")
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseAirlineCompanyList> getAirlineCompany(@PathVariable Long id) throws Exception {
		ResponseAirlineCompanyList response = airlineCompanyService.getAirlineCompany(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Add flight to airline company")
	@PostMapping(path = "/{id}/flights/add/{flightId}")
	public ResponseEntity<Void> addFlightToCompany(@PathVariable Long id, @PathVariable Long flightId)throws Exception {
		airlineCompanyService.addFlightToAirlineCompany(id, flightId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@ApiOperation(value = "Get airline company flight list")
	@GetMapping(path = "/{id}/flights/list")
	public ResponseEntity<ResponseAirlineCompanyList> getAirlineCompanyFlightList(@PathVariable Long id) throws Exception {
		ResponseAirlineCompanyList response = airlineCompanyService.getAirlineCompanyFlightList(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get airline company flight by flight id")
	@GetMapping(path = "/{id}/flights/{flightId}")
	public ResponseEntity<ResponseAirlineCompanyList> getAirlineCompanyFlight(@PathVariable Long id, @PathVariable Long flightId) throws Exception {
		ResponseAirlineCompanyList response = airlineCompanyService.getAirlineCompanyFlight(id, flightId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}