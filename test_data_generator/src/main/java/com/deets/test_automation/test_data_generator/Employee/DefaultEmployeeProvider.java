package com.deets.test_automation.test_data_generator.Employee;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList; 
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.deets.test_automation.test_data_generator.Dictionary;
import com.deets.test_automation.test_data_generator.Globals;
import com.deets.test_automation.test_data_generator.SettingsPage;
import com.deets.test_automation.test_data_generator.Dependent.Dependent;
import com.deets.test_automation.test_data_generator.Dependent.DependentProvider;
import com.deets.test_automation.test_data_generator.Employee.Address.Address;
import com.deets.test_automation.test_data_generator.Employee.Address.AddressProvider;
import com.deets.test_automation.test_data_generator.Employee.Email.Email;
import com.deets.test_automation.test_data_generator.Employee.Email.EmailProvider;
import com.deets.test_automation.test_data_generator.Employee.EmergencyContact.EmergencyContact;
import com.deets.test_automation.test_data_generator.Employee.NationalInfo.NationalInfo;
import com.deets.test_automation.test_data_generator.Employee.Phone.Phone;
import com.deets.test_automation.test_data_generator.Employee.Phone.PhoneProvider;
import com.deets.test_automation.test_data_generator.Fairy.Fairy;
import com.deets.test_automation.test_data_generator.Job.JobProvider;
import com.deets.test_automation.test_data_generator.Job.Job;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.person.Person;
import com.google.inject.assistedinject.Assisted;

public class DefaultEmployeeProvider implements EmployeeProvider {
	
	protected String employeeID;
	protected Integer age;
	protected LocalDate dateOfBirth;
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
	protected Email email;
	protected Phone phone;
	protected EmergencyContact emergencyContact;
	protected Address address;
	protected Job job;
	protected CustomField customField1;
	protected CustomField customField2;
	protected CustomField customField3;
	protected CustomField customField4;
	protected CustomField customField5;
	protected CustomField customField6;
	protected CustomField customField7;
	protected CustomField customField8;
	protected CustomField customField9;
	protected CustomField customField10;
	
	
	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	protected final DateProducer dateProducer;
	protected final EmailProvider emailProvider;
	protected final PhoneProvider phoneProvider;
	protected final DependentProvider dependentProvider;
	protected final AddressProvider addressProvider;
	protected final JobProvider JobProvider;
	protected final Dictionary dictionary;
	protected JAXBContext context;
	protected Unmarshaller unmarshaller;
	
	private ArrayList<String> numbers = new ArrayList<String>();

