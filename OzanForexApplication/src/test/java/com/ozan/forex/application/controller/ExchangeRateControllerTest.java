package com.ozan.forex.application.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ozan.forex.application.service.ExchangeRateService;

@WebMvcTest(controllers = ExchangeRateController.class)
@ActiveProfiles("test")
public class ExchangeRateControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ExchangeRateService exchangeRateService;

	@Test
	void getLatestExchangeRate_HttpOkTest() throws Exception {
		this.mockMvc.perform(get("/exchange-rate/latest")).andExpect(status().isOk());
	}

	@Test
	void getExchangeRate_ReturnValueTest() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/exchange-rate/latest")).andExpect(status().isOk()).andReturn();
		String latestRate = result.getResponse().getContentAsString();
		assertNotNull(latestRate);
	}
}
