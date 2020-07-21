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
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_ReSubmit_A_SBO_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class Duplicate_A_SBO_Quote_TC18 extends Driver_Setup{


	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic= null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic= null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_ReSubmit_A_SBO_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndReSubmitASBOBusinessLogic = null;
	Epricer_Application_Approved_A_SBO_Quote_Business_Logic approveASBOQuote = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogicpcs = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;

	@BeforeClass
	public void setUp() {
		System.out.println("inside class : Duplicate_A_SBO_Quote- BeforeMethod");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	
	@Test
	@Parameters({"MySAURL","ENV","IBMURL"})
	public void ePricerLogin(String MySAURL,String ENV, String IBMURL) throws Throwable {
		try{
			
		loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver,TC_ID,test);
		createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
		updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID,test);
		ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID,test);
		ePricerCreateASBOQuoteIncompleteItAndReSubmitASBOBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_ReSubmit_A_SBO_BusinessLogic(driver, TC_ID,test);
		loginBusinessLogicpcs = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
		eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver, TC_ID, test);
		approveASBOQuote = new Epricer_Application_Approved_A_SBO_Quote_Business_Logic(driver, TC_ID, test);			
		EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(driver, TC_ID, test);
		EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,TC_ID, test);

		loginBusinessLogic.MySALaunch(MySAURL,ENV);
		loginBusinessLogic.ePricerLoginscreen();
		createAQuoteBusinessLogic.createANewQuoteLinkClick();
		createAQuoteBusinessLogic.overviewPolygonScreen();
		createAQuoteBusinessLogic.dataForEPricerOverviewScreenWithoutQuoteTitle();
		//createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
		createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
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
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestScreen();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.verifyTabsOnSubmitPriceRequestScreen();
		approveASBOQuote.quoteIdFetchedAndDataSavedInExcel("Duplicate_A_SBO_Quote_TC18");
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitAndSendNotificationBtnClick();
		//ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.sendNotificationScreen();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.dataForSendNotificationScreen();
		
		loginBusinessLogicpcs.authenticatePopUpHandle(IBMURL, ENV);
		//Thread.sleep(8000);
		if (ENV.equalsIgnoreCase("PROD")) {
			loginBusinessLogicpcs.ePricerLoginscreen("SelectAIBMPRODRole", ENV);
		} else {
			loginBusinessLogicpcs.ePricerLoginscreen("SelectIBMRole", ENV);
		}			
		eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("EnterQuoteid");

		EpricerApplicationIBMQuoteEditorBusinessLogic.switchtocommentstatustab();
		ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.iBMGuiOpened();
		Thread.sleep(10000);
		//BP Login again
		loginBusinessLogic.MySALaunch(MySAURL,ENV);
		loginBusinessLogic.ePricerLoginscreen();
		EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
		EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
		EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
		EpricerApplicationSearchQuoteBusinessLogic.getQuoteFromDatasheet("EnterQuoteid", true);	
		ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.searchQuoteIdButtonClicked();
		Thread.sleep(10000);
		ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.quoteIdLinkPresent();
		ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.duplicatingQuoteGoBtnClicked();
		ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.duplicateQuoteIdFetched();
		ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.duplicateQuoteIdCheck();
		//EpricerApplicationSearchQuoteBusinessLogic.getQuoteFromDatasheet("EnterQuoteid", true);
		ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.addCrad();
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestTabClick();
		
		ePricerCreateASBOQuoteIncompleteItAndReSubmitASBOBusinessLogic.requestPricingTabClick();
		ePricerCreateASBOQuoteIncompleteItAndReSubmitASBOBusinessLogic.submitPriceRequestBTNClick();
		//updateAQuoteBusinessLogic.searchQuotesScreen();
		//ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.duplicateQuoteIdPresentOnMyQuotesScreenAfterSubmit();
		Thread.sleep(20000);
		//IBM GUI For searching quote after duplicating quote and verifying requestedEndUserPrice and requestedEndUserDiscount 
		loginBusinessLogicpcs.authenticatePopUpHandle(IBMURL, ENV);
		//Thread.sleep(8000);
		if (ENV.equalsIgnoreCase("PROD")) {
			loginBusinessLogicpcs.ePricerLoginscreen("SelectAIBMPRODRole", ENV);
		} else {
			loginBusinessLogicpcs.ePricerLoginscreen("SelectIBMRole", ENV);
		}			
		eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("EnterQuoteid");
		ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.iBMGuiOpenedToSubmitDuplicateQuote();
		
		Extent_Reporting.Log_Pass("Duplicate_A_SBO_Quote_TC18 Passed.",	"Duplicate_A_SBO_Quote_TC18 Passed.",test);
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Duplicate_A_SBO_Quote_TC18 Failed.",	"Duplicate_A_SBO_Quote_TC18 Failed.", driver,test);
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

