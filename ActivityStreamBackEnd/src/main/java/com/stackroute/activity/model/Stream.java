package com.stackroute.activity.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Stream extends BaseDomain{
	
	@Id
	private String id;

	@Column(name="user_id")
	private String parentID;
	
	@Column(name="sender_id")
	private String senderID;
	
	@Column(name="posted_date")
	private Date postedDate;
	
	@Column(name="stream_type")
	private String streamType;
	
    private String tag;
	
	private String message;
	
	private String circleList;
}
