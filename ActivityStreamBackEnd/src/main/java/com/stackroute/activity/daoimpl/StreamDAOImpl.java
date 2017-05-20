package com.stackroute.activity.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activity.dao.CircleDAO;
import com.stackroute.activity.dao.StreamDAO;
import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.Stream;
import com.stackroute.activity.model.StreamCircle;

@Repository("streamDAO")
@Transactional
public class StreamDAOImpl implements StreamDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired  private CircleDAO circleDAO;
	
	public StreamDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public List<Stream> getMessages(List<String> circleNames) {
		// TODO Auto-generated method stub
		return null;
	}

	private Circle getCircleByName(String circleName)
	{
		return (Circle) getCurrentSession().createCriteria(Circle.class)
		 	.add(Restrictions.eq("name", circleName)).uniqueResult();
	}

	public boolean sendMessageToCircle(String circleName, Stream stream) {
		try {
			
			stream.setId((int)( Math.random()*1000000));
			getCurrentSession().save(stream);
			StreamCircle streamCircle = new StreamCircle();
			streamCircle.setId((int)( Math.random()*1000000));
			streamCircle.setStreamID(stream.getId());
			if(getCircleByName(circleName)==null)
			{
				return false;
			}
			streamCircle.setCircleID(getCircleByName(circleName).getId());
			getCurrentSession().save(streamCircle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean sendMessageToUser(String receiverID, Stream stream) {
		try {
			stream.setReceiverID(receiverID);
			stream.setId((int)(Math.random()*10000));
			getCurrentSession().save(stream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean sendMessageToCircles(List<String> circleNames, Stream stream) {
		try {
			for(String circleName : circleNames)
			{
				sendMessageToCircle(circleName,stream);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

		
	/*private int getStreamByCircleID(String circleID)
	{
		StreamCircle streamCircle = (StreamCircle) getCurrentSession().createCriteria(StreamCircle.class)
			.add(Restrictions.eq("circleID", circleID)).uniqueResult();
		if(streamCircle==null)
		{
			return -1;
		}
		return streamCircle.getStreamID();
	}
	*/

	@SuppressWarnings("unchecked")
	public List<Stream> getMessagesFromCircle(String circleID) {
		
		return getCurrentSession().createQuery("from Stream where id in (select streamID from StreamCircle where circleID=?)")
		.setString(0, circleID).list();

	
	}

	public List<Stream> getMessages(String userID) {
		
		List<String> myCircles=  circleDAO.getMyCircles(userID);
		List<Stream> allStreams = new ArrayList<Stream>();
		List<Stream> circleStream;
		for( String circleName : myCircles)
		{
			circleStream = getMessagesFromCircle(circleName);
			if(circleStream!=null)
			{
				allStreams.addAll(circleStream);
			}
			
		}
		
		return allStreams;
	}


	
}
