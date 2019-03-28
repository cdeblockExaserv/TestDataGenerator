package com.deets.test_automation.test_data_generator.Employee.NationalInfo;

public class NationalInfo {
	
	private final String nationalIDType;
	private final boolean isPrimary;
	private final String country;

	public NationalInfo(String country, String nationalIDType, boolean isPrimary) {
		this.nationalIDType = nationalIDType;
		this.isPrimary = isPrimary;
		this.country = country;
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
	
		
}
