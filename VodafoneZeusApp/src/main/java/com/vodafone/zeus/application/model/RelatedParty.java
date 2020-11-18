package com.vodafone.zeus.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelatedParty {
    @JsonProperty("IDs")
    private IdModel iDs;
    @JsonProperty("Desc")
    private Object desc;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Role")
    private String role;
}
