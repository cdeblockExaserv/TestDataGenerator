package com.deets.test_automation.test_data_generator.Employee.Phone;

public class Phone {

	private String type;
	private String countryCode;
	private String areaCode;
	private String phoneNumber;
	private String extension;
	private boolean isPrimary;
	
	public Phone(String type, String countryCode, String areaCode, String phoneNumber, String extension, boolean isPrimary) {
		super();
		this.type = type;
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.phoneNumber = phoneNumber;
		this.extension = extension;
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	
	
}
