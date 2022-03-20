package com.example.nationalscholarship.nationalscholarship.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.nationalscholarship.nationalscholarship.model.Institute;

@Repository
public class InstituteDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		Session session= sessionFactory.getCurrentSession();
		if(session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	@Transactional
	public Institute saveInstitute(Institute institute){
		Session session= this.getSession();
		session.save(institute);
		return institute;
	}
	
	@Transactional
	public List<Institute> getAllInstitutes(){
		Session session= this.getSession();
		return session.createCriteria(Institute.class).list();	
	}
	
	@Transactional
	public Institute getInstituteByInstituteCode(int Institutecode){
		Session session= this.getSession();
		Institute institute = new Institute();
		institute = (Institute)session.get(Institute.class,Institutecode);
		if(institute!= null){
	    return institute;
		}
		return null;
	}
	
	@Transactional
	public void deleteInstitute(int Institutecode){
		Session session= this.getSession();
		Institute institute = new Institute();
		institute = (Institute)session.get(Institute.class,Institutecode);
		if(institute!= null){
	    session.delete(institute);
		}
	}
	
	@Transactional
	public void updateInstitute(Institute institute){
		Session session= this.getSession();
		session.update(institute);
	}
}