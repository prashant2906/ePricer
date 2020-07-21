/*Author-Meenal Dixit*/

package com.ibm.stax.Tests.RegressionBP;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_NA_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.InitialSetup.Driver_Setup;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class PCS_TC21_SBOQuote_NotFoundCompoents_SubmitToIBM extends Driver_Setup{
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic  ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic= null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_PCS_NA_BusinessLogic PCSNABusinessLogic=null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogicNA =null;
String Quoteid = "";

@BeforeClass
public void setUp() {
	System.out.println("PCS_TC21_SBOQuote_NotFoundCompoents_SubmitToIBM");
	driver = getDriver();
	
}

/**
 * Verify The Login Page With Valid Credentials
 * @throws Throwable
 */

@Test
@Parameters({ "PCSURL", "IBMURL","ENV"})
public void PCS_TC21_BOQuote_NotFoundCompoents(String PCSURL,String IBMURL,String ENV) throws Throwable {

	
	try {

		loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
		createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID,test);
		createAQuoteBusinessLogicNA= new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID,test);
		PCSNABusinessLogic = new Epricer_Application_PCS_NA_BusinessLogic(driver, TC_ID,test);
		EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver, TC_ID,test);
		EpricerApplicationIBMQuoteEditorBusinessLogic= new Epricer_Application_IBM_QuoteEditor_BusinessLogic (driver, TC_ID,test);
		//String quoteid = "";
		
        // CREATE SBO QUOTE
		//login into the screen
		loginBusinessLogic.epricerNavigatetoPCS(PCSURL);
		loginBusinessLogic.pcsloggin();			
		loginBusinessLogic.ibmIDPageData(ENV);
		loginBusinessLogic.pcsENVSelect(ENV);
		
		// select group
		loginBusinessLogic.ePricerLoginscreen();
		
		//create a quote and fill mandatory fields on overview page:
		createAQuoteBusinessLogic.createANewQuoteLinkClick();
		Quoteid = createAQuoteBusinessLogicNA.quoteIdFetched();
		createAQuoteBusinessLogic.overviewPolygonScreen();
		createAQuoteBusinessLogic.countrybidtypeselectforEPricerOverviewScreen();
		PCSNABusinessLogic.click_on_saveandcontinue();
		
		//goto manage configuration screen and add product manually:
		createAQuoteBusinessLogic.manageConfigurationPolygonScreen();
		createAQuoteBusinessLogic.addProductManuallyButtonClick();
		createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
		
		//do collect pricing:
		createAQuoteBusinessLogic.collectPricingButtonClick();
		createAQuoteBusinessLogic.pricingValueCheck();
		
		//fill the registration details:
		createAQuoteBusinessLogic.registrationCustomerPolygon();
		createAQuoteBusinessLogic.pcsdataForRegistrationNumberScreenNotFoundComp();
		createAQuoteBusinessLogicNA.pcsGotoSubmitSBquote();  // click the submit price request to go the submit price quest tab
		createAQuoteBusinessLogicNA.pcsSubmitSBquote(); // sB quote submit		
		
		//Login to IBM GUI
		loginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
		loginBusinessLogic.ePricerLoginscreen("SelectIBMRole",ENV);
		EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
		EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
		EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
		EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
		EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();
		Thread.sleep(30000);
		EpricerApplicationIBMQuoteEditorBusinessLogic.switchtocommentstatustab();
		EpricerApplicationIBMQuoteEditorBusinessLogic.changeBPquotestatus(true);
		EpricerApplicationIBMQuoteEditorBusinessLogic.removefromonhold();
		EpricerApplicationIBMQuoteEditorBusinessLogic.switchtopricetab();
		EpricerApplicationIBMQuoteEditorBusinessLogic.ComponentViewOverlayClickForNotFoundComponent();
		
		Extent_Reporting.Log_Pass("PCS_T21_Passed.","PCS_TC21_Passed.", test);
		
	} catch (Exception e) {
		Extent_Reporting.Log_Fail("PCS_T21_Failed.","PCS_TC21_Failed.", driver,test);
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
