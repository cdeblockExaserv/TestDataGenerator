package com.deets.test_automation.test_data_generator.Fairy;

import com.deets.test_automation.test_data_generator.Employee.DefaultEmployeeProvider;
import com.deets.test_automation.test_data_generator.Employee.EmployeeFactory;
import com.deets.test_automation.test_data_generator.Employee.EmployeeProvider;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.RandomGenerator;
import com.google.inject.assistedinject.FactoryModuleBuilder;
/**
**Altered after copy
**/
public class FairyModule extends com.devskiller.jfairy.FairyModule {

	
	private final RandomGenerator randomGenerator;
	private final DataMaster dataMaster;

	public FairyModule(DataMaster dataMaster, RandomGenerator randomGenerator) {
		super(dataMaster, randomGenerator);
		this.dataMaster = dataMaster;
		this.randomGenerator = randomGenerator;
	}

	@Override
	protected void configure() {
		super.configure();
		
		bind(DataMaster.class).toInstance(dataMaster);
		bind(RandomGenerator.class).toInstance(randomGenerator);
		
		install(new FactoryModuleBuilder().build(FairyFactory.class));
		install(new FactoryModuleBuilder().implement(EmployeeProvider.class, DefaultEmployeeProvider.class).build(EmployeeFactory.class));
	}

}