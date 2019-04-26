package com.deets.test_automation.test_data_generator.Employee;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.Globals;
import com.deets.test_automation.test_data_generator.Dependent.Dependent;
import com.deets.test_automation.test_data_generator.Employee.Address.Address;
import com.deets.test_automation.test_data_generator.Employee.Email.Email;
import com.deets.test_automation.test_data_generator.Employee.EmergencyContact.EmergencyContact;
import com.deets.test_automation.test_data_generator.Employee.NationalInfo.NationalInfo;
import com.deets.test_automation.test_data_generator.Employee.Phone.Phone;
import com.deets.test_automation.test_data_generator.Job.Job;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.person.Person;

public class Employee /*extends Person*/{
	
//	
//	public enum MaritalStatus { SINGLE, MARRIED, WIDOWED, DIVORCED, SEPARATED,
//	REGISTRED_PARTNERSHIP }
//	
	
	public Person person;
	protected final DataMaster dataMaster;
	
	private static Integer employeeID;
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
	private Email email;
	private Phone phone;
	private EmergencyContact emergencyContact;
	private Address address;
	private Job job;
	private CustomField customField1;
	private CustomField customField2;
	private CustomField customField3;
	private CustomField customField4;
	private CustomField customField5;
	private CustomField customField6;
	private CustomField customField7;
	private CustomField customField8;
	private CustomField customField9;
	private CustomField customField10;
	
	
	public Employee(Integer age, LocalDate dateOfBirth, String suffix, String maritalStatus,String nativePreferedLanguage, String displayName, String preferedName, 
			String birthName, String prefix, LocalDate maritalStatusSince, Person person, NationalInfo nationalInfo, 
			Dependent dependent, Email email, Phone phone, EmergencyContact emergencyContact, Address address, Job job,
			CustomField customField1, CustomField customField2, CustomField customField3, CustomField customField4, 
			CustomField customField5, CustomField customField6, CustomField customField7, CustomField customField8, 
			CustomField customField9, CustomField customField10, DataMaster dataMaster) {

		this.dataMaster = dataMaster;
		if (Globals.settings.isEmployeeID()) {
			if (employeeID == null) {
				employeeID = Integer.valueOf(dataMaster.getRandomValue("employeeIDStart")) - 1;
			}
			employeeID++;
		} else employeeID = null;
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
		this.phone = phone;
		this.emergencyContact = emergencyContact;
		this.address = address;
		this.job = job;
		this.customField1 = customField1;
		this.customField2 = customField2;
		this.customField3 = customField3;
		this.customField4 = customField4;
		this.customField5 = customField5;
		this.customField6 = customField6;
		this.customField7 = customField7;
		this.customField8 = customField8;
		this.customField9 = customField9;
		this.customField10 = customField10;
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
	
	public Email getEmail() {
		return email;
	}

	public Phone getPhone() {
		return phone;
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

	public void setEmail(Email email) {
		this.email = email;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
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

	public CustomField getCustomField1() {
		return customField1;
	}
	public CustomField getCustomField2() {
		return customField2;
	}
	public CustomField getCustomField3() {
		return customField3;
	}
	public CustomField getCustomField4() {
		return customField4;
	}
	public CustomField getCustomField5() {
		return customField5;
	}
	public CustomField getCustomField6() {
		return customField6;
	}
	public CustomField getCustomField7() {
		return customField7;
	}
	public CustomField getCustomField8() {
		return customField8;
	}
	public CustomField getCustomField9() {
		return customField9;
	}
	public CustomField getCustomField10() {
		return customField10;
	}

	public void setCustomField1(CustomField customField1) {
		this.customField1 = customField1;
	}
	public void setCustomField2(CustomField customField2) {
		this.customField2 = customField2;
	}
	public void setCustomField3(CustomField customField3) {
		this.customField3 = customField3;
	}
	public void setCustomField4(CustomField customField4) {
		this.customField4 = customField4;
	}
	public void setCustomField5(CustomField customField5) {
		this.customField5 = customField5;
	}
	public void setCustomField6(CustomField customField6) {
		this.customField6 = customField6;
	}
	public void setCustomField7(CustomField customField7) {
		this.customField7 = customField7;
	}
	public void setCustomField8(CustomField customField8) {
		this.customField8 = customField8;
	}
	public void setCustomField9(CustomField customField9) {
		this.customField9 = customField9;
	}
	public void setCustomField10(CustomField customField10) {
		this.customField10 = customField10;
	}
	
	
}
