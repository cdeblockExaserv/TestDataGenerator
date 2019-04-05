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
		if(relationship_en == "Single") {
			return dateProducer.randomDateBetweenTwoDates(dateOfBirth.minusYears(15), dateOfBirth.plusYears(15));
		} else if (relationship_en == "Parent") {
			return dateProducer.randomDateBetweenTwoDates(dateOfBirth.minusYears(110), dateOfBirth.minusYears(18));
		} else if (relationship_en == "Child") {
			return dateProducer.randomDateBetweenTwoDates(dateOfBirth.plusYears(18), LocalDate.now());
		} else {
			return dateProducer.randomDateInThePast(110).toLocalDate();
		}
		
	}
	
	public String getRelationship() {
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
	}
	
	public Person getPerson() {
		person = Fairy.builder().withFilePrefix(Globals.LOC).build().person();
		return person;
	}

	public abstract Dependent get(LocalDate dateOfBirth);

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
