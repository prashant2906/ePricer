/**
 *  
 *
 */


package com.ibm.stax.Tests.RegressionIBM;

import com.ibm.stax.InitialSetup.Driver_Setup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class JP_TC31_change_bottom_line_and_approve_IBM extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	
 
	String Quoteid = "";
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({"IBMURL","ENV"})
	public void JP_TC31_change_bottom_line_and_approve_IBM_main(String IBMURL, String ENV) throws Throwable {
		try {
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic (driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			            
        	PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole",ENV);
			
			EpricerApplicationIBMQuoteEditorBusinessLogic.ClickcreateQuoteLink();
			Quoteid = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			EpricerApplicationIBMQuoteEditorBusinessLogic.overviewpageinIBM("Japan",ENV);
			EpricerApplicationIBMQuoteEditorBusinessLogic.CustomerpageinIBM();
			
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			EpricerApplicationIBMQuoteEditorBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonconfigurationpage();
			
			Thread.sleep(20000);
			
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtotabinIBM("Pricing");
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Prices");
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.changepricebuttomline();	
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Request approval");
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonrequestapprovalpage();
			
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Approval");
			EpricerApplicationIBMQuoteEditorBusinessLogic.actiononApprovaltab("Approve");
			
			
			Thread.sleep(5000);
			String quotestatus = action.getInputTextValue(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteheader-page/div[2]/div/div[2]/div[1]/div[5]/span", "Get status");
		
			if(quotestatus.equalsIgnoreCase("Ongoing quote - Approved"))
			{
				Extent_Reporting.Log_Pass("JP_TC31_change_bottom_line_and_approve_IBM Passed.",
    					"JP_TC31_change_bottom_line_and_approve_IBM Passed.", test);
			}
			else
			{
				System.out.println("the quote status should be Ongoing quote - Approved which is " + quotestatus);
				throw new Exception("Failed");
			}
			
			
            			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("JP_TC31_change_bottom_line_and_approve_IBM Failed.",
					"JP_TC31_change_bottom_line_and_approve_IBM Failed", driver, test);
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

