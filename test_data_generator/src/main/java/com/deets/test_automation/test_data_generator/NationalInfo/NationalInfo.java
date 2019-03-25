package com.deets.test_automation.test_data_generator.NationalInfo;

public class NationalInfo {
	
	private final String nationalID;
	private final String country;
	private final String nationalIDType;
	private final String isPrimary;

	public NationalInfo(String nationalID, String country, String nationalIDType, String isPrimary) {
		this.nationalID = nationalID;
		this.country = country;
		this.nationalIDType = nationalIDType;
		this.isPrimary = isPrimary;
	}

	public String getNationalID() {
		return nationalID;
	}

	public String getCountry() {
		return country;
	}

	public String getNationalIDType() {
		return nationalIDType;
	}

	public String getIsPrimary() {
		return isPrimary;
	}
	
	
		
}
