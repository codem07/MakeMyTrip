package com.share.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.share.utilities.ExcelReader;
import com.share.utilities.ExtentManager;
import com.share.utilities.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	/*
	 * WebDriver - Done Properties - Done logs - log4j jar ExtentReports DataBase
	 * Excel Mail ReportNG Jenkins
	 */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports extentReport = ExtentManager.getInstance();
	public static ExtentTest test;
	public static Random random = new Random();

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void setUp() {

		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {

				// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir" +
				// "\\src\\test\\resources\\executables\\chromedriver.exe"));
				driver = new FirefoxDriver();
				log.debug("Firefox Launched !!!");
			} else if (config.getProperty("browser").equals("chrome")) {

				// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir" +
				// "\\src\\test\\resources\\executables\\chromedriver.exe"));
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.debug("Chrome Launched !!!");
			}

			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

			wait = new WebDriverWait(driver, 20);
		}

	}

	public static void click(String locator) {
		if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
			test.log(Status.INFO.INFO, "Clicked on " + locator);

		} else if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).click();
			test.log(Status.INFO, "Clicked on " + locator);
	

		}  else if (locator.endsWith("_indexXPATH")) {
             
			driver.findElement(By.xpath(OR.getProperty(locator)+"["+Integer.toString(20) +"]")).click();
			test.log(Status.INFO.INFO, "Clicked on " + locator);

		}else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).click();
			test.log(Status.INFO.INFO, "Clicked on " + locator);
		}
		
		
	}
	
	public static String getText(String locator) {
		
		
	    WebElement element = driver.findElement(By.xpath(OR.getProperty(locator)));
		test.log(Status.INFO.INFO, "gettext for this " + locator);
		String str = element.getText();
		return str;
		
	}
	
	
	

	public static void type(String locator, String value) {
		if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
			;
			test.log(Status.INFO.INFO, "Typed " + value + " on " + locator);

		} else if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			test.log(Status.INFO.INFO, "Typed " + value + " on " + locator);

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			test.log(Status.INFO.INFO, "Typed " + value + " on " + locator);
		}
	}

	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {

			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));

		} else if (locator.endsWith("_XPATH")) {

			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));

		} else if (locator.endsWith("_ID")) {

			dropdown = driver.findElement(By.id(OR.getProperty(locator)));

		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		test.log(Status.INFO.INFO, "Selecting from dropdown" + locator + " value as " + value);

	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void verifyEquals(String actual, String expected) throws IOException {
		try {

			Assert.assertEquals(actual, expected);
			test.log(Status.PASS, "Verification success: " + actual + " equal to " + expected);
			//test.log(LogStatus.PASS, test.addScreenCapture(TestUtil.screenshotName));
		} catch (Throwable t) {

			// ReportNG
			TestUtil.captureScreenshot();
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Report
			test.log(Status.FAIL, "Verification failure : " + t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

		}
	}
	
	
	

	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}

		log.debug("test execution completed");
	}

}
