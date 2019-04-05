package com.deets.test_automation.test_data_generator.Locale;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.Dependent.AbstractDependentProvider;
import com.deets.test_automation.test_data_generator.Dependent.Dependent;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.google.inject.Inject;

public class EnDependentProvider extends AbstractDependentProvider{
	
	@Inject
	public EnDependentProvider(DataMaster dataMaster, BaseProducer baseProducer, DateProducer dateProducer) {
		super(dataMaster, baseProducer, dateProducer);
	}

	public EnDependent get() {
		return new EnDependent(getPerson(), getRelationship(),  getDate());
	}

	@Override
	public Dependent get(LocalDate dateOfBirth) {
		setDateOfBirth(dateOfBirth);
		return new EnDependent(getPerson(), getRelationship(),  getDate());
	}

}