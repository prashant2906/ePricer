package com.ibm.stax.Tests.Sanity;

import com.ibm.stax.InitialSetup.Driver_Setup;

import static org.testng.Assert.fail;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;

/**
 * @author Neha
 *
 */
public class Sanity_TC10_BPJP_SB extends Driver_Setup {
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic loginPCSBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;

	@Test
	@Parameters({ "MySAURL", "IBMURL", "ENV", "Timestamp"})
	public void Sanity_TC10_BPJP_SB_main(String MySAURL, String IBMURL, String ENV, String Timestamp) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID, test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(
					driver, TC_ID, test);
			loginPCSBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			
			if (ENV.equalsIgnoreCase("PROD")|| ENV.equalsIgnoreCase("IVT")) {
				loginBusinessLogic.MySAPRODLaunch(MySAURL, ENV);
				loginBusinessLogic.LaunchProdGroup("SelectProdRole");
			} else {
				loginBusinessLogic.MySALaunch(MySAURL, ENV);
				Thread.sleep(10000);
				loginBusinessLogic.LaunchGroup();
				}
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			Quoteid = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("BP JP SB Quote: " + Quoteid);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("Japan", "CISCO", ENV);
			
			createAQuoteBusinessLogic.moveToManageConfig();
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			// createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.CustomerpageinPSAT();
		//	createAQuoteBusinessLogic.dataForRegistrationNumberScreen(ENV);
			
			createAQuoteBusinessLogic.detailsPricingPolygon();
			Thread.sleep(9000);
			createAQuoteBusinessLogic.checkrequestexceptioncheckbox();
			Thread.sleep(5000);
			createAQuoteBusinessLogic.clicksubmitpricerequestbutton();
			Thread.sleep(15000);
			createAQuoteBusinessLogic.PSATinputIBMchanelinfo("JP");
			Thread.sleep(15000);
			createAQuoteBusinessLogic.PSATSBsubmit();
			Thread.sleep(15000);

			// open ibm and incomplete the submitted sb quote

			loginPCSBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			Thread.sleep(10000);
			if (ENV.equalsIgnoreCase("PROD")) {
				loginPCSBusinessLogic.ePricerLoginscreen("SelectAIBMPRODRole", ENV);
			} else {
				loginPCSBusinessLogic.ePricerLoginscreen("SelectIBMRole", ENV);
			}	
			Thread.sleep(5000);
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtopricetab();
			Thread.sleep(10000);
			if (ENV.equalsIgnoreCase("PROD")) {
				Extent_Reporting.Log_Pass("Sanity_TC10_BPJP_SB Passed.", "Sanity_TC10_BPJP_SB Passed.", test);
				PCScreateAQuoteBusinessLogic.createFinalReport(3,ENV,Timestamp,"Pass",0);
			} else {
				EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("approval");
				EpricerApplicationIBMQuoteEditorBusinessLogic.approveBPquoteinIBM();
				Extent_Reporting.Log_Pass("Sanity_TC10_BPJP_SB Passed.", "Sanity_TC10_BPJP_SB Passed.", test);
				}
	        } catch (Throwable e) {
			Extent_Reporting.Log_Fail("Sanity_TC10_BPJP_SB Failed.", "Sanity_TC10_BPJP_SB.", driver, test);
			if (ENV.equalsIgnoreCase("PROD")) {
				PCScreateAQuoteBusinessLogic.createFinalReport(3,ENV,Timestamp,"Fail",0);
			}
			driver.quit();
			e.printStackTrace();
			fail();
		}
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
