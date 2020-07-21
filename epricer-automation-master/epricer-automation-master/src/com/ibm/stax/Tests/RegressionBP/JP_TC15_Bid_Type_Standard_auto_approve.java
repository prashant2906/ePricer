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
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class JP_TC15_Bid_Type_Standard_auto_approve extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;

	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "MySAURL", "IBMURL", "ENV" })
	public void JP_TC15_Bid_Type_Standard_auto_approve_main(String MySAURL, String IBMURL, String ENV)
			throws Throwable {
		try {
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			
			loginBusinessLogic.MySALaunch(MySAURL, ENV);
			loginBusinessLogic.LaunchGroup();

			createAQuoteBusinessLogic.createANewQuoteLinkClick();

			Quoteid = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println(Quoteid);

			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			// createAQuoteBusinessLogic.dataForEPricerOverviewScreenWithoutQuoteTitle();
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			// createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.dataForRegistrationNumberScreen(ENV);
			createAQuoteBusinessLogic.detailsPricingPolygon();

			Thread.sleep(5000);

			createAQuoteBusinessLogic.checkrequestexceptioncheckbox();

			createAQuoteBusinessLogic.clicksubmitpricerequestbutton();

			createAQuoteBusinessLogic.PSATinputIBMchanelinfo();
			createAQuoteBusinessLogic.PSATSBsubmit();
			Thread.sleep(15000);

			createAQuoteBusinessLogic.PSATMyquote();
			createAQuoteBusinessLogic.PSATOpenquotefrommyquote(Quoteid);
			Thread.sleep(15000);

//			String status = action.getInputTextValue(driver,
//					".//*[@id='ibm-columns-main']/div/div[2]/div/div/quoteedit-page/div/div/div/quoteheader-page/div/div/div[1]/div[6]/span",
//					"Get status as Request pricing");
//
//			if (status.equalsIgnoreCase("Request pricing "))
//
//			{
				Extent_Reporting.Log_Pass("JP_TC15_Bid_Type_Standard_auto_approve Passed.",
						"JP_TC15_Bid_Type_Standard_auto_approve Passed.",test);
//			} else {
//				throw new Exception("Quote status is not correct, actual is " + status);
//			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("JP_TC15_Bid_Type_Standard_auto_approve Failed.",
					"JP_TC15_Bid_Type_Standard_auto_approve Failed.", driver,test);
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
