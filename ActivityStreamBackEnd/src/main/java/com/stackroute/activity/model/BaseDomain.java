package com.stackroute.activity.model;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
public class BaseDomain {
	
	@Transient
	public String statusMessage;
	
	
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
