package com.deets.test_automation.test_data_generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

import com.deets.test_automation.test_data_generator.Employee.Employee;
import com.deets.test_automation.test_data_generator.Fairy.Fairy;

public class TestDataGenerator {
	DocumentBuilderFactory docFactory;
	DocumentBuilder docBuilder;
	static org.w3c.dom.Document doc;
	org.w3c.dom.Element rootElementParent;
	static Locale loc;
	
	public static void main(String[] args) throws Throwable {
		
		final Date timestamp = new Date();
		final SimpleDateFormat dateFormat = 
				new SimpleDateFormat("yyMMdd_hhmmss");
		TestDataGenerator generator = new TestDataGenerator();
		generator.TestDataGeneratorInit();
		boolean option = true;
		while (option) {
			System.out.println("Welcome to Exaserv Test Data Generator!!");
			Integer employeesCount = generator.getEmployeesCount("Please enter the number of employees to be generated");
			loc = generator.getLocale("Please choose the nationality of the employees");
			for(int i=0;i<employeesCount;i++){
				generator.generateEmployee(loc);
			}
			option = generator.getOption("Would you like to create employees for another country? (Y/N)");
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("OutputFiles/TestDataOutput" + dateFormat.format(timestamp).toString() + ".xml"));
		transformer.transform(domSource, result);
		// CSV
		File stylesheet = new File("src/main/resources/style.xsl");
		File xmlSource = new File("OutputFiles/TestDataOutput" + dateFormat.format(timestamp).toString() + ".xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlSource);
		StreamSource stylesource = new StreamSource(stylesheet);
        transformer = TransformerFactory.newInstance()
                .newTransformer(stylesource);
        Source source = new DOMSource(document);
        Result outputTarget = new StreamResult(new File("OutputFiles/TestDataOutput"+ dateFormat.format(timestamp).toString() +".csv"));
        transformer.transform(source, outputTarget);
		System.out.println("Files saved!");		
	}
	
	public void TestDataGeneratorInit() throws Throwable{
		docFactory = DocumentBuilderFactory.newInstance();
		docBuilder = docFactory.newDocumentBuilder();
	    doc = docBuilder.newDocument();
	    rootElementParent = doc.createElement("Employees");
	    doc.appendChild(rootElementParent);
	}
	
	public org.w3c.dom.Element createElement(String tag, String value){
		org.w3c.dom.Element Employee = doc.createElement(tag);
		if(value != null){
			Employee.appendChild(doc.createTextNode(value));
		}
		return Employee;
	}
	
	public org.w3c.dom.Element appendChild(org.w3c.dom.Element elementToInsert,org.w3c.dom.Element elementRoot){
		elementRoot.appendChild(elementToInsert);
		return elementToInsert;
	}
	
	public void generateBiographicalData(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("BiographicalData",""),employeeNode);
		appendChild(createElement("EmployeeID",employee.getEmployeeID().toString()),segmentNode);
		appendChild(createElement("DateOfBirth",employee.person.getDateOfBirth().toString()),segmentNode);
		appendChild(createElement("FirstName",employee.person.getFirstName()),segmentNode);
		appendChild(createElement("MiddleName",employee.person.getMiddleName()),segmentNode);
		appendChild(createElement("LastName",employee.person.getLastName()),segmentNode);
		appendChild(createElement("Prefix",employee.getPrefix()),segmentNode);
		appendChild(createElement("Suffix",employee.getSuffix()),segmentNode);
		appendChild(createElement("Gender",employee.person.getSex().toString()),segmentNode);
		appendChild(createElement("DisplayName",employee.getDisplayName()),segmentNode);
		appendChild(createElement("BirthName",employee.getBirthName()),segmentNode);
		appendChild(createElement("PreferedName",employee.getPreferedName()),segmentNode);
		appendChild(createElement("MaritalStatus",employee.getMaritalStatus()),segmentNode);
		appendChild(createElement("MaritalStatusSince",employee.getMaritalStatusSince().toString()),segmentNode);
		appendChild(createElement("Nationality",loc.getCountry()),segmentNode);
		//For Test CSV -Email
		appendChild(createElement("EmailAddress", employee.getEmail().getEmailAddress()), segmentNode);
		appendChild(createElement("EmailType",employee.getEmail().getEmailType()),segmentNode);
		appendChild(createElement("EmailIsPrimary", "true"), segmentNode);
		// -Address
		appendChild(createElement("Line1",employee.getAddress().getAddressLine1()),segmentNode);
		appendChild(createElement("Line2",employee.getAddress().getAddressLine2()),segmentNode);
		appendChild(createElement("ApartmentNumber",employee.getAddress().getApartmentNumber()),segmentNode);
		appendChild(createElement("City",employee.getAddress().getCity()),segmentNode);
		appendChild(createElement("ZipCode",employee.getAddress().getPostalCode()),segmentNode);
		appendChild(createElement("Country",employee.getAddress().getCountry()),segmentNode);
		appendChild(createElement("AddressType",employee.getAddress().getAddressType()),segmentNode);
		appendChild(createElement("State",employee.getAddress().getState()),segmentNode);
		// -Dependent
		//appendChild(createElement("Date",employee.getDependent().getDate().toString()),segmentNode);
		appendChild(createElement("Relationship",employee.getDependent().getRelationship()),segmentNode);
		appendChild(createElement("DependentDateOfBirth",employee.getDependent().getPerson().getDateOfBirth().toString()),segmentNode);
		appendChild(createElement("DependentFirstName",employee.getDependent().getPerson().getFirstName()),segmentNode);
		appendChild(createElement("DependentMiddleName",employee.getDependent().getPerson().getMiddleName()),segmentNode);
		appendChild(createElement("DependentLastName",employee.getDependent().getPerson().getLastName()),segmentNode);
		// -NationalInfo
		appendChild(createElement("NationalIDNumber",employee.person.getNationalIdentityCardNumber()),segmentNode);
		appendChild(createElement("NationalIDType",employee.getNationalinfo().getNationalIDType()),segmentNode);
		appendChild(createElement("Country",employee.getNationalinfo().getCountry()),segmentNode);
		appendChild(createElement("NationalIDIsPrimary","true"),segmentNode);
		// -PersonalPhone
		appendChild(createElement("CountryCode",employee.getPersonalPhone().getCountryCode()),segmentNode);
		//appendChild(createElement("Extension",employee.getPersonalPhone().getExtension()),segmentNode); -> businessPhone only
		appendChild(createElement("PersonalPhoneNumber",employee.getPersonalPhone().getPhoneNumber()),segmentNode);
		appendChild(createElement("PhoneIsPrimary","true"),segmentNode);
		// -EmergencyContact
		appendChild(createElement("EmergencyContactName",employee.person.getFullName()),segmentNode);
		appendChild(createElement("EmergencyContactRelationship",employee.getEmergencyContact().getRelationship()),segmentNode);
		appendChild(createElement("EmergencyContactMail",employee.person.getEmail()),segmentNode);
		appendChild(createElement("EmergencyContactPhone",employee.getEmergencyContact().getTelephone()),segmentNode);
		appendChild(createElement("EmergencyContactIsPrimary","true"),segmentNode);
	
	}
	
//	public void generateEmail(Employee employee, org.w3c.dom.Element employeeNode) {
//		org.w3c.dom.Element segmentNode = appendChild(createElement("EmailInformation",""),employeeNode);
//		
//		appendChild(createElement("EmailAddress", employee.getEmail().getEmailAddress()), segmentNode);
//		appendChild(createElement("EmailType",employee.getEmail().getEmailType()),segmentNode);
//		appendChild(createElement("EmailIsPrimary", "true"), segmentNode);
//		
//		if (employee.getEmail() != null) {
//			appendChild(createElement("EmailAddress",employee.getEmail().getEmailAddress()),segmentNode);
//			appendChild(createElement("EmailType",employee.getEmail().getEmailType()),segmentNode);
//			if (employee.getEmail().isPrimary() == true) {
//				appendChild(createElement("EmailIsPrimary","true"),segmentNode);
//			} else {
//				appendChild(createElement("EmailIsPrimary","false"),segmentNode);
//			}
//		}
//		if (employee.getBusinessEmail() != null) {
//			appendChild(createElement("BusinessEmailAddress",employee.getBusinessEmail().getEmailAddress()),segmentNode);
//			appendChild(createElement("EmailType",employee.getBusinessEmail().getEmailType()),segmentNode);
//			if (employee.getBusinessEmail().isPrimary() == true) {
//				appendChild(createElement("EmailIsPrimary","true"),segmentNode);
//			} else {
//				appendChild(createElement("EmailIsPrimary","false"),segmentNode);
//			}
//		}
//	}
	
//	public void generateAddress(Employee employee,org.w3c.dom.Element employeeNode){
//		org.w3c.dom.Element segmentNode = appendChild(createElement("Address",""),employeeNode);
//		appendChild(createElement("Line1",employee.person.getAddress().getAddressLine1()),segmentNode);
//		appendChild(createElement("Line2",employee.person.getAddress().getAddressLine2()),segmentNode);
//		appendChild(createElement("ApartmentNumber",employee.person.getAddress().getApartmentNumber()),segmentNode);
//		appendChild(createElement("City",employee.person.getAddress().getCity()),segmentNode);
//		appendChild(createElement("ZipCode",employee.person.getAddress().getPostalCode()),segmentNode);
//		
//	}
	
//	public void generateDependent(Employee employee,org.w3c.dom.Element employeeNode){
//		org.w3c.dom.Element segmentNode = appendChild(createElement("Dependent",""),employeeNode);
//		appendChild(createElement("Date",employee.getDependent().getDate().toString()),segmentNode);
//		appendChild(createElement("Relationship",employee.getDependent().getRelationship()),segmentNode);
//		appendChild(createElement("DateOfBirth",employee.getDependent().getPerson().getDateOfBirth().toString()),segmentNode);
//		appendChild(createElement("FirstName",employee.getDependent().getPerson().getFirstName()),segmentNode);
//		appendChild(createElement("MiddleName",employee.getDependent().getPerson().getMiddleName()),segmentNode);
//		appendChild(createElement("LastName",employee.getDependent().getPerson().getLastName()),segmentNode);
//	}
//	

//	public void generateNationalInfo(Employee employee,org.w3c.dom.Element employeeNode){
//		org.w3c.dom.Element segmentNode = appendChild(createElement("NationalIdInfo",""),employeeNode);
//		appendChild(createElement("NationalIDNumber",employee.person.getNationalIdentificationNumber()),segmentNode);
//		appendChild(createElement("NationalIDType",employee.getNationalinfo().getNationalIDType()),segmentNode);
//		appendChild(createElement("Country",employee.getNationalinfo().getCountry()),segmentNode);
//		appendChild(createElement("IsPrimary","true"),segmentNode);
//		
//	}
	
//	public void generatePersonalPhone(Employee employee,org.w3c.dom.Element employeeNode){
//	org.w3c.dom.Element segmentNode = appendChild(createElement("PersonalPhone",""),employeeNode);
//	appendChild(createElement("CountryCode",employee.getPersonalPhone().getCountryCode()),segmentNode);
//	appendChild(createElement("Extension",employee.getPersonalPhone().getExtension()),segmentNode);
//	appendChild(createElement("PersonalPhoneNumber",employee.getPersonalPhone().getPhoneNumber()),segmentNode);
//	appendChild(createElement("PersonalPhoneIsPrimary","true"),segmentNode);
//	
//}
	
