package com.example.nationalscholarship.nationalscholarship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="StudentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int studentId;
	
	@Column(name="StateOfDomicile")
	String stateOfDomicile;
	
	@Column(name="Name")
	String name;
	
	@Column(name="Gender")
	String gender;
	
	@Column(name="MobileNo")
	String mobileNo;
	
	@Column(name="Email")
	String email;
	
	@Column(name="DateOfBirth")
	String dateOfBirth;
	
	@Column(name="District")
	String district;
	
	@Column(name="InstituteCode")
	String instituteCode;
	
	@Column(name="AadharNo")
	String aadharNo;
	
	@Column(name="Password")
	String password;
	
	@Column(name="BankIfscCode")
	String bankIfscCode;
	
	@Column(name="BankAccountNo")
	String bankAccountNo;
	
	@Column(name="BankName")
	String bankName;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStateOfDomicile() {
		return stateOfDomicile;
	}

	public void setStateOfDomicile(String stateOfDomicile) {
		this.stateOfDomicile = stateOfDomicile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getInstituteCode() {
		return instituteCode;
	}

	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBankIfscCode() {
		return bankIfscCode;
	}

	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
