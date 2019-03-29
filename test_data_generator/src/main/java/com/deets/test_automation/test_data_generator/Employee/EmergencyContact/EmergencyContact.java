package com.deets.test_automation.test_data_generator.Employee.EmergencyContact;

import com.devskiller.jfairy.producer.person.Person;

public class EmergencyContact {
	
	private Person person;
	private String relationship;
	private String telephone;
	private boolean isPrimary;
	
	public EmergencyContact(Person person, String relationship, String telephone, boolean isPrimary) {
		super();
		this.person = person;
		this.relationship = relationship;
		this.telephone = telephone;
		this.isPrimary = isPrimary;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	
}
