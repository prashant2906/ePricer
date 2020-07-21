/**
 * @author Neha Upadhyay
 *
 */

package com.ibm.stax.Tests.RegressionIBM;

import org.junit.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.NAIBM.Epricer_Application_NAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class EMEA_Internal_TC1_CreateAndApproveQuote extends Driver_Setup{
	//public WebDriver driver;
	ElementAction action = new ElementAction();
	
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_NAIBM_CreateAQuote_BusinessLogic nAIBMcreateAQuoteBusinessLogic = null;
	
	@BeforeClass
	public void setUp(){
		System.out.println("inside class : EMEA_Internal_TC1_CreateAndApproveQuote- BeforeMethod");
		driver=getDriver();
	}
	
	@Test
	@Parameters({"IBMURL","ENV","Timestamp"})
	public void createAndApproveQuote(String IBMURL,String ENV, String Timestamp) throws Throwable
	{
		
		try{
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			nAIBMcreateAQuoteBusinessLogic = new Epricer_Application_NAIBM_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			
			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();			
			
			eMEAIBMcreateAQuoteBusinessLogic.createQuoteLink();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			
			eMEAIBMcreateAQuoteBusinessLogic.ibmEMEAOverviewScreenData(ENV);
			eMEAIBMcreateAQuoteBusinessLogic.searchCustomer();
			
			//eMEAIBMcreateAQuoteBusinessLogic.manageConfigurationInternalPolygonScreen();
			Thread.sleep(10000);
			eMEAIBMcreateAQuoteBusinessLogic.uploadInternalCFR();
			
			createAQuoteBusinessLogic.collectPricingButtonClick();
			eMEAIBMcreateAQuoteBusinessLogic.configurationSaveAndClick();
			eMEAIBMcreateAQuoteBusinessLogic.getQuoteIdandSaveInDatasheet();
			Thread.sleep(10000);
			eMEAIBMcreateAQuoteBusinessLogic.pricingScreenData();
			eMEAIBMcreateAQuoteBusinessLogic.requestApproval();
			//nAIBMcreateAQuoteBusinessLogic.waitingForApprovalLabelCheck();
			
			eMEAIBMcreateAQuoteBusinessLogic.relogin();			
			loginBusinessLogic.epricerLogoScreen();			
			loginBusinessLogic.ePricerLoginWithDistributorProfile();
			loginBusinessLogic.ePRICERMainScreen();
			
			eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("ExpiredValueQuote");
			eMEAIBMcreateAQuoteBusinessLogic.pricingPolygon();
			eMEAIBMcreateAQuoteBusinessLogic.pricingScreenUpdateData();
			
			eMEAIBMcreateAQuoteBusinessLogic.relogin();
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();
			eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("ExpiredValueQuote");
			eMEAIBMcreateAQuoteBusinessLogic.pricingPolygon();
			eMEAIBMcreateAQuoteBusinessLogic.goToReports();
			
			nAIBMcreateAQuoteBusinessLogic.reportsCheck();
			//createAQuoteBusinessLogicPcs.createFinalReport(1,ENV,Timestamp,"Pass",2);
		}
		 catch (Exception e) {
				Extent_Reporting.Log_Fail("EMEA_Internal_TC1_CreateAndApproveQuote Failed.","EMEA_Internal_TC1_CreateAndApproveQuote Failed.", driver, test);
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
