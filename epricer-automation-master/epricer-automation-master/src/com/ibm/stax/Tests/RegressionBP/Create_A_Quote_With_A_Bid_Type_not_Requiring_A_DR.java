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

public class Create_A_Quote_With_A_Bid_Type_not_Requiring_A_DR extends
		Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigQuantity = null;

	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC2_Create_A_Quote_With_A_Bid_Type_Not_Requiring_A_DR- BeforeMethod");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * 
	 * @throws Throwable
	 */

	@Test
	@Parameters({"MySAURL","ENV"})
	public void CreateAQuoteWithBidTypeNotRequiringDR(String MySAURL,String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(
					driver, TC_ID, test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(
					driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(
					driver, TC_ID, test);
			changeConfigQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID, test);
			
			
			loginBusinessLogic.MySALaunch(MySAURL,ENV);			
			//loginBusinessLogic.ibmIDPageData();
			//loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			//loginBusinessLogic.ePRICERMainScreen();
			Thread.sleep(8000);
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			//createAQuoteBusinessLogic.overviewPolygonScreen();
			//createAQuoteNotRequiringDRBusinessLogic.dataForEPricerOverviewScreenTab();
			createAQuoteNotRequiringDRBusinessLogic.dataForEPricerOverviewWithoutQuoteTitle();
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();

			//createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteNotRequiringDRBusinessLogic.searchCustomerButtonClick();
			createAQuoteNotRequiringDRBusinessLogic.dataForSearchCustomerScreen();
			Thread.sleep(5000);
			//createAQuoteBusinessLogic.detailsPricingPolygon();
			createAQuoteBusinessLogic.previewValueSellerOfferButtonClicked();
			Thread.sleep(9000);
			createAQuoteBusinessLogic.closeIBMBusinessPartnerValueSellerScreenBtnClicked();
			createAQuoteBusinessLogic.detailsPricingPolygon();

			//createAQuoteBusinessLogic.listPriceTotalValueCheck();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
			//createAQuoteBusinessLogic.valueSellerApprovedStatusCheck();
			createAQuoteBusinessLogic.acceptValueSellerScreenHeadingsCheck();

			createAQuoteBusinessLogic.addendumTabClicked();
			//createAQuoteBusinessLogic.brandTabCheck();

			createAQuoteBusinessLogic.editAddendumButtonClicked();
			Thread.sleep(8000);
			createAQuoteBusinessLogic.brandCheckboxCheck();
			createAQuoteBusinessLogic.cancelAndCloseButtonClicked();

			createAQuoteBusinessLogic.sendAddendumButtonClicked();
			createAQuoteBusinessLogic.sendValueSellerAddendumScreen();
			changeConfigQuantity.sendMailButtonClicked();
			// *-------------------------------------------Testcase4------------------------------*\\
			//createAQuoteNotRequiringDRBusinessLogic.clickOnSearchQuote();

			Extent_Reporting.Log_Pass("Create_A_Quote_With_A_Bid_Type_Not_Requiring_A_DR Passed.",
							"Create_A_Quote_With_A_Bid_Type_Not_Requiring_A_DR Passed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Create_A_Quote_With_A_Bid_Type_Not_Requiring_A_DR Failed.",
							"Create_A_Quote_With_A_Bid_Type_Not_Requiring_A_DR Failed.",driver, test);
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
