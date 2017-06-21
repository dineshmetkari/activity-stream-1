package com.stackroute.activity.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activity.dao.UserDAO;
import com.stackroute.activity.model.User;

public class UserDAOTestCase {

@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired
	static UserDAO  userDAO;
	
	@Autowired
	static User user;
	
	
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
		
		//get the userDAO from context
		userDAO =  (UserDAO) context.getBean("userDAO");
		
		//get the user from context
		
		user = (User)context.getBean("user");
		
	}
	
	@Test
	public void createUserTestCase()
	{
		user.setId("sample");
		user.setName("sample");
		user.setPassword("password");
		boolean flag =  userDAO.save(user);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createUserTestCase",true,flag);
		
	}
	
	
	//@Test
	public void updateUserTestCase()
	{
		user.setId("Dinesh");
		user.setName("Dinesh");
		user.setPassword("Dinesh@123");
		boolean flag =  userDAO.update(user);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals(" update user test case",true,flag);
		
	}
	
	@Test
	public void validateUSerTestCase()
	{
		
		boolean flag =  userDAO.validate("Som", "Som");
		
		
		assertEquals(true, flag);
		
	}
	
	
	@Test
	public void getAllUserTestCase()
	{
		int actualSize=   userDAO.list().size();
		
		//will compare actual and expected
		//if actual and expected is same - TC will pass
		//if it is different - TC fail
		assertEquals(22, actualSize);
	}
	
	
	
	
	

}
