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

import com.ibm.stax.BusinessLogic.Epricer_Application_Approved_A_SBO_Quote_Business_Logic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Approved_COPRA_Price extends Driver_Setup{	
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic ePricerUpdateAQuote= null;
	Epricer_Application_Approved_A_SBO_Quote_Business_Logic approvedASBOQuote = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic createASBOQuoteIncompleteAndAccept = null;
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogicpcs = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	
	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC19_Approved_COPRA_Price- BeforeMethod");
		driver = getDriver();
	}

/**
 * Verify The Login Page With Valid Credentials
 * 
 * @throws Throwable
 */

	@Test
	@Parameters({"MySAURL","ENV", "IBMURL"})
	public void ApprovedCOPRAPrice(String MySAURL,String ENV, String IBMURL) throws Throwable {
	try {

		loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(
				driver, TC_ID, test);
		createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(
				driver, TC_ID, test);
		changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(
				driver, TC_ID, test);
		createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(
				driver, TC_ID, test);
		ePricerUpdateAQuote = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID, test);
		approvedASBOQuote = new Epricer_Application_Approved_A_SBO_Quote_Business_Logic(driver, TC_ID, test);
		createASBOQuoteIncompleteAndAccept = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID, test);
		loginBusinessLogicpcs = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
		eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver,TC_ID,test);
		EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(driver, TC_ID, test);
		

		loginBusinessLogic.MySALaunch(MySAURL,ENV);
		//loginBusinessLogic.ibmIDPageData();
		//loginBusinessLogic.epricerLogoScreen();
		loginBusinessLogic.ePricerLoginscreen();
		//loginBusinessLogic.ePRICERMainScreen();
				
		createAQuoteBusinessLogic.createANewQuoteLinkClick();
		createAQuoteBusinessLogic.overviewPolygonScreen();
		createAQuoteNotRequiringDRBusinessLogic.dataForEPricerOverviewWithoutQuoteTitle();
		createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
		createAQuoteBusinessLogic.addProductManuallyButtonClick();
		approvedASBOQuote.dataForEPricerAddProductManuallyScreen();
		//createAQuoteBusinessLogic.componentAddedSuccessMsg();

		createAQuoteBusinessLogic.collectPricingButtonClick();
		createAQuoteBusinessLogic.pricingValueCheck();

		createAQuoteBusinessLogic.registrationCustomerPolygon();
		createAQuoteNotRequiringDRBusinessLogic.searchCustomerButtonClick();
		createAQuoteNotRequiringDRBusinessLogic.dataForSearchCustomerScreen();

		createAQuoteBusinessLogic.detailsPricingPolygon();
		
		createASBOQuoteIncompleteAndAccept.requestPriceeExceptionChkboxClick();
		createASBOQuoteIncompleteAndAccept.submitPriceRequestBtnClick();
		createASBOQuoteIncompleteAndAccept.submitPriceRequestScreen();
		createASBOQuoteIncompleteAndAccept.verifyTabsOnSubmitPriceRequestScreen();
		approvedASBOQuote.quoteIdFetchedandSavedInDatasheet();
		approvedASBOQuote.submitButtonClickedOnSubmitPriceRequest();
		
		loginBusinessLogicpcs.authenticatePopUpHandle(IBMURL, ENV);
		//Thread.sleep(8000);
		if (ENV.equalsIgnoreCase("PROD")) {
			loginBusinessLogicpcs.ePricerLoginscreen("SelectAIBMPRODRole", ENV);
		} else {
			loginBusinessLogicpcs.ePricerLoginscreen("SelectIBMRole", ENV);
		}			
		eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("EnterQuoteid");
		EpricerApplicationIBMQuoteEditorBusinessLogic.switchtocommentstatustab();
		approvedASBOQuote.iBMGuiOpened();
		
		Extent_Reporting.Log_Pass("Approved_COPRA_Price Passed.",
				"Approved_COPRA_Price Passed.", test);	
	} 
	catch (Exception e) {
	Extent_Reporting.Log_Fail("Approved_COPRA_Price Failed.",
			"Approved_COPRA_Price Failed.", driver, test);
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