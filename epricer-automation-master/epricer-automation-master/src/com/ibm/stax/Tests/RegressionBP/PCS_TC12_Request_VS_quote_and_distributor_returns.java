/**
 *  
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
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC12_Request_VS_quote_and_distributor_returns extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	
	String Quoteid = "";
	
	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC12_Request_VS_quote_and_distributor_returns");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	
	@Test
	@Parameters({"PCSURL","ENV"})
	public void PCS_TC12_Request_VS_quote_and_distributor_returns_main(String PCSURL,String ENV) throws Throwable {
	
	
			try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(	driver, TC_ID,test);
			
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			
			loginBusinessLogic.pcsloggin();
			
			loginBusinessLogic.ibmIDPageData(ENV);
			Thread.sleep(10000);
			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			loginBusinessLogic.ePricerLoginscreen();		

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			Quoteid = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen(ENV);
			
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();			
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.componentAddedSuccessMsg();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			Thread.sleep(5000);
			createAQuoteBusinessLogic.pricingValueCheck();			
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			createAQuoteBusinessLogic.pcsRequestVSoffer();	
			
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();
			loginBusinessLogic.pcsENVSelect(ENV);
			loginBusinessLogic.ePricerLoginscreen("SelectADistributorRole",ENV);
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();
			Thread.sleep(20000);			
			createAQuoteBusinessLogic.pcsReturntorequester();
			Thread.sleep(10000);
			
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();
			loginBusinessLogic.pcsENVSelect(ENV);
			loginBusinessLogic.ePricerLoginscreen("SelectARole",ENV);
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();
		//	createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.pcsopenTabOverview();			
			createAQuoteBusinessLogic.pcsopenTabManageconfiguration();			
			createAQuoteBusinessLogic.changeQuantity();
			createAQuoteBusinessLogic.pcsclicksavecontinueonconfigurationtab();
			createAQuoteBusinessLogic.pcsopenTabPricingDetail();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.pcsRequestVSoffer();	
			
			Extent_Reporting.Log_Pass("PCS_TC12_Request_VS_quote_and_distributor_returns Passed.","PCS_TC12_Request_VS_quote_and_distributor_returns Passed.",test);		
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCS_TC12_Request_VS_quote_and_distributor_returns Failed.","PCS_TC12_Request_VS_quote_and_distributor_returns.", driver,test);
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