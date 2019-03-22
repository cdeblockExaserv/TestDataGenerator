package com.deets.test_automation.test_data_generator.Employee;

import java.time.LocalDate;

import com.devskiller.jfairy.producer.BaseProducer;

public class EmployeeProperties {

	private EmployeeProperties() {
	}

	public abstract static class EmployeeProperty {

		public abstract void apply(EmployeeProvider employee, BaseProducer baseProducer);

	}
	
	public static EmployeeProperty employeeID(final String employeeID) {
		return new EmployeeProperty() {
			@Override
			public void apply(EmployeeProvider employee, BaseProducer baseProducer) {
				employee.setEmployeeID(employeeID);
			}
		};
	}
	
	public static EmployeeProperty suffix(final String suffix) {
		return new EmployeeProperty() {
			@Override
			public void apply(EmployeeProvider employee, BaseProducer baseProducer) {
				employee.setSuffix(suffix);
			}
		};
	}
	
	public static EmployeeProperty maritalStatus(final String maritalStatus) {
		return new EmployeeProperty() {
			@Override
			public void apply(EmployeeProvider employee, BaseProducer baseProducer) {
				employee.setMaritalStatus(maritalStatus);
			}
		};
	}
	
	public static EmployeeProperty nativePreferedLanguage(final String nativePreferedLanguage) {
		return new EmployeeProperty() {
			@Override
			public void apply(EmployeeProvider employee, BaseProducer baseProducer) {
				employee.setNativePreferedLanguage(nativePreferedLanguage);
			}
		};
	}
	
	public static EmployeeProperty displayName(final String displayName) {
		return new EmployeeProperty() {
			@Override
			public void apply(EmployeeProvider employee, BaseProducer baseProducer) {
				employee.setDisplayName(displayName);
			}
		};
	}
	
	public static EmployeeProperty preferedName(final String preferedName) {
		return new EmployeeProperty() {
			@Override
			public void apply(EmployeeProvider employee, BaseProducer baseProducer) {
				employee.setPreferedName(preferedName);
			}
		};
	}
	
	public static EmployeeProperty birthName(final String birthName) {
		return new EmployeeProperty() {
			@Override
			public void apply(EmployeeProvider employee, BaseProducer baseProducer) {
				employee.setBirthName(birthName);
			}
		};
	}
	
	public static EmployeeProperty prefix(final String prefix) {
		return new EmployeeProperty() {
			@Override
			public void apply(EmployeeProvider employee, BaseProducer baseProducer) {
				employee.setPrefix(prefix);
			}
		};
	}
	
	public static EmployeeProperty maritalStatusSince(final LocalDate maritalStatusSince) {
		return new EmployeeProperty() {
			@Override
			public void apply(EmployeeProvider employee, BaseProducer baseProducer) {
				employee.setMaritalStatusSince(maritalStatusSince);
			}
		};
	}
	

	
}
