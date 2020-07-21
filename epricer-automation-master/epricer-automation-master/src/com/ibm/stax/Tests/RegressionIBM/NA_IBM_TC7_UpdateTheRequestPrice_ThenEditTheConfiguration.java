
package com.ibm.stax.Tests.RegressionIBM;

import org.testng.annotations.AfterTest;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_AddServListMainPreAfterQuotingHWSW_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.NAIBM.Epricer_Application_NAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class NA_IBM_TC7_UpdateTheRequestPrice_ThenEditTheConfiguration extends Driver_Setup{
	//public WebDriver driver;
	ElementAction action = new ElementAction();
	
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_EMEAIBM_AddServListMainPreAfterQuotingHWSW_BusinessLogic addServListMainPreAfterQuotingHWSW = null;
	Epricer_Application_NAIBM_CreateAQuote_BusinessLogic nAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;

	@BeforeClass
	public void setUp(){
		System.out.println("NA_IBM_TC7_UpdateTheRequestPrice_ThenEditTheConfiguration - BeforeMethod");
		driver=getDriver();
	}
	
	@Test
	@Parameters({"IBMURL","ENV"})
	public void createAndApproveQuote(String IBMURL,String ENV) throws Throwable
	{
		
		try{
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID,test);
			eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			addServListMainPreAfterQuotingHWSW = new Epricer_Application_EMEAIBM_AddServListMainPreAfterQuotingHWSW_BusinessLogic(driver, TC_ID,test);			
			nAIBMcreateAQuoteBusinessLogic = new Epricer_Application_NAIBM_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			
			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);

			//nAIBMLoginBusinessLogic.epricerNavigatetoNAIBM(IBMURL);
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();
			
			eMEAIBMcreateAQuoteBusinessLogic.createQuoteLink();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			eMEAIBMcreateAQuoteBusinessLogic.ibmEMEAOverviewScreenData(ENV);
			eMEAIBMcreateAQuoteBusinessLogic.searchCustomer();
			eMEAIBMcreateAQuoteBusinessLogic.manageConfigurationInternalPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			addServListMainPreAfterQuotingHWSW.dataForEPricerMultipleAddProductManually();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			eMEAIBMcreateAQuoteBusinessLogic.configurationSaveAndClick();
			eMEAIBMcreateAQuoteBusinessLogic.getQuoteIdandSaveInDatasheet();
			
			nAIBMcreateAQuoteBusinessLogic.pricingScreenData();
			nAIBMcreateAQuoteBusinessLogic.approvedPriceValue();
			
			eMEAIBMcreateAQuoteBusinessLogic.MoveToConfigurationTab();
			eMEAIBMcreateAQuoteBusinessLogic.uploadInternalCFR();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			eMEAIBMcreateAQuoteBusinessLogic.moveToPricingPolygon();
			
			eMEAIBMcreateAQuoteBusinessLogic.applyApprovedPrice();
			nAIBMcreateAQuoteBusinessLogic.approvedPriceValueCheck();
			eMEAIBMcreateAQuoteBusinessLogic.switchToTotalView();
			
			Extent_Reporting.Log_Pass("NA_IBM_TC7_UpdateTheRequestPrice_ThenEditTheConfiguration Passed.","NA_IBM_TC7_UpdateTheRequestPrice_ThenEditTheConfiguration Passed.",test);
		}
		 catch (Exception e) {
				Extent_Reporting.Log_Fail("NA_IBM_TC7_UpdateTheRequestPrice_ThenEditTheConfiguration Failed.","NA_IBM_TC7_UpdateTheRequestPrice_ThenEditTheConfiguration Failed.", driver,test);
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
