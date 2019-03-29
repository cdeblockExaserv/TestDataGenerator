package com.deets.test_automation.test_data_generator.Employee;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.inject.Inject;

import com.deets.test_automation.test_data_generator.Globals;
import com.deets.test_automation.test_data_generator.Dependent.Dependent;
import com.deets.test_automation.test_data_generator.Dependent.DependentProvider;
import com.deets.test_automation.test_data_generator.Employee.Email.BusinessEmail;
import com.deets.test_automation.test_data_generator.Employee.Email.PersonalEmail;
import com.deets.test_automation.test_data_generator.Employee.EmergencyContact.EmergencyContact;
import com.deets.test_automation.test_data_generator.Employee.NationalInfo.NationalInfo;
import com.deets.test_automation.test_data_generator.Employee.Phone.BusinessPhone;
import com.deets.test_automation.test_data_generator.Employee.Phone.PersonalPhone;
//import com.deets.test_automation.test_data_generator.Email.EmailFactory;
//import com.deets.test_automation.test_data_generator.Email.EmailProperties;
//import com.deets.test_automation.test_data_generator.Email.EmailProvider;
import com.deets.test_automation.test_data_generator.Fairy.Fairy;
//import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.util.TextUtils;
import static org.apache.commons.lang3.StringUtils.lowerCase;

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
	protected NationalInfo nationalInfo;
	protected Dependent dependent;
	protected PersonalEmail email;
	protected BusinessEmail businessEmail;
	protected PersonalPhone personalPhone;
	protected BusinessPhone businessPhone;
	protected EmergencyContact emergencyContact;
	
	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	protected final DateProducer dateProducer;
	protected final DependentProvider dependentProvider;
	
	private ArrayList<String> numbers = new ArrayList<String>();

	@Inject
	public DefaultEmployeeProvider(BaseProducer baseProducer, DataMaster dataMaster,
			DateProducer dateProducer, DependentProvider dependentProvider,
			@Assisted EmployeeProperties.EmployeeProperty... employeeProperties) {
		
		this.baseProducer = baseProducer;
		//this.person = Fairy.builder().withFilePrefix(loc).build().person();
		this.dataMaster = dataMaster;
		this.dateProducer = dateProducer;
		this.dependentProvider = dependentProvider;
		
		for (EmployeeProperties.EmployeeProperty employeeProperty : employeeProperties) {
			employeeProperty.apply(this, baseProducer);
		}
		
		for (Integer i = 1; i < 10; i++) {
			numbers.add(i.toString());
		}
	}
	
	public Employee get() {
		this.person = Fairy.builder().withFilePrefix(Globals.LOC).build().person();
		
		generatePrefix();
		generateSuffix();
		generateMaritalStatus();
		generateNativePreferedLanguage();
		generateDisplayName();
		generatePreferedName();
		generateBirthName();
		generateMaritalStatusSince();
		generateDependent();
		generateEmail();
		generateNationalInfo(); 
		generatePersonalPhone();
		generateEmergencyContact();
		
		return new Employee(suffix, maritalStatus, nativePreferedLanguage, displayName, preferedName,
				birthName, prefix, maritalStatusSince, person, nationalInfo, dependent, email, businessEmail,
				personalPhone, businessPhone, emergencyContact);
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
		// New firstname -> true/false
		if (preferedName != null ) {
			return;
		}
		
		preferedName = baseProducer.trueOrFalse() ? dataMaster.getValuesOfType(FIRST_NAME, person.getSex().name(), String.class) : "";
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
	public void generateDependent() {
		if (dependent != null) {
			return;
		}
		dependent = dependentProvider.get();
	}
	public void generateEmail() {
		String emailAddress;
		boolean bool;
		if (email != null) {
			return;
		}
		//Check if employee has businessEmail or not
//		if (bool = baseProducer.trueOrFalse()) {
//			emailAddress = TextUtils.stripAccents(lowerCase(person.getFirstName() + '.' + person.getLastName() + 
//													'@' + /*job.getCompany()*/ "exaserv.com")).replaceAll(" ", "");
//			bool = true;
//			businessEmail = new BusinessEmail(emailAddress, bool);
//			//If there is a business mail, check there's also a personal mail
//			if (baseProducer.trueOrFalse()) {
//				emailAddress = TextUtils.stripAccents(lowerCase(person.getFirstName() + '.' + person.getLastName() +
//														'@' + dataMaster.getRandomValue(PERSONAL_EMAIL))).replaceAll(" ", "");
//				bool = false;
//				email = new PersonalEmail(emailAddress, bool);
//			} 
//		//If there's no business mail, create a personal mail 
//		} else {
			emailAddress = TextUtils.stripAccents(lowerCase(person.getFirstName() + '.' + person.getLastName() +
													'@' + dataMaster.getRandomValue(PERSONAL_EMAIL))).replaceAll(" ", "");
			bool = true;
			email = new PersonalEmail(emailAddress, bool);
//		}
		
	}
	
	public void generateNationalInfo() {
		if (nationalInfo != null) {
			return;
		}
		String type = dataMaster.getRandomValue(NATIONAL_ID_TYPE);
		boolean bool = true;
		String country = dataMaster.getRandomValue(COUNTRY);
		nationalInfo = new NationalInfo(country, type, bool);
	}

	public void generatePersonalPhone() {
		if (personalPhone != null) {
			return;
		}
		String country = dataMaster.getRandomValue(COUNTRY_CODE);
		// Only for business phone in future update
//		String ext = "";
//		if (baseProducer.trueOrFalse()) {
//			for (int i = 0;  i<3; i++) {
//				Integer r = baseProducer.randomBetween(1, 9);
//				ext += r.toString();
//				}
//		}
//		String number = country + " " + this.person.getTelephoneNumber().toString();
//		if (ext != "") number += " Ext. " + ext;
		
		String number = country + " " + this.person.getTelephoneNumber().toString();
		personalPhone = new PersonalPhone(country, number, true);
	}
	
	public void generateEmergencyContact() {
		if (emergencyContact != null) {
			return;
		}
		Person person = Fairy.builder().withFilePrefix(Globals.LOC).build().person();
		String rel = dataMaster.getValuesOfType(RELATIONSHIP, "emergency", String.class);
		String tel = dataMaster.getRandomValue(COUNTRY_CODE) + " " + person.getTelephoneNumber();
		emergencyContact = new EmergencyContact(person, rel, tel, true);
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
	public void setNationalInfo(NationalInfo nationalInfo) {
		// TODO Auto-generated method stub
		this.nationalInfo = nationalInfo;
	}
	public void setDependent(Dependent dependent) {
		// TODO Auto-generated method stub
		this.dependent = dependent;
	}
	public void setEmailType(String emailType) {
		this.email.setEmailType(emailType);
	}
	public void setEmailAddress(String emailAddress) {
		this.email.setEmailAddress(emailAddress);
	}
	public void setEmailIsPrimary(boolean isPrimary) {
		this.email.setPrimary(isPrimary);
	}
	public void setEmergencyContact(EmergencyContact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

}
