//Author
package com.shopeeSG.TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebElement;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.shopeeSG.MobileElements.CommonFunctions;
import com.shopeeSG.MobileElements.HomeScreen;

import com.shopeeSG.util.BaseClass;
import com.shopeeSG.util.CommonUtil;


import io.appium.java_client.AppiumDriver;

public class TestRunner extends BaseClass {

	static AppiumDriver<WebElement> driver;
	
	HomeScreen hs;
	CommonFunctions cf;
	String mobileNo, email, password, usernameBlank, passwordBlank, emailInvalid, mobileInvalid, maxAttemptCountAMS,
			mobileNotRegistered, emailNotRegistered, passwordInvalid,plateform;

	@BeforeMethod
	public void preCondition() throws IOException

	{
		System.out.println("Set Up....");
		
		plateform=CommonUtil.getPropertyValue("config","plateform");
		TestRunner.driver = BaseClass.getAppCapabilities(plateform);
		cf=new CommonFunctions(driver);
		hs=new HomeScreen(driver);
	}

	@Test
	public void swipeAllScreen() throws InterruptedException {
		extentTest = extentReports.createTest("swipeAllScreen");
		cf.swipeNextScreen();
		cf.swipeNextScreen();
		
		hs.clickOnStart();
		hs.clickOnCloseAd();
		hs.clickOnShopeeMall();
		
		hs.clickOnArrow();
		hs.clickOnMobile();
		
		hs.clickOnSeeAll();
		
		
	}


	@AfterMethod
	public void getResult(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.SKIP) {
			System.out.println("Skipped extent report");
			extentTest.skip(MarkupHelper.createLabel(testResult.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
			extentTest.skip(testResult.getThrowable());
			// extentTest.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName() + "
			// - Test Case Skipped", ExtentColor.ORANGE));
		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(MarkupHelper.createLabel(testResult.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			extentTest.fail(testResult.getThrowable());
			String screenshotPath = CommonUtil.takesScreenShotFailed(driver, testResult.getName());
			extentTest.addScreenCaptureFromPath(screenshotPath);
		} else if (testResult.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(MarkupHelper.createLabel(testResult.getName() + " Test Case PASSED", ExtentColor.GREEN));
			String screenshotPath = CommonUtil.takesScreenShot(driver, testResult.getName());

			extentTest.addScreenCaptureFromPath(screenshotPath);
		}

	}

}
