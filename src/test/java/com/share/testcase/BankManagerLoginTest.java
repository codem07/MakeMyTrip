package com.share.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.share.base.TestBase;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void loginasBankManager() throws InterruptedException, IOException {
		
		//soft assersion 
	//	verifyEquals("abc","adf");
		
		Thread.sleep(3000);

		log.debug("Inside Login Test");
		click("bmlBtn_CSS");
		Thread.sleep(2000);
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))));
		
		log.debug("Login success");
              
		//hardcore assersion
	//	Assert.fail("Login not successfull");
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
