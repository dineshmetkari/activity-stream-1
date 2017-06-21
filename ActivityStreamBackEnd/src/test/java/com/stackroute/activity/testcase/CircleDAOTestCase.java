package com.stackroute.activity.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activity.dao.CircleDAO;
import com.stackroute.activity.model.Circle;

public class CircleDAOTestCase {

@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static CircleDAO  circleDAO;
	
	@Autowired  static Circle circle;
	
	
	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.stackroute");
		context.refresh();
		
		//get the circleDAO from context
		circleDAO =  (CircleDAO) context.getBean("circleDAO");
		
		//get the circle from context
		
		circle = (Circle)context.getBean("circle");
		
	}
	
	@Test
	public void createCircleTestCase()
	{
		circle.setAdminID("somsubhra");
		circle.setId("circleCI");
		circle.setName("circleCI");
		boolean flag =  circleDAO.save(circle);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createCircleTestCase",true,flag);
		
	}
	
	
	//@Test
	public void updateUserTestCase()
	{
		circle.setAdminID("Farooq");
		circle.setId("Coder_Platform");
		circle.setName("Coder_Platform");
		boolean flag =  circleDAO.update(circle);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals(" update circle test case",true,flag);
		
	}
	
	
	
	@Test
	public void getAllCirclesTestCase()
	{
		int actualSize=   circleDAO.getAllCircles().size();
		
		//will compare actual and expected
		//if actual and expected is same - TC will pass
		//if it is different - TC fail
		assertEquals(10, actualSize);
	}
	
	
	
	@Test
	public void addUserToCircleTestCae()
	{
	assertEquals(true,	  circleDAO.addUser("Dinesh", "Coder_Platofm"));
	}
	
	
	@Test
	public void getAllMyCirclesTestCase()
	{
		assertEquals(5,	  circleDAO.getMyCircles("somsubhra").size());	
	}
	
	@Test
	public void getAllCirclesBySearchStringTestCase()
	{
		assertEquals(1,	  circleDAO.getAllCircles("angular").size());	
	}
	

}

