package com.example.nationalscholarship.nationalscholarship.service;

import java.util.List;

import com.example.nationalscholarship.nationalscholarship.model.Institute;

public interface InstituteService {

	public List<Institute> getInstitutes(List<String> message, List<String> errMsg);
	
	public Institute getInstituteByInstituteNo(int instituteNo, List<String> message, List<String> errMsg);
	
	public Institute saveInstitute(Institute institute, List<String> message, List<String> errMsg);
	
	public Institute updateInstitute(Institute institute, List<String> message, List<String> errMsg);
	
	public void deleteInstitute(int instituteNo, List<String> message, List<String> errMsg);
	
	public boolean checkInstituteAlreadyRegistred(String institutionCode, List<String> message, List<String> errMsg);
	
	public void instituteLogin(String userName, String password, List<String> message, List<String> errMsg);
}
