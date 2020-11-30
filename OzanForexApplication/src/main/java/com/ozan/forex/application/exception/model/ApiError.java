package com.ozan.forex.application.exception.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
	private LocalDateTime timestamp;
	private int errorCode;
	private HttpStatus status;
	private String message;
	private List<String> errors;
}
