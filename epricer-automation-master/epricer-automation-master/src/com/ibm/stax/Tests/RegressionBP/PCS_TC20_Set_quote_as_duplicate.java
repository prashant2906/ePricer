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
import com.ibm.stax.BusinessLogic.PCS.*;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC20_Set_quote_as_duplicate extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;

	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic= null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic=null;
	
	Epricer_Application_PCS_NA_BusinessLogic PCSNABusinessLogic=null;
	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC20_Set_quote_as_duplicate");
		driver = getDriver();
	}

	@Test
	@Parameters({"PCSURL","IBMURL","ENV"})
	
	public void RequestVSQuoteAndDistributorApproves(String PCSURL,String IBMURL,String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(
					driver, TC_ID,test);
			
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(
					driver, TC_ID,test);

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);
			
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID,test);
			ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID,test);
			PCSNABusinessLogic = new Epricer_Application_PCS_NA_BusinessLogic(driver, TC_ID,test);
			
			
			//login into the screen
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();			
			loginBusinessLogic.ibmIDPageData(ENV);
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
			PCSNABusinessLogic.pcs_RegistrationNumberScreen();
			
			//click on submit price request button:
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestBtnClick();
			//ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.submitPriceRequestScreen();
			PCSNABusinessLogic.quoteIdFetched();
			PCSNABusinessLogic.fill_mandatory_fields_on_submitscreen();
			PCSNABusinessLogic.click_on_submit_button();     
			
			//Login into IBM GUI:
			//PCSNABusinessLogic.send_for_duplicate_review(IBMURL);
			
			
				
			Extent_Reporting.Log_Pass("PCS_Duplicate_a_SBO_quote_accept_it_as_VS Passed.","PCS_Duplicate_a_SBO_quote_accept_it_as_VS Passed.",test);
						
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCS_Duplicate_a_SBO_quote_accept_it_as_VS Failed.","PCS_Duplicate_a_SBO_quote_accept_it_as_VS Failed.", driver,test);
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