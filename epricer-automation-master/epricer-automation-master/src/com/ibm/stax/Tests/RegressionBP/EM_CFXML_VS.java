package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.CFXML_Buisness_Logic;
import com.ibm.stax.BusinessLogic.CFR_With_TSS_Components_Business_Logic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Approved_A_SBO_Quote_Business_Logic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class EM_CFXML_VS extends Driver_Setup{

	

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_Approved_A_SBO_Quote_Business_Logic approveASBOQuote = null;
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	Epricer_Application_Approved_A_SBO_Quote_Business_Logic approvedASBOQuote = null;
	CFXML_Buisness_Logic CFXMLTSSBL = null;
	CFR_With_TSS_Components_Business_Logic CFRWithTSSBL = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = null;

	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogicpcs = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigQuantity = null;
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({"MySAURL","ENV","IBMURL"})
	public void CFRWithTSSComponents(String MySAURL,String ENV, String IBMURL) throws Throwable {
		try {
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			CFXMLTSSBL = new CFXML_Buisness_Logic(driver, TC_ID, test);
			CFRWithTSSBL = new CFR_With_TSS_Components_Business_Logic(driver, TC_ID, test);
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID, test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(driver, TC_ID, test);
			changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID, test);
			approvedASBOQuote = new Epricer_Application_Approved_A_SBO_Quote_Business_Logic(driver, TC_ID, test);
			loginBusinessLogicpcs = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver,TC_ID,test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(driver, TC_ID, test);
			
			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();
			
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			Thread.sleep(20000);
			CFRWithTSSBL.dataForEPricerOverviewWithoutQuoteTitle();
			
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			CFXMLTSSBL.uploadCFXML();
			Thread.sleep(8000);
						createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteNotRequiringDRBusinessLogic.searchCustomerButtonClick();
			createAQuoteNotRequiringDRBusinessLogic.dataForSearchCustomerScreen();
			Thread.sleep(20000);
					
			createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
			createAQuoteBusinessLogic.acceptValueSellerScreenHeadingsCheck();

			createAQuoteBusinessLogic.addendumTabClicked();

			createAQuoteBusinessLogic.editAddendumButtonClicked();
			Thread.sleep(8000);
			createAQuoteBusinessLogic.brandCheckboxCheck();
			createAQuoteBusinessLogic.cancelAndCloseButtonClicked();

			createAQuoteBusinessLogic.sendAddendumButtonClicked();
			createAQuoteBusinessLogic.sendValueSellerAddendumScreen();
			
			Extent_Reporting.Log_Pass("EM_CFXML_VS Passed.","EM_CFXML_VS Passed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("EM_CFXML_VS Failed.","EM_CFXML_VS Failed.", driver, test);
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
