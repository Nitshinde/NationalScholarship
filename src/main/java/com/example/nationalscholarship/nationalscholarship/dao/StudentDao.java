package com.example.nationalscholarship.nationalscholarship.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.nationalscholarship.nationalscholarship.model.Student;

@Repository
public class StudentDao {

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
	public Student saveStudent(Student student){
		Session session= this.getSession();
		session.save(student);
		return student;
	}
	
	@Transactional
	public List<Student> getAllStudents(){
		Session session= this.getSession();
		return session.createCriteria(Student.class).list();	
	}
	
	@Transactional
	public Student getStudentById(int id){
		Session session= this.getSession();
		Student student = new Student();
		student = (Student)session.get(Student.class,id);
		if(student!= null){
	    return student;
		}
		return null;
	}
	
	@Transactional
	public void deleteStudent(int id){
		Session session= this.getSession();
		Student student = new Student();
		student = (Student)session.get(Student.class,id);
		if(student!= null){
	    session.delete(student);
		}
	}
	
	@Transactional
	public void updateStudent(Student student){
		Session session= this.getSession();
		session.update(student);
	}
}