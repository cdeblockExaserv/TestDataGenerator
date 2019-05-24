package com.deets.test_automation.test_data_generator.Employee.NationalInfo;

import java.time.LocalDate;

import com.devskiller.jfairy.producer.person.Person.Sex;
import com.google.inject.Provider;

public interface NationalInfoProvider extends Provider<NationalInfo>{

	NationalInfo get(Sex sex, LocalDate dateOfBirth);
	

	
}
