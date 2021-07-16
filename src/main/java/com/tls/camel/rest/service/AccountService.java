package com.tls.camel.rest.service;


import java.io.IOException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sun.net.httpserver.Authenticator.Success;
import com.tls.camel.rest.dao.Account;
import com.tls.camel.rest.dao.AccountResponse;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class AccountService {
	
	@Autowired
	WebClient.Builder webClientBuilder;

	public String getAccountDetails()
	{
		Account acc=new Account();
		acc.setCaller_id("1234");
		acc.setAgent_number("789965");
		acc.setCustomer_number("8897792889");
		acc.setK_number("897654");
		return "HHHHHHHHS";
	}
	
	
	public ResponseEntity<AccountResponse> addAccountDetails(Account account) throws IOException
	{
		System.out.println("post method for external api call..."+account.getAgent_number());
		
		
		//3scale api need to consume  because it is in demeliterize zone so we are doing.....
		String restUrl="https://kpi.knowlarity.com/Basic/v1/account/call/makecall";
		JSONObject  jsonobj=null;
		AccountResponse response=null;
		try {
		 response=webClientBuilder.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build()
        .post()
        .uri(restUrl)
        .header("Authorization", "0efee30b-3dff-49cf-aada-ced87f546b0a")
        .header("x-api-key", "9f3245Z06F80OHRr8OBc39ifTM1ZfL7J718Nv5OG")
        .body(BodyInserters.fromValue(account)).accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(AccountResponse.class)
        .block();
		 response.getSuccess().setPrimary_id(account.getPrimary_id());
		 if(response.getSuccess().getStatus()=="success") {
			 System.out.println("In success(200) response block.............");
		 }else {
			 System.out.println("In not success response block.............");
		 }
		 return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(WebClientResponseException we) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new AccountResponse());
		}catch(WebClientRequestException wre) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}	
}
