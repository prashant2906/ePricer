package com.ibm.stax.Tests.Sanity;

import com.ibm.stax.InitialSetup.Driver_Setup;

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
public class Sanity_TC08_BPEMEA_SB extends Driver_Setup {
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic loginPCSBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;


	@Test
	@Parameters({ "MySAURL", "IBMURL", "ENV", "Timestamp" })
	public void Sanity_TC08_BPEMEA_SB_main(String MySAURL, String IBMURL, String ENV,String Timestamp) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID, test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			loginPCSBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);

			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(
					driver, TC_ID, test);

			if (ENV.equalsIgnoreCase("PROD") || ENV.equalsIgnoreCase("IVT")) {
				loginBusinessLogic.MySAPRODLaunch(MySAURL, ENV);
				loginBusinessLogic.LaunchProdGroup("SelectProdRole");
			} else {
				loginBusinessLogic.MySALaunch(MySAURL, ENV);
				Thread.sleep(10000);
				loginBusinessLogic.LaunchGroup();
			}
			Thread.sleep(4000);
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			Quoteid = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("BP EMEA SB Quote: " + Quoteid);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			Thread.sleep(5000);
			if (ENV.equalsIgnoreCase("PROD")|| ENV.equalsIgnoreCase("IVT")) {
				createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("Germany", "Managed Services Offering",ENV);
			} else {
				createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("France", "Managed Services Offering", ENV);
			}			
			Thread.sleep(4000);
			//createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			createAQuoteBusinessLogic.moveToManageConfig();
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			// createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			Thread.sleep(2000);
			createAQuoteBusinessLogic.CustomerpageinPSAT();
			// createAQuoteBusinessLogic.dataForRegistrationNumberScreen(ENV);
			createAQuoteBusinessLogic.detailsPricingPolygon();

			Thread.sleep(10000);

			createAQuoteBusinessLogic.checkrequestexceptioncheckbox();

			createAQuoteBusinessLogic.clicksubmitpricerequestbutton();
			Thread.sleep(20000);
			createAQuoteBusinessLogic.PSATinputIBMchanelinfo();
			Thread.sleep(5000);
			createAQuoteBusinessLogic.PSATSBsubmit();
			Thread.sleep(20000);

			// open ibm and incomplete the submitted sb quote

			loginPCSBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			
			if (ENV.equalsIgnoreCase("PROD")||ENV.equalsIgnoreCase("IVT")) {
				loginPCSBusinessLogic.ePricerLoginscreen("SelectAIBMPRODRole", ENV);
			} else {
				loginPCSBusinessLogic.ePricerLoginscreen("SelectIBMRole", ENV);
			}	
			
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			Thread.sleep(5000);
			EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtocommentstatustab();
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.changeBPquotestatus(true);

			Thread.sleep(2000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtopricetab();
			Thread.sleep(2000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("approval");

			EpricerApplicationIBMQuoteEditorBusinessLogic.approveBPquoteinIBM();
			// open bp to submit the quote again

			Extent_Reporting.Log_Pass("Sanity_TC08_BPEMEA_SB Passed.", "Sanity_TC08_BPEMEA_SB Passed.", test);
			if (ENV.equalsIgnoreCase("PROD")) {
				PCScreateAQuoteBusinessLogic.createFinalReport(3,ENV, Timestamp,"Pass",1);
			}
			}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("Sanity_TC08_BPEMEA_SB Failed.", "Sanity_TC08_BPEMEA_SB.", driver, test);
			if (ENV.equalsIgnoreCase("PROD")) {
				PCScreateAQuoteBusinessLogic.createFinalReport(3,ENV, Timestamp,"Fail",1);			
			}
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
