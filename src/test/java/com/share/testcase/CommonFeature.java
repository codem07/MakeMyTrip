package com.share.testcase;

import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.share.base.TestBase;
import com.share.utilities.TestUtil;

public class CommonFeature extends TestBase {
	public static ExtentTest test;

	public void signUp(String username) throws InterruptedException, IOException {

		// clicking on signUp/Login button
		click("signupLogin_XPATH");

		// clicking on continue with dummy auth button
		click("countinuewithDummyAuth_XPATH");

		// typing username or email into input box
		type("usernameoremailName_XPATH", username);

		// clicking login button
		click("login-btn_XPATH");

		// Verifying text of continue button for Welcome page
		try {
			if (getText("continue-btn_XPATH").equals("Continue")) {

				click("continue-btn_XPATH");

				// Verifying text of continue button for form page
				if (getText("continue-btn_XPATH").equals("Continue")) {
					click("continue-btn_XPATH");

					// Verifying text of continue button for tools selection page
					if (getText("continue-btn-disable_XPATH").equals("Continue")) {
						// selecting tools by increasing size of loop
						for (int i = 1; i <= 3; i++) {

							// List of tools in section
							driver.findElement(
									By.xpath(OR.getProperty("tool-selection-btn_indexXPATH") + "[" + 1 + "]")).click();

							WebElement verifyTools = driver
									.findElement(By.xpath(OR.getProperty("tool-verify_indexXPATH") + "[" + i + "]"));
							String strTools = verifyTools.getText();

							WebElement verifyToolsFrom = driver
									.findElement(By.xpath(OR.getProperty("tool-verify_indexXPATH") + "[" + i + "]"));
							String strToolsFrom = verifyToolsFrom.getText();

							verifyEquals(strTools, strToolsFrom);

						}

						click("continue-btn_XPATH");
						Thread.sleep(20000);
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

			}
		} catch (Throwable t) {

			test.log(LogStatus.FAIL, "Account is already exist");
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		}
	}

	public void createCompany(String companyname, String plan) throws IOException, InterruptedException {
		Thread.sleep(3000);
		click("profile-dp-img_CSS");
		click("join-a-company-btn_XPATH");

		// Validating "Add new company" tab class by getting class value form
		// "/manage-companies/join" page
		WebElement elementNew = driver.findElement(By.cssSelector(OR.getProperty("add-new-company-tab_CSS")));
		String strNew = elementNew.getAttribute("class");

		verifyEquals(strNew, "css-7lvt0d");

		click("add-new-company-tab_CSS");
		click("pop-up-cross-icon_CSS");
		type("company-Name-input_XPATH", "ss-test-" + companyname);
		type("company-Website-input_XPATH", companyname + ".com");
		type("company-Email-Address-input_XPATH", companyname + "@" + companyname + ".com");
		Thread.sleep(3000);
		click("add-company-btn_CSS");
		Thread.sleep(3000);
		click("company-Select-radio-btn_CSS");
		Thread.sleep(3000);
		click("proceed-to-select-plan-btn_CSS");
		Thread.sleep(3000);
		if (plan.equals("FREE")) {
			Thread.sleep(3000);
			click("select-free-plan-btn_XPATH");

			Thread.sleep(10000);

			WebElement visitBtn = driver.findElement(By.cssSelector(OR.getProperty("visit-company-profile-btn_CSS")));
			String visitBtnClass = visitBtn.getAttribute("class");

			verifyEquals(visitBtnClass, "css-r0vj3d");
			click("visit-company-profile-btn_CSS");

			Thread.sleep(10000);
			WebElement tellUs = driver.findElement(By.cssSelector(OR.getProperty("tell-us-text-CSS")));
			String tellUsText = tellUs.getText();

			verifyEquals(tellUsText, "Tell us about yourself");
			Thread.sleep(3000);

			click("close-btn_XPATH");
			
			Thread.sleep(10000);
			WebElement enterpriseDropDown = driver.findElement(By.cssSelector(OR.getProperty("enterprise-dropdown_CSS")));
			String enterpriseClass = enterpriseDropDown.getAttribute("class");

			verifyEquals(enterpriseClass, "css-qokca7");
			
			

		}

	}

	public void login(String username) throws InterruptedException, IOException {

		click("signupLogin_XPATH");

		// clicking on continue with dummy auth button
		click("countinuewithDummyAuth_XPATH");

		// typing username or email into input box
		type("usernameoremailName_XPATH", username);

		// clicking login button
		click("login-btn_XPATH");

		Thread.sleep(20000);
		// Validating pop up which is appearing after sighUp
		WebElement elementPopUp = driver.findElement(By.xpath(OR.getProperty("PopUp_XPATH")));
		String strPopUp = elementPopUp.getAttribute("class");

		verifyEquals(strPopUp, "css-1xnhj1e");

	}
}
