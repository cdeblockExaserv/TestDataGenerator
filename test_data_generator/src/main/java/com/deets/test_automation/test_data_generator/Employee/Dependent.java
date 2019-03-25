package com.deets.test_automation.test_data_generator.Employee;

import java.time.LocalDate;

import com.devskiller.jfairy.producer.person.Person;

public interface Dependent {
	
	Person getPerson();
	LocalDate getDate();
	String getRelationship();
}
