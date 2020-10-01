package com.test.upgrade.common.utility;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;

public class RespUtils {

	Response response = null;
	String pathToProductTypeAll = "$.loansInReview.[*].productType";

	public RespUtils(Response rest) {
		this.response = rest;
	}

	public int getStatusCode() {
		return response.getStatusCode();
	}

	public String getResponse() {
		if(this.response != null) {
			return response.asString();
		}
		return null;
	}

	public JSONArray getProductType() {
		JSONArray records = (JSONArray) JsonPath.read(getResponse(), pathToProductTypeAll);
		return records;
	}
	
	public boolean verifyAllProductType() {
		JSONArray records = getProductType();
		boolean found = false;
		for (int i = 0; i < records.size(); i++) 
			if (records.get(i).equals("PERSONAL_LOAN"))
				found = true;
		return found;
	}
}
