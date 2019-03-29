package com.deets.test_automation.test_data_generator.Dependent;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.Globals;
import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.person.Person;

public abstract class AbstractDependentProvider implements DependentProvider{
	
	private static final String RELATIONSHIP = "relationships";

	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	protected final DateProducer dateProducer;

	public AbstractDependentProvider(DataMaster dataMaster, BaseProducer baseProducer, DateProducer dateProducer) {
		this.baseProducer = baseProducer;
		this.dataMaster = dataMaster;
		this.dateProducer = dateProducer;
	}

	public LocalDate getDate() {
		return dateProducer.randomDateInThePast(100).toLocalDate();
	}
	
	public String getRelationship() {
		return dataMaster.getValuesOfType(RELATIONSHIP, "dependent", String.class);
	}
	
	public Person getPerson() {
		Person person = Fairy.builder().withFilePrefix(Globals.LOC).build().person();
		return person;
	}
	
}
