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

public class PCS_TC4_Duplicate_a_VS_approved_quote extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	
	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC4_Duplicate_a_VS_approved_quote");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	@Test
	@Parameters({"PCSURL","ENV"})
	public void PCS_Duplicate_a_VS_approved_quote_main(String PCSURL,String ENV) throws Throwable {
	
	
		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver, TC_ID,test);
			
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();
			
			loginBusinessLogic.ibmIDPageData(ENV);
			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			loginBusinessLogic.ePricerLoginscreen();
			
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			Thread.sleep(4000);
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			Thread.sleep(4000);
			EpricerApplicationSearchQuoteBusinessLogic.searchVSquotePCS();
			Thread.sleep(4000);
			EpricerApplicationSearchQuoteBusinessLogic.searchVSduplicate();//after crad and click for 2 save overview button one 1st and 2nd tab. add bp name on second tab
			Thread.sleep(9000);
			createAQuoteBusinessLogic.click_on_saveandcontinue();
			Thread.sleep(9000);
			createAQuoteBusinessLogic.pcsclicksavecontinueonconfigurationtab();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreencontinueonly();
			createAQuoteBusinessLogic.pcsAcceptVSoffer();			
		
			Extent_Reporting.Log_Pass("PCS_Duplicate_a_VS_approved_quote Passed.","PCS_Duplicate_a_VS_approved_quote Passed.",test);
			} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCS_Duplicate_a_VS_approved_quote Failed.","PCS_Duplicate_a_VS_approved_quote Failed.", driver,test);
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