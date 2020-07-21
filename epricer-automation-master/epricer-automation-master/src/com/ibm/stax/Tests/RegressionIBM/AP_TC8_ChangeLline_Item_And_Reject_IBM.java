package com.ibm.stax.Tests.RegressionIBM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class AP_TC8_ChangeLline_Item_And_Reject_IBM extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	
 
	String Quoteid = "";
	@BeforeClass
	public void setUp() {
		System.out.println("AP_TC8_ChangeLline_Item_And_Reject_IBM - BeforeMethod");
		driver = getDriver();
	}

	@Test
	@Parameters({"IBMURL","ENV"})
	public void AP_TC8_ChangeLline_Item_And_RejectIBM(String IBMURL, String ENV) throws Throwable {
		try {
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic (driver, TC_ID,test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			            
        	PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole",ENV);
			
			EpricerApplicationIBMQuoteEditorBusinessLogic.ClickcreateQuoteLink();
			Quoteid = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			EpricerApplicationIBMQuoteEditorBusinessLogic.overviewpageinIBM("Australia",ENV);
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
			EpricerApplicationIBMQuoteEditorBusinessLogic.changepricelineitem();	
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Request approval");
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonrequestapprovalpage();
			
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Approval");
			EpricerApplicationIBMQuoteEditorBusinessLogic.actiononApprovaltab("reject");
			
			
			Thread.sleep(5000);
			String quotestatus = action.getInputTextValue(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteheader-page/div[2]/div/div[2]/div[1]/div[5]/span", "Get status");
		
			if(quotestatus.equalsIgnoreCase("Ongoing quote - Rejected"))
			{
				Extent_Reporting.Log_Pass("AP_TC8_ChangeLline_Item_And_Reject_IBM Passed.",
    					"AP_TC8_ChangeLline_Item_And_Reject_IBM Passed.",test);
			}
			else
			{
				System.out.println("the quote status should be Ongoing quote - Rejected which is " + quotestatus);
				throw new Exception("Failed");
			}
			
			
            			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("AP_TC8_ChangeLline_Item_And_Reject_IBM Failed.",
					"AP_TC8_ChangeLline_Item_And_Reject_IBM Failed", driver,test);
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

