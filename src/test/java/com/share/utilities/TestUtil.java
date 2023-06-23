package com.share.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.share.base.TestBase;

public class TestUtil extends TestBase {
	public static String screenshotPath;
	public static String screenshotName;
//	System.out.println();
	
	
	
	public static void captureScreenshot() throws IOException {
		
		 

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ","_");
		File ssFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ssFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName));

	
	
		

	}
	
	@DataProvider(name="db")
	public Object [] [] getData(Method m){
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
	  
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
