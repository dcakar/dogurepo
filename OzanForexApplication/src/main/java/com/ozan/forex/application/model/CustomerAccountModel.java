package com.ozan.forex.application.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAccountModel {
    @JsonProperty("CustomerAccountVBO") 
    private List<CustomerAccount> customerAccountList;
}
