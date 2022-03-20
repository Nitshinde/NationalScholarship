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

import com.example.nationalscholarship.nationalscholarship.dao.InstituteDao;
import com.example.nationalscholarship.nationalscholarship.model.Institute;
import com.example.nationalscholarship.nationalscholarship.response.ResponseViewModel;
import com.example.nationalscholarship.nationalscholarship.service.InstituteService;

@RestController
public class InstituteController {

	@Autowired
	InstituteService  instituteService;
	
	
	@GetMapping("/a")
	public String home() {
		return "Get";
	}
	
	@GetMapping("/getInstituteInfo")
	public ResponseViewModel getInstituteInfo() {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		List<Institute> allInstituteList = instituteService.getInstitutes(message, errMsg);
		if(errMsg == null || errMsg.isEmpty()) {
			responseViewModel.setError(false);
			responseViewModel.setErrorCode(0);
			responseViewModel.setMessage(message.toString());
			responseViewModel.setResult(allInstituteList);
		} else {
			responseViewModel.setError(true);
			responseViewModel.setErrorCode(1);
			responseViewModel.setMessage(errMsg.toString());
			responseViewModel.setResult(allInstituteList);
		}
		return responseViewModel;
	}
	
	@GetMapping("/getInstituteInfoByInstituteNo/{instituteNo}")
	public ResponseViewModel getInstituteInfoByInstituteCode(@PathVariable int instituteNo) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		Institute institute = instituteService.getInstituteByInstituteNo(instituteNo, message, errMsg);
		if(errMsg == null || errMsg.isEmpty()) {
			responseViewModel.setError(false);
			responseViewModel.setErrorCode(0);
			responseViewModel.setMessage(message.toString());
			responseViewModel.setResult(institute);
		} else {
			responseViewModel.setError(true);
			responseViewModel.setErrorCode(1);
			responseViewModel.setMessage(errMsg.toString());
			responseViewModel.setResult(institute);
		}
		return responseViewModel;
	}
	
	@PostMapping("/saveInstituteInfo")
	public ResponseViewModel saveInstituteInfo(@RequestBody Institute institute) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		Institute savedInstitute = new Institute();
		String institutionCode = "";
		boolean isAlreadyRegistred = false;
		if(institute != null && institute.getInstitutionCode() != null && institute.getInstitutionCode() != "") {
		institutionCode = institute.getInstitutionCode();
		isAlreadyRegistred = instituteService.checkInstituteAlreadyRegistred(institutionCode, message, errMsg);
		} else {
			errMsg.add("Please Provide Institution Code");
		}
		if(!isAlreadyRegistred) {
		savedInstitute = instituteService.saveInstitute(institute, message, errMsg);
		}
		if(errMsg == null || errMsg.isEmpty()) {
			responseViewModel.setError(false);
			responseViewModel.setErrorCode(0);
			responseViewModel.setMessage(message.toString());
			responseViewModel.setResult(savedInstitute);
		} else {
			responseViewModel.setError(true);
			responseViewModel.setErrorCode(1);
			responseViewModel.setMessage(errMsg.toString());
			responseViewModel.setResult(null);
		}
		return responseViewModel;
	}
	
	@PostMapping("/updateInstituteInfo")
	public ResponseViewModel updateInstituteInfo(@RequestBody Institute institute) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		Institute updatedInstitute = instituteService.updateInstitute(institute, message, errMsg);
				if(errMsg == null || errMsg.isEmpty()) {
					responseViewModel.setError(false);
					responseViewModel.setErrorCode(0);
					responseViewModel.setMessage(message.toString());
					responseViewModel.setResult(institute);
				} else {
					responseViewModel.setError(true);
					responseViewModel.setErrorCode(1);
					responseViewModel.setMessage(errMsg.toString());
					responseViewModel.setResult(updatedInstitute);
				}
				return responseViewModel;
	}
	
	@DeleteMapping("/deleteInstituteByInstituteNo/{InstituteNo}")
	public ResponseViewModel deleteInstituteByInstituteCode(@PathVariable int instituteNo) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		instituteService.deleteInstitute(instituteNo, message, errMsg);
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
	
	@PostMapping("/instituteLogin")
	public ResponseViewModel instituteLoginAfterVerify(@RequestBody String userName, String password) {
		ResponseViewModel responseViewModel = new ResponseViewModel();
		List<String> message = new ArrayList<String>();
		List<String> errMsg = new ArrayList<String>();
		instituteService.instituteLogin(userName, password, message, errMsg);
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
