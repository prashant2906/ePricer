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

public class Legal_PSAT_Delete_TC07 extends Driver_Setup {

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
	public void Legal_PSAT_Delete_TC07_main(String MySAURL, String IBMURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID, test);

			// login with group EULEG_DSDEL - Dist Delete quote and create quote UK

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_S2DEL - SP2 Delete quote");

			createAQuoteBusinessLogic.clickmyquote();

			createAQuoteBusinessLogic.myquoterefinebystatus("Returned from distributor");

			Thread.sleep(15000);
			EpricerApplicationSearchQuoteBusinessLogic.checkonthefirstresult();

			boolean check2 = EpricerApplicationSearchQuoteBusinessLogic.Checkdropdownlist("Delete", true);
			System.out.println("check result for user 1 is " + check2);

			if (check2) {

				Extent_Reporting.Log_Pass("Legal_PSAT_Delete_TC07 Passed.", "Legal_PSAT_Delete_TC07 Passed.", test);
			} else {
				throw new Exception("Failed");

			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_PSAT_Delete_TC07 Failed.", "Legal_PSAT_Delete_TC07.", driver, test);
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
