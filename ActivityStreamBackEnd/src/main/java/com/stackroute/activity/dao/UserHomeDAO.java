package com.stackroute.activity.dao;

import java.util.List;

import com.stackroute.activity.model.UserStream;

public interface UserHomeDAO {

	public List<UserStream>  getMyInbox(String userID);
	
	public List<UserStream>  getMyCircleMessages(String circleID);
	
}
