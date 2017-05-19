package com.stackroute.activity.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activity.dao.CircleDAO;
import com.stackroute.activity.model.Circle;

@RestController
public class CircleRestController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(CircleRestController.class);

	
	@Autowired
	CircleDAO circleDAO;
	
	
	
	@PostMapping("/circle/create")
	public ResponseEntity<Void> createCircle(@RequestBody Circle circle){
		
		Circle c=circleDAO.get(circle.getId());
		if (c!=null) {
			
            logger.debug("A circle with name " + circle.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
		
		circleDAO.save(circle);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/circle/add/{userId}/{circleId}")
	public ResponseEntity<Void> addUser(@PathVariable("userId") String userId, @PathVariable("circleId") String circleId){
		
		boolean status=circleDAO.addUser(userId, circleId);
		if(status==false){
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		else
			return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/circle/remove/{userId}/{circleId}")
	public ResponseEntity<Void> removeUser(@PathVariable("userId") String userId, @PathVariable("circleId") String circleId){
		
		boolean status=circleDAO.removeUser(userId, circleId);
		if(status==false){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else
			return new ResponseEntity<Void>(HttpStatus.OK);
		
		
	}
	
	//-------------------------------Retrieve all circles-------------------------------------
	@GetMapping("/circle")
	public ResponseEntity<List<Circle>> getAllCircles(){
	
		List<Circle> circles=circleDAO.getAllCircles();
		if(circles.isEmpty()){
			return new ResponseEntity<List<Circle>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Circle>>(circles, HttpStatus.OK);
	}
	
//-----------------------Retrieve circles for a specific user--------------------------------	
	@GetMapping("/circle/search/user/{userId}")
	public ResponseEntity<List<Circle>> getMyCircles(@PathVariable("userId") String userId){
		
		List<Circle> circles=circleDAO.getMyCircles(userId);
		if(circles.isEmpty()){
			return new ResponseEntity<List<Circle>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Circle>>(circles, HttpStatus.OK);
	}
	
//----------------------Retrieve circles by Search String-----------------------------------	
	@GetMapping("/circle/search/{searchString}")
	public ResponseEntity<List<Circle>> getAllCircles(@PathVariable("searchString") String searchString){
		
		List<Circle> circles=circleDAO.getAllCircles(searchString);
		
		if(circles.isEmpty()){
			return new ResponseEntity<List<Circle>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Circle>>(circles, HttpStatus.OK);
		
	}

}
