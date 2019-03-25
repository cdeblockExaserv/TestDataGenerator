package com.deets.test_automation.test_data_generator.Employee;

import com.google.inject.Provider;

public interface DependentProvider extends Provider<Dependent>{
	
	Dependent get();

}
