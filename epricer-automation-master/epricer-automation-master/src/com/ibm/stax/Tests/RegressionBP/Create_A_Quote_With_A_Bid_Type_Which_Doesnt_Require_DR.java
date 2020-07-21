/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class Create_A_Quote_With_A_Bid_Type_Which_Doesnt_Require_DR extends Driver_Setup{


	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic= null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	
	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC13_Create_A_Quote_With_A_Bid_Type_Which_Doesnt_Require_DR- BeforeMethod");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	
	@Test
	@Parameters({"MySAURL","ENV"})
	public void ePricerLogin(String MySAURL,String ENV) throws Throwable {
		try{
			
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver,TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID, test);			
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID, test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(driver, TC_ID, test);
			
			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			//loginBusinessLogic.ibmIDPageData();
			//loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			//loginBusinessLogic.ePRICERMainScreen();
			
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			//createAQuoteBusinessLogic.overviewPolygonScreen();
			//createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			createAQuoteBusinessLogic.dataForEPricerOverviewScreenWithoutQuoteTitle();
			//createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();
			
			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			
			createAQuoteNotRequiringDRBusinessLogic.searchCustomerButtonClick();
			createAQuoteNotRequiringDRBusinessLogic.dataForSearchCustomerScreen();
			
			//createAQuoteBusinessLogic.detailsPricingPolygon();
			Thread.sleep(15000);
			createAQuoteBusinessLogic.previewValueSellerOfferButtonClicked();
			createAQuoteBusinessLogic.closeIBMBusinessPartnerValueSellerScreenBtnClicked();
			createAQuoteBusinessLogic.detailsPricingPolygon();
			Thread.sleep(5000);
			//createAQuoteBusinessLogic.listPriceTotalValueCheck();
			Thread.sleep(5000);
			createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
			//createAQuoteBusinessLogic.valueSellerApprovedStatusCheck();
			//createAQuoteBusinessLogic.acceptValueSellerScreenHeadingsCheck();
			Thread.sleep(5000);
			createAQuoteBusinessLogic.addendumTabClicked();
			//createAQuoteBusinessLogic.brandTabCheck();

			createAQuoteBusinessLogic.editAddendumButtonClicked();
			createAQuoteBusinessLogic.brandCheckboxCheck();
			Thread.sleep(9000);
			createAQuoteBusinessLogic.cancelAndCloseButtonClicked();

			createAQuoteBusinessLogic.sendAddendumButtonClicked();
			createAQuoteBusinessLogic.sendValueSellerAddendumScreen();
			createAQuoteBusinessLogic.sendMailButtonClicked();
			
			
		Extent_Reporting.Log_Pass("Create_A_Quote_With_A_Bid_Type_Which_Doesnt_Require_DR Passed.",
				"Create_A_Quote_With_A_Bid_Type_Which_Doesnt_Require_DR Passed.", test);
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Create_A_Quote_With_A_Bid_Type_Which_Doesnt_Require_DR Failed.",
					"Create_A_Quote_With_A_Bid_Type_Which_Doesnt_Require_DR Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Create_A_Quote_With_A_Bid_Type_Which_Doesnt_Require_DR Failed.");
		}
	}
	
	@AfterTest
	  public void tearDown() {
		  driver.quit();
	  } 
}
