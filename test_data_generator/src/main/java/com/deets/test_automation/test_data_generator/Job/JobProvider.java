package com.deets.test_automation.test_data_generator.Job;

import java.time.LocalDate;

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
	protected String leaveOfAbsenseReturnDate;
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
					FSLA_status, jobEntryDate, leaveOfAbsenceStartDate, leaveOfAbsenseReturnDate, LMS_jobCodeID, 
					EEO_jobGroup, EEO_category1, EEO_category4, EEO_category5, EEO_category6);
	}

	public void generateIncumbent() {
		if (incumbent != null) {
			return;
		}
		incumbent = "";
	}

	public void generatePosition() {
		if (position != null) {
			return; 
		}
		position = StringUtils.substringBetween(dataMaster.getRandomValue(POSITION), "(", ")");
	}

	public void generatePositionEntryDate() {
		if (positionEntryDate != null) {
			return;
		}
		positionEntryDate = dateProducer.randomDateBetweenTwoDates(jobEntryDate, LocalDate.now().minusDays(1));
	}

	public void generateCompany() {
		if(company != null) {
			return;
		}
		company = dataMaster.getRandomValue(COMPANY);
	}

	public void generateBusinessUnit() {
		if(businessUnit != null) {
			return;
		}
		businessUnit = dataMaster.getRandomValue(BUSINESS_UNIT);
	}

	public void generateDivision() {
		if(division != null) {
			return;
		}
		division = dataMaster.getRandomValue(DIVISION);		
	}

	public void generateDepartment() {
		if(department != null) {
			return;
		}
		department = dataMaster.getRandomValue(DEPARTMENT);		
	}

	public void generateLocation() {
		if(location != null) {
			return;
		}
		location = dataMaster.getRandomValue(LOCATION);		
	}

	public void generateCostcenter() {
		if(costCenter != null) {
			return;
		}
		costCenter = dataMaster.getRandomValue(COSTCENTER);		
	}

	public void generateTimezone() {
		if(timezone != null) {
			return;
		}
		// Maybe generated -> TrueOrFalse()
		timezone = "";
	}

	public void generateSupervisor() {
		if(supervisor != null) {
			return;
		}
		if (!Globals.Employees.isEmpty()) {
			int index = baseProducer.randomBetween(0, Globals.Employees.size()-1);
			supervisor = Globals.Employees.get(index).getEmployeeID().toString();
		} else {
			supervisor = "";
		}
	}

	public void generateJobClassification() {
		if(jobClassification != null) {
			return;
		}
		jobClassification = dataMaster.getRandomValue(JOB_CLASSIFICATION);
	}

	public void generatePositionTitle() {
		if(positionTitle != null) {
			return;
		}
		positionTitle = baseProducer.trueOrFalse() ? StringUtils.substringBefore(position, "(") : "";
	}

	public void generateLocalJobTitle() {
		if(localJobTitle != null) {
			return;
		}
		if(positionTitle == "") {
			localJobTitle = StringUtils.substringBefore(position, "(");
		} else {
			localJobTitle = "";
		}
		
	}

	public void generatePayGrade() {
		if(payGrade != null) {
			return;
		}
		payGrade = dataMaster.getRandomValue(PAYGRADE);
	}

	public void generateIsRegular() {
		isRegular = baseProducer.trueOrFalse();
	}

	public void generateStandardWeeklyHours() {
		if(standardWeeklyHours != null) {
			return;
		}
		standardWeeklyHours = baseProducer.randomBetween(Integer.parseInt(dataMaster.getRandomValue(MIN_HOURS)), 
						Integer.parseInt(dataMaster.getRandomValue(MAX_HOURS)));
	}

	public void generateFTE() {
		if(fte != null) {
			return;
		}
		fte = Double.parseDouble(dataMaster.getRandomValue(FTE));
	}

	public void generateIsFullTime() {
		isFulltime = baseProducer.trueOrFalse();
	}

	public void generateEmployeeClass() {
		if (employeeClass != null) {
			return;
		}
		employeeClass = dataMaster.getRandomValue(EMPLOYEE_CLASS);
	}

	public void generateShiftCode() {
		if(shiftCode != null) {
			return;
		}
		shiftCode = dataMaster.getRandomValue(SHIFT_CODE);
	}

	public void generateFslaStatus() {
		if(FSLA_status != null) {
			return;
		}
		FSLA_status = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(FSLA_STATUS) : "";
	}

	public void generateJobEntryDate() {
		if (jobEntryDate != null) {
			return;
		}
		jobEntryDate = dateProducer.randomDateBetweenTwoDates(dateOfBirth.plusYears(18).minusDays(1), LocalDate.now().minusDays(1));
	}

	public void generateLeaveOfAbsenceStartDate() {
		if(leaveOfAbsenceStartDate != null) {
			return;
		}
		loaDate = dateProducer.randomDateBetweenTwoDates(positionEntryDate.plusDays(1), LocalDate.now());
		leaveOfAbsenceStartDate = baseProducer.trueOrFalse() ? loaDate.toString() : "";
	}

	public void generateLeaveOfAbsenceEndDate() {
		if(leaveOfAbsenseReturnDate != null) {
			return;
		}
		if(leaveOfAbsenceStartDate != "")	{
			leaveOfAbsenseReturnDate = dateProducer.randomDateBetweenTwoDates(loaDate.plusDays(1), LocalDate.now().plusDays(14)).toString();
		} else {
			leaveOfAbsenseReturnDate = "";
		}
	}

	public void generateLmsJobCodeID() {
		if (LMS_jobCodeID != null) {
			return;
		}
		// TODO:Get complementary data instead of (3000, 5000)
		LMS_jobCodeID = baseProducer.randomBetween(3000, 5000);
	}

	public void generateEeoJobGroup() {
		if(EEO_jobGroup != null) {
			return;
		}
		EEO_jobGroup = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(EEO_JOB_GROUP) : "";
	}

	public void generateEeoCategory1() {
		if(EEO_category1 != null) {
			return;
		}
		EEO_category1 = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(EEO_CATEGORY1) : "";
	}

	public void generateEeoCategory4() {
		if(EEO_category4 != null) {
			return;
		}
		EEO_category4 = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(EEO_CATEGORY4) : "";
	}

	public void generateEeoCategory5() {
		if(EEO_category5 != null) {
			return;
		}
		EEO_category5 = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(EEO_CATEGORY5) : "";
	}

	public void generateEeoCategory6() {
		if(EEO_category6 != null) {
			return;
		}
		EEO_category6 = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(EEO_CATEGORY6) : "";
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

	public void setLeaveOfAbsenseReturnDate(String leaveOfAbsenseReturnDate) {
		 this.leaveOfAbsenseReturnDate = leaveOfAbsenseReturnDate;
		
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
