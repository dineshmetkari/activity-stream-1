package com.stackroute.activity.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.stackroute.activity.model.BaseDomain;
import com.stackroute.activity.model.UserStream;

@Component
public class UserHome extends BaseDomain{
	
	private List<UserStream> myInbox;
	
	private List<String> myCircles;

	public List<UserStream> getMyInbox() {
		return myInbox;
	}

	public void setMyInbox(List<UserStream> myInbox) {
		this.myInbox = myInbox;
	}

	public List<String> getMyCircles() {
		return myCircles;
	}

	public void setMyCircles(List<String> myCircles) {
		this.myCircles = myCircles;
	}
	
	

}
