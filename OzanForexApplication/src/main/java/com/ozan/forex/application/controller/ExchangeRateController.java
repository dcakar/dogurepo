package com.ozan.forex.application.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ozan.forex.application.service.ExchangeRateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Exchange Rate API")
@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {
	private ExchangeRateService exchangeRateService;
	
	@ApiOperation(value = "Get latest exchange rate")
    @GetMapping(path = "/latest")
    public ResponseEntity<BigDecimal> getExchangeRate(@RequestParam("base") String base, @RequestParam("symbol") String symbol) throws Exception {
		BigDecimal exchangeRate = exchangeRateService.getExchangeRate(base, symbol);
		return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
	}

}
