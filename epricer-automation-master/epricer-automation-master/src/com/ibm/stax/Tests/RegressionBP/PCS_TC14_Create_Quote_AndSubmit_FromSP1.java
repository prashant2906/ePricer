/**
 * @author Abhishek Singh
 * 
 */
package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_NA_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC14_Create_Quote_AndSubmit_FromSP1 extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_NA_BusinessLogic epricerApplicationPCSNABusinessLogic=null;
	
	String Quoteid = "";
	
	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC14_Create_Quote_AndSubmit_FromSP1");
		driver = getDriver();
		
	}
	
	@Test
	@Parameters({"PCSURL","ENV"})
	public void create_quote_submit_fromSP1(String PCSURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			epricerApplicationPCSNABusinessLogic=new Epricer_Application_PCS_NA_BusinessLogic(driver, TC_ID,test);
			
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();
			
			loginBusinessLogic.ibmIDPageData(ENV);
			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			loginBusinessLogic.ePricerLoginscreen();			

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			Thread.sleep(10000);
			Quoteid = createAQuoteBusinessLogic.quoteIdFetched();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen(ENV);
			
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();			
			
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			createAQuoteBusinessLogic.submitPriceClick();
			createAQuoteBusinessLogic.pcsSubmitScreenData();
			//epricerApplicationPCSNABusinessLogic.fill_mandatory_fields_on_submitscreen();
			//epricerApplicationPCSNABusinessLogic.click_on_submit_button();
			//createAQuoteBusinessLogic.pcsSubmitSBquote();
			
			
		
		
			
			Extent_Reporting.Log_Pass("Create a SB quote and submit from sp1 Passed.",
					"Create a SB quote and submit from sp1 Passed.",test);
			System.out.println("completed");
			
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail(
					"Create a SB quote and submit from sp1 Passed Failed.",
					"Create a SB quote and submit from sp1 Passed Failed.", driver,test);
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
