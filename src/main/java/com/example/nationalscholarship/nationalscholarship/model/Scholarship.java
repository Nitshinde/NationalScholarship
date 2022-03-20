package com.example.nationalscholarship.nationalscholarship.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Scholarship")
public class Scholarship {
	
	@Id
	@Column(name="ApplicationId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int applicationId;
	
	@Column(name="AadharNumber")
	String  aadharNumber;
	
	@Column(name="Religion")
	String religion;
	
	@Column(name="CommunicationCategory")
	String communicationCategory;
	
	@Column(name="FatherName")
	String fatherName;
	
	@Column(name="MotherName")
	String motherName;
	
	@Column(name="FamilyAnnualIncomer")
	BigDecimal familyAnnualIncome;
	
	@Column(name="InstituteName")
	String instituteName;
	
	@Column(name="PresentClassCourse")
	String presentClassCourse;
	
	@Column(name="PresentClassCourseYear")
	String presentClassCourseYear;
	
	@Column(name="ModeOfStudy")
	String modeOfStudy;
	
	@Column(name="ClassStartDate")
	Date classStartDate;
	
	@Column(name="UniversityBoardName")
	String universityBoardName;
	
	@Column(name="PreviousClassCourse")
	String previousClassCourse;
	
	@Column(name="PreviousClassYear")
	String previousClassYear;
	
	@Column(name="TenthRollNo")
	String tenthRollNo;
	
	@Column(name="TenthBoardName")
	String tenthboardName;
	
	@Column(name="TenthPassingYear")
	String tenthpassingYear;
	
	@Column(name="TenthPercentageObtained")
	float tenthpercentageObtained;
	
	@Column(name="TwelvethRollNo")
	String twelvethrollNo;
	
	@Column(name="TwelvethBoardName")
	String twelvethboardName;
	
	@Column(name="TwelvethPassingYear")
	String twelvethpassingYear;
	
	@Column(name="TwelvethPercentageObtained")
	float twelvethpercentageObtained;
	
	@Column(name="AdmissionFee")
	BigDecimal admissionFee;
	
	@Column(name="TutionFee")
	BigDecimal tutionFee;
	
	@Column(name="OthersFee")
	BigDecimal othersFee;
	
	@Column(name="IsDisabled")
	String isDisabled;
	
	@Column(name="TypeOfDisability")
	String typeOfDisability;
	
	@Column(name="PercentageOfDisability")
	float percentageOfDisability;
	
	@Column(name="MaritalStatus")
	String maritalStatus;
	
	@Column(name="ParentProfession")
	String parentProfession;
	
	@Column(name="State")
	String state;
	
	@Column(name="District")
	String district;
	
	@Column(name="BlockTaluka")
	String blockTaluka;
	
	@Column(name="HouseNumber")
	String houseNumber;
	
	@Column(name="StreetNumber")
	String streetNumber;
	
	@Column(name="Pincode")
	String pincode;
	
	@Column(name="ChooseSchemeApplyingFor")
	String chooseSchemeApplyingFor;
	
	@Column(name="ForwardedByInstitute")
	int forwardedByInstitute;
	
	@Column(name="VerifiedByStateNodalOfficer")
	int verifiedByStateNodalOfficer;
	
	@Column(name="VerifiedByMinistry")
	int verifiedByMinistry;
	
	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCommunicationCategory() {
		return communicationCategory;
	}

	public void setCommunicationCategory(String communicationCategory) {
		this.communicationCategory = communicationCategory;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public BigDecimal getFamilyAnnualIncome() {
		return familyAnnualIncome;
	}

	public void setFamilyAnnualIncome(BigDecimal familyAnnualIncome) {
		this.familyAnnualIncome = familyAnnualIncome;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getPresentClassCourse() {
		return presentClassCourse;
	}

	public void setPresentClassCourse(String presentClassCourse) {
		this.presentClassCourse = presentClassCourse;
	}

	public String getPresentClassCourseYear() {
		return presentClassCourseYear;
	}

	public void setPresentClassCourseYear(String presentClassCourseYear) {
		this.presentClassCourseYear = presentClassCourseYear;
	}

	public String getModeOfStudy() {
		return modeOfStudy;
	}

	public void setModeOfStudy(String modeOfStudy) {
		this.modeOfStudy = modeOfStudy;
	}

	public Date getClassStartDate() {
		return classStartDate;
	}

	public void setClassStartDate(Date classStartDate) {
		this.classStartDate = classStartDate;
	}

	public String getUniversityBoardName() {
		return universityBoardName;
	}

	public void setUniversityBoardName(String universityBoardName) {
		this.universityBoardName = universityBoardName;
	}

	public String getPreviousClassCourse() {
		return previousClassCourse;
	}

	public void setPreviousClassCourse(String previousClassCourse) {
		this.previousClassCourse = previousClassCourse;
	}

	public String getPreviousClassYear() {
		return previousClassYear;
	}

	public void setPreviousClassYear(String previousClassYear) {
		this.previousClassYear = previousClassYear;
	}

	public String getTenthRollNo() {
		return tenthRollNo;
	}

	public void setTenthRollNo(String tenthRollNo) {
		this.tenthRollNo = tenthRollNo;
	}

	public String getTenthboardName() {
		return tenthboardName;
	}

	public void setTenthboardName(String tenthboardName) {
		this.tenthboardName = tenthboardName;
	}

	public String getTenthpassingYear() {
		return tenthpassingYear;
	}

	public void setTenthpassingYear(String tenthpassingYear) {
		this.tenthpassingYear = tenthpassingYear;
	}

	public float getTenthpercentageObtained() {
		return tenthpercentageObtained;
	}

	public void setTenthpercentageObtained(float tenthpercentageObtained) {
		this.tenthpercentageObtained = tenthpercentageObtained;
	}

	public String getTwelvethrollNo() {
		return twelvethrollNo;
	}

	public void setTwelvethrollNo(String twelvethrollNo) {
		this.twelvethrollNo = twelvethrollNo;
	}

	public String getTwelvethboardName() {
		return twelvethboardName;
	}

	public void setTwelvethboardName(String twelvethboardName) {
		this.twelvethboardName = twelvethboardName;
	}

	public String getTwelvethpassingYear() {
		return twelvethpassingYear;
	}

	public void setTwelvethpassingYear(String twelvethpassingYear) {
		this.twelvethpassingYear = twelvethpassingYear;
	}

	public float getTwelvethpercentageObtained() {
		return twelvethpercentageObtained;
	}

	public void setTwelvethpercentageObtained(float twelvethpercentageObtained) {
		this.twelvethpercentageObtained = twelvethpercentageObtained;
	}

	public BigDecimal getAdmissionFee() {
		return admissionFee;
	}

	public void setAdmissionFee(BigDecimal admissionFee) {
		this.admissionFee = admissionFee;
	}

	public BigDecimal getTutionFee() {
		return tutionFee;
	}

	public void setTutionFee(BigDecimal tutionFee) {
		this.tutionFee = tutionFee;
	}

	public BigDecimal getOthersFee() {
		return othersFee;
	}

	public void setOthersFee(BigDecimal othersFee) {
		this.othersFee = othersFee;
	}

	public String getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}

	public String getTypeOfDisability() {
		return typeOfDisability;
	}

	public void setTypeOfDisability(String typeOfDisability) {
		this.typeOfDisability = typeOfDisability;
	}

	public float getPercentageOfDisability() {
		return percentageOfDisability;
	}

	public void setPercentageOfDisability(float percentageOfDisability) {
		this.percentageOfDisability = percentageOfDisability;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getParentProfession() {
		return parentProfession;
	}

	public void setParentProfession(String parentProfession) {
		this.parentProfession = parentProfession;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBlockTaluka() {
		return blockTaluka;
	}

	public void setBlockTaluka(String blockTaluka) {
		this.blockTaluka = blockTaluka;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getChooseSchemeApplyingFor() {
		return chooseSchemeApplyingFor;
	}

	public void setChooseSchemeApplyingFor(String chooseSchemeApplyingFor) {
		this.chooseSchemeApplyingFor = chooseSchemeApplyingFor;
	}
}



	
	
