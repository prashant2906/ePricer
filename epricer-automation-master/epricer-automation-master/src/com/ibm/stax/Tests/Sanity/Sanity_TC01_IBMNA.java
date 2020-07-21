package com.ibm.stax.Tests.Sanity;

import static org.testng.Assert.fail;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;

/**
 * @author Neha
 *
 */
public class Sanity_TC01_IBMNA extends Driver_Setup {
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogicPcs = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;

	@Test
	@Parameters({ "IBMURL", "ENV", "Timestamp" })
	public void Sanity_TC01_IBMNA_main(String IBMURL, String ENV, String Timestamp) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogicPcs = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(
					driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);

			// PCSloginBusinessLogic.epricerNavigatetoIBM(IBMURL);
			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			Thread.sleep(5000);
			if (ENV.equalsIgnoreCase("PROD")) {
				PCSloginBusinessLogic.ePricerLoginscreen("SelectProdRole", ENV);
			} else {
				PCSloginBusinessLogic.ePricerLoginscreen();
			}

			EpricerApplicationIBMQuoteEditorBusinessLogic.ClickcreateQuoteLink();
			Quoteid = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			EpricerApplicationIBMQuoteEditorBusinessLogic.overviewpageinIBM("United States", ENV);
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.CustomerpageinIBM();

			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.dataForEPricerAddProductManuallyScreen();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.collectPricingButtonClick();
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonconfigurationpage();

			Thread.sleep(10000);

			// EpricerApplicationIBMQuoteEditorBusinessLogic.switchtotabinIBM("Pricing");
			Thread.sleep(9000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Prices");
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.changepricebuttomline();
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Request approval");
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonrequestapprovalpage();

			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Approval");
			// CDT DEV has different set of SDE codes compared to CDT MAINT. So calling a
			// different function.
			if (ENV.equalsIgnoreCase("DEV")) {
				EpricerApplicationIBMQuoteEditorBusinessLogic.actiononApprovaltabCDTDEV("Approve");
			} else {
				EpricerApplicationIBMQuoteEditorBusinessLogic.actiononApprovaltab("Approve");
			}

			Thread.sleep(5000);
			String quotestatus = action.getInputTextValue(driver,
					".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteheader-page/div[2]/div/div[2]/div[1]/div[5]/span",
					"Get status");

			if (quotestatus.equalsIgnoreCase("Ongoing quote - Approved")) {
				Extent_Reporting.Log_Pass("Sanity_TC01_IBMNA Passed.", "Sanity_TC01_IBMNA Passed.", test);
			} else {
				fail("the quote status should be Ongoing quote - Approved which is " + quotestatus);
			}
			if (ENV.equalsIgnoreCase("PROD")) {
				 createAQuoteBusinessLogicPcs.createFinalReport(1,ENV,Timestamp,"Pass",0);
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Sanity_TC01_IBMNA Failed.", "Sanity_TC01_IBMNA Failed", driver, test);
			if (ENV.equalsIgnoreCase("PROD")) {
				 createAQuoteBusinessLogicPcs.createFinalReport(1,ENV,Timestamp,"Fail",0);
			}
			driver.quit();
			e.printStackTrace();
			fail("Failed");
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
