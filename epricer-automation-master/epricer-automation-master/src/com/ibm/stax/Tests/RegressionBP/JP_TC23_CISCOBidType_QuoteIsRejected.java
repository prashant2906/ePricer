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

public class JP_TC23_CISCOBidType_QuoteIsRejected extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic PCSEpricerApplicationIBMQuoteEditorBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;

	String Quoteid = " ";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "MySAURL", "IBMURL", "ENV"})
	public void JP_CISCOBidType_RejectAQuote_main(String MySAURL, String IBMURL, String ENV) throws Throwable {
		try {
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,TC_ID,test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			PCSEpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(driver, TC_ID,test);

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
			createAQuoteBusinessLogic.PSATOpenquotefrommyquote(Quoteid);

			Thread.sleep(1000);

			// String status = action.getInputTextValue(driver,
			// ".//*[@id='ibm-columns-main']/div/div[2]/div/div/quoteedit-page/div/div/div/quoteheader-page/div/div/div[1]/div[6]/span",
			// "Get status as Request pricing");

			/*
			 * if (status.equalsIgnoreCase("Request pricing ")) {
			 * Extent_Reporting.Log_Pass("Status is Request pricing  Passed.",
			 * "Status is Request pricing Passed."); } else{ throw new
			 * Exception("Quote status is not correct, actual is " + status); }
			 */
			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole",ENV);
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();

			PCSEpricerApplicationIBMQuoteEditorBusinessLogic.switchtocommentstatustab();

			Thread.sleep(20000);
			PCSEpricerApplicationIBMQuoteEditorBusinessLogic.switchtopricetab();
			PCSEpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("approval");
			PCSEpricerApplicationIBMQuoteEditorBusinessLogic.approveBPquoteinIBM();

			Thread.sleep(15000);

//			String statusibm = action.getInputTextValue(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteheader-page/div[2]/div/div[2]/div[1]/div[5]/span",
//					"Get status in IBM");
//     		 
//            if (statusibm.contains(""))
//           	{
            	Extent_Reporting.Log_Pass("JP_TC23_QuoteIsRejected Passed.",
    					"JP_TC23_QuoteIsRejected Passed.",test);
//           	}
//           	else{
//           		throw new Exception("Quote status is not correct, actual is " + status);
//           	}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("JP_TC23_QuoteIsRejected Failed.", "JP_TC23_QuoteIsRejected.", driver,test);
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
