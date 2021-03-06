package com.vodafone.zeus.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerInformation {
    @JsonProperty("Header")
    private Header header;
    @JsonProperty("Body")
    private Body body;
}
