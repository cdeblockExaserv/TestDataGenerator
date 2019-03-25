package com.deets.test_automation.test_data_generator.Employee;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.Dependent.Dependent;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Provider;

public interface EmployeeProvider extends Provider<Employee>{

	@VisibleForTesting
	String SUFFIX = "suffixes";
	@VisibleForTesting
	String MARITAL_STATUS = "maritalStates";
	@VisibleForTesting
	String NATIVE_PREFERED_LANGUAGE = "nativePreferedLanguages";
	@VisibleForTesting
	String PREFIX = "prefixes";
	
	Employee get();
	
	void generateEmployeeID();
	void generateSuffix();
	void generateMaritalStatus();
	void generateNativePreferedLanguage();
	void generateDisplayName();
	void generatePreferedName();
	void generateBirthName();
	void generatePrefix();
	void generateMaritalStatusSince();
	void generateDependent();
	
	public void setEmployeeID(String employeeID);
	public void setSuffix(String suffix);
	public void setMaritalStatus(String maritalStatus);
	public void setNativePreferedLanguage(String nativePreferedLanguage);
	public void setDisplayName(String displayName);
	public void setPreferedName(String preferedName);
	public void setBirthName(String birthName);
	public void setPrefix(String prefix);
	public void setMaritalStatusSince(LocalDate maritalStatusSince);
	public void setDependent(Dependent dependent);
}
