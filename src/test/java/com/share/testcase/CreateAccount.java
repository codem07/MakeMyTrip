package com.share.testcase;

import org.testng.annotations.Test;

import com.share.base.TestBase;
import com.share.utilities.TestUtil;

public class CreateAccount extends TestBase {

	@Test(dataProviderClass = TestUtil.class)
	public void createAccount() throws InterruptedException {
		
		
		click("signupLogin_XPATH");

		Thread.sleep(3000);

	}

}
