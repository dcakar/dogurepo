package com.ozan.forex.application.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.ozan.forex.application.common.ApplicationConstants;
import com.ozan.forex.application.util.JsonUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
	private RestTemplate restTemplate;

	@Override
	public BigDecimal getExchangeRate(String base, String symbol) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		Map<String, String> params = new HashMap<String, String>();
		params.put("base", base);
		params.put("symbol", symbol);
		HttpEntity entity = new HttpEntity(headers);
		HttpEntity<String> response = restTemplate.exchange(ApplicationConstants.EXCHANGE_URL, HttpMethod.GET, entity,
				String.class, params);
		JsonNode root = JsonUtil.readTree(response.getBody());
		JsonNode name = root.path("rates");
		JsonNode rate = name.get(symbol);
		return new BigDecimal(rate.asText());

	}
}