	@Inject
	public DefaultEmployeeProvider(BaseProducer baseProducer, DataMaster dataMaster,
			DateProducer dateProducer, DependentProvider dependentProvider,
			AddressProvider addressProvider, JobProvider JobProvider,
			EmailProvider emailProvider, PhoneProvider phoneProvider,
			@Assisted EmployeeProperties.EmployeeProperty... employeeProperties) {
		
		this.baseProducer = baseProducer;
		//this.person = Fairy.builder().withFilePrefix(loc).build().person();
		this.dataMaster = dataMaster;
		this.dateProducer = dateProducer;
		this.dependentProvider = dependentProvider;
		this.addressProvider = addressProvider;
		this.JobProvider = JobProvider;
		this.emailProvider = emailProvider;
		this.phoneProvider = phoneProvider;
		dictionary = new Dictionary();
		try {
			context = JAXBContext.newInstance(SettingsPage.class);
			unmarshaller = context.createUnmarshaller();
			Globals.settings = (SettingsPage) unmarshaller.unmarshal(new File("src/main/resources/toGenerate.xml"));
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		for (EmployeeProperties.EmployeeProperty employeeProperty : employeeProperties) {
			employeeProperty.apply(this, baseProducer);
		}
		
		for (Integer i = 1; i < 10; i++) {
			numbers.add(i.toString());
		}
		
	}
	
	public Employee get() {
		this.person = Fairy.builder().withFilePrefix(Globals.LOC).build().person();
		
		generateAge();
		generateDateOfBirth();
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
		generatePhone();
		generateEmergencyContact();
		generateAddress();
		generateJob();
		generateCustomFields();
		
		return new Employee(age, dateOfBirth, suffix, maritalStatus, nativePreferedLanguage, displayName, preferedName,
				birthName, prefix, maritalStatusSince, person, nationalInfo, dependent, email,
				phone, emergencyContact, address, job, customField1, customField2, customField3, customField4,
				customField5, customField6, customField7, customField8, customField9, customField10, dataMaster);
	}
	
	public void generateAge() {
		
		if (!Globals.settings.isAge()) { return; }
		age = baseProducer.randomBetween(Integer.valueOf(dataMaster.getRandomValue(MIN_AGE)),
				Integer.valueOf(dataMaster.getRandomValue(MAX_AGE)));		
	}
	public void generateDateOfBirth() {
	
		if (!Globals.settings.isDateOfBirth()) { return; }
		if (age == null) { return; }
			LocalDate maxDate = LocalDate.now().minusYears(age);
			LocalDate minDate = maxDate.minusYears(1).plusDays(1);
			dateOfBirth = dateProducer.randomDateBetweenTwoDates(minDate, maxDate);
	}
	public void generateSuffix() {
		
		if (!Globals.settings.isSuffix()) { suffix = ""; }
		
		suffix = baseProducer.trueOrFalse() ? dataMaster.getRandomValue(SUFFIX) : "";
	}
	public void generateMaritalStatus() {
	
		if (!Globals.settings.isMaritalStatus()) { maritalStatus = ""; }
		
		maritalStatus = dataMaster.getRandomValue(MARITAL_STATUS);
	}
	public void generateNativePreferedLanguage() {

		if (!Globals.settings.isNativePreferedLanguage()) { nativePreferedLanguage = ""; }
		
		nativePreferedLanguage = dataMaster.getRandomValue(NATIVE_PREFERED_LANGUAGE);
	}
	public void generateDisplayName() {

		if (!Globals.settings.isDisplayName()) { displayName = ""; }
		
		//With or without prefix/suffix?
		displayName = prefix + " " + person.getFullName() + " " + suffix;
	}
	public void generatePreferedName() {

		// New firstname -> true/false
		if (!Globals.settings.isPreferedName()) {
			preferedName = "";
		}
		
		preferedName = baseProducer.trueOrFalse() ? dataMaster.getValuesOfType(FIRST_NAME, person.getSex().name(), String.class) : "";
	}
	public void generateBirthName() {
	
		if (!Globals.settings.isBirthName()) { birthName = ""; }
		
		birthName = prefix + " " + person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName() + " " + suffix;
	}
	public void generatePrefix() {

		if (!Globals.settings.isPrefix()) { prefix = ""; }
		else {		
		prefix = baseProducer.trueOrFalse() ? dataMaster.getValuesOfType(PREFIX, person.getSex().name(), String.class) : "";
		}
	}
		
	public void generateMaritalStatusSince() {

		if (!Globals.settings.isMaritalStatus()) {
			return;
		}
		if (dictionary.getMaritalStateValue(maritalStatus) == "Single") {
			maritalStatusSince = dateOfBirth;
		} else {
			maritalStatusSince = dateProducer.randomDateBetweenTwoDates(dateOfBirth.plusYears(18).minusDays(1), LocalDate.now());
		}
	}
	public void generateDependent() {
		dependent = dependentProvider.get(dateOfBirth);
	}
	public void generateEmail() {
		email = emailProvider.get(person);
	}
	
	public void generateNationalInfo() {
		nationalInfo = new NationalInfo(person, dataMaster);
	}

	public void generatePhone() {
		phone = phoneProvider.get();		
	}
	
	public void generateEmergencyContact() {
		emergencyContact = new EmergencyContact(dataMaster);
	}
	public void generateAddress() {
		address = addressProvider.get();
	}
	public void generateJob() {
		job = JobProvider.get(dateOfBirth);
	}
	public void generateCustomFields() {
		if (Globals.settings.isCustomField1()) {
			customField1 = new CustomField(baseProducer, dataMaster, dateProducer, "1");
		} else customField1 = null;
		if (Globals.settings.isCustomField2()) {
			customField2 = new CustomField(baseProducer, dataMaster, dateProducer, "2");
			} else customField2 = null;
		if (Globals.settings.isCustomField3()) {
			customField3 = new CustomField(baseProducer, dataMaster, dateProducer, "3");
			} else customField3 = null;
		if (Globals.settings.isCustomField4()) {
			customField4 = new CustomField(baseProducer, dataMaster, dateProducer, "4");
			} else customField4 = null;
		if (Globals.settings.isCustomField5()) {
			customField5 = new CustomField(baseProducer, dataMaster, dateProducer, "5");
			} else customField5 = null;
		if (Globals.settings.isCustomField6()) {
			customField6 = new CustomField(baseProducer, dataMaster, dateProducer, "6");
			} else customField6 = null;
		if (Globals.settings.isCustomField7()) {
			customField7 = new CustomField(baseProducer, dataMaster, dateProducer, "7");
			} else customField7 = null;
		if (Globals.settings.isCustomField8()) {
			customField8 = new CustomField(baseProducer, dataMaster, dateProducer, "8");
			} else customField8 = null;
		if (Globals.settings.isCustomField9()) {
			customField9 = new CustomField(baseProducer, dataMaster, dateProducer, "9");
			} else customField9 = null;
		if (Globals.settings.isCustomField10()) {
			customField10 = new CustomField(baseProducer, dataMaster, dateProducer, "10");
			} else customField10 = null;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	public void setAddress(Address address) {

		this.address = address;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
