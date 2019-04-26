package com.deets.test_automation.test_data_generator.Employee.Email;

public interface EmailFactory {

	EmailProvider produceEmailProvider(EmailProperties.EmailProperty emailProperties);
}
