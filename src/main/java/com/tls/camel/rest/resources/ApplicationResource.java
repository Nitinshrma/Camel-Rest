package com.tls.camel.rest.resources;



import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.json.simple.JsonObject;
import org.apache.camel.model.rest.RestBindingMode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.tls.camel.rest.dao.Account;
import com.tls.camel.rest.dao.AccountResponse;
import com.tls.camel.rest.process.AccountProcess;
import com.tls.camel.rest.service.AccountService;
@Component
public class ApplicationResource extends RouteBuilder {

	@Autowired
	AccountService accountservice;
	@BeanInject
	AccountProcess processor;
	public void configure() throws Exception
	{
		restConfiguration().component("servlet").port(8080).host("localhost").bindingMode(RestBindingMode.json);
		rest().get("/helloworld").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(constant("WELCOME TO FUSE REST EXAMPLE"));
	
	    rest().get("/getAccountDetails").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(()->accountservice.getAccountDetails());
	   
	    rest().post("/addAccountDetails").consumes(MediaType.APPLICATION_JSON_VALUE).type(Account.class).outType(AccountResponse.class).route().process(processor).endRest();
	   // rest().post("/addAccountDetails").consumes(MediaType.APPLICATION_JSON_VALUE).type(Account.class).produces(MediaType.APPLICATION_JSON_VALUE).route().process(processor).endRest();
	}
}
