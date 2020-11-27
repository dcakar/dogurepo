package com.ozan.forex.application.web;

import org.springframework.http.ResponseEntity;

import com.ozan.forex.application.exception.model.ApiError;

public class ErrorResponseEntityBuilder {
	public static ResponseEntity<Object> build(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
