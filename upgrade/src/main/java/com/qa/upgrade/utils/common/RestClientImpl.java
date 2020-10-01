package com.qa.upgrade.utils.common;

import static io.restassured.RestAssured.when;
import com.qa.upgrade.common.abstraction.IRestClient;
import io.restassured.response.Response;

public class RestClientImpl implements IRestClient{

	@Override
	public WResponse get(String path) {
		
		Response resp =
		when().
			get(path).
		then().
			assertThat().statusCode(200).log().all().extract().response();

		return new WResponse(resp);
	}
}