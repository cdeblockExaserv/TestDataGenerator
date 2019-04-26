package com.deets.test_automation.test_data_generator.Employee;

import java.io.IOException;
import java.time.LocalDate;

import com.devskiller.jfairy.data.DataMaster;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.DateProducer;
import com.google.common.annotations.VisibleForTesting;

public class CustomField {

	@VisibleForTesting
	String CUSTOM_FIELD = "customField";
	@VisibleForTesting
	String PICKLIST = "picklist";
	@VisibleForTesting
	String TYPE = "type";
	@VisibleForTesting
	String INCREMENTAL_START = "incrementalStart";
	@VisibleForTesting
	String FORMAT = "format";
	@VisibleForTesting
	String RANGE_START = "rangeStart";
	@VisibleForTesting
	String RANGE_END = "rangeEnd";
	@VisibleForTesting
	String RANGE_TYPE = "rangeType";
	@VisibleForTesting
	String FIELD_NAME = "fieldName";

	private String type;
	private String value;
	private String fieldName;
	private String customFieldX;
	
	protected final BaseProducer baseProducer;
	protected final DataMaster dataMaster;
	protected final DateProducer dateProducer;
	
	public CustomField(BaseProducer baseProducer, DataMaster dataMaster, DateProducer dateProducer, String customFieldX) {
		super();
		
		this.baseProducer = baseProducer;
		this.dataMaster = dataMaster;
		this.dateProducer = dateProducer;
		this.customFieldX = CUSTOM_FIELD + customFieldX;
	
		this.type = dataMaster.getValuesOfType(this.customFieldX , TYPE, String.class);
		this.fieldName = dataMaster.getValuesOfType(this.customFieldX, FIELD_NAME, String.class);
		
		try {
			setValue();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setValue() throws IOException {
		if (type.equals("Incremental")) {
			//TODO: implement
		} else if (type.equals("Format")) {
			value = baseProducer.numerify(dataMaster.getValuesOfType(customFieldX, FORMAT, String.class));
		} else if (type.equals("Picklist")) {
			value = dataMaster.getValuesOfType(customFieldX, PICKLIST, String.class);
		} else if (type.equals("Range")) {
			if (dataMaster.getValuesOfType(customFieldX, RANGE_TYPE, String.class).equals("Numeric")) {
				Integer tempVal = baseProducer.randomBetween(Integer.valueOf(dataMaster.getValuesOfType(customFieldX, RANGE_START, String.class)),
						Integer.valueOf(dataMaster.getValuesOfType(customFieldX, RANGE_END, String.class)));
				value = tempVal.toString();
			} else if (dataMaster.getValuesOfType(customFieldX, RANGE_TYPE, String.class).equals("Date")) {
				value = dateProducer.randomDateBetweenTwoDates(LocalDate.parse(dataMaster.getValuesOfType(customFieldX, RANGE_START, String.class)),
						LocalDate.parse(dataMaster.getValuesOfType(customFieldX, RANGE_END, String.class))).toString();
			} else throw new IOException("No complementary range type! Choose from: Numeric or Date");
		} else throw new IOException("No complementary generation type! Choose from: Incremental, Format, Picklist or Range");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	
	
}
