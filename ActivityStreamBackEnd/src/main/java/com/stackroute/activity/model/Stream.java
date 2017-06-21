package com.stackroute.activity.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name ="stream")
public class Stream extends BaseDomain{
	
	@Id
	private int id;

	@Column(name="parent_id")
	private String parentID;
	
	@Column(name="sender_id")
	private String senderID;
	
	
	@Column(name="receiver_id")
	private String receiverID;
	
	public String getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}

	/*
	@Transient*/
	@Column(name="posted_date")
	private Timestamp postedDate;
	
	@Column(name="stream_type")
	private String streamType;
	
    private String tag;
	
	private String message;
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public Timestamp getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Timestamp postedDate) {
		this.postedDate = postedDate;
	}

	public void setCurrentDate()
	{
		this.postedDate= new Timestamp(System.currentTimeMillis());
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

}
