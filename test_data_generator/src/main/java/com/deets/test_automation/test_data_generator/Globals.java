package com.deets.test_automation.test_data_generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.deets.test_automation.test_data_generator.Employee.Employee;
import com.opencsv.CSVReader;

public class Globals {
	
	public static String LOC;

	public static ArrayList<DemoCSVObject> integrated = new ArrayList<DemoCSVObject>();
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	public static SettingsPage settings;
	public static String area;
	public static String timezone;
	public static String IDarea;
	public static List<CSVRecord> list;
	public static List<DemoCSVObject> demos = new ArrayList<DemoCSVObject>();
	public static DemoCSVObject demo;
	public static void readList() throws IOException {
		final InputStream in = TestDataGenerator.class.getClass().getResourceAsStream("/" + Globals.LOC + ".csv");
		//final String CSV_PATH = "src/main/resources/" + Globals.LOC + ".csv";
		try (	Reader reader = new BufferedReader(new InputStreamReader(in));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader());
				) {
		list = csvParser.getRecords();
		}
	}
	public static void readIntegrationCSV(String path) throws IOException {
		List<List<String>> records = new ArrayList<List<String>>();
		try (CSVReader csvReader = new CSVReader(new FileReader(path));) {
		    String[] values = csvReader.readNext();
		    while ((values = csvReader.readNext()) != null) {
		        records.add(Arrays.asList(values));
		        for ( List<String> record : records) {
		        	demo = new DemoCSVObject(record);
		        	demos.add(demo);
		        }
		    }
		}
		
	}
	
}
