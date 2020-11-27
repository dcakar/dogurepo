package com.ozan.forex.application.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Header {
    @JsonProperty("Timestamp")
    private Date timestamp;
}
