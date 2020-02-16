package org.ticketing.app.integration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.CollectionUtils;
import org.ticketing.app.api.request.RequestTicketBuy;
import org.ticketing.app.api.response.ResponseTicketBuy;
import org.ticketing.app.api.response.ResponseTicketSearch;
import org.ticketing.app.common.util.JsonUtil;
import org.ticketing.app.util.TestUtil;

public class TicketControllerTest extends AbstractIT {

    @Test
    public void getTicketByTicketNumber_ThenReturnSuccess() throws Exception {
        MvcResult result = mockMvc.perform(get(TestUtil.URL_TICKET_GET, "FL111111").contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andReturn();
        ResponseTicketSearch response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseTicketSearch.class);
        assertNotNull(response);
    }

    @Test
    public void buyTicket_ThenReturnSuccess() throws Exception {
        RequestTicketBuy request = TestUtil.createRequestTicketBuy();
        String requestJson = JsonUtil.toJson(request);
        MvcResult result = mockMvc.perform(post(TestUtil.URL_TICKET_BUY).contentType(APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().isOk()).andReturn();    
        ResponseTicketBuy response = JsonUtil.fromJson(result.getResponse().getContentAsString(), ResponseTicketBuy.class);
        assertNotNull(response);
        assertFalse(CollectionUtils.isEmpty(response.getTicketList()));
    }

    @Test
    public void cancelTicket_ThenReturnSuccess() throws Exception {
        mockMvc.perform(put(TestUtil.URL_TICKET_CANCEL, 1L).contentType(APPLICATION_JSON_UTF8)).andExpect(status().isOk());
    }
}
