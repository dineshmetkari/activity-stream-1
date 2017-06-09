package com.stackroute.activity.dao;

import java.util.List;
import java.util.SortedMap;

import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.Stream;

public interface StreamDAO {
	
	public List<Stream> getMessagesFromCircle(String circleName,int pageNumber); 
	
	public List<Stream> getMessagesFromUserHome(String userId,String otherUserId,int pageNumber);
	
	public List<Stream> getMessages(String userID,int pageNumber); 
	
	public boolean sendMessageToCircle(String circleName,Stream stream);
	 
	public boolean sendMessageToUser(String userID,Stream stream);
	 	
	public boolean sendMessageToCircles(List<String> circleNames,Stream stream);
	
	public List<String> listTags();
	
	public List<String> listMyTags(String userId);
	
	public List<Stream> showMessagesWithTag(String tag,int pageNumber);
	
	public boolean subscribeUserToTag(String userID, String tag);
	
	public boolean unsubscribeUserToTag(String userID, String tag);
	
	

}