package com.ozan.forex.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillingAccount {
    @JsonProperty("IDs")
    private IdModel idModel;
    @JsonProperty("Name")
    private Object name;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("BillTypeCode")
    private String billTypeCode;
    @JsonProperty("CustomerBillingCycleSpecification")
    private CustomerBillingCycleSpecification customerBillingCycleSpecification;
}
