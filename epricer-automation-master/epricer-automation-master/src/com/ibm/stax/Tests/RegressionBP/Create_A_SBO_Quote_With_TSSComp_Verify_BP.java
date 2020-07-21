/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class Create_A_SBO_Quote_With_TSSComp_Verify_BP extends Driver_Setup{

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic= null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuote = null;
	
	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC18_Create_A_SBO_Quote_With_TSSComp_Verify_BP- BeforeMethod");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	
	@Test
	@Parameters({"MySAURL","ENV"})
	public void ePricerLogin(String MySAURL,String ENV) throws Throwable {
		try{
			
		loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver,TC_ID, test);
		createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
		updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID, test);
		updateAQuote = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID, test);		
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID, test);
		
		loginBusinessLogic.MySALaunch(MySAURL,ENV);
		
		//loginBusinessLogic.ibmIDPageData();
		//loginBusinessLogic.epricerLogoScreen();
		loginBusinessLogic.ePricerLoginscreen();
		//loginBusinessLogic.ePRICERMainScreen();
		
		createAQuoteBusinessLogic.createANewQuoteLinkClick();
		createAQuoteBusinessLogic.overviewPolygonScreen();
		createAQuoteBusinessLogic.dataForEPricerOverviewScreen("TSSBid");
		createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
		updateAQuote.uploadCFR("TSSComp");
		createAQuoteBusinessLogic.collectPricingButtonClick();
		createAQuoteBusinessLogic.pricingValueCheck();
		createAQuoteBusinessLogic.registrationCustomerPolygon();
		createAQuoteBusinessLogic.dataForRegistrationNumberScreen();
		createAQuoteBusinessLogic.detailsPricingPolygon();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.requestPriceeExceptionChkboxClick();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestBtnClick();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestScreen();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.verifyTabsOnSubmitPriceRequestScreen();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteIdFetched();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitAndSendNotificationBtnClick();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.sendNotificationScreen();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.dataForSendNotificationScreen();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.checkTSS();
		
		Extent_Reporting.Log_Pass("Create_A_SBO_Quote_CheckP4V_Calculation Passed.",
				"Create_A_SBO_Quote_CheckP4V_Calculation Passed.", test);
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Create_A_SBO_Quote_CheckP4V_Calculation Failed.",
					"Create_A_SBO_Quote_CheckP4V_Calculation Failed.", driver, test);
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
