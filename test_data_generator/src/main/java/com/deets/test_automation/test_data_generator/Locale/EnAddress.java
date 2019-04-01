package com.deets.test_automation.test_data_generator.Locale;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import com.deets.test_automation.test_data_generator.Employee.Address.AbstractAddress;

public class EnAddress extends AbstractAddress {

	public EnAddress(String streetNumber, String street, String apartmentNumber, String city, String postalCode, 
				String country, String addressType, String state) {
		super(street, streetNumber, apartmentNumber, postalCode, city, country, addressType, state);
	}

	@Override
	public String getAddressLine1() {
		return streetNumber + " " + street
				+ (isNotBlank(apartmentNumber) ? " APT " + apartmentNumber : "");
	}

	@Override
	public String getAddressLine2() {
		return city + " " + postalCode;
	}
}
