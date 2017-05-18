package com.stackroute.activity.rest.controller;

import java.util.List;
import java.util.SortedMap;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/*
import com.stackroute.activity.model.Circle;

@RestController
public class StreamRestController {

	
	@GetMapping("/stream/getMessage/{userId}")
	public ResponseEntity<SortedMap<Long, Message>> getMessages(String userId){
		
	}
	
	@PostMapping("/stream/sendMessage/{circleId}")
	public ResponseEntity<boolean> sendMessage(String circleId)
	{
		
	}
	
	@PostMapping("/stream/sendMessage/{userId}")
	public ResponseEntity<boolean> sendMessage(String UserId){
		
	}
	
	@PostMapping("/stream/sendMultipleMessage")
	public ResponseEntity<boolean> sendMessage(@RequestBody List<Circle> circles){
		
	}
	
}
*/