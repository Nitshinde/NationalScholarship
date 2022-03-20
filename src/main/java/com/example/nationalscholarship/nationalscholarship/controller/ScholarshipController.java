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

import com.example.nationalscholarship.nationalscholarship.dao.ScholarshipDao;
import com.example.nationalscholarship.nationalscholarship.model.Scholarship;
import com.example.nationalscholarship.nationalscholarship.response.ResponseViewModel;
import com.example.nationalscholarship.nationalscholarship.service.ScholarshipService;

@RestController
public class ScholarshipController {

	@Autowired
	ScholarshipService  scholarshipService;
	
	
	@GetMapping("/b")
	public String home() {
		return "Get";
	}
	
	@GetMapping("/getScholarshipInfo")
	public ResponseViewModel getScholarshipInfo() {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<>();
		List<String> errMsg = new ArrayList<>();
		List<Scholarship> allScholarshipList = scholarshipService.getScholarships(message, errMsg);
		if(errMsg == null || errMsg.isEmpty()) {
			responseViewModel.setError(false);
			responseViewModel.setErrorCode(0);
			responseViewModel.setMessage(message.toString());
			responseViewModel.setResult(allScholarshipList);
		} else {
			responseViewModel.setError(true);
			responseViewModel.setErrorCode(1);
			responseViewModel.setMessage(errMsg.toString());
			responseViewModel.setResult(allScholarshipList);
		}
		return responseViewModel;
	}
	
	@GetMapping("/getScholarshipInfoByApplicationId/{applicationId}")
	public ResponseViewModel getScholarshipInfoByApplicationId(@PathVariable int applicationId) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<>();
		List<String> errMsg = new ArrayList<>();
		Scholarship scholarship = scholarshipService.getScholarshipByApplicationId(applicationId, message, errMsg);
		if(errMsg == null || errMsg.isEmpty()) {
			responseViewModel.setError(false);
			responseViewModel.setErrorCode(0);
			responseViewModel.setMessage(message.toString());
			responseViewModel.setResult(scholarship);
		} else {
			responseViewModel.setError(true);
			responseViewModel.setErrorCode(1);
			responseViewModel.setMessage(errMsg.toString());
			responseViewModel.setResult(scholarship);
		}
		return responseViewModel;
	}
	
	@PostMapping("/saveScholarshipInfo")
	public ResponseViewModel saveScholarshipInfo(@RequestBody Scholarship scholarship) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<>();
		List<String> errMsg = new ArrayList<>();
		Scholarship savedScholarship = scholarshipService.saveScholarship(scholarship, message, errMsg);
		if(errMsg == null || errMsg.isEmpty()) {
			responseViewModel.setError(false);
			responseViewModel.setErrorCode(0);
			responseViewModel.setMessage(message.toString());
			responseViewModel.setResult(scholarship);
		} else {
			responseViewModel.setError(true);
			responseViewModel.setErrorCode(1);
			responseViewModel.setMessage(errMsg.toString());
			responseViewModel.setResult(scholarship);
		}
		return responseViewModel;
	}
	
	@PostMapping("/updateScholarshipInfo")
	public ResponseViewModel updateScholarshipInfo(@RequestBody Scholarship scholarship) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<>();
		List<String> errMsg = new ArrayList<>();
		Scholarship updatedScholarship = scholarshipService.updateScholarship(scholarship, message, errMsg);
				if(errMsg == null || errMsg.isEmpty()) {
					responseViewModel.setError(false);
					responseViewModel.setErrorCode(0);
					responseViewModel.setMessage(message.toString());
					responseViewModel.setResult(scholarship);
				} else {
					responseViewModel.setError(true);
					responseViewModel.setErrorCode(1);
					responseViewModel.setMessage(errMsg.toString());
					responseViewModel.setResult(updatedScholarship);
				}
				return responseViewModel;
	}
	
	@DeleteMapping("/deleteScholarshipByApplicationId/{applicationId}")
	public ResponseViewModel deleteInstituteByInstituteCode(@PathVariable int applicationId) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<>();
		List<String> errMsg = new ArrayList<>();
		scholarshipService.deleteScholarship(applicationId, message, errMsg);
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
