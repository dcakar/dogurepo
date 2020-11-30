package com.ozan.forex.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozan.forex.application.controller.request.RequestGetConversions;
import com.ozan.forex.application.controller.response.ResponseGetConversions;
import com.ozan.forex.application.service.ConversionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Conversion List API")
@RestController
@RequestMapping("/conversion-list")
public class ConversionListController {
	private ConversionService conversionService;
	
	@ApiOperation(value = "Get conversion list by parameters")
    @PostMapping(path = "/filter")
    public ResponseEntity<ResponseGetConversions> getConversions(@RequestBody @Validated RequestGetConversions request) throws Exception {
		ResponseGetConversions response = conversionService.getConversions(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
