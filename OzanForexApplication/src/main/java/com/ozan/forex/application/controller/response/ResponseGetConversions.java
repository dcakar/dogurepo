package com.ozan.forex.application.controller.response;

import java.util.List;

import com.ozan.forex.application.dto.ConversionDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseGetConversions {
	private List<ConversionDTO> conversionList;
}
