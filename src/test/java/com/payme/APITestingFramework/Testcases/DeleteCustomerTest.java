package com.payme.APITestingFramework.Testcases;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.payme.APITestingFramework.APIs.DeleteCustomerAPI;
import com.payme.APITestingFramework.Setup.BaseTest;
import com.payme.APITestingFramework.TestUtils.TestUtil;
import com.payme.APITestingFramework.Utilites.DataUtils;
import com.payme.APITestingFramework.listeners.ExtentListeners;

import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseTest {
	
	@Test (dataProviderClass=DataUtils.class , dataProvider="data")
	public void deleteCust(Hashtable<String, String> data) {
		
		
		Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerWithValidId(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		
		/*	1ST way--	Validating key value using json path and putting assert
		 * 
		 * 			String actual_ID=response.jsonPath().get("id").toString();
		
					System.out.println("Getting id From JSON Path :-"+actual_ID);
		
					Assert.assertEquals(actual_ID, data.get("id"),"ID not Matched");
		
		*/
		
		/*		2ND way-- using jsonObject validating 
		 * 
		 * 
		 * 			JSONObject jsonObject = new JSONObject(response.asString());
		
					System.out.println(jsonObject.has("id"));
		
					Assert.assertTrue(jsonObject.has("id"),"ID Key is not present ");
		
		*/
		
		
		/* 3rd way-- Validating using testUtil customized methods */
		
			Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"));
			Assert.assertEquals(TestUtil.getJsonKeyValue(response.asString(), "id"),"ID not Matched");	
		System.out.println("Presence check of Deleted key :-"+TestUtil.jsonHasKey(response.asString(), "deleted"));
		System.out.println("Presence check of object key :-"+TestUtil.jsonHasKey(response.asString(), "object"));
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}

}
