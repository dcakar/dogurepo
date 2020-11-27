package com.ozan.forex.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreditProfile {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("CreditRiskRating")
    private String creditRiskRating;
    @JsonProperty("CreditScore")
    private Object creditScore;
}
