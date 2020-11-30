package com.ozan.forex.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ozan.forex.application.controller.request.RequestGetConversionAmount;
import com.ozan.forex.application.controller.response.ResponseGetConversionAmount;
import com.ozan.forex.application.exception.enumeration.ApiErrorType;
import com.ozan.forex.application.exception.model.ApiError;
import com.ozan.forex.application.service.ConversionService;
import com.ozan.forex.application.util.JsonUtil;

@WebMvcTest(ConversionController.class)
public class ConversionControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ConversionService conversionService;
	private static final MediaType JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf-8"));

	@Test
	public void convertAmount_HttpOkTest() throws Exception {
		RequestGetConversionAmount request = new RequestGetConversionAmount();
		request.setSourceAmount(BigDecimal.ONE);
		request.setSourceCurrency("USD");
		request.setTargetCurrency("EUR");
		mockMvc.perform(post("/conversion/convert-amount").contentType(JSON_UTF8).content(JsonUtil.toJson(request))).andExpect(status().isOk());
	}

	@Test
	public void convertAmount_ReturnValueTest() throws Exception {
		ResponseGetConversionAmount response = new ResponseGetConversionAmount();
		RequestGetConversionAmount request = new RequestGetConversionAmount();
		request.setSourceAmount(BigDecimal.ONE);
		request.setSourceCurrency("USD");
		request.setTargetCurrency("EUR");
		when(conversionService.convertAmount(any(RequestGetConversionAmount.class))).thenReturn(response);
		MvcResult result = this.mockMvc.perform(post("/conversion/convert-amount").
				contentType(JSON_UTF8).content(JsonUtil.toJson(request))).andExpect(status().isOk()).andReturn();
		verify(conversionService, times(1)).convertAmount(any(RequestGetConversionAmount.class));
		String conversion = result.getResponse().getContentAsString();
		response = JsonUtil.fromJson(conversion, ResponseGetConversionAmount.class);
		assertNotNull(response);
	}
	
	@Test
	public void convertAmount_WhenSourceAmountNotGivenTest() throws Exception {
		ApiError errorResponse = new ApiError();
		RequestGetConversionAmount request = new RequestGetConversionAmount();
		request.setSourceCurrency("USD");
		request.setTargetCurrency("EUR");
		MvcResult result = this.mockMvc.perform(post("/conversion/convert-amount").
				contentType(JSON_UTF8).content(JsonUtil.toJson(request))).andExpect(status().isBadRequest()).andReturn();
		String responseEntity = result.getResponse().getContentAsString();
		errorResponse = JsonUtil.fromJson(responseEntity, ApiError.class);
		assertNotNull(errorResponse);
		assertEquals(errorResponse.getErrorCode(), ApiErrorType.METHOD_ARGUMENT_NOT_VALID.getCode());
	}
	
	@Test
	public void convertAmount_WhenSourceCurrencyNotGivenTest() throws Exception {
		RequestGetConversionAmount request = new RequestGetConversionAmount();
		request.setSourceAmount(BigDecimal.ONE);
		request.setTargetCurrency("EUR");
		MvcResult result = this.mockMvc.perform(post("/conversion/convert-amount").
				contentType(JSON_UTF8).content(JsonUtil.toJson(request))).andExpect(status().isBadRequest()).andReturn();
		String responseEntity = result.getResponse().getContentAsString();
		ApiError errorResponse = JsonUtil.fromJson(responseEntity, ApiError.class);
		assertNotNull(errorResponse);
		assertEquals(errorResponse.getErrorCode(), ApiErrorType.METHOD_ARGUMENT_NOT_VALID.getCode());
	}
	
	@Test
	public void convertAmount_WhenTargetCurrencyNotGivenTest() throws Exception {
		RequestGetConversionAmount request = new RequestGetConversionAmount();
		request.setSourceAmount(BigDecimal.ONE);
		request.setSourceCurrency("USD");
		MvcResult result = this.mockMvc.perform(post("/conversion/convert-amount").
				contentType(JSON_UTF8).content(JsonUtil.toJson(request))).andExpect(status().isBadRequest()).andReturn();
		String responseEntity = result.getResponse().getContentAsString();
		ApiError errorResponse = JsonUtil.fromJson(responseEntity, ApiError.class);
		assertNotNull(errorResponse);
		assertEquals(errorResponse.getErrorCode(), ApiErrorType.METHOD_ARGUMENT_NOT_VALID.getCode());
	}
}
