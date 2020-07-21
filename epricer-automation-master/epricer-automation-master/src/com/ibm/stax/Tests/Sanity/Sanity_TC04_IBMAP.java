/**
 * @author Neha
 *
 */


package com.ibm.stax.Tests.Sanity;

import com.ibm.stax.InitialSetup.Driver_Setup;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;


public class Sanity_TC04_IBMAP extends Driver_Setup {

	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogicPcs = null;
	
	@Test
	@Parameters({"IBMURL","ENV", "Timestamp"})
	public void Sanity_TC04_IBMAP_main(String IBMURL, String ENV,String Timestamp) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogicPcs = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID, test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic (driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver, TC_ID, test);
			
            
        	//PCSloginBusinessLogic.epricerNavigatetoIBM(IBMURL);
        	PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
        	if (ENV.equalsIgnoreCase("PROD")|| ENV.equalsIgnoreCase("IVT")) {
				PCSloginBusinessLogic.ePricerLoginscreen("SelectProdRole", ENV);
			} else {
				PCSloginBusinessLogic.ePricerLoginscreen();
			}
			
			Thread.sleep(4000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.ClickcreateQuoteLink();
			Quoteid = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			EpricerApplicationIBMQuoteEditorBusinessLogic.overviewpageinIBM("China", ENV);
			EpricerApplicationIBMQuoteEditorBusinessLogic.CustomerpageinIBM();
			
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			EpricerApplicationIBMQuoteEditorBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			Thread.sleep(4000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonconfigurationpage();
			
			Thread.sleep(10000);
			
		//	EpricerApplicationIBMQuoteEditorBusinessLogic.switchtotabinIBM("Pricing");
			Thread.sleep(9000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Prices");
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.changepricebuttomline();	
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Request approval");
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonrequestapprovalpage();
			
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Approval");
			EpricerApplicationIBMQuoteEditorBusinessLogic.actiononApprovaltab("Approve");
			
			
			//Thread.sleep(5000);
			String quotestatus = action.getInputTextValue(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteheader-page/div[2]/div/div[2]/div[1]/div[5]/span", "Get status");
		
			if(quotestatus.equalsIgnoreCase("Ongoing quote - Approved"))
			{
				Extent_Reporting.Log_Pass("Sanity_TC04_IBMAP Passed.",
    					"Sanity_TC04_IBMAP Passed.", test);
			}
			else
			{
				System.out.println("the quote status should be Ongoing quote - Approved which is " + quotestatus);
				throw new Exception("Failed");
			}	
			if (ENV.equalsIgnoreCase("PROD")) {
				createAQuoteBusinessLogicPcs.createFinalReport(4,ENV,Timestamp,"Pass",0);			
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Sanity_TC04_IBMAP Failed.","Sanity_TC04_IBMAP Failed", driver, test);
			if (ENV.equalsIgnoreCase("PROD")) {
				createAQuoteBusinessLogicPcs.createFinalReport(4,ENV,Timestamp,"Fail",0);
			}
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

