package com.deets.test_automation.test_data_generator.Employee.Address;


public abstract class AbstractAddress implements Address{
	
	protected String street;
	protected String streetNumber;
	protected String apartmentNumber;
	protected String postalCode;
	protected String city;
	protected String country;
	protected String addressType;
	protected String state;

	public AbstractAddress(String street, String streetNumber, String apartmentNumber, String postalCode, String city,
				String country, String addressType, String state) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.apartmentNumber = apartmentNumber;
		this.country = country;
		this.addressType = addressType;
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getStreet() {
		return street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public abstract String getAddressLine1();

	public abstract String getAddressLine2();

	@Override
	public String toString() {
		return getAddressLine1() + System.lineSeparator() + getAddressLine2();
	}
	
	

}
