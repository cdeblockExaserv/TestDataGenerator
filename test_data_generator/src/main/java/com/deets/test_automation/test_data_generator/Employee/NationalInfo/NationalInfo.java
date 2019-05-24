package com.deets.test_automation.test_data_generator.Employee.NationalInfo;


public class NationalInfo {
	
	private String nationalIDNumber;
	private String nationalIDType;
	private String country;
	private boolean isPrimary;
	
	public NationalInfo(String nationalIDNumber, String nationalIDType, String country, boolean isPrimary) {
		super();
		this.nationalIDNumber = nationalIDNumber;
		this.nationalIDType = nationalIDType;
		this.country = country;
		this.isPrimary = isPrimary;
	}

	
	public String getNationalIDNumber() {
		return nationalIDNumber;
	}

	public void setNationalIDNumber(String nationalIDNumber) {
		this.nationalIDNumber = nationalIDNumber;
	}

	public String getNationalIDType() {
		return nationalIDType;
	}

	public void setNationalIDType(String nationalIDType) {
		this.nationalIDType = nationalIDType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	
}
