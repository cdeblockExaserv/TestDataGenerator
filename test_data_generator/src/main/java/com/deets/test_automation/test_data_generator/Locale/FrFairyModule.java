package com.deets.test_automation.test_data_generator.Locale;

import com.deets.test_automation.test_data_generator.Employee.Address.AddressProvider;
import com.deets.test_automation.test_data_generator.Employee.NationalInfo.NationalInfoProvider;
import com.deets.test_automation.test_data_generator.Fairy.FairyModule;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.RandomGenerator;


/**
 * @author graux
 * @since 26.04.15
 */
public class FrFairyModule extends FairyModule {

	public FrFairyModule(DataMaster dataMaster, RandomGenerator randomGenerator) {
		super(dataMaster, randomGenerator);
	}

	@Override
	protected void configure() {
		super.configure();
		bind(AddressProvider.class).to(FrAddressProvider.class);
		bind(NationalInfoProvider.class).to(FrNationalInfoProvider.class);
		
	}
}
