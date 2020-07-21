package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Verify_Content_Of_My_Quote extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;

	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC22_Verify_Content_Of_My_Quote");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * 
	 * @throws Throwable
	 */

	@Test
	@Parameters({"MySAURL","ENV"})
	public void VerifyContentOfMyQuote(String MySAURL,String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(
					driver, TC_ID,test);			
			changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(
					driver, TC_ID,test);

			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			//loginBusinessLogic.ibmIDPageData();
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();
						
			changeConfigurationQuantity.myQuotesLinkAndPageVerification();
			Extent_Reporting.Log_Pass("Verify_Content_Of_My_Quote Passed.",
					"Verify_Content_Of_My_Quote Passed.",test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Verify_Content_Of_My_Quote Failed.",
					"Verify_Content_Of_My_Quote Failed.", driver,test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
