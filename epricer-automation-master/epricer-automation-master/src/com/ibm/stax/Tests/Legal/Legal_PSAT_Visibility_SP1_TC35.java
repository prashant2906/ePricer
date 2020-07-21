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
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Legal_PSAT_Visibility_SP1_TC35 extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;

	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "MySAURL", "IBMURL", "ENV" })
	public void Legal_TC35_PSAT_Visibility_SP1_main(String MySAURL, String IBMURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID, test);

			// login with group EULEG_DSDEL - Dist Delete quote and create quote UK

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_DSDEL - Dist Delete quote");

			boolean checkIfQuoteExists = false;
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteria();
			EpricerApplicationSearchQuoteBusinessLogic
					.pastsearchCriteriaQuotestatussubcriteria("Value Seller Approved");
			EpricerApplicationSearchQuoteBusinessLogic.ClickSingleCheck();
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();

			Thread.sleep(15000);

			Quoteid = action.getInputTextValue(driver, ".//*[@id='resultTable']/table/tbody/tr[2]/td[2]/span/a",
					"get teh quote id");

			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid, true);
			System.out.println("user1 quote check result " + checkIfQuoteExists);

			if (checkIfQuoteExists) {

				Extent_Reporting.Log_Pass("Legal_TC35_PSAT_Visibility_SP1 Passed.",
						"Legal_TC35_PSAT_Visibility_SP1 Passed.", test);

			} else {
				throw new Exception("Failed");

			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_TC35_PSAT_Visibility_SP1 Failed.", "Legal_TC35_PSAT_Visibility_SP1.",
					driver, test);
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