	public void generateJobInfo(Employee employee,org.w3c.dom.Element employeeNode){
	org.w3c.dom.Element segmentNode = appendChild(createElement("JobInfo",""),employeeNode);
	appendChild(createElement("Incumbent",employee.getJob().getIncumbent()),segmentNode);
	appendChild(createElement("Position",employee.getJob().getPosition()),segmentNode);
	appendChild(createElement("PositionEntryDate",employee.getJob().getPositionEntryDate().toString()),segmentNode);
	appendChild(createElement("Company",employee.getJob().getCompany()),segmentNode);
	appendChild(createElement("BusinessUnit",employee.getJob().getBusinessUnit()),segmentNode);
	appendChild(createElement("Division",employee.getJob().getDivision()),segmentNode);
	appendChild(createElement("Department",employee.getJob().getDepartment()),segmentNode);
	appendChild(createElement("Location",employee.getJob().getLocation()),segmentNode);
	appendChild(createElement("CostCenter",employee.getJob().getCostCenter()),segmentNode);
	appendChild(createElement("TimeZone",employee.getJob().getTimezone()),segmentNode);
	appendChild(createElement("Supervisor",employee.getJob().getSupervisor()),segmentNode);
	appendChild(createElement("JobClassification",employee.getJob().getJobClassification()),segmentNode);
	appendChild(createElement("PositionTitle",employee.getJob().getPositionTitle()),segmentNode);
	appendChild(createElement("LocalJobTitle",employee.getJob().getLocalJobTitle()),segmentNode);
	appendChild(createElement("PayGrade",employee.getJob().getPayGrade()),segmentNode);
	if(employee.getJob().getIsRegular()) {
		appendChild(createElement("IsRegular", "true"),segmentNode);
	} else {
		appendChild(createElement("IsRegular", "false"),segmentNode);
	}
	appendChild(createElement("StandardWeeklyHours",employee.getJob().getStandardWeeklyHours().toString()),segmentNode);
	appendChild(createElement("FTE",employee.getJob().getFTE().toString()),segmentNode);
	if(employee.getJob().getIsFulltime()) {
		appendChild(createElement("IsFulltime", "true"),segmentNode);
	} else {
		appendChild(createElement("IsFulltime", "false"),segmentNode);
	}
	appendChild(createElement("EmployeeClass",employee.getJob().getEmployeeClass()),segmentNode);
	appendChild(createElement("ShiftCode",employee.getJob().getShiftCode()),segmentNode);
	appendChild(createElement("FSLAStatus",employee.getJob().getFSLA_status()),segmentNode);
	appendChild(createElement("JobEntryDate",employee.getJob().getJobEntryDate().toString()),segmentNode);
	appendChild(createElement("LeaveOfAbsenceStartDate",employee.getJob().getLeaveOfAbsenceStartDate().toString()),segmentNode);
	appendChild(createElement("LeaveOfAbsenceReturnDate",employee.getJob().getLeaveOfAbsenseReturnDate().toString()),segmentNode);
	appendChild(createElement("LMSJobCodeID",employee.getJob().getLMS_jobCodeID().toString()),segmentNode);
	appendChild(createElement("EEOJobGroup",employee.getJob().getEEO_jobGroup()),segmentNode);
	appendChild(createElement("EEOCategory1",employee.getJob().getEeoCategory1()),segmentNode);
	appendChild(createElement("EEOCategory4",employee.getJob().getEeoCategory4()),segmentNode);
	appendChild(createElement("EEOCategory5",employee.getJob().getEeoCategory5()),segmentNode);
	appendChild(createElement("EEOCategory6",employee.getJob().getEeoCategory6()),segmentNode);
	
}
	
