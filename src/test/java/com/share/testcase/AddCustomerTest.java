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
		Thread.sleep(3000);

		type("firstname_CSS", FirstName);

		Thread.sleep(3000);

		type("lastname_CSS", LastName);
		Thread.sleep(3000);

		type("postcode_CSS", Postcode);
		Thread.sleep(3000);

		click("addbtn_CSS");
		Thread.sleep(3000);

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		Assert.assertTrue(alert.getText().contains(alerttext));

		alert.accept();
		Thread.sleep(3000);

		System.out.println("this is ADDCT class name: " + this.getClass().getName());
	}

//@Test(dataProviderClass=TestUtil.class,dataProvider="db")
	public void addCustomerTest2() {

	}

}
