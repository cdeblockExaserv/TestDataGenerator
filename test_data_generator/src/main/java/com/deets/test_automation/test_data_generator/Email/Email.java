package com.deets.test_automation.test_data_generator.Email;

public class Email {
	
	private final String email;
	private final String emailType;
	private final String emailaddress;
	private final boolean isPrimary;
	
	public Email(String email, String emailType, String emailaddress, boolean isPrimary) {
		this.email = email;
		this.emailType = emailType;
		this.emailaddress = emailaddress;
		this.isPrimary = isPrimary;
	}

	public String getEmail() {
		return email;
	}

	public String getEmailType() {
		return emailType;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public boolean isPrimary() {
		return isPrimary;
	}
	
}
