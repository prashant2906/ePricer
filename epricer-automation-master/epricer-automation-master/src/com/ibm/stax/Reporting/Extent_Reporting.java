package com.ibm.stax.Reporting;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent_Reporting {

	public static void Log_Pass(String stepName, String passMessage, ExtentTest test) {
		test.log(LogStatus.PASS, stepName, passMessage);
	}

	public static void Log_Fail(String stepName, String failMessage, WebDriver driver, ExtentTest test)  {
		test.log(LogStatus.FAIL, stepName, failMessage);
		String img = test.addScreenCapture(Common_Functions.captureScreenshot(driver));
		test.log(LogStatus.INFO, "Image", "Error Snap: " + img);
	}

	public static void Log_report(String string, ExtentTest test) {
		// test.addScreenCapture(Common_Functions.captureScreenshot(driver));
		test.log(LogStatus.PASS, string);
	}

	public static void Log_report_img(String stepName, String string, WebDriver driver, ExtentTest test) {
		String img = test.addScreenCapture(Common_Functions.captureScreenshot1(driver, stepName));
		test.log(LogStatus.PASS, stepName, string + img);
	}

	public static void Log_report_img(String string, WebDriver driver, ExtentTest test) {
		String img = test.addScreenCapture(Common_Functions.captureScreenshot1(driver, string));
		test.log(LogStatus.INFO, string + img);
	}
}
