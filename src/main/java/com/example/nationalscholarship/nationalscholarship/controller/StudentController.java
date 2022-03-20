package com.example.nationalscholarship.nationalscholarship.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.nationalscholarship.nationalscholarship.dao.StudentDao;
import com.example.nationalscholarship.nationalscholarship.model.Student;
import com.example.nationalscholarship.nationalscholarship.response.ResponseViewModel;
import com.example.nationalscholarship.nationalscholarship.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	
	@GetMapping("/")
	public String home() {
		return "Get";
	}
	
	@GetMapping("/getStudentInfo")
	public ResponseViewModel getStudentInfo() {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		List<Student> allStudentList = studentService.getStudents(message, errMsg);
		if(errMsg == null || errMsg.isEmpty()) {
			responseViewModel.setError(false);
			responseViewModel.setErrorCode(0);
			responseViewModel.setMessage(message.toString());
			responseViewModel.setResult(allStudentList);
		} else {
			responseViewModel.setError(true);
			responseViewModel.setErrorCode(1);
			responseViewModel.setMessage(errMsg.toString());
			responseViewModel.setResult(null);
		}
		return responseViewModel;
	}
	
	@GetMapping("/getStudentInfoById/{id}")
	public ResponseViewModel getStudentInfoById(@PathVariable int id) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		Student student = studentService.getStudentById(id, message, errMsg);
		if(errMsg == null || errMsg.isEmpty()) {
			responseViewModel.setError(false);
			responseViewModel.setErrorCode(0);
			responseViewModel.setMessage(message.toString());
			responseViewModel.setResult(student);
		} else {
			responseViewModel.setError(true);
			responseViewModel.setErrorCode(1);
			responseViewModel.setMessage(errMsg.toString());
			responseViewModel.setResult(null);
		}
		return responseViewModel;
	}
	
	@PostMapping("/saveStudentInfo")
	public ResponseViewModel saveStudentInfo(@RequestBody Student student) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		Student savedStudent = new Student();
		String aadharNo = "";
		boolean isAlreadyRegistred = false;
		if(student != null && student.getAadharNo() != null && student.getAadharNo() != "") {
		aadharNo = student.getAadharNo();
		isAlreadyRegistred = studentService.checkStudentAlreadyRegistred(aadharNo, message, errMsg);
		} else {
			errMsg.add("Please Provide Aadhar No.");
		}
		if(!isAlreadyRegistred) {
		savedStudent = studentService.saveStudent(student, message, errMsg);
		}
		
		if(errMsg == null || errMsg.isEmpty()) {
			responseViewModel.setError(false);
			responseViewModel.setErrorCode(0);
			responseViewModel.setMessage(message.toString());
			responseViewModel.setResult(savedStudent);
		} else {
			responseViewModel.setError(true);
			responseViewModel.setErrorCode(1);
			responseViewModel.setMessage(errMsg.toString());
			responseViewModel.setResult(null);
		}
		return responseViewModel;
	}
	
	@PostMapping("/updateStudentInfo")
	public ResponseViewModel updateStudentInfo(@RequestBody Student student) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		Student updatedStudent = studentService.updateStudent(student, message, errMsg);
				if(errMsg == null || errMsg.isEmpty()) {
					responseViewModel.setError(false);
					responseViewModel.setErrorCode(0);
					responseViewModel.setMessage(message.toString());
					responseViewModel.setResult(student);
				} else {
					responseViewModel.setError(true);
					responseViewModel.setErrorCode(1);
					responseViewModel.setMessage(errMsg.toString());
					responseViewModel.setResult(null);
				}
				return responseViewModel;
	}
	
	@DeleteMapping("/deleteStudentById/{id}")
	public ResponseViewModel deleteStudentById(@PathVariable int id) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		studentService.deleteStudent(id, message, errMsg);
		if(errMsg == null || errMsg.isEmpty()) {
			responseViewModel.setError(false);
			responseViewModel.setErrorCode(0);
			responseViewModel.setMessage(message.toString());
			responseViewModel.setResult(null);
		} else {
			responseViewModel.setError(true);
			responseViewModel.setErrorCode(1);
			responseViewModel.setMessage(errMsg.toString());
			responseViewModel.setResult(null);
		}
		return responseViewModel;
	}
	
	@PostMapping("/studentLogin")
	public ResponseViewModel studentLogin(@RequestBody String userName, String password) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		studentService.studentLogin(userName, password, message, errMsg);
				if(errMsg == null || errMsg.isEmpty()) {
					responseViewModel.setError(false);
					responseViewModel.setErrorCode(0);
					responseViewModel.setMessage(message.toString());
					responseViewModel.setResult(null);
				} else {
					responseViewModel.setError(true);
					responseViewModel.setErrorCode(1);
					responseViewModel.setMessage(errMsg.toString());
					responseViewModel.setResult(null);
				}
				return responseViewModel;
	}
}
