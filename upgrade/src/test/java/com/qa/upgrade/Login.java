package com.qa.upgrade;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.upgrade.base.BaseTest;
import com.qa.upgrade.utils.common.RestClientImpl;
import com.qa.upgrade.utils.common.WResponse;



public class Login extends BaseTest {
	
	RestClientImpl restClient = new RestClientImpl();
	
	@Test (groups="regression")
	public void testOne() {
		WResponse apiResponse = restClient.get();
		Assert.assertEquals(apiResponse.getType(), "programming");
	}

}
