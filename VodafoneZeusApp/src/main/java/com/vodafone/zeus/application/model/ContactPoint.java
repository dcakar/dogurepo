package com.vodafone.zeus.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactPoint {
    @JsonProperty("Postal")
    private Postal postal;
    @JsonProperty("Email")
    private Object email;
    @JsonProperty("Telephone")
    private Telephone telephone;
}
