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


import com.ibm.stax.BusinessLogic.Epricer_Application_Change_Configuration_Quantity_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.IBM.Epricer_Application_IBM_QuoteEditor_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;


public class Legal_PSAT_Visibility_SP2_TC35 extends Driver_Setup{
	
	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_Change_Configuration_Quantity_BusinessLogic changeConfigurationQuantity = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringDRBusinessLogic = null;
	
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic PCScreateAQuoteBusinessLogic = null;
	Epricer_Application_PCS_Login_BusinessLogic loginPCSBusinessLogic = null;
	Epricer_Application_IBM_QuoteEditor_BusinessLogic EpricerApplicationIBMQuoteEditorBusinessLogic = null;
	
	
	
	String Quoteid = "";
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({ "MySAURL", "IBMURL","ENV" })
	public void Legal_TC35_PSAT_Visibility_SP2_main(String MySAURL, String IBMURL, String ENV) throws Throwable {
		try {

			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			changeConfigurationQuantity = new Epricer_Application_Change_Configuration_Quantity_BusinessLogic(driver, TC_ID, test);
			createAQuoteNotRequiringDRBusinessLogic = new Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(driver, TC_ID,test);
			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver, TC_ID, test);
			PCScreateAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic (driver, TC_ID, test);
			loginPCSBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic (driver, TC_ID, test);
			EpricerApplicationIBMQuoteEditorBusinessLogic = new Epricer_Application_IBM_QuoteEditor_BusinessLogic (driver, TC_ID, test);
			
			  
			// login with group EULEG_DSDEL - Dist Delete quote and create quote   UK 
			 
		     
		        loginBusinessLogic.MySALaunch(MySAURL,ENV);
				loginBusinessLogic.LaunchGroupLegal("EULEG_S2HVSP - SP2 Hide Value Seller price");
				
				boolean checkIfQuoteExists = false;
				EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
				EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
				EpricerApplicationSearchQuoteBusinessLogic.searchCriteria();
				EpricerApplicationSearchQuoteBusinessLogic.pastsearchCriteriaQuotestatussubcriteria("Value Seller Approved");
				EpricerApplicationSearchQuoteBusinessLogic.ClickSingleCheck();
				EpricerApplicationSearchQuoteBusinessLogic.ClickGObutton();
				
				Thread.sleep(15000);
				
				Thread.sleep(15000);
				
				
				Quoteid = action.getInputTextValue(driver, ".//*[@id='resultTable']/table/tbody/tr[2]/td[2]/span/a", "get teh quote id");
					
					checkIfQuoteExists = createAQuoteBusinessLogic.checkIfQuoteExists( Quoteid , true);
					System.out.println("user1 quote check result " + checkIfQuoteExists);
				
				
				
				
				if (checkIfQuoteExists){
					
					
						Extent_Reporting.Log_Pass("Legal_TC35_PSAT_Visibility_SP2 Passed.",
		    					"Legal_TC35_PSAT_Visibility_SP2 Passed.", test);
					
					
				}
				else
				{
					throw new Exception("Failed");
					
				}

            
            			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Legal_TC35_PSAT_Visibility_SP2 Failed.",
					"Legal_TC35_PSAT_Visibility_SP2.", driver, test);
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
