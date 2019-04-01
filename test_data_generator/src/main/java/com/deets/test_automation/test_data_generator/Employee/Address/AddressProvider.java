package com.deets.test_automation.test_data_generator.Employee.Address;

import com.google.inject.Provider;

public interface AddressProvider extends Provider<Address>{
	
	Address get();

}
