package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_Approved_A_SBO_Quote_Business_Logic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Reviewer_Workflow extends Driver_Setup{


	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Approved_A_SBO_Quote_Business_Logic approveSBOQuote = null;
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogicpcs = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic duplicateSBOBL = null;
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable
	 */
	
	@Test
	@Parameters({"ENV","IBMURL"})
	public void ReviewerWorkflow(String ENV, String IBMURL) throws Throwable {
		try{
			approveSBOQuote = new Epricer_Application_Approved_A_SBO_Quote_Business_Logic(driver, TC_ID,test);
			loginBusinessLogicpcs = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver,TC_ID,test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(driver, TC_ID, test);
			duplicateSBOBL = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(driver,TC_ID,test);
			loginBusinessLogicpcs.authenticatePopUpHandle(IBMURL, ENV);
			//Thread.sleep(8000);
			if (ENV.equalsIgnoreCase("PROD")) {
				loginBusinessLogicpcs.ePricerLoginscreen("SelectAIBMPRODRole", ENV);
			} else {
				loginBusinessLogicpcs.ePricerLoginscreen("SelectIBMRole", ENV);
			}			
			eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("EnterQuoteid");
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtocommentstatustab();
			duplicateSBOBL.removeFromHoldRadioBtnClick();
			approveSBOQuote.IBMGUIReviewerWorkflow();
			
		//	approveSBOQuote.IBMGUILoginFromReviewerID();
		//	approveSBOQuote.IBMGUILoginFromInitiatorID();
		
		Extent_Reporting.Log_Pass("Reviewer_Workflow Passed.",
				"Reviewer_Workflow Passed.",test);
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Reviewer_Workflow Failed.",
					"Reviewer_Workflow Failed.", driver,test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Reviewer_Workflow Failed.");
		}
	}
	
	@AfterTest
	  public void tearDown() {
		  driver.quit();
	  } 
}
