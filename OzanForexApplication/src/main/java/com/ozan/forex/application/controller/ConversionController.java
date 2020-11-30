package com.ozan.forex.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozan.forex.application.controller.request.RequestGetConversionAmount;
import com.ozan.forex.application.controller.response.ResponseGetConversionAmount;
import com.ozan.forex.application.service.ConversionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Conversion API")
@RestController
@RequestMapping("/conversion")
public class ConversionController {
	private ConversionService conversionService;
	
	@ApiOperation(value = "Converts amount from source to target currency")
    @PostMapping(path = "/convert-amount")
    public ResponseEntity<ResponseGetConversionAmount> convertAmount(@RequestBody @Validated RequestGetConversionAmount request) throws Exception {
		ResponseGetConversionAmount response = conversionService.convertAmount(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
