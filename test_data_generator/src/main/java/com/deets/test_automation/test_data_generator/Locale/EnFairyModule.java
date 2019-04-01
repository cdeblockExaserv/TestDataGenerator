package com.deets.test_automation.test_data_generator.Locale;

import com.deets.test_automation.test_data_generator.Dependent.DependentProvider;
import com.deets.test_automation.test_data_generator.Employee.Address.AddressProvider;
import com.deets.test_automation.test_data_generator.Fairy.FairyModule;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.RandomGenerator;
import com.devskiller.jfairy.producer.VATIdentificationNumberProvider;
import com.devskiller.jfairy.producer.company.locale.en.EnVATIdentificationNumberProvider;
import com.devskiller.jfairy.producer.person.NationalIdentificationNumberFactory;
import com.devskiller.jfairy.producer.person.NationalIdentityCardNumberProvider;
import com.devskiller.jfairy.producer.person.PassportNumberProvider;
import com.devskiller.jfairy.producer.person.locale.NoNationalIdentificationNumberFactory;
import com.devskiller.jfairy.producer.person.locale.en.EnNationalIdentityCardNumberProvider;
import com.devskiller.jfairy.producer.person.locale.en.EnPassportNumberProvider;

/**
 * @author Olga Maciaszek-Sharma
 * @since 08.03.15
 */
public class EnFairyModule extends FairyModule {

	public EnFairyModule(DataMaster dataMaster, RandomGenerator randomGenerator) {
		super(dataMaster, randomGenerator);
	}

	@Override
	protected void configure() {
		super.configure();
		bind(NationalIdentificationNumberFactory.class).to(NoNationalIdentificationNumberFactory.class);
		bind(NationalIdentityCardNumberProvider.class).to(EnNationalIdentityCardNumberProvider.class);
		bind(VATIdentificationNumberProvider.class).to(EnVATIdentificationNumberProvider.class);
		bind(com.devskiller.jfairy.producer.person.AddressProvider.class).to(com.devskiller.jfairy.producer.person.locale.en.EnAddressProvider.class);
		bind(PassportNumberProvider.class).to(EnPassportNumberProvider.class);
		bind(DependentProvider.class).to(EnDependentProvider.class);
		bind(AddressProvider.class).to(EnAddressProvider.class);
	}

}
