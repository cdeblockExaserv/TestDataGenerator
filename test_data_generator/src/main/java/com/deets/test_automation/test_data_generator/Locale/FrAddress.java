package com.deets.test_automation.test_data_generator.Locale;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import com.deets.test_automation.test_data_generator.Globals;
import com.deets.test_automation.test_data_generator.Employee.Address.AbstractAddress;

public abstract class FrAddress extends AbstractAddress {
	public FrAddress(String street, String streetNumber, String apartmentNumber, String city, String postalCode, String country,
				String type, String state) {
		super(street, streetNumber, apartmentNumber, city, postalCode, country, type, state);
	}

	protected abstract String getApartmentMark();

	protected String getStreetNumberSeparator() {
		return ", ";
	}

	@Override
	public String getAddressLine1() {
		if (Globals.settings.isAddressLine1()) {
			return street + getStreetNumberSeparator() + streetNumber +
					(isNotBlank(apartmentNumber) ? getApartmentMark() + apartmentNumber : "");
		} else return Globals.demo.getAddressLine1();
	}
	
	@Override
	public String getAddressLine2() {
		if (Globals.settings.isAddressLine2()) {
			return postalCode + " " + city;
		} else	return Globals.demo.getAddressLine2();
	}

}
