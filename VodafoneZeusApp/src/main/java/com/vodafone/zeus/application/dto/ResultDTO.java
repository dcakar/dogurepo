package com.vodafone.zeus.application.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultDTO {
    private List<ConvertedDataDTO> convertedDataList;
}
