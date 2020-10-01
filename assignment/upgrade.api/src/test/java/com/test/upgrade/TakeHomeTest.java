package com.test.upgrade;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.test.upgrade.base.BaseTest;
import com.test.upgrade.base.Path;
import com.test.upgrade.common.utility.RespUtils;
import com.test.upgrade.common.utility.RestClientHelper;
import com.test.upgrade.pojo.Users;

public class TakeHomeTest extends BaseTest{	

	RestClientHelper restClientHelper = new RestClientHelper();
	Users user = new Users();

	@Test (groups="regression")
	public void testLoginValid() {	
		user.setUsername("coding.challenge.login@upgrade.com");
		user.setPassword("On$3XcgsW#9q");

		RespUtils apiResponse = restClientHelper.post(Path.LOGIN, user);
		Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test (groups="regression")
	public void testProductType() {	
		user.setUsername("coding.challenge.login@upgrade.com");
		user.setPassword("On$3XcgsW#9q");

		RespUtils apiResponse = restClientHelper.post(Path.LOGIN, user);
		Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
		Assert.assertTrue(apiResponse.verifyAllProductType());
	}
	
	@Test (groups="regression")
	public void testLoginInvalidUn() {	
		user.setUsername("invalid.username@upgrade.com");
		user.setPassword("On$3XcgsW#9q");

		RespUtils apiResponse = restClientHelper.post(Path.LOGIN, user);
		Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_UNAUTHORIZED);
	}
	
	@Test (groups="regression")
	public void testLoginInvalidPwd() {	
		user.setUsername("coding.challenge.login@upgrade.com");
		user.setPassword("inv@l!dPa$$word");

		RespUtils apiResponse = restClientHelper.post(Path.LOGIN, user);
		Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_UNAUTHORIZED);
	}
	
}
