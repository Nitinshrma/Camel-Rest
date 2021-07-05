package com.tls.camel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClientException;

import com.tls.camel.rest.dao.AccountResponse;

public class MyClientException extends WebClientException {
    private final HttpStatus status;
    private final AccountResponse details;

    public MyClientException(HttpStatus status, AccountResponse errorDetails) {
        super(status.getReasonPhrase());
        this.status = status;
        this.details = errorDetails;
    }



	public HttpStatus getStatus() {
        return status;
    }

    public AccountResponse getDetails() {
        return details;
    }
}
