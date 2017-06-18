package com.stackroute.activity.rest.controller;

import java.util.List;
import java.util.Locale;
import java.util.SortedMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activity.dao.StreamDAO;
import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.Stream;
import com.stackroute.activity.model.UserCircle;
import com.stackroute.activity.model.UserTag;

@RestController
@RequestMapping(value = "/api/stream")
public class StreamRestController {

	@Autowired
	StreamDAO streamDAO;

	@Autowired
	UserTag userTag;

	@Autowired
	ResourceBundleMessageSource messageSource;

	// ---------------------Send Message to Circle---------------------------------
	@PostMapping("/sendMessageToCircle/{circleName}")
	public ResponseEntity<Stream> sendMessageToCircle(@PathVariable("circleName") String circleName,
			@RequestBody Stream stream) {
		Boolean sendStatus = streamDAO.sendMessageToCircle(circleName, stream);
		if (sendStatus) {
			
			stream.setStatusMessage(messageSource.getMessage("send.message.circle.success", null, Locale.US));
			return new ResponseEntity<Stream>(HttpStatus.OK);
		} else {
			
			stream.setStatusMessage(messageSource.getMessage("send.message.circle.failure", null, Locale.US));
			return new ResponseEntity<Stream>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// -------------------Send Message to Users-------------------------------------
	@PostMapping("/sendMessageToUser")
	public ResponseEntity<Stream> sendMessageToUser(@RequestBody Stream stream) {

		String userId = stream.getReceiverID();
		Boolean sendStatus = streamDAO.sendMessageToUser(userId, stream);
		if (sendStatus) {
			
			stream.setStatusMessage(
					messageSource.getMessage("send.message.user.success", new String[] { userId }, Locale.US));
			return new ResponseEntity<Stream>(HttpStatus.OK);
		} else {
			
			stream.setStatusMessage(
					messageSource.getMessage("send.message.user.failure", new String[] { userId }, Locale.US));
			return new ResponseEntity<Stream>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ---------------------Get Messages by User----------------------------------
	@GetMapping("/getMessagesByUser/{userId}/{otherUserId}/{pageNumber}")
	public ResponseEntity<List<Stream>> getMessagesByUser(@PathVariable("userId") String userId,
			@PathVariable("otherUserId") String otherUserId, @PathVariable("pageNumber") int pageNumber) {

		return new ResponseEntity<List<Stream>>(streamDAO.getMessagesFromUserHome(userId, otherUserId, pageNumber),
				HttpStatus.OK);

	}

	// ---------------------Get Messages by Circle--------------------------------
	@GetMapping("/getMessagesByCircle/{circleId}/{pageNumber}")
	public ResponseEntity<List<Stream>> getMessagesByCircle(@PathVariable("circleId") String circleId,
			@PathVariable("pageNumber") int pageNumber) {

		return new ResponseEntity<List<Stream>>(streamDAO.getMessagesFromCircle(circleId, pageNumber), HttpStatus.OK);

	}

	// ---------------------List All Tags--------------------------------
	@GetMapping("/listAllTags")
	public ResponseEntity<List<String>> listAllTags() {

		return new ResponseEntity<List<String>>(streamDAO.listTags(), HttpStatus.OK);

	}

	// ---------------------Get Messages by Tag--------------------------------
	@GetMapping("/showMessagesWithTag/{tag}/{pageNumber}")
	public ResponseEntity<List<Stream>> showMessagesWithTag(@PathVariable("tag") String tag,
			@PathVariable("pageNumber") int pageNumber) {

		return new ResponseEntity<List<Stream>>(streamDAO.showMessagesWithTag(tag, pageNumber), HttpStatus.OK);

	}

	/*----------------------Subscribe user to stream with a specific tag------------------------------------------------------------*/

	@PutMapping("/subscribe/{userId}/{tag}")
	public ResponseEntity<UserTag> subscribeUserToTag(@PathVariable("userId") String userId,
			@PathVariable("tag") String tag) {

		boolean status = streamDAO.subscribeUserToTag(userId, tag);
		if (status == false) {
			
			userTag.setStatusMessage(
					messageSource.getMessage("subscribe.user.tag.failure", new String[] { userId, tag }, Locale.US));
			return new ResponseEntity<UserTag>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			
			userTag.setStatusMessage(
					messageSource.getMessage("subscribe.user.tag.success", new String[] { userId, tag }, Locale.US));
			return new ResponseEntity<UserTag>(HttpStatus.OK);
		}

	}

	/*----------------------Unsubscribe user to stream with a specific tag------------------------------------------------------------*/

	@PutMapping("/unsubscribe/{userId}/{tag}")
	public ResponseEntity<UserTag> unsubscribeUserToTag(@PathVariable("userId") String userId,
			@PathVariable("tag") String tag) {

		boolean status = streamDAO.unsubscribeUserToTag(userId, tag);
		if (status == false) {
			
			userTag.setStatusMessage(
					messageSource.getMessage("unsubscribe.user.tag.failure", new String[] { tag }, Locale.US));
			return new ResponseEntity<UserTag>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			
			userTag.setStatusMessage(messageSource.getMessage("unsubscribe.user.tag.success", null, Locale.US));
			return new ResponseEntity<UserTag>(HttpStatus.OK);
		}

	}

	// -----------------------Retrieve tags subscribed by a specific user--------------------------------
	@GetMapping("/tags/search/user/{userId}")
	public ResponseEntity<List<String>> getMyTags(@PathVariable("userId") String userId) {

		return new ResponseEntity<List<String>>(streamDAO.listMyTags(userId), HttpStatus.OK);

	}
}
