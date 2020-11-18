package com.vodafone.zeus.application.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parts {
    @JsonProperty("ContactPeople")
    private ContactPeople contactPeople;
    @JsonProperty("ServiceAccounts")
    private ServiceAccounts serviceAccounts;
    @JsonProperty("CustomerAccountBalance")
    private List<CustomerAccountBalance> customerAccountBalance;
    @JsonProperty("BillingAccounts")
    private BillingAccounts billingAccounts;
    @JsonProperty("StatusHistory")
    private StatusHistory statusHistory;
    @JsonProperty("CustomerCreditProfile")
    private CustomerCreditProfile customerCreditProfile;
}
