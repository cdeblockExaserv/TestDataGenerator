package com.deets.test_automation.test_data_generator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Generator")
public class SettingsPage {
	//bio
	private boolean employeeID;
	private boolean age;
	private boolean dateOfBirth;
	private boolean firstName;
	private boolean middleName;
	private boolean lastName;
	private boolean prefix;
	private boolean suffix;
	private boolean gender;
	private boolean displayName;
	private boolean birthName;
	private boolean preferedName;
	private boolean nativePreferedLanguage;
	private boolean maritalStatus;
	private boolean maritalStatusSince;
	private boolean nationality;
	//email
	private boolean emailAddress;
	private boolean emailType;
	private boolean emailIsPrimary;
	//address
	private boolean street;
	private boolean streetNumber;
	private boolean apartmentNumber;
	private boolean city;
	private boolean zipcode;
	private boolean country;
	private boolean addressType;
	private boolean state;
	//phone
	private boolean phoneType;
	private boolean countryCode;
	private boolean areaCode;
	private boolean phoneNumber;
	private boolean extension;
	private boolean isPhonePrimary;
	//dependent
	private boolean relationship;
	private boolean dependentDate;
	private boolean dependentFirstName;
	private boolean dependentMiddleName;
	private boolean dependentLastName;
	//nationalInfo
	private boolean nationalIDNumber;
	private boolean nationalIDType;
	private boolean IDCountry;
	private boolean nationalIDisPrimary;
	//EmergencyContact
	private boolean emergencyRelationship;
	private boolean emergencyName;
	private boolean emergencyMail;
	private boolean emergencyPhone;
	private boolean emergencyIsPrimary;
	//jobInfo
	private boolean incumbent;
	private boolean position;
	private boolean positionEntrydate;
	private boolean company;
	private boolean businessUnit;
	private boolean division;
	private boolean department;
	private boolean location;
	private boolean costCenter;
	private boolean timeZone;
	private boolean supervisor;
	private boolean jobClassification;
	private boolean positionTitle;
	private boolean localJobTitle;
	private boolean payGrade;
	private boolean isRegular;
	private boolean standardWeeklyHours;
	private boolean fte;
	private boolean isFulltime;
	private boolean employeeClass;
	private boolean shiftCode;
	private boolean fslaStatus;
	private boolean jobEntryDate;
	private boolean leaveOfAbsenceStartDate;
	private boolean leaveOfAbsenceReturnDate;
	private boolean lmsJobCodeID;
	private boolean eeoJobGroup;
	private boolean eeoCategory1;
	private boolean eeoCategory4;
	private boolean eeoCategory5;
	private boolean eeoCategory6;
	//customFields
	private boolean customField1;
	private boolean customField2;
	private boolean customField3;
	private boolean customField4;
	private boolean customField5;
	private boolean customField6;
	private boolean customField7;
	private boolean customField8;
	private boolean customField9;
	private boolean customField10;
	
	public SettingsPage() {
		super();
	}

	public boolean isEmployeeID() {
		return employeeID;
	}

	public boolean isAge() {
		return age;
	}

	public boolean isDateOfBirth() {
		return dateOfBirth;
	}

	public boolean isFirstName() {
		return firstName;
	}

	public boolean isMiddleName() {
		return middleName;
	}

	public boolean isLastName() {
		return lastName;
	}

	public boolean isPrefix() {
		return prefix;
	}

	public boolean isSuffix() {
		return suffix;
	}

	public boolean isGender() {
		return gender;
	}

	public boolean isDisplayName() {
		return displayName;
	}

	public boolean isBirthName() {
		return birthName;
	}

	public boolean isPreferedName() {
		return preferedName;
	}

	public boolean isNativePreferedLanguage() {
		return nativePreferedLanguage;
	}

	public boolean isMaritalStatus() {
		return maritalStatus;
	}

	public boolean isMaritalStatusSince() {
		return maritalStatusSince;
	}

	public boolean isNationality() {
		return nationality;
	}
	
	public boolean isEmailAddress() {
		return emailAddress;
	}

	public boolean isEmailType() {
		return emailType;
	}

	public boolean emailIsPrimary() {
		return emailIsPrimary;
	}
	
	public boolean isPhoneType() {
		return phoneType;
	}

	public boolean isCountryCode() {
		return countryCode;
	}

