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

public class AddCustomerTest extends TestBase  {

@Test(dataProvider="getData")
public void addCustomer(String FirstName, String LastName, String Postcode, String alerttext) throws InterruptedException, IOException {
	
	driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
	Thread.sleep(3000);

	driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(FirstName);
	Thread.sleep(3000);

	driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(LastName);
	Thread.sleep(3000);

	driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(Postcode);
	Thread.sleep(3000);

	driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
	Thread.sleep(3000);


	
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	
	Assert.assertTrue(alert.getText().contains(alerttext));
	
	alert.accept();
	Thread.sleep(3000);


 System.out.println("this is ADDCT class name: "+this.getClass().getName());
}

@DataProvider
public Object [] [] getData(){
	String sheetName = "AddCustomerTest";
	int rows = excel.getRowCount(sheetName);
	int cols = excel.getColumnCount(sheetName);
  //  System.out.println(excel.path);
    //System.out.println("Rows count 2 ="+rows);
    //System.out.println("Cols count 4 ="+cols);
	                              //1     4
	Object[][] data = new Object[rows-1][cols]; 
	
	for (int rowNum = 2; rowNum <= rows; rowNum++) {
		
		for(int colNum = 0; colNum < cols; colNum++) {
			System.out.println("colNum" +colNum);
			//    0           1                                             2      
			data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			//System.out.println(excel.getCellData(sheetName, colNum, rowNum));
			
		}
	}
	return data;
	 
}



}





