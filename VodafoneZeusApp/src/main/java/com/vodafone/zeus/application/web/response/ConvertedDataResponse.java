package com.vodafone.zeus.application.web.response;

import com.vodafone.zeus.application.dto.ResultDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvertedDataResponse extends BaseResponse {
    private ResultDTO result;
}
