package com.deets.test_automation.test_data_generator.Employee.Phone;

public class BusinessPhone extends Phone{

	private String extension;
	
	public BusinessPhone(String countryCode, String phoneNumber,
			boolean isPrimary, String extension) {
		super("Business", countryCode, phoneNumber, isPrimary);
		this.extension = extension;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	

}
