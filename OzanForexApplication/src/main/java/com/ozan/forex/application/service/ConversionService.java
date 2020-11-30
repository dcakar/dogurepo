package com.ozan.forex.application.service;

import com.ozan.forex.application.controller.request.RequestGetConversionAmount;
import com.ozan.forex.application.controller.request.RequestGetConversions;
import com.ozan.forex.application.controller.response.ResponseGetConversionAmount;
import com.ozan.forex.application.controller.response.ResponseGetConversions;

public interface ConversionService {
	ResponseGetConversionAmount convertAmount(RequestGetConversionAmount request) throws Exception;

	ResponseGetConversions getConversions(RequestGetConversions request);
}
