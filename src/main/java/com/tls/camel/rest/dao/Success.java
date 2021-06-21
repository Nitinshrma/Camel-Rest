package com.tls.camel.rest.dao;

public class Success {
	public String status;
    public String message;
    public String call_id;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCall_id() {
		return call_id;
	}
	public void setCall_id(String call_id) {
		this.call_id = call_id;
	}
	@Override
	public String toString() {
		return "Success [status=" + status + ", message=" + message + ", call_id=" + call_id + "]";
	}
    
    
}
