package com.deets.test_automation.test_data_generator.Locale;

import com.deets.test_automation.test_data_generator.Employee.AbstractDependentProvider;
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
		return new EnDependent(getDate(), getRelationship(), getPerson());
	}

}