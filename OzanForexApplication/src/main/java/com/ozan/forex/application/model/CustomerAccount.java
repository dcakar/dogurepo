package com.ozan.forex.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAccount {
    @JsonProperty("IDs")
    private IdModel idModel;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Created")
    private String created;
    @JsonProperty("LastModified")
    private String lastModified;
    @JsonProperty("Details")
    private Details details;
    @JsonProperty("RelatedCustomerAccounts")
    private RelatedCustomerAccounts relatedCustomerAccounts;
    @JsonProperty("Roles")
    private Roles roles;
    @JsonProperty("Parts")
    private Parts parts;
    @JsonProperty("RelatedParties")
    private RelatedParties relatedParties;
}
