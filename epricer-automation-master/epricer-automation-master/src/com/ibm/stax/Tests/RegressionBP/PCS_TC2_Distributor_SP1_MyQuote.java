package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ibm.stax.BusinessLogic.PCS.*;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC2_Distributor_SP1_MyQuote extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_MyQuote_BusinessLogic EpricerApplicationMyQuoteBusinessLogic = null;
	
	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC2_Distributor_SP1_MyQuote");
		driver = getDriver();
	}

	@Test
	@Parameters({"PCSURL","ENV"})
	public void PCSMyQuote(String PCSURL,String ENV) throws Throwable {
	
	
		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(
					driver, TC_ID,test);
			
			EpricerApplicationMyQuoteBusinessLogic = new Epricer_Application_PCS_MyQuote_BusinessLogic(
					driver, TC_ID,test);

		
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			
			loginBusinessLogic.pcsloggin();
			
			loginBusinessLogic.ibmIDPageData(ENV);
			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			loginBusinessLogic.ePricerLoginscreen();
			
			EpricerApplicationMyQuoteBusinessLogic.MyQuotesLinkClick();
			EpricerApplicationMyQuoteBusinessLogic.MyQuotesCheckPage();
			

			Extent_Reporting.Log_Pass("My quote Passed.",
					"My quote Passed.",test);
			
			
			
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail(
					"Search quote Failed.",
					"Search quote Failed.", driver,test);
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