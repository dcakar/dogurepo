package com.ozan.forex.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BirthDate {
    @JsonProperty("DateString")
    private String dateString;
}
