package com.deets.test_automation.test_data_generator.Locale;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.Dependent.AbstractDependent;
import com.devskiller.jfairy.producer.person.Person;

public class EnDependent extends AbstractDependent {

	public EnDependent(Person person, String relationship, LocalDate date) {
		super(person, relationship, date);
	}
	
}
