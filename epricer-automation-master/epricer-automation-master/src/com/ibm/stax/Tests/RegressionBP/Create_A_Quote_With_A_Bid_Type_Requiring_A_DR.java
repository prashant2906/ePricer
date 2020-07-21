package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class Create_A_Quote_With_A_Bid_Type_Requiring_A_DR extends Driver_Setup{


	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	
	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC1_Create_A_Quote_With_A_Bid_Type_Requiring_A_DR- BeforeMethod");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	
	@Test
	//@Parameters({"BPURL","ENV","MySAURL"})
	@Parameters({"MySAURL","ENV"})
	public void ePricerLogin(String MySAURL,String ENV) throws Throwable {
		try{
			
		loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver,TC_ID, test);
		createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
		
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
		createAQuoteBusinessLogic.dataForRegistrationNumberScreen();
		
		//createAQuoteBusinessLogic.detailsPricingPolygon();
		createAQuoteBusinessLogic.previewValueSellerOfferButtonClicked();
		//createAQuoteBusinessLogic.iBMBusinessPartnerValueSellerScreen();
		Thread.sleep(15000);
		createAQuoteBusinessLogic.closeIBMBusinessPartnerValueSellerScreenBtnClicked();
		//createAQuoteBusinessLogic.detailsPricingPolygon();
		
		//createAQuoteBusinessLogic.listPriceTotalValueCheck();
		createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
		//createAQuoteBusinessLogic.valueSellerApprovedStatusCheck();
		createAQuoteBusinessLogic.acceptValueSellerScreenHeadingsCheck();
		//Thread.sleep(5000);
		createAQuoteBusinessLogic.addendumTabClicked();
		//createAQuoteBusinessLogic.brandTabCheck();
		
		createAQuoteBusinessLogic.editAddendumButtonClicked();
		Thread.sleep(9000);
		createAQuoteBusinessLogic.brandCheckboxCheck();
		createAQuoteBusinessLogic.cancelAndCloseButtonClicked();
		
		createAQuoteBusinessLogic.sendAddendumButtonClicked();
		createAQuoteBusinessLogic.sendValueSellerAddendumScreen();
		createAQuoteBusinessLogic.sendMailButtonClicked();
		
		Extent_Reporting.Log_Pass("Create_A_Quote_With_A_Bid_Type_Requiring_A_DR Passed.",
				"Create_A_Quote_With_A_Bid_Type_Requiring_A_DR Passed.", test);
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Create_A_Quote_With_A_Bid_Type_Requiring_A_DR Failed.",
					"Create_A_Quote_With_A_Bid_Type_Requiring_A_DR Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Create_A_Quote_With_A_Bid_Type_Requiring_A_DR Failed.");
		}
	}
	
	@AfterTest
	  public void tearDown() {
		  driver.quit();
	  } 
}
