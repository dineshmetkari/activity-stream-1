package com.stackroute.activity.rest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activity.dao.UserDAO;
import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.User;

@RestController
public class UserRestController {

	private static final Logger logger =
			LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	UserDAO userDAO;
	
	//-------------------Retrieve All Users--------------------------------------------------------
    
	@GetMapping(value="/user/")
    public List<User> listAllUsers() {
        
		return userDAO.list();
        
    }
	
	//-------------------Retrieve Single User--------------------------------------------------------
    
	@GetMapping(value="/user/id/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable("id") String id) {
        logger.debug("Fetching User with id " + id);
        User user = userDAO.get(id);
        if (user == null) {
            logger.debug("User with id " + id + " not found");
            User errorUser=new User();
            errorUser.setErrorCode("404");
            errorUser.setErrorMessage("User not found");
            return errorUser;
        }
        return user;
    }		

	
	
	
	
	 //-------------------Create a User--------------------------------------------------------
    
	@PostMapping(value = "/user/")
    public User createUser(@RequestBody User user) {
        logger.debug("Creating User " + user.getName());
  
        User u=userDAO.get(user.getId());
        if (u!=null) {
            logger.debug("A User with name " + user.getName() + " already exist");
            User errorUser=new User();
            errorUser.setErrorCode("409");
            errorUser.setErrorMessage("User with the name "+user.getName()+" already exists");
            return errorUser;
        }
  
        userDAO.save(user);
        user.setErrorCode("200");
        user.setErrorMessage("User created successfully");
       
        return user;
    }
	
	
	 //------------------- Update a User --------------------------------------------------------
    
	@PutMapping(value = "/user/{id}")
    public User updateUser(@PathVariable("id") String id, @RequestBody User user) {
        logger.debug("Updating User " + id);
          
        User currentUser = userDAO.get(id);
          
        if (currentUser==null) {
            logger.debug("User with id " + id + " not found");
            User errorUser=new User();
            errorUser.setErrorCode("404");
            errorUser.setErrorMessage("User with the name "+user.getName()+" not found");
            return errorUser;
        }
  
        
        currentUser.setName(user.getName());
        currentUser.setPassword(user.getPassword());
        
        
        
          
        userDAO.update(currentUser);
        currentUser.setErrorCode("200");
        currentUser.setErrorMessage("User updated");
        return currentUser;
    }
	
	  //-------------------Authenticate a User--------------------------------------------------------
    
  	@PostMapping(value = "/user/authenticate")
      public User authenticate(@RequestBody User user,HttpSession session) {
          
    
          if (userDAO.validate(user.getId(),user.getPassword())) {
        	  User u=userDAO.get(user.getId());
        	  session.setAttribute("loggedInUser", u);
        	  session.setAttribute("loggedInUserId", u.getId());
        	  logger.debug("Logged in User ID:"+session.getAttribute("loggedInUserId").toString());
        	  u.setErrorCode("200");
        	  u.setErrorMessage("Authentication successful");
              return u;
          }
    
          else
          {
        	  User errorUser=new User();
        	  errorUser.setErrorCode("404");
        	  errorUser.setErrorMessage("Authentication failure");
        	  return errorUser;
          }
          
          
      }
	
//-------------------User Logout--------------------------------------------------------
    
  	@PutMapping(value = "/user/logout")
      public User logout(HttpSession session) {
          
  		String userId=(String)session.getAttribute("loggedInUserId");
  		
  		
  		session.invalidate();
  		
  		User user=new User();
  		user.setErrorCode("200");
  		user.setErrorMessage("User successdully logged out");
      
        return user;
      }

}
