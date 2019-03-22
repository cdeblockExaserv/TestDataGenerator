package com.deets.test_automation.test_data_generator.Employee;

public interface EmployeeFactory {

	EmployeeProvider produceEmployeeProvider(EmployeeProperties.EmployeeProperty... employeeProperties);
	
}
