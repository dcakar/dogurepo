package com.ozan.forex.application.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ozan.forex.application.exception.model.ApiError;
import com.ozan.forex.application.exception.model.ApiErrors;
import com.ozan.forex.application.web.ErrorResponseEntityBuilder;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getContentType());
		builder.append(" media type is not supported. Supported media types are ");
		ex.getSupportedMediaTypes().forEach(type -> builder.append(type).append(", "));
		details.add(builder.toString());
		ApiError err = new ApiError(LocalDateTime.now(), ApiErrors.MEDIA_TYPE_NOT_SUPPORTED.getCode(), HttpStatus.BAD_REQUEST, "Invalid JSON", details);
		return ErrorResponseEntityBuilder.build(err);

	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());
		ApiError err = new ApiError(LocalDateTime.now(), ApiErrors.HTTP_MESSAGE_NOT_READABLE.getCode(), HttpStatus.BAD_REQUEST, "Malformed JSON request", details);
		return ErrorResponseEntityBuilder.build(err);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getObjectName() + " : " + error.getDefaultMessage()).collect(Collectors.toList());
		ApiError err = new ApiError(LocalDateTime.now(), ApiErrors.METHOD_ARGUMENT_NOT_VALID.getCode(), HttpStatus.BAD_REQUEST, "Validation Errors", details);
		return ErrorResponseEntityBuilder.build(err);
	}
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getParameterName() + " parameter is missing");
		ApiError err = new ApiError(LocalDateTime.now(), ApiErrors.MISSING_SERVLET_REQUEST_PARAMETER.getCode(), HttpStatus.BAD_REQUEST, "Missing Parameters", details);
		return ErrorResponseEntityBuilder.build(err);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());
		ApiError err = new ApiError(LocalDateTime.now(), ApiErrors.METHOD_ARGUMENT_TYPE_MISMATCH.getCode(), HttpStatus.BAD_REQUEST, "Mismatch Type", details);
		return ErrorResponseEntityBuilder.build(err);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());
		ApiError err = new ApiError(LocalDateTime.now(), ApiErrors.CONSTRAINT_VIOLATION.getCode(), HttpStatus.BAD_REQUEST, "Constraint Violation", details);
		return ErrorResponseEntityBuilder.build(err);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(String.format("Could not find the %s method for URL %s", ex.getHttpMethod(), ex.getRequestURL()));
		ApiError err = new ApiError(LocalDateTime.now(), ApiErrors.NO_HANDLER_FOUND.getCode(), HttpStatus.BAD_REQUEST, "Method Not Found", details);
		return ErrorResponseEntityBuilder.build(err);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ApiError err = new ApiError(LocalDateTime.now(), ApiErrors.OTHER_ERRORS.getCode(), HttpStatus.BAD_REQUEST, "Error occurred", details);
		return ErrorResponseEntityBuilder.build(err);
	}

}
