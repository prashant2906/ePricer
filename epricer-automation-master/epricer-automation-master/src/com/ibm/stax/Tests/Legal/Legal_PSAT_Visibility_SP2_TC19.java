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

public class Legal_PSAT_Visibility_SP2_TC19 extends Driver_Setup {

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
	public void Legal_TC19_PSAT_Visibility_SP2_main(String MySAURL, String IBMURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID, test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			// login with group EULEG_DSDEL - Dist Delete quote and create quote UK

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_S2DEL - SP2 Delete quote");

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			String Quoteid_user1 = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("Quoteid_user1 is " + Quoteid_user1);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("Russia",
					"Managed Services Offering", ENV);
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();

			createAQuoteBusinessLogic.uploadCFRLegal("AllCombination1.cfr");

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.CustomerpageinPSAT();

			createAQuoteBusinessLogic.detailsPricingPolygon();
			Thread.sleep(5000);

			createAQuoteBusinessLogic.checkrequestexceptioncheckbox();

			createAQuoteBusinessLogic.clicksubmitpricerequestbutton();
			Thread.sleep(15000);
			createAQuoteBusinessLogic.PSATinputIBMchanelinfo();
			createAQuoteBusinessLogic.PSATSBsubmit();
			Thread.sleep(30000);

			createAQuoteBusinessLogic.PSATLogout();
			Thread.sleep(30000);
			loginBusinessLogic.MySAlogout();

			driver.manage().deleteAllCookies();

			// Add steps to close and restart browser

			Thread.sleep(15000);

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_S2VENT - SP2 View Ent price");

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			String Quoteid_user2 = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("Quoteid_user2 is " + Quoteid_user2);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("Russia",
					"Managed Services Offering", ENV);
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();

			createAQuoteBusinessLogic.uploadCFRLegal("AllCombination1.cfr");

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.CustomerpageinPSAT();

			createAQuoteBusinessLogic.detailsPricingPolygon();
			Thread.sleep(5000);

			createAQuoteBusinessLogic.checkrequestexceptioncheckbox();

			createAQuoteBusinessLogic.clicksubmitpricerequestbutton();
			Thread.sleep(15000);
			createAQuoteBusinessLogic.PSATinputIBMchanelinfo();
			createAQuoteBusinessLogic.PSATSBsubmit();
			Thread.sleep(30000);

			createAQuoteBusinessLogic.PSATLogout();
			Thread.sleep(30000);
			loginBusinessLogic.MySAlogout();

			driver.manage().deleteAllCookies();

			// Add steps to close and restart browser

			Thread.sleep(15000);

			String quoteid = Quoteid_user1 + ',' + Quoteid_user2;

			loginBusinessLogic.MySALaunchwithSecondUser(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_S2NDEL - SP2 not Delete quote");

			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickMultipleCheck();
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();

			boolean check1 = EpricerApplicationSearchQuoteBusinessLogic.Checksearchquotedisplay(Quoteid_user1, false);
			System.out.println("check result for user 1 is " + check1);
			boolean check2 = EpricerApplicationSearchQuoteBusinessLogic.Checksearchquotedisplay(Quoteid_user2, false);
			System.out.println("check result for user 2 is " + check1);

			if (check1 && check2) {

				Extent_Reporting.Log_Pass("Legal_TC19_PSAT_Visibility_SP2 Passed.",
						"Legal_TC19_PSAT_Visibility_SP2 Passed.", test);
			} else {
				throw new Exception("Failed");

			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_TC19_PSAT_Visibility_SP2 Failed.", "Legal_TC19_PSAT_Visibility_SP2.",
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