	public boolean isAreaCode() {
		return areaCode;
	}
	
	public boolean isPhoneNumber() {
		return phoneNumber;
	}

	public boolean isExtension() {
		return extension;
	}

	public boolean phoneIsPrimary() {
		return isPhonePrimary;
	}

	public boolean isStreet() {
		return street;
	}

	public boolean isStreetNumber() {
		return streetNumber;
	}

	public boolean isApartmentNumber() {
		return apartmentNumber;
	}

	public boolean isCity() {
		return city;
	}

	public boolean isZipcode() {
		return zipcode;
	}

	public boolean isCountry() {
		return country;
	}

	public boolean isAddressType() {
		return addressType;
	}

	public boolean isState() {
		return state;
	}

	public boolean isRelationship() {
		return relationship;
	}

	public boolean isDependentDate() {
		return dependentDate;
	}

	public boolean isDependentFirstName() {
		return dependentFirstName;
	}

	public boolean isDependentMiddleName() {
		return dependentMiddleName;
	}

	public boolean isDependentLastName() {
		return dependentLastName;
	}

	public boolean isNationalIDNumber() {
		return nationalIDNumber;
	}

	public boolean isNationalIDType() {
		return nationalIDType;
	}

	public boolean isNationalIDisPrimary() {
		return nationalIDisPrimary;
	}

	public boolean isIDCountry() {
		return IDCountry;
	}
	
	public boolean isEmergencyRelationship() {
		return emergencyRelationship;
	}

	public boolean isEmergencyName() {
		return emergencyName;
	}

	public boolean isEmergencyMail() {
		return emergencyMail;
	}

	public boolean isEmergencyPhone() {
		return emergencyPhone;
	}

	public boolean isEmergencyIsPrimary() {
		return emergencyIsPrimary;
	}

	public boolean isIncumbent() {
		return incumbent;
	}

	public boolean isPosition() {
		return position;
	}

	public boolean isPositionEntrydate() {
		return positionEntrydate;
	}

	public boolean isCompany() {
		return company;
	}

	public boolean isBusinessUnit() {
		return businessUnit;
	}

	public boolean isDivision() {
		return division;
	}

	public boolean isDepartment() {
		return department;
	}

	public boolean isLocation() {
		return location;
	}

	public boolean isCostCenter() {
		return costCenter;
	}

	public boolean isTimeZone() {
		return timeZone;
	}

	public boolean isSupervisor() {
		return supervisor;
	}

	public boolean isJobClassification() {
		return jobClassification;
	}

	public boolean isPositionTitle() {
		return positionTitle;
	}

	public boolean isLocalJobTitle() {
		return localJobTitle;
	}

	public boolean isPayGrade() {
		return payGrade;
	}

	public boolean isRegular() {
		return isRegular;
	}

	public boolean isStandardWeeklyHours() {
		return standardWeeklyHours;
	}

	public boolean isFte() {
		return fte;
	}

	public boolean isFulltime() {
		return isFulltime;
	}

	public boolean isEmployeeClass() {
		return employeeClass;
	}

	public boolean isShiftCode() {
		return shiftCode;
	}

	public boolean isFslaStatus() {
		return fslaStatus;
	}

	public boolean isJobEntryDate() {
		return jobEntryDate;
	}

	public boolean isLeaveOfAbsenceStartDate() {
		return leaveOfAbsenceStartDate;
	}

	public boolean isLeaveOfAbsenceReturnDate() {
		return leaveOfAbsenceReturnDate;
	}

	public boolean isLmsJobCodeID() {
		return lmsJobCodeID;
	}

	public boolean isEeoJobGroup() {
		return eeoJobGroup;
	}

	public boolean isEeoCategory1() {
		return eeoCategory1;
	}

	public boolean isEeoCategory4() {
		return eeoCategory4;
	}

	public boolean isEeoCategory5() {
		return eeoCategory5;
	}

	public boolean isEeoCategory6() {
		return eeoCategory6;
	}

	public boolean isCustomField1() {
		return customField1;
	}

	public boolean isCustomField2() {
		return customField2;
	}

	public boolean isCustomField3() {
		return customField3;
	}

	public boolean isCustomField4() {
		return customField4;
	}

	public boolean isCustomField5() {
		return customField5;
	}

