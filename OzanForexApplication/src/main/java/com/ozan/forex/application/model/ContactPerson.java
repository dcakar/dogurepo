package com.ozan.forex.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactPerson {
    @JsonProperty("IDs")
    private IdModel idModel;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("IndividualName")
    private IndividualName individualName;
    @JsonProperty("BirthDate")
    private BirthDate birthDate;
    @JsonProperty("FamilyGeneration")
    private Object familyGeneration;
    @JsonProperty("ContactPoints")
    private ContactPoints contactPoints;
}
