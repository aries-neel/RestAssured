package com.payme.APITestingFramework.TestUtils;

import org.json.JSONObject;

import com.payme.APITestingFramework.listeners.ExtentListeners;

public class TestUtil {

	public static boolean jsonHasKey(String json, String key) {

		JSONObject jsObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating the Presence of Key:-"+ key);
		return jsObject.has(key);

	}

	public static String getJsonKeyValue(String json, String key) {

		JSONObject jsObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("Validating value of Key:-"+ key);
		return jsObject.get(key).toString();
	}

}
