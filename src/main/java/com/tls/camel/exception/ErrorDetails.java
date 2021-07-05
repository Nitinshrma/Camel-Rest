package com.tls.camel.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

public class ErrorDetails {

	@Autowired
	WebClient.Builder webClient;
	

}
