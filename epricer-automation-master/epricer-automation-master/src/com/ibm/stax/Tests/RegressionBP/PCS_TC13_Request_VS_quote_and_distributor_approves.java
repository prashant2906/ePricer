/**
 * @author Harsha Agarwal
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
import com.ibm.stax.BusinessLogic.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_NA_BusinessLogic;
//import com.ibm.stax.BusinessLogic.PCS.*;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC13_Request_VS_quote_and_distributor_approves extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic= null;
	
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic createAVSQuoteAndAcceptBusinessLogic=null;
	Epricer_Application_UpdateAQuote_BusinessLogic ePricerUpdateQuote = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic=null;
	
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic duplicateSBOQuote = null;
	Epricer_Application_PCS_NA_BusinessLogic PCSNABusinessLogic=null;
	
	
	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC13_Request_VS_quote_and_distributor_approves");
		driver = getDriver();
	}

	@Test
	@Parameters({"PCSURL","ENV"})
	public void login_PCS(String PCSURL,String ENV) throws Throwable {
	
	
			try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);
			createAVSQuoteAndAcceptBusinessLogic=new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID,test);
			
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID,test);
			ePricerUpdateQuote = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);
			ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID,test);
			
			duplicateSBOQuote = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID,test);
			PCSNABusinessLogic = new Epricer_Application_PCS_NA_BusinessLogic(driver, TC_ID,test);
			
			//login into the screen
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();			
			loginBusinessLogic.ibmIDPageData(ENV);
			Thread.sleep(10000);
			loginBusinessLogic.pcsENVSelect(ENV);
			
			// select group
			loginBusinessLogic.ePricerLoginscreen();
			
			//create a quote and fill mandatory fields on overview page:
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen();
			PCSNABusinessLogic.click_on_saveandcontinue();
			
			//goto manage configuration screen and add product manually:
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			
			//do collect pricing:
			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			
			//fill the registration details:
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			Thread.sleep(10000);
			PCSNABusinessLogic.pcs_RegistrationNumberScreen_VS();
			
			//click on submit price request button:
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestBtnClick();
			PCSNABusinessLogic.quoteIdFetched();
			PCSNABusinessLogic.fill_mandatory_fields_on_submitscreen();
			PCSNABusinessLogic.click_on_submit_button();
			
			//refresh the page and login with distributor profile:
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.refreshPage();
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginWithDistributorProfile();
			loginBusinessLogic.ePRICERMainScreen();
			
			//Search the quote and accept value seller price:
			ePricerUpdateQuote.searchQuotesLinkClick();
			ePricerUpdateQuote.searchCriteriaQuoteIdSelect();
			PCSNABusinessLogic.searchQuoteButtonClicked();
			Thread.sleep(30000);
			createAQuoteBusinessLogic.moveToDetailsPricing();
			PCSNABusinessLogic.fill_BP_companyname();
			action.waitForPageToLoad(driver);
			Thread.sleep(20000);
			createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
			action.waitForPageToLoad(driver);
			
			 //again login with SP2 profile:
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.refreshPage();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();
			
			//Search the quote and accept value seller price:
			ePricerUpdateQuote.searchQuotesLinkClick();
			ePricerUpdateQuote.searchCriteriaQuoteIdSelect();
			PCSNABusinessLogic.searchQuoteButtonClicked();
			
			//verify addendum tab:
			//PCSNABusinessLogic.addendumTabClicked();			
			Extent_Reporting.Log_Pass("PCS_TC13_Request_VS_quote_and_distributor_approves Passed.",
					"PCS_TC13_Request_VS_quote_and_distributor_approves Passed.",test);
			System.out.println("completed");
			
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCS_TC13_Request_VS_quote_and_distributor_approves Failed.","PCS_TC13_Request_VS_quote_and_distributor_approves Failed.", driver,test);
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