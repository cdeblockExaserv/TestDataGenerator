package com.deets.test_automation.test_data_generator.Fairy;

import com.deets.test_automation.test_data_generator.Dependent.DependentProvider;
import com.deets.test_automation.test_data_generator.Employee.DefaultEmployeeProvider;
import com.deets.test_automation.test_data_generator.Employee.EmployeeFactory;
import com.deets.test_automation.test_data_generator.Employee.EmployeeProvider;
import com.deets.test_automation.test_data_generator.Locale.EnDependentProvider;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.RandomGenerator;
import com.devskiller.jfairy.producer.VATIdentificationNumberProvider;
import com.devskiller.jfairy.producer.company.locale.en.EnVATIdentificationNumberProvider;
import com.devskiller.jfairy.producer.person.AddressProvider;
import com.devskiller.jfairy.producer.person.NationalIdentificationNumberFactory;
import com.devskiller.jfairy.producer.person.NationalIdentityCardNumberProvider;
import com.devskiller.jfairy.producer.person.PassportNumberProvider;
import com.devskiller.jfairy.producer.person.locale.NoNationalIdentificationNumberFactory;
import com.devskiller.jfairy.producer.person.locale.en.EnAddressProvider;
import com.devskiller.jfairy.producer.person.locale.en.EnNationalIdentityCardNumberProvider;
import com.devskiller.jfairy.producer.person.locale.en.EnPassportNumberProvider;
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
		bind(DependentProvider.class).to(EnDependentProvider.class);
		bind(NationalIdentificationNumberFactory.class).to(NoNationalIdentificationNumberFactory.class);
		bind(NationalIdentityCardNumberProvider.class).to(EnNationalIdentityCardNumberProvider.class);
		bind(VATIdentificationNumberProvider.class).to(EnVATIdentificationNumberProvider.class);
		bind(PassportNumberProvider.class).to(EnPassportNumberProvider.class);
		bind(AddressProvider.class).to(EnAddressProvider.class);
		
		install(new FactoryModuleBuilder().build(FairyFactory.class));
		install(new FactoryModuleBuilder().implement(EmployeeProvider.class, DefaultEmployeeProvider.class).build(EmployeeFactory.class));
	}

}