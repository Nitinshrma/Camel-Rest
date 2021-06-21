package com.tls.camel.rest.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tls.camel.rest.dao.Account;
import com.tls.camel.rest.dao.AccountResponse;
import com.tls.camel.rest.service.AccountService;
@Component
public class AccountProcess implements Processor {
	
	@Autowired
	private AccountService accountService;
	

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		AccountResponse response=accountService.addAccountDetails(exchange.getIn().getBody(Account.class));
		exchange.getIn().setBody(response);
	}

}
