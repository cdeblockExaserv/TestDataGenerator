package com.deets.test_automation.test_data_generator.Employee;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.Dependent.Dependent;
import com.deets.test_automation.test_data_generator.Employee.Address.Address;
import com.deets.test_automation.test_data_generator.Employee.Email.BusinessEmail;
import com.deets.test_automation.test_data_generator.Employee.Email.PersonalEmail;
import com.deets.test_automation.test_data_generator.Employee.EmergencyContact.EmergencyContact;
import com.deets.test_automation.test_data_generator.Employee.NationalInfo.NationalInfo;
import com.deets.test_automation.test_data_generator.Employee.Phone.BusinessPhone;
import com.deets.test_automation.test_data_generator.Employee.Phone.PersonalPhone;
import com.deets.test_automation.test_data_generator.Job.Job;
import com.devskiller.jfairy.producer.person.Person;

public class Employee /*extends Person*/{
	
//	
//	public enum MaritalStatus { SINGLE, MARRIED, WIDOWED, DIVORCED, SEPARATED,
//	REGISTRED_PARTNERSHIP }
//	
	
	public Person person;
	
	private static Integer employeeID = 900000;
	private Integer age;
	private LocalDate dateOfBirth;
	private String suffix;
	private String maritalStatus;
	private String nativePreferedLanguage;
	private String displayName;
	private String preferedName;
	private String birthName;
	private String prefix;
	private LocalDate maritalStatusSince;
	private NationalInfo nationalInfo;
	private Dependent dependent;
	private PersonalEmail email;
	private BusinessEmail businessEmail;
	private PersonalPhone personalPhone;
	private BusinessPhone businessPhone;
	private EmergencyContact emergencyContact;
	private Address address;
	private Job job;
	
	
	public Employee(Integer age, LocalDate dateOfBirth, String suffix, String maritalStatus,String nativePreferedLanguage, String displayName, String preferedName, 
			String birthName, String prefix, LocalDate maritalStatusSince, Person person, NationalInfo nationalInfo, 
			Dependent dependent, PersonalEmail email,BusinessEmail businessEmail, PersonalPhone personalPhone, BusinessPhone businessPhone, 
			EmergencyContact emergencyContact, Address address, Job job) {

		
		employeeID++;
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
		this.email = email;
		this.businessEmail = businessEmail;
		this.businessPhone = businessPhone;
		this.personalPhone = personalPhone;
		this.emergencyContact = emergencyContact;
		this.address = address;
		this.job = job;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		
	}

	public NationalInfo getNationalInfo() {
		return nationalInfo;
	}

	public Address getAddress() {
		return address;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public static void setEmployeeID(Integer employeeID) {
		Employee.employeeID = employeeID;
	}

	public Person getPerson() {
		return person;
	}

	public Integer getEmployeeID() {
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
	
	public NationalInfo getNationalinfo() {
		return nationalInfo;
	}

	public Dependent getDependent() {
		return dependent;
	}
	
	public PersonalEmail getEmail() {
		return email;
	}
	
	public BusinessEmail getBusinessEmail() {
		return businessEmail;
	}

	public PersonalPhone getPersonalPhone() {
		return personalPhone;
	}

	public BusinessPhone getBusinessPhone() {
		return businessPhone;
	}

	public EmergencyContact getEmergencyContact() {
		return emergencyContact;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setNativePreferedLanguage(String nativePreferedLanguage) {
		this.nativePreferedLanguage = nativePreferedLanguage;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setPreferedName(String preferedName) {
		this.preferedName = preferedName;
	}

	public void setBirthName(String birthName) {
		this.birthName = birthName;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setMaritalStatusSince(LocalDate maritalStatusSince) {
		this.maritalStatusSince = maritalStatusSince;
	}

	public void setNationalInfo(NationalInfo nationalInfo) {
		this.nationalInfo = nationalInfo;
	}

	public void setDependent(Dependent dependent) {
		this.dependent = dependent;
	}

	public void setEmail(PersonalEmail email) {
		this.email = email;
	}

	public void setBusinessEmail(BusinessEmail businessEmail) {
		this.businessEmail = businessEmail;
	}

	public void setPersonalPhone(PersonalPhone personalPhone) {
		this.personalPhone = personalPhone;
	}

	public void setBusinessPhone(BusinessPhone businessPhone) {
		this.businessPhone = businessPhone;
	}

	public void setEmergencyContact(EmergencyContact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
