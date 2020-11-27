package com.ozan.forex.application.service;

import java.math.BigDecimal;

public interface ExchangeRateService {
	BigDecimal getExchangeRate(String base, String symbol) throws Exception;
}
