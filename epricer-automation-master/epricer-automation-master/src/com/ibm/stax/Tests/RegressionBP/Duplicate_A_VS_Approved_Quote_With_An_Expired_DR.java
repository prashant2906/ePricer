/**
 * @author Neha Upadhyay
 *
 */
package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Duplicate_A_VS_Approved_Quote_With_An_Expired_DR extends
		Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigQuantity = null;

	@BeforeClass
	public void setUp() {
		System.out.println("inside class : Duplicate_A_VS_Approved_Quote_With_An_Expired_DR- BeforeMethod");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * 
	 * @throws Throwable
	 */

	@Test
	@Parameters({"MySAURL","ENV"})
	public void CreateAQuoteWithBidTypeNotRequiringDR(String MySAURL,String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(
					driver, TC_ID,test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(
					driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(
					driver, TC_ID,test);
			changeConfigQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID,test);


			loginBusinessLogic.MySALaunch(MySAURL,ENV);

			//loginBusinessLogic.ibmIDPageData();
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();

			// *-------------------------------------------Testcase4------------------------------*\\
		//	createAQuoteNotRequiringDRBusinessLogic.clickOnSearchQuote();

			Extent_Reporting
			.Log_Pass(
					"Duplicate_A_VS_Approved_Quote_With_An_Expired_DR Passed.",
					"Duplicate_A_VS_Approved_Quote_With_An_Expired_DR Passed.",test);
		} catch (Exception e) {
			Extent_Reporting
			.Log_Fail(
					"Duplicate_A_VS_Approved_Quote_With_An_Expired_DR Failed.",
					"Duplicate_A_VS_Approved_Quote_With_An_Expired_DR Failed.",
					driver,test);
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
