package com.share.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.share.base.TestBase;

public class TestUtil extends TestBase {
	public static String screenshotPath;
	public static String screenshotName;
//	System.out.println();

	public static String captureScreenshot() throws IOException {


		LocalDate ld = LocalDate.now();

		Date d = new Date();
		 screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".png";
		File ssFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		screenshotPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName;
		
		FileUtils.copyFile(ssFile, new File(screenshotPath));
		return screenshotPath;
		
		// TestUtil.screenshotName = screenshotName;
	//stackshare
		


	}
	
	
	public static String getScreenShotAsBase64() throws IOException{
		
		
		Date d = new Date();
		 screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".png";
		File ssFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		screenshotPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName;
		
		FileUtils.copyFile(ssFile, new File(screenshotPath));
	   byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(screenshotPath)) ;
		return Base64.getEncoder().encodeToString(imageBytes);
		
		
		
		
	}

	@DataProvider(name = "db")
	public Object[][] getData(Method m) {
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {
				//System.out.println("colNum" + colNum);
				// 0 1 2
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				// System.out.println(excel.getCellData(sheetName, colNum, rowNum));

			}
		}
		return data;

	}

	
	//Runmode
	public static boolean isTestRunnable(String testName, ExcelReader excel) {

		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);

		for (int rNum = 2; rNum <= rows; rNum++) {
			String testcase = excel.getCellData(sheetName, "TCID", rNum);
			if (testcase.equalsIgnoreCase(testName)) {

				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				if (runmode.equalsIgnoreCase("Y")) 
					return true;
				else 
					return false;
				
			}
		}

		return false;

	}
}
