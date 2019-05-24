package com.deets.test_automation.test_data_generator.Job;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.deets.test_automation.test_data_generator.Globals;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class JobProvider implements Provider<Job>{
	@VisibleForTesting
	String POSITION = "positions";
	@VisibleForTesting
	String COMPANY = "companies";
	@VisibleForTesting
	String BUSINESS_UNIT = "businessUnits";
	@VisibleForTesting
	String DIVISION = "divisions";
	@VisibleForTesting
	String DEPARTMENT = "departments";
	@VisibleForTesting
	String LOCATION = "locations";
	@VisibleForTesting
	String COSTCENTER = "costcenters";
	@VisibleForTesting
	String JOB_CLASSIFICATION = "jobClassifications";
	@VisibleForTesting
	String MIN_HOURS = "minHours";
	@VisibleForTesting
	String MAX_HOURS = "maxHours";
	@VisibleForTesting
	String PAYGRADE = "paygrades";
	@VisibleForTesting
	String FTE = "fte";
	@VisibleForTesting
	String EMPLOYEE_CLASS = "employeeClasses";
	@VisibleForTesting
	String SHIFT_CODE = "shiftCodes";
	@VisibleForTesting
	String FSLA_STATUS = "fslaStatus";
	@VisibleForTesting
	String MIN_JOB_ENTRY = "minJobEntryDate";
	@VisibleForTesting
	String MIN_POSITION_ENTRY = "minPositionEntryDate";
	@VisibleForTesting
	String EEO_JOB_GROUP = "eeoJobGroups";
	@VisibleForTesting
	String EEO_CATEGORY1 = "eeoCategory1";
	@VisibleForTesting
	String EEO_CATEGORY4 = "eeoCategory4";
	@VisibleForTesting
	String EEO_CATEGORY5 = "eeoCategory5";
	@VisibleForTesting
	String EEO_CATEGORY6 = "eeoCategory6";
	

	protected String incumbent;
	protected String position;
	protected LocalDate positionEntryDate;
	protected String company;
	protected String businessUnit;
	protected String division;
	protected String department;
	protected String location;
	protected String costCenter;
	protected String timezone;
	protected String supervisor;
	protected String jobClassification;
	protected String positionTitle;
	protected String localJobTitle;
	protected String payGrade;
	protected boolean isRegular;
	protected Integer standardWeeklyHours;
	protected Double fte;
	protected boolean isFulltime;
	protected String employeeClass;
	protected String shiftCode;
	protected String FSLA_status;
	protected LocalDate jobEntryDate;
	private LocalDate loaDate;
	protected String leaveOfAbsenceStartDate;
	protected String leaveOfAbsenceReturnDate;
	protected Integer LMS_jobCodeID;
	protected String EEO_jobGroup;
	protected String EEO_category1;
	protected String EEO_category4;
	protected String EEO_category5;
	protected String EEO_category6;
	protected LocalDate dateOfBirth;
	
	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	protected final DateProducer dateProducer;

	@Inject
	public JobProvider(BaseProducer baseProducer, DataMaster dataMaster, DateProducer dateProducer) {
		
		this.baseProducer = baseProducer;
		this.dataMaster = dataMaster;
		this.dateProducer = dateProducer;
		
	}

	public Job get(LocalDate dateOfBirth) {

		this.dateOfBirth = dateOfBirth;
		generateIncumbent();
		generatePosition();
		generateCompany();
		generateBusinessUnit();
		generateDivision();
		generateDepartment();
		generateLocation();
		generateCostcenter();
		generateTimezone();
		generateSupervisor();
		generateJobClassification();
		generatePositionTitle();
		generateLocalJobTitle();
		generatePayGrade();
		generateIsRegular();
		generateStandardWeeklyHours();
		generateFTE();
		generateIsFullTime();
		generateEmployeeClass();
		generateShiftCode();
		generateFslaStatus();
		generateJobEntryDate();
		generatePositionEntryDate();
		generateLeaveOfAbsenceStartDate();
		generateLeaveOfAbsenceEndDate();
		generateLmsJobCodeID();
		generateEeoJobGroup();
		generateEeoCategory1();
		generateEeoCategory4();
		generateEeoCategory5();
		generateEeoCategory6();
		
		
		return new Job(incumbent, position, positionEntryDate, company, businessUnit, division, department,
					location, costCenter, timezone, supervisor, jobClassification, positionTitle, localJobTitle,
					payGrade, isRegular, standardWeeklyHours, fte, isFulltime, employeeClass, shiftCode,
					FSLA_status, jobEntryDate, leaveOfAbsenceStartDate, leaveOfAbsenceReturnDate, LMS_jobCodeID, 
					EEO_jobGroup, EEO_category1, EEO_category4, EEO_category5, EEO_category6);
	}

	public void generateIncumbent() {
		if (Globals.settings.isIncumbent()) {
			incumbent = "";
		} else incumbent = "";
		
	}

	public void generatePosition() {
		if (Globals.settings.isPosition()) {
			position = StringUtils.substringBetween(dataMaster.getRandomValue(POSITION), "(", ")"); 
		} else position = "";
		
	}

	public void generatePositionEntryDate() {
		if (Globals.settings.isPositionEntrydate()) {
			if (jobEntryDate.isAfter(LocalDate.parse(dataMaster.getRandomValue(MIN_POSITION_ENTRY)))){
				positionEntryDate = dateProducer.randomDateBetweenTwoDates(jobEntryDate, LocalDate.now().minusDays(1));
			} else {
				positionEntryDate = dateProducer.randomDateBetweenTwoDates(LocalDate.parse(dataMaster.getRandomValue(MIN_POSITION_ENTRY)),
						LocalDate.now().minusDays(1));
			}
			
		} else positionEntryDate = LocalDate.parse(Globals.demo.getHireDate());
	}

	public void generateCompany() {
		if(Globals.settings.isCompany()) {
			company = dataMaster.getRandomValue(COMPANY);
		} else company = "";
	}

	public void generateBusinessUnit() {
		if(Globals.settings.isBusinessUnit()) {
			businessUnit = dataMaster.getRandomValue(BUSINESS_UNIT);
		} else businessUnit = "";
	}

	public void generateDivision() {
		if(Globals.settings.isDivision()) {
			division = dataMaster.getRandomValue(DIVISION);		
		} else division = Globals.demo.getDivision();
	}

	public void generateDepartment() {
		if(Globals.settings.isDepartment()) {
			department = dataMaster.getRandomValue(DEPARTMENT);		
		} else department = Globals.demo.getDepartment();
	}

	public void generateLocation() {
		if(Globals.settings.isLocation()) {
			location = dataMaster.getRandomValue(LOCATION);		
		} else location = Globals.demo.getLocation();
	}

	public void generateCostcenter() {
		if(Globals.settings.isCostCenter()) {
			costCenter = dataMaster.getRandomValue(COSTCENTER);		
		} else costCenter = "";
	}

	public void generateTimezone() {
		if(Globals.settings.isTimeZone()) {
			ArrayList<String> timezones = new ArrayList<String>(Arrays.asList(Globals.timezone.split("/")));
			Random r = new Random();
			timezone = timezones.get(r.nextInt(timezones.size()));
		} else timezone = Globals.demo.getTimeZone();
		
	}

	public void generateSupervisor() {
		if(Globals.settings.isSupervisor()) {
			if (!Globals.employees.isEmpty()) {
				int index = baseProducer.randomBetween(0, Globals.employees.size()-1);
				supervisor = Globals.employees.get(index).getEmployeeID().toString();
			} else supervisor = "";	
		} else supervisor = Globals.demo.getManager();
	}

	public void generateJobClassification() {
		if(Globals.settings.isJobClassification()) {
			jobClassification = dataMaster.getRandomValue(JOB_CLASSIFICATION);
		} else jobClassification = "";
	}

	public void generatePositionTitle() {
		if(Globals.settings.isPositionTitle()) {
			positionTitle = baseProducer.trueOrFalse() ? StringUtils.substringBefore(position, "(") : "";
		} else positionTitle = "";
	}

	public void generateLocalJobTitle() {
		if(Globals.settings.isLocalJobTitle()) {
			if(positionTitle == "") {
				localJobTitle = StringUtils.substringBefore(position, "(");
			} else localJobTitle = "";		
		} else localJobTitle = Globals.demo.getTitle();
	}

	public void generatePayGrade() {
		if(Globals.settings.isPayGrade()) {
			payGrade = dataMaster.getRandomValue(PAYGRADE);
		} else payGrade = "";
	}

	public void generateIsRegular() {
		if(Globals.settings.isRegular()) {
			isRegular = baseProducer.trueOrFalse();
		} else isRegular = false;
	}

	public void generateStandardWeeklyHours() {
		if(Globals.settings.isStandardWeeklyHours()) {
			standardWeeklyHours = baseProducer.randomBetween(Integer.parseInt(dataMaster.getRandomValue(MIN_HOURS)), 
					Integer.parseInt(dataMaster.getRandomValue(MAX_HOURS)));
		} else standardWeeklyHours = 0;
	}

	public void generateFTE() {
		if(Globals.settings.isFte()) {
			fte = Double.parseDouble(dataMaster.getRandomValue(FTE));
		} else fte = 0.00;
	}

	public void generateIsFullTime() {
		if(Globals.settings.isFulltime()) {
			isFulltime = baseProducer.trueOrFalse();
		} else isFulltime = false;
	}

	public void generateEmployeeClass() {
		if(Globals.settings.isEmployeeClass()) {
			employeeClass = dataMaster.getRandomValue(EMPLOYEE_CLASS);
		} else employeeClass = "";
	}

	public void generateShiftCode() {
		if(Globals.settings.isShiftCode()) {
			shiftCode = dataMaster.getRandomValue(SHIFT_CODE);
		} else shiftCode = "";
	}

	public void generateFslaStatus() {
		if(Globals.settings.isFslaStatus()) {
			FSLA_status = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(FSLA_STATUS) : "";
		} else FSLA_status = "";
	}

	public void generateJobEntryDate() {
		if(Globals.settings.isJobEntryDate()) {
			if (dateOfBirth.isAfter(LocalDate.parse(dataMaster.getRandomValue(MIN_JOB_ENTRY)))){
				jobEntryDate = dateProducer.randomDateBetweenTwoDates(dateOfBirth.plusYears(18).minusDays(1), LocalDate.now().minusDays(1));
			} else {
				jobEntryDate = dateProducer.randomDateBetweenTwoDates(LocalDate.parse(dataMaster.getRandomValue(MIN_JOB_ENTRY)).minusDays(1),
						LocalDate.now().minusDays(1));
			}
			
		} else jobEntryDate = null;
	}

	public void generateLeaveOfAbsenceStartDate() {
		if(Globals.settings.isLeaveOfAbsenceStartDate()) {
			loaDate = dateProducer.randomDateBetweenTwoDates(positionEntryDate.plusDays(1), LocalDate.now());
			leaveOfAbsenceStartDate = baseProducer.trueOrFalse() ? loaDate.toString() : "";	
		} else {
			loaDate = null;
			leaveOfAbsenceStartDate = "";
		}
	}

	public void generateLeaveOfAbsenceEndDate() {
		if(Globals.settings.isLeaveOfAbsenceReturnDate()){
			if(leaveOfAbsenceStartDate != "")	{
				leaveOfAbsenceReturnDate = dateProducer.randomDateBetweenTwoDates(loaDate.plusDays(1), LocalDate.now().plusDays(14)).toString();
			} else {
				leaveOfAbsenceReturnDate = "";
			}	
		} else leaveOfAbsenceReturnDate = "";
	}

	public void generateLmsJobCodeID() {
		if(Globals.settings.isLmsJobCodeID()) {
			// TODO:Get complementary data instead of (3000, 5000)
			LMS_jobCodeID = baseProducer.randomBetween(3000, 5000);	
		} else LMS_jobCodeID = Integer.valueOf(Globals.demo.getJobCode());
	}

	public void generateEeoJobGroup() {
		if(Globals.settings.isEeoJobGroup()) {
			EEO_jobGroup = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(EEO_JOB_GROUP) : "";
		} else EEO_jobGroup = "";
	}

	public void generateEeoCategory1() {
		if(Globals.settings.isEeoCategory1()) {
			EEO_category1 = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(EEO_CATEGORY1) : "";
		} else EEO_category1 = "";
	}

	public void generateEeoCategory4() {
		if(Globals.settings.isEeoCategory4()) {
			EEO_category4 = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(EEO_CATEGORY4) : "";
		} else EEO_category4 = "";
	}

	public void generateEeoCategory5() {
		if(Globals.settings.isEeoCategory5()) {
			EEO_category5 = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(EEO_CATEGORY5) : "";
		} else EEO_category5 = "";
	}

	public void generateEeoCategory6() {
		if(Globals.settings.isEeoCategory6()) {
			EEO_category6 = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(EEO_CATEGORY6) : "";
		} else EEO_category6 = "";
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

	public void setRegular(boolean isRegular) {
		 this.isRegular = isRegular;
		
	}

	public void setStandardWeeklyHours(Integer standardWeeklyHours) {
		 this.standardWeeklyHours = standardWeeklyHours;
		
	}

	public void setFTE(Double fTE) {
		 this.fte = fTE;
		
	}

	public void setFulltime(boolean isFulltime) {
		 this.isFulltime = isFulltime;
		
	}

	public void setEmployeeClass(String employeeClass) {
		 this.employeeClass = employeeClass;
		
	}

	public void setShiftCode(String shiftCode) {
		 this.shiftCode = shiftCode;
		
	}

	public void setFslaStatus(String fSLA_status) {
		 this.FSLA_status = fSLA_status;
		
	}

	public void setJobEntryDate(LocalDate jobEntryDate) {
		 this.jobEntryDate = jobEntryDate;
		
	}

	public void setLeaveOfAbsenceStartDate(String leaveOfAbsenceStartDate) {
		 this.leaveOfAbsenceStartDate = leaveOfAbsenceStartDate;
		
	}

	public void setLeaveOfAbsenceReturnDate(String leaveOfAbsenceReturnDate) {
		 this.leaveOfAbsenceReturnDate = leaveOfAbsenceReturnDate;
		
	}

	public void setLmsJobCodeID(Integer lMS_jobCodeID) {
		 this.LMS_jobCodeID = lMS_jobCodeID;
		
	}

	public void setEeoJobGroup(String eEO_jobGroup) {
		 this.EEO_jobGroup = eEO_jobGroup;
		
	}

	public void setEeoCategory1(String eEO_category1) {
		 this.EEO_category1 = eEO_category1;
		
	}

	public void setEeoCategory4(String eEO_category4) {
		 
		this.EEO_category4 = eEO_category4;
	}

	public void setEeoCategory5(String eEO_category5) {
		 this.EEO_category5 = eEO_category5;
		
	}

	public void setEeoCategory6(String eEO_category6) {
		 this.EEO_category6 = eEO_category6;
		
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		 this.dateOfBirth = dateOfBirth;
		
	}

	public Job get() {
		 
		return null;
	}
	
}
