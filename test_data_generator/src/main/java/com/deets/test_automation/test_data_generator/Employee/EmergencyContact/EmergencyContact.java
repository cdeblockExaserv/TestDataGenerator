package com.deets.test_automation.test_data_generator.Employee.EmergencyContact;

import com.deets.test_automation.test_data_generator.Dictionary;
import com.deets.test_automation.test_data_generator.Globals;
import com.deets.test_automation.test_data_generator.Fairy.Fairy;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.person.Person.Sex;
import com.google.common.annotations.VisibleForTesting;

public class EmergencyContact {
	
	@VisibleForTesting
	String RELATIONSHIP = "relationships";
	@VisibleForTesting
	String COUNTRY_CODE = "phoneCountryCode";
	
	private Person person;
	private String name;
	private String relationship;
	private String mail;
	private String telephone;
	private boolean isPrimary;
	
	private Dictionary dictionary = new Dictionary();
	
	public EmergencyContact(String relationship, String telephone, boolean isPrimary) {
		super();
		this.person = Fairy.builder().withFilePrefix(Globals.LOC).build().person();
		this.relationship = relationship;
		this.telephone = telephone;
		this.isPrimary = isPrimary;
	}
	
	public EmergencyContact(DataMaster dataMaster) {
		this.person = Fairy.builder().withFilePrefix(Globals.LOC).build().person();
		if (Globals.settings.isEmergencyRelationship()) {
			relationship =  dataMaster.getValuesOfType(RELATIONSHIP, "dependent", String.class);
			String relationship_en = dictionary.getRelationshipValue(relationship);
			if (relationship_en == "Father" && person.getSex() != Sex.MALE) {
				do {
					relationship = dataMaster.getValuesOfType(RELATIONSHIP, "dependent", String.class);
					relationship_en = dictionary.getRelationshipValue(relationship);
				} while (relationship_en == "Father");
			} else if (relationship_en == "Mother" && person.getSex() != Sex.FEMALE) {
				do {
					relationship = dataMaster.getValuesOfType(RELATIONSHIP, "dependent", String.class);
					relationship_en = dictionary.getRelationshipValue(relationship);
				} while (relationship_en == "Mother");
			}
		} else relationship = "";
		if (Globals.settings.isEmergencyName()) {
			name = person.getFullName();
		} else name = "";
		if (Globals.settings.isEmergencyMail()) {
			mail = person.getEmail();
		} else mail = "";
		if (Globals.settings.isEmergencyPhone()) {
			telephone = dataMaster.getRandomValue(COUNTRY_CODE) + " " + person.getTelephoneNumber();
		} else telephone = "";
		if (Globals.settings.isEmergencyIsPrimary()) {
			//TODO: implement when multiple are created
			isPrimary = true;
		} else isPrimary = false;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
