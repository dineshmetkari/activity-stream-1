package com.stackroute.activity.daoimpl;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activity.dao.CircleDAO;
import com.stackroute.activity.model.Circle;
import com.stackroute.activity.model.UserCircle;

@Repository("circleDAO")
@Transactional
public class CircleDAOImpl implements CircleDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CircleDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public boolean save(Circle circle) {
		try {
			getCurrentSession().save(circle);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Circle circle) {
		try {
			getCurrentSession().update(circle);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Circle circle) {
		try {
			getCurrentSession().delete(circle);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
//redundant
	public List<Circle> list() {
		return getCurrentSession().createQuery("from Circle").list();
	}

	
	public Circle get(String id) {
		return (Circle) getCurrentSession().get(Circle.class, id);
			
	}

    //timestamp to be stored
	public boolean addUser(String userID, String circleID) {
		
		UserCircle userCircle = new UserCircle();
		userCircle.setId((int)(Math.random()*100000));
		userCircle.setCircleID(circleID);
		userCircle.setUserID(userID);
		
		try {
			getCurrentSession().save(userCircle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
		
		// TODO Auto-generated method stub
		return true;
	}

	public boolean removeUser(String userID, String circleID) {
		UserCircle userCircle=  get(userID, circleID);
		try {
			getCurrentSession().delete(userCircle);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}

	public List<Circle> getAllCircles() {
		return getCurrentSession().createQuery("from Circle").list();
	}

	@SuppressWarnings("unchecked")
	public List<String> getMyCircles(String userID) {
		return getCurrentSession().createQuery("select circleID from UserCircle where userID= ?")
				.setString(0, userID)
				.list();
	}

	@SuppressWarnings("unchecked")
	public List<Circle> getAllCircles(String searchString) {
		 return getCurrentSession()
				         .createCriteria(Circle.class)
				         .add(Restrictions.like("name", "%"+searchString+"%")).list();
				
	}

	public UserCircle get(String userID, String circleID) {
		return (UserCircle) getCurrentSession().createQuery("from UserCircle where userID= ? and circleID= ?")
				.setString(0, userID)
				.setString(1, circleID)
				.uniqueResult();
	}

}

