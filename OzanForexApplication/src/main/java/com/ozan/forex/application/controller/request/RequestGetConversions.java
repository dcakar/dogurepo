package com.ozan.forex.application.controller.request;

import java.time.LocalDateTime;

import com.ozan.forex.application.controller.validation.OneOfThemRequired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@OneOfThemRequired(with = {"transactionId", "transactionDate"}, message = "transactionId or transactionDate is mandatory")
public class RequestGetConversions {
	private String transactionId;
	private LocalDateTime transactionDate;
}