	public boolean isCustomField6() {
		return customField6;
	}

	public boolean isCustomField7() {
		return customField7;
	}

	public boolean isCustomField8() {
		return customField8;
	}

	public boolean isCustomField9() {
		return customField9;
	}

	public boolean isCustomField10() {
		return customField10;
	}

	@XmlElement(name="EmployeeID")
	public void setEmployeeID(boolean employeeID) {
		this.employeeID = employeeID;
	}

	@XmlElement(name="Age")
	public void setAge(boolean age) {
		this.age = age;
	}

	@XmlElement(name="DateOfBirth")
	public void setDateOfBirth(boolean dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@XmlElement(name="FirstName")
	public void setFirstName(boolean firstName) {
		this.firstName = firstName;
	}

	@XmlElement(name="MiddleName")
	public void setMiddleName(boolean middleName) {
		this.middleName = middleName;
	}

	@XmlElement(name="LastName")
	public void setLastName(boolean lastName) {
		this.lastName = lastName;
	}

	@XmlElement(name="Prefix")
	public void setPrefix(boolean prefix) {
		this.prefix = prefix;
	}

	@XmlElement(name="Suffix")
	public void setSuffix(boolean suffix) {
		this.suffix = suffix;
	}

	@XmlElement(name="Gender")
	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@XmlElement(name="DisplayName")
	public void setDisplayName(boolean displayName) {
		this.displayName = displayName;
	}

	@XmlElement(name="BirthName")
	public void setBirthName(boolean birthName) {
		this.birthName = birthName;
	}

	@XmlElement(name="PreferedName")
	public void setPreferedName(boolean preferedName) {
		this.preferedName = preferedName;
	}

	@XmlElement(name="NativePreferedLanguage")
	public void setNativePreferedLanguage(boolean nativePreferedLanguage) {
		this.nativePreferedLanguage = nativePreferedLanguage;
	}

	@XmlElement(name="MaritalStatus")
	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@XmlElement(name="MaritalStatusSince")
	public void setMaritalStatusSince(boolean maritalStatusSince) {
		this.maritalStatusSince = maritalStatusSince;
	}

	@XmlElement(name="Nationality")
	public void setNationality(boolean nationality) {
		this.nationality = nationality;
	}

	@XmlElement(name="EmailAddress")
	public void setEmailAddress(boolean emailAddress) {
		this.emailAddress = emailAddress;
	}

	@XmlElement(name="EmailType")
	public void setEmailType(boolean emailType) {
		this.emailType = emailType;
	}
	
	@XmlElement(name="EmailIsPrimary")
	public void setEmailIsPrimary(boolean primary) {
		this.emailIsPrimary = primary;
	}

	@XmlElement(name="PhoneIsPrimary")
	public void setPhonePrimary(boolean isPrimary) {
		this.isPhonePrimary = isPrimary;
	}
	
	@XmlElement(name="CountryCode")
	public void setCountryCode(boolean countryCode) {
		this.countryCode = countryCode;
	}
	
	@XmlElement(name="AreaCode")
	public void setAreaCode(boolean areaCode) {
		this.areaCode = areaCode;
	}
	
	@XmlElement(name="PhoneType")
	public void setPhoneType(boolean phoneType) {
		this.phoneType = phoneType;
	}

	@XmlElement(name="PhoneNumber")
	public void setPhoneNumber(boolean phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@XmlElement(name="Extension")
	public void setExtension(boolean extension) {
		this.extension = extension;
	}

	@XmlElement(name="Street")
	public void setStreet(boolean street) {
		this.street = street;
	}

	@XmlElement(name="StreetNumber")
	public void setStreetNumber(boolean streetNumber) {
		this.streetNumber = streetNumber;
	}

	@XmlElement(name="ApartmentNumber")
	public void setApartmentNumber(boolean apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	@XmlElement(name="City")
	public void setCity(boolean city) {
		this.city = city;
	}

	@XmlElement(name="ZipCode")
	public void setZipcode(boolean zipcode) {
		this.zipcode = zipcode;
	}

	@XmlElement(name="Country")
	public void setCountry(boolean country) {
		this.country = country;
	}

	@XmlElement(name="AddressType")
	public void setAddressType(boolean addressType) {
		this.addressType = addressType;
	}

	@XmlElement(name="State")
	public void setState(boolean state) {
		this.state = state;
	}

	@XmlElement(name="Relationship")
	public void setRelationship(boolean relationship) {
		this.relationship = relationship;
	}

	@XmlElement(name="DependentDateOfBirth")
	public void setDependentDate(boolean dependentDate) {
		this.dependentDate = dependentDate;
	}

	@XmlElement(name="DependentFirstName")
	public void setDependentFirstName(boolean dependentFirstName) {
		this.dependentFirstName = dependentFirstName;
	}

	@XmlElement(name="DependentMiddleName")
	public void setDependentMiddleName(boolean dependentMiddleName) {
		this.dependentMiddleName = dependentMiddleName;
	}

	@XmlElement(name="DependentLastName")
	public void setDependentLastName(boolean dependentLastName) {
		this.dependentLastName = dependentLastName;
	}
	
	@XmlElement(name="NationalIDNumber")
	public void setNationalIDNumber(boolean nationalIDNumber) {
		this.nationalIDNumber = nationalIDNumber;
	}

	@XmlElement(name="NationalIDType")
	public void setNationalIDType(boolean nationalIDType) {
		this.nationalIDType = nationalIDType;
	}

	@XmlElement(name="NationalIDIsPrimary")
	public void setNationalIDisPrimary(boolean nationalIDisPrimary) {
		this.nationalIDisPrimary = nationalIDisPrimary;
	}
	
	@XmlElement(name="IDCountry")
	public void setIDCountry(boolean IDCountry) {
		this.IDCountry = IDCountry;
	}
	
	@XmlElement(name="EmergencyContactRelationship")
	public void setEmergencyRelationship(boolean emergencyRelationship) {
		this.emergencyRelationship = emergencyRelationship;
	}
	
	@XmlElement(name="EmergencyContactName")
	public void setEmergencyName(boolean emergencyName) {
		this.emergencyName = emergencyName;
	}
	
	@XmlElement(name="EmergencyContactMail")
	public void setEmergencyMail(boolean emergencyMail) {
		this.emergencyMail = emergencyMail;
	}
	
	@XmlElement(name="EmergencyContactPhone")
	public void setEmergencyPhone(boolean emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}
	
	@XmlElement(name="EmergencyContactIsPrimary")
	public void setEmergencyIsPrimary(boolean emergencyIsPrimary) {
		this.emergencyIsPrimary = emergencyIsPrimary;
	}

	@XmlElement(name="Incumbent")
	public void setIncumbent(boolean incumbent) {
		this.incumbent = incumbent;
	}

	@XmlElement(name="Position")
	public void setPosition(boolean position) {
		this.position = position;
	}

	@XmlElement(name="PositionEntryDate")
	public void setPositionEntrydate(boolean positionEntrydate) {
		this.positionEntrydate = positionEntrydate;
	}

	@XmlElement(name="Company")
	public void setCompany(boolean company) {
		this.company = company;
	}

	@XmlElement(name="BusinessUnit")
	public void setBusinessUnit(boolean businessUnit) {
		this.businessUnit = businessUnit;
	}

	@XmlElement(name="Division")
	public void setDivision(boolean division) {
		this.division = division;
	}

	@XmlElement(name="Department")
	public void setDepartment(boolean department) {
		this.department = department;
	}

	@XmlElement(name="Location")
	public void setLocation(boolean location) {
		this.location = location;
	}

	@XmlElement(name="CostCenter")
	public void setCostCenter(boolean costCenter) {
		this.costCenter = costCenter;
	}

	@XmlElement(name="TimeZone")
	public void setTimeZone(boolean timeZone) {
		this.timeZone = timeZone;
	}

	@XmlElement(name="Supervisor")
	public void setSupervisor(boolean supervisor) {
		this.supervisor = supervisor;
	}

	@XmlElement(name="JobClassification")
	public void setJobClassification(boolean jobClassification) {
		this.jobClassification = jobClassification;
	}

	@XmlElement(name="PositionTitle")
	public void setPositionTitle(boolean positionTitle) {
		this.positionTitle = positionTitle;
	}

	@XmlElement(name="LocalJobTitle")
	public void setLocalJobTitle(boolean localJobTitle) {
		this.localJobTitle = localJobTitle;
	}

	@XmlElement(name="PayGrade")
	public void setPayGrade(boolean payGrade) {
		this.payGrade = payGrade;
	}

	@XmlElement(name="IsRegular")
	public void setRegular(boolean isRegular) {
		this.isRegular = isRegular;
	}

	@XmlElement(name="StandardWeeklyHours")
	public void setStandardWeeklyHours(boolean standardWeeklyHours) {
		this.standardWeeklyHours = standardWeeklyHours;
	}

	@XmlElement(name="FTE")
	public void setFte(boolean fte) {
		this.fte = fte;
	}

	@XmlElement(name="IsFulltime")
	public void setFulltime(boolean isFulltime) {
		this.isFulltime = isFulltime;
	}

	@XmlElement(name="EmployeeClass")
	public void setEmployeeClass(boolean employeeClass) {
		this.employeeClass = employeeClass;
	}

	@XmlElement(name="ShiftCode")
	public void setShiftCode(boolean shiftCode) {
		this.shiftCode = shiftCode;
	}

	@XmlElement(name="FSLAStatus")
	public void setFslaStatus(boolean fslaStatus) {
		this.fslaStatus = fslaStatus;
	}

	@XmlElement(name="JobEntryDate")
	public void setJobEntryDate(boolean jobEntryDate) {
		this.jobEntryDate = jobEntryDate;
	}

	@XmlElement(name="LeaveOfAbsenceStartDate")
	public void setLeaveOfAbsenceStartDate(boolean leaveOfAbsenceStartDate) {
		this.leaveOfAbsenceStartDate = leaveOfAbsenceStartDate;
	}

	@XmlElement(name="LeaveOfAbsenceReturnDate")
	public void setLeaveOfAbsenceReturnDate(boolean leaveOfAbsenceReturnDate) {
		this.leaveOfAbsenceReturnDate = leaveOfAbsenceReturnDate;
	}

	@XmlElement(name="LMSJobCodeID")
	public void setLmsJobCodeID(boolean lmsJobCodeID) {
		this.lmsJobCodeID = lmsJobCodeID;
	}

	@XmlElement(name="EEOJobGroup")
	public void setEeoJobGroup(boolean eeoJobGroup) {
		this.eeoJobGroup = eeoJobGroup;
	}

	@XmlElement(name="EEOCategory1")
	public void setEeoCategory1(boolean eeoCategory1) {
		this.eeoCategory1 = eeoCategory1;
	}

	@XmlElement(name="EEOCategory4")
	public void setEeoCategory4(boolean eeoCategory4) {
		this.eeoCategory4 = eeoCategory4;
	}

	@XmlElement(name="EEOCategory5")
	public void setEeoCategory5(boolean eeoCategory5) {
		this.eeoCategory5 = eeoCategory5;
	}

	@XmlElement(name="EEOCategory6")
	public void setEeoCategory6(boolean eeoCategory6) {
		this.eeoCategory6 = eeoCategory6;
	}
	
	@XmlElement(name="CustomField1")
	public void setCustomField1(boolean customField1) {
		this.customField1 = customField1;
	}
	
	@XmlElement(name="CustomField2")
	public void setCustomField2(boolean customField2) {
		this.customField2 = customField2;
	}
	
	@XmlElement(name="CustomField3")
	public void setCustomField3(boolean customField3) {
		this.customField3 = customField3;
	}
	
	@XmlElement(name="CustomField4")
	public void setCustomField4(boolean customField4) {
		this.customField4 = customField4;
	}
	
	@XmlElement(name="CustomField5")
	public void setCustomField5(boolean customField5) {
		this.customField5 = customField5;
	}
	
	@XmlElement(name="CustomField6")
	public void setCustomField6(boolean customField6) {
		this.customField6 = customField6;
	}
	
	@XmlElement(name="CustomField7")
	public void setCustomField7(boolean customField7) {
		this.customField7 = customField7;
	}
	
	@XmlElement(name="CustomField8")
	public void setCustomField8(boolean customField8) {
		this.customField8 = customField8;
	}
	
	@XmlElement(name="CustomField9")
	public void setCustomField9(boolean customField9) {
		this.customField9 = customField9;
	}
	
	@XmlElement(name="CustomField10")
	public void setCustomField10(boolean customField10) {
		this.customField10 = customField10;
	}
	
	
	
	
}
