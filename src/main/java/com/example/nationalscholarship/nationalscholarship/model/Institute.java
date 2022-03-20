package com.example.nationalscholarship.nationalscholarship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Institute")
public class Institute {
	
	@Id
	@Column(name="InstituteNo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int instituteNo;
	
	@Column(name="State")
	String state;
	
	@Column(name="InstituteName")
	String instituteName;
	
	@Column(name="InstitutionCode")
	String institutionCode;
	
	@Column(name="DISECodeOfInstitute")
	String diseCodeOfInstitute;
	
	@Column(name="UniversityState")
	String universityState;
	
	@Column(name="UniversityName")
	String universityName;

	@Column(name="Password")
	String password;

	@Column(name="InstituteEstablishmentCertificate")
	String instituteEstablishmentCertificate;
	
	@Column(name="University_BoardAffiliationCertificate")
	String universityBoardAffiliationCertificate;
	
	@Column(name="VerifiedByStateNodalOfficer")
	int verifiedByStateNodalOfficer;
	
	@Column(name="VerifiedByMinistry")
	int verifiedByMinistry;
	
	@Column(name="Address")
	String address;
	
	@Column(name="City")
	String city;
	
	@Column(name="District")
	String district;
	
	@Column(name="Pincode")
	String pincode;
	
	@Column(name="principalName")
	String PrincipalName;
	
	@Column(name="MobileNo")
	String mobileNo;
	
	@Column(name="Telephone")
	String telephone;

	public int getInstituteNo() {
		return instituteNo;
	}

	public void setInstituteNo(int instituteNo) {
		this.instituteNo = instituteNo;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getDiseCodeOfInstitute() {
		return diseCodeOfInstitute;
	}

	public void setDiseCodeOfInstitute(String diseCodeOfInstitute) {
		this.diseCodeOfInstitute = diseCodeOfInstitute;
	}

	public String getUniversityState() {
		return universityState;
	}

	public void setUniversityState(String universityState) {
		this.universityState = universityState;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInstituteEstablishmentCertificate() {
		return instituteEstablishmentCertificate;
	}

	public void setInstituteEstablishmentCertificate(String instituteEstablishmentCertificate) {
		this.instituteEstablishmentCertificate = instituteEstablishmentCertificate;
	}

	public String getUniversityBoardAffiliationCertificate() {
		return universityBoardAffiliationCertificate;
	}

	public void setUniversityBoardAffiliationCertificate(String universityBoardAffiliationCertificate) {
		this.universityBoardAffiliationCertificate = universityBoardAffiliationCertificate;
	}

	public int getVerifiedByStateNodalOfficer() {
		return verifiedByStateNodalOfficer;
	}

	public void setVerifiedByStateNodalOfficer(int verifiedByStateNodalOfficer) {
		this.verifiedByStateNodalOfficer = verifiedByStateNodalOfficer;
	}

	public int getVerifiedByMinistry() {
		return verifiedByMinistry;
	}

	public void setVerifiedByMinistry(int verifiedByMinistry) {
		this.verifiedByMinistry = verifiedByMinistry;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPrincipalName() {
		return PrincipalName;
	}

	public void setPrincipalName(String principalName) {
		PrincipalName = principalName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}	
	
	
}



	
	
