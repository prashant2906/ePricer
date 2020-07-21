package com.ibm.stax.BusinessLogic.NAIBM;
 
import org.openqa.selenium.WebDriver;

import com.ibm.stax.PageObjects.Epricer_Application_Login_PageObjects;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Kajal Shakya
 *
 */
public class Epricer_Application_NAIBM_Login_BusinessLogic {

	private ElementAction action = new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;
	Epricer_Application_Login_PageObjects ePricerLoginPageObjects = null;
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;

	public Epricer_Application_NAIBM_Login_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is to navigate to NAIBM.
	 * 
	 * @throws Throwable
	 */
	public void epricerNavigatetoNAIBM(String NAIBM) throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			
			//driver.get(Excel_Handling.Get_Data(TC_ID, "EMEAIBMUrl"));
	
			driver.get(NAIBM);	
			Thread.sleep(6000);

			Extent_Reporting.Log_report_img("NAIBM url opened.","NAIBM url opened.",driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("NAIBM url not opened.","NAIBM url not opened.",driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}
	
	/**
	 * This method is for ePricerLoginWithPricerRole
	 * 
	 * @throws Throwable
	 */
	public boolean ePricerLoginWithPricerRole() throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver,ePricerLoginPageObjects.selectARoleDD);
			action.isElementDisplayed(driver,ePricerLoginPageObjects.selectARoleDD, "select A Role DD");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,ePricerLoginPageObjects.selectARoleDD,
					Excel_Handling.Get_Data(TC_ID, "SelectADistributorRole"),"select A Role DD");
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("selectARoleDD selected","selectARoleDD selected", driver, test);
			action.waitForElementClickable(driver,ePricerLoginPageObjects.startButton);
			action.Clickbtn(driver, ePricerLoginPageObjects.startButton,"startButton");
			Thread.sleep(4000);
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("ePricer Login screen","ePricer Login screen", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("start button not clicked.","start button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		return true;
	}

	public void searchCustomerWithCMR() throws Throwable{
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchForACustomer);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchForACustomer, "searchForACustomer");//EndUserCustomerName
				//IBMMasterCustomerRadio
			action.selectRadio(driver, ePricerEMEAIBMCreateAQuotePageObjects.ibmMasterCustomerRadio, "ibmMasterCustomerRadio");
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.customerSelectionByCompanyName,"CMR customer number", "customerSelectionByCompanyName");
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cMRCustomerName, "6222902", "CMRCustomerName");
			Thread.sleep(10000);
			//SearchForName
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchInternalCustomer, "searchInternalCustomer");
			Thread.sleep(10000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.customerPageSaveAndContinue, "customerPageSaveAndContinue");	
//			
			//customerPageSaveAndContinue
			
			//action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.customerSaveAndContinue, "customerSaveAndContinue");
			Extent_Reporting.Log_report_img("searchCustomer is Successful.", "searchCustomer is Successful.",driver, test);
			Extent_Reporting.Log_Pass("searchCustomer is Successful.", "searchCustomer is Successful.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("searchCustomer not Successful.","searchCustomer not Successful.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");		}
		
		
	}
}