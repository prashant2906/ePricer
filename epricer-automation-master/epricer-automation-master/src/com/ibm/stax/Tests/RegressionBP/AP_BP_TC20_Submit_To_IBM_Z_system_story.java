
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

public class AP_BP_TC20_Submit_To_IBM_Z_system_story extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;

	Epricer_Application_IBM_QuoteEditor_BusinessLogic PCSEpricerApplicationIBMQuoteEditorBusinessLogic = null;

	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({"MySAURL", "IBMURL", "ENV"})
	public void AP_TC20_Submit_To_IBM_Z_system_story_main(String MySAURL, String IBMURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID,test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID,test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			PCSEpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(
					driver, TC_ID,test);

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
			Thread.sleep(5000);
			createAQuoteBusinessLogic.PSATinputIBMchanelinfo();
			createAQuoteBusinessLogic.PSATSBsubmit();
			Thread.sleep(15000);

			createAQuoteBusinessLogic.PSATMyquote();
			createAQuoteBusinessLogic.PSATOpenquotefrommyquote(Quoteid);

			Thread.sleep(15000);
//
//			String status = action.getInputTextValue(driver,
//					".//*[@id='ibm-columns-main']/div/div[2]/div/div/quoteedit-page/div/div/div/quoteheader-page/div/div/div[1]/div[6]/span",
//					"Get status as Request pricing");
//
//			if (status.equalsIgnoreCase("Request pricing ")) {
//				Extent_Reporting.Log_Pass("JP_TC20_Submit_To_IBM_Z_system_story Passed.",
//						"JP_TC20_Submit_To_IBM_Z_system_story Passed.");
//			} else {
//				throw new Exception("Quote status is not correct, actual is " + status);
//			}

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
			Extent_Reporting.Log_Pass("AP_BP_TC20_Submit_To_IBM_Z_system_story Passed.",
					"AP_BP_TC20_Submit_To_IBM_Z_system_story Passed.",test);

//			String statusibm = action.getInputTextValue(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteheader-page/div[2]/div/div[2]/div[1]/div[5]/span",
//					"Get status in IBM");
//     		 
//            if (statusibm.contains("IBM approved"))
//           	{
//            	Extent_Reporting.Log_Pass("JP_TC20_Submit_To_IBM_Z_system_story Passed.",
//    					"JP_TC20_Submit_To_IBM_Z_system_story Passed.");
//           	}
//           	else{
//           		throw new Exception("Quote status is not correct, actual is " + statusibm);
//           	}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("AP_BP_TC20_Submit_To_IBM_Z_system_story Failed.",
					"AP_BP_TC20_Submit_To_IBM_Z_system_story.", driver,test);
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
