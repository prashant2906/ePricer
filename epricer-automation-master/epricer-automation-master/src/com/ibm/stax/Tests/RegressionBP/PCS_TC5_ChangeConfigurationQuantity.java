package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_ChangeConfigurationQuantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC5_ChangeConfigurationQuantity extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_ChangeConfigurationQuantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_UpdateAQuote_BusinessLogic ePricerUpdateAQuote = null;

	@BeforeClass
	public void setUp() {
		System.out.println("PCS_TC5_ChangeConfigurationQuantity");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * 
	 * @throws Throwable
	 */
	@Test
	@Parameters({ "PCSURL", "ENV" })
	public void Change_Configuration(String PCSURL, String ENV) throws Throwable {

		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			changeConfigurationQuantity = new Epricer_Application_PCS_ChangeConfigurationQuantity_BusinessLogic(driver,	TC_ID,test);
			ePricerUpdateAQuote = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);

			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();

			loginBusinessLogic.ibmIDPageData(ENV);
			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			loginBusinessLogic.ePricerLoginscreen();

			// create a quote and fill mandatory fields on overview page:
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen(ENV);
			createAQuoteBusinessLogic.click_on_saveandcontinue();

			// goto manage configuration screen and add product manually:
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			changeConfigurationQuantity.dataForEPricerAddProductManuallyScreenwithMultipleFeature();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.collectPricingButtonClick();
			Thread.sleep(6000);
			createAQuoteBusinessLogic.pricingValueCheck();

			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.detailsPricingPolygon();
			changeConfigurationQuantity.selectTabManageConfigurationPolygonScreenFromDetialsPricing();
			Thread.sleep(5000);
			changeConfigurationQuantity.changeQuantityOfFeature();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			ePricerUpdateAQuote.uploadCFR();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			Thread.sleep(6000);
			changeConfigurationQuantity.changeCFRQuantity();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			Extent_Reporting.Log_Pass("Change_Configuration_Quantity Passed.", "Change_Configuration_Quantity Passed.",test);
		}

		catch (Exception e) {
			Extent_Reporting.Log_Fail("Change_Configuration_Quantity Failed.", "Change_Configuration_Quantity Failed.",	driver,test);
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
