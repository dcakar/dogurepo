package com.ozan.forex.application.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozan.forex.application.controller.request.RequestConversionAmount;
import com.ozan.forex.application.controller.response.ResponseConversionAmount;
import com.ozan.forex.application.dao.entity.ConversionsLog;
import com.ozan.forex.application.dao.repository.ConversionsLogRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ConversionServiceImpl implements ConversionService {
	private ExchangeRateService exchangeRateService;
	private ConversionsLogRepository conversionsLogRepository;

	@Override
	public ResponseConversionAmount convertAmount(RequestConversionAmount request) throws Exception {
		ResponseConversionAmount response = new ResponseConversionAmount();
		BigDecimal exchangeRate = exchangeRateService.getExchangeRate(request.getSourceCurrency(), request.getTargetCurrency());
		String transactionId = UUID.randomUUID().toString();
		response.setTransactionId(transactionId);
		response.setConversionAmount(request.getSourceAmount().multiply(exchangeRate));
		ConversionsLog conversionsLog = new ConversionsLog();
		conversionsLog.setConversionAmount(response.getConversionAmount());
		conversionsLog.setSourceAmount(request.getSourceAmount());
		conversionsLog.setSourceCurrency(request.getSourceCurrency());
		conversionsLog.setTargetCurrency(request.getTargetCurrency());
		conversionsLog.setTransactionDate(LocalDateTime.now());
		conversionsLog.setTransactionId(transactionId);
		conversionsLogRepository.save(conversionsLog);
		return response;
	}
}
