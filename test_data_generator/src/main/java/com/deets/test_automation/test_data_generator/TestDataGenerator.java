package com.deets.test_automation.test_data_generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
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
				new SimpleDateFormat("yyMMdd_HHmmss");
		TestDataGenerator generator = new TestDataGenerator();
		generator.TestDataGeneratorInit();
		boolean option = true;
		System.out.println("Welcome to Exaserv Test Data Generator!!");
		while (option) {
			Integer employeesCount = generator.getEmployeesCount("Please enter the number of employees to be generated");
			loc = generator.getLocale("Please choose the nationality of the employees");
			Globals.readList();
			try {
				JAXBContext context;
				Unmarshaller unmarshaller;
				context = JAXBContext.newInstance(SettingsPage.class);
				unmarshaller = context.createUnmarshaller();
				Globals.settings = (SettingsPage) unmarshaller.unmarshal(TestDataGenerator.class.getClass().getResourceAsStream("/toGenerate.xml"));
				
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			for(int i=0;i<employeesCount;i++){
				generator.generateEmployee(loc);
			}
			option = generator.getOption("Would you like to create employees for another country? (Y/N)");
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(doc);
		File output = new File("/OutputFiles/");
		output.mkdir();
		StreamResult result = new StreamResult(output + "/TestDataOutput" + dateFormat.format(timestamp).toString() + ".xml");
		transformer.transform(domSource, result);
		generateCSV("Bio", transformer, dateFormat, timestamp);
		generateCSV("Address", transformer, dateFormat, timestamp);
		generateCSV("Dependent", transformer, dateFormat, timestamp);
		generateCSV("Email", transformer, dateFormat, timestamp);
		generateCSV("NationalId", transformer, dateFormat, timestamp);
		generateCSV("Phone", transformer, dateFormat, timestamp);
		generateCSV("Emergency", transformer, dateFormat, timestamp);
		generateCSV("JobInfo", transformer, dateFormat, timestamp);
//		generateCSV("Custom1", transformer, dateFormat, timestamp);
//		generateCSV("Custom2", transformer, dateFormat, timestamp);
//		generateCSV("Custom3", transformer, dateFormat, timestamp);
//		generateCSV("Custom4", transformer, dateFormat, timestamp);
//		generateCSV("Custom5", transformer, dateFormat, timestamp);
//		generateCSV("Custom6", transformer, dateFormat, timestamp);
//		generateCSV("Custom7", transformer, dateFormat, timestamp);
//		generateCSV("Custom8", transformer, dateFormat, timestamp);
//		generateCSV("Custom9", transformer, dateFormat, timestamp);
//		generateCSV("Custom10", transformer, dateFormat, timestamp);
		System.out.println("Files saved!");		
	}
	
	public static void generateCSV(String tag, Transformer transformer, SimpleDateFormat dateFormat, Date timestamp) throws Throwable { //CSV
		InputStream stylesheet = TestDataGenerator.class.getClass().getResourceAsStream("/style" + tag + ".xsl");
		File xmlSource = new File("/OutputFiles/TestDataOutput" + dateFormat.format(timestamp).toString() + ".xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlSource);
		StreamSource stylesource = new StreamSource(stylesheet);
        transformer = TransformerFactory.newInstance()
                .newTransformer(stylesource);
        Source source = new DOMSource(document);
        Result outputTarget = new StreamResult(/*new File("src/main/resources/*/"/OutputFiles/TestDataOutput_" + tag + dateFormat.format(timestamp).toString() +".csv");
        transformer.transform(source, outputTarget);
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
		appendChild(createElement("Age",employee.getAge().toString()),segmentNode);
		appendChild(createElement("DateOfBirth",employee.getDateOfBirth().toString()),segmentNode);
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
	}
	
	public void generateEmail(Employee employee, org.w3c.dom.Element employeeNode) {
		org.w3c.dom.Element segmentNode = appendChild(createElement("Email",""),employeeNode);
		appendChild(createElement("EmailAddress", employee.getEmail().getEmailAddress()), segmentNode);
		appendChild(createElement("Type",employee.getEmail().getEmailType()),segmentNode);
		appendChild(createElement("IsPrimary", "true"), segmentNode);
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
	}
	
	public void generateAddress(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("Address",""),employeeNode);
		appendChild(createElement("Line1",employee.getAddress().getAddressLine1()),segmentNode);
		appendChild(createElement("Line2",employee.getAddress().getAddressLine2()),segmentNode);
		appendChild(createElement("ApartmentNumber",employee.getAddress().getApartmentNumber()),segmentNode);
		appendChild(createElement("City",employee.getAddress().getCity()),segmentNode);
		appendChild(createElement("ZipCode",employee.getAddress().getPostalCode()),segmentNode);
		appendChild(createElement("Country",employee.getAddress().getCountry()),segmentNode);
		appendChild(createElement("AddressType",employee.getAddress().getAddressType()),segmentNode);
		appendChild(createElement("State",employee.getAddress().getState()),segmentNode);
	}
	
	public void generateDependent(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("Dependent",""),employeeNode);
		appendChild(createElement("Relationship",employee.getDependent().getRelationship()),segmentNode);
		appendChild(createElement("DateOfBirth",employee.getDependent().getDate().toString()),segmentNode);
		appendChild(createElement("FirstName",employee.getDependent().getFirstName()),segmentNode);
		appendChild(createElement("MiddleName",employee.getDependent().getMiddleName()),segmentNode);
		appendChild(createElement("LastName",employee.getDependent().getLastName()),segmentNode);
	}
	

	public void generateNationalInfo(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("NationalIdInfo",""),employeeNode);
		appendChild(createElement("Number",employee.person.getNationalIdentityCardNumber()),segmentNode);
		appendChild(createElement("Type",employee.getNationalinfo().getNationalIDType()),segmentNode);
		appendChild(createElement("Country",employee.getNationalinfo().getCountry()),segmentNode);
		appendChild(createElement("IsPrimary","true"),segmentNode);
	}
	
	public void generatePhone(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("Phone",""),employeeNode);
		appendChild(createElement("CountryCode",employee.getPhone().getCountryCode()),segmentNode);
		appendChild(createElement("AreaCode",employee.getPhone().getAreaCode()),segmentNode);
		//appendChild(createElement("Extension",employee.getPersonalPhone().getExtension()),segmentNode); -> businessPhone only
		appendChild(createElement("PhoneNumber",employee.getPhone().getPhoneNumber()),segmentNode);
		appendChild(createElement("IsPrimary","true"),segmentNode);
	}
	
	public void generateEmergencyContact(Employee employee,org.w3c.dom.Element employeeNode) {
		org.w3c.dom.Element segmentNode = appendChild(createElement("EmergencyContact",""),employeeNode);
		appendChild(createElement("Name",employee.getEmergencyContact().getName()),segmentNode);
		appendChild(createElement("Relationship",employee.getEmergencyContact().getRelationship()),segmentNode);
		appendChild(createElement("Mail",employee.getEmergencyContact().getMail()),segmentNode);
		appendChild(createElement("Phone",employee.getEmergencyContact().getTelephone()),segmentNode);
		appendChild(createElement("IsPrimary","true"),segmentNode);
	}
	
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
		appendChild(createElement("LeaveOfAbsenceReturnDate",employee.getJob().getLeaveOfAbsenceReturnDate().toString()),segmentNode);
		appendChild(createElement("LMSJobCodeID",employee.getJob().getLMS_jobCodeID().toString()),segmentNode);
		appendChild(createElement("EEOJobGroup",employee.getJob().getEEO_jobGroup()),segmentNode);
		appendChild(createElement("EEOCategory1",employee.getJob().getEeoCategory1()),segmentNode);
		appendChild(createElement("EEOCategory4",employee.getJob().getEeoCategory4()),segmentNode);
		appendChild(createElement("EEOCategory5",employee.getJob().getEeoCategory5()),segmentNode);
		appendChild(createElement("EEOCategory6",employee.getJob().getEeoCategory6()),segmentNode);
	}
	
	public void generateCustomField1(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("CustomField1",""),employeeNode);
		if (employee.getCustomField1() != null)
		appendChild(createElement(employee.getCustomField1().getFieldName(),employee.getCustomField1().getValue()),segmentNode);
	}
	public void generateCustomField2(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("CustomField2",""),employeeNode);
		if (employee.getCustomField2() != null)
		appendChild(createElement(employee.getCustomField2().getFieldName(),employee.getCustomField2().getValue()),segmentNode);
	}
	public void generateCustomField3(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("CustomField3",""),employeeNode);
		if (employee.getCustomField3() != null)
		appendChild(createElement(employee.getCustomField3().getFieldName(),employee.getCustomField3().getValue()),segmentNode);
	}
	public void generateCustomField4(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("CustomField4",""),employeeNode);
		if (employee.getCustomField4() != null)
		appendChild(createElement(employee.getCustomField4().getFieldName(),employee.getCustomField4().getValue()),segmentNode);
	}
	public void generateCustomField5(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("CustomField5",""),employeeNode);
		if (employee.getCustomField5() != null)
		appendChild(createElement(employee.getCustomField5().getFieldName(),employee.getCustomField5().getValue()),segmentNode);
	}
	public void generateCustomField6(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("CustomField6",""),employeeNode);
		if (employee.getCustomField6() != null)
		appendChild(createElement(employee.getCustomField6().getFieldName(),employee.getCustomField6().getValue()),segmentNode);
	}
	public void generateCustomField7(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("CustomField7",""),employeeNode);
		if (employee.getCustomField7() != null)
		appendChild(createElement(employee.getCustomField7().getFieldName(),employee.getCustomField7().getValue()),segmentNode);
	}
	public void generateCustomField8(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("CustomField8",""),employeeNode);
		if (employee.getCustomField8() != null)
		appendChild(createElement(employee.getCustomField8().getFieldName(),employee.getCustomField8().getValue()),segmentNode);
	}
	public void generateCustomField9(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("CustomField9",""),employeeNode);
		if (employee.getCustomField9() != null)
		appendChild(createElement(employee.getCustomField9().getFieldName(),employee.getCustomField9().getValue()),segmentNode);
	}
	public void generateCustomField10(Employee employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("CustomField10",""),employeeNode);
		if (employee.getCustomField10() != null)
		appendChild(createElement(employee.getCustomField10().getFieldName(),employee.getCustomField10().getValue()),segmentNode);
	}
	
	public void generateEmployee(Locale loc){
		Employee employee;
		if (loc == Locale.US) {
			employee = Fairy.builder().withFilePrefix("us").build().employee();
		} else if (loc == Locale.CANADA_FRENCH) {
			employee = Fairy.builder().withFilePrefix("ca").build().employee();
		}else if(loc == Locale.UK) { 
			employee = Fairy.builder().withFilePrefix("uk").build().employee();
		}else if(loc == Locale.FRANCE) {
			employee = Fairy.builder().withFilePrefix("fr").build().employee();
		}else {
			Globals.LOC = "us";
			employee = Fairy.builder().withFilePrefix("us").build().employee();
		}
		Globals.Employees.add(employee);
		org.w3c.dom.Element employeeNode = appendChild(createElement("Employee",""),rootElementParent);
		generateBiographicalData(employee,employeeNode);
		generateAddress(employee,employeeNode);
		generateDependent(employee,employeeNode);
		generateEmail(employee, employeeNode);
		generateNationalInfo(employee, employeeNode);
		generatePhone(employee, employeeNode);
		generateEmergencyContact(employee, employeeNode);
		generateJobInfo(employee, employeeNode);
		generateCustomField1(employee, employeeNode);
		generateCustomField2(employee, employeeNode);
		generateCustomField3(employee, employeeNode);
		generateCustomField4(employee, employeeNode);
		generateCustomField5(employee, employeeNode);
		generateCustomField6(employee, employeeNode);
		generateCustomField7(employee, employeeNode);
		generateCustomField8(employee, employeeNode);
		generateCustomField9(employee, employeeNode);
		generateCustomField10(employee, employeeNode);
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
			Globals.LOC = "us";
			break;
		case 2:
			loc = Locale.FRANCE;
			Globals.LOC = "fr";
			break;
//		case 3:
//			loc = Locale.UK;
//			Globals.LOC = "uk";
//			break;
//		case 4:
//			loc = Locale.CANADA_FRENCH;
//			Globals.LOC = "ca";
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
