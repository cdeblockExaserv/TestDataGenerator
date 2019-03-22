package com.deets.test_automation.test_data_generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;

public class TestDataGenerator {
	DocumentBuilderFactory docFactory;
	DocumentBuilder docBuilder;
	static org.w3c.dom.Document doc;
	org.w3c.dom.Element rootElementParent;
	static Locale loc;
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		TestDataGenerator generator = new TestDataGenerator();
		generator.TestDataGeneratorInit();
		System.out.println("Welcome to Exaserv Test Data Generator!!");
		Integer employeesCount = generator.getEmployeesCount("Please enter the number of employees to be generated");
		loc = generator.getLocale("Please choose the nationality of the employees");
		for(int i=0;i<employeesCount;i++){
			generator.generateEmployee(loc);
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("OutputFiles/TestDataOutput.xml"));
		transformer.transform(source, result);
		System.out.println("File saved!");		
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
	public void generateBiographicalData(Person employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("BiographicalData",""),employeeNode);
		appendChild(createElement("DateofBirth",employee.getDateOfBirth().toString()),segmentNode);
		appendChild(createElement("FirstName",employee.getFirstName()),segmentNode);
		appendChild(createElement("Middlename",employee.getMiddleName()),segmentNode);
		appendChild(createElement("LastName",employee.getLastName()),segmentNode);
		appendChild(createElement("Gender",employee.getSex().toString()),segmentNode);
		appendChild(createElement("DisplayName",employee.getFullName()),segmentNode);
		appendChild(createElement("BirthName",employee.getFullName()),segmentNode);
		appendChild(createElement("MartialStatusSince",Fairy.create().dateProducer().randomDateInThePast(employee.getAge()).format(DateTimeFormatter.ofPattern("YYYY-MM-dd"))),segmentNode);
		appendChild(createElement("Nationality",loc.getCountry()),segmentNode);

	}
	public void generateAddress(Person employee,org.w3c.dom.Element employeeNode){
		org.w3c.dom.Element segmentNode = appendChild(createElement("Address",""),employeeNode);
		appendChild(createElement("Line1",employee.getAddress().getAddressLine1()),segmentNode);
		appendChild(createElement("Line2",employee.getAddress().getAddressLine2()),segmentNode);
		appendChild(createElement("ApartmentNumber",employee.getAddress().getApartmentNumber()),segmentNode);
		appendChild(createElement("City",employee.getAddress().getCity()),segmentNode);
		appendChild(createElement("ZipCode",employee.getAddress().getPostalCode()),segmentNode);
		
	}
	public void generateEmployee(Locale loc){
		Person person;
		
		if (loc == Locale.US) {
			person = Fairy.builder().withFilePrefix("us").build().person();
		} else if (loc == Locale.CANADA_FRENCH){
			person = Fairy.builder().withFilePrefix("ca").build().person();
		}else if(loc == Locale.UK) { 
			person = Fairy.builder().withFilePrefix("uk").build().person();
		}else if(loc == Locale.FRANCE) {
			person = Fairy.builder().withFilePrefix("fr").build().person();
		}else {
			person = Fairy.builder().withFilePrefix("us").build().person();
		}
		//Person person = Fairy.builder().withLocale(loc).withFilePrefix("test").build().person();
		org.w3c.dom.Element employeeNode = appendChild(createElement("Employee",""),rootElementParent);
		generateBiographicalData(person,employeeNode);
		generateAddress(person,employeeNode);
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
		System.out.println("2. Canada");
		System.out.println("3. UK");
		System.out.println("4. France");
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
			loc = Locale.CANADA_FRENCH;
			break;
		case 3:
			loc = Locale.UK;
			break;
		case 4:
			loc = Locale.FRANCE;
			break;
		default:
			loc = Locale.US;
			break;
		}
		return loc;
	}
	

}
