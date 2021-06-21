package com.tls.camel.rest.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
	private String k_number;
	private String agent_number;
	private String customer_number;
	private String caller_id;
	public String getK_number() {
		return k_number;
	}
	public void setK_number(String k_number) {
		this.k_number = k_number;
	}
	public String getAgent_number() {
		return agent_number;
	}
	public void setAgent_number(String agent_number) {
		this.agent_number = agent_number;
	}
	public String getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}
	public String getCaller_id() {
		return caller_id;
	}
	public void setCaller_id(String caller_id) {
		this.caller_id = caller_id;
	}
	
	
/*	public Account() {
		// TODO Auto-generated constructor stub
	}*/
}
