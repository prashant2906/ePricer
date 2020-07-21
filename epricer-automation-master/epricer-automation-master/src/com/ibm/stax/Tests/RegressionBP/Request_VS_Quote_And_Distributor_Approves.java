package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Request_VS_Quote_And_Distributor_Approves extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndAccept = null;
	Epricer_Application_UpdateAQuote_BusinessLogic ePricerUpdateQuote = null;

	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC9_Request_VS_Quote_And_Distributor_Approves- BeforeMethod");
		driver = getDriver();
	}

	@Test
	@Parameters({"MySAURL","ENV"})
	public void RequestVSQuoteAndDistributorApproves(String MySAURL,String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID,test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(driver, TC_ID,test);
			ePricerCreateASBOQuoteIncompleteItAndAccept = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID,test);
			ePricerUpdateQuote = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);
			
			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			//loginBusinessLogic.ibmIDPageData();
			//loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			//loginBusinessLogic.ePRICERMainScreen();

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			//createAQuoteBusinessLogic.overviewPolygonScreen();
			//createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			createAQuoteBusinessLogic.dataForEPricerOverviewScreenWithoutQuoteTitle();
			//createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			Thread.sleep(8000);
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();

			//createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.dataForRegistrationNumberScreen();

			//createAQuoteBusinessLogic.detailsPricingPolygon();
			ePricerCreateASBOQuoteIncompleteItAndAccept.requestPriceeExceptionChkboxClick();
			ePricerCreateASBOQuoteIncompleteItAndAccept.submitPriceRequestBtnClick();
			//ePricerCreateASBOQuoteIncompleteItAndAccept.submitPriceRequestScreen();
			ePricerCreateASBOQuoteIncompleteItAndAccept.quoteIdFetched();
			ePricerCreateASBOQuoteIncompleteItAndAccept.submitToDistributorButton();
			//ePricerCreateASBOQuoteIncompleteItAndAccept.quoteIdPresentOnMyQuotesScreen();
			Thread.sleep(25000);
			ePricerCreateASBOQuoteIncompleteItAndAccept.refreshPage();
			Thread.sleep(10000);
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginWithDistributorProfile();
			//loginBusinessLogic.ePRICERMainScreen();
			ePricerUpdateQuote.searchQuotesLinkClick();
			//ePricerUpdateQuote.searchQuotesScreen();
			ePricerUpdateQuote.searchCriteriaQuoteIdSelect();

			ePricerCreateASBOQuoteIncompleteItAndAccept.searchQuoteButtonClicked();
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);
			createAQuoteBusinessLogic.moveToDetailsPricing();
			action.waitForPageToLoad(driver);
			createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();

			Extent_Reporting.Log_Pass("RequestVSQuoteAndDistributorApproves Passed.","RequestVSQuoteAndDistributorApproves Passed.",test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("RequestVSQuoteAndDistributorApproves Failed.","RequestVSQuoteAndDistributorApproves Failed.", driver,test);
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