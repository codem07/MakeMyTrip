package com.share.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.share.base.TestBase;
import com.share.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {

		test = extentReport.createTest(result.getName().toUpperCase()).assignAuthor(config.getProperty("AuthorName"))
				.assignCategory("Regresstion").assignDevice("Chrome");

		

		if (!TestUtil.isTestRunnable(result.getName(), excel)) {

			throw new SkipException("Skipping the test " + result.getName().toUpperCase() + " as th Run mode is no");
		}

	}
	


	//
	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");

	/*	try {

			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/* non base64 img
		try {
			test.fail(result.getName().toUpperCase() + "Failed with exception:" + result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		//base64 img
		
		try {
			test.fail(result.getName().toUpperCase() + "Failed with exception:" + result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.getScreenShotAsBase64()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test.addScreenCaptureFromBase64String(TestUtil.screenshotPath);
		//test.fail(result.getName().toUpperCase() + "Failed with exception:" + result.getThrowable());

		

        Reporter.log("Capturing SS");
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");

		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
				+ " height=200 width=200></img></a>");

		// extentReport.endTest(test);
		extentReport.flush();

	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, result.getName().toUpperCase() + " Skipped the test as the runmode is no");
		// extentReport.endTest(test);
		extentReport.flush();

	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, result.getName().toUpperCase() + "PASS");
		// extentReport.endTest(test);
		extentReport.flush();
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
