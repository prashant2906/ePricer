package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.stax.BusinessLogic.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC8_Duplicate_VSQuote_ChangeConfiguration_Accept_VSPrice extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic duplicateSBOQuote = null;
	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC8_Duplicate_VSQuote_ChangeConfiguration_Accept_VSPrice");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * 
	 * @throws Throwable
	 */
	@Test
	@Parameters({ "PCSURL", "ENV" })
	public void PCSDuplicate_VSQuote_ChangeConfiguration_Accept_VSPrice(String PCSURL, String ENV) throws Throwable {

		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,TC_ID, test);
			duplicateSBOQuote = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID,test);

			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();
			loginBusinessLogic.ibmIDPageData(ENV);
			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			loginBusinessLogic.ePricerLoginscreen();

			// Create a VS quote
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			Quoteid = createAQuoteBusinessLogic.quoteIdFetched();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen(ENV);
			createAQuoteBusinessLogic.click_on_saveandcontinue();
			//createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.addTwoConfigAndManualComponent();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			Thread.sleep(20000);
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.detailsPricingPolygon();
			createAQuoteBusinessLogic.pcsAcceptVSoffer();
			createAQuoteBusinessLogic.addendumTabClicked();

			// search and duplicate the VS quote
			// String Quoteid = "5157824";

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
			Thread.sleep(10000);
			createAQuoteBusinessLogic.pcsopenTabManageconfiguration();
			Thread.sleep(5000);
			duplicateSBOQuote.deleteOneCFRAndComponent();
			Thread.sleep(20000);
			createAQuoteBusinessLogic.pcsopenTabManageconfiguration();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			Thread.sleep(10000);
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			Thread.sleep(10000);
			// createAQuoteBusinessLogic.pcsdataForRegistrationNumbersmalldeal();
			createAQuoteBusinessLogic.pcsclicksavecontinueonconfigurationtab();
			// createAQuoteBusinessLogic.pcsdataForRegistrationNumbersmalldeal();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreencontinueonly();
			createAQuoteBusinessLogic.pcsAcceptVSoffer();

			// createAQuoteBusinessLogic.addendumTabClicked();

			// Open VS quote at IBM GUI

			Extent_Reporting.Log_Pass("PCS_TC8_Duplicate_VSQuote_ChangeConfiguration_Accept_VSPrice Passed.",
					"PCS_TC8_Duplicate_VSQuote_ChangeConfiguration_Accept_VSPrice Passed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCS_TC8_Duplicate_VSQuote_ChangeConfiguration_Accept_VSPrice Failed.",
					"PCS_TC8_Duplicate_VSQuote_ChangeConfiguration_Accept_VSPrice Failed.", driver, test);
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
