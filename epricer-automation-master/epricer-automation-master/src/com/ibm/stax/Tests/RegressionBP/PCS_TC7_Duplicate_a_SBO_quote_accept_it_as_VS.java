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

import com.ibm.stax.BusinessLogic.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic;

import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC7_Duplicate_a_SBO_quote_accept_it_as_VS extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic duplicateSBOQuote = null;
	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC7_Duplicate_a_SBO_quote_accept_it_as_VS");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * 
	 * @throws Throwable
	 */

	@Test
	@Parameters({ "PCSURL", "IBMURL", "ENV" })
	public void PCS_TC7_Duplicate_a_SBO_quote_accept_it_as_VS_method(String PCSURL, String IBMURL, String ENV)
			throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID,test);

			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(
					driver, TC_ID,test);
			duplicateSBOQuote = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID,test);
			// create a SB quote

			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();

			loginBusinessLogic.ibmIDPageData(ENV);
			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			loginBusinessLogic.ePricerLoginscreen();

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			Quoteid = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen(ENV);

			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();

			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();

			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			createAQuoteBusinessLogic.pcsGotoSubmitSBquote(); // click the submit price request to go the submit price
																// quest tab
			createAQuoteBusinessLogic.pcsSubmitSBquote(); // sB quote submit

			Thread.sleep(10000);
			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();

			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			loginBusinessLogic.ePricerLoginscreen();

			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickMultipleCheck();
			// click the multiple result
			EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();
			Thread.sleep(10000);

			duplicateSBOQuote.quoteIdLinkPresent();
			duplicateSBOQuote.duplicatingQuoteGoBtnClicked();
			duplicateSBOQuote.addCrad();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreencontinueonly();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.pcsAcceptVSoffer();
			/*
			 * createAQuoteBusinessLogic.pcsopenTabManageconfiguration();
			 * 
			 * createAQuoteBusinessLogic.pcsclicksavecontinueonconfigurationtab();
			 * createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreencontinueonly();
			 * createAQuoteBusinessLogic.pcsAcceptVSoffer();
			 */

			Extent_Reporting.Log_Pass("PCS_TC7_Duplicate_a_SBO_quote_accept_it_as_VS Passed.",
					"PCS_TC7_Duplicate_a_SBO_quote_accept_it_as_VS Passed.",test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCS_TC7_Duplicate_a_SBO_quote_accept_it_as_VS Failed.",
					"PCS_TC7_Duplicate_a_SBO_quote_accept_it_as_VS Failed.", driver,test);
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