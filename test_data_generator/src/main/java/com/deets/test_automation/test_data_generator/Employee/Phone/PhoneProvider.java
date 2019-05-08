package com.deets.test_automation.test_data_generator.Employee.Phone;

import com.deets.test_automation.test_data_generator.Dictionary;
import com.deets.test_automation.test_data_generator.Globals;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PhoneProvider implements Provider<Phone>{

	@VisibleForTesting
	String PHONE_TYPE = "phoneTypes";
	@VisibleForTesting
	String COUNTRY_CODE = "phoneCountryCode";
	@VisibleForTesting
	String AREA_CODE = "phoneAreaCode";
	@VisibleForTesting
	String PHONE_FORMAT = "telephone_number_formats";
	
	protected String phoneNumber;
	protected String type;
	protected String countryCode;
	protected String areaCode;
	protected boolean isPrimary;
	protected String extension;
	
	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	protected final DateProducer dateProducer;
	protected final Dictionary dictionary;

	@Inject
	public PhoneProvider(BaseProducer baseProducer, DataMaster dataMaster, DateProducer dateProducer, Dictionary dictionary) {
		
		this.baseProducer = baseProducer;
		this.dataMaster = dataMaster;
		this.dateProducer = dateProducer;
		this.dictionary = dictionary;		
	}
	
	public Phone get() {
		generateType();
		generateCountryCode();
		generateAreaCode();
		generateExtension();
		generatePhoneNumber();
		generateIsPrimary();
		return new Phone(type, countryCode, areaCode, phoneNumber, extension, isPrimary);
	}

	private void generateIsPrimary() {
		if (Globals.settings.phoneIsPrimary()) {
			isPrimary = true;
		} 
	}

	private void generateType() {
		if (Globals.settings.isPhoneType()) {
			type = dataMaster.getRandomValue(PHONE_TYPE);
			
		}
	}

	private void generatePhoneNumber() {
		if (Globals.settings.isPhoneNumber()) {
			String telephoneNumberFormat = dataMaster.getRandomValue(PHONE_FORMAT);
			phoneNumber = countryCode + " " + Globals.area + baseProducer.numerify(telephoneNumberFormat).toString();
			if (!extension.equals("")) phoneNumber += " Ext. " + extension;
		} else {
			phoneNumber = "";
		}
	}
	
	private void generateCountryCode() {
		if (Globals.settings.isCountryCode()) {
			countryCode = dataMaster.getRandomValue(COUNTRY_CODE);
			
		} else {
			countryCode = "";
		}
	}
	
	private void generateAreaCode() {
		if (Globals.settings.isCountryCode()) {
			areaCode = Globals.area.replaceFirst("-", "");
		} else {
			areaCode = "";
		}
	}
	
	private void generateExtension() {
		if (Globals.settings.isExtension()) {
			if (dictionary.getPhoneTypeValue(type).equals("Business")) {
				if (baseProducer.trueOrFalse()) {
					for (int i = 0;  i<3; i++) {
						Integer r = baseProducer.randomBetween(1, 9);
						extension += r.toString();
					}
				}
			}
		} else {
			extension = "";
		}
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	
	
	
	
}
