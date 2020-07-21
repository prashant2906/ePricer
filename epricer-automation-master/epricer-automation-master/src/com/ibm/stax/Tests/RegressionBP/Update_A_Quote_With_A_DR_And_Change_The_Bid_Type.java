
package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class Update_A_Quote_With_A_DR_And_Change_The_Bid_Type extends Driver_Setup{


	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic= null;
	
	@BeforeClass
	public void setUp() {
		System.out.println("inside class : Update_A_Quote_With_A_DR_And_Change_The_Bid_Type- BeforeMethod");
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	
	@Test
	@Parameters({"MySAURL","ENV"})
	public void UpdateAQuoteWithADRAndChangeTheBidType(String MySAURL,String ENV) throws Throwable {
		try{
			
		loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver,TC_ID,test);
		createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
		updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID,test);
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID,test);
		
		loginBusinessLogic.MySALaunch(MySAURL,ENV);
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
		
		ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteIdFetched();
		
		updateAQuoteBusinessLogic.searchQuotesLinkClick();
		//updateAQuoteBusinessLogic.searchQuotesScreen();
		updateAQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
		updateAQuoteBusinessLogic.enterQuoteId();
		updateAQuoteBusinessLogic.searchQuoteButtonClicked();
		//updateAQuoteBusinessLogic.searchedQuotePresent();
		Thread.sleep(10000);
		updateAQuoteBusinessLogic.overviewPolygonClick();
		updateAQuoteBusinessLogic.selectBidTypeUpdate();
		updateAQuoteBusinessLogic.dataForEPricerOverviewScreenUpdated();
		
		//createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
		
		updateAQuoteBusinessLogic.uploadCFR();
		//updateAQuoteBusinessLogic.downloadThisCFRIcon();
		
		createAQuoteBusinessLogic.collectPricingButtonClick();
		createAQuoteBusinessLogic.pricingValueCheck();
		
		//createAQuoteBusinessLogic.registrationCustomerPolygon();
		createAQuoteBusinessLogic.dataForRegistrationNumberScreen();
		
		//createAQuoteBusinessLogic.detailsPricingPolygon();
		createAQuoteBusinessLogic.previewValueSellerOfferButtonClicked();
		//createAQuoteBusinessLogic.iBMBusinessPartnerValueSellerScreen();
		createAQuoteBusinessLogic.closeIBMBusinessPartnerValueSellerScreenBtnClicked();
		//createAQuoteBusinessLogic.detailsPricingPolygon();
		
		//createAQuoteBusinessLogic.listPriceTotalValueCheck();
		createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
		//createAQuoteBusinessLogic.valueSellerApprovedStatusCheck();
		createAQuoteBusinessLogic.acceptValueSellerScreenHeadingsCheck();
		
		createAQuoteBusinessLogic.addendumTabClicked();
		//createAQuoteBusinessLogic.brandTabCheck();
		
		createAQuoteBusinessLogic.editAddendumButtonClicked();
		action.waitForPageToLoad(driver);
		createAQuoteBusinessLogic.brandCheckboxCheck();
		createAQuoteBusinessLogic.cancelAndCloseButtonClicked();
		
		createAQuoteBusinessLogic.sendAddendumButtonClicked();
		createAQuoteBusinessLogic.sendValueSellerAddendumScreen();
		createAQuoteBusinessLogic.sendMailButtonClicked();
		
		Extent_Reporting.Log_Pass("Update_A_Quote_With_A_DR_And_Change_The_Bid_Type Passed.",
				"Update_A_Quote_With_A_DR_And_Change_The_Bid_Type Passed.",test);
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Update_A_Quote_With_A_DR_And_Change_The_Bid_Type Failed.",
					"Update_A_Quote_With_A_DR_And_Change_The_Bid_Type Failed.", driver,test);
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
