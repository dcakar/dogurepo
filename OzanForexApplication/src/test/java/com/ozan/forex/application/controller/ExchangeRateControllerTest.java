package com.ozan.forex.application.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.ozan.forex.application.service.ExchangeRateService;

@WebMvcTest(ExchangeRateController.class)
public class ExchangeRateControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ExchangeRateService exchangeRateService;

	@Test
	public void getExchangeRate_NoParametersGivenTest() throws Exception {
		this.mockMvc.perform(get("/exchange-rate/latest")).andExpect(status().isBadRequest());
	}

	@Test
	public void getExchangeRate_AllParametersGivenTest() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("base", "USD");
		params.add("symbol", "EUR");
		MvcResult result = mockMvc.perform(get("/exchange-rate/latest").params(params)).andExpect(status().isOk()).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}
}
