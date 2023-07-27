package com.share.utilities;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


//class 
public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance()      {
		System.out.println("Extent is before the : "+extent);
		if(extent==null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
			final File config = new File("ReportsConfig.xml");
			int i = 1;
			
		extent = new ExtentReports();
		
	/*spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("StackShare Automation Report");
		spark.config().setReportName("Extent Report");
		*/
			System.out.println("Extent is inside the if : "+extent+i);
			extent.attachReporter(spark);
		
			
		
				try {
					spark.loadXMLConfig(config);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	return extent;
	}
	

}
