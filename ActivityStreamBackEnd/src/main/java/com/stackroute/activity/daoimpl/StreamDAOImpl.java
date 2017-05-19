package com.stackroute.activity.daoimpl;

import java.util.List;
import java.util.SortedMap;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activity.dao.StreamDAO;
import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.Stream;

@Repository("streamDAO")
@Transactional
public class StreamDAOImpl implements StreamDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public StreamDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public boolean save(Stream stream) {
		try {
			getCurrentSession().save(stream);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Stream stream) {
		try {
			getCurrentSession().update(stream);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Stream stream) {
		try {
			getCurrentSession().delete(stream);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<Stream> list() {
		return getCurrentSession().createQuery("from Stream").list();
	}

	

	public Stream get(String id) {
		return (Stream) getCurrentSession().load(Stream.class, id);
			
	}

	public SortedMap<Long, Stream> getMessages(List<Circle> circles) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean sendMessage(Circle circle) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean sendMessage(String userID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean sendMessage(List<Circle> circles) {
		// TODO Auto-generated method stub
		return false;
	}

}

