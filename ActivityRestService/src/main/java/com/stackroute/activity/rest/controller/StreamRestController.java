package com.stackroute.activity.rest.controller;

import java.util.List;
import java.util.SortedMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activity.dao.StreamDAO;
import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.Stream;
import com.stackroute.activity.model.UserCircle;
import com.stackroute.activity.model.UserTag;

@RestController
public class StreamRestController {

	@Autowired
	StreamDAO streamDAO;
	
	@Autowired
	UserTag userTag;
	

	
//---------------------Send Message to Circle---------------------------------	
	@PostMapping("/stream/sendMessageToCircle/{circleName}")
	public Stream sendMessageToCircle(@PathVariable("circleName") String circleName,@RequestBody Stream stream)
	{
		Boolean sendStatus=streamDAO.sendMessageToCircle(circleName, stream);
		if(sendStatus)
		{
			stream.setErrorCode("200");
			stream.setErrorMessage("The message is sent successfully");
			return stream;
		}
		else
		{
			stream.setErrorCode("404");
			stream.setErrorMessage("Error!!! The message was not sent");
			return stream;
		}
		
	}
	
//---------------------Send Message to Circles---------------------------------------	
	//tried to implement sending messages to multiple circles at once, but as it is out of scope, 
	//will implement in the next version
	
	
	/*@PostMapping("/stream/sendMessageToCircles/{circleName}")
	public Stream sendMessageToCircles(@RequestBody List<String> circleNames,@RequestBody Stream stream)
	{
		Boolean sendStatus=streamDAO.sendMessageToCircles(circleNames, stream);
		
		if(sendStatus)
		{
			stream.setErrorCode("200");
			stream.setErrorMessage("The message is sent successfully");
			return stream;
		}
		else
		{
			stream.setErrorCode("404");
			stream.setErrorMessage("Error!!! The message was not sent");
			return stream;
		}
		
	}*/
	
//-------------------Send Message to Users-------------------------------------	
	@PostMapping("/stream/sendMessageToUser")
	public Stream sendMessageToUser(@RequestBody Stream stream){
		
		String userId=stream.getReceiverID();
		Boolean sendStatus=streamDAO.sendMessageToUser(userId, stream);
		if(sendStatus)
		{
			stream.setErrorCode("200");
			stream.setErrorMessage("The message is sent successfully to "+userId);
			return stream;
		}
		else
		{
			stream.setErrorCode("404");
			stream.setErrorMessage("Error!!! The message was not sent");
			return stream;
		}
	}
	

//---------------------Get Messages by User----------------------------------
	@GetMapping("/stream/getMessagesByUser/{userId}/{otherUserId}")
	public List<Stream> getMessagesByUser(@PathVariable("userId") String userId,@PathVariable("otherUserId") String otherUserId){
		
		return streamDAO.getMessagesFromUserHome(userId,otherUserId);
		
	}

	
//---------------------Get Messages by Circle--------------------------------
		@GetMapping("/stream/getMessagesByCircle/{circleId}")
		public List<Stream> getMessagesByCircle(@PathVariable("circleId") String circleId){
			
			return streamDAO.getMessagesFromCircle(circleId);
			
		}	
		
		
		//---------------------Get Messages by Circle--------------------------------
		@GetMapping("/stream/getAllTags")
		public List<String> listAllTags(){
					
			return streamDAO.listTags();
					
		}	
		
		
		//---------------------Get Messages by Circle--------------------------------
				@GetMapping("/stream/showMessagesWithTag/{tag}")
				public List<Stream> showMessagesWithTag(@PathVariable("tag") String tag){
							
					return streamDAO.showMessagesWithTag(tag);
							
				}	
				
				
		/*----------------------Subscribe user to stream with a specific tag------------------------------------------------------------*/		
	
	
				@PutMapping("/stream/subscribe/{userId}/{tag}")
				public UserTag subscribeUserToTag(@PathVariable("userId") String userId, @PathVariable("tag") String tag){
					
					boolean status=streamDAO.subscribeUserToTag(userId, tag);
					if(status==false){
						userTag.setErrorCode("409");
						userTag.setErrorMessage("User could not be subscribed to tag. Either user does not exist or he is already subscribed to the specified tag");
						
					}
					else
					{
						userTag.setErrorCode("200");
						userTag.setErrorMessage("User subscription added successfully");
						
					}
					return userTag;
				}	
				
				
				/*----------------------Unsubscribe user to stream with a specific tag------------------------------------------------------------*/		
				
				
				@PutMapping("/stream/unsubscribe/{userId}/{tag}")
				public UserTag unsubscribeUserToTag(@PathVariable("userId") String userId, @PathVariable("tag") String tag){
					
					boolean status=streamDAO.unsubscribeUserToTag(userId, tag);
					if(status==false){
						userTag.setErrorCode("409");
						userTag.setErrorMessage("User could not be unsubscribed to tag");
						
					}
					else
					{
						userTag.setErrorCode("200");
						userTag.setErrorMessage("User subscription removed successfully");
						
					}
					return userTag;
				}
	
				
				//-----------------------Retrieve tags subscribed by a specific user--------------------------------	
				@GetMapping("/tags/search/user/{userId}")
				public List<String> getMyTags(@PathVariable("userId") String userId){
					
					return streamDAO.listMyTags(userId);
					
				}
}
