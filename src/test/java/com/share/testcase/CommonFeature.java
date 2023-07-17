package com.share.testcase;

import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.share.base.TestBase;
import com.share.utilities.TestUtil;

public class CommonFeature extends TestBase {
	public static ExtentTest test;
	public void signUp() throws InterruptedException, IOException {

		// clicking on signUp/Login button
		click("signupLogin_XPATH");

		// clicking on continue with dummy auth button
		click("countinuewithDummyAuth_XPATH");

		// typing username or email into input box
		type("usernameoremailName_XPATH", "bhautik-vase13");

		// clicking login button
		click("login-btn_XPATH");

		// Verifying text of continue button for Welcome page
		try { if (getText("continue-btn_XPATH").equals("Continue")) {

			click("continue-btn_XPATH");

			// Verifying text of continue button for form page
			if (getText("continue-btn_XPATH").equals("Continue")) {
				click("continue-btn_XPATH");

				// Verifying text of continue button for tools selection page
				if (getText("continue-btn-disable_XPATH").equals("Continue")) {
					// selecting tools by increasing size of loop
					for (int i = 1; i <= 3; i++) {

						// List of tools in section
						driver.findElement(By.xpath(OR.getProperty("tool-selection-btn_indexXPATH") + "[" + 1 + "]"))
								.click();

						WebElement verifyTools = driver
								.findElement(By.xpath(OR.getProperty("tool-verify_indexXPATH") + "[" + i + "]"));
						String strTools = verifyTools.getText();

						WebElement verifyToolsFrom = driver
								.findElement(By.xpath(OR.getProperty("tool-verify_indexXPATH") + "[" + i + "]"));
						String strToolsFrom = verifyToolsFrom.getText();

						verifyEquals(strTools, strToolsFrom);

					}

					click("continue-btn_XPATH");

					// Validating pop up which is appearing after sighUp
					WebElement elementPopUp = driver.findElement(By.xpath(OR.getProperty("PopUp_XPATH")));
					String strPopUp = elementPopUp.getAttribute("class");

					verifyEquals(strPopUp, "css-1xnhj1e");

					click("ok-got-it-btn_XPATH");

					// Validating account should not have any plan selected by verifying "new"
					WebElement elementNew = driver.findElement(By.cssSelector(OR.getProperty("new_CSS")));
					String strNew = elementNew.getAttribute("class");

					verifyEquals(strNew, "css-ifi66z");

				}
			}

		}} catch (Throwable t) {

			test.log(LogStatus.FAIL, "Account is already exist" );
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		}
	}
}
