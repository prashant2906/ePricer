package com.ibm.stax.Tests.Sanity;

import com.ibm.stax.InitialSetup.Driver_Setup;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;

/**
 * @author Neha
 *
 */
public class Sanity_TC11_BPJP_VS extends Driver_Setup {

	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;

	@Test
	@Parameters({ "MySAURL", "IBMURL", "ENV",  "Timestamp"})
	public void Sanity_TC11_BPJP_VS_main(String MySAURL, String IBMURL, String ENV, String Timestamp) throws Throwable {
		try {
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			if (ENV.equalsIgnoreCase("PROD")|| ENV.equalsIgnoreCase("IVT")) {
				loginBusinessLogic.MySAPRODLaunch(MySAURL, ENV);
				loginBusinessLogic.LaunchProdGroup("SelectProdRole");
			} else {
				loginBusinessLogic.MySALaunch(MySAURL, ENV);
				Thread.sleep(10000);
				loginBusinessLogic.LaunchGroup();
				}
				Thread.sleep(10000);
				createAQuoteBusinessLogic.createANewQuoteLinkClick();
				Quoteid = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
				System.out.println("BP JP VS Quote: " + Quoteid);
				createAQuoteBusinessLogic.overviewPolygonScreen();
				Thread.sleep(10000);
				createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("Japan", "Special Condition", ENV);
				
				// createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
				// createAQuoteBusinessLogic.dataForEPricerOverviewScreenWithoutQuoteTitle();
				createAQuoteBusinessLogic.moveToManageConfig();
				createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
				createAQuoteBusinessLogic.addProductManuallyButtonClick();
				createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
				// createAQuoteBusinessLogic.componentAddedSuccessMsg();

				createAQuoteBusinessLogic.collectPricingButtonClick();
				createAQuoteBusinessLogic.pricingValueCheck();
				createAQuoteBusinessLogic.registrationCustomerPolygon();
				Thread.sleep(5000);
				createAQuoteBusinessLogic.CustomerpageinPSAT();

				createAQuoteBusinessLogic.detailsPricingPolygon();
				createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
				Thread.sleep(9000);
				// createAQuoteBusinessLogic.valueSellerApprovedStatusCheck();

				// Thread.sleep(15000);

				Extent_Reporting.Log_Pass("Sanity_TC11_BPJP_VS Passed.", "Sanity_TC11_BPJP_VS Passed.", test);
				if (ENV.equalsIgnoreCase("PROD")) {
					PCScreateAQuoteBusinessLogic.createFinalReport(4,ENV, Timestamp,"Pass",0);
				}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Sanity_TC11_BPJP_VS Failed.", "Sanity_TC11_BPJP_VS.", driver, test);
			if (ENV.equalsIgnoreCase("PROD")) {
				PCScreateAQuoteBusinessLogic.createFinalReport(4, ENV, Timestamp,"Fail",0);
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
