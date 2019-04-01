package com.deets.test_automation.test_data_generator.Employee.Address;

import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.google.common.annotations.VisibleForTesting;

public abstract class AbstractAddressProvider implements AddressProvider{
	
	@VisibleForTesting
	private static final String POSTAL_CODE_FORMAT = "postal_code";
	@VisibleForTesting
	private static final String CITY = "city";
	@VisibleForTesting
	private static final String STREET = "street";
	@VisibleForTesting
	private static final String COUNTRY = "country";
	@VisibleForTesting
	private static final String ADDRESS_TYPE = "addressType";
	@VisibleForTesting
	private static final String STATE = "states";

	protected final BaseProducer baseProducer;

	protected final DataMaster dataMaster;

	public AbstractAddressProvider(DataMaster dataMaster, BaseProducer baseProducer) {
		this.baseProducer = baseProducer;
		this.dataMaster = dataMaster;
	}

	public String getCountry() {
		return dataMaster.getRandomValue(COUNTRY);
	}
	
	public String getAddressType() {
		return dataMaster.getRandomValue(ADDRESS_TYPE);
	}
	
	public String getState() {
		return dataMaster.getRandomValue(STATE);
	}

	public String getCity() {
		return dataMaster.getRandomValue(CITY);
	}

	public String getPostalCode() {
		String postalCodeFormat = dataMaster.getRandomValue(POSTAL_CODE_FORMAT);
		return baseProducer.numerify(postalCodeFormat);
	}

	public String getStreet() {
		return dataMaster.getRandomValue(STREET);
	}

	public String getStreetNumber() {
		return String.valueOf(baseProducer.randomBetween(1, 199));
	}

	public String getApartmentNumber() {
		return baseProducer.trueOrFalse() ? String.valueOf(baseProducer.randomBetween(1, 350)) : "";
	}

}
