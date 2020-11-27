package com.ozan.forex.application.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceAccounts {
    @JsonProperty("ServiceAccount")
    private List<ServiceAccount> serviceAccount;
}
