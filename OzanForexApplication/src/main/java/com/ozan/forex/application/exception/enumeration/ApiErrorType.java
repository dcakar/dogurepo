package com.ozan.forex.application.exception.enumeration;

public enum ApiErrorType {
	MEDIA_TYPE_NOT_SUPPORTED(25000),
	HTTP_MESSAGE_NOT_READABLE(25001),
	METHOD_ARGUMENT_NOT_VALID(25002),
	MISSING_SERVLET_REQUEST_PARAMETER(25003),
	METHOD_ARGUMENT_TYPE_MISMATCH(25004),
	CONSTRAINT_VIOLATION(25005),
	NO_HANDLER_FOUND(25006),
	OTHER_ERRORS(25007);
	
	private ApiErrorType(int code) {
		this.code = code;
	}
	
	private int code;

	public int getCode() {
		return code;
	}
}
