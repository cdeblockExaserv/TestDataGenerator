package com.deets.test_automation.test_data_generator.Employee.Address;

import org.apache.commons.csv.CSVRecord;
import java.util.Random;

import com.deets.test_automation.test_data_generator.Globals;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.google.common.annotations.VisibleForTesting;


public abstract class AbstractAddressProvider implements AddressProvider{
	
	@VisibleForTesting
	private static final String CITY = "city";
	@VisibleForTesting
	private static final String STREET = "street";
	@VisibleForTesting
	private static final String COUNTRY = "country";
	@VisibleForTesting
	private static final String ADDRESS_TYPE = "addressType";
	

	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	private Integer start;
	private Integer end;
	
	private CSVRecord csvRecord;

	public AbstractAddressProvider(DataMaster dataMaster, BaseProducer baseProducer){
		this.baseProducer = baseProducer;
		this.dataMaster = dataMaster;
		Random random = new Random();
		csvRecord = Globals.list.get(random.nextInt(Globals.list.size()));
		start = Integer.valueOf(csvRecord.get(1).toString());
		end = Integer.valueOf(csvRecord.get(2).toString());
		Globals.area = !csvRecord.get(3).isEmpty() ? csvRecord.get(3).toString() + "-" : "";
		Globals.timezone = csvRecord.get(4);
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
	
	public String getState(){
		if (Globals.settings.isState()) {
			return csvRecord.get(0).toString();
		} else return "";
	}

	public String getCity() {
		if (Globals.settings.isCity()) {
		return dataMaster.getRandomValue(CITY);
		} else return "";
	}

	public String getPostalCode() {
		if (Globals.settings.isZipcode()) {
			return Integer.toString(baseProducer.randomBetween(start, end));
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
