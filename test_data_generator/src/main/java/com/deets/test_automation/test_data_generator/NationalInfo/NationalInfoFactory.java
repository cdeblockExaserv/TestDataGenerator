package com.deets.test_automation.test_data_generator.NationalInfo;

public interface NationalInfoFactory {

	NationalInfoProvider produceNationalInfoProvider(NationalInfoProperties.Property... properties);
	
}
