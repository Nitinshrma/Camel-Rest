package com.tls.camel.soap.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tls.camel.rest.dao.Account;
import com.tls.camel.rest.service.AccountService;
import com.tml.springsoap.gen.AccountResponse;
import com.tml.springsoap.gen.AddAccountRequest;
import com.tml.springsoap.gen.Error;
import com.tml.springsoap.gen.Success;

@Service
public class AccountSoapService {

	
	@Autowired
	public AccountService service;
	public AccountResponse addAccount(AddAccountRequest request) throws IOException{
		Account account = new Account();
		 account.setK_number(request.getKNumber());
		 account.setCaller_id(request.getCallerId());
		 account.setCustomer_number(request.getCustomerNumber());
		 account.setAgent_number(request.getAgentNumber());
		 
		ResponseEntity<com.tls.camel.rest.dao.AccountResponse> response =service.addAccountDetails(account);
		
				System.out.println("Hello....... "+response.toString());
				if(response!=null)
				{
					System.out.println("in if "+response.toString());
				}else
				{
					System.out.println("in else"+response.toString());
				}
				AccountResponse rs=new AccountResponse();
				Success su=new Success();
				com.tls.camel.rest.dao.Success succ=response.getBody().getSuccess();
				if(response.getBody().getSuccess()!=null)
				{
					System.out.println(">>   in if ");
				su.setCallerId(response.getBody().getSuccess().getCall_id());
				su.setMessage(response.getBody().getSuccess().getMessage());
				su.setStatus(response.getBody().getSuccess().getStatus());
				}
				else
				{
					System.out.println(">>in else");
					su.setCallerId("none");
					su.setMessage("none");
					su.setStatus("none");
				}
				Error error=new Error();
				System.out.println("nnnnnn,,,"+error.getMessage());
				if(response.getBody().getError()!=null)
				{
					error.setMessage(response.getBody().getError().getMessage());
					
				}else {
					error.setMessage("noerror");
				}
				rs.setSuccess(su);
				rs.setError(error);
		return rs;
	}

}
