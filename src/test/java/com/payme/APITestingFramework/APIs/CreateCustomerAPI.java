package com.payme.APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.payme.APITestingFramework.Setup.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest {
	
	// separating business logic from test case
	
	public static Response sendPostRequestToCreateCustomerWithValidAuthKey(Hashtable<String, String> data) {
		
		
		Response response = given().auth().basic(prop.getProperty("validSecretKey"), "")
							.formParam("name", data.get("name"))
							.formParam("email", data.get("email"))
							.formParam("description", data.get("description"))
		
							.post(prop.getProperty("customerEndPoint"));
		
		return response;
		
		
	}
	
	// separating business logic from test case
	
public static Response sendPostRequestToCreateCustomerWithInValidAuthKey(Hashtable<String, String> data) {
		
		
		Response response = given().auth().basic(prop.getProperty("invalidSecretKey"), "")
							.formParam("name", data.get("name"))
							.formParam("email", data.get("email"))
							.formParam("description", data.get("description"))
		
							.post(prop.getProperty("customerEndPoint"));
		
		return response;
		
		
	}
	
	
	
	
	
	
	
	

}
