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

public class Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic duplicateSBOQuote = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  createAVSQuoteAndAcceptBusinessLogic= null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuote = null;


	
	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC14_Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price- BeforeMethod");
		driver = getDriver();
	}
	
	@Test
	@Parameters({"MySAURL","ENV"})
	public void DuplicateSBOQuoteAcceptAsVS(String MySAURL,String ENV) throws Throwable {
		try{
			
		loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver,TC_ID,test);
		createAQuoteBusinessLogic = new  Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
		changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID,test);
		createAQuoteNotRequiringDRBusinessLogic = new  Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(driver, TC_ID,test);
		duplicateSBOQuote = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID,test);
		
		updateAQuote = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);
		createAVSQuoteAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID,test);

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
		/*
		for(int i=1; i<=2; i++){
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.componentAddedSuccessMsg();
			updateAQuote.uploadCFR();
		}
		*/
		createAQuoteBusinessLogic.collectPricingButtonClick();
		createAQuoteBusinessLogic.pricingValueCheck();
		
		//createAQuoteBusinessLogic.registrationCustomerPolygon();
		createAQuoteBusinessLogic.dataForRegistrationNumberScreen();
		
		//createAQuoteBusinessLogic.detailsPricingPolygon();
		createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
		Thread.sleep(25000);
		//createAQuoteBusinessLogic.valueSellerApprovedStatusCheck();
		//createAQuoteBusinessLogic.acceptValueSellerScreenHeadingsCheck();
		
		createAQuoteBusinessLogic.addendumTabClicked();
		createAVSQuoteAndAcceptBusinessLogic.quoteIdFetched();
		createAVSQuoteAndAcceptBusinessLogic.searchQuotesLinkClick();
		//createAVSQuoteAndAcceptBusinessLogic.searchQuotesScreen();
		
		duplicateSBOQuote.enterQuoteId();
		duplicateSBOQuote.searchQuoteIdButtonClickedForDuplicateQuote();;
		duplicateSBOQuote.quoteIdLinkPresent();
		duplicateSBOQuote.duplicatingQuoteGoBtnClicked();
		duplicateSBOQuote.duplicateQuoteIdFetched();
		duplicateSBOQuote.duplicateQuoteIdCheck();
		duplicateSBOQuote.addCrad();		
		duplicateSBOQuote.manageCofigTabClick();
		duplicateSBOQuote.deleteOneCFRAndComponent();
		createAVSQuoteAndAcceptBusinessLogic.detailsPricingClick();
		Thread.sleep(10000);
		createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
		createAQuoteBusinessLogic.valueSellerApprovedStatusCheck();
		createAVSQuoteAndAcceptBusinessLogic.valueSellerApprovedHeadingCheck();
		
		createAQuoteBusinessLogic.addendumTabClicked();
		
		Extent_Reporting.Log_Pass("Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price Passed.","Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price Passed.",test);
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price Failed.","Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price Failed.", driver,test);
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