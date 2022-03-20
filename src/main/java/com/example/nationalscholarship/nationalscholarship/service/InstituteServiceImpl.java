package com.example.nationalscholarship.nationalscholarship.service;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nationalscholarship.nationalscholarship.dao.InstituteDao;
import com.example.nationalscholarship.nationalscholarship.model.Institute;

@Service
public class InstituteServiceImpl implements InstituteService{

	@Autowired
	InstituteDao instituteDao;
	
	@Override
	public List<Institute> getInstitutes(List<String> message, List<String> errMsg) {
		List<Institute> allInstituteList = instituteDao.getAllInstitutes();
		if(allInstituteList != null && !allInstituteList.isEmpty()) {
		message.add("Institutes found!");
		return allInstituteList;
		} else {
		errMsg.add("Institutes not found!");
		return allInstituteList;
		}
	}

	@Override
	public Institute getInstituteByInstituteNo(int Institutecode, List<String> message, List<String> errMsg) {
		Institute institute = instituteDao.getInstituteByInstituteCode(Institutecode);
		if(institute != null && !institute.toString().isEmpty()) {
			message.add("Required Institute found!");
			return institute;
			} else {
			errMsg.add("Required Institute not found!");
			return institute;
			}
	}

	@Override
	public Institute saveInstitute(Institute institute, List<String> message, List<String> errMsg) {
		Institute savedInstitute = instituteDao.saveInstitute(institute);
		if(savedInstitute != null && !savedInstitute.toString().isEmpty()) {
			message.add("Institute saved!");
			return savedInstitute;
			} else {
			errMsg.add("Institute not saved!");
			return savedInstitute;
			}
	}

	@Override
	public Institute updateInstitute(Institute institute, List<String> message, List<String> errMsg) {
		try {
			instituteDao.updateInstitute(institute);
			message.add("Institute updated!");
		} catch ( Exception e) {
			errMsg.add("Institute not updated!");
		}
		return null;
	}

	@Override
	public void deleteInstitute(int instituteNo, List<String> message, List<String> errMsg) {		
		try {
			instituteDao.deleteInstitute(instituteNo);
			message.add("Institute deleted!");
		} catch ( Exception e) {
			errMsg.add("Institute not deleted!");
		}
	}

	@Override
	public boolean checkInstituteAlreadyRegistred(String institutionCode, List<String> message, List<String> errMsg) {
		Session session = instituteDao.getSession();
		List<String> aadharNoList = new ArrayList<>();
		String qryStr = "SELECT i.institutionCode FROM Institute i WHERE i.institutionCode =:institutionCode";
		Query hql = session.createQuery(qryStr);
		hql.setParameter("institutionCode", institutionCode);
		hql.setMaxResults(1);
		aadharNoList = hql.list();
		if(aadharNoList != null && !aadharNoList.isEmpty()) {
			errMsg.add("Institute With This InstitutionCode is Already Registred");
			return true;
		} else {
			return false;
		}		
	}
	
	@Override
	@Transactional
	public void instituteLogin(String userName, String password, List<String> message, List<String> errMsg) {
		Session session = instituteDao.getSession();
		List<Institute> institutes = new ArrayList<>();
		String qryStr = "SELECT i FROM Institute i WHERE i.institutionCode =:userName AND i.password =:password";
		Query hql = session.createQuery(qryStr);
		hql.setParameter("userName", userName);
		hql.setParameter("password", password);
		hql.setMaxResults(1);
		institutes = hql.list();
		if(institutes != null && !institutes.isEmpty()) {
			Institute institute = institutes.get(0);		
			if(institute != null 
					&& !institute.toString().trim().toString().isEmpty()
					&& institute.getVerifiedByStateNodalOfficer() == 1) {
				if(institute.getVerifiedByMinistry() == 1) {
					message.add("Logged In Successfully!");
				} else {
					errMsg.add("Institute Not Verified By Ministry");
				}
			} else {
				errMsg.add("Institute Not Verified By State Nodal Officer");
			}
		} else {
			errMsg.add("Wrong Username Or Password, Please Check Username or Password");
		}
	}

}
