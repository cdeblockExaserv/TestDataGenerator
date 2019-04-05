package com.deets.test_automation.test_data_generator.Job;

import java.time.LocalDate;

public class Job {
	
	private String incumbent;
	private String position;
	private LocalDate positionEntryDate;
	private String company;
	private String businessUnit;
	private String division;
	private String department;
	private String location;
	private String costCenter;
	private String timezone;
	private String supervisor;
	private String jobClassification;
	private String positionTitle;
	private String localJobTitle;
	private String payGrade;
	private boolean isRegular;
	private Integer standardWeeklyHours;
	private Double FTE;
	private boolean isFulltime;
	private String employeeClass;
	private String shiftCode;
	private String FSLA_status;
	private LocalDate jobEntryDate;
	private String leaveOfAbsenceStartDate;
	private String leaveOfAbsenseReturnDate;
	private Integer LMS_jobCodeID;
	private String EEO_jobGroup;
	private String EEO_category1;
	private String EEO_category4;
	private String EEO_category5;
	private String EEO_category6;
	
	public Job(String incumbent, String position, LocalDate positionEntryDate, String company, String businessUnit, String division,
			String department, String location, String costCenter, String timezone, String supervisor,
			String jobClassification, String positionTitle, String localJobTitle, String payGrade, boolean isRegular,
			Integer standardWeeklyHours, Double fTE, boolean isFulltime, String employeeClass, String shiftCode,
			String fSLA_status, LocalDate jobEntryDate, String leaveOfAbsenceStartDate,
			String leaveOfAbsenseReturnDate, Integer lMS_jobCodeID, String eEO_jobGroup, String eEO_category1,
			String eEO_category4, String eEO_category5, String eEO_category6) {
		super();
		this.incumbent = incumbent;
		this.position = position;
		this.positionEntryDate = positionEntryDate;
		this.company = company;
		this.businessUnit = businessUnit;
		this.division = division;
		this.department = department;
		this.location = location;
		this.costCenter = costCenter;
		this.timezone = timezone;
		this.supervisor = supervisor;
		this.jobClassification = jobClassification;
		this.positionTitle = positionTitle;
		this.localJobTitle = localJobTitle;
		this.payGrade = payGrade;
		this.isRegular = isRegular;
		this.standardWeeklyHours = standardWeeklyHours;
		FTE = fTE;
		this.isFulltime = isFulltime;
		this.employeeClass = employeeClass;
		this.shiftCode = shiftCode;
		FSLA_status = fSLA_status;
		this.jobEntryDate = jobEntryDate;
		this.leaveOfAbsenceStartDate = leaveOfAbsenceStartDate;
		this.leaveOfAbsenseReturnDate = leaveOfAbsenseReturnDate;
		LMS_jobCodeID = lMS_jobCodeID;
		EEO_jobGroup = eEO_jobGroup;
		EEO_category1 = eEO_category1;
		EEO_category4 = eEO_category4;
		EEO_category5 = eEO_category5;
		EEO_category6 = eEO_category6;
	}



	public String getIncumbent() {
		return incumbent;
	}



	public String getPosition() {
		return position;
	}



	public LocalDate getPositionEntryDate() {
		return positionEntryDate;
	}



	public String getCompany() {
		return company;
	}



	public String getBusinessUnit() {
		return businessUnit;
	}



	public String getDivision() {
		return division;
	}



	public String getDepartment() {
		return department;
	}



	public String getLocation() {
		return location;
	}



	public String getCostCenter() {
		return costCenter;
	}



	public String getTimezone() {
		return timezone;
	}



	public String getSupervisor() {
		return supervisor;
	}



	public String getJobClassification() {
		return jobClassification;
	}



	public String getPositionTitle() {
		return positionTitle;
	}



	public String getLocalJobTitle() {
		return localJobTitle;
	}



	public String getPayGrade() {
		return payGrade;
	}



	public boolean getIsRegular() {
		return isRegular;
	}



	public Integer getStandardWeeklyHours() {
		return standardWeeklyHours;
	}



	public Double getFTE() {
		return FTE;
	}



	public boolean getIsFulltime() {
		return isFulltime;
	}



	public String getEmployeeClass() {
		return employeeClass;
	}



	public String getShiftCode() {
		return shiftCode;
	}



	public String getFSLA_status() {
		return FSLA_status;
	}



	public LocalDate getJobEntryDate() {
		return jobEntryDate;
	}



	public String getLeaveOfAbsenceStartDate() {
		return leaveOfAbsenceStartDate;
	}



	public String getLeaveOfAbsenseReturnDate() {
		return leaveOfAbsenseReturnDate;
	}



	public Integer getLMS_jobCodeID() {
		return LMS_jobCodeID;
	}



	public String getEEO_jobGroup() {
		return EEO_jobGroup;
	}



	public String getEeoCategory1() {
		return EEO_category1;
	}



	public String getEeoCategory4() {
		return EEO_category4;
	}



	public String getEeoCategory5() {
		return EEO_category5;
	}



	public String getEeoCategory6() {
		return EEO_category6;
	}



	public void setIncumbent(String incumbent) {
		this.incumbent = incumbent;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public void setPositionEntryDate(LocalDate positionEntryDate) {
		this.positionEntryDate = positionEntryDate;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}



	public void setDivision(String division) {
		this.division = division;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}



	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}



	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}



	public void setJobClassification(String jobClassification) {
		this.jobClassification = jobClassification;
	}



	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}



	public void setLocalJobTitle(String localJobTitle) {
		this.localJobTitle = localJobTitle;
	}



	public void setPayGrade(String payGrade) {
		this.payGrade = payGrade;
	}



	public void setIsRegular(boolean isRegular) {
		this.isRegular = isRegular;
	}



	public void setStandardWeeklyHours(Integer standardWeeklyHours) {
		this.standardWeeklyHours = standardWeeklyHours;
	}



	public void setFTE(Double fTE) {
		FTE = fTE;
	}



	public void setIsFulltime(boolean isFulltime) {
		this.isFulltime = isFulltime;
	}



	public void setEmployeeClass(String employeeClass) {
		this.employeeClass = employeeClass;
	}



	public void setShiftCode(String shiftCode) {
		this.shiftCode = shiftCode;
	}



	public void setFSLA_status(String fSLA_status) {
		FSLA_status = fSLA_status;
	}



	public void setJobEntryDate(LocalDate jobEntryDate) {
		this.jobEntryDate = jobEntryDate;
	}



	public void setLeaveOfAbsenceStartDate(String leaveOfAbsenceStartDate) {
		this.leaveOfAbsenceStartDate = leaveOfAbsenceStartDate;
	}



	public void setLeaveOfAbsenseReturnDate(String leaveOfAbsenseReturnDate) {
		this.leaveOfAbsenseReturnDate = leaveOfAbsenseReturnDate;
	}



	public void setLMS_jobCodeID(Integer lMS_jobCodeID) {
		LMS_jobCodeID = lMS_jobCodeID;
	}



	public void setEEO_jobGroup(String eEO_jobGroup) {
		EEO_jobGroup = eEO_jobGroup;
	}



	public void setEeoCategory1(String eEO_category1) {
		EEO_category1 = eEO_category1;
	}



	public void setEeoCategory4(String eEO_category4) {
		EEO_category4 = eEO_category4;
	}



	public void setEeoCategory5(String eEO_category5) {
		EEO_category5 = eEO_category5;
	}



	public void setEeoCategory6(String eEO_category6) {
		EEO_category6 = eEO_category6;
	}



}
