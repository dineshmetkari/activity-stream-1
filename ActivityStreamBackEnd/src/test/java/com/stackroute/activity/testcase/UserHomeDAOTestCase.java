package com.stackroute.activity.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activity.dao.UserHomeDAO;
import com.stackroute.activity.model.UserStream;

public class UserHomeDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	 
	 	@Autowired  static UserHomeDAO  userHomeDAO;
	 
	 	@Autowired  static UserStream userStream;
	 	
	 	@BeforeClass
	 	public static void initialize()
	 	{
	 		context = new AnnotationConfigApplicationContext();
	 		context.scan("com.stackroute");
	 		context.refresh();
	 		
	 		userHomeDAO =  (UserHomeDAO) context.getBean("userHomeDAO");
	 		
	 		
	 		userStream = (UserStream)context.getBean("userStream");
	 	}
	 	
	 	
	 	@Test
	 	public void getUserHomeTestCase()
	 	{
	 		List<UserStream> userStreams = userHomeDAO.getMyInbox("Dinesh");
	 		System.out.println("User home streams");
	 		displayStreams(userStreams);
	 		assertEquals(2,  userStreams.size());
	 		
	 		
	 	}
	 	
	 	@Test
	 	public void getUserHomeByCircleIDTestCase()
	 	{
	 		List<UserStream> userStreams = userHomeDAO.getMyCircleMessages("hobes");
	 		System.out.println("Circle strems");
	 		displayStreams(userStreams);
	 		assertEquals(0,  userStreams.size());
	 		
	 		
	 	}
	 	
	 	
	 	
	 	private void displayStreams(List<UserStream> userStreams)
	 	{
	 		System.out.println("User ID \t Circle ID \t Sender \t Message \t Stream Type \t Tag ");
	 		for(UserStream userStream :userStreams )
	 		{
	 			System.out.print(userStream.getUserID() +"\t" + 
	 		                     userStream.getCircleID()+"\t"+
	 					         userStream.getSenderID()+"\t"+
	 					         userStream.getMessage() +"\t" + 
	 		                     userStream.getStreamType()+"\t"+
	 					         userStream.getTag());
	 			System.out.println();
	 		}
	 		
	 	}
}
