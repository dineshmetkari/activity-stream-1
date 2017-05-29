package com.stackroute.activity.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name="user_home")
@Entity
@Component
public class UserStream {

		@Id
	 	private int id;
	 	
	 	@Column(name="user_id")
	 	private String userID;
	 	
	 	@Column(name="sender_id")
	 	private String senderID;
	 
	 	
	 	@Column(name="circle_id")
	 	private String circleID;
	 
	 	
	 	@Column(name="stream_type")
	 	private String streamType;
	 	
	 	private String tag;
	 	
	 	private String message;
	 	
	 	@Column(name="posted_date")
	 	private Date postedDate;
	 
	 	public String getUserID() {
	 		return userID;
	 	}
	 
	 	public void setUserID(String userID) {
	 		this.userID = userID;
	 	}
	 
	 	public String getSenderID() {
	 		return senderID;
	 	}
	 
	 	public void setSenderID(String senderID) {
	 		this.senderID = senderID;
	 	}
	 
	 	public String getCircleID() {
	 		return circleID;
	 	}
	 
	 	public void setCircleID(String circleID) {
	 		this.circleID = circleID;
	 	}
	 
	 	public String getStreamType() {
	 		return streamType;
	 	}
	 
	 	public void setStreamType(String streamType) {
	 		this.streamType = streamType;
	 	}
	 
	 	public String getTag() {
	 		return tag;
	 	}
	 
	 	public void setTag(String tag) {
	 		this.tag = tag;
	 	}
	 
	 	public String getMessage() {
	 		return message;
	 	}
	 
	 	public void setMessage(String message) {
	 		this.message = message;
	 	}
	 
	 	public Date getPostedDate() {
	 		return postedDate;
	 	}
	 
	 	public void setPostedDate(Date postedDate) {
	 		this.postedDate = postedDate;
	 	}
	 
	 
	
}
