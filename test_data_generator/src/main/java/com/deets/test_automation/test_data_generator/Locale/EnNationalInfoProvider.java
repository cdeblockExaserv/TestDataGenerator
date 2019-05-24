package com.deets.test_automation.test_data_generator.Locale;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.Globals;
import com.deets.test_automation.test_data_generator.Employee.NationalInfo.AbstractNationalInfoProvider;
import com.deets.test_automation.test_data_generator.Employee.NationalInfo.NationalInfo;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.person.Person;
import com.google.inject.Inject;

public class EnNationalInfoProvider extends AbstractNationalInfoProvider{

	private String number;
	private String type;
	private boolean isPrimary;
	private String country;
	
	@Inject
	public EnNationalInfoProvider(DataMaster dataMaster, BaseProducer baseProducer) {
		super(dataMaster, baseProducer);
		this.type = super.getNationalIDType();
		this.isPrimary = super.getIsPrimary();
		this.country = super.getCountry();
	}
	
	public String getNationalIDNumber() {		
		if (Globals.settings.isNationalIDNumber()) {
			number = Globals.IDarea + "-" + 
						baseProducer.numerify("##").toString() + "-" + 
						baseProducer.numerify("####").toString();
			return number;
		} else {
			return "";
		}
	}

	@Override
	public NationalInfo get(Person.Sex sex, LocalDate dob) {
		return new NationalInfo(getNationalIDNumber(), type, country, isPrimary);
	}

	@Override
	public NationalInfo get() {
		return new NationalInfo(getNationalIDNumber(), type, country, isPrimary);
				
	}


}
