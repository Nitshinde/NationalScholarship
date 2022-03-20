package com.example.nationalscholarship.nationalscholarship.service;

import java.util.List;

import com.example.nationalscholarship.nationalscholarship.model.Student;

public interface StudentService {

	public List<Student> getStudents(List<String> message, List<String> errMsg);
	
	public Student getStudentById(int id, List<String> message, List<String> errMsg);
	
	public Student saveStudent(Student student, List<String> message, List<String> errMsg);
	
	public Student updateStudent(Student student, List<String> message,
			List<String> errMsg);
	
	public void deleteStudent(int id, List<String> message,
			List<String> errMsg);
	
	public boolean checkStudentAlreadyRegistred(String aadharNo, List<String> message,
			List<String> errMsg);
	
	public void studentLogin(String userName, String password, List<String> message,
			List<String> errMsg);
}
