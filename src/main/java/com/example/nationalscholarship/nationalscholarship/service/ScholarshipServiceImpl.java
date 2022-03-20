package com.example.nationalscholarship.nationalscholarship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nationalscholarship.nationalscholarship.dao.ScholarshipDao;
import com.example.nationalscholarship.nationalscholarship.model.Scholarship;

@Service
public class ScholarshipServiceImpl implements ScholarshipService{

	@Autowired
	ScholarshipDao scholarshipDao;
	
	@Override
	public List<Scholarship> getScholarships(List<String> message, List<String> errMsg) {
		List<Scholarship> allScholarshipList = scholarshipDao.getAllScholarships();
		if(allScholarshipList != null && !allScholarshipList.isEmpty()) {
		message.add("Scholarships Application found!");
		return allScholarshipList;
		} else {
		errMsg.add("Scholarships Application not found!");
		return allScholarshipList;
		}
	}

	@Override
	public Scholarship getScholarshipByApplicationId(int applicationId, List<String> message, List<String> errMsg) {
		Scholarship scholarship = scholarshipDao.getScholarshipByApplicationId(applicationId);
		if(scholarship != null && !scholarship.toString().isEmpty()) {
			message.add("Required Scholarship Application found!");
			return scholarship;
			} else {
			errMsg.add("Required Scholarship Application not found!");
			return scholarship;
			}
	}

	@Override
	public Scholarship saveScholarship(Scholarship scholarship, List<String> message, List<String> errMsg) {
		Scholarship savedScholarship = scholarshipDao.saveScholarship(scholarship);
		if(savedScholarship != null && !savedScholarship.toString().isEmpty()) {
			message.add("Scholarship Application saved!");
			return savedScholarship;
			} else {
			errMsg.add("Scholarship Application not saved!");
			return savedScholarship;
			}
	}

	@Override
	public Scholarship updateScholarship(Scholarship scholarship, List<String> message, List<String> errMsg) {
		try {
			scholarshipDao.updateScholarship(scholarship);
			message.add("Scholarship Application updated!");
		} catch ( Exception e) {
			errMsg.add("Scholarship Application not updated!");
		}
		return null;
	}

	@Override
	public void deleteScholarship(int ApplicationId, List<String> message, List<String> errMsg) {		
		try {
			scholarshipDao.deleteScholarship(ApplicationId);
			message.add("Scholarship deleted!");
		} catch ( Exception e) {
			errMsg.add("Scholarship Application not deleted!");
		}
	}

}
