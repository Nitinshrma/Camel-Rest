package com.tls.camel.rest.dao;

public class Error {
	 public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Error [message=" + message + "]";
	}
	 
}
