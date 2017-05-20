package com.stackroute.activity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name ="stream_circle")
public class StreamCircle {
	
	@Id
	private int id;
	
	@Column(name ="stream_id")
	private int streamID;
	@Column(name ="circle_id")
	private String circleID;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStreamID() {
		return streamID;
	}
	public void setStreamID(int streamID) {
		this.streamID = streamID;
	}
	public String getCircleID() {
		return circleID;
	}
	public void setCircleID(String circleID) {
		this.circleID = circleID;
	}

}
