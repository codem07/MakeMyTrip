package com.share.testcase;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.share.base.TestBase;
import com.share.utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "db")
	public void addCustomerTest(String FirstName, String LastName, String Postcode, String alerttext)
			throws InterruptedException, IOException {

		click("addCustBtn_CSS");

		type("firstname_CSS", FirstName);
		type("lastname_CSS", LastName);
		type("postcode_CSS", Postcode);
		click("addbtn_CSS");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
		Thread.sleep(3000);
		
	}

//@Test(dataProviderClass=TestUtil.class,dataProvider="db")
	public void addCustomerTest2() {

	}

}
