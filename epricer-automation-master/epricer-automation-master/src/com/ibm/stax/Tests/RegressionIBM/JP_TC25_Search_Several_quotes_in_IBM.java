/**
 *  
 *
 */

package com.ibm.stax.Tests.RegressionIBM;

import com.ibm.stax.InitialSetup.Driver_Setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.PCS.Epricer_Application_PCS_SearchQuote_BusinessLogic;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;

public class JP_TC25_Search_Several_quotes_in_IBM extends Driver_Setup {

	public WebDriver driver;
	ElementAction action = new ElementAction();
	Epricer_Application_PCS_Login_BusinessLogic PCSloginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_BusinessLogic EpricerApplicationSearchQuoteBusinessLogic = null;

	String Quoteid = "";

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	@Parameters({"IBMURL", "ENV"})
	public void JP_TC25_Search_Several_quotes_in_IBM_main(String IBMURL, String ENV) throws Throwable {
		try {

			PCSloginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID,test);
			EpricerApplicationSearchQuoteBusinessLogic = new Epricer_Application_PCS_SearchQuote_BusinessLogic(driver,TC_ID,test);

			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole",ENV);
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteria();

			Thread.sleep(2000);
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuotestatussubcriteria("Contract preparation");
			EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();

			String Quoteid1 = EpricerApplicationSearchQuoteBusinessLogic.getvalueoffirstresult();
			String Quoteid2 = EpricerApplicationSearchQuoteBusinessLogic.getvalueofsecondresult();

			String Quoteid = Quoteid1 + "," + Quoteid2;
			System.out.println(Quoteid);

			PCSloginBusinessLogic.authenticatePopUpHandle(IBMURL, ENV);
			PCSloginBusinessLogic.ePricerLoginscreen("SelectIBMRole",ENV);
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesLinkClick();
			EpricerApplicationSearchQuoteBusinessLogic.searchQuotesScreen();
			EpricerApplicationSearchQuoteBusinessLogic.searchCriteriaQuoteIdSelect();
			EpricerApplicationSearchQuoteBusinessLogic.enterQuoteId(Quoteid);
			EpricerApplicationSearchQuoteBusinessLogic.ClickIBMSearchbutton();

			Thread.sleep(15000);

			String quoteid11 = action.getInputTextValue(driver, ".//*[@id='currentquotetab']/li[1]/div/div[1]",
					"first result");
			System.out.println(quoteid11);
			String quoteid12 = action.getInputTextValue(driver, ".//*[@id='currentquotetab']/li[2]/div/div[1]",
					"first result");
			System.out.println(quoteid12);

			if (Quoteid.contains(quoteid11)) {
				if (Quoteid.contains(quoteid12)) {
					Extent_Reporting.Log_Pass("JP_TC25_Search_Several_quotes_in_IBM Passed.","JP_TC25_Search_Several_quotes_in_IBM Passed.",test);
				}

			} else {
				throw new Exception("Failed");
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("JP_TC25_Search_Several_quotes_in_IBM Failed.","JP_TC25_Search_Several_quotes_in_IBM", driver,test);
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
