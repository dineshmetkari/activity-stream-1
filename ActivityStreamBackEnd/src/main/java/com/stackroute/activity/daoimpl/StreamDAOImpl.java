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
		
			stream.setCurrentDate();
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

	@SuppressWarnings("unchecked")
	public List<Stream> getMessagesFromCircle(String circleID) {
		
		return getCurrentSession().createQuery("from Stream where id in (select streamID from StreamCircle where circleID=?)")
		.setString(0, circleID).list();

	
	}
	
	@SuppressWarnings("unchecked")
	public List<Stream> getMessagesFromUserHome(String userId,String otherUserId) {
		
		return getCurrentSession().createQuery("from UserStream where (userID=? and senderID=?) or (userID=? and senderID=?)")
		.setString(0, userId)
		.setString(1, otherUserId)
		.setString(2, otherUserId)
		.setString(3, userId)
		.list();

	
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

	
	public List<String> listTags(){
		return getCurrentSession().createQuery("select s.tag from Stream s").list();
	}
	
	
	public List<Stream> showMessagesWithTag(String tag){
		//return getCurrentSession().createQuery("select s.senderID,s.postedDate,s.streamType,s.tag,s.message,s.receiverID,sc.circleID from Stream s inner join s.StreamCircle sc where s.id=sc.streamID").list();
		
		return getCurrentSession().createSQLQuery("select a.sender_id as senderID,a.posted_date as postedDate,a.stream_type as streamType,a.tag as tag,a.message as message,a.receiver_id as receiverID,b.circle_id as circleID "
				+"from stream a join stream_circle b"
				+" where a.tag like '%"+tag+"%' and a.receiver_id is null and"
				+" a.id=b.stream_id"
				+" union"
				+" select a.sender_id,a.posted_date,a.stream_type,a.tag,a.message,a.receiver_id,null"
				+" from stream a"
				+" where receiver_id is not null and a.tag like '%"+tag+"%'")
				.addScalar("senderID",StandardBasicTypes.STRING)
				.addScalar("postedDate",StandardBasicTypes.TIMESTAMP)
				.addScalar("streamType",StandardBasicTypes.STRING)
				.addScalar("tag",StandardBasicTypes.STRING)
				.addScalar("message",StandardBasicTypes.STRING)
				.addScalar("receiverID",StandardBasicTypes.STRING)
				.addScalar("circleID",StandardBasicTypes.STRING)
				.setResultTransformer(Transformers.aliasToBean(StreamAndStreamCircle.class))
				.list();
	}
	
	/*select a.sender_id,a.posted_date,a.stream_type,a.tag,a.message,a.receiver_id,b.circle_id
	from stream a join stream_circle b
	where a.tag="angular" and a.receiver_id is null and
	a.id=b.stream_id*/


	
}
