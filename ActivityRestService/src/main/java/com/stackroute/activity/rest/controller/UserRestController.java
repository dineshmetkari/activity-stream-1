package com.stackroute.activity.rest.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activity.dao.UserDAO;
import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.User;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	ResourceBundleMessageSource messageSource;

	// -------------------Retrieve All Users--------------------------------------------------------

	@GetMapping
	public ResponseEntity<List<User>> listAllUsers() {

		return new ResponseEntity<List<User>>(userDAO.list(), HttpStatus.OK);

	}

	// -------------------Retrieve Single User--------------------------------------------------------

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		logger.debug("Fetching User with id " + id);
		User user = userDAO.get(id);
		if (user == null) {
			logger.debug("User with id " + id + " not found");
			User errorUser = new User();
			
			errorUser.setStatusMessage(messageSource.getMessage("user.not.found", null, Locale.US));
			return new ResponseEntity<User>(errorUser, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// -------------------Create a User--------------------------------------------------------

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		logger.debug("Creating User " + user.getName());

		User u = userDAO.get(user.getId());
		if (u != null) {
			logger.debug("A User with name " + user.getName() + " already exist");
			User errorUser = new User();
			
			errorUser.setStatusMessage("User with the name " + user.getName() + " already exists");
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}

		userDAO.save(user);
		
		user.setStatusMessage(messageSource.getMessage("user.create.success", null, Locale.US));

		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}

	// ------------------- Update a User--------------------------------------------------------

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
		logger.debug("Updating User " + id);

		User currentUser = userDAO.get(id);

		if (currentUser == null) {
			logger.debug("User with id " + id + " not found");
			User errorUser = new User();
			
			errorUser.setStatusMessage(messageSource.getMessage("user.update.failure", new String[] { id }, Locale.US));
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setPassword(user.getPassword());

		userDAO.update(currentUser);
		
		currentUser.setStatusMessage(messageSource.getMessage("user.update.success", new String[] { id }, Locale.US));
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}


}
