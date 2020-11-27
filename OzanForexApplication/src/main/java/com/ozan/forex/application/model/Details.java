package com.ozan.forex.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Details {
    @JsonProperty("PIN")
    private String pin;
    @JsonProperty("TaxIdentificationNumber")
    private String taxIdentificationNumber;
}
