package com.example.nationalscholarship.nationalscholarship.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.nationalscholarship.nationalscholarship.model.Scholarship;

@Repository
public class ScholarshipDao {

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
	public Scholarship saveScholarship(Scholarship scholarship){
		Session session= this.getSession();
		session.save(scholarship);
		return scholarship;
	}
	
	@Transactional
	public List<Scholarship> getAllScholarships(){
		Session session= this.getSession();
		return session.createCriteria(Scholarship.class).list();	
	}
	
	@Transactional
	public Scholarship getScholarshipByApplicationId(int applicationId){
		Session session= this.getSession();
		Scholarship scholarship = new Scholarship();
		scholarship = (Scholarship)session.get(Scholarship.class,applicationId);
		if(scholarship!= null){
	    return scholarship;
		}
		return null;
	}
	
	@Transactional
	public void deleteScholarship(int applicationId){
		Session session= this.getSession();
		Scholarship scholarship = new Scholarship();
		scholarship = (Scholarship)session.get(Scholarship.class,applicationId);
		if(scholarship!= null){
	    session.delete(scholarship);
		}
	}
	
	@Transactional
	public void updateScholarship(Scholarship scholarship){
		Session session= this.getSession();
		session.update(scholarship);
	}
}