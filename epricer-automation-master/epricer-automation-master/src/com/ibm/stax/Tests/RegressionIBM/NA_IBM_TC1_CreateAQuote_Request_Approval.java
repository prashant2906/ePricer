
package com.ibm.stax.Tests.RegressionIBM;

import org.testng.annotations.AfterTest;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.NAIBM.Epricer_Application_NAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.NAIBM.Epricer_Application_NAIBM_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class NA_IBM_TC1_CreateAQuote_Request_Approval extends Driver_Setup{
	//public WebDriver driver;
	ElementAction action = new ElementAction();
	
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_NAIBM_Login_BusinessLogic nAIBMLoginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_NAIBM_CreateAQuote_BusinessLogic nAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	
	@BeforeClass
	public void setUp(){
		System.out.println("NA_IBM_TC1_CreateAQuote_Request_Approval- BeforeMethod");
		driver=getDriver();
	}
	
	@Test
	@Parameters({"IBMURL","ENV"})
	public void createAndApproveQuote(String IBMURL,String ENV) throws Throwable
	{
		
		try{
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID,test);
			nAIBMLoginBusinessLogic = new Epricer_Application_NAIBM_Login_BusinessLogic(driver, TC_ID,test);			
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			nAIBMcreateAQuoteBusinessLogic = new Epricer_Application_NAIBM_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);

			//nAIBMLoginBusinessLogic.epricerNavigatetoNAIBM(IBMURL);
			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);

			//loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();			
			
			eMEAIBMcreateAQuoteBusinessLogic.createQuoteLink();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			
			eMEAIBMcreateAQuoteBusinessLogic.ibmEMEAOverviewScreenData(ENV);
			eMEAIBMcreateAQuoteBusinessLogic.getQuoteIdandSaveInDatasheet();
			eMEAIBMcreateAQuoteBusinessLogic.searchCustomer();
			
			eMEAIBMcreateAQuoteBusinessLogic.manageConfigurationInternalPolygonScreen();
			
			nAIBMcreateAQuoteBusinessLogic.uploadInternalCFR();
			
			createAQuoteBusinessLogic.collectPricingButtonClick();
			eMEAIBMcreateAQuoteBusinessLogic.configurationSaveAndClick();
			
			nAIBMcreateAQuoteBusinessLogic.pricingScreenData();
			
			eMEAIBMcreateAQuoteBusinessLogic.requestApproval();
			
			nAIBMcreateAQuoteBusinessLogic.waitingForApprovalLabelCheck();
			
			eMEAIBMcreateAQuoteBusinessLogic.relogin();			
			loginBusinessLogic.epricerLogoScreen();
			
			nAIBMLoginBusinessLogic.ePricerLoginWithPricerRole();
			
			loginBusinessLogic.ePRICERMainScreen();
			eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("ExpiredValueQuote");
			eMEAIBMcreateAQuoteBusinessLogic.pricingPolygon();
			
			nAIBMcreateAQuoteBusinessLogic.pricingScreenUpdateData();
			nAIBMcreateAQuoteBusinessLogic.waitingForApprovalLabelCheck();
			nAIBMcreateAQuoteBusinessLogic.approvalTabData("No");
			nAIBMcreateAQuoteBusinessLogic.ongoingQuoteApprovedLabelCheck();
			
			eMEAIBMcreateAQuoteBusinessLogic.relogin();
			loginBusinessLogic.epricerLogoScreen();
			loginBusinessLogic.ePricerLoginscreen();
			loginBusinessLogic.ePRICERMainScreen();
			
			eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("ExpiredValueQuote");
			eMEAIBMcreateAQuoteBusinessLogic.pricingPolygon();
			
			nAIBMcreateAQuoteBusinessLogic.approvedQuotepricingScreenData();
			
			eMEAIBMcreateAQuoteBusinessLogic.goToReports();
			nAIBMcreateAQuoteBusinessLogic.reportsCheck();
			//nAIBMcreateAQuoteBusinessLogic.tailoredReportDataCheck();
			
			Extent_Reporting.Log_Pass("NA_IBM_TC1_CreateAQuote_Request_Approval Passed.","NA_IBM_TC1_CreateAQuote_Request_Approval Passed.", test);
		}
		 catch (Exception e) {
				Extent_Reporting.Log_Fail(
						"NA_IBM_TC1_CreateAQuote_Request_Approval Failed.","NA_IBM_TC1_CreateAQuote_Request_Approval Failed.", driver,test);
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
