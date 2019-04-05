package com.deets.test_automation.test_data_generator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Dictionary {
	
	private HashMap<String, String> relationships = new HashMap<String, String>();
	private HashMap<String, String> maritalStates = new HashMap<String,String>();

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
	}

	public HashMap<String, String> getRelationships() {
		return relationships;
	}

	public HashMap<String, String> getMaritalStates() {
		return maritalStates;
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

}
