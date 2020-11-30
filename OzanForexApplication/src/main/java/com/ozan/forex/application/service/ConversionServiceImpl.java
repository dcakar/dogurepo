package com.ozan.forex.application.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozan.forex.application.common.mapper.GlobalMapper;
import com.ozan.forex.application.controller.request.RequestGetConversionAmount;
import com.ozan.forex.application.controller.request.RequestGetConversions;
import com.ozan.forex.application.controller.response.ResponseGetConversionAmount;
import com.ozan.forex.application.controller.response.ResponseGetConversions;
import com.ozan.forex.application.dao.entity.Conversion;
import com.ozan.forex.application.dao.repository.ConversionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ConversionServiceImpl implements ConversionService {
	private ExchangeRateService exchangeRateService;
	private ConversionRepository conversionRepository;

	@Override
	public ResponseGetConversionAmount convertAmount(RequestGetConversionAmount request) throws Exception {
		ResponseGetConversionAmount response = new ResponseGetConversionAmount();
		BigDecimal exchangeRate = exchangeRateService.getExchangeRate(request.getSourceCurrency(), request.getTargetCurrency());
		String transactionId = UUID.randomUUID().toString();
		response.setTransactionId(transactionId);
		response.setConversionAmount(request.getSourceAmount().multiply(exchangeRate));
		createConversionRecord(request, response);
		return response;
	}
	
	private void createConversionRecord(RequestGetConversionAmount request, ResponseGetConversionAmount response) {
		Conversion conversion = new Conversion();
		conversion.setConversionAmount(response.getConversionAmount());
		conversion.setSourceAmount(request.getSourceAmount());
		conversion.setSourceCurrency(request.getSourceCurrency());
		conversion.setTargetCurrency(request.getTargetCurrency());
		conversion.setTransactionDate(LocalDateTime.now());
		conversion.setTransactionId(response.getTransactionId());
		conversionRepository.save(conversion);
	}

	@Override
	public ResponseGetConversions getConversions(RequestGetConversions request) {
		ResponseGetConversions response = new ResponseGetConversions();
		response.setConversionList(GlobalMapper.toConversionDTOList(conversionRepository.
				findByTransactionIdOrTransactionDate(request.getTransactionId(), request.getTransactionDate())));
		return response;
	}
}
