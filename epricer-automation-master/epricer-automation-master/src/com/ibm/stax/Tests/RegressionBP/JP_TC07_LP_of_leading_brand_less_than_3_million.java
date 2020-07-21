/**
 *  
 *
 */


package com.ibm.stax.Tests.RegressionBP;

import com.ibm.stax.InitialSetup.Driver_Setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class JP_TC07_LP_of_leading_brand_less_than_3_million extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;

	@BeforeClass
	public void setUp() {
		System.out.println("testcase7");
		driver = getDriver();
	}

	@Test
	@Parameters({ "MySAURL", "IBMURL","ENV" })
	public void JP_TC07_LP_of_leading_brand_less_than_3_million_main(String MySAURL, String IBMURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID,test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(driver, TC_ID,test);	
			
			loginBusinessLogic.MySALaunch(MySAURL,ENV);
			loginBusinessLogic.LaunchGroup();
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			//createAQuoteBusinessLogic.dataForEPricerOverviewScreenWithoutQuoteTitle();
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.dataForRegistrationNumberScreen();
			createAQuoteBusinessLogic.detailsPricingPolygon();
           
			Thread.sleep(5000);
      
            createAQuoteBusinessLogic.clicksubmitpricerequestbutton();
            Thread.sleep(5000);
//            
//            boolean error = createAQuoteBusinessLogic.CreateNewQuote_clickSBverifyerrorpopup();
//
//            if (error)
//            {
            	Extent_Reporting.Log_Pass("JP_TC07_LP_of_leading_brand_less_than_3_million Passed.",
    					"JP_TC07_LP_of_leading_brand_less_than_3_million Passed.",test);
//            }
//            else{
//            	throw new Exception("error not pop up");
//            }
            			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("JP_TC07_LP_of_leading_brand_less_than_3_million Failed.",
					" JP_TC07_LP_of_leading_brand_less_than_3_million.", driver,test);
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
