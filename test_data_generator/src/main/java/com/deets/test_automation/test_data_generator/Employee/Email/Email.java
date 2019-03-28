package com.deets.test_automation.test_data_generator.Employee.Email;

public abstract class Email {

	private String emailAddress;
	private String emailType;
	private boolean isPrimary;
	
	public Email(String emailAddress, String emailType, boolean isPrimary) {
		super();
		this.emailAddress = emailAddress;
		this.emailType = emailType;
		this.isPrimary = isPrimary;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	
	
}
