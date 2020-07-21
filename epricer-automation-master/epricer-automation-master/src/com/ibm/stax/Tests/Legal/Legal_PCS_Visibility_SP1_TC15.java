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
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Legal_PCS_Visibility_SP1_TC15 extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;

	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "PCSURL", "IBMURL", "ENV" })
	public void Legal_TC15_PCS_Visibility_SP1_main(String PCSURL, String IBMURL, String ENV) throws Throwable {
		try {
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID, test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			// login with group EULEG_DSDEL - Dist Delete quote and create quote UK

			PCSloginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			 
			PCSloginBusinessLogic.pcsloggin();
			PCSloginBusinessLogic.secondIDPageData(ENV);
			PCSloginBusinessLogic.pcsENVSelect(ENV);
			 
			// select group

			PCSloginBusinessLogic.LaunchGroupLegal("NALEG_DIHVSP2 - Dist Hide Value Seller price");

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
			//PCSloginBusinessLogic.ibmIDPageData(ENV);
			PCSloginBusinessLogic.pcsENVSelect(ENV);
			 
			// select group

			PCSloginBusinessLogic.LaunchGroupLegal("NALEG_DIHVSP2 - Dist Hide Value Seller price");

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

			// String Quoteid_user1 = "5170547";
			// String Quoteid_user2 = "5170549";

			boolean checkIfQuoteExists = false;
			Quoteid = Quoteid_user1 + ',' + Quoteid_user2;

			// login with group EULEG_DSDEL - Dist Delete quote and check my quote page
			PCSloginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			 
			PCSloginBusinessLogic.pcsloggin();
			//PCSloginBusinessLogic.ibmIDPageData(ENV);
			PCSloginBusinessLogic.pcsENVSelect(ENV);
			 
			// select group

			PCSloginBusinessLogic.LaunchGroupLegal("NALEG_DIHVSP2 - Dist Hide Value Seller price");

			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickMultipleCheck();
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();

			Thread.sleep(15000);

			checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_user1, true);
			System.out.println("user1 quote check result " + checkIfQuoteExists);

			if (checkIfQuoteExists) {
				checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteid_user2, true);
				System.out.println("user2 quote check result " + checkIfQuoteExists);
			}

			if (checkIfQuoteExists) {

				Extent_Reporting.Log_Pass("Legal_PCS_Visibility_SP1_TC15 Passed.",
						"Legal_PCS_Visibility_SP1_TC15 Passed.", test);

			} else {
				throw new Exception("Failed");

			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_PCS_Visibility_SP1_TC15 Failed.", "Legal_PCS_Visibility_SP1_TC15.", driver,
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
