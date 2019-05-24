package com.deets.test_automation.test_data_generator.Locale;

import java.io.IOException;

import com.deets.test_automation.test_data_generator.Employee.Address.AbstractAddressProvider;
import com.deets.test_automation.test_data_generator.Employee.Address.Address;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.google.inject.Inject;

public class FrAddressProvider extends AbstractAddressProvider{

	@Inject
	public FrAddressProvider(DataMaster dataMaster, BaseProducer baseProducer) throws IOException {
		super(dataMaster, baseProducer);
	}

	public Address get() {
		//return new EnAddress(getStreetNumber(), getStreet(), getApartmentNumber(), getCity(), getPostalCode(), 
		//		getCountry(), getAddressType(), getState());
		return new FrAddress(getStreetNumber(), getStreet(), getApartmentNumber(), getCity(), getPostalCode(), 
				getCountry(), getAddressType(), getState()) {
			
			@Override
			protected String getApartmentMark() {
				return " Apartement ";
			}
		};
	}
}
