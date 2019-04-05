package com.deets.test_automation.test_data_generator.Dependent;

import java.time.LocalDate;

import com.google.inject.Provider;

public interface DependentProvider extends Provider<Dependent>{
	
	Dependent get();
	
	Dependent get(LocalDate dateOfBirth);

}
