package com.payme.APITestingFramework.Setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.payme.APITestingFramework.Utilites.ExcelReader;

import io.restassured.RestAssured;

//this will have all repeated codes and  test fixture methods the intialization will be done here

public class BaseTest {
	
	public static Properties prop=new Properties();;
	private FileInputStream fis;
	public  static ExcelReader excel=new ExcelReader
			(".//src/test//resources//TestDataAPITesting//testDataAPITesting.xlsx" );
	
	
	@BeforeSuite
	public void setup() {
		// read the properties file 
		
		
		try {
			fis=new FileInputStream(".//src//test//resources//properties//config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		RestAssured.basePath=prop.getProperty("basePath");
		RestAssured.baseURI=prop.getProperty("baseURI");
		
	
		
		
		
		
	}
	@AfterSuite
	public void tearDown() {
		// to generate reports 
		// send mails 
		// close database connection 
	}
	
	

}
