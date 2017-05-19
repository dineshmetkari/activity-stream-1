package com.stackroute.activity.builder;

import java.util.SortedMap;

import com.stackroute.activity.model.Stream;

public interface InboxBuilder {
	
	public SortedMap<Long, Stream> getMyInbox(String userID);

}
