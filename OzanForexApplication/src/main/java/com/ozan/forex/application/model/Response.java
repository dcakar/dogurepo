package com.ozan.forex.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    @JsonProperty("GetCustomerAccountListVBMResponse")
    private CustomerAccountModel customerAccountModel;
}
