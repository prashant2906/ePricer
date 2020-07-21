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

public class Request_VS_Quotes_And_Distributor_Returns_The_Quote extends
		Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic ePricerUpdateQuote = null;

	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC10_Request_VS_Quotes_And_Distributor_Returns_The_Quote - BeforeMethod");
		driver = getDriver();
	}

	@Test
	@Parameters({"MySAURL","ENV"})
	public void ePricerLogin(String MySAURL,String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID,test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(driver, TC_ID,test);
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(
					driver, TC_ID,test);
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
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();

			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.dataForRegistrationNumberScreen();

			createAQuoteBusinessLogic.detailsPricingPolygon();
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.requestPriceeExceptionChkboxClick();
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestBtnClick();
			//ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestScreen();
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteIdFetched();
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitToDistributorButton();
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteIdPresentOnMyQuotesScreen();
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.refreshPage();
			//loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginWithDistributorProfile();
			//loginBusinessLogic.ePRICERMainScreen();
			ePricerUpdateQuote.searchQuotesLinkClick();
			ePricerUpdateQuote.searchQuotesScreen();
			ePricerUpdateQuote.searchCriteriaQuoteIdSelect();
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.searchQuoteButtonClicked();
			Thread.sleep(5000);
			createAQuoteBusinessLogic.returntoDistributonClicked();
			Thread.sleep(10000);
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.refreshPage();
			Thread.sleep(4000);
			//loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			//loginBusinessLogic.ePRICERMainScreen();
			action.handleAlert(driver);
			ePricerUpdateQuote.searchQuotesLinkClick();
			//ePricerUpdateQuote.searchQuotesScreen();
			ePricerUpdateQuote.searchCriteriaQuoteIdSelect();
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.searchQuoteButtonClicked();
			action.handleAlert(driver);
			changeConfigurationQuantity.moveToManageConfiguration();
			//createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			changeConfigurationQuantity.changeQuantity();
			createAQuoteBusinessLogic.moveToDetailsPricingFromManageConfig();
			changeConfigurationQuantity.requestValueSellerOfferButtonClicked();

			Extent_Reporting.Log_Pass(
					"RequestVSQuotesAndDistributorReturnsTheQuote Passed.",
					"RequestVSQuotesAndDistributorReturnsTheQuote Passed.",test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail(
					"RequestVSQuotesAndDistributorReturnsTheQuote Failed.",
					"RequestVSQuotesAndDistributorReturnsTheQuote Failed.", driver,test);
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