package com.ozan.forex.application.controller.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestGetConversionAmount {
	@NotNull(message = "sourceAmount cannot be null")
	private BigDecimal sourceAmount;
	@NotNull(message = "sourceCurrency cannot be null")
	private String sourceCurrency;
	@NotNull(message = "targetCurrency cannot be null")
	private String targetCurrency;
}
