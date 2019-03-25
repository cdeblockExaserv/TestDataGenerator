package com.deets.test_automation.test_data_generator.NationalInfo;

import java.time.LocalDate;

import com.devskiller.jfairy.producer.person.Country;
import com.google.inject.Provider;

public interface NationalInfoProvider extends Provider<NationalInfo>{
	
	NationalInfo get();
	
	void setCountry(Country country);

	void setIssueDate(LocalDate dateOfBirth);

}
