package com.deets.test_automation.test_data_generator.Employee.Phone;

import com.devskiller.jfairy.producer.BaseProducer;

public class PhoneProperties {

private PhoneProperties() {
		
	}
	
	public abstract static class PhoneProperty {
		public abstract void apply(PhoneProvider phone, BaseProducer baseProducer);
	}
	
	public static PhoneProperty phoneNumber(final String phoneNumber) {
		return new PhoneProperty() {
			@Override
			public void apply(PhoneProvider phone, BaseProducer baseProducer) {
				phone.setPhoneNumber(phoneNumber);
			}
		};
	}
	public static PhoneProperty phoneType(final String type) {
		return new PhoneProperty() {
			@Override
			public void apply(PhoneProvider phone, BaseProducer baseProducer) {
				phone.setType(type);;
			}
		};
	}
	public static PhoneProperty countryCode(final String countryCode) {
		return new PhoneProperty() {
			@Override
			public void apply(PhoneProvider phone, BaseProducer baseProducer) {
				phone.setCountryCode(countryCode);
			}
		};
	}
	public static PhoneProperty areaCode(final String areaCode) {
		return new PhoneProperty() {
			@Override
			public void apply(PhoneProvider phone, BaseProducer baseProducer) {
				phone.setAreaCode(areaCode);;
			}
		};
	}
	public static PhoneProperty extension(final String extension) {
		return new PhoneProperty() {
			@Override
			public void apply(PhoneProvider phone, BaseProducer baseProducer) {
				phone.setExtension(extension);
			}
		};
	}
	public static PhoneProperty phoneIsPrimary(final boolean isPrimary) {
		return new PhoneProperty() {
			@Override
			public void apply(PhoneProvider phone, BaseProducer baseProducer) {
				phone.setPrimary(isPrimary);
			}
		};
	}
	
}
