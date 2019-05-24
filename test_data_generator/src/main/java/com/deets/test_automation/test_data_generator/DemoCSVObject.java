package com.deets.test_automation.test_data_generator;

import java.util.HashMap;
import java.util.List;

public class DemoCSVObject {

	private String personID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private String title;
	private String gender;
	private String email;
	private String manager;
	private String department;
	private String jobCode;
	private String division;
	private String location;
	private String timeZone;
	private String hireDate;
	private String employeeID;
	private String businessPhone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String defaultLocale;
	private HashMap<String, String> customFields;
	
	public DemoCSVObject(List<String> list) {
		super();
		this.personID = list.get(1);
		this.firstName = list.get(3);
		this.middleName = list.get(5);
		this.lastName = list.get(6);
		this.suffix = list.get(7);
		this.title = list.get(8);
		this.gender = list.get(9);
		this.email = list.get(10);
		this.manager = list.get(11);
		this.department = list.get(13);
		this.jobCode = list.get(14);
		this.division = list.get(15);
		this.location = list.get(16);
		this.timeZone = list.get(17);
		this.hireDate = list.get(18);
		this.employeeID = list.get(19);
		this.businessPhone = list.get(20);
		this.addressLine1 = list.get(22);
		this.addressLine2 = list.get(23);
		this.city = list.get(24);
		this.state = list.get(25);
		this.zip = list.get(26);
		this.country = list.get(27);
		this.defaultLocale = list.get(29);
		this.customFields = new HashMap<String, String>();
		if (list.get(35).isEmpty()) {
			this.customFields.put("customField1", list.get(35));
		} else {
			this.customFields.put("customField1", "");
		}
		if (list.get(36).isEmpty()) {
		this.customFields.put("customField2", list.get(36));
		}else {
			this.customFields.put("customField2", "");
		}
		if (list.get(37).isEmpty()) {
		this.customFields.put("customField3", list.get(37));
		}else {
			this.customFields.put("customField3", "");
		}
		if (list.get(38).isEmpty()) {
			this.customFields.put("customField4", list.get(38));
		}else {
			this.customFields.put("customField4", "");
		}
		if (list.get(39).isEmpty()) {
			this.customFields.put("customField5", list.get(39));
		}else {
			this.customFields.put("customField5", "");
		}
		if (list.get(40).isEmpty()) {
			this.customFields.put("customField6", list.get(40));
		}else {
			this.customFields.put("customField6", "");
		}
		if (list.get(41).isEmpty()) {
			this.customFields.put("customField7", list.get(41));
		}else {
			this.customFields.put("customField7", "");
		}
		if (list.get(42).isEmpty()) {
			this.customFields.put("customField8", list.get(42));
		}else {
			this.customFields.put("customField8", "");
		}
		if (list.get(43).isEmpty()) {
			this.customFields.put("customField9", list.get(43));
		}else {
			this.customFields.put("customField9", "");
		}
		if (list.get(44).isEmpty()) {
			this.customFields.put("customField10", list.get(44));
		}else {
			this.customFields.put("customField10", "");
		}
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	public HashMap<String, String> getCustomFields() {
		return customFields;
	}

	public void setCustomFields(HashMap<String, String> customFields) {
		this.customFields = customFields;
	}
	
}
