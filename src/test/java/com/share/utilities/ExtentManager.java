package com.share.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent==null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
			final File config = new File("");
			
		
	/*	spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("StackShare Automation Report");
		spark.config().setReportName("Extent Report");
		*/extent.attachReporter(spark);
		
		
		
		}
		return extent;
	}
	

}
