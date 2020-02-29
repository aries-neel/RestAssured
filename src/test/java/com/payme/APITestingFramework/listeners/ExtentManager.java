package com.payme.APITestingFramework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String FileName) {
		
		ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter(FileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setReportName(FileName);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		extent.setSystemInfo("Automation Tester ","Neelmani Singh");
		extent.setSystemInfo("Organization ", "payme");
		extent.setSystemInfo("Build No.", "payme-1234");
		
		return extent;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
