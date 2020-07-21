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
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC3_Distributor_SP1_Value_Seller_quotes extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	
	@Test
	@Parameters({"PCSURL","ENV"})
	public void PCS_Distributor_SP1_Value_Seller_quotes_Login(String PCSURL,String ENV) throws Throwable {
	
	
		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();
			
			loginBusinessLogic.ibmIDPageData(ENV);
			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			loginBusinessLogic.ePricerLoginscreen();
			
			

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
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
			Thread.sleep(10000);
			createAQuoteBusinessLogic.pcsAcceptVSoffer();
			Extent_Reporting.Log_Pass("PCS_Distributor_SP1_Value_Seller_quotes Passed.",
					"PCS_Distributor_SP1_Value_Seller_quotes Passed.",test);
			
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail(
					"PCS_Distributor_SP1_Value_Seller_quotes Failed.",
					"PCS_Distributor_SP1_Value_Seller_quotes Failed.", driver,test);
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