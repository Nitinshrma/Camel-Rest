package com.tls.camel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -7661881974219233311L;

	private int statusCode;
	
	public ServiceException (String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}
	
	public ServiceException (String message) {
		super(message);
	}

	public int getStatusCode() {
		return statusCode;
	}
}