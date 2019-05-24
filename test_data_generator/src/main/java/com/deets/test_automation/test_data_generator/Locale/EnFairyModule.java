package com.deets.test_automation.test_data_generator.Locale;

import com.deets.test_automation.test_data_generator.Employee.Address.AddressProvider;
import com.deets.test_automation.test_data_generator.Employee.NationalInfo.NationalInfoProvider;
import com.deets.test_automation.test_data_generator.Fairy.FairyModule;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.RandomGenerator;

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
		
		bind(AddressProvider.class).to(EnAddressProvider.class);
		bind(NationalInfoProvider.class).to(EnNationalInfoProvider.class);
	}

}
