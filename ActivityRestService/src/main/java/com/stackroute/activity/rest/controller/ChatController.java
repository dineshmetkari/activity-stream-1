package com.stackroute.activity.rest.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activity.dao.StreamDAO;
import com.stackroute.activity.model.Stream;

@RestController
public class ChatController {

	@Autowired
	StreamDAO streamDAO;
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	
	
	@MessageMapping("/postToCircle/{circleName}")
	public Stream sendMessageToCircle(Stream stream,@DestinationVariable("circleName") String circleName){
		stream.setCurrentDate();
		
		simpMessagingTemplate.convertAndSend("/topic/circle/"+circleName,stream);
		System.out.println("circleName"+circleName);
		streamDAO.sendMessageToCircle(circleName, stream);
		return stream;
	}
	
	@MessageMapping("/postToUser")
	public Stream sendMessageToUser(Stream stream){
		String userId=stream.getReceiverID();
		
		simpMessagingTemplate.convertAndSend("/topic/user/"+userId,stream);
		streamDAO.sendMessageToUser(userId, stream);
		
		return stream;
	}
}
