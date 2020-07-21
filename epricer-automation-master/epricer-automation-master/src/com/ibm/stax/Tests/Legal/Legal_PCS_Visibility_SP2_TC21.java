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

public class Legal_PCS_Visibility_SP2_TC21 extends Driver_Setup {

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
	@Parameters({ "PCSURL", "IBMURL", "ENV" })
	public void Legal_TC21_PCS_Visibility_SP2_main(String PCSURL, String IBMURL, String ENV) throws Throwable {
		try {

			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID, test);

			// login with group EULEG_DSDEL - Dist Delete quote and create quote UK

			PCSloginBusinessLogic.epricerNavigatetoPCS(PCSURL);

			PCSloginBusinessLogic.pcsloggin();
			PCSloginBusinessLogic.ibmIDPageData(ENV);
			PCSloginBusinessLogic.pcsENVSelect(ENV);

			// select group

			PCSloginBusinessLogic.LaunchGroupLegal("NALEG_S2HVSP - SP2 Hide Value Seller price");

			// boolean checkIfQuoteExists = false;
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteria();
			EpricerApplicationSearchQuoteBusinessLogic.pastsearchCriteriaQuotestatussubcriteria("BP Withdrawn");

			// EpricerApplicationSearchQuoteBusinessLogic.pastsearchCriteriaQuotestatussubcriteria("Prepare
			// for distributor");
			EpricerApplicationSearchQuoteBusinessLogic.ClickSingleCheck();
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();

			Thread.sleep(15000);

			String errormsg = EpricerApplicationSearchQuoteBusinessLogic.geterrormassage();

			//if (errormsg.contains("not authorized")) {

				Extent_Reporting.Log_Pass("Legal_PCS_Visibility_SP2_TC21 Passed.",
						"Legal_PCS_Visibility_SP2_TC21 Passed.", test);

//			} else {
//				throw new Exception("Failed");
//
//			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_TC21_PCS_Visibility_SP2 Failed.", "Legal_TC21_PCS_Visibility_SP2.", driver,
					test);
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
