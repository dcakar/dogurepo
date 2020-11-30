package com.ozan.forex.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ozan.forex.application.controller.request.RequestGetConversions;
import com.ozan.forex.application.controller.response.ResponseGetConversions;
import com.ozan.forex.application.dto.ConversionDTO;
import com.ozan.forex.application.exception.enumeration.ApiErrorType;
import com.ozan.forex.application.exception.model.ApiError;
import com.ozan.forex.application.service.ConversionService;
import com.ozan.forex.application.util.JsonUtil;

@WebMvcTest(ConversionListController.class)
public class ConversionListControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ConversionService conversionService;
	private static final MediaType JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf-8"));

	@Test
	public void getConversionList_HttpOkTest() throws Exception {
		RequestGetConversions request = new RequestGetConversions();
		request.setTransactionDate(LocalDateTime.now());
		request.setTransactionId("123");
		mockMvc.perform(post("/conversion-list/filter").contentType(JSON_UTF8).content(JsonUtil.toJson(request))).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void getConversionList_WhenOnlyTransactionIdGivenTest() throws Exception {
		RequestGetConversions request = new RequestGetConversions();
		request.setTransactionId("1");
		ResponseGetConversions response = new ResponseGetConversions();
		List<ConversionDTO> conversionList = new ArrayList<>();
		conversionList.add(new ConversionDTO());
		response.setConversionList(conversionList);
		when(conversionService.getConversions(any(RequestGetConversions.class))).thenReturn(response);
		MvcResult result = mockMvc.perform(post("/conversion-list/filter").contentType(JSON_UTF8).content(JsonUtil.toJson(request))).andExpect(status().isOk()).andReturn();
		verify(conversionService, times(1)).getConversions(any(RequestGetConversions.class));
		String responseEntity = result.getResponse().getContentAsString();
		response = JsonUtil.fromJson(responseEntity, ResponseGetConversions.class);
		assertNotNull(response);
		assertFalse(response.getConversionList().isEmpty());
	}
	
	@Test
	public void getConversionList_WhenOnlyTransactionDateGivenTest() throws Exception {
		RequestGetConversions request = new RequestGetConversions();
		request.setTransactionDate(LocalDateTime.now());
		ResponseGetConversions response = new ResponseGetConversions();
		List<ConversionDTO> conversionList = new ArrayList<>();
		conversionList.add(new ConversionDTO());
		response.setConversionList(conversionList);
		when(conversionService.getConversions(any(RequestGetConversions.class))).thenReturn(response);
		MvcResult result = mockMvc.perform(post("/conversion-list/filter").contentType(JSON_UTF8).content(JsonUtil.toJson(request))).andExpect(status().isOk()).andReturn();
		verify(conversionService, times(1)).getConversions(any(RequestGetConversions.class));
		String responseEntity = result.getResponse().getContentAsString();
		response = JsonUtil.fromJson(responseEntity, ResponseGetConversions.class);
		assertNotNull(response);
		assertFalse(response.getConversionList().isEmpty());
	}
	
	@Test
	public void getConversionList_WhenAllInputsMissingTest() throws Exception {
		RequestGetConversions request = new RequestGetConversions();
		MvcResult result = mockMvc.perform(post("/conversion-list/filter").contentType(JSON_UTF8).content(JsonUtil.toJson(request))).andExpect(status().isBadRequest()).andReturn();
		String responseEntity = result.getResponse().getContentAsString();
		ApiError errorResponse = JsonUtil.fromJson(responseEntity, ApiError.class);
		assertNotNull(errorResponse);
		assertEquals(errorResponse.getErrorCode(), ApiErrorType.METHOD_ARGUMENT_NOT_VALID.getCode());
	}
}
