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

public class AP_TC6_Do_Not_Need_Approve_As_Pricer_IBM extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	
 
	String Quoteid = "";
	@BeforeClass
	public void setUp() {
		System.out.println("inside class : AP_TC6_Do_Not_Need_Approve_As_Pricer_IBM- BeforeMethod");
		driver = getDriver();
	}

	@Test
	@Parameters({"IBMURL","ENV"})
	public void AP_TC6_Do_Not_Need_Approve_As_PricerIBM(String IBMURL, String ENV) throws Throwable {
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
			
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtotabinIBM("Administration");
			
			EpricerApplicationIBMQuoteEditorBusinessLogic.SignquoteinIBM();
			
			Thread.sleep(20000);
			String quotestatus = action.getInputTextValue(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteheader-page/div[2]/div/div[2]/div[1]/div[5]/span", "Get status");
		
			if(quotestatus.equalsIgnoreCase("Contract preparation"))
			{
				Extent_Reporting.Log_Pass("AP_TC6_Do_Not_Need_Approve_As_Pricer_IBM Passed.",
    					"AP_TC6_Do_Not_Need_Approve_As_Pricer_IBM Passed.",test);
			}
			else
			{
				System.out.println("the quote status should be contranct preparation which is " + quotestatus);
				throw new Exception("Failed");
			}            			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("AP_TC6_Do_Not_Need_Approve_As_Pricer_IBM Failed.",
					"AP_TC6_Do_Not_Need_Approve_As_Pricer_IBM", driver,test);
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

