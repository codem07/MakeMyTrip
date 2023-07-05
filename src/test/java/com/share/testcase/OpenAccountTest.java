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

public class OpenAccountTest extends TestBase  {

@Test(dataProviderClass=TestUtil.class,dataProvider="db")
public void openAccountTest(String customer, String currancy ) throws InterruptedException, IOException {
 
click("openaccount_CSS");
select("customer_CSS",customer);
select("currency_CSS",currancy);
click("process_CSS");
Alert alert = wait.until(ExpectedConditions.alertIsPresent());
alert.accept();


}


	 
}









