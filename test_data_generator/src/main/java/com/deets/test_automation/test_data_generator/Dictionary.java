package com.deets.test_automation.test_data_generator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Dictionary {
	
	private HashMap<String, String> relationships = new HashMap<String, String>();
	private HashMap<String, String> maritalStates = new HashMap<String,String>();
	private HashMap<String, String> emailTypes = new HashMap<String,String>();
	private HashMap<String, String> phoneTypes = new HashMap<String,String>();
 
	public Dictionary() {
		super();
		//fr
		relationships.put("Père", "Father");
		relationships.put("Mère", "Mother");
		relationships.put("Époux", "Spouse");
		relationships.put("Enfant", "Child");
		relationships.put("Autres", "Other");
		maritalStates.put("Marrié", "Married");
		maritalStates.put("Célibataire", "Single");
		maritalStates.put("Divorcé", "Divorced");
		maritalStates.put("Veuf", "Widowed");
		maritalStates.put("Séparé", "Separated");
		maritalStates.put("Partenariat Enregistré", "Registered Parntership");
		emailTypes.put("Personnel", "Personal");
		emailTypes.put("Professionnel", "Business");
		phoneTypes.put("Personnel", "Personal");
		phoneTypes.put("Professionnel", "Business");
		//en
		relationships.put("Father", "Father");
		relationships.put("Mother", "Mother");
		relationships.put("Spouse", "Spouse");
		relationships.put("Child", "Child");
		relationships.put("Other", "Other");
		maritalStates.put("Married", "Married");
		maritalStates.put("Single", "Single");
		maritalStates.put("Divorced", "Divorced");
		maritalStates.put("Widowed", "Widowed");
		maritalStates.put("Separated", "Separated");
		maritalStates.put("Registered Partnership", "Registered Parntership");
		emailTypes.put("Personal", "Personal");
		emailTypes.put("Business", "Business");
		phoneTypes.put("Personal", "Personal");
		phoneTypes.put("Business", "Business");
	}

	public HashMap<String, String> getRelationships() {
		return relationships;
	}

	public HashMap<String, String> getMaritalStates() {
		return maritalStates;
	}
	
	public HashMap<String, String> getEmailTypes() {
		return emailTypes;
	}
	
	public HashMap<String, String> getPhoneTypes() {
		return phoneTypes;
	}
	
	public String getRelationshipValue(String myKey) {
		try {
			Set<String> keys = relationships.keySet();
			for (String key : keys) {
				if (key.equals(myKey)) {
					return relationships.get(myKey);
				}
			}
			throw new IOException("No matching keys found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "No matching keys found";
	}
	
	public String getMaritalStateValue(String myKey) {
		try {
			Set<String> keys = maritalStates.keySet();
			for (String key : keys) {
				if (key.equals(myKey)) {
					return maritalStates.get(myKey);
				}
			}
			throw new IOException("No matching keys found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "No matching keys found";
	}

	public String getEmailTypeValue(String myKey) {
		try {
			Set<String> keys = emailTypes.keySet();
			for (String key : keys) {
				if (key.equals(myKey)) {
					return emailTypes.get(myKey);
				}
			}
			throw new IOException("No matching keys found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "No matching keys found";
	}
	
	public String getPhoneTypeValue(String myKey) {
		try {
			Set<String> keys = phoneTypes.keySet();
			for (String key : keys) {
				if (key.equals(myKey)) {
					return phoneTypes.get(myKey);
				}
			}
			throw new IOException("No matching keys found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "No matching keys found";
	}
}
