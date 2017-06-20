package com.stackroute.activity.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activity.dao.CircleDAO;
import com.stackroute.activity.dao.StreamDAO;
import com.stackroute.activity.dto.StreamAndStreamCircle;
import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.Stream;
import com.stackroute.activity.model.StreamCircle;
import com.stackroute.activity.model.UserCircle;
import com.stackroute.activity.model.UserTag;

@Repository("streamDAO")
@Transactional
public class StreamDAOImpl implements StreamDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired  private CircleDAO circleDAO;
	
	private static int pageSize = 8;
	
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
		
			System.out.println("inside sendMessageToCircle");
			stream.setCurrentDate();
			stream.setId((int)( Math.random()*1000000));
			getCurrentSession().save(stream);
			StreamCircle streamCircle = new StreamCircle();
			streamCircle.setId((int)( Math.random()*1000000));
			streamCircle.setStreamID(stream.getId());
			System.out.println("1");
			if(getCircleByName(circleName)==null)
			{
				System.out.println("2");
				return false;
			}
			streamCircle.setCircleID(getCircleByName(circleName).getId());
			getCurrentSession().save(streamCircle);
			System.out.println("3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("4");
			return false;
		}
		System.out.println("5");
		return true;
	}

	public boolean sendMessageToUser(String receiverID, Stream stream) {
		try {
			stream.setCurrentDate();
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

	/*@SuppressWarnings("unchecked")
	public List<Stream> getMessagesFromCircle(String circleID) {
		
		return getCurrentSession().createQuery("from Stream where id in (select streamID from StreamCircle where circleID=?)")
		.setString(0, circleID).list();

	
	}*/
	
	public List<Stream> getMessagesFromCircle(String circleID,int pageNumber) {
		
		Query query= getCurrentSession().createQuery("from Stream where id in (select streamID from StreamCircle where circleID=?) order by postedDate desc").setString(0, circleID);
		query.setString(0, circleID);
		query.setFirstResult(pageSize * (pageNumber - 1));
		query.setMaxResults(pageSize);
		
		
		return query.list();

	
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public List<Stream> getMessagesFromUserHome(String userId,String otherUserId,int pageNumber) {
		
		return getCurrentSession().createQuery("from Stream where (receiverID=? and senderID=?) or (receiverID=? and senderID=?) order by postedDate desc")
		.setString(0, userId)
		.setString(1, otherUserId)
		.setString(2, otherUserId)
		.setString(3, userId)
		.setFirstResult(pageSize*(pageNumber-1))
		.setMaxResults(pageSize)
		.list();

	
	}

	public List<Stream> getMessages(String userID,int pageNumber) {
		
		List<String> myCircles=  circleDAO.getMyCircles(userID);
		List<Stream> allStreams = new ArrayList<Stream>();
		List<Stream> circleStream;
		for( String circleName : myCircles)
		{
			circleStream = getMessagesFromCircle(circleName,pageNumber);
			if(circleStream!=null)
			{
				allStreams.addAll(circleStream);
			}
			
		}
		
		return allStreams;
	}

	
	public List<String> listTags(){
		return getCurrentSession().createQuery("select s.tag from Stream s").list();
	}
	
	
	public List<Stream> showMessagesWithTag(String tag,int pageNumber){
		//return getCurrentSession().createQuery("select s.senderID,s.postedDate,s.streamType,s.tag,s.message,s.receiverID,sc.circleID from Stream s inner join s.StreamCircle sc where s.id=sc.streamID").list();
		
		return getCurrentSession().createSQLQuery("(select a.sender_id as senderID,a.posted_date as postedDate,a.stream_type as streamType,a.tag as tag,a.message as message,a.receiver_id as receiverID,b.circle_id as circleID "
				+"from stream a join stream_circle b"
				+" where a.tag like '%"+tag+"%' and a.receiver_id is null and"
				+" a.id=b.stream_id)"
				+" union"
				+" (select a.sender_id,a.posted_date,a.stream_type,a.tag,a.message,a.receiver_id,null"
				+" from stream a"
				+" where receiver_id is not null and a.tag like '%"+tag+"%') order by posteddate desc")
				.addScalar("senderID",StandardBasicTypes.STRING)
				.addScalar("postedDate",StandardBasicTypes.TIMESTAMP)
				.addScalar("streamType",StandardBasicTypes.STRING)
				.addScalar("tag",StandardBasicTypes.STRING)
				.addScalar("message",StandardBasicTypes.STRING)
				.addScalar("receiverID",StandardBasicTypes.STRING)
				.addScalar("circleID",StandardBasicTypes.STRING)
				.setResultTransformer(Transformers.aliasToBean(StreamAndStreamCircle.class))
				.setFirstResult(pageSize * (pageNumber - 1))
				.setMaxResults(pageSize)
				.list();
	}
	
	

	
public boolean subscribeUserToTag(String userID, String tag) {
		
		UserTag userTag = new UserTag();
		userTag.setId((int)(Math.random()*100000));
		userTag.setTag(tag);
		userTag.setUserID(userID);
		
		try {
			getCurrentSession().save(userTag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
		
	
		return true;
	}


public boolean unsubscribeUserToTag(String userID, String tag) {
	UserTag userTag=getUserTag(userID, tag);
	try {
		getCurrentSession().delete(userTag);
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	
	return true;
}

public UserTag getUserTag(String userID, String tag) {
	return (UserTag) getCurrentSession().createQuery("from UserTag where userID= ? and tag= ?")
			.setString(0, userID)
			.setString(1, tag)
			.uniqueResult();
}


@SuppressWarnings("unchecked")
public List<String> listMyTags(String userID) {
	return getCurrentSession().createQuery("select tag from UserTag where userID= ?")
			.setString(0, userID)
			.list();
}

	
}
