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
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class Legal_IBM_Ongoing_Visibility_TC05 extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
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
	public void Legal_IBM_Ongoing_Visibility_TC05_main(String IBMURL, String ENV) throws Throwable {
		try {
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(
					driver, TC_ID, test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);

		PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole", ENV);

			EpricerApplicationIBMQuoteEditorBusinessLogic.ClickcreateQuoteLink();
			String Quoteidlvl7 = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			EpricerApplicationIBMQuoteEditorBusinessLogic.overviewpageinIBM("United States", ENV);
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
			String Quoteidlvl8 = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			EpricerApplicationIBMQuoteEditorBusinessLogic.overviewpageinIBM("United States", ENV);
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
			PCSloginBusinessLogic.ePricerLoginscreen("SelectARole", ENV); // just use this column as new ibm group

			EpricerApplicationIBMQuoteEditorBusinessLogic.ClickcreateQuoteLink();
			String Quoteidrealcost = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			EpricerApplicationIBMQuoteEditorBusinessLogic.overviewpageinIBM("United States", ENV);
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
			// String Quoteidlvl7 = "5192338";
			// String Quoteidlvl8 = "5192342";
			// String Quoteidrealcost = "5192346";

			Quoteid = Quoteidlvl7 + "," + Quoteidlvl8 + "," + Quoteidrealcost;

			System.out.println(Quoteid);

		PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL,ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectARole", ENV); // just use this column as new ibm group
			EpricerApplicationIBMQuoteEditorBusinessLogic.SearchIBMquotebyid(Quoteid);

			// PCSloginBusinessLogic.epricerNavigatetoIBM(IBMURL);
			// PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole", ENV);

			Thread.sleep(5000);

			Boolean checkIfQuoteExists1 = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteidlvl7, true);
			System.out.println(checkIfQuoteExists1 + " " + Quoteidlvl7);
			Boolean checkIfQuoteExists2 = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteidlvl8, true);
			System.out.println(checkIfQuoteExists2 + " " + Quoteidlvl8);
			Boolean checkIfQuoteExists3 = createAQuoteBusinessLogic.checkIfQuoteExists(Quoteidrealcost, true);
			System.out.println(checkIfQuoteExists3 + " " + Quoteidrealcost);

			// Boolean checkIfQuoteExists =
			// createAQuoteBusinessLogic.checkIfErrorMessageExists( "Some quotes are
			// invalid" , true);

			if (checkIfQuoteExists1 && checkIfQuoteExists2 && checkIfQuoteExists3) {
				Extent_Reporting.Log_Pass("Legal_IBM_Ongoing_Visibility_TC05 Passed.",
						"Legal_IBM_Ongoing_Visibility_TC05 Passed.", test);
			} else {
				throw new Exception("Failed");
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_IBM_Ongoing_Visibility_TC05 Failed.",
					"Legal_IBM_Ongoing_Visibility_TC05 Failed", driver, test);
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
