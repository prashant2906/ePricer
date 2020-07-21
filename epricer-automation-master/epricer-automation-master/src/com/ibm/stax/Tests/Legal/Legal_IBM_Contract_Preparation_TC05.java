/**
 *  
 *
 */


package com.ibm.stax.Tests.Legal;

import com.ibm.stax.InitialSetup.Driver_Setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;



public class Legal_IBM_Contract_Preparation_TC05 extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	
 
	String Quoteid = "";
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "IBMURL","ENV" })
	public void Legal_IBM_Contract_Preparation_TC05_main(String IBMURL, String ENV) throws Throwable {
		try {
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic (driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver, TC_ID, test);
			          
        PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole", ENV);
			
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteria();
			
			Thread.sleep(2000);
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuotestatussubcriteria("Contract preparation");
			EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();		
			
			EpricerApplicationSearchQuoteBusinessLogic.checkonthefirstresult();
			Thread.sleep(5000);
			
			boolean checkresult = EpricerApplicationSearchQuoteBusinessLogic.Checkdropdownlistinibmsearch("Delete", false);
			System.out.println("check result for user 1 is " + checkresult);

			if (checkresult) {

				Extent_Reporting.Log_Pass("Legal_IBM_Contract_Preparation_TC05 Passed.", "Legal_IBM_Contract_Preparation_TC05 Passed.", test);
			} else {
				throw new Exception("Failed");

			}			
            			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_IBM_Contract_Preparation_TC05 Failed.",
					"Legal_IBM_Contract_Preparation_TC05 Failed", driver, test);
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

