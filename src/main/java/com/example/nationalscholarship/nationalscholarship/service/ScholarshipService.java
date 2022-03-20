package com.example.nationalscholarship.nationalscholarship.service;

import java.util.List;

import com.example.nationalscholarship.nationalscholarship.model.Scholarship;

public interface ScholarshipService {

	public List<Scholarship> getScholarships(List<String> message, List<String> errMsg);
	
	public Scholarship getScholarshipByApplicationId(int applicationId, List<String> message, List<String> errMsg);
	
	public Scholarship saveScholarship(Scholarship scholarship, List<String> message, List<String> errMsg);
	
	public Scholarship updateScholarship(Scholarship scholarship, List<String> message, List<String> errMsg);
	
	public void deleteScholarship(int applicationId, List<String> message, List<String> errMsg);
}
