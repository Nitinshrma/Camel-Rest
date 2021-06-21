package com.tls.camel.rest.service;

import org.apache.camel.json.simple.JsonObject;
import org.apache.camel.json.simple.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.tls.camel.rest.dao.Account;
import com.tls.camel.rest.dao.AccountResponse;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
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
	public AccountResponse addAccountDetails(Account account)
	{
		System.out.println("post method for external api call...");
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
        .body(BodyInserters.fromValue(account))
        .retrieve()
        .bodyToMono(AccountResponse.class)
        .block();
		 System.out.println("AccountResponse::::"+response);
		 
	/*	 jsonobj=new JSONObject(response);  
		System.out.println("response....."+jsonobj);
		if(jsonobj.getJSONObject("error")) {
			
		}*/
	//	JSONObject status=jsonobj.getJSONObject("error");
		
	//	System.out.println(status.toString());
		//String callerid=jsonobj.getString("call-id");
		
		//System.out.println("status.."+status.getString("error"));
		
		//https://kpi.knowlarity.com/Basic/v1/account/call/makecall
		/*
		{
		    "success": {
		        "status": "success",
		        "message": "Call successfully placed",
		        "call_id": "47de04df-3da5-443c-96e7-0c664dd56d03"
		    }
		}*/
	//Authorization:	0efee30b-3dff-49cf-aada-ced87f546b0a
//	x-api-key:9f3245Z06F80OHRr8OBc39ifTM1ZfL7J718Nv5OG
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return response;
				
	}
	
	
}
