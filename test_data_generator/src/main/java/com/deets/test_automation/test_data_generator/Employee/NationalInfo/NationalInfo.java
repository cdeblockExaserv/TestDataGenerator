package com.deets.test_automation.test_data_generator.Employee.NationalInfo;

import com.deets.test_automation.test_data_generator.Globals;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.person.Person;
import com.google.common.annotations.VisibleForTesting;

public class NationalInfo {
	
	@VisibleForTesting
	String NATIONAL_ID_TYPE = "nationalIdTypes";
	@VisibleForTesting
	String COUNTRY = "country";
	
	private final String nationalIDNumber;
	private final String nationalIDType;
	private final boolean isPrimary;
	private final String country;

	public NationalInfo(String number, String country, String nationalIDType, boolean isPrimary) {
		this.nationalIDType = nationalIDType;
		this.isPrimary = isPrimary;
		this.country = country;
		this.nationalIDNumber = number;
	}

	public String getNationalIDType() {
		return nationalIDType;
	}

	public boolean getIsPrimary() {
		return isPrimary;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getNationalIDNumber() {
		return nationalIDNumber;
	}

	public NationalInfo(Person person, DataMaster dataMaster) {
		if (Globals.settings.isNationalIDNumber()) {
			nationalIDNumber = person.getNationalIdentityCardNumber();
		} else nationalIDNumber = "";
		if (Globals.settings.isNationalIDType()) {
			nationalIDType = dataMaster.getRandomValue(NATIONAL_ID_TYPE);
		} else nationalIDType = "";
		if (Globals.settings.isIDCountry()) {
			country = dataMaster.getRandomValue(COUNTRY);
		} else country = "";
		if (Globals.settings.isNationalIDisPrimary()) {
			isPrimary = true;
		} else isPrimary = false;
		
		
	}
	
}
