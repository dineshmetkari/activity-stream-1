package com.stackroute.activity.dao;

import java.util.List;
import java.util.SortedMap;

import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.Stream;

public interface StreamDAO {
	
	public List<Stream> getMessagesFromCircle(String circleName); 
	
	public List<Stream> getMessagesFromUserHome(String userId,String otherUserId);
	
	public List<Stream> getMessages(String userID); 
	
	public boolean sendMessageToCircle(String circleName,Stream stream);
	 
	public boolean sendMessageToUser(String userID,Stream stream);
	 	
	public boolean sendMessageToCircles(List<String> circleNames,Stream stream);
	
	public List<String> listTags();

}