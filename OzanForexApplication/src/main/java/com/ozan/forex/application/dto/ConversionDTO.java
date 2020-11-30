package com.ozan.forex.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConversionDTO {
	private BigDecimal sourceAmount;
	private String sourceCurrency;
	private String targetCurrency;
	private BigDecimal conversionAmount;
	private String transactionId;
	private LocalDateTime transactionDate;
}
