/**
 * @author Neha Upadhyay
 *
 */
package com.ibm.stax.Tests.RegressionIBM;

import org.testng.annotations.AfterTest;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class EMEA_Internal_TC3_QuoteWithNewCustomerToIBM extends Driver_Setup{
	//public WebDriver driver;
	ElementAction action = new ElementAction();
	
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogicPcs = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;	
	Epricer_Application_EMEAIBM_Login_BusinessLogic eMEAIBMLoginBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	
	@BeforeClass
	public void setUp(){
		System.out.println("inside class : EMEA_Internal_TC3_QuoteWithNewCustomerToIBM- BeforeMethod");
		driver=getDriver();
	}
	
	@Test
	@Parameters({"IBMURL","ENV","Timestamp"})
	public void QuoteWithNewCustomerToIBM(String IBMURL,String ENV, String Timestamp) throws Throwable
	{
		
		try{
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);			
			eMEAIBMLoginBusinessLogic = new Epricer_Application_EMEAIBM_Login_BusinessLogic(driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			
			//eMEAIBMLoginBusinessLogic.epricerNavigatetoEMEAIBM(IBMURL);
			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();			
			
			eMEAIBMcreateAQuoteBusinessLogic.createQuoteLink();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			eMEAIBMcreateAQuoteBusinessLogic.ibmEMEAOverviewScreenData(ENV);
			eMEAIBMcreateAQuoteBusinessLogic.selectCreateNewCustomer();
			eMEAIBMcreateAQuoteBusinessLogic.manageConfigurationInternalPolygonScreen();
			eMEAIBMcreateAQuoteBusinessLogic.uploadMultipleInternalCFR();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			eMEAIBMcreateAQuoteBusinessLogic.dataForEPricerAddProductManually();
			createAQuoteBusinessLogic.collectPricingButtonClick();			
			eMEAIBMcreateAQuoteBusinessLogic.configurationSaveAndClick();
			eMEAIBMcreateAQuoteBusinessLogic.getQuoteIdandSaveInDatasheet();
			eMEAIBMcreateAQuoteBusinessLogic.attachDocs();
			
			eMEAIBMcreateAQuoteBusinessLogic.relogin();
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();
			
			eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuoteToDuplicate();			
			eMEAIBMcreateAQuoteBusinessLogic.duplicatQuoteWithNoAttachment();
			 
			eMEAIBMcreateAQuoteBusinessLogic.relogin();
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();
			
			eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuoteToDuplicate();
			eMEAIBMcreateAQuoteBusinessLogic.duplicatQuoteWithAttachment();
			
			eMEAIBMcreateAQuoteBusinessLogic.MoveToConfigurationTab();			
			eMEAIBMcreateAQuoteBusinessLogic.changeQuantityOfManualCOmponent();
			eMEAIBMcreateAQuoteBusinessLogic.deleteCFR();

			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			eMEAIBMcreateAQuoteBusinessLogic.dataForEPricerAddProductManually();
			eMEAIBMcreateAQuoteBusinessLogic.uploadCFRSecondTime();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			eMEAIBMcreateAQuoteBusinessLogic.moveToPricingPolygon();
			eMEAIBMcreateAQuoteBusinessLogic.applyApprovedPrice();
			Extent_Reporting.Log_Pass("EMEA_Internal_TC3_QuoteWithNewCustomerToIBM Passed.",
					"EMEA_Internal_TC3_QuoteWithNewCustomerToIBM Passed.", test);
			//createAQuoteBusinessLogicPcs.createFinalReport(2,ENV,Timestamp,"Pass",2);
		}
		 catch (Exception e) {
				Extent_Reporting.Log_Fail(
						"EMEA_Internal_TC3_QuoteWithNewCustomerToIBM Failed.",
						"EMEA_Internal_TC3_QuoteWithNewCustomerToIBM Failed.", driver, test);
				//createAQuoteBusinessLogicPcs.createFinalReport(2,ENV,Timestamp,"Fail",2);
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