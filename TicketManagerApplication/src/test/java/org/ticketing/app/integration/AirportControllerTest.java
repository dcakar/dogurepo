package org.ticketing.app.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.CollectionUtils;
import org.ticketing.app.api.request.RequestAirportAdd;
import org.ticketing.app.api.response.ResponseAirportList;
import org.ticketing.app.common.util.JsonUtil;
import org.ticketing.app.util.TestUtil;

public class AirportControllerTest extends AbstractIT {

    @Test
    public void addAirport_ThenReturnSuccess() throws Exception {
    	RequestAirportAdd request = new RequestAirportAdd();
    	request.setName(TestUtil.TEST);
    	String requestJson = JsonUtil.toJson(request);
        mockMvc.perform(post(TestUtil.URL_AIRPORT_ADD).contentType(APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().isOk());
    }

    @Test
    public void getAllAirportList_ThenReturnSuccess() throws Exception {
        MvcResult result = mockMvc.perform(get(TestUtil.URL_AIRPORT_LIST).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();    
        ResponseAirportList response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseAirportList.class);
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getAirportDtoList()));
    }

    @Test
    public void getAirportById_ThenReturnSuccess() throws Exception {
    	MvcResult result = mockMvc.perform(get(TestUtil.URL_AIRPORT_GET, 1L).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();
    	ResponseAirportList response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseAirportList.class);
    	assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getAirportDtoList()));
    }
}
