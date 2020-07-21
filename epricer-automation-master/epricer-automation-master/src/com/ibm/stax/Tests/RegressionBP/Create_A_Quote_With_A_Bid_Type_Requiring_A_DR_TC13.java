package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_Approved_A_SBO_Quote_Business_Logic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class Create_A_Quote_With_A_Bid_Type_Requiring_A_DR_TC13 extends Driver_Setup{


	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic= null;
	Epricer_Application_Approved_A_SBO_Quote_Business_Logic approveASBOQuote = null;
	
	@BeforeClass
	public void setUp() {
		System.out.println("inside class : Create_A_Quote_With_A_Bid_Type_Requiring_A_DR_TC13- BeforeMethod");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	
	@Test
	@Parameters({"MySAURL","ENV"})
	public void ePricerLogin(String MySAURL,String ENV)  throws Throwable {
		try{
			
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver,TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID, test);
			approveASBOQuote = new Epricer_Application_Approved_A_SBO_Quote_Business_Logic(driver, TC_ID, test);			
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID, test);
			
			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			//loginBusinessLogic.ibmIDPageData();
			//loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			//loginBusinessLogic.ePRICERMainScreen();
			
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			//createAQuoteBusinessLogic.overviewPolygonScreen();
			//createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			createAQuoteBusinessLogic.dataForEPricerOverviewScreenWithoutQuoteTitle();
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();
			
			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.dataForRegistrationNumberScreen();
			
			//createAQuoteBusinessLogic.detailsPricingPolygon();
			
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.requestPriceeExceptionChkboxClick();
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestBtnClick();
			//ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestScreen();
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.verifyTabsOnSubmitPriceRequestScreen();
			approveASBOQuote.quoteIdFetchedAndDataSavedInExcel("Reviewer_Workflow");
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitAndSendNotificationBtnClick();
		//	ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.sendNotificationScreen();
			Thread.sleep(10000);
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.dataForSendNotificationScreen();
			//ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteIdPresentOnMyQuotesScreen();
		
		Extent_Reporting.Log_Pass("Create_A_Quote_With_A_Bid_Type_Requiring_A_DR_TC13 Passed.",
				"Create_A_Quote_With_A_Bid_Type_Requiring_A_DR_TC13 Passed.", test);
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Create_A_Quote_With_A_Bid_Type_Requiring_A_DR_TC13 Failed.",
					"Create_A_Quote_With_A_Bid_Type_Requiring_A_DR_TC13 Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Create_A_Quote_With_A_Bid_Type_Requiring_A_DR_TC13 Failed.");
		}
	}
	
	@AfterTest
	  public void tearDown() {
		  driver.quit();
	  } 
}
