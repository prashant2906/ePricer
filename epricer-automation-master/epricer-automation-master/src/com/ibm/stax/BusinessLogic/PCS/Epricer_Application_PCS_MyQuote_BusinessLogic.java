package com.ibm.stax.BusinessLogic.PCS;

import org.openqa.selenium.WebDriver;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_MyQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;


/**
 * @author Kajal Shakya
 *
 */
public class Epricer_Application_PCS_MyQuote_BusinessLogic {
	
	private ElementAction action=new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;	
	public static String quoteId;

	Epricer_Application_PCS_MyQuote_PageObjects EpricerApplicationPCSMyQuotePageObjects = null;

	public Epricer_Application_PCS_MyQuote_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for clicking searchQuotesLink.
	 * 
	 * @throws Throwable
	 */
	public void MyQuotesLinkClick()  throws Exception
	{
		try {
			EpricerApplicationPCSMyQuotePageObjects = new Epricer_Application_PCS_MyQuote_PageObjects(driver, TC_ID);
			
			
				//Extent_Reporting.Log_report_img("Clicking on searchQuotesLink ", "Clicking on searchQuotesLink",driver);
				action.waitForElementClickable(driver, EpricerApplicationPCSMyQuotePageObjects.pcsmyQuotesLink );
				action.Javascriptexecutor_forClick(driver, EpricerApplicationPCSMyQuotePageObjects.pcsmyQuotesLink, "myQuotes Link ");
				
				Extent_Reporting.Log_report_img("MyQuotesLink clicked.", "MyQuotesLink clicked.",driver, test);
				Extent_Reporting.Log_Pass("MyQuotesLink clicked.", "MyQuotesLink clicked.", test);
				
			} catch (Throwable e) {
				Extent_Reporting.Log_Fail("MyQuotesLink not clicked.", "MyQuotesLink not clicked.", driver, test);
				e.printStackTrace();
				driver.quit();
				throw new Exception("Failed");
			}
	}
	
	/**
	 * This method is for clicking searchQuotesLink.
	 * @throws Throwable
	 */
	public void MyQuotesCheckPage()  throws Exception
	{
		try {
			EpricerApplicationPCSMyQuotePageObjects = new Epricer_Application_PCS_MyQuote_PageObjects(driver, TC_ID);
			
			
				Extent_Reporting.Log_report_img("Check my quote page ", "Check my quote page",driver, test);
				action.waitForElementClickable(driver, EpricerApplicationPCSMyQuotePageObjects.pcsmyQuotesQuoteActiondropdown);
			//	action.Javascriptexecutor_forClick(driver, EpricerApplicationPCSMyQuotePageObjects.pcsmyQuotesLink, "myQuotes Link ");
				
				boolean actiondropdowndisplay = action.CheckifExist(driver, EpricerApplicationPCSMyQuotePageObjects.pcsmyQuotesQuoteActiondropdown);
				
				if (actiondropdowndisplay){
					Extent_Reporting.Log_report_img("check the action dropdown list.", "check the action dropdown list.",driver, test);
					Extent_Reporting.Log_Pass("check the action dropdown list.", "check the action dropdown list.", test);
				}
				else{
					Extent_Reporting.Log_report_img("check the action dropdown list check failed.", "check the action dropdown list check failed. ",driver, test);
					Extent_Reporting.Log_Fail("check the action dropdown list check failed.", "check the action dropdown list check failed.", driver, test);
				}
				
				
				
			} catch (Throwable e) {
				Extent_Reporting.Log_Fail("check the action dropdown list check failed.", "check the action dropdown list check failed.", driver, test);
				e.printStackTrace();
				driver.quit();
				throw new Exception("Failed");
			}
	}
	
	
	

	
}

