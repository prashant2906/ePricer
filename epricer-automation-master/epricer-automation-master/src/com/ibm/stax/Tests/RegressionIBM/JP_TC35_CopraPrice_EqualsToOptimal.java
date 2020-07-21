package com.ibm.stax.Tests.RegressionIBM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class JP_TC35_CopraPrice_EqualsToOptimal extends Driver_Setup {

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
	@Parameters({"IBMURL", "ENV"})
	public void CopraPrice_EqualsToOptimal(String IBMURL, String ENV)
			throws Throwable {
		try {
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic(driver, TC_ID,test);

			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole",ENV);

			EpricerApplicationIBMQuoteEditorBusinessLogic.ClickcreateQuoteLink();
			Quoteid = createAQuoteBusinessLogic.quoteIdFetched();
			System.out.println(Quoteid);
			EpricerApplicationIBMQuoteEditorBusinessLogic.overviewpageinIBM("Japan",ENV);
			EpricerApplicationIBMQuoteEditorBusinessLogic.CustomerpageinIBM();

			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			EpricerApplicationIBMQuoteEditorBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			EpricerApplicationIBMQuoteEditorBusinessLogic.savecontinueonconfigurationpage();

			Thread.sleep(20000);

			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtotabinIBM("Pricing");
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.switchtabunderpricing("COPRA");
			Thread.sleep(5000);
			EpricerApplicationIBMQuoteEditorBusinessLogic.SetApprovedPricEqualsToOptimalforCopra();
			Extent_Reporting.Log_Pass("JP_TC35_CopraPrice_EqualsToOptimal Failed.",
					"JP_TC35_CopraPrice_EqualsToOptimal", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("JP_TC35_CopraPrice_EqualsToOptimal Failed.",
					"JP_TC35_CopraPrice_EqualsToOptimal", driver,test);
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
