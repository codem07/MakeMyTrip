package com.share.testcase;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.share.base.TestBase;
import com.share.utilities.TestUtil;

public class GitHubSync extends TestBase {

	

	@Test(dataProviderClass = TestUtil.class, dataProvider = "db")
	public void gitHubSync(String Runmode) throws InterruptedException, IOException{


		if (!Runmode.equals("Y")) {
			
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		
		click("signupLogin_XPATH");
		click("countinuewithDummyAuth_XPATH");
		type("countinuewithDummyAuth_XPATH","bhautik-vase");
		click("login-btn_XPATH");
		
		
		
	}

}
