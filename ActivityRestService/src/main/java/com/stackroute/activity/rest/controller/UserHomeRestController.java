package com.stackroute.activity.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activity.dao.CircleDAO;
import com.stackroute.activity.dao.StreamDAO;
import com.stackroute.activity.dao.UserHomeDAO;
import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.Stream;
import com.stackroute.activity.model.UserStream;
import com.stackroute.activity.vo.UserHome;

@RestController
public class UserHomeRestController {
	
	@Autowired
	UserHomeDAO userHomeDAO;
	
	@Autowired
	UserHome userHome;
	
	@Autowired
	CircleDAO circleDAO;
	
	@Autowired
	StreamDAO streamDAO;
	
	//---------------------Get Messages by User----------------------------------
		@GetMapping("/userHome/getInboxByUser/{userId}/{pageNumber}")
		public UserHome getInboxByUser(@PathVariable("userId") String userId,@PathVariable("pageNumber") int pageNumber){
			
			
			userHome.setMyInbox(userHomeDAO.getMyInbox(userId));
			userHome.setMyCircles(circleDAO.getMyCircles(userId));
			
			for(String circleName:userHome.getMyCircles()){
				
				streamDAO.getMessagesFromCircle(circleName,pageNumber);
			}
			
			return userHome;
			
		}


}
