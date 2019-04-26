package com.deets.test_automation.test_data_generator.Employee.Email;

import com.devskiller.jfairy.producer.BaseProducer;

public class EmailProperties {

private EmailProperties() {
		
	}
	
	public abstract static class EmailProperty {
		public abstract void apply(EmailProvider email, BaseProducer baseProducer);
	}
	
	public static EmailProperty emailAddress(final String emailAddress) {
		return new EmailProperty() {
			@Override
			public void apply(EmailProvider email, BaseProducer baseProducer) {
				email.setEmailAddress(emailAddress);
			}
		};
	}
	public static EmailProperty emailType(final String type) {
		return new EmailProperty() {
			@Override
			public void apply(EmailProvider email, BaseProducer baseProducer) {
				email.setType(type);;
			}
		};
	}
	public static EmailProperty emailIsPrimary(final boolean isPrimary) {
		return new EmailProperty() {
			@Override
			public void apply(EmailProvider email, BaseProducer baseProducer) {
				email.setPrimary(isPrimary);
			}
		};
	}
	
}
