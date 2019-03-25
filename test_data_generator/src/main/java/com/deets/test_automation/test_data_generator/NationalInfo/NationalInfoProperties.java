package com.deets.test_automation.test_data_generator.NationalInfo;

import java.time.LocalDate;

import com.devskiller.jfairy.producer.person.Country;

public final class NationalInfoProperties {

	private NationalInfoProperties() {
	}
	
	public abstract static class Property {

		public abstract void apply(NationalInfoProvider nationalInfoProvider);
	}

	public static Property dateOfBirth(final LocalDate dateOfBirth) {
		return new Property() {
			@Override
			public void apply(NationalInfoProvider nationalInfoProvider) {
				nationalInfoProvider.setIssueDate(dateOfBirth);
			}
		};
	}

	public static Property Country(final Country country) {
		return new Property() {
			@Override
			public void apply(NationalInfoProvider nationalInfoProvider) {
				nationalInfoProvider.setCountry(country);
			}
		};
	}
}
