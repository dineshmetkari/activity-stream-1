package com.stackroute.activity.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activity.dao.UserHomeDAO;
import com.stackroute.activity.model.UserStream;

@Transactional
@Repository("userHomeDAO")
public class UserHomeDAOImpl implements UserHomeDAO{

	@Autowired
	private SessionFactory sessionFactory;
	 	
		public UserHomeDAOImpl(SessionFactory sessionFactory)
	 	{
	 		this.sessionFactory=sessionFactory;
	 	}
	 	
	 	private Session getCurrentSession()
	 	{
	 		return sessionFactory.getCurrentSession();
	 	}
	 
	 	@SuppressWarnings("unchecked")
	 	public List<UserStream> getMyInbox(String userID) {
	 		return getCurrentSession().createCriteria(UserStream.class)
	 		.add(Restrictions.eq("userID", userID)).list();
	 	}
	 
	 	@SuppressWarnings("unchecked")
	 	public List<UserStream> getMyCircleMessages(String circleID) {
	 		return getCurrentSession().createCriteria(UserStream.class)
	 				.add(Restrictions.eq("circleID", circleID)).list();
	 	}
	
}
