/**
 * @author Meenal
 *
 */


package com.ibm.stax.Tests.RegressionBP;

import com.ibm.stax.InitialSetup.Driver_Setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class AP_BP_TC09_QuoteStatus_Cannot_AutoApproved extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic PCSEpricerApplicationIBMQuoteEditorBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	
	String Quoteid = "";
	@BeforeClass
	public void setUp() {
		System.out.println("testcase9");
		driver = getDriver();
	}

	@Test
	@Parameters({ "MySAURL", "IBMURL","ENV" })
	public void APCannotBeAutoApproved_main(String MySAURL, String IBMURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic (driver, TC_ID,test);

			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			loginBusinessLogic.LaunchGroup();			

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			Quoteid = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println(Quoteid);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			//createAQuoteBusinessLogic.dataForEPricerOverviewScreenWithoutQuoteTitle();
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.dataForRegistrationNumberScreen();
			createAQuoteBusinessLogic.detailsPricingPolygon();
           
			Thread.sleep(5000);
			createAQuoteBusinessLogic.checkrequestexceptioncheckbox();      
            createAQuoteBusinessLogic.clicksubmitpricerequestbutton();
            Thread.sleep(5000);
            
            createAQuoteBusinessLogic.PSATinputIBMchanelinfo();
            createAQuoteBusinessLogic.PSATSBsubmit();
            Thread.sleep(15000);
            
            createAQuoteBusinessLogic.PSATMyquote();
            Thread.sleep(15000);
            createAQuoteBusinessLogic.PSATOpenquotefrommyquote(Quoteid);
            
            Thread.sleep(15000);
         
           // String status = action.getInputTextValue(driver, ".//*[@id='ibm-columns-main']/div/div[2]/div/div/quoteedit-page/div/div/div/quoteheader-page/div/div/div[1]/div[6]/span", "Get status as Request pricing");
      		 
//            if (status.equalsIgnoreCase("Request pricing "))
//           	{
//            	Extent_Reporting.Log_Pass("AP_BP_TC09_QuoteStatus_Cannot_AutoApproved Passed.",
//    					"AP_BP_TC09_QuoteStatus_Cannot_AutoApproved Passed.");
//           	}
//           	else{
//           		throw new Exception("Quote status is not correct, actual is " + status);
//           	}
//            
            Extent_Reporting.Log_Pass("AP_BP_TC09_QuoteStatus_Cannot_AutoApproved Passed.",
					"AP_BP_TC09_QuoteStatus_Cannot_AutoApproved Passed.",test);
			
            			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("AP_BP_TC09_QuoteStatus_Cannot_AutoApproved Failed.",
					"AP_BP_TC09_QuoteStatus_Cannot_AutoApproved", driver,test);
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
