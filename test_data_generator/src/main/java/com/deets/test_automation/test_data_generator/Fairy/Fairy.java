/*
 * Copyright (c) 2013 Codearte
 
	package com.devskiller.jfairy;
*/

package com.deets.test_automation.test_data_generator.Fairy;


import javax.inject.Inject;
import java.util.Locale;

import com.google.inject.Provider;
import com.deets.test_automation.test_data_generator.Employee.Employee;
import com.deets.test_automation.test_data_generator.Employee.EmployeeFactory;
import com.deets.test_automation.test_data_generator.Employee.EmployeeProperties;
//import com.devskiller.jfairy.Bootstrap;
import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.devskiller.jfairy.producer.company.Company;
import com.devskiller.jfairy.producer.company.CompanyFactory;
import com.devskiller.jfairy.producer.company.CompanyProperties;
import com.devskiller.jfairy.producer.net.NetworkProducer;
import com.devskiller.jfairy.producer.payment.CreditCard;
import com.devskiller.jfairy.producer.payment.CreditCardProvider;
import com.devskiller.jfairy.producer.payment.IBAN;
import com.devskiller.jfairy.producer.payment.IBANFactory;
import com.devskiller.jfairy.producer.payment.IBANProperties;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.person.PersonFactory;
import com.devskiller.jfairy.producer.person.PersonProperties;
import com.devskiller.jfairy.producer.text.TextProducer;

public final class Fairy {

	private final TextProducer textProducer;
	private final PersonFactory personFactory;
	private final EmployeeFactory employeeFactory;
	private final NetworkProducer networkProducer;
	private final BaseProducer baseProducer;
	private final DateProducer dateProducer;
	private final CreditCardProvider creditCardProvider;
	private final CompanyFactory companyFactory;
	private final IBANFactory ibanFactory;

	@Inject
	Fairy(TextProducer textProducer, PersonFactory personFactory, EmployeeFactory employeeFactory, NetworkProducer networkProducer,
	      BaseProducer baseProducer, DateProducer dateProducer, CreditCardProvider creditCardProvider,
	      CompanyFactory companyFactory, IBANFactory ibanFactory) {
		this.textProducer = textProducer;
		this.personFactory = personFactory;
		this.employeeFactory = employeeFactory;
		this.networkProducer = networkProducer;
		this.baseProducer = baseProducer;
		this.dateProducer = dateProducer;
		this.creditCardProvider = creditCardProvider;
		this.companyFactory = companyFactory;
		this.ibanFactory = ibanFactory;
	}

	public static Fairy create() {
		return Bootstrap.create();
	}

	public static Fairy create(Locale locale) {
		return Bootstrap.create(locale);
	}

	public static Fairy create(Provider<DataMaster> dataMasterProvider, Locale locale) {
		return Bootstrap.create(dataMasterProvider, locale);
	}


	public static Bootstrap.Builder builder() {
		return Bootstrap.builder();
	}

	/**
	 * Use this method for generating texts
	 *
	 * @return A {@link com.devskiller.jfairy.producer.text.TextProducer} instance
	 */
	public TextProducer textProducer() {
		return textProducer;
	}

	/**
	 * Use this method for fake persons
	 *
	 * @param personProperties desired person features
	 * @return A {@link com.devskiller.jfairy.producer.person.Person} instance
	 */
	public Person person(PersonProperties.PersonProperty... personProperties) {
		return personFactory.producePersonProvider(personProperties).get();
	}
	
	/**
	 * Use this method for fake employees
	 *
	 * @param employeeProperties desired employee features
	 * @return A {@link com.deets.test_automation.test_data_generator.Employee.Employee} instance
	 */
	public Employee employee( EmployeeProperties.EmployeeProperty... employeeProperties) {
		return employeeFactory.produceEmployeeProvider(employeeProperties).get();
	}

	/**
	 * Use this method to generate fake company
	 *
	 * @param companyProperties desired company features
	 * @return A {@link com.devskiller.jfairy.producer.company.CompanyProvider} instance
	 */
	public Company company(CompanyProperties.CompanyProperty... companyProperties) {
		return companyFactory.produceCompany(companyProperties).get();
	}

	/**
	 * Use this method for get standard tools
	 *
	 * @return A {@link com.devskiller.jfairy.producer.BaseProducer} instance
	 */
	public BaseProducer baseProducer() {
		return baseProducer;
	}

	public DateProducer dateProducer() {
		return dateProducer;
	}

	/**
	 * Use this method for generating IBAN (International Bank Account Number)
	 *
	 * @return A {@link com.devskiller.jfairy.producer.payment.IBAN} instance
	 */
	public IBAN iban() {
		return ibanFactory.produceIBANProvider().get();
	}

	/**
	 * Use this method for generating IBAN (International Bank Account Number)
	 *
	 * @param properties desired IBAN features
	 * @return A {@link com.devskiller.jfairy.producer.payment.IBAN} instance
	 */
	public IBAN iban(IBANProperties.Property... properties) {
		return ibanFactory.produceIBANProvider(properties).get();
	}

	public CreditCard creditCard() {
		return creditCardProvider.get();
	}

	public NetworkProducer networkProducer() {
		return networkProducer;
	}
}
