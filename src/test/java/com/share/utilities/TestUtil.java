package com.share.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
	
	
	//adf
	}

	
	
	
         
}
