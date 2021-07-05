package com.tls.camel;

import com.tls.camel.soap.service.AccountSoapService;
import com.tml.springsoap.gen.*;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountEndpoint {

    private static final String NAMESPACE_URI = "http://www.tml.com/springsoap/gen";

    private AccountSoapService soapService;

    @Autowired
    public AccountEndpoint(AccountSoapService soapService) {
        this.soapService = soapService;
    }
   
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addAccountRequest")
    @ResponsePayload
    public AddAccountResponse addAccount(@RequestPayload AddAccountRequest request)  {
    	AddAccountResponse response = new AddAccountResponse();
        try {
			response.setAccountResponse(soapService.addAccount(request));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return response;
    }
}
