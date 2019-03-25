package com.deets.test_automation.test_data_generator.Dependent;

import java.time.LocalDate;

import com.devskiller.jfairy.producer.person.Person;

public abstract class AbstractDependent implements Dependent{

	protected final LocalDate date;
	protected final String relationship;
	protected final Person person;

	public AbstractDependent(LocalDate date, String relationship, Person person) {
		this.date = date;
		this.relationship = relationship;
		this.person = person;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getRelationship() {
		return relationship;
	}

	public Person getPerson() {
		return person;
	}
	
}
