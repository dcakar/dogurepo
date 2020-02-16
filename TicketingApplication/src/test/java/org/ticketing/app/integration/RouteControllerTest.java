package org.ticketing.app.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.CollectionUtils;
import org.ticketing.app.api.request.RequestRouteAdd;
import org.ticketing.app.api.response.ResponseRouteList;
import org.ticketing.app.common.util.JsonUtil;
import org.ticketing.app.util.TestUtil;

public class RouteControllerTest extends AbstractIT {

    @Test
    public void addRoute_ThenReturnSuccess() throws Exception {
    	RequestRouteAdd request = new RequestRouteAdd();
    	request.setArrival(TestUtil.TEST);
    	request.setDeparture(TestUtil.TEST);
    	String requestJson = JsonUtil.toJson(request);
        mockMvc.perform(post(TestUtil.URL_ROUTE_ADD).contentType(APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getAllRouteList_ThenReturnSuccess() throws Exception {
        MvcResult result = mockMvc.perform(get(TestUtil.URL_ROUTE_LIST).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();    
        ResponseRouteList response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseRouteList.class);
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getRouteDtoList()));
    }

    @Test
    public void getRouteById_ThenReturnSuccess() throws Exception {
    	MvcResult result = mockMvc.perform(get(TestUtil.URL_ROUTE_GET, 1L).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();
    	ResponseRouteList response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseRouteList.class);
    	assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getRouteDtoList()));
    }
}
