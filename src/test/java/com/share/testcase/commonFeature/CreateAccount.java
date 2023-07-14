package com.share.testcase.commonFeature;

import org.testng.annotations.Test;

import com.share.base.TestBase;

public class CreateAccount extends TestBase {
	
	
	public void createAccount(String accountName) {
		
		
		click("signupLogin_XPATH");
		click("countinuewithDummyAuth_XPATH");
		type("countinuewithDummyAuth_XPATH",accountName);
		click("login-btn_XPATH");
		
		
		
	}

}
