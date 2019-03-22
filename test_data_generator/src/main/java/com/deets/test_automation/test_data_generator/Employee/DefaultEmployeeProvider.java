package com.deets.test_automation.test_data_generator.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.math3.random.RandomGenerator;

import com.deets.test_automation.test_data_generator.Globals;
import com.deets.test_automation.test_data_generator.Fairy.Fairy;
//import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.person.Person;
import com.google.inject.assistedinject.Assisted;

public class DefaultEmployeeProvider implements EmployeeProvider{
	
	protected String employeeID;
	protected String suffix;
	protected String maritalStatus;
	protected String nativePreferedLanguage;
	protected String displayName;
	protected String preferedName;
	protected String birthName;
	protected String prefix;
	protected LocalDate maritalStatusSince;
	protected String loc;
	protected Person person;
	
	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	protected final DateProducer dateProducer;
	
	private ArrayList<String> numbers = new ArrayList<String>();

	@Inject
	public DefaultEmployeeProvider(BaseProducer baseProducer, DataMaster dataMaster,
			DateProducer dateProducer,
			@Assisted EmployeeProperties.EmployeeProperty... employeeProperties) {
		
		this.baseProducer = baseProducer;
		//this.person = Fairy.builder().withFilePrefix(loc).build().person();
		this.dataMaster = dataMaster;
		this.dateProducer = dateProducer;
		
		for (EmployeeProperties.EmployeeProperty employeeProperty : employeeProperties) {
			employeeProperty.apply(this, baseProducer);
		}
		
		for (Integer i = 1; i < 10; i++) {
			numbers.add(i.toString());
		}
	}
	
	public Employee get() {
		this.person = Fairy.builder().withFilePrefix(Globals.LOC).build().person();
		
		generateEmployeeID();
		generatePrefix();
		generateSuffix();
		generateMaritalStatus();
		generateNativePreferedLanguage();
		generateDisplayName();
		generatePreferedName();
		generateBirthName();
		generateMaritalStatusSince();
		
		return new Employee(/*person.getFirstName(), person.getMiddleName(), person.getLastName(), person.getAddress(), person.getEmail(),
				person.getUsername(), person.getPassword(), person.getSex(), person.getTelephoneNumber(), person.getDateOfBirth(), 
				person.getAge(), person.getNationalIdentityCardNumber(), person.getNationalIdentificationNumber(), person.getPassportNumber(),
				person.getCompany(), person.getCompanyEmail(), person.getNationality(), */employeeID, suffix, maritalStatus, nativePreferedLanguage, displayName, preferedName,
				birthName, prefix, maritalStatusSince, person);
	}
	
	public void generateEmployeeID() {
		// TODO Auto-generated method stub
		if (employeeID != null) { return; }
		
		employeeID = baseProducer.randomElement(numbers);
		// NOTE: Amount of numbers? Sequence? incremental?
		for (int i = 0; i < 4; i++) {
			employeeID += baseProducer.randomElement(numbers);
		}
	}
	public void generateSuffix() {
		// TODO Auto-generated method stub
		if (suffix != null) { return; }
		
		suffix = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(SUFFIX) : "";
	}
	public void generateMaritalStatus() {
		// TODO Auto-generated method stub
		if (maritalStatus != null) { return; }
		
		if (person.getAge() >= 18) {
		maritalStatus = dataMaster.getRandomValue(MARITAL_STATUS);
		} else {
			maritalStatus = "Single";
		}
	}
	public void generateNativePreferedLanguage() {
		// TODO Auto-generated method stub
		if (maritalStatus != null) { return; }
		
		nativePreferedLanguage = dataMaster.getRandomValue(NATIVE_PREFERED_LANGUAGE);
	}
	public void generateDisplayName() {
		// TODO Auto-generated method stub
		if (displayName != null) { return; }
		
		//With or without prefix/suffix?
		displayName = prefix + " " + person.getFullName() + " " + suffix;
	}
	public void generatePreferedName() {
		// TODO Auto-generated method stub
		// What does this have to be?
	}
	public void generateBirthName() {
		// TODO Auto-generated method stub
		if (birthName != null) { return; }
		
		//With or without prefix/suffix?
		birthName = prefix + " " + person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName() + " " + suffix;
	}
	public void generatePrefix() {
		// TODO Auto-generated method stub
		if (prefix != null) { return; }
		
		prefix = baseProducer.trueOrFalse() ? dataMaster.getValuesOfType(PREFIX, person.getSex().name(), String.class) : "";
	}
	public void generateMaritalStatusSince() {
		// TODO Auto-generated method stub
		if (maritalStatusSince != null) {
			return;
		}
		if (maritalStatus == "Single") {
			maritalStatusSince = person.getDateOfBirth();
		} else {
			maritalStatusSince = dateProducer.randomDateBetweenTwoDates(person.getDateOfBirth().plusYears(18), LocalDate.now());
		}
	}
	public void setEmployeeID(String employeeID) {
		// TODO Auto-generated method stub
		this.employeeID = employeeID;
	}
	public void setSuffix(String suffix) {
		// TODO Auto-generated method stub
		this.suffix = suffix;
	}
	public void setMaritalStatus(String maritalStatus) {
		// TODO Auto-generated method stub
		this.maritalStatus = maritalStatus;
	}
	public void setNativePreferedLanguage(String nativePreferedLanguage) {
		// TODO Auto-generated method stub
		this.nativePreferedLanguage = nativePreferedLanguage;
	}
	public void setDisplayName(String displayName) {
		// TODO Auto-generated method stub
		this.displayName = displayName;
	}
	public void setPreferedName(String preferedName) {
		// TODO Auto-generated method stub
		this.preferedName = preferedName;
	}
	public void setBirthName(String birthName) {
		// TODO Auto-generated method stub
		this.birthName = birthName;
	}
	public void setPrefix(String prefix) {
		// TODO Auto-generated method stub
		this.prefix = prefix;
	}
	public void setMaritalStatusSince(LocalDate maritalStatusSince) {
		// TODO Auto-generated method stub
		this.maritalStatusSince = maritalStatusSince;
	}

}
