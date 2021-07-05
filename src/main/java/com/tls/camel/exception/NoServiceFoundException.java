package com.tls.camel.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoServiceFoundException extends ResponseStatusException{

	public NoServiceFoundException(String message){
	    super(HttpStatus.NOT_FOUND, message);
	  }
}
