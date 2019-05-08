package com.deets.test_automation.test_data_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.deets.test_automation.test_data_generator.Employee.Employee;

public class Globals {
	
	public static String LOC;

	public static ArrayList<Employee> Employees = new ArrayList<Employee>();
	public static SettingsPage settings;
	public static String area;
	public static String timezone;
	public static List<CSVRecord> list;
	public static void readList() throws IOException {
		final InputStream in = TestDataGenerator.class.getClass().getResourceAsStream("/" + Globals.LOC + ".csv");
		//final String CSV_PATH = "src/main/resources/" + Globals.LOC + ".csv";
		try (	Reader reader = new BufferedReader(new InputStreamReader(in));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
				) {
		list = csvParser.getRecords();
		}
	}
	
}
