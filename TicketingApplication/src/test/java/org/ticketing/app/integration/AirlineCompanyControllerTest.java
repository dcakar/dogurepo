package org.ticketing.app.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.CollectionUtils;
import org.ticketing.app.api.request.RequestAirlineCompanyAdd;
import org.ticketing.app.api.response.ResponseAirlineCompanyList;
import org.ticketing.app.common.util.JsonUtil;
import org.ticketing.app.util.TestUtil;

@Sql("/data.sql")
public class AirlineCompanyControllerTest extends AbstractIT {

    @Test
    public void addAirlineCompany_ThenReturnSuccess() throws Exception {
    	RequestAirlineCompanyAdd request = new RequestAirlineCompanyAdd();
    	request.setName(TestUtil.TEST);
    	String requestJson = JsonUtil.toJson(request);
    	mockMvc.perform(post(TestUtil.URL_AIRLINE_COMPANY_ADD).contentType(APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getAllAirlineCompanyList_ThenReturnSuccess() throws Exception {
        MvcResult result = mockMvc.perform(get(TestUtil.URL_AIRLINE_COMPANY_LIST).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();    
        ResponseAirlineCompanyList response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseAirlineCompanyList.class);
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getAirlineCompanyDtoList()));
    }

    @Test
    public void addFlightToAirlineCompany_ThenReturnSuccess() throws Exception {
    	mockMvc.perform(post(TestUtil.URL_AIRLINE_COMPANY_FLIGHT_ADD, 1L, 1L).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk());
    }
    
    @Test
    public void getAirlineCompanyFlightList_ThenReturnSuccess() throws Exception {
    	MvcResult result = mockMvc.perform(get(TestUtil.URL_AIRLINE_COMPANY_FLIGHT_LIST, 1L).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();
    	ResponseAirlineCompanyList response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseAirlineCompanyList.class);
    	assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getFlightDtoList()));
    }
    
    @Test
    public void getAirlineCompanyFlight_ThenReturnSuccess() throws Exception {
    	MvcResult result = mockMvc.perform(get(TestUtil.URL_AIRLINE_COMPANY_FLIGHT, 1L, 1L).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();
    	ResponseAirlineCompanyList response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseAirlineCompanyList.class);
    	assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getFlightDtoList()));
    }
}
