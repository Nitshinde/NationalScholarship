package com.example.nationalscholarship.nationalscholarship.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="student")
public class StudentRepository {
	
	@Id
	@Column(name="studentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int studentId;
	
	@Column(name="name")
	String name;
	
	@Column(name="mobileNo")
	String mobileNo;
	
	@Column(name="email")
	String email;
	
	@Column(name="address")
	String address;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
