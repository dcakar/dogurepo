package org.ticketing.app.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.CollectionUtils;
import org.ticketing.app.api.request.RequestFlightList;
import org.ticketing.app.api.response.ResponseFlightList;
import org.ticketing.app.common.util.JsonUtil;
import org.ticketing.app.util.TestUtil;

public class FlightControllerTest extends AbstractIT {

    @Test
    public void getAllFlightList_ThenReturnSuccess() throws Exception {
        MvcResult result = mockMvc.perform(post(TestUtil.URL_FLIGHT_LIST).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();
        ResponseFlightList response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseFlightList.class);
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getFlightDtoList()));
    }

    @Test
    public void getFlightListFiltered_ThenReturnSuccess() throws Exception {
    	RequestFlightList request = new RequestFlightList();
    	request.setAirlineCompanyId(1L);
    	request.setAirportId(1L);
    	request.setDeparture("ISTANBUL");
    	request.setArrival("ANKARA");
    	Date tomorrow = Date.from(LocalDateTime.now().plusDays(1L).atZone(ZoneId.systemDefault()).toInstant());
    	Date yesterday = Date.from(LocalDateTime.now().minusDays(1L).atZone(ZoneId.systemDefault()).toInstant());
    	request.setFlightEndDate(tomorrow);
    	request.setFlightStartDate(yesterday);
    	String requestJson = JsonUtil.toJson(request);
    	MvcResult result = mockMvc.perform(post(TestUtil.URL_FLIGHT_LIST_FILTER).contentType(APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().isOk()).andReturn();    
        ResponseFlightList response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseFlightList.class);
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getFlightDtoList()));
    }

    @Test
    public void getFlightById_ThenReturnSuccess() throws Exception {
    	MvcResult result = mockMvc.perform(get(TestUtil.URL_FLIGHT_GET, 1L).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();
    	ResponseFlightList response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseFlightList.class);
    	assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getFlightDtoList()));
    }
    
    @Test
    public void cancelFlight_ThenReturnSuccess() throws Exception {
    	mockMvc.perform(put(TestUtil.URL_FLIGHT_CANCEL, 1L).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();
    }
}
