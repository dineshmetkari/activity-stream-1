package com.stackroute.activity.rest.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/api")
public class UserAuthRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserAuthRestController.class);

	@Autowired
	UserDAO userDAO;

	@Autowired
	ResourceBundleMessageSource messageSource;
	
	

	// -------------------Authenticate a User--------------------------------------------------------

	@PostMapping("/authenticate")
	public ResponseEntity<User> authenticate(@RequestBody User user, HttpSession session) {

		if (userDAO.validate(user.getId(), user.getPassword())) {
			User u = userDAO.get(user.getId());
			session.setAttribute("loggedInUser", u);
			session.setAttribute("loggedInUserId", u.getId());
			logger.debug("Logged in User ID:" + session.getAttribute("loggedInUserId").toString());

			u.setStatusMessage(messageSource.getMessage("authentication.success", null, Locale.US));
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}

		else {
			User errorUser = new User();

			errorUser.setStatusMessage(messageSource.getMessage("authentication.failure", null, Locale.US));
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}

	}

	// -------------------User Logout--------------------------------------------------------

	@PutMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request) {

		HttpSession existingSession=request.getSession(false);
		try {
		String userId = (String) existingSession.getAttribute("loggedInUserId");
		System.out.println("userId" + userId);
		//User user = new User();

		

			existingSession.invalidate();
			//user.setStatusMessage(messageSource.getMessage("user.logout", null, Locale.US));

			return new ResponseEntity<String>(messageSource.getMessage("user.logout", null, Locale.US), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

}
