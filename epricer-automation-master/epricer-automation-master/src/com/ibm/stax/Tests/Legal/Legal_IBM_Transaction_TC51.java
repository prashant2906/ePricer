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
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Legal_IBM_Transaction_TC51 extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;

	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "IBMURL", "ENV" })
	public void Legal_IBM_Transaction_TC51_main(String IBMURL, String ENV) throws Throwable {
		try {

			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(
					driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,
					TC_ID, test);

			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole", ENV);

			/*
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.ClickcreateQuoteLink(); Quoteid
			 * = createAQuoteBusinessLogic.quoteIdFetched(); System.out.println(Quoteid);
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.
			 * overviewpageinIBM("United States", ENV);
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.CustomerpageinIBMNA();
			 * createAQuoteBusinessLogic.addProductManuallyButtonClick();
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.
			 * dataForEPricerAddProductManuallyScreen();
			 * createAQuoteBusinessLogic.collectPricingButtonClick();
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonconfigurationpage
			 * ();
			 * 
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.switchtotabinIBM("Pricing");
			 * Thread.sleep(5000);
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Prices")
			 * ; Thread.sleep(5000);
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.changepricebuttomline();
			 * Thread.sleep(10000); EpricerApplicationIBMQuoteEditorBusinessLogic.
			 * switchtabunderpricing("Request approval");
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.
			 * savecontinueonrequestapprovalpage();
			 * 
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing(
			 * "Approval");
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.actiononApprovaltab("Approve");
			 * 
			 * EpricerApplicationIBMQuoteEditorBusinessLogic.closecurrentIBMquote();
			 */
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();

			EpricerApplicationSearchQuoteBusinessLogic.searchCriteria();

			Thread.sleep(2000);
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuotestatussubcriteria("On hold");

			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuotestatussubcriteriaBPreasoncode(false,
					"Special bid verification");

			EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();

			EpricerApplicationSearchQuoteBusinessLogic.checkonthefirstresult();
			Thread.sleep(5000);
			// EpricerApplicationSearchQuoteBusinessLogic.selectactioninIBMsearch("Open");
			EpricerApplicationSearchQuoteBusinessLogic.clickIBMsearchGO();

			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtotabinIBM("CommonStatus");
			// EpricerApplicationIBMQuoteEditorBusinessLogic.clickonradiobutton("changestaus");
			Thread.sleep(5000);
			boolean checkresult = EpricerApplicationIBMQuoteEditorBusinessLogic.checktinycedisplayed(true);

			if (checkresult) {

				Extent_Reporting.Log_Pass("Legal_IBM_Transaction_TC51 Passed.", "Legal_IBM_Transaction_TC51 Passed.",
						test);
			} else {
				throw new Exception("Failed");
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_IBM_Transaction_TC51 Failed.", "Legal_IBM_Transaction_TC51 Failed", driver,
					test);
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
