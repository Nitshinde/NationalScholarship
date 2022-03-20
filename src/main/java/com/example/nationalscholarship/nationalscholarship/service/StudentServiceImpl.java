package com.example.nationalscholarship.nationalscholarship.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nationalscholarship.nationalscholarship.dao.StudentDao;
import com.example.nationalscholarship.nationalscholarship.model.Institute;
import com.example.nationalscholarship.nationalscholarship.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	
	@Override
	public List<Student> getStudents(List<String> message, List<String> errMsg) {
		List<Student> allStudentList = studentDao.getAllStudents();
		if(allStudentList != null && !allStudentList.isEmpty()) {
		message.add("Students found!");
		return allStudentList;
		} else {
		errMsg.add("Students not found!");
		return allStudentList;
		}
	}

	@Override
	public Student getStudentById(int id, List<String> message, List<String> errMsg) {
		Student student = studentDao.getStudentById(id);
		if(student != null && !student.toString().isEmpty()) {
			message.add("Required Student found!");
			return student;
			} else {
			errMsg.add("Required Student not found!");
			return student;
			}
	}

	@Override
	public Student saveStudent(Student student, List<String> message, List<String> errMsg) {
		Student savedStudent = studentDao.saveStudent(student);
		if(savedStudent != null && !savedStudent.toString().isEmpty()) {
			message.add("Student saved!");
			return savedStudent;
			} else {
			errMsg.add("Student not saved!");
			return savedStudent;
			}
	}

	@Override
	public Student updateStudent(Student student, List<String> message, List<String> errMsg) {
		try {
			studentDao.updateStudent(student);
			message.add("Student updated!");
		} catch ( Exception e) {
			errMsg.add("Student not updated!");
		}
		return null;
	}

	@Override
	public void deleteStudent(int id, List<String> message, List<String> errMsg) {		
		try {
			studentDao.deleteStudent(id);
			message.add("Student deleted!");
		} catch ( Exception e) {
			errMsg.add("Student not deleted!");
		}
	}

	@Override
	public boolean checkStudentAlreadyRegistred(String aadharNo, List<String> message, List<String> errMsg) {
		Session session = studentDao.getSession();
		List<String> aadharNoList = new ArrayList<>();
		String qryStr = "SELECT s.aadharNo FROM Student s WHERE s.aadharNo =:aadharNo";
		Query hql = session.createQuery(qryStr);
		hql.setParameter("aadharNo", aadharNo);
		hql.setMaxResults(1);
		aadharNoList = hql.list();
		if(aadharNoList != null && !aadharNoList.isEmpty()) {
			errMsg.add("Student With This AadharNo is Already Registred");
			return true;
		} else {
			return false;
		}		
	}

	@Override
	public void studentLogin(String userName, String password, List<String> message, List<String> errMsg) {
		Session session = studentDao.getSession();
		List<Institute> institutes = new ArrayList<>();
		String qryStr = "SELECT s FROM Student s WHERE s.aadharNo =:userName AND s.password =:password";
		Query hql = session.createQuery(qryStr);
		hql.setParameter("userName", userName);
		hql.setParameter("password", password);
		hql.setMaxResults(1);
		institutes = hql.list();
		if(institutes != null && !institutes.isEmpty()) {
					message.add("Logged In Successfully!");
		} else {
			errMsg.add("Wrong Username Or Password, Please Check Username or Password");
		}	
	}
}
