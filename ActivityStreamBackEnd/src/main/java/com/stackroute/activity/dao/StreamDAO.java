package com.stackroute.activity.dao;

import java.util.List;
import java.util.SortedMap;

import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.Stream;

public interface StreamDAO {
	
	public SortedMap<Long,Stream> getMessages(List<Circle> circles);
	
	public boolean sendMessage(Circle circle);
	
	public boolean sendMessage(String userID);
	
	public boolean sendMessage(List<Circle> circles);

}