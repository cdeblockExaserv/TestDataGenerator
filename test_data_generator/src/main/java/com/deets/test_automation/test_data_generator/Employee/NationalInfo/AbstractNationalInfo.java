package com.deets.test_automation.test_data_generator.Employee.NationalInfo;

public abstract class AbstractNationalInfo extends NationalInfo{

	public AbstractNationalInfo(String country, String nationalIDType, boolean isPrimary) {
		super("", nationalIDType, country, isPrimary);
	}

	public String getNationalIDType() {
		return getNationalIDType();
	}

	public boolean getIsPrimary() {
		return isPrimary();
	}
	
	public String getCountry() {
		return getCountry();
	}

	public void setNationalIDType(String nationalIDType) {
		setNationalIDType(nationalIDType);
	}

	public void setPrimary(boolean isPrimary) {
		setPrimary(isPrimary);
	}

	public void setCountry(String country) {
		setCountry(country);
	}
	
	public abstract String getNationalIDNumber();

	
}
