package com.deets.test_automation.test_data_generator.Employee;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.Dependent.Dependent;
import com.deets.test_automation.test_data_generator.Employee.Address.Address;
import com.deets.test_automation.test_data_generator.Job.Job;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Provider;

public interface EmployeeProvider extends Provider<Employee>{

	@VisibleForTesting
	String SUFFIX = "suffixes";
	@VisibleForTesting
	String FIRST_NAME = "firstNames";
	@VisibleForTesting
	String MARITAL_STATUS = "maritalStates";
	@VisibleForTesting
	String NATIVE_PREFERED_LANGUAGE = "nativePreferedLanguages";
	@VisibleForTesting
	String PREFIX = "prefixes";
	@VisibleForTesting
	String EMAIL_TYPE = "emailTypes";
	@VisibleForTesting
	String PERSONAL_EMAIL = "personalEmails";
	@VisibleForTesting
	String NATIONAL_ID_TYPE = "nationalIdTypes";
	@VisibleForTesting
	String COUNTRY = "country";
	@VisibleForTesting
	String COUNTRY_CODE = "phoneCountryCode";
	@VisibleForTesting
	String RELATIONSHIP = "relationships";
	
	Employee get();
	
	void generateAge();
	void generateDateOfBirth();
	void generateSuffix();
	void generateMaritalStatus();
	void generateNativePreferedLanguage();
	void generateDisplayName();
	void generatePreferedName();
	void generateBirthName();
	void generatePrefix();
	void generateMaritalStatusSince();
	void generateDependent();
	void generateEmail();
	void generatePersonalPhone();
	void generateEmergencyContact();
	void generateAddress();
	void generateJob();

	public void setAge(Integer age);
	public void setDateOfBirth(LocalDate dateOfBirth);
	public void setSuffix(String suffix);
	public void setMaritalStatus(String maritalStatus);
	public void setNativePreferedLanguage(String nativePreferedLanguage);
	public void setDisplayName(String displayName);
	public void setPreferedName(String preferedName);
	public void setBirthName(String birthName);
	public void setPrefix(String prefix);
	public void setMaritalStatusSince(LocalDate maritalStatusSince);
	public void setDependent(Dependent dependent);
	public void setAddress(Address address);
	public void setEmailType(String emailType);
	public void setEmailAddress(String emailAddress);
	public void setEmailIsPrimary(boolean isPrimary);
	public void setJob(Job job);

}
