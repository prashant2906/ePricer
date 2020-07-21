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
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Legal_PCS_Visibility_SP1_TC17 extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;

	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "PCSURL", "IBMURL", "ENV" })
	public void Legal_TC17_PCS_Visibility_SP1_main(String PCSURL, String IBMURL, String ENV) throws Throwable {
		try {
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			// login with group EULEG_DSDEL - Dist Delete quote and create quote UK

			PCSloginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			 
			PCSloginBusinessLogic.pcsloggin();
			PCSloginBusinessLogic.ibmIDPageData(ENV);
			PCSloginBusinessLogic.pcsENVSelect(ENV);
			 
			// select group

			PCSloginBusinessLogic.LaunchGroupLegal("NALEG_DSDEL - Dist Delete quote");

			PCScreateAQuoteBusinessLogic.createANewQuoteLinkClick();
			String Quoteid_user1 = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("Quoteid_user1 is " + Quoteid_user1);

			PCScreateAQuoteBusinessLogic.overviewPolygonScreen();
			PCScreateAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen(ENV);

			PCScreateAQuoteBusinessLogic.dataForEPricerOverviewScreen();

			PCScreateAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			PCScreateAQuoteBusinessLogic.addProductManuallyButtonClick();
			PCScreateAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			PCScreateAQuoteBusinessLogic.componentAddedSuccessMsg();

			PCScreateAQuoteBusinessLogic.collectPricingButtonClick();
			Thread.sleep(15000);
			PCScreateAQuoteBusinessLogic.pricingValueCheck();

			PCScreateAQuoteBusinessLogic.registrationCustomerPolygon();
			PCScreateAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			PCScreateAQuoteBusinessLogic.submitPriceClick();
			PCScreateAQuoteBusinessLogic.pcsSubmitScreenData();

			Thread.sleep(30000);

			PCSloginBusinessLogic.pcsSignout();
			Thread.sleep(15000);

			driver.manage().deleteAllCookies();

			// Add steps to close and restart browser

			Thread.sleep(15000);

			// login with group EULEG_DINDEL - Dist not Delete quote Russia

			PCSloginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			 
			PCSloginBusinessLogic.pcsloggin();
			//PCSloginBusinessLogic.secondIDPageData(ENV);
			PCSloginBusinessLogic.pcsENVSelect(ENV);
			 
			// select group

			PCSloginBusinessLogic.LaunchGroupLegal("NALEG_DIVENT - Dist View Ent price");

			PCScreateAQuoteBusinessLogic.createANewQuoteLinkClick();
			String Quoteid_user2 = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("Quoteid_user2 is " + Quoteid_user2);

			PCScreateAQuoteBusinessLogic.overviewPolygonScreen();
			PCScreateAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen(ENV);

			PCScreateAQuoteBusinessLogic.dataForEPricerOverviewScreen();

			PCScreateAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			PCScreateAQuoteBusinessLogic.addProductManuallyButtonClick();
			PCScreateAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			PCScreateAQuoteBusinessLogic.componentAddedSuccessMsg();

			PCScreateAQuoteBusinessLogic.collectPricingButtonClick();
			Thread.sleep(15000);
			PCScreateAQuoteBusinessLogic.pricingValueCheck();

			PCScreateAQuoteBusinessLogic.registrationCustomerPolygon();
			PCScreateAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			PCScreateAQuoteBusinessLogic.submitPriceClick();
			PCScreateAQuoteBusinessLogic.pcsSubmitScreenData();

			Thread.sleep(30000);

			PCSloginBusinessLogic.pcsSignout();
			Thread.sleep(15000);

			driver.manage().deleteAllCookies();

			// Add steps to close and restart browser

			Thread.sleep(15000);

			// Add steps to close and restart browser

			Thread.sleep(15000);

			// String Quoteid_user1 = "5169176";
			// String Quoteid_user2 = "5169180";

			boolean checkIfQuoteExists = false;

			// login with group EULEG_DSDEL - Dist Delete quote and check my quote page
			PCSloginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			 
			PCSloginBusinessLogic.pcsloggin();
			//PCSloginBusinessLogic.ibmIDPageData(ENV);
			PCSloginBusinessLogic.pcsENVSelect(ENV);
			 
			// select group

			PCSloginBusinessLogic.LaunchGroupLegal("NALEG_DINDEL - Dist not Delete quote");

			createAQuoteBusinessLogic.clickmyquote();

			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_user1, true);
			System.out.println(checkIfQuoteExists + " " + Quoteid_user1);
			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_user2, false);
			System.out.println(checkIfQuoteExists + " " + Quoteid_user2);

			Extent_Reporting.Log_Pass("Legal_TC17_PCS_Visibility_SP1 Passed.", "Legal_TC17_PCS_Visibility_SP1 Passed.",
					test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_TC17_PCS_Visibility_SP1 Failed.", "Legal_TC17_PCS_Visibility_SP1.", driver,
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
