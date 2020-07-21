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
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Change_Configuration_Quantity extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic ePricerUpdateAQuote= null;

	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC3_Change_Configuration_Quantity- BeforeMethod");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * 
	 * @throws Throwable
	 */

	@Test
	@Parameters({"MySAURL","ENV"})
	public void ChangeConfigurationQuantity(String MySAURL,String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(
					driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(
					driver, TC_ID, test);
			changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(
					driver, TC_ID, test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(
					driver, TC_ID, test);
			ePricerUpdateAQuote = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID, test);
			
			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			//loginBusinessLogic.ibmIDPageData();
			//loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen(); 

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			//createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			createAQuoteBusinessLogic.dataForEPricerOverviewScreenWithoutQuoteTitle();
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			changeConfigurationQuantity.dataForEPricerAddProductManuallyScreenwithMultipleFeature();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteNotRequiringDRBusinessLogic.searchCustomerButtonClick();
			createAQuoteNotRequiringDRBusinessLogic.dataForSearchCustomerScreen();
			changeConfigurationQuantity.selectTabManageConfigurationPolygonScreenFromDetialsPricing();
			changeConfigurationQuantity.changeQuantityOfFeature();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			ePricerUpdateAQuote.uploadCFR();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			changeConfigurationQuantity.changeCFRQuantity();
			createAQuoteBusinessLogic.collectPricingButtonClick();

			Extent_Reporting.Log_Pass("Change_Configuration_Quantity Passed.","Change_Configuration_Quantity Passed.", test);
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Change_Configuration_Quantity Failed.","Change_Configuration_Quantity Failed.", driver, test);
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