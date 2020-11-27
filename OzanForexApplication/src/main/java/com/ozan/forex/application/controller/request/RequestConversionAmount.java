package com.ozan.forex.application.controller.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestConversionAmount {
	private BigDecimal sourceAmount;
	private String sourceCurrency;
	private String targetCurrency;
}
