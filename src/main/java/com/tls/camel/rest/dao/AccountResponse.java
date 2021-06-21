package com.tls.camel.rest.dao;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class AccountResponse {
	private Error error;
	private Success success;
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	public Success getSuccess() {
		return success;
	}
	public void setSuccess(Success success) {
		this.success = success;
	}
	@Override
	public String toString() {
		return "AccountResponse [error=" + error + ", success=" + success + "]";
	}

	
	
	
}
