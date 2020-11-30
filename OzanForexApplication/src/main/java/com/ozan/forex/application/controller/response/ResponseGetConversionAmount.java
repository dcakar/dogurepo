package com.ozan.forex.application.controller.response;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseGetConversionAmount {
	private BigDecimal conversionAmount;
	private String transactionId;
}