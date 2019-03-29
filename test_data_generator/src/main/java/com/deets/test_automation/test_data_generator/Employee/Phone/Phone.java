package com.deets.test_automation.test_data_generator.Employee.Phone;

public abstract class Phone {

	private String type;
	private String countryCode;
	private String phoneNumber;
	private boolean isPrimary;
	
	public Phone(String type, String countryCode, String phoneNumber, boolean isPrimary) {
		super();
		this.type = type;
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
		this.isPrimary = isPrimary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getPhoneIsPrimary() {
		return isPrimary;
	}

	public void setPhoneIsPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	
	
	
}
