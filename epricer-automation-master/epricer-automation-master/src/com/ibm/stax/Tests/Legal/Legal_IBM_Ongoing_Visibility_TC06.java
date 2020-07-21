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
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Legal_IBM_Ongoing_Visibility_TC06 extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;

	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "IBMURL", "ENV" })
	public void Legal_IBM_Ongoing_Visibility_TC06_main(String IBMURL, String ENV) throws Throwable {
		try {
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(
					driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);

		PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole", ENV);

			EpricerApplicationIBMQuoteEditorBusinessLogic.ClickcreateQuoteLink();
			String Quoteidlvl5 = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			EpricerApplicationIBMQuoteEditorBusinessLogic.overviewpageinIBM("United States", ENV);
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.CustomerpageinIBMNA();

			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			EpricerApplicationIBMQuoteEditorBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonconfigurationpage();

			Thread.sleep(20000);

			//EpricerApplicationIBMQuoteEditorBusinessLogic.switchtotabinIBM("Pricing");
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Prices");
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.changepricebuttomline();
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Request approval");
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonrequestapprovalpage();

			EpricerApplicationIBMQuoteEditorBusinessLogic.closecurrentIBMquote();

			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectADistributorRole", ENV); // just use this column as new ibm
																						// group

			EpricerApplicationIBMQuoteEditorBusinessLogic.ClickcreateQuoteLink();
			String Quoteidlvl6 = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.overviewpageinIBM("United States", ENV);
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.CustomerpageinIBMNA();

			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			EpricerApplicationIBMQuoteEditorBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonconfigurationpage();

			Thread.sleep(20000);

			//EpricerApplicationIBMQuoteEditorBusinessLogic.switchtotabinIBM("Pricing");
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Prices");
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.changepricebuttomline();
			Thread.sleep(10000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("Request approval");
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonrequestapprovalpage();

			EpricerApplicationIBMQuoteEditorBusinessLogic.closecurrentIBMquote();

			// String Quoteid = "5190934";
			// String Quoteidlvl5 = "5192357";
			// String Quoteidlvl6 = "5192361";
			// String Quoteidrealcost = "5192346";

			Quoteid = Quoteidlvl5 + "," + Quoteidlvl6;

			System.out.println(Quoteid);

			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectARole", ENV); // just use this column as new ibm group
			EpricerApplicationIBMQuoteEditorBusinessLogic.SearchIBMquotebyid(Quoteidlvl5);

			Boolean checkIfQuoteExists1 = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteidlvl5, true);
			System.out.println(checkIfQuoteExists1 + " " + Quoteidlvl5);

			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectARole", ENV); // just use this column as new ibm group
			EpricerApplicationIBMQuoteEditorBusinessLogic.SearchIBMquotebyid(Quoteidlvl6);

			Boolean checkIfQuoteExists2 = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteidlvl6, true);
			System.out.println(checkIfQuoteExists2 + " " + Quoteidlvl6);

			if (checkIfQuoteExists1 && checkIfQuoteExists2) {
				Extent_Reporting.Log_Pass("Legal_IBM_Ongoing_Visibility_TC06 Passed.",
						"Legal_IBM_Ongoing_Visibility_TC06 Passed.", test);
			} else {
				throw new Exception("Failed");
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_IBM_Ongoing_Visibility_TC06 Failed.",
					"Legal_IBM_Ongoing_Visibility_TC06 Failed", driver, test);
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
