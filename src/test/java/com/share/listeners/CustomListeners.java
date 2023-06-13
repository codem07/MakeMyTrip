package com.share.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.share.utilities.TestUtil;



public class CustomListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
<<<<<<< HEAD
		
	}
	//asdfadsfaf
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing SS");
		Reporter.log("<a target=\"_blank\" href=\"E:\\error.png\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"E:\\error.png\"><img src=\"E:\\error.png\" height=200 width=200></img></a>");
		
		Reporter.log("Captfsdfasdfadfadfuringasf SS");
		Reporter.log("Captfsdfasdfadfadfuringasf SS");
		Reporter.log("Capturingasf SS");
		Reporter.log("Capturingasf SS");
		Reporter.log("Captfsdfasdfadfadfuringasf SS");
=======
>>>>>>> PC1

	}

	//
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		Reporter.log("Capturing SS");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName+ " height=200 width=200></img></a>");

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
