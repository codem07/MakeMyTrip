package com.share.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.share.base.TestBase;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void loginasBankManager() throws InterruptedException {
		
		log.debug("Inside Login Test");
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))));
		
		
		log.debug("Login success");
		
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
