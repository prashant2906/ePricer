      package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_Approved_A_SBO_Quote_Business_Logic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Approved_A_SBO_Quote extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_Approved_A_SBO_Quote_Business_Logic approveASBOQuote = null;
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogicpcs = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;

	@BeforeClass
	public void setUp() {
		System.out.println("inside class : TC16_Approved_A_SBO_Quote- BeforeMethod");
		driver = getDriver();
	}

	@Test
	@Parameters({"MySAURL","ENV","IBMURL"})
	public void ApprovedASBO_Quote(String MySAURL,String ENV, String IBMURL) throws Throwable {
		try {
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID, test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(driver, TC_ID, test);
			updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID, test);
			approveASBOQuote = new Epricer_Application_Approved_A_SBO_Quote_Business_Logic(driver, TC_ID, test);
			ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver, TC_ID, test);
			eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			loginBusinessLogicpcs = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			
			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			
			//loginBusinessLogic.ibmIDPageData();
			//loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			//loginBusinessLogic.ePRICERMainScreen();
			
			
			updateAQuoteBusinessLogic.searchQuotesLinkClick();
			updateAQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			approveASBOQuote.dataForSearchQuote();

			ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.quoteIdLinkPresent();
			ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.duplicatingQuoteGoBtnClicked();
			approveASBOQuote.submitTheduplicatedQuote();
			ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.duplicateQuoteIdFetched();
			ePricerDuplicateSBOQuoteAcceptAsVSBusinessLogic.duplicateQuoteIdCheck();
			
			approveASBOQuote.submitTheduplicatedQuote();		
			
			loginBusinessLogicpcs.authenticatePopUpHandle(IBMURL, ENV);
			//Thread.sleep(8000);
			if (ENV.equalsIgnoreCase("PROD")) {
				loginBusinessLogicpcs.ePricerLoginscreen("SelectAIBMPRODRole", ENV);
			} else {
				loginBusinessLogicpcs.ePricerLoginscreen("SelectIBMRole", ENV);
			}			
			eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("EnterQuoteid");
			approveASBOQuote.openIBMGUI();
			approveASBOQuote.searchQuote();

			Extent_Reporting.Log_Pass("Approved_A_SBO_Quote Passed.",
					"Approved_A_SBO_Quote Passed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Approved_A_SBO_Quote Failed.",
					"Approved_A_SBO_Quote Failed.", driver, test);
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
