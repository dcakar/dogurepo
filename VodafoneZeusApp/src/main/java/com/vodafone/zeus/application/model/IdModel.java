package com.vodafone.zeus.application.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdModel {
    @JsonProperty("ID")
    private List<String> idList;
}
