package com.ibm.stax.Tests.Sanity;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
/**
 * @author Neha
 *
 */
public class Sanity_TC07_BPNA_VS extends Driver_Setup {
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBL = null;

	/**
	 * Verify The Login Page With Valid Credentials
	 * @throws Throwable 
	 */
	
	@Test
	@Parameters({"PCSURL","ENV", "Timestamp"})
	public void Sanity_TC07_BPNA_VS_main(String PCSURL,String ENV, String Timestamp) throws Throwable  {
	
	
		try {

			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			createAQuoteBL = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
			loginBusinessLogic.pcsloggin();

			loginBusinessLogic.ibmIDPageData(ENV);
			loginBusinessLogic.pcsENVSelect(ENV);
			// select group
			if (ENV.equalsIgnoreCase("PROD")||ENV.equalsIgnoreCase("IVT")) {
				loginBusinessLogic.ePricerLoginscreen("SelectProdRole", ENV);
			} else {
				loginBusinessLogic.ePricerLoginscreen();
			}

			createAQuoteBusinessLogic.createANewQuoteLinkClick();
			createAQuoteBusinessLogic.overviewPolygonScreen();
			if (ENV.equalsIgnoreCase("PROD") || ENV.equalsIgnoreCase("IVT")) {
				createAQuoteBusinessLogic.overviewProdData(ENV);
			} else {
				createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen(ENV);
			}	
			// createAQuoteBusinessLogic.dataForEPricerOverviewScreen();
			createAQuoteBL.moveToManageConfig();
			
			createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
			createAQuoteBusinessLogic.addProductManuallyButtonClick();
			createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
			//createAQuoteBusinessLogic.componentAddedSuccessMsg();

			createAQuoteBusinessLogic.collectPricingButtonClick();
			createAQuoteBusinessLogic.pricingValueCheck();
			
			createAQuoteBusinessLogic.registrationCustomerPolygon();
			createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreen();
			createAQuoteBusinessLogic.pcsAcceptVSoffer();
			Extent_Reporting.Log_Pass("Sanity_TC07_BPNA_VS Passed.","Sanity_TC07_BPNA_VS Passed.", test);
			if (ENV.equalsIgnoreCase("PROD")) {
				createAQuoteBusinessLogic.createFinalReport(2,ENV,Timestamp,"Pass",0);	
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("Sanity_TC07_BPNA_VS Failed.","Sanity_TC07_BPNA_VS Failed.", driver, test);
			if (ENV.equalsIgnoreCase("PROD")) {
				createAQuoteBusinessLogic.createFinalReport(2,ENV,Timestamp,"Fail",0);
			}
			driver.quit();
			e.printStackTrace();
			}
	
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}