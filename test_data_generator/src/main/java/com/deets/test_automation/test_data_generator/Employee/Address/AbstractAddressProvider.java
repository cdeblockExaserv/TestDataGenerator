package com.deets.test_automation.test_data_generator.Employee.Address;

import com.deets.test_automation.test_data_generator.Globals;
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
		if (Globals.settings.isCountry()) {
		return dataMaster.getRandomValue(COUNTRY);
		} else { return ""; }
	}
	
	public String getAddressType() {
		if (Globals.settings.isAddressType()) {
		return dataMaster.getRandomValue(ADDRESS_TYPE);
		} else return "";
	}
	
	public String getState() {
		//TODO: Fix when file to load in
		if (Globals.settings.isState()) {
		return dataMaster.getRandomValue(STATE);
		} else return "Minnesota";
	}

	public String getCity() {
		if (Globals.settings.isCity()) {
		return dataMaster.getRandomValue(CITY);
		} else return "";
	}

	public String getPostalCode() {
		if (Globals.settings.isZipcode()) {
			String postalCodeFormat = dataMaster.getRandomValue(POSTAL_CODE_FORMAT);
			return baseProducer.numerify(postalCodeFormat);
		} else return "";
	}

	public String getStreet() {
		if (Globals.settings.isStreet()) {
		return dataMaster.getRandomValue(STREET);
		} else return "";
	}

	public String getStreetNumber() {
		if (Globals.settings.isStreetNumber()) {
		return String.valueOf(baseProducer.randomBetween(1, 199));
		} else return "";
	}

	public String getApartmentNumber() {
		if (Globals.settings.isApartmentNumber()) {
		return baseProducer.trueOrFalse() ? String.valueOf(baseProducer.randomBetween(1, 350)) : "";
		} else return "";
	}

}
