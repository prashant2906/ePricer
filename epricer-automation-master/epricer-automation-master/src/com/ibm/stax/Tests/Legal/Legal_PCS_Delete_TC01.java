/**
 *  
 *
 */


package com.ibm.stax.Tests.Legal;

import com.ibm.stax.InitialSetup.Driver_Setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class Legal_PCS_Delete_TC01 extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	
	String Quoteid = "";
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({"PCSURL", "IBMURL","ENV" })
	public void Legal_PCS_Delete_TC01_main(String PCSURL,String IBMURL, String ENV) throws Throwable {
		try {
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver, TC_ID, test);
						 
			PCSloginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			
			PCSloginBusinessLogic.pcsloggin();
			
			PCSloginBusinessLogic.ibmIDPageData(ENV);
			PCSloginBusinessLogic.pcsENVSelect(ENV);
			// select group

			PCSloginBusinessLogic.LaunchGroupLegal("NALEG_S2DEL - SP2 Delete quote");

			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteria();
			EpricerApplicationSearchQuoteBusinessLogic
					.pastsearchCriteriaQuotestatussubcriteria("Prepare for distributor");
			EpricerApplicationSearchQuoteBusinessLogic.ClickSingleCheck();
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();
			Thread.sleep(15000);
			EpricerApplicationSearchQuoteBusinessLogic.checkonthefirstresult();

			boolean check2 = EpricerApplicationSearchQuoteBusinessLogic.Checkdropdownlist("Delete", true);
			System.out.println("check result for user 1 is " + check2);

			if (check2) {

				Extent_Reporting.Log_Pass("Legal_PCS_Delete_TC01 Passed.", "Legal_PCS_Delete_TC01 Passed.", test);
			} else {
				throw new Exception("Failed");

			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_PCS_Delete_TC01 Failed.",
					"Legal_PCS_Delete_TC01.", driver, test);
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
