package com.stackroute.activity.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activity.model.Circle;

@RestController
public class CircleRestController {
	
	@PostMapping("/circle/create")
	public ResponseEntity<boolean> createCircle(Circle circle){
		
	}
	
	@PutMapping("/circle/add/{userId}/{circleId}")
	public ResponseEntity<boolean> addUser(String UserId, String CircleId){
		
	}
	
	@PutMapping("/circle/remove/{userId}/{circleId}")
	public ResponseEntity<boolean> removeUser(String UserId, String CircleId){
		
	}
	
	@GetMapping("/circle")
	public ResponseEntity<List<Circle>> getAllCircles(){
		
	}
	
	@GetMapping("/circle/search/{userId}")
	public ResponseEntity<List<Circle>> getMyCircles(String UserId){
		
		
	}
	
	@GetMapping("/circle/search/{searchString}")
	public ResponseEntity<List<Circle>> getAllCircles(String searchString){
		
	}

}
