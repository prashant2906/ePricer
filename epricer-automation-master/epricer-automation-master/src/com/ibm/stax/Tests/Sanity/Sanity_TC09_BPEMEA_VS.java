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
public class Sanity_TC09_BPEMEA_VS extends Driver_Setup{
	
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;
	
	@Test
	@Parameters({ "MySAURL", "IBMURL","ENV", "Timestamp" })
	public void Sanity_TC09_BPEMEA_VS_main(String MySAURL, String IBMURL, String ENV, String Timestamp) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic (driver, TC_ID, test);

			if (ENV.equalsIgnoreCase("PROD")) {
				loginBusinessLogic.MySAPRODLaunch(MySAURL, ENV);
				loginBusinessLogic.LaunchProdGroup("SelectProdRole");
			} else {
				loginBusinessLogic.MySALaunch(MySAURL, ENV);
				Thread.sleep(10000);
				loginBusinessLogic.LaunchGroup();
			}
			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			Quoteid = PCScreateAQuoteBusinessLogic.quoteIdFetchedPSAT();
			System.out.println("BP EMEA VS Quote: " + Quoteid);
			createAQuoteBusinessLogic.overviewPolygonScreen();
			createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreenforlegal("Germany", "Managed Services Offering", ENV);
			
			createAQuoteBusinessLogic.moveToManageConfig();
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			Thread.sleep(10000);
			createAQuoteBusinessLogic.CustomerpageinPSAT();
		
			createAQuoteBusinessLogic.detailsPricingPolygon();
			createAQuoteBusinessLogic.acceptValueSellerOfferButtonClicked();
			//createAQuoteBusinessLogic.valueSellerApprovedStatusCheck();
           
           Thread.sleep(2000);
        	Extent_Reporting.Log_Pass("Sanity_TC09_BPEMEA_VS Passed.","Sanity_TC09_BPEMEA_VS Passed.", test);
        	if (ENV.equalsIgnoreCase("PROD")) {
            	PCScreateAQuoteBusinessLogic.createFinalReport(4,ENV,Timestamp,"Pass",1);	
			}
			} catch (Exception e) {
			Extent_Reporting.Log_Fail("Sanity_TC09_BPEMEA_VS Failed.","Sanity_TC09_BPEMEA_VS.", driver, test);
			if (ENV.equalsIgnoreCase("PROD")) {
				PCScreateAQuoteBusinessLogic.createFinalReport(4,ENV,Timestamp,"Fail",1);
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
