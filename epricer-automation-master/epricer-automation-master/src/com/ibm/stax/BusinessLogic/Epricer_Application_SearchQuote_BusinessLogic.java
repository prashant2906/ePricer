package com.ibm.stax.BusinessLogic;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibm.stax.PageObjects.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_SearchQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_SearchQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;


/**
 *  
 *
 */
public class Epricer_Application_SearchQuote_BusinessLogic {
	
	private ElementAction action=new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;	
	public static String quoteId;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	ClassLoader classLoader = getClass().getClassLoader();
	File authenticationIBMGUI = new File(classLoader.getResource("AuthenticationIBMGUI.exe").getFile());

	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = null;
	Epricer_Application_SearchQuote_PageObjects EpricerApplicationSearchQuotePageObjects = null;
	Epricer_Application_PCS_SearchQuote_PageObjects EpricerApplicationSearchQuotePageObjectsJP= null;
	
	public Epricer_Application_SearchQuote_BusinessLogic(WebDriver d,String tcId, ExtentTest test){
		this.test = test;
		this.driver = d;
		this.TC_ID=tcId;
		}
	
	/**
	 * This method is for clicking searchQuotesLink.
	 * @throws Throwable
	 */
	public void searchQuotesLinkClick()  throws Exception
	{
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_SearchQuote_PageObjects(driver, TC_ID);
			
			
				Extent_Reporting.Log_report_img("Clicking on searchQuotesLink ", "Clicking on searchQuotesLink",driver, test);
				action.waitForElementClickable(driver, EpricerApplicationSearchQuotePageObjects.searchQuotesLink );
				Thread.sleep(1000);
				action.Javascriptexecutor_forClick(driver, EpricerApplicationSearchQuotePageObjects.searchQuotesLink, "searchQuotes Link ");
				
				Extent_Reporting.Log_report_img("searchQuotesLink clicked.", "searchQuotesLink clicked.",driver, test);
				Extent_Reporting.Log_Pass("searchQuotesLink clicked.", "searchQuotesLink clicked.", test);
				
			} catch (Throwable e) {
				Extent_Reporting.Log_Fail("searchQuotesLink not clicked.", "searchQuotesLink not clicked.", driver, test);
				e.printStackTrace();
				driver.quit();
				throw new Exception("Failed");
			}
	}
	
	/**
	 * This method is for verifying searchQuotesScreen.
	 * @throws Throwable
	 */
	public void searchQuotesScreen()  throws Exception{
		try
	{
		EpricerApplicationSearchQuotePageObjects = new Epricer_Application_SearchQuote_PageObjects(driver, TC_ID);
		action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchQuotesScreen );
		action.isElementDisplayed(driver, EpricerApplicationSearchQuotePageObjects.searchQuotesScreen, "searchQuotesScreen is displayed.");
		//Thread.sleep(4000);
		Extent_Reporting.Log_report_img("searchQuotesScreen is displayed.", "searchQuotesScreen is displayed.",driver, test);
		Extent_Reporting.Log_Pass("searchQuotesScreen is displayed.", "searchQuotesScreen is displayed.", test);
		
	}catch (Exception e) {
		Extent_Reporting.Log_Fail("searchQuotesScreen is not displayed.", "searchQuotesScreen is not displayed.", driver, test);
		System.out.println(e.getMessage().toString());
		e.printStackTrace();
		driver.quit();
		throw new Exception("Failed");
	}
		
	}
	
	
	/**
	 * This method is for searchCriteriaQuoteIdSelect
	 * @throws Throwable
	 */
	public void Getallsearchcriteria() throws Throwable
	{
	 try{
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_SearchQuote_PageObjects(driver, TC_ID);
			ePricerUpdateAQuotePageObjects =new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
		
		action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.searchCriteriaSelect);
		action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.searchCriteriaSelect, "search Criteria Select");
		
		action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerUpdateAQuotePageObjects.searchCriteriaSelect,Excel_Handling.Get_Data(TC_ID, "SearchCriteriaSelect"), "Select search Criteria Selected");
		Thread.sleep(2000);
		Extent_Reporting.Log_report_img("Select search Criteria Selected", "Select search Criteria Selected",driver, test);
		Extent_Reporting.Log_Pass("Select search Criteria Selected", "Select search Criteria Selected", test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("Select search Criteria not Selected", "Select search Criteria not Selected", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}
	
	public void searchCriteriaQuoteIdSelect() throws Throwable
	{
	 try{
			EpricerApplicationSearchQuotePageObjectsJP = new Epricer_Application_PCS_SearchQuote_PageObjects(driver, TC_ID);
		
		action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchCriteriaSelect);
		action.isElementDisplayed(driver, EpricerApplicationSearchQuotePageObjects.searchCriteriaSelect, "search Criteria Select");
		
		action.selectDropBoxValuebyVisibleTextwithoutClick(driver, EpricerApplicationSearchQuotePageObjects.searchCriteriaSelect,Excel_Handling.Get_Data(TC_ID, "SearchCriteriaSelect"), "Select search Criteria Selected");
		Thread.sleep(2000);
		Extent_Reporting.Log_report_img("Select search Criteria Selected", "Select search Criteria Selected",driver, test);
		Extent_Reporting.Log_Pass("Select search Criteria Selected", "Select search Criteria Selected", test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("Select search Criteria not Selected", "Select search Criteria not Selected", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}
	public void entermultipleQuoteId(String quoteid1, String quoteid2, String quoteid3,String quoteid4) throws Throwable
	{
	 try{
		 EpricerApplicationSearchQuotePageObjectsJP = new Epricer_Application_PCS_SearchQuote_PageObjects(driver, TC_ID);
			//ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
		ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
				driver, TC_ID);
		//Thread.sleep(2000);
		
		action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjectsJP.enterQuoteid);
		action.isElementDisplayed(driver, EpricerApplicationSearchQuotePageObjectsJP.enterQuoteid, "enterQuoteid");
		
		driver.findElement(By.xpath(EpricerApplicationSearchQuotePageObjects.enterQuoteid)).click();
		driver.findElement(By.xpath(EpricerApplicationSearchQuotePageObjects.enterQuoteid)).sendKeys(quoteid1,quoteid2,quoteid3,quoteid4 );
	
		Extent_Reporting.Log_report_img("Quoteid entered.", "Quoteid entered.", driver, test);
		
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("Quoteid not entered.", "Quoteid not entered.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	
}
	public void ClickGObutton() throws Throwable
	{
		try
		{
				EpricerApplicationSearchQuotePageObjectsJP = new Epricer_Application_PCS_SearchQuote_PageObjects(driver, TC_ID);
				action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjectsJP.searchButton);
				action.isElementDisplayed(driver, EpricerApplicationSearchQuotePageObjectsJP.searchButton, "search multiple quotes");
				action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjectsJP.searchButton,"search button clicked.");
				System.out.println("click search button done");
				
				Thread.sleep(5000);
				Extent_Reporting.Log_report_img("Click GO button", "Click GO button",driver, test);
				Extent_Reporting.Log_Pass("Click GO button", "search VS quotesearch VS quote", test);
			
				
				
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("search VS quote not successfully.", "search VS quote failed.", driver, test);
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
			
		}
	public void ClickMultipleCheck() throws Throwable
	{
		try {
			EpricerApplicationSearchQuotePageObjectsJP = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,TC_ID);
			Thread.sleep(5000);
			action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjectsJP.multiplecheck,"multiple check button clicked.");
			//System.out.println("click multiple check done");

			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("multiple check", "Click GO button", driver, test);
			Extent_Reporting.Log_Pass("multiple check", "search VS quotesearch VS quote", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("multiple check successfully.", "multiple check failed.", driver, test);
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}
	public void searchCriteriaCEIDSelect(String ceid) throws Throwable
	{
	 try{
			EpricerApplicationSearchQuotePageObjectsJP = new Epricer_Application_PCS_SearchQuote_PageObjects(driver, TC_ID);
		
			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjectsJP.SP2CEIDSeachQuoteScreen);
			action.isElementDisplayed(driver, EpricerApplicationSearchQuotePageObjectsJP.SP2CEIDSeachQuoteScreen, "enter SP2CIED");
			
			driver.findElement(By.xpath(EpricerApplicationSearchQuotePageObjectsJP.SP2CEIDSeachQuoteScreen)).click();
			driver.findElement(By.xpath(EpricerApplicationSearchQuotePageObjectsJP.SP2CEIDSeachQuoteScreen)).sendKeys(ceid);
			
			Extent_Reporting.Log_report_img("SP2CEID  entered.", "SP2CEID entered.", driver, test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("SP2CEID selected", "SP2CEID selected", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}
}
