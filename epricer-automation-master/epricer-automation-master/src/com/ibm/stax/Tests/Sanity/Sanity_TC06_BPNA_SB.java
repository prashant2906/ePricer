package com.ibm.stax.Tests.Sanity;

import static org.testng.Assert.fail;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;


/**
 * @author Neha
*
*/
public class Sanity_TC06_BPNA_SB extends Driver_Setup {

	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogicPcs = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBL = null;

	/**
	 * Verify The Login Page With Valid Credentials
	 * 
	 * @throws Throwable
	 */

	@Test
	@Parameters({ "PCSURL", "IBMURL", "ENV", "Timestamp"})
	public void Sanity_TC06_BPNA_SB_main(String PCSURL, String IBMURL, String ENV,String Timestamp) throws Throwable {

		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogicPcs = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			createAQuoteBL = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,TC_ID, test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(driver, TC_ID, test);

			// create a SB quote

			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();

			loginBusinessLogic.ibmIDPageData(ENV);
			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			if (ENV.equalsIgnoreCase("PROD") || ENV.equalsIgnoreCase("IVT")) {
				loginBusinessLogic.ePricerLoginscreen("SelectProdRole", ENV);
			} else {
				loginBusinessLogic.ePricerLoginscreen();
			}	
			Thread.sleep(5000);
			createAQuoteBusinessLogicPcs.createANewQuoteLinkClick();
			Thread.sleep(5000);
			Quoteid = createAQuoteBusinessLogicPcs.quoteIdFetched();
			System.out.println("BP NA Quote: " + Quoteid);
			createAQuoteBusinessLogicPcs.overviewPolygonScreen();
			if (ENV.equalsIgnoreCase("PROD")||ENV.equalsIgnoreCase("IVT")) {
				createAQuoteBusinessLogicPcs.overviewProdData(ENV);
			} else {
				createAQuoteBusinessLogicPcs.countrybidtypeselectforEPricerOverviewScreen(ENV);
			}	

			createAQuoteBL.moveToManageConfig();

			createAQuoteBusinessLogicPcs.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogicPcs.addProductManuallyButtonClick();
			createAQuoteBusinessLogicPcs.dataForEPricerAddProductManuallyScreen();
		//	createAQuoteBusinessLogicPcs.componentAddedSuccessMsg();
			Thread.sleep(8000);
			createAQuoteBusinessLogicPcs.collectPricingButtonClick();
			createAQuoteBusinessLogicPcs.pricingValueCheck();

			createAQuoteBusinessLogicPcs.registrationCustomerPolygon();
			createAQuoteBusinessLogicPcs.pcsdataForRegistrationNumberScreen();
			Thread.sleep(20000);
			createAQuoteBusinessLogicPcs.pcsGotoSubmitSBquote(); // click the submit price request to go the submit
																	// price quest tab
			createAQuoteBusinessLogicPcs.pcsSubmitSBquote(); // sB quote submit

			// open ibm and incomplete the submitted sb quote

			loginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			Thread.sleep(8000);
			if (ENV.equalsIgnoreCase("PROD")) {
				loginBusinessLogic.ePricerLoginscreen("SelectAIBMPRODRole", ENV);
			} else {
				loginBusinessLogic.ePricerLoginscreen("SelectIBMRole", ENV);
			}			
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtocommentstatustab();
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.changeBPquotestatus(true);
			Thread.sleep(20000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtopricetab();
			Thread.sleep(20000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("approval");

			EpricerApplicationIBMQuoteEditorBusinessLogic.approveBPquoteinIBM();
			// open bp to submit the quote again

			Extent_Reporting.Log_Pass("Sanity_TC06_BPNA_SB Passed.", "Sanity_TC06_BPNA_SB Passed.", test);
			if (ENV.equalsIgnoreCase("PROD")) {
				createAQuoteBusinessLogicPcs.createFinalReport(1,ENV,Timestamp,"Pass",0);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Sanity_TC06_BPNA_SB Failed.", "Sanity_TC06_BPNA_SB Failed.", driver, test);
			if (ENV.equalsIgnoreCase("PROD")) {
				createAQuoteBusinessLogicPcs.createFinalReport(1,ENV,Timestamp,"Fail",0);
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