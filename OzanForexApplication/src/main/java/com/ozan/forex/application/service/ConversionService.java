package com.ozan.forex.application.service;

import com.ozan.forex.application.controller.request.RequestConversionAmount;
import com.ozan.forex.application.controller.response.ResponseConversionAmount;

public interface ConversionService {
	ResponseConversionAmount convertAmount(RequestConversionAmount request) throws Exception;
}
