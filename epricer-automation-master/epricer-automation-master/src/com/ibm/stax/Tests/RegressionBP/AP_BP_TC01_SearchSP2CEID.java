/**
 * @author Meenal
 *
 */

package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_SearchQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class AP_BP_TC01_SearchSP2CEID extends Driver_Setup {
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	
	
	@BeforeClass
	public void setUp() {
		System.out.println("testcase1");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	@Parameters({ "MySAURL", "IBMURL","ENV"})
	@Test
	public void SearchSP2CEID(String MySAURL, String IBMURL, String ENV) throws Throwable {
		

		try {
			
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationSearchQuoteBusinessLogic= new Epricer_Application_SearchQuote_BusinessLogic (driver,TC_ID,test);
			
			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			
	//		loginBusinessLogic.PSATLaunch(PSATURL,"JP");
			
			
			loginBusinessLogic.LaunchGroup();
			
			
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.Getallsearchcriteria();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaCEIDSelect("*");
			//EpricerApplicationSearchQuoteBusinessLogic.ClickMultipleCheck();
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();
			
		}
		
		catch (Exception e) {
			Extent_Reporting.Log_Fail("SearchMultipleQuotes","SearchMultipleQuotes Failed.", driver,test);
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
