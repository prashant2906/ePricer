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
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Legal_LegalTest_With_Manual extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;

	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "MySAURL", "IBMURL", "ENV" })
	public void Legal_TC01_LegalTest_With_Manual_main(String MySAURL, String IBMURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			// login with group EULEG_DSDEL - Dist Delete quote and create quote UK

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_DSDEL - Dist Delete quote");

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			String Quoteid_EULEG_DSDEL = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("Quoteid_EULEG_DSDEL is " + Quoteid_EULEG_DSDEL);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("United Kingdom", "Standard",ENV);
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();

			createAQuoteBusinessLogic.uploadCFRLegal("AegonGB.cfr");
			Thread.sleep(20000);
			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.CustomerpageinPSAT();

			createAQuoteBusinessLogic.detailsPricingPolygon();
			createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();

			Thread.sleep(15000);

			// login with group EULEG_DINDEL - Dist not Delete quote Russia

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_DINDEL - Dist not Delete quote");

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			String Quoteid_EULEG_DINDEL = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("Quoteid_EULEG_DINDEL is " + Quoteid_EULEG_DINDEL);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("Russia", "Standard", ENV);
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();

			createAQuoteBusinessLogic.uploadCFRLegal("AegonGB.cfr");

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.CustomerpageinPSAT();

			createAQuoteBusinessLogic.detailsPricingPolygon();
			createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();

			// login with group EULEG_S2VENT - SP2 View Ent pricer UK

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_S2VENT - SP2 View Ent price");

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			String Quoteid_EULEG_S2VENT = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("Quoteid_EULEG_S2VENT is " + Quoteid_EULEG_S2VENT);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("United Kingdom", "Standard",
					ENV);
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();

			createAQuoteBusinessLogic.uploadCFRLegal("CPD1_1xV5010E_5x1,9TB+50x12TB+ET+5y_SBT(1).cfr");

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.CustomerpageinPSAT();
			Thread.sleep(20000);
			PCScreateAQuoteBusinessLogic.pcsRequestVSoffer();
			// login with group EULEG_DIHVSP2 - Dist Hide Value Seller pricer UK

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_DIHVSP2 - Dist Hide Value Seller price");

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			String Quoteid_EULEG_DIHVSP2 = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("Quoteid_EULEG_DIHVSP2 is " + Quoteid_EULEG_DIHVSP2);
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

			boolean checkIfQuoteExists = false;

			// login with group EULEG_DSDEL - Dist Delete quote and check my quote page
			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_DSDEL - Dist Delete quote");

			createAQuoteBusinessLogic.clickmyquote();

			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DSDEL, true);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DSDEL);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DINDEL, true);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DINDEL);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_S2VENT, true);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_S2VENT);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DIHVSP2, true);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DIHVSP2);

			// login with group EULEG_DINDEL - Dist not Delete quote and check my quote page

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_DINDEL - Dist not Delete quote");

			createAQuoteBusinessLogic.clickmyquote();

			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DSDEL, false);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DSDEL);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DINDEL, true);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DINDEL);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_S2VENT, false);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_S2VENT);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DIHVSP2, false);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DIHVSP2);

			// login with group EULEG_S2VENT - SP2 View Ent price and check my quote page

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_S2VENT - SP2 View Ent price");

			createAQuoteBusinessLogic.clickmyquote();

			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DSDEL, false);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DSDEL);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DINDEL, false);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DINDEL);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_S2VENT, true);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_S2VENT);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DIHVSP2, false);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DIHVSP2);

			// login with group EULEG_DIHVSP2 - Dist Hide Value Seller price and check my
			// quote page

			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroupLegal("EULEG_DIHVSP2 - Dist Hide Value Seller price");

			createAQuoteBusinessLogic.clickmyquote();

			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DSDEL, false);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DSDEL);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DINDEL, false);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DINDEL);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_S2VENT, false);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_S2VENT);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_EULEG_DIHVSP2, true);
			System.out.println(checkIfQuoteExists + " " + Quoteid_EULEG_DIHVSP2);

			Extent_Reporting.Log_Pass("Legal_TC01_LegalTest_With_Manual Passed.",
					"Legal_TC01_LegalTest_With_Manual Passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_TC01_LegalTest_With_Manual Failed.", "Legal_TC01_LegalTest_With_Manual.",
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
