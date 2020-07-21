/**
 * @author Neha Upadhyay
 *
 */
package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Duplicate_A_VS_Approved_Quote_TC28 extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBL = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic duplicateSBOQuoteBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  createAVSQuoteAndAcceptBL= null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_BusinessLogic duplicateAVSBL = null;
	Epricer_Application_UpdateAQuote_BusinessLogic ePricerUpdateQuote = null;
	
	@BeforeClass
	public void setUp() {
		System.out.println("inside class : Duplicate_A_VS_Approved_Quote_TC28- BeforeMethod");
		driver = getDriver();
	}
	
	@Test
	@Parameters({"MySAURL","ENV"})
	public void DuplicateSBOQuoteAcceptAsVS(String MySAURL,String ENV) throws Throwable {
		try{
			
		loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver,TC_ID,test);
		createAQuoteBusinessLogic = new  Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
		duplicateAVSBL = new Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_BusinessLogic(driver, TC_ID,test);
		changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID,test);
		createAQuoteNotRequiringDRBL = new  Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(driver, TC_ID,test);
		duplicateSBOQuoteBusinessLogic = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID,test);
		updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);
		createAVSQuoteAndAcceptBL = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID,test);
		ePricerUpdateQuote = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);
		

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
		createAQuoteBusinessLogic.addTwoConfigAndManualComponent();

		createAQuoteBusinessLogic.collectPricingButtonClick();
		createAQuoteBusinessLogic.pricingValueCheck();
		
		//createAQuoteBusinessLogic.registrationCustomerPolygon();
		createAQuoteBusinessLogic.dataForRegistrationNumberScreen();
		
		//createAQuoteBusinessLogic.detailsPricingPolygon();
		
		createAVSQuoteAndAcceptBL.quoteIdFetched();
		
		duplicateSBOQuoteBusinessLogic.detailsPricingClick();
		Thread.sleep(6000);
		duplicateAVSBL.requestValueSellerOfferBTNClicked();
		
		duplicateSBOQuoteBusinessLogic.submittedToDistributorQuoteIdLinkPresent();		
		createAVSQuoteAndAcceptBL.refreshPage();
		
		//loginBusinessLogic.epricerLogoScreen();
		loginBusinessLogic.ePricerLoginWithDistributorProfile();
		//loginBusinessLogic.ePRICERMainScreen();
		ePricerUpdateQuote.searchQuotesLinkClick();
		ePricerUpdateQuote.searchCriteriaQuoteIdSelect();

		createAVSQuoteAndAcceptBL.searchQuoteButtonClicked();
		createAQuoteBusinessLogic.moveToDetailsPricing();
		action.waitForPageToLoad(driver);
		createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
		
		Extent_Reporting.Log_Pass("Duplicate_A_VS_Approved_Quote_TC28 Passed.","Duplicate_A_VS_Approved_Quote_TC28 Passed.",test);
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Duplicate_A_VS_Approved_Quote_TC28 Failed.","Duplicate_A_VS_Approved_Quote_TC28 Failed.", driver,test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}
	
	
	@AfterTest
	  public void tearDown() {
		  driver.quit();
	  } 
}