/**
  *  
 *
 */

package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC6_Create_A_SBO_Quote_Incomplete_It_And_Accept extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC6_Create_A_SBO_Quote_Incomplete_It_And_Accept");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * 
	 * @throws Throwable
	 */

	@Test
	@Parameters({"PCSURL", "IBMURL", "ENV" })
	public void PCS_TC6_Create_A_SBO_Quote_Incomplete_It_And_Accept_main(String PCSURL, String IBMURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID, test);

			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(
					driver, TC_ID, test);

			// create a SB quote

			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();

			loginBusinessLogic.ibmIDPageData(ENV);
			loginBusinessLogic.pcsENVSelect(ENV);
			Thread.sleep(10000);
			// select group
			loginBusinessLogic.ePricerLoginscreen();

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			Quoteid = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			Thread.sleep(5000);
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen(ENV);

			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();

			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			Thread.sleep(6000);
			createAQuoteBusinessLogic.pricingValueCheck();

			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			Thread.sleep(30000);
			createAQuoteBusinessLogic.pcsGotoSubmitSBquote(); // click the submit price request to go the submit price
			Thread.sleep(10000);													// quest tab
			createAQuoteBusinessLogic.pcsSubmitSBquote(); // sB quote submit

			// open ibm and incomplete the submitted sb quote

			loginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			Thread.sleep(30000);
			loginBusinessLogic.ePricerLoginscreen("SelectIBMRole",ENV);
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();
			Thread.sleep(20000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtocommentstatustab();
			EpricerApplicationIBMQuoteEditorBusinessLogic.changeBPquotestatus(false);

			// open bp to submit the quote again

			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();
			// loginBusinessLogic.ibmIDPageData();
			loginBusinessLogic.pcsENVSelect(ENV);

			loginBusinessLogic.ePricerLoginscreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();
			Thread.sleep(20000);

			createAQuoteBusinessLogic.pcsopenTabManageconfiguration();
			createAQuoteBusinessLogic.pcsclicksavecontinueonconfigurationtab();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreencontinueonly();
			createAQuoteBusinessLogic.pcsAcceptVSoffer();

			Extent_Reporting.Log_Pass("PCS_TC6_Create_A_SBO_Quote_Incomplete_It_And_Accept Passed.",
					"PCS_TC6_Create_A_SBO_Quote_Incomplete_It_And_Accept Passed.",test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCS_TC6_Create_A_SBO_Quote_Incomplete_It_And_Accept Failed.",
					"PCS_TC6_Create_A_SBO_Quote_Incomplete_It_And_Accept.", driver,test);
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