	public void generateEmployee(Locale loc){
		//Person person;
		Employee employee;
		if (loc == Locale.US) {
			//person = Fairy.builder().withFilePrefix("us").build().person() ;
			Globals.LOC = "us";
			employee = Fairy.builder().withFilePrefix("us").build().employee();
		} else if (loc == Locale.CANADA_FRENCH) {
			//person = Fairy.builder().withFilePrefix("ca").build().person();
			Globals.LOC = "ca";
			employee = Fairy.builder().withFilePrefix("ca").build().employee();
		}else if(loc == Locale.UK) { 
			//person = Fairy.builder().withFilePrefix("uk").build().person();
			Globals.LOC = "uk";
			employee = Fairy.builder().withFilePrefix("uk").build().employee();
		}else if(loc == Locale.FRANCE) {
			//person = Fairy.builder().withFilePrefix("fr").build().person();
			Globals.LOC = "fr";
			employee = Fairy.builder().withFilePrefix("fr").build().employee();
		}else {
			//person = Fairy.builder().withFilePrefix("us").build().person();
			Globals.LOC = "us";
			employee = Fairy.builder().withFilePrefix("us").build().employee();
		}
		Globals.Employees.add(employee);
		//Person person = Fairy.builder().withLocale(loc).withFilePrefix("test").build().person();
		org.w3c.dom.Element employeeNode = appendChild(createElement("Employee",""),rootElementParent);
		generateBiographicalData(employee,employeeNode);
		generateJobInfo(employee, employeeNode);
//		generateAddress(employee,employeeNode);
//		generateDependent(employee,employeeNode);
//		generateEmail(employee, employeeNode);
//		generateNationalInfo(employee, employeeNode);
		//System.out.println(person.getAddress());
	}
	
