package com.share.listeners;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener{
	
	
	public void onTestStart(ITestResult result) {
		
	}
	//asdfadsfaf
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing SS");
		Reporter.log("<a target=\"_blank\" href=\"E:\\error.png\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"E:\\error.png\"><img src=\"E:\\error.png\" height=200 width=200></img></a>");
		
		

	}
	
	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	
	public void onStart(ITestContext context) {
	
	}
	
	public void onFinish(ISuite arg0) {
		
	}
	
	public void onStart(ISuite arg0) {
		
	}

	public void onFinish(ITestContext context) {
		
	}




}
