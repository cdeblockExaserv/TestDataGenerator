package com.deets.test_automation.test_data_generator.Employee.Email;

import static org.apache.commons.lang3.StringUtils.lowerCase;

import com.deets.test_automation.test_data_generator.Dictionary;
import com.deets.test_automation.test_data_generator.Globals;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.util.TextUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class EmailProvider implements Provider<Email>{

	@VisibleForTesting
	String EMAIL_TYPE = "emailTypes";
	@VisibleForTesting
	String PERSONAL_EMAIL = "personalEmails";
	@VisibleForTesting
	String COMPANY_EMAIL = "companyEmails";
	
	protected String emailAddress;
	protected String type;
	protected boolean isPrimary;
	protected String firstName;
	protected String lastName;
	
	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	protected final DateProducer dateProducer;
	protected final Dictionary dictionary;

	@Inject
	public EmailProvider(BaseProducer baseProducer, DataMaster dataMaster, DateProducer dateProducer,
			Dictionary dictionary) {
		
		this.baseProducer = baseProducer;
		this.dataMaster = dataMaster;
		this.dateProducer = dateProducer;
		this.dictionary = dictionary;		
	}
	
	
	
	public Email get(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		generateType();
		generateEmailAddress();
		generateIsPrimary();
		
		return new Email(emailAddress, type, isPrimary);
	}

	private void generateIsPrimary() {
		if (Globals.settings.emailIsPrimary()) {
			isPrimary = true;
		} 
	}

	private void generateType() {
		if (Globals.settings.isEmailType()) {
			type = dataMaster.getRandomValue(EMAIL_TYPE);
		} else {
			type = "";
		}
	}

	private void generateEmailAddress() {
	
		if (Globals.settings.isEmailAddress()) {
			if (type != "") {
				if (dictionary.getEmailTypeValue(type) == "Personal") {
					emailAddress = TextUtils.stripAccents(lowerCase(firstName + '.' + lastName +
							'@' + dataMaster.getRandomValue(PERSONAL_EMAIL))).replaceAll(" ", "");
				} else if (dictionary.getEmailTypeValue(type) == "Business") {
					emailAddress = TextUtils.stripAccents(lowerCase(firstName + '.' + lastName +
							'@' + dataMaster.getRandomValue(COMPANY_EMAIL))).replaceAll(" ", "");
				}
			} else { //TODO: implement real solution when file is loaded in
				emailAddress = Globals.demo.getEmail();
			}
		}
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}



	@Override
	public Email get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
