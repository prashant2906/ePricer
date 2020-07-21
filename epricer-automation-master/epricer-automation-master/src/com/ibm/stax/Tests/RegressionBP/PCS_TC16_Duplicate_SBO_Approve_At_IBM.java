
package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_NA_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Utilities.ElementAction;
import com.ibm.stax.BusinessLogic.Epricer_Application_Approved_A_SBO_Quote_Business_Logic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic;

import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;


public class PCS_TC16_Duplicate_SBO_Approve_At_IBM extends Driver_Setup{
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic= null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic=null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_Approved_A_SBO_Quote_Business_Logic approveASBOQuote = null;
	Epricer_Application_PCS_NA_BusinessLogic PCSNABusinessLogic=null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogicNA =null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic duplicateSBOQuote = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;


    String Quoteid = "";
	
	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC16_Duplicate_SBO_Approve_At_IBM");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	
	
	@Test
	@Parameters({ "PCSURL", "IBMURL","ENV"})
	public void PCS_TC16_Duplicate_SBO_quote_and_Approve(String PCSURL,String IBMURL,String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogicNA= new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);
			
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID,test);
			ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID,test);
			PCSNABusinessLogic = new Epricer_Application_PCS_NA_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver, TC_ID,test);
			approveASBOQuote = new Epricer_Application_Approved_A_SBO_Quote_Business_Logic(driver, TC_ID,test);
			duplicateSBOQuote = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationIBMQuoteEditorBusinessLogic= new Epricer_Application_IBM_QuoteEditor_BusinessLogic (driver, TC_ID,test);


					

			//login into the screen
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();			
			loginBusinessLogic.ibmIDPageData(ENV);
			Thread.sleep(5000);
			loginBusinessLogic.pcsENVSelect(ENV);
			
			
			// select group
			loginBusinessLogic.ePricerLoginscreen();
			

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			Quoteid = createAQuoteBusinessLogicNA.quoteIdFetched();
			System.out.println(Quoteid);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen();
			
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			
			
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			Thread.sleep(8000);
			createAQuoteBusinessLogicNA.pcsGotoSubmitSBquote();  // click the submit price request to go the submit price quest tab
			PCSNABusinessLogic.quoteIdFetched();
			createAQuoteBusinessLogicNA.pcsSubmitSBquote(); // sB quote submit
			
			//dulpicate a SBO quote
			Thread.sleep(20000);
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			Thread.sleep(5000);
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			Thread.sleep(10000);
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickMultipleCheck();
			
			// click the multiple result
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();
			Thread.sleep(10000);
			EpricerApplicationSearchQuoteBusinessLogic.searchVSduplicate();
		   
			Thread.sleep(10000);
			createAQuoteBusinessLogicNA.pcsopenTabManageconfiguration();
			//createAQuoteBusinessLogic.addProductManuallyButtonClick();
			//createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();
			//createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogicNA.pcsclicksavecontinueonconfigurationtab();
			createAQuoteBusinessLogicNA.pcsdataForRegistrationNumberScreencontinueonly();
			createAQuoteBusinessLogicNA.pcsGotoSubmitSBquote();  // click the submit price request to go the submit price quest tab
			createAQuoteBusinessLogicNA.pcsRESubmitSBquote(); // sB quote submit		
			
			//open quote at IBM GUI			
			
			loginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			loginBusinessLogic.ePricerLoginscreen("SelectIBMRole",ENV);
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			//EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();
			
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtocommentstatustab();
			EpricerApplicationIBMQuoteEditorBusinessLogic.changeBPquotestatus(true);
			
			Thread.sleep(20000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtopricetab();
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("approval");
			EpricerApplicationIBMQuoteEditorBusinessLogic.approveBPquoteinIBM();
			
			Extent_Reporting.Log_Pass("PCS_TC16_ Passed.","PCS_TC16 Passed.",test);		
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCS_TC16 Failed.","PCS_TC16_Failed.", driver,test);
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
