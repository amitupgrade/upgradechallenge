package com.test.upgrade.common.utility;

import static io.restassured.RestAssured.*;

import com.test.upgrade.pojo.Users;

import io.restassured.response.Response;

public class RestClientHelper{
	
	public RespUtils get(String path) {
		
		Response resp =
		when().
			get(path).
		then().
			assertThat().statusCode(200).log().all().extract().response();

		return new RespUtils(resp);
	}
	
	
	public RespUtils post(String path, Users user) {

		Response resp =
		given().log().all().
			header("x-cf-source-id", "coding-challenge").
			header("x-cf-corr-id", "b155502e-fc46-11ea-adc1-0242ac120002").
			header("Content-Type", "application/json").
			body(user).
		when().
			post(path).
		then().
		log().all().extract().response();	

		return new RespUtils(resp);
	}
}
