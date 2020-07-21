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
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Legal_PSAT_Visibility_SP1_TC06 extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;

	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "MySAURL", "IBMURL", "ENV" })
	public void Legal_TC06_PSAT_Visibility_SP1_main(String MySAURL, String IBMURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID, test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			
			// login with group EULEG_DSDEL - Dist Delete quote and create quote UK

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_DIHVSP2 - Dist Hide Value Seller price");

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			String Quoteid_user1 = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("Quoteid_user1 is " + Quoteid_user1);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("United Kingdom", "Standard",
					ENV);
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();

			createAQuoteBusinessLogic.uploadCFRLegal("AllCombination1.cfr");

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.CustomerpageinPSAT();

			createAQuoteBusinessLogic.detailsPricingPolygon();
			createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
			createAQuoteBusinessLogic.valueSellerApprovedStatusCheck();
			Thread.sleep(30000);

			createAQuoteBusinessLogic.closeCurrentquote();

			Thread.sleep(30000);

			createAQuoteBusinessLogic.PSATLogout();
			Thread.sleep(30000);
			loginBusinessLogic.MySAlogout();

			driver.manage().deleteAllCookies();

			// Add steps to close and restart browser

			Thread.sleep(15000);

			// login with group EULEG_DINDEL - Dist not Delete quote Russia

			loginBusinessLogic.MySALaunchwithSecondUser(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_DIHVSP2 - Dist Hide Value Seller price");

			boolean checkIfQuoteExists = false;
			Thread.sleep(15000);
			createAQuoteBusinessLogic.clickmyquote();

			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_user1, true);
			System.out.println(checkIfQuoteExists + " " + Quoteid_user1);

			Extent_Reporting.Log_Pass("Legal_TC06_PSAT_Visibility_SP1 Passed.",
					"Legal_TC06_PSAT_Visibility_SP1 Passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_TC06_PSAT_Visibility_SP1 Failed.", "Legal_TC06_PSAT_Visibility_SP1.",
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
