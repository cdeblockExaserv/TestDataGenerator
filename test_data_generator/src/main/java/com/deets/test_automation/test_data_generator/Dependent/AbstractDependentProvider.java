package com.deets.test_automation.test_data_generator.Dependent;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.Dictionary;
import com.deets.test_automation.test_data_generator.Globals;
import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.person.Person.Sex;

public abstract class AbstractDependentProvider implements DependentProvider{
	
	private static final String RELATIONSHIP = "relationships";

	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	protected final DateProducer dateProducer;
	protected final Dictionary dictionary;
	protected String relationship;
	protected String relationship_en;

	private LocalDate dateOfBirth;
	private Person person;
	
	public AbstractDependentProvider(DataMaster dataMaster, BaseProducer baseProducer, DateProducer dateProducer) {
		this.baseProducer = baseProducer;
		this.dataMaster = dataMaster;
		this.dateProducer = dateProducer;
		dictionary = new Dictionary();
	}

	public LocalDate getDate() {
		if (Globals.settings.isDependentDate()) {
			if(relationship_en == "Single") {
				return dateProducer.randomDateBetweenTwoDates(dateOfBirth.minusYears(15), dateOfBirth.plusYears(15));
			} else if (relationship_en == "Parent") {
				return dateProducer.randomDateBetweenTwoDates(dateOfBirth.minusYears(110), dateOfBirth.minusYears(18));
			} else if (relationship_en == "Child") {
				return dateProducer.randomDateBetweenTwoDates(dateOfBirth.plusYears(18), LocalDate.now());
			} else {
				return dateProducer.randomDateInThePast(75).toLocalDate();
			}
		} else { return null; }
		
	}
	
	public String getRelationship() {
		if (Globals.settings.isRelationship()) {
			relationship =  dataMaster.getValuesOfType(RELATIONSHIP, "dependent", String.class);
			relationship_en = dictionary.getRelationshipValue(relationship);
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
			return relationship;
		} else { return null; }
	}
	
	public Person getPerson() {
		person = Fairy.builder().withFilePrefix(Globals.LOC).build().person();
		return person;
	}
	
	public String getFirstName() {
		if (Globals.settings.isDependentFirstName()) {
			return person.getFirstName();
		} else return "";
	}
	
	public String getMiddleName() {
			if (Globals.settings.isDependentMiddleName()) {
				return person.getMiddleName();
			} else return "";	
		}
	
	public String getLastName() {
			if (Globals.settings.isDependentLastName()) {
				return person.getLastName();
			} else return "";	
		}

	public abstract Dependent get(LocalDate dateOfBirth);

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
