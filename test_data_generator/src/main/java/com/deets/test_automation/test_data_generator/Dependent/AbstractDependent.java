package com.deets.test_automation.test_data_generator.Dependent;

import java.time.LocalDate;

import com.devskiller.jfairy.producer.person.Person;

public abstract class AbstractDependent implements Dependent{

	protected final LocalDate date;
	protected final String relationship;
	protected final String firstName;
	protected final String middleName;
	protected final String lastName;
	protected final Person person;

	public AbstractDependent(Person person, String relationship, LocalDate date) {
		this.date = date;
		this.relationship = relationship;
		this.person = person;
		this.firstName = person.getFirstName();
		this.middleName = person.getMiddleName();
		this.lastName = person.getLastName();
	}

	public LocalDate getDate() {
		return date;
	}

	public String getRelationship() {
		return relationship;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

		

}
