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
import com.stackroute.activity.model.User;

@RestController
public class UserRestController {

	private static final Logger logger =
			LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	UserDAO userDAO;
	
	//-------------------Retrieve All Users--------------------------------------------------------
    
	@GetMapping(value="/user/")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userDAO.list();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
	
	//-------------------Retrieve Single User--------------------------------------------------------
    
	@GetMapping(value="/user/id/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        logger.debug("Fetching User with id " + id);
        User user = userDAO.get(id);
        if (user == null) {
            logger.debug("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }		

	
	
	
	
	 //-------------------Create a User--------------------------------------------------------
    
	@PostMapping(value = "/user/")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        logger.debug("Creating User " + user.getName());
  
        User u=userDAO.get(user.getId());
        if (u!=null) {
            logger.debug("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        userDAO.save(user);
  
       
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
	
	
	 //------------------- Update a User --------------------------------------------------------
    
	@PutMapping(value = "/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        logger.debug("Updating User " + id);
          
        User currentUser = userDAO.get(id);
          
        if (currentUser==null) {
            logger.debug("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        
        currentUser.setName(user.getName());
        currentUser.setPassword(user.getPassword());
        
        
        
          
        userDAO.update(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
	
	  //-------------------Authenticate a User--------------------------------------------------------
    
  	@PostMapping(value = "/user/authenticate")
      public ResponseEntity<User> authenticate(@RequestBody User user,HttpSession session) {
          
    
          if (userDAO.validate(user.getId(),user.getPassword())) {
        	  User u=userDAO.get(user.getName());
        	  session.setAttribute("loggedInUser", u);
        	  session.setAttribute("loggedInUserId", u.getId());
        	  logger.debug("Logged in User ID:"+session.getAttribute("loggedInUserId").toString());
              return new ResponseEntity<User>(u,HttpStatus.OK);
          }
    
          
          
    
         
          return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
      }
	
//-------------------User Logout--------------------------------------------------------
    
  	@PutMapping(value = "/user/logout")
      public ResponseEntity<User> logout(HttpSession session) {
          
  		String userId=(String)session.getAttribute("loggedInUserId");
  		
  		
  		session.invalidate();
    
      
        return new ResponseEntity<User>(HttpStatus.OK);
      }

}
