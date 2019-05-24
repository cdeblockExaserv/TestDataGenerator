package com.deets.test_automation.test_data_generator.Employee.NationalInfo;

import com.deets.test_automation.test_data_generator.Globals;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.google.common.annotations.VisibleForTesting;

public abstract class AbstractNationalInfoProvider implements NationalInfoProvider{

	@VisibleForTesting
	String NATIONAL_ID_TYPE = "nationalIdTypes";
	@VisibleForTesting
	String COUNTRY = "country";
	
	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	
	public AbstractNationalInfoProvider(DataMaster dataMaster, BaseProducer baseProducer){
		this.baseProducer = baseProducer;
		this.dataMaster = dataMaster;
	}
	
//	public String getNationalIDNumber() {
//		if (Globals.settings.isNationalIDNumber()) {
//			return person.getNationalIdentityCardNumber();
//		} else nationalIDNumber = "";
//	}
	public String getNationalIDType() {
		if (Globals.settings.isNationalIDType()) {
			return dataMaster.getRandomValue(NATIONAL_ID_TYPE);
		} else return "";
	}
	public String getCountry() {
		if (Globals.settings.isIDCountry()) {
			return dataMaster.getRandomValue(COUNTRY);
		} else return "";
	}
	public boolean getIsPrimary() {
		if (Globals.settings.isNationalIDisPrimary()) {
			return true;
		} else return false;
	}
		
}
