package com.share.testcase;

import org.testng.annotations.Test;

import com.share.base.TestBase;
import com.share.testcase.commonFeature.CreateAccount;
import com.share.utilities.TestUtil;

public class GitHubSync extends TestBase {

	

	@Test(dataProviderClass = TestUtil.class, dataProvider = "db")
	public void gitInstall(String AccountName) {

		click("signupLogin_XPATH");
		click("countinuewithDummyAuth_XPATH");
		type("countinuewithDummyAuth_XPATH","bhautik-vase");
		click("login-btn_XPATH");
		
		
		
	}

}
