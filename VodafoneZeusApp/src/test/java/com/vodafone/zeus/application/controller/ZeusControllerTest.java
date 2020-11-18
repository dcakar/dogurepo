package com.vodafone.zeus.application.controller;

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

import com.vodafone.zeus.application.service.DataConverterService;
import com.vodafone.zeus.application.util.JsonUtil;
import com.vodafone.zeus.application.web.controller.ZeusController;
import com.vodafone.zeus.application.web.response.ConvertedDataResponse;

@WebMvcTest(controllers = ZeusController.class)
@ActiveProfiles("test")
public class ZeusControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DataConverterService dataConverterService;

	@Test
    void getConvertedData_HttpOkTest() throws Exception {
    	this.mockMvc.perform(get("/zeus/convert")).andExpect(status().isOk());
    }
	
	@Test
    void getConvertedData_ReturnValueTest() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/zeus/convert")).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		ConvertedDataResponse convertedDataResponse = JsonUtil.fromJson(content, ConvertedDataResponse.class);
		assertNotNull(convertedDataResponse);
    }
}
