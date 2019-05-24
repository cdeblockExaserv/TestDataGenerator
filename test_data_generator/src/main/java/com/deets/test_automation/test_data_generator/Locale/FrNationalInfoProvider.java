package com.deets.test_automation.test_data_generator.Locale;

import java.time.LocalDate;

import com.deets.test_automation.test_data_generator.Globals;
import com.deets.test_automation.test_data_generator.Employee.NationalInfo.AbstractNationalInfoProvider;
import com.deets.test_automation.test_data_generator.Employee.NationalInfo.NationalInfo;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.person.Person.Sex;
import com.google.inject.Inject;

public class FrNationalInfoProvider extends AbstractNationalInfoProvider {

	private Integer mm;
	private Long cc;
	private String number;
	private String type;
	private boolean isPrimary;
	private String country;
	private Person.Sex sex;
	private LocalDate dob;
	
	@Inject
	public FrNationalInfoProvider(DataMaster dataMaster, BaseProducer baseProducer) {
		super(dataMaster, baseProducer);
		this.type = super.getNationalIDType();
		this.isPrimary = super.getIsPrimary();
	}
	
	public String getNationalIDNumber() {
		if (Globals.settings.isNationalIDNumber()) {
			if (sex == Sex.MALE) number = "1"; else number = "2";
			number += Integer.toString(dob.getYear()).substring(2);
			mm = dob.getMonthValue();
			if (mm < 10) number += "0" + mm.toString(); else number += mm.toString();
			number += Globals.IDarea;
			number += baseProducer.numerify("###");
			number += baseProducer.numerify("###");
			cc = 97 - (Long.valueOf(number) % 97);
			if (cc == 0) cc = (long) 97;
			if (cc < 10) number += "0" + cc.toString(); else number += cc.toString();
			return number;
		} else {
			return "";
		}
	}

	@Override
	public NationalInfo get(Person.Sex sex, LocalDate dob) {
		this.sex = sex;
		this.dob = dob;
		return new NationalInfo(getNationalIDNumber(), type, country, isPrimary);
	}

	@Override
	public NationalInfo get() {
		return new NationalInfo(getNationalIDNumber(), type, country, isPrimary);

	}

}
