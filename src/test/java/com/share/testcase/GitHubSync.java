package com.share.testcase;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.share.base.TestBase;
import com.share.utilities.TestUtil;

public class GitHubSync extends CommonFeature {

	

	@Test(dataProviderClass = TestUtil.class, dataProvider="db")
	public void gitHubSync(String username, String companyname) throws InterruptedException, IOException{


		/*if (!runmode.equals("Y")) {
			
			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}*/
		
		
		/*click("signupLogin_XPATH");
		Thread.sleep(3000);
		click("countinuewithDummyAuth_XPATH");
		Thread.sleep(3000);
		type("usernameoremailName_XPATH","bhautik-vase");
		Thread.sleep(3000);
		click("login-btn_XPATH");
		*/
		
		signUp(username);
        createCompany(companyname);
		
		
		
	}
	
	
	

}
