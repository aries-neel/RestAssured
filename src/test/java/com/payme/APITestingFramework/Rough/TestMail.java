package com.payme.APITestingFramework.Rough;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.payme.APITestingFramework.Utilites.MonitoringMail;
import com.payme.APITestingFramework.Utilites.TestConfig;

public class TestMail {

 
	public static void main(String[] args) throws AddressException, MessagingException {
		
		MonitoringMail mail= new MonitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody);

	}

}
