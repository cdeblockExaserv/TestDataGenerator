package com.deets.test_automation.test_data_generator.Employee;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.NationalInfo.NationalInfo;
import com.devskiller.jfairy.producer.person.Person;

public class Employee /*extends Person*/{
	
//	
//	public enum MaritalStatus { SINGLE, MARRIED, WIDOWED, DIVORCED, SEPARATED,
//	REGISTRED_PARTNERSHIP }
//	
	
	public Person person;
	
	private final String employeeID;
	private final String suffix;
	private final String maritalStatus;
	private final String nativePreferedLanguage;
	private final String displayName;
	private final String preferedName;
	private final String birthName;
	private final String prefix;
	private final LocalDate maritalStatusSince;
	private final String loc;
	private final NationalInfo nationalInfo;
	private final Dependent dependent;

	
	
	public Employee(/*String firstName, String middleName, String lastName, Address address, String email, String username,
            String password, Sex sex, String telephoneNumber, LocalDate dateOfBirth, Integer age,
            String nationalIdentityCardNumber, String nationalIdentificationNumber, String passportNumber,
            Company company, String companyEmail, Country nationality, */String employeeID, String suffix, String maritalStatus,
			String nativePreferedLanguage, String displayName, String preferedName, String birthName, String prefix,
			LocalDate maritalStatusSince, Person person, NationalInfo nationalInfo, Dependent dependent) {
//		super(firstName, middleName, lastName, address, email, username,
//	              password, sex, telephoneNumber, dateOfBirth, age,
//	              nationalIdentityCardNumber, nationalIdentificationNumber, passportNumber,
//	              company, companyEmail, nationality);
		this.loc = "us";
		//this.person = Fairy.builder().withFilePrefix(loc).build().person();
		
		this.employeeID = employeeID;
		this.suffix = suffix;
		this.maritalStatus = maritalStatus;
		this.nativePreferedLanguage = nativePreferedLanguage;
		this.displayName = displayName;
		this.preferedName = preferedName;
		this.birthName = birthName;
		this.prefix = prefix;
		this.maritalStatusSince = maritalStatusSince;
		this.person = person;
		this.nationalInfo = nationalInfo;
		this.dependent = dependent;
		
	}

	public Person getPerson() {
		return person;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getNativePreferedLanguage() {
		return nativePreferedLanguage;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public String getPreferedName() {
		return preferedName;
	}

	public String getBirthName() {
		return birthName;
	}

	public String getPrefix() {
		return prefix;
	}

	public LocalDate getMaritalStatusSince() {
		return maritalStatusSince;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	public String getLoc() {
		return loc;
	}
	
	public NationalInfo getNationalinfo() {
		return nationalInfo;
	}

	public Dependent getDependent() {
		return dependent;
	}
	
}
