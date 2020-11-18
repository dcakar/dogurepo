package com.vodafone.zeus.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAccountBalance {
    @JsonProperty("Amount")
    private int amount;
    @JsonProperty("DueDate")
    private DueDate dueDate;
}