	public Integer getEmployeesCount(String prompt){
		String inputLine = null;
	
		System.out.println(prompt + " ");
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) return null;
		}
		catch (IOException e){
			System.out.println("IOException: " + e);
		}
		return Integer.parseInt(inputLine);
		
	}
	
	public Locale getLocale(String prompt){
		String inputLine = null;
		
		System.out.println(prompt + " ");
		System.out.println("1. USA");
		System.out.println("2. France");
//		System.out.println("3. UK");
//		System.out.println("4. Canada");
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) return null;
		}
		catch (IOException e){
			System.out.println("IOException: " + e);
		}
		switch(Integer.parseInt(inputLine)){
		case 1:
			loc = Locale.US;
			break;
		case 2:
			loc = Locale.FRANCE;
			break;
//		case 3:
//			loc = Locale.UK;
//			break;
//		case 4:
//			loc = Locale.CANADA_FRENCH;
//			break;
		default:
			loc = Locale.US;
			break;
		}
		return loc;
	}
	
	public boolean getOption(String prompt) {
		String inputLine = null;
	
		System.out.println(prompt);
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			
		}catch (IOException e){
			System.out.println("IOException: " + e);
		}
		if (inputLine.equals("Y") || inputLine.equals("y")) {
			return true;
		} else if (inputLine.equals("N") || inputLine.equals("n")) {
			return false;
		} else return false;
	}
	
}
