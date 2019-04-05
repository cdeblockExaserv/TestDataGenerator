package com.deets.test_automation.test_data_generator.Job;

public interface JobFactory {

	JobProvider produceJobProvider(JobProperties.JobProperty jobProperties);
	
}
