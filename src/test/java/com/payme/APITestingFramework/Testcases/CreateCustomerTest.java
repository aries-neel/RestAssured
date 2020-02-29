package com.payme.APITestingFramework.Testcases;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.payme.APITestingFramework.APIs.CreateCustomerAPI;
import com.payme.APITestingFramework.Setup.BaseTest;
import com.payme.APITestingFramework.Utilites.DataUtils;
import com.payme.APITestingFramework.listeners.ExtentListeners;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest{
	
	/* with limited optimization
	@Test
	public void validateCreateCustomerAPIWithValidSecretKey() {
		
		RestAssured.baseURI="https://api.stripe.com";
		RestAssured.basePath ="/v1";
		Response response = given().auth().basic("sk_test_lsiwjIexmN0I0WJ1ddS2aDvp00Kd0MB6EY", "")
		.formParam("email", "neel1904@gmail.com")
		.formParam("description", "this is the first customer from framework")
		.post("/customers");
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	@Test
	public void validateCreateCustomerAPIWithINvalidSecretKey() {
		
		RestAssured.baseURI="https://api.stripe.com";
		RestAssured.basePath ="/v1";
		
		Response response = given().auth().basic("sk_test_lsiwjIexmN0I0WJ1ddS2aDvp00Kd0MB6EY123", "")
		.formParam("email", "neel1904@gmail.com")
		.formParam("description", "this is the first customer from framework")
		.post("/customers");
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	*/
	
	@Test (dataProviderClass=DataUtils.class , dataProvider="data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {
		
		
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerWithValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	/*
	 * @Test(dataProvider="getData")
	public void validateCreateCustomerAPIWithINvalidSecretKey(String email ,String name ,String desc) {
		
		RestAssured.baseURI="https://api.stripe.com";
		RestAssured.basePath ="/v1";
		
		Response response = given().auth().basic(prop.getProperty("InvalidSecretKey"), "")
		.formParam("email", email)
		.formParam("name", name)
		.formParam("description", desc)
		.post(prop.getProperty("customerEndPoint"));
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		String SheetName="APITestData";
		int rows=excel.getRowCount(SheetName);
		int cols = excel.getColumnCount(SheetName);
		
		Object[][] data = new Object[rows][cols];
		
		for(int row=2;row<=rows;row++) {
			
			for(int col=0;col<3;col++) {
				
			data[row-2][col] = excel.getCellData(SheetName, col, row);
			
			}
			
		}
			
		data [0][0] = "new@gmail.com";
		data [0][1] ="kumar";
		data [0][2] ="this is first payme account in framework";
		
		data [1][0] = "nath@gmail.com";
		data [1][1] ="nilam";
		data [1][2] ="this is second payme account in framework";
		
		return data;
	}
	@DataProvider
	public Object[][] getData() {
		
		String SheetName="APITestData";
		int rows=excel.getRowCount(SheetName);
		int cols = excel.getColumnCount(SheetName);
		
		Object[][] data = new Object[rows][cols];
		
		for(int row=2;row<=rows;row++) {
			
			for(int col=0;col<3;col++) {
				
			data[row-2][col] = excel.getCellData(SheetName, col, row);
			
			}
			*/
		}
	
		



