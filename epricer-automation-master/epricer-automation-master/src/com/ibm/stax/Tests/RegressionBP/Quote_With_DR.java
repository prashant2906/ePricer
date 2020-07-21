package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Quote_With_DR extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;

	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC4_Quote_With_DR- BeforeMethod");
		driver = getDriver();
	}

	@Test
	@Parameters({"MySAURL","ENV"})
	public void QuoteWithDR(String MySAURL,String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(
					driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(
					driver, TC_ID,test);
			changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(
					driver, TC_ID,test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(
					driver, TC_ID,test);

			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			
			//loginBusinessLogic.ibmIDPageData();
			//loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			//loginBusinessLogic.ePRICERMainScreen();

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			//createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			createAQuoteBusinessLogic.dataForEPricerOverviewScreenWithoutQuoteTitle();
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();

			//createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.dataForRegistrationNumberScreen();

			//createAQuoteBusinessLogic.detailsPricingPolygon();

			Extent_Reporting.Log_Pass("Quote_With_DR Passed.","Quote_With_DR Passed.",test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Quote_With_DR Failed.","Quote_With_DR Failed.", driver,test);
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