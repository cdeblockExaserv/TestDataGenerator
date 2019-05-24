package com.deets.test_automation.test_data_generator.Locale;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import com.deets.test_automation.test_data_generator.Globals;
import com.deets.test_automation.test_data_generator.Employee.Address.AbstractAddress;

public class EnAddress extends AbstractAddress {

	public EnAddress(String streetNumber, String street, String apartmentNumber, String city, String postalCode,
				String country, String addressType, String state) {
		super(street, streetNumber, apartmentNumber, city, postalCode, country, addressType, state);
	}

	@Override
	public String getAddressLine1() {
		if (Globals.settings.isAddressLine1()) {
			return streetNumber + " " + street
				+ (isNotBlank(apartmentNumber) ? " APT " + apartmentNumber : "");
		} else return Globals.demo.getAddressLine1();
	}

	@Override
	public String getAddressLine2() {
		if (Globals.settings.isAddressLine2()) {
			return city + " " + postalCode;
		} else return Globals.demo.getAddressLine2();
	}
	
	
}
