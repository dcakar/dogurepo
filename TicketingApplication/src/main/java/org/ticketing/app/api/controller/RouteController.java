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
import org.ticketing.app.api.request.RequestRouteAdd;
import org.ticketing.app.api.response.ResponseRouteList;
import org.ticketing.app.service.RouteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Route Management API")
@RestController
@RequestMapping("/management/route")
public class RouteController {
	private RouteService routeService;
	
	@ApiOperation(value = "Add route")
    @PostMapping(path = "/add")
    public ResponseEntity<Void> addRoute(@RequestBody RequestRouteAdd request) throws Exception {
		routeService.addRoute(request);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get route list")
    @GetMapping(path = "/list")
    public ResponseEntity<ResponseRouteList> getRouteList() throws Exception {
    	ResponseRouteList response = routeService.getRouteList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get route by id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseRouteList> getRoute(@PathVariable Long id) throws Exception {
    	ResponseRouteList response = routeService.getRoute(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
