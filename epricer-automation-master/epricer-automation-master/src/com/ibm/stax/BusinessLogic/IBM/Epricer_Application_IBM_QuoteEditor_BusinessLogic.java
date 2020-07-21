/**
 *
 */
package com.ibm.stax.BusinessLogic.IBM;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.IBM.Epricer_Application_IBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.IBM.Epricer_Application_IBM_QuoteEditor;
import com.ibm.stax.PageObjects.NAIBM.Epricer_Application_NAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_CreateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

public class Epricer_Application_IBM_QuoteEditor_BusinessLogic {

	ElementAction action = new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;

	Epricer_Application_IBM_QuoteEditor IBMQuoteEditor = null;
	Epricer_Application_PCS_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_IBM_CreateAQuote_PageObjects ePricerIBMCreateAQuotePageObjects = null;
	Epricer_Application_NAIBM_CreateAQuote_PageObjects nAIBMCreateAQuotePageObjects = null;
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;
	static String quoteId;

	public Epricer_Application_IBM_QuoteEditor_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/*
	 * @jacob: Create quote link for IBM
	 * 
	 */
	public void ClickcreateQuoteLink() throws Exception {

		ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);

		Thread.sleep(5000);
		try {
			action.clickLinkByLinkText(driver, "Create quote", "click the link create quote");
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_Pass("ibm CreateQuoteLink not clicked.", "ibm CreateQuoteLink not clicked.", test);
			Extent_Reporting.Log_report_img("Clicking on ibm CreateQuoteLink ", "Clicking on ibm CreateQuoteLink",
					driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("ibm CreateQuoteLink not clicked.", "ibm CreateQuoteLink not clicked.", driver,test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}


	/*
	 * @jacob: Create quote link for IBM
	 * 
	 */
	public void ClickMyQuoteLink() throws Exception{
		
		ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
		
		Thread.sleep(5000);
		try {
			Extent_Reporting.Log_report_img("Clicking on ibm MyQuoteLink ", "Clicking on ibm MyQuoteLink",driver, test);
			action.clickLinkByLinkText(driver, "My quotes", "click the link My quote");
			Thread.sleep(5000);
			if (isAlertPResent())
			{
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
			}
			action.waitForPageToLoad(driver);
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("ibm MyQuoteLink not clicked.", "ibm MyQuoteLink not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
}
	
	/*
	 * @jacob: Create quote link for IBM
	 * 
	 */
	public boolean checklinkondashboard(String link,boolean expected) throws Exception{
		
		ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
		boolean result = false;
		Thread.sleep(5000);
		try {
			Extent_Reporting.Log_report_img("checklinkondashboard ", "checklinkondashboard",driver, test);
			result=driver.findElement(By.linkText(link)).isDisplayed();
			if(result){
				System.out.println("The link \"" + link +"\" is found");
			}
			action.waitForPageToLoad(driver);
		} catch (Throwable e) {
			System.out.println("The link \"" + link +"\" is not found");
			result = false;
		}
		if (result == expected){
			result = true;
		}else{
			result = false;
		}
		
		return result;
	}
	
	
	/*
	 * @jacob: close current quote
	 * 
	 */
	public void closecurrentIBMquote() throws Exception {

		ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);

		Thread.sleep(5000);
		try {
			//action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMclosecurrnetquote, "close current quote");
			Extent_Reporting.Log_Pass("close current quote ", "close current quote", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("close current quote not clicked.", "close current quote not clicked.", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	
	/*
	 * @jacob: search quote id for ibm
	 * 
	 */
	public void SearchIBMquotebyid(String quoteid) throws Exception{
		
		ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
		
		Thread.sleep(5000);
		try {
			Extent_Reporting.Log_report_img("Clicking on ibm SearchQuoteLink ", "Clicking on ibm SearchQuoteLink",driver, test);
			action.clickLinkByLinkText(driver, "Search quotes", "click the link Search Quote");
			action.waitForPageToLoad(driver);
			
			Thread.sleep(5000);
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMselectinternalquote, "select internal quote");
			
			if (isAlertPResent())
			{
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			
			action.selectDropBoxByVisibleText(driver, ePricerIBMCreateAQuotePageObjects.IBMsearchcriteria, "Quote id(s)", "select quoteid");
			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMquoteidinput, quoteid, "input quote id");
			
			if (driver.findElement(By.id("multipleCheck")).isSelected())
					{
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMmultipleCheck, "check on the multiple checkbox");
			}
		
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMsearchbutton, "click on search button");
			
			
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("ibm SearchQuoteLink not clicked.", "ibm SearchQuoteLink not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
}
	
	/*
	 * @jacob: Create quote link for IBM overview page
	 * 
	 */
	public void CRADNumberoverviewpageinIBM(String date) throws Exception{
		
		ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
		
		action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewOOname);
		try {
				
			Thread.sleep(2000);
			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewcradnumber, date, "enter crad number");
			// date as 01 Oct 2021
			
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("overview page in ibm failed.", "overview page in ibm failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
}
	
	
	/*
	 * @jacob: Create quote link for IBM overview page
	 * 
	 */
	/*
	 * @jacob: Create quote link for IBM overview page
	 * 
	 */
	public void overviewpageinIBM(String CTRY, String Env) throws Exception {
		ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
		ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
		Thread.sleep(15000);
		//action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewOOname);
		try {
			if (Env.contentEquals("PROD")|| Env.equalsIgnoreCase("IVT")) {
				action.selectDropBoxByVisibleText(driver,
						ePricerIBMCreateAQuotePageObjects.IBMoverviewcountryselectdropdown,Excel_Handling.Get_Data(TC_ID, "ProdCountry"), "select country");
				action.selectDropBoxByVisibleText(driver,ePricerIBMCreateAQuotePageObjects.IBMoverviewsolusiontypedropdown, "Not Applicable","select solusion type");
			} else {
				action.selectDropBoxByVisibleText(driver,ePricerIBMCreateAQuotePageObjects.IBMoverviewcountryselectdropdown, CTRY, "select country");
				Thread.sleep(15000);
				action.selectDropBoxByVisibleText(driver,ePricerIBMCreateAQuotePageObjects.IBMoverviewsolusiontypedropdown,Excel_Handling.Get_Data(TC_ID, "SelectBidType"), "select solusion type");
			}
			Thread.sleep(2000);
			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewrequestphone, "123456","enter request phone");

			Thread.sleep(2000);
			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewquotetile,Excel_Handling.Get_Data(TC_ID, "TC_ID"), "enter quote title");
			Thread.sleep(2000);
			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewoppid, "123456","enter opp id");
			Thread.sleep(2000);
			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewOOemail,	"test@in.ibm.com", "enter OO email");
			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewOOname, "OO name","enter OO name");
			Thread.sleep(2000);
			action.selectDropBoxByVisibleText(driver,ePricerIBMCreateAQuotePageObjects.IBMoverviewchannelindicatordropdown, "Other","select chanel indicator");
			if (action.CheckifExist(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD)) {
				Calendar c = Calendar.getInstance();
				c.add(Calendar.MONTH, 1);
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
				String strDate= formatter.format(c.getTime());  
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");
			}		
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewsavecontinuebutton,
					"click save and continue");

			Extent_Reporting.Log_Pass("overview page in ibm Passed.", "overview page in ibm Passed.", test);
			Extent_Reporting.Log_report_img("overview page in ibm ", "overview page in ibm", driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("overview page in ibm failed.", "overview page in ibm failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void CustomerpageinIBM() throws Throwable {
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(5000);
			action.waitForPageToLoad(driver);
			Thread.sleep(20000);
			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.searchForACustomer);
			Thread.sleep(10000);
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.searchForACustomer, "searchForACustomer");// EndUserCustomerName
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,ePricerIBMCreateAQuotePageObjects.customerSelectionByCompanyName,
					Excel_Handling.Get_Data(TC_ID, "CompanySearchOnDropdown"), "customerSelectionByCompanyName");
			action.inputText(driver, ePricerIBMCreateAQuotePageObjects.searchForName,
					Excel_Handling.Get_Data(TC_ID, "Search Customer Name"), "searchForName");
			Thread.sleep(5000);
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.searchInternalCustomer, "searchInternalCustomer");
			Thread.sleep(10000);
			if (action.CheckifExist(driver, ePricerIBMCreateAQuotePageObjects.searchInternalCustomer)) {
				action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.customerSelectionForInternal);
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerSelectionForInternal,
						"customerSelectionForInternal");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerSelectionForInternal,
						"customerSelectionForInternal");
				Thread.sleep(3000);
				action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.selectCustomerClick);
				Thread.sleep(5000);
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.selectCustomerClick, "selectCustomerClick");
				Thread.sleep(15000);
				action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue);
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue,
						"customerPageSaveAndContinue");
			}
			else {
				Thread.sleep(10000);
				action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue);
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue,
						"customerPageSaveAndContinue");
			}
			
			Extent_Reporting.Log_report_img("searchCustomer is Successful.", "searchCustomer is Successful.", driver, test);
			Extent_Reporting.Log_Pass("searchCustomer is Successful.", "searchCustomer is Successful.", test);
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Customer page in IBM failed.", "Customer page in IBM failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
			}
		
	}

	public void dataForEPricerAddProductManuallyScreen() throws Throwable {
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMcomponentdropdown);

			action.selectDropBoxValue(driver, ePricerIBMCreateAQuotePageObjects.IBMcomponentdropdown,
					Excel_Handling.Get_Data(TC_ID, "SelectCategorySelected"), "Select Category Selected");

			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("Select Category Selected", "Select Category Selected", driver, test);

			action.inputText(driver, ePricerIBMCreateAQuotePageObjects.IBMcomponenttype,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField1"), "typeModelField1");
			Extent_Reporting.Log_report_img("TypeModelField1 entered.", "TypeModelField1 entered.", driver, test);

			action.inputText(driver, ePricerIBMCreateAQuotePageObjects.IBMcomponentmodel,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField2"), "TypeModelField2");
			Extent_Reporting.Log_report_img("TypeModelField2 entered.", "TypeModelField2 entered.", driver, test);

			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMcomponentaddclose, "click add and close");
			// Thread.sleep(50000);

			Thread.sleep(15000);

			Extent_Reporting.Log_report_img("dataForEPricerAddProductManuallyScreen provided.",
					"dataForEPricerAddProductManuallyScreen provided.", driver, test);
			Extent_Reporting.Log_Pass("dataForEPricerAddProductManuallyScreen provided.",
					"dataForEPricerAddProductManuallyScreen provided.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("dataForEPricerAddProductManuallyScreen not provided.",
					"dataForEPricerAddProductManuallyScreen not provided.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/*
	 * @jacob: click the button save and continue
	 * 
	 */
	public void savecontinueonconfigurationpage() throws Throwable {
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMcomponentsaveclosebutton);
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMcomponentsaveclosebutton,
					"click save and continue button");
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("click save button.", "click save button.", driver, test);
			Extent_Reporting.Log_Pass("click save button. passed.", "click save button. passed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("click save button on configuration page failed.",
					"click save button on configuration page failed..", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/*
	 * @jacob: click the button save and continue
	 * 
	 */
	public void actiononApprovaltab(String approve_or_reject) throws Throwable {
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove);

			if (approve_or_reject.equalsIgnoreCase("approve")) {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove,
						"click approval button");

			} else if (approve_or_reject.equalsIgnoreCase("reject")) {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioreject,
						"click reject button");
			} else {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove,
						"click approval button");
				// click approve by default
			}

			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalLvl1emailid,
					"test@in.ibm.com", "input level 1 mail id");
			Thread.sleep(8000);
			if (action.CheckifExist(driver, nAIBMCreateAQuotePageObjects.specialBidCode)) {
				action.selectDropBoxByVisibleText(driver, nAIBMCreateAQuotePageObjects.specialBidCode,"SDE2,GEO Specific Exemptions", "specialBidCode");
			}			
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalsubmitbutton,
					"click submit button");

			Thread.sleep(15000);
			// action.clickButton(driver,
			// ".//*[@id='ngdialog3']/div[2]/div[1]/div[2]/div[9]/div/p/button[2]", "");

			//action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabsubmitcancelnotification);
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabsubmitcancelnotification,
					"click cancel notification button");
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("click submit button.", "click save button.", driver, test);
			Extent_Reporting.Log_Pass("click save button. passed.", "click save button. passed.", test);

		} catch (Exception e) {			
			Extent_Reporting.Log_Fail("click save button on configuration page failed.","click save button on configuration page failed..", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/*
	 * @jacob: click the button save and continue
	 * 
	 */
	public void savecontinueonrequestapprovalpage() throws Throwable {
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalsavebutton);

			driver.switchTo().frame("ui-tinymce-4_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection, "Test",
					"commentsSection");
			driver.switchTo().parentFrame();

			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalsavebutton,
					"click save and continue button");

			action.waitForElementClickable(driver,
					ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalcancelnotification);

			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalcancelnotification,
					"click cancel notification button");

			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("click save button.", "click save button.", driver, test);
			Extent_Reporting.Log_Pass("click save button. passed.", "click save button. passed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("click save button on configuration page failed.",
					"click save button on configuration page failed..", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/*
	 * @jacob: click the button save and continue
	 * 
	 */
	

	public void manageConfigurationinIBM() throws Exception {
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.mnageInternaConfigurationPolygon);
			action.isElementDisplayed(driver, ePricerIBMCreateAQuotePageObjects.mnageInternaConfigurationPolygon,
					"mnageInternaConfigurationPolygon is displayed.");

			Extent_Reporting.Log_report_img("mnageInternaConfigurationPolygon is displayed.",
					"mnageInternaConfigurationPolygon is displayed.", driver, test);
			Extent_Reporting.Log_Pass("mnageInternaConfigurationPolygon is displayed.",
					"mnageInternaConfigurationPolygon is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("mnageInternaConfigurationPolygon is not displayed.",
					"mnageInternaConfigurationPolygon is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for addProductManuallyButtonClick
	 * 
	 * @throws Throwable
	 */
	public void addProductManuallyButtonClick() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.addProductManuallyButton);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.addProductManuallyButton,
					"addProductManuallyButton");

			Extent_Reporting.Log_report_img("addProductManually button clicked.", "addProductManually button clicked.",
					driver, test);
			Extent_Reporting.Log_Pass("addProductManually button clicked.", "addProductManually button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("addProductManually button not clicked.",
					"addProductManually button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for change tab.
	 * 
	 * @throws Throwable
	 */
	public void switchtotabinIBM(String Tab) throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			Thread.sleep(15000);
			//action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministration);
			switch(Tab){
	        case "Administration":
	        	action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministration, "change the view to administration");
	        	break;
	        case "Pricing":
	        	Thread.sleep(40000);
	        	action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabPricing, "change the view to price");
	           
	            break;
	        case "Overview":
	        	Thread.sleep(20000);
	        	action.clickButton(driver, ".//*[text()='Overview']", "change the view to overview");
	      //  	action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabOverview, "change the view to Overview");
	             break;
	        case "ReportsLetters":
	        	//action.clickButton(driver, ".//*[text()='Reports/Letters']", "change the view to overview");
	        	action.clickLinkByLinkText(driver, "Reports/Letters", "change the view");
	        	break;
	        case "CommonStatus":
	        	Thread.sleep(40000);
	            //action.clickButton(driver, ".//*[text()='Comments/Status']", "change the view to overview");
	            action.clickLinkByLinkText(driver, "Comments/Status", "change the view");
	        default:
	            System.out.println("default");
	            break;
	        }
			Extent_Reporting.Log_Pass(Tab+" clicked.", Tab+" clicked.", test);
			Extent_Reporting.Log_report_img("Clicking on"+Tab, "Clicking on "+Tab, driver,test);
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail(Tab+" not clicked.", Tab+" not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	

/**
 * This method is for change bottom line price.
 * @throws Throwable
 */
	public void selectpriceview(String view)  throws Exception
	{
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor  (driver, TC_ID);
		ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
		try {
			Thread.sleep(15000);
			//action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMtabpricesviewdropdown);
			action.selectDropBoxByVisibleText(driver, ePricerIBMCreateAQuotePageObjects.IBMtabpricesviewdropdown, view, "Select total view");
			System.out.println("select the total");
			Thread.sleep(10000);			
			if (isAlertPResent()) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			Thread.sleep(3000);
			if (isAlertPResent()) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
		
						
			Extent_Reporting.Log_report_img("select price view ", "select price view",driver, test);
				
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("select price view failed.", "select price view failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
}


	/**
	 * This method is for change bottom line price.
	 * 
	 * @throws Throwable
	 */
	public void changepricebuttomline() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			//action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMtabpricesviewdropdown);
			action.selectDropBoxByVisibleText(driver, ePricerIBMCreateAQuotePageObjects.IBMtabpricesviewdropdown,
					"Total", "Select total view");
			//System.out.println("select the total");
			Thread.sleep(10000);

			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.pricingCheckBoxClick);
			action.Javascriptexecutor_forClick(driver, ePricerIBMCreateAQuotePageObjects.pricingCheckBoxClick,
					"pricingCheckBoxClick");
			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.quickApplyButton);
			action.Javascriptexecutor_forClick(driver, ePricerIBMCreateAQuotePageObjects.quickApplyButton,
					"quickApplyButton");
			Thread.sleep(3000);
			action.waitForPageToLoad(driver);
			action.inputText(driver, ePricerIBMCreateAQuotePageObjects.quickApplyField, "99", "QuickApplyField");
			action.Javascriptexecutor_forClick(driver, ePricerIBMCreateAQuotePageObjects.applyAfterDiscount,
					"applyAfterDiscount");// requestApproval

			if (isAlertPResent()) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			if (isAlertPResent()) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}
			Thread.sleep(9000);
			action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMtabpricesviewdropdown);
			Extent_Reporting.Log_Pass("update the bottom line price passed.", "update the bottom line price passed.", test);
			Extent_Reporting.Log_report_img("update the bottom line price ", "update the bottom line price", driver,
					test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("update the bottom line price failed.", "update the bottom line price failed.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for change bottom line price.
	 * 
	 * @throws Throwable
	 */
	public void changepricelineitem() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
		try {

			action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMtabpricesviewdropdown);
			action.selectDropBoxByVisibleText(driver, ePricerIBMCreateAQuotePageObjects.IBMtabpricesviewdropdown,
					"Component", "Select Component view");
			//System.out.println("select the total");
			Thread.sleep(10000);

			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingCheckBoxClick);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingCheckBoxClick,
					"pricingCheckBoxClick");
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyButton);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyButton,
					"quickApplyButton");
			Thread.sleep(3000);
			action.waitForPageToLoad(driver);
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyField, "99", "QuickApplyField");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.applyAfterDiscount,
					"applyAfterDiscount");// requestApproval

			Thread.sleep(9000);

			// action.clearAndInputTextValue(driver,
			// ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteprices-page/div/quotepricing-page/div/div/div[11]/div[2]/table/tbody/tr[1]/td[7]/span[2]/input",
			// "99", "Set discount");

			System.out.println("set the discount");
			// action.clickButton(driver,
			// ePricerIBMCreateAQuotePageObjects.IBMtabpricesrecalculatebutton, "click
			// recalculate");
			// action.clickButton(driver,
			// ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteprices-page/div/quotepricing-page/div/div/quotepricingbuttons-page[1]/div[2]/div/a[2]/strong/span",
			// "click recal");

			System.out.println("click recaculate");

			if (isAlertPResent()) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}

			action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMtabpricesviewdropdown);

			Extent_Reporting.Log_report_img("update the bottom line price ", "update the bottom line price", driver,test);
			Extent_Reporting.Log_Pass("update the bottom line price failed.", "update the bottom line price failed.",test);
			} catch (Throwable e) {
			Extent_Reporting.Log_Fail("update the bottom line price failed.", "update the bottom line price failed.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void SignquoteinIBM() throws Throwable {
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationmaintainofferno);

			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationothernumberid,
					"H2JS9", "in put H2JS9");
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationmaintainofferno,
					"click radio button maintain offer no");
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationsigntypecash,
					"click radio sign by cash");

			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationsavebutton, "click save");

			Extent_Reporting.Log_report_img("searchCustomer is Successful.", "searchCustomer is Successful.", driver,
					test);
			Extent_Reporting.Log_Pass("searchCustomer is Successful.", "searchCustomer is Successful.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("SignquoteinIBM failed.", "SignquoteinIBM failed.",driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for change tab.
	 * 
	 * @throws Throwable
	 */
	public void switchtocommentstatustab() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			Thread.sleep(25000);
			action.waitForPageToLoad(driver);			
			action.clickLinkByLinkText(driver, "Comments/Status", "change the view");			
			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("Clicking on Comments/Status ", "Clicking on Comments/Status", driver,test);
			Extent_Reporting.Log_Pass("Comments/Status clicked.", "Comments/Status clicked.", test);
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("Comments/Status not clicked.", "Comments/Status not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for change tab.
	 * 
	 * @throws Throwable
	 */
	public void switchtopricetab() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			Thread.sleep(20000);
			action.clickLinkByLinkText(driver, "Pricing", "change the tab to pricing");
			Extent_Reporting.Log_Pass("Clicking on pricing ", "Clicking on pricing", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("pricing not clicked.", "pricing not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for change tab.
	 * 
	 * @throws Throwable
	 */
	public void checkquotestatus(String status) throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			action.waitForElementVisible(driver, IBMQuoteEditor.IBMquotestatus);
			String text = action.getInputTextValue(driver, IBMQuoteEditor.IBMquotestatus, "get status");
			System.out.println("Quote status is " + text);
			Thread.sleep(2000);
			if (text.equalsIgnoreCase(status)) {
				Extent_Reporting.Log_Pass("check quote status pass", "check quote status pass", test);
				Extent_Reporting.Log_report_img(" check quote status ", "check quote status", driver, test);
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("check quote status failed.", "check quote status failed.", driver, test);
			driver.quit();
			e.printStackTrace();
		}
	}

	/**
	 * This method is for change tab.
	 * 
	 * @throws Throwable
	 */
	public void switchtabunderpricing(String tab) throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			Thread.sleep(2000);
			// action.waitForElementVisible(driver, IBMQuoteEditor.IBMCOPRAlink);
			if (tab.equalsIgnoreCase("COPRA")) {
				try {
					Thread.sleep(2000);
					action.clickLinkByLinkText(driver, IBMQuoteEditor.IBMCOPRAlink, "change the tab to COPRA");
					Extent_Reporting.Log_Pass("Copra clicked.", "Copra clicked.", test);
					Extent_Reporting.Log_report_img("Clicking on Copra ", "Clicking on copra", driver, test);

				} catch (Throwable e) {
					Extent_Reporting.Log_Fail("copra not clicked.", "copra not clicked.", driver, test);
					driver.quit();
					e.printStackTrace();
					throw new Exception("Failed");
				}
			}
			if (tab.equalsIgnoreCase("Prices")) {
				try {
					Thread.sleep(35000);
					action.clickLinkByLinkText(driver, IBMQuoteEditor.IBMPriceslink, "change the tab to prices");
					Extent_Reporting.Log_Pass("Clicking on prices ", "Clicking on prices", test);

			} catch (Throwable e) {
					Extent_Reporting.Log_Fail("prices not clicked.", "prices not clicked.", driver, test);
					driver.quit();
					e.printStackTrace();
					throw new Exception("Failed");
				}
			}

			if (tab.equalsIgnoreCase("approval")) {
				try {
					Thread.sleep(10000);
					action.clickLinkByLinkText(driver, IBMQuoteEditor.IBMapprovelink, "change the tab to approval");
					Extent_Reporting.Log_Pass("Clicking on approval ", "Clicking on approval", test);

				} catch (Throwable e) {
					Extent_Reporting.Log_Fail("approval not clicked.", "approval not clicked.", driver, test);
					driver.quit();
					e.printStackTrace();
					throw new Exception("Failed");
				}
			}
			if (tab.equalsIgnoreCase("Request approval")) {
				try {
					Thread.sleep(25000);
					action.clickLinkByLinkText(driver, IBMQuoteEditor.IBMRequestapprovallink, "change the tab to IBMRequestapprovallink");
					
					if (isAlertPResent()) {
						action.acceptAlert(driver);
					}
					Extent_Reporting.Log_Pass("IBMRequestapprovallink clicked.","IBMRequestapprovallink clicked.", test);
					
				} catch (Throwable e) {
					Extent_Reporting.Log_Fail("IBMRequestapprovallink not clicked.","IBMRequestapprovallink not clicked.", driver, test);
					driver.quit();
					e.printStackTrace();
					throw new Exception("Failed");
				}
			}
			Extent_Reporting.Log_Pass("change tab to " + tab + "Passed", "change tab to " + tab + "Passed", test);
			Extent_Reporting.Log_report_img("change tab to " + tab, "change tab to " + tab, driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("change tab to " + tab + "failed", "change tab to " + tab + "failed", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for change status.
	 * 
	 * @throws Throwable
	 */
	public void changeBPquotestatus(Boolean reasoncode) throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
		try {
			Thread.sleep(18000);
			action.waitForElementVisible(driver, IBMQuoteEditor.IBMChangeStautsRadio);			
			action.Javascriptexecutor_forClick(driver, IBMQuoteEditor.IBMChangeStautsRadio, "click on change status radio");
			Thread.sleep(7000);
			action.waitForElementVisible(driver, IBMQuoteEditor.IBMChangeStautsdropdownlist);

			action.selectDropBoxByVisibleText(driver, IBMQuoteEditor.IBMChangeStautsdropdownlist,
					Excel_Handling.Get_Data(TC_ID, "ChangeBPStauts"), "Select the status to change");
			Extent_Reporting.Log_Pass("change status passed", "change status passed.", test);

			if (reasoncode) {
				Thread.sleep(8000);
				action.selectDropBoxByVisibleText(driver, IBMQuoteEditor.IBMChangeStautsreasoncodedropdownlist,
						Excel_Handling.Get_Data(TC_ID, "changeBPreasoncode"), "Select the status to change");
				Extent_Reporting.Log_Pass("Select the status to change passed", "Select the status to change passed.", test);
			}
			Thread.sleep(30000);
			driver.switchTo().frame("ui-tinymce-0_ifr");
			
			Thread.sleep(15000);
			
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection, "Test",
					"commentsSection");
			driver.switchTo().parentFrame();
			Extent_Reporting.Log_Pass("write on comments section passed", "write on comments section passed.", test);

			Thread.sleep(20000);

			action.Javascriptexecutor_forClick(driver, IBMQuoteEditor.IBMChangeStautsSaveButton, "click save button");
			action.waitForPageToLoad(driver);
			Thread.sleep(8000);
			Extent_Reporting.Log_report_img("Clicking on save button to change status ","Clicking on save button to change status ", driver, test);
			Extent_Reporting.Log_Pass("Clicking on save button to change status passed", "Clicking on save button to change status passed.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("Clicking on save button to change status fail.",	"Clicking on save button to change status fail.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for clicking the remove from onhold radio button.
	 * 
	 * @throws Throwable
	 */
	public void removefromonhold() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
		try {
			action.waitForElementVisible(driver, IBMQuoteEditor.IBMRemovefromonhold);
			Thread.sleep(2000);
			action.clickButton(driver, IBMQuoteEditor.IBMRemovefromonhold, "click on remove from on hold radio");
			Thread.sleep(2000);

			driver.switchTo().frame("ui-tinymce-0_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection, "Test",
					"commentsSection");
			driver.switchTo().parentFrame();

			action.clickButton(driver, IBMQuoteEditor.IBMChangeStautsSaveButton, "click save button");
			Extent_Reporting.Log_report_img("Clicking on save button to change status ",
					"Clicking on save button to change status ", driver, test);
			Extent_Reporting.Log_Pass("remove from on hold Passed.", "remove from on hold pass.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("remove from on hold failed.", "remove from on hold failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for approve bp quote
	 * 
	 * @throws Throwable
	 */
	public void approveBPquoteinIBM() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			Thread.sleep(10000);
			action.waitForElementVisible(driver, IBMQuoteEditor.IBMApproveRadio);
			action.clickButton(driver, IBMQuoteEditor.IBMApproveRadio, "click the radio approve");

			action.waitForElementVisible(driver, IBMQuoteEditor.IBMApprovesubmit);
			action.clickButton(driver, IBMQuoteEditor.IBMApprovesubmit, "submit approve");

			Thread.sleep(5000);
			Extent_Reporting.Log_Pass("submit the approve ", "submit the approve", test);
			Extent_Reporting.Log_report_img("submit the approve ", "submit the approve", driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("submit the approve failed.", "submit the approve failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for rejecting a BP quote from IBM GUI
	 * 
	 */
	public void rejectBPquoteinIBM() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			action.waitForElementVisible(driver, IBMQuoteEditor.IBMWithdrawRadio);
			action.clickButton(driver, IBMQuoteEditor.IBMWithdrawRadio, "click the radio Withdraw");

			action.waitForElementVisible(driver, IBMQuoteEditor.IBMApprovesubmit);
			action.clickButton(driver, IBMQuoteEditor.IBMApprovesubmit, "submit Withdraw");
			action.selectDropBoxByVisibleText(driver, IBMQuoteEditor.BPWithrawDropBox,
					Excel_Handling.Get_Data(TC_ID, "BPWithdrawDropBox"), "Select the reason code for Withdraw");

			Thread.sleep(20000);

			Extent_Reporting.Log_report_img("submit the Withdraw ", "submit the Withdraw", driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("submit the Withdraw failed.", "submit the withdraw failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for open addendum report
	 * 
	 * @throws Throwable
	 */
	public void openaddenduminIBM() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			action.waitForElementVisible(driver, IBMQuoteEditor.IBMgetReportAddendum);
			action.clickButton(driver, IBMQuoteEditor.IBMgetReportAddendum, "click the button report addendum");
			Thread.sleep(10000);

			Extent_Reporting.Log_report_img("open the addendum", "open the addendum", driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("open the addendum failed.", "open the addendum failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for check exception text in addendum report
	 * 
	 * @throws Throwable
	 */
	public void checkexceptiontextinaddendum() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			driver.switchTo().activeElement();
			action.waitForElementVisible(driver, IBMQuoteEditor.IBMexceptiontextinAddendum);

			String exceptiontext = action.getInputTextValue(driver, IBMQuoteEditor.IBMexceptiontextinAddendum,
					"IBMexceptiontextinAddendum");
			if (exceptiontext.equalsIgnoreCase("non standard T&Cs test message")) {
				Thread.sleep(2000);

				Extent_Reporting.Log_report_img("get exception text", "get exception text", driver, test);
			} else {
				throw new Exception("get exception text Failed");
			}

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("get exception text failed.", "get exception text failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for check optimal price displayed
	 * 
	 * @throws Throwable
	 */
	public void checkoptimalpricedisplayed() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {

			Thread.sleep(20000);
			boolean display = action.CheckifExist(driver, IBMQuoteEditor.IBMOptimalprice);

			if (display) {

				Extent_Reporting.Log_report_img("check optimal price displayed", "check optimal price displayed",
						driver, test);
			} else {
				throw new Exception("check optimal price displayed Failed");
			}

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("check optimal price displayed failed.", "check optimal price displayed failed.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for clicking on display criteria
	 * 
	 * @throws Throwable
	 */
	public void clickondisplaycriteria() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {

			action.waitForElementVisible(driver, IBMQuoteEditor.IBMdisplaycriteria);
			Thread.sleep(20000);
			action.clickButton(driver, IBMQuoteEditor.IBMdisplaycriteria, "click on display criteria");

			Extent_Reporting.Log_report_img("click on display criteria", "click on display criteria", driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("click on display criteria failed.", "click on display criteria failed.", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for check price displayed in criteria
	 * 
	 * @throws Throwable
	 */
	public void checkpricedisplayedincriteria(String price) throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {

			Select Availablelist = new Select(driver.findElement(By.id("availableColumns")));
			int index = Availablelist.getOptions().size();
			Boolean found = false;
			if (index > 0) {
				for (int i = 0; i < index; i++) {
					Availablelist.deselectAll();
					Availablelist.selectByIndex(i);
					String SSting = Availablelist.getFirstSelectedOption().getText();
					// System.out.println(SSting);
					if (SSting.equals(price)) {
						found = true;
						break;
					} else {
						found = false;
					}
				}
			}

			if (found) {

			} else {
				Select Selectedlist = new Select(driver.findElement(By.id("selectedColumns")));
				int index2 = Selectedlist.getOptions().size();
				if (index2 > 0) {
					for (int i = 0; i < index2; i++) {
						Selectedlist.deselectAll();
						Selectedlist.selectByIndex(i);
						String SSting = Selectedlist.getFirstSelectedOption().getText();
						// System.out.println(SSting);
						if (SSting.equals(price)) {
							found = true;
							break;
						} else {
							found = false;
						}
					}
				}

			}

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("check optimal price displayed failed.", "check optimal price displayed failed.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for approve bp quote
	 * 
	 * @throws Throwable
	 */
	public void settheNonstandTandC() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			action.waitForElementVisible(driver, IBMQuoteEditor.IBMnonstandardTC);
			action.clickButton(driver, IBMQuoteEditor.IBMnonstandardTC, "click the radio non standard T&C");

			driver.switchTo().frame("ui-tinymce-5_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection,
					"non standard T&Cs test message", "commentsSection");
			driver.switchTo().parentFrame();

			Thread.sleep(2000);

			Extent_Reporting.Log_report_img("set nonstanard T&C passed", "set nonstanard T&C passed", driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("submit the approve failed.", "submit the approve failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for check current addendum seleted
	 * 
	 * @throws Throwable
	 */
	public void checkaddendumseleted(String addendumid) throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {
			Thread.sleep(10000);
			action.waitForElementVisible(driver, IBMQuoteEditor.IBMaddendumselectdropdown);
			String text = action.getDropBoxSelectedValue(driver, IBMQuoteEditor.IBMaddendumselectdropdown, 0,
					"get selected value");
			System.out.println("real selected addendum is " + text);
			if (text.equalsIgnoreCase(addendumid)) {
				Extent_Reporting.Log_report_img("the addendum check pass", "the addendum check pass", driver, test);
				Extent_Reporting.Log_Pass("the addendum check pass", "the addendum check pass", test);
			} else {
				throw new Exception();
			}

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("the addendum check fail", "the addendum check fail", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for change tab.
	 * 
	 * @throws Throwable
	 */
	public void addattachementonapproveinIBM() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);

		File attachement = null;
		ClassLoader classLoader = getClass().getClassLoader();

		attachement = new File(classLoader.getResource("attachment.txt").getFile());
		try {
			// action.waitForElementVisible(driver, IBMQuoteEditor.IBMuploadattachment);
			// Thread.sleep(3000);
//			List<WebElement> browsebtn = driver.findElements(By.xpath(IBMQuoteEditor.IBMuploadattachment));
//			for(int i=1;i<=4;i++)
//			{
//				
//			}		

			action.inputText(driver, IBMQuoteEditor.IBMuploadattachment, attachement.getAbsolutePath(),
					"input the attachment path");

			action.clickButton(driver, IBMQuoteEditor.IBMuploadallbutton, "click on uploadall button");
			Thread.sleep(20000);

			Extent_Reporting.Log_report_img("upload attachement successfully", "upload attachement successfully",
					driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("upload attachement failed.", "upload attachement failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for change tab.
	 * 
	 * @throws Throwable
	 */

	public void ComponentViewOverlayClickForNotFoundComponent() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);

		try {
			action.waitForElementClickable(driver, IBMQuoteEditor.TableView);
			action.isElementDisplayed(driver, IBMQuoteEditor.TableView, "Component View Selected");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, IBMQuoteEditor.TableView,
					Excel_Handling.Get_Data(TC_ID, "TableView"), "Component View Selected");
			Thread.sleep(1000);
			Extent_Reporting.Log_report_img("TableView", "Component View Selected", driver, test);

			List<WebElement> e = driver.findElements(By.xpath(IBMQuoteEditor.NotfoundComponentLink));
			for (int i = 0; i <= 2; i++) {
				if (i == 1) {
					e.get(i).click();
					Extent_Reporting.Log_Pass("Not found component clicked.", "Notfound component clicked.", test);
					Extent_Reporting.Log_report_img("Not found component clicked.", "Not found component clicked.",
							driver, test);
					break;
				}
			}

			if (action.isElementDisplayed(driver, IBMQuoteEditor.ListPriceforNotfoundComponent,
					"Not found component Overlay is displayed")) {
				action.inputText(driver, IBMQuoteEditor.ListPriceforNotfoundComponent, "200",
						"List Price for not found component");
			}

			action.waitForElementVisible(driver, IBMQuoteEditor.ApplyButtonClickNotFound);
			action.Javascriptexecutor_forClick(driver, IBMQuoteEditor.ApplyButtonClickNotFound, "Click Apply button");
			Extent_Reporting.Log_Pass("Apply button clicked", "Apply button clicked", test);

			action.Javascriptexecutor_forClick(driver, IBMQuoteEditor.CloseLPApplied, "Close Button Clicked");

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("List price change failed", "List price change failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for set price copra and click apply button.
	 * 
	 * @throws Throwable
	 */
	public void setcoprapriceandapply(String price) throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {

			Thread.sleep(2000);

			action.clearAndInputTextValue(driver, IBMQuoteEditor.PSATBPapprovedpriceonCoprascreen, price,
					"input optimal price price");

			action.clickLinkByLinkText(driver, "Apply Approved Price", "click the button apply");
			action.clickButton(driver,
					".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteprices-page/div/quotepricescopra-page/div/div/div[4]/div[5]/a/strong/button",
					"Apply button");
			Extent_Reporting.Log_report_img("Clicking on pricing ", "Clicking on pricing", driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("pricing not clicked.", "pricing not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for set price copra and click apply button.
	 * 
	 * @throws Throwable
	 */
	public void quickapplyoptimal() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {

			Thread.sleep(2000);

			action.clickButton(driver, IBMQuoteEditor.PSATtotalcheckbox, "check on the checkbox");
			Thread.sleep(2000);
			action.clickButton(driver, IBMQuoteEditor.PSATQuick_apply, "click on the quick apply button");
			Thread.sleep(2000);
			action.clickButton(driver, IBMQuoteEditor.PSATmanualOrPoints, "click the raido price type");
			Thread.sleep(2000);
			action.clickButton(driver, IBMQuoteEditor.PSATOptimalprice, "click on optimal price");
			Thread.sleep(2000);
			action.clickButton(driver, IBMQuoteEditor.PSATPriceapplybutton, "click on apply button");
			Thread.sleep(10000);

			Extent_Reporting.Log_report_img("Clicking on pricing ", "Clicking on pricing", driver, test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("pricing not clicked.", "pricing not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for set check Approved Price is Larger than Optimal Price and
	 * then click apply button.
	 * 
	 * @throws Throwable
	 */
	public void SetApprovedPriceLargerThanOptimalforCopra() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {

			Thread.sleep(2000);
			if (IBMQuoteEditor.ApprovedPriceAmount != IBMQuoteEditor.OptimalPriceAmount) {

				IBMQuoteEditor.ApprovedPriceAmount = IBMQuoteEditor.OptimalPriceAmount + 10;
				action.clickLinkByLinkText(driver, "Apply Approved Price", "click the button apply");

				Extent_Reporting.Log_report_img("Clicking on pricing ", "Clicking on pricing", driver, test);
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("pricing not clicked.", "pricing not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for set check Approved Price is Equals to Optimal Price and
	 * then click apply button.
	 * 
	 * @throws Throwable
	 */
	public void SetApprovedPricEqualsToOptimalforCopra() throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		try {

			Thread.sleep(2000);
			if (IBMQuoteEditor.ApprovedPriceAmount != IBMQuoteEditor.OptimalPriceAmount) {

				action.clearInputTextValue(driver, IBMQuoteEditor.ApprovedPriceAmount, "set approved price");
				action.clickLinkByLinkText(driver, "Apply Approved Price", "click the button apply");

				Extent_Reporting.Log_report_img("Clicking on pricing ", "Clicking on pricing", driver, test);
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("pricing not clicked.", "pricing not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public Boolean isAlertPResent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void CustomerpageinIBMNA() throws Throwable{
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(15000);
			action.waitForPageToLoad(driver);
			
			//action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.searchForACustomer);
			Thread.sleep(5000);
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.searchForACustomer, "searchForACustomer");//EndUserCustomerName
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerIBMCreateAQuotePageObjects.customerSelectionByCompanyName,Excel_Handling.Get_Data(TC_ID, "CompanySearchOnDropdown"), "customerSelectionByCompanyName");
			action.inputText(driver, ePricerIBMCreateAQuotePageObjects.searchForName, Excel_Handling.Get_Data(TC_ID, "Search Customer Name"), "searchForName");
			Thread.sleep(10000);
			//SearchForName
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.searchInternalCustomer, "searchInternalCustomer");
			Thread.sleep(10000);
			if (action.CheckifExist(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue)) {
				Thread.sleep(10000);
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue, "customerPageSaveAndContinue");	
				
			} else {
				Thread.sleep(20000);
				//action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.customerSelectionForInternal );
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerSelectionForInternal, "customerSelectionForInternal");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerSelectionForInternal, "customerSelectionForInternal");
				Thread.sleep(3000);
				action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.selectCustomerClick);
				Thread.sleep(5000);
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.selectCustomerClick, "selectCustomerClick");
				action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue);
				Thread.sleep(10000);
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue, "customerPageSaveAndContinue");	
				
			}
			//customerPageSaveAndContinue
			
			//action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.customerSaveAndContinue, "customerSaveAndContinue");
			Extent_Reporting.Log_report_img("searchCustomer is Successful.", "searchCustomer is Successful.",driver, test);
			Extent_Reporting.Log_Pass("searchCustomer is Successful.", "searchCustomer is Successful.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CustomerpageinIBMNA not clicked.", "CustomerpageinIBMNA not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		
		
	}
	
	public void CustomercontinurebuttoninIBMNA() throws Throwable{
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(5000);
			action.waitForPageToLoad(driver);
			
			
			if (action.checkElementClickable(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue, "save button")) {
				Thread.sleep(10000);
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue, "customerPageSaveAndContinue");	
				
			} else {
				Thread.sleep(10000);
				action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.customerSelectionForInternal );
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerSelectionForInternal, "customerSelectionForInternal");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerSelectionForInternal, "customerSelectionForInternal");
				Thread.sleep(3000);
				action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.selectCustomerClick);
				Thread.sleep(5000);
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.selectCustomerClick, "selectCustomerClick");
				action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue);
				Thread.sleep(10000);
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.customerPageSaveAndContinue, "customerPageSaveAndContinue");	
				
			}
			//customerPageSaveAndContinue
			
			//action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.customerSaveAndContinue, "customerSaveAndContinue");
			Extent_Reporting.Log_report_img("searchCustomer is Successful.", "searchCustomer is Successful.",driver, test);
			Extent_Reporting.Log_Pass("searchCustomer is Successful.", "searchCustomer is Successful.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CustomercontinurebuttoninIBMNA not clicked.", "CustomercontinurebuttoninIBMNA not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");		
			}
		
	}
	
	
	/**
	 * This method is switch the tab to Administration
	 * @throws Throwable
	 */

	public void switchtoAdmintab()  throws Exception
	{
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor  (driver, TC_ID);
		try {
	
			Thread.sleep(20000);
				
				action.clickLinkByLinkText(driver, "Administration", "change the tab to Administration");
				Extent_Reporting.Log_report_img("Clicking on Administration ", "Clicking on Administration",driver, test);
					
			} catch (Throwable e) {
				Extent_Reporting.Log_Fail("Administration not clicked.", "Administration not clicked.", driver, test);
				driver.quit();
				e.printStackTrace();
				throw new Exception("Failed");
			}
	}
	
	
	/*
	 * @jacob: Action on Administration tab
	 * 
	 */
	public void actiononAdmintab(String sign_or_preparecontract) throws Throwable {
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationmaintainofferno);

			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationname, "test","in put test");
			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationothernumberid,"H2JS9", "in put H2JS9");
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationmaintainofferno,"click radio button maintain offer no");
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationsigntypecash,"click radio sign by cash");

			if (sign_or_preparecontract.equalsIgnoreCase("sign")) {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationsigntypecash,"click sign button");
			} else if (sign_or_preparecontract.equalsIgnoreCase("prepare")) {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationpreparecontract,"click prepare button");
			} else {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationsigntypecash,"click sign button");
				// click approve by default
			}

			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabAdministrationsavebutton, "click save");

			Extent_Reporting.Log_report_img("sign or prepare contract pass.","searchCustomer is Successfulsign or prepare contract pass.", driver, test);
			Extent_Reporting.Log_Pass("sign or prepare contract pass.", "sign or prepare contract pass.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sign or prepare contract failed.", "sign or prepare contract failed.", driver,test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}
		
	
	/**
	 * This method is for change bottom line price.
	 * @throws Throwable
	 */
		public boolean checkpricetypeshown(String pricetype, boolean expected)  throws Exception
		{
			IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor  (driver, TC_ID);
			boolean result = false;
			String xpath,getpricetype = "";
			try {
				for (int i = 2; i < 15; i++) {
					xpath = ".//*[@id='priceresultTableHead']/table/thead/tr/th[" + i + "]/span";
					//System.out.println(xpath);
					Thread.sleep(2000);
					try{
						//boolean stringcanbefound = driver.findElement(By.xpath(xpath)).isDisplayed();
					
						if(action.CheckifExist(driver, xpath))
						{
							getpricetype = action.getInputTextValue(driver, xpath, "get price type");
						//	System.out.println("the price type get from web page is " + getpricetype);
						}else{
							 System.out.println("the xpath is not valid, can not get the price from the xpath generated");
						}
						
					} catch (Exception e) {
						 System.out.println("there isn't any block can be switched to");
						 break;
					}if (getpricetype == null) {
						 System.out.println("pricetype is empty");
						break;
					}
					if (getpricetype.equalsIgnoreCase(pricetype)) {
						result = true;
						System.out.println("the price type expected found" + pricetype);
						break;
					}
					
				}
		}catch (Exception e) {
				 System.out.println("there isn't any block can be switched to");
				 System.out.println("the price type expected can not be found" + pricetype);
				
		}
			if(result == expected)
			{
				return true;
			}
			else
			{
				return false;
			}
	
		}
		
		

		/**
		 * This method is to check the status list in the dropdown list.
		 * @throws Throwable
		 */
		public boolean checkchangestatusdisplayed(String statuschecked,Boolean expected)  throws Exception
		{
			IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			boolean checkresult = false;
			String listcontent = null;
			try {
					action.waitForElementVisible(driver, IBMQuoteEditor.IBMChangeStautsRadio);
					Thread.sleep(2000);
					action.clickButton(driver, IBMQuoteEditor.IBMChangeStautsRadio, "click on change status radio");
					Thread.sleep(7000);
					action.waitForElementVisible(driver, IBMQuoteEditor.IBMChangeStautsdropdownlist);
						
					try {
						listcontent = action.getInputTextValue(driver, IBMQuoteEditor.IBMChangeStautsdropdownlist, "get content");
					}
					catch (Exception e) {
					
						listcontent = null;
					}
					System.out.println(listcontent.toString());
					
					if(listcontent.toString().contains(statuschecked))
					{
						checkresult = true;
					}
					else
					{
						checkresult = false;
					}
				
					if (checkresult == expected)
					{
						return true;
					}
					else
					{
						return false;
					}	
		
				} catch (Exception e) {
					return false;
				}
			}
		
		/**
		 * This method is to check the status list in the dropdown list.
		 * @throws Throwable
		 */
		public boolean checkdropdowndisplayed()  throws Exception
		{
			IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			boolean checkresult = false;
			try {
				checkresult = action.isElementDisplayed(driver, IBMQuoteEditor.IBMChangeStautsdropdownlist, "");
				
				} catch (Exception e) {
					return false;
				}
			return checkresult;
			}
		
		/*
		 * @jacob: click the button save and continue
		 * 
		 */
	
		
		/**
		 * This method is for change bottom line price.
		 * @throws Throwable
		 */
			public void clickbuttonDisplaySelectedCriteria()  throws Exception
			{
				IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor  (driver, TC_ID);
				ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
				try {
							
					action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMselectdisplaycritriabutton);
					action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMselectdisplaycritriabutton,"Select total view");
					
					Thread.sleep(5000);
					Extent_Reporting.Log_report_img("click on the  IBMselectdisplaycritriabutton", "click on the  IBMselectdisplaycritriabutton",driver, test);
						
				} catch (Throwable e) {
					Extent_Reporting.Log_Fail("click on the  IBMselectdisplaycritriabutton failed.", "click on the  IBMselectdisplaycritriabutton failed.", driver,test);
					driver.quit();
					e.printStackTrace();
					throw new Exception("Failed");
				}
		}	
			/**
			 * This method is for change bottom line price.
			 * @throws Throwable
			 */
				public boolean checkpricelevelonDisplayCriteriaPage(String pricelevel, boolean expected)  throws Exception
				{
					IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor  (driver, TC_ID);
					ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
					try {
						System.out.println("price level expected " + pricelevel);
						Select Availablelist=new Select(driver.findElement(By.id("availableColumns")));
						int index = Availablelist.getOptions().size();
						Boolean found = false;
						if(index > 0){
						 for(int i = 0; i < index; i++) {
							 Availablelist.deselectAll();
							 Availablelist.selectByIndex(i);
							 String SSting = Availablelist.getFirstSelectedOption().getText();
							 System.out.println(SSting);
							 if (SSting.equalsIgnoreCase(pricelevel))
									 {
								 found = true;
								 break;
							 		 }
							 else {
								 found = false;
							 }
							}
						}
						
						 if (found){
							 
						 }
						 else{
							 Select Selectedlist=new Select(driver.findElement(By.id("selectedColumns")));
								int index2 = Selectedlist.getOptions().size();
								if (index2 > 0){
								 for(int i = 0; i < index2; i++) {
									 Selectedlist.deselectAll();
									 Selectedlist.selectByIndex(i);
									 String SSting = Selectedlist.getFirstSelectedOption().getText();
									 System.out.println(SSting);
									 if (SSting.equalsIgnoreCase(pricelevel))
											 {
										 found = true;
										 break;
									 		 }
									 else {
										 found = false;
									 }
									}
								}
							 }	
				if(found == expected){
					expected = true;
				}
				else{
					expected = false;
				}
									
					} catch (Exception e) {
						expected = false;	
					}
					return expected;
			}
				
		
				/*
				 * @jacob: click the button save and continue
				 * 
				 */
	public void actiononApprovaltabduplicate(String approve_or_reject) throws Throwable {
		try {

			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			if (approve_or_reject.equalsIgnoreCase("approve")) {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove,"click approval button");

			} else if (approve_or_reject.equalsIgnoreCase("reject")) {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioreject,"click reject button");
			} else {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove,"click approval button");
				// click approve by default
			}
			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalLvl1emailid,"test@cn.ibm.com", "input level 1 mail id");
			// boolean SBCshown = action.isElementDisplay(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalSBClist);
			if (action.CheckifExist(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalSBClist)) {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalSBClistoption1,"select 1 SBC code");
			}
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalsubmitbutton,"click submit button");
			Thread.sleep(10000);
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabsubmitcancelnotificationduplicate,"click cancel notification button");
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("click submit button.", "click save button.", driver, test);
			Extent_Reporting.Log_Pass("click save button. passed.", "click save button. passed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("click save button on configuration page failed.","click save button on configuration page failed..", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for change tab.
	 * @throws Throwable  
	 * 
	 * @throws Throwable
	 */
	public boolean checktabunderpricing(String tab, boolean expected) throws Throwable {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		boolean checkresult = false;
		try {
			Thread.sleep(2000);
			if (tab.equalsIgnoreCase("COPRA")) {
				try {
					Thread.sleep(2000);
					// action.clickLinkByLinkText(driver, IBMQuoteEditor.IBMCOPRAlink, "change the
					// tab to COPRA");
					checkresult = action.isElementDisplay(driver, IBMQuoteEditor.IBMCOPRAlink);
				} catch (Exception e) {
					checkresult = false;
				}
			}
			if (tab.equalsIgnoreCase("Prices")) {
				try {
					Thread.sleep(2000);
					// action.clickLinkByLinkText(driver, IBMQuoteEditor.IBMPriceslink, "change the
					// tab to prices");
					checkresult = action.isElementDisplay(driver, IBMQuoteEditor.IBMPriceslink);
				} catch (Exception e) {
					checkresult = false;
				}
			}

			if (tab.equalsIgnoreCase("approval")) {
				try {
					Thread.sleep(10000);
					// action.clickLinkByLinkText(driver, IBMQuoteEditor.IBMapprovelink, "change the
					// tab to approval");
					checkresult = action.isElementDisplay(driver, IBMQuoteEditor.IBMapprovelink);
				} catch (Exception e) {
					checkresult = false;
				}
			}
			if (tab.equalsIgnoreCase("Request approval")) {
				try {
					Thread.sleep(2000);
					// action.clickLinkByLinkText(driver, IBMQuoteEditor.IBMRequestapprovallink,
					// "change the tab to IBMRequestapprovallink");
					checkresult = action.isElementDisplay(driver, IBMQuoteEditor.IBMRequestapprovallink);
					if (isAlertPResent()) {
						action.acceptAlert(driver);
					}

				} catch (Exception e) {
					checkresult = false;
				}
			}

			if (checkresult == expected) {
				checkresult = true;
			} else {
				checkresult = false;
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("click save button on configuration page failed.",
					"click save button on configuration page failed..", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
			
		}

		return checkresult;
	}

	/**
	 * This method is for change bottom line price.
	 * 
	 * @throws Throwable
	 */
	public boolean checkbuttondisplayed(String button, boolean expected) {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);

		boolean checkresult = false;
		try {
			if (button.equalsIgnoreCase("refreshrealcost")) {
				System.out.println("goes into refresh real cost");
				checkresult = action.isElementDisplay(driver, IBMQuoteEditor.IBMrefreshrealcost);
				System.out.println("test check finish refresh real cost");
			}
			if (button.equalsIgnoreCase("exportimport")) {
				System.out.println("goes into export import");
				checkresult = action.isElementDisplay(driver, IBMQuoteEditor.IBMexportimport);
				System.out.println("test check finish export import");
			}
			if (button.equalsIgnoreCase("approvalhistory")) {
				System.out.println("goes into approvalhistory");
				checkresult = action.isElementDisplay(driver, IBMQuoteEditor.IBMexportimport);
				System.out.println("test check finish approvalhistory");
			}
			if (button.equalsIgnoreCase("changestatus")) {
				System.out.println("goes into change status");
				checkresult = action.isElementDisplay(driver, IBMQuoteEditor.IBMChangeStautsRadio);
				System.out.println("test check finish changestatus");
			}

		} catch (Throwable e) {

		}
		System.out.println("check result is " + checkresult);
		if (checkresult == expected) {
			checkresult = true;
		} else {
			checkresult = false;
		}
		return checkresult;
	}

	/**
	 * This method is for change bottom line price.
	 * 
	 * @throws Throwable
	 */
	public boolean checklinkdisplayed(String link, boolean expected) {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);

		boolean checkresult = false;
		try {
			System.out.println("goes into refresh real cost");
			checkresult = driver.findElement(By.linkText(link)).isDisplayed();
			System.out.println("test check finish refresh real cost");

		} catch (Exception e) {

		}
		System.out.println("check result is " + checkresult);
		if (checkresult == expected) {
			checkresult = true;
		} else {
			checkresult = false;
		}
		return checkresult;
	}

	/**
	 * This method is for change status.
	 * 
	 * @throws Throwable
	 */
	public void clickonradiobutton(String button) throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
		try {

			if (button.equalsIgnoreCase("changestatus")) {
				action.waitForElementVisible(driver, IBMQuoteEditor.IBMChangeStautsRadio);
				Thread.sleep(2000);
				action.clickButton(driver, IBMQuoteEditor.IBMChangeStautsRadio, "click on change status radio");
				Thread.sleep(7000);
			}

			Extent_Reporting.Log_report_img("Clicking on save button to change status ",
					"Clicking on save button to change status ", driver, test);
			Extent_Reporting.Log_Pass("change status passed", "change status passed.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("Clicking on save button to change status fail.",
					"Clicking on save button to change status fail.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
						
	/**
	 * This method is for change status.
	 * @throws Throwable
	 */
	public boolean checkdropdwonlistforstatuschange(String dropdown, Boolean displayexpected) throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
		try {
			String listcontent = null;
			boolean displayresult;
			// action.waitForElementVisible(driver,
			// IBMQuoteEditor.IBMChangeStautsdropdownlist);

			try {
				listcontent = action.getInputTextValue(driver, IBMQuoteEditor.IBMChangeStautsdropdownlist,
						"get content");
			} catch (Exception e) {

				listcontent = null;
			}
			System.out.println(listcontent.toString());

			if (listcontent.toString().contains(dropdown)) {
				displayresult = true;
			} else {
				displayresult = false;
			}

			if (displayresult == displayexpected) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {

			return false;
		}
	}

	/**
	 * This method is for change status.
	 * 
	 * @throws Throwable
	 */
	public boolean checktinycedisplayed(Boolean displayexpected) throws Exception {
		IBMQuoteEditor = new Epricer_Application_IBM_QuoteEditor(driver, TC_ID);
		ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
		boolean checkresult = false;
		try {
			System.out.println("goes into refresh real cost");
			driver.switchTo().frame("ui-tinymce-0_ifr");
			checkresult = action.isElementDisplay(driver, ePricerCreateAQuotePageObjects.commentsSection);
			driver.switchTo().parentFrame();
			System.out.println("test check finish refresh real cost");

		} catch (Exception e) {
			checkresult = false;

		}
		if (checkresult == displayexpected) {
			return true;
		} else {
			return false;
		}

	}
	
	public void savecontinueonrequestapprovalpagenonotification() throws Throwable
	{
		try{
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			
			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalsavebutton);
			//action.isElementDisplayed(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalsavebutton, "save button displayed");
			
			driver.switchTo().frame("ui-tinymce-4_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection,"Test", "commentsSection");
			driver.switchTo().parentFrame();
			
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalsavebutton, "click save and continue button");
				
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("click save button.", "click save button.", driver, test);
			Extent_Reporting.Log_Pass("click save button. passed.", "click save button. passed.", test);
		}
	catch (Exception e) {
		Extent_Reporting.Log_Fail("click save button on configuration page failed.", "click save button on configuration page failed..", driver, test);
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
		}
	}
	
	/*
	 * @jacob: click the button save and continue
	 * 
	 */
	public void requestapprovalpagecancelnotification(String dialog) throws Throwable
	{
		try{
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			if (action.CheckifExist(driver, ePricerIBMCreateAQuotePageObjects.IBMtabsubmitcancelnotificationduplicate)) {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabsubmitcancelnotificationduplicate,"click cancel notification button");
			}
			String xpath = ".//*[@id='" + dialog + "']/div[2]/div[1]/div[2]/div[9]/div/p/button[2]";
			
			System.out.println(xpath);
			action.waitForElementClickable(driver, xpath);
			Thread.sleep(10000);
			action.clickButton(driver, xpath, "click cancel notification button");
				
			
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("cancel notification.", "cancel notification.", driver, test);
			Extent_Reporting.Log_Pass("cancel notification. passed.", "ccancel notification. passed.", test);
		}
	catch (Exception e) {
		Extent_Reporting.Log_Fail("cancel notification failed.", "cancel notification page failed.", driver, test);
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
		}
	}
	
	/*
	 * @jacob: click the button save and continue
	 * 
	 */
	public void savecontinueonrequestapprovalpageforduplicatequote() throws Throwable
	{
		try{
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			
			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalsavebutton);		
			driver.switchTo().frame("ui-tinymce-4_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection,"Test", "commentsSection");
			driver.switchTo().parentFrame();			
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalsavebutton, "click save and continue button");			
			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalcancelnotificationforduplicatequote);						
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalcancelnotificationforduplicatequote, "click cancel notification button");
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("click save button.", "click save button.", driver, test);
			Extent_Reporting.Log_Pass("click save button. passed.", "click save button. passed.", test);
		}
	catch (Exception e) {
		Extent_Reporting.Log_Fail("click save button on configuration page failed.", "click save button on configuration page failed.", driver, test);
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
		}
	}
	
	
	
	
	/*
	 * @jacob: click the button save and continue
	 * 
	 */
	public void savecontinueonrequestapprovalpage(String GEO) throws Throwable
	{
		try{
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			
			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalsavebutton);
			action.isElementDisplayed(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalsavebutton, "save button displayed");
			
			if (GEO.equalsIgnoreCase("UK"))
			{
				driver.switchTo().frame("ui-tinymce-5_ifr");
			}
			else{
			driver.switchTo().frame("ui-tinymce-4_ifr");
			}
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection,"Test", "commentsSection");
			driver.switchTo().parentFrame();
			Thread.sleep(5000);
			
			if (GEO.equalsIgnoreCase("LA")){
				System.out.println("LA GUI");
				
				action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ1);
				action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ1, "Q1", "answer Q1");
				action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ2, "Q2", "answer Q2");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ3, "answer Q3");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ4, "answer Q4");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ5, "answer Q5");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ6, "answer Q6");
				action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ7, "Q7", "answer Q7");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ8, "answer Q8");
				action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ9, "Q9", "answer Q9");
				action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ10, "Q10", "answer Q10");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ11, "answer Q11");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ12, "answer Q12");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ13, "answer Q13");
				action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ13_1, "Q13_1", "answer Q13_1");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ14, "answer Q14");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ15, "answer Q15");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ16, "answer Q16");
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ17, "answer Q17");
				action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ18, "Q18", "answer Q18");
				action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMLAQ19, "Q19", "answer Q19");
				
			}
			
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalsavebutton, "click save and continue button");
			
			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalcancelnotification);
			action.isElementDisplayed(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalcancelnotification, "save button displayed");
			
			
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabrequestapprovalcancelnotification, "click cancel notification button");
				
			
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("click save button.", "click save button.", driver, test);
			Extent_Reporting.Log_Pass("click save button. passed.", "click save button. passed.", test);
		}
	catch (Exception e) {
		Extent_Reporting.Log_Fail("click save button on configuration page failed.", "click save button on configuration page failed..", driver, test);
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
		}
	}
	
	/*
	 * @jacob: click the button save and continue
	 * 
	 */
	public void actiononApprovaltabnonotification(String approve_or_reject) throws Throwable
	{
		try{
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
	
			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove);
			action.isElementDisplayed(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove, "save button displayed");
			
			if(approve_or_reject.equalsIgnoreCase("approve"))
			{
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove, "click approval button");				
			}
			else if(approve_or_reject.equalsIgnoreCase("reject")){
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioreject, "click reject button");
				}
			else{
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove, "click approval button");
				// click approve by default
			}
			
			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalLvl1emailid, "test@cn.ibm.com", "input level 1 mail id");
			Thread.sleep(6000);
		//	boolean SBCshown = action.isElementDisplay(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalSBClist);
			if(action.CheckifExist(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalSBClist))
			{
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalSBClistoption1, "select 1 SBC code");
			}			
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalsubmitbutton, "click submit button");
			Thread.sleep(5000);
			
			Extent_Reporting.Log_report_img("click submit button.", "click save button.", driver, test);
			Extent_Reporting.Log_Pass("click save button. passed.", "click save button. passed.", test);		
		}
	catch (Exception e) {
		Extent_Reporting.Log_Fail("click save button on configuration page failed.", "click save button on configuration page failed..", driver, test);
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
		}
	}
	
	public void actiononApprovaltabcancelnotification(String ngdialog) throws Throwable
	{
		try{
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			String xpath = ".//*[@id='" + ngdialog + "']/div[2]/div[1]/div[2]/div[9]/div/p/button[2]";
			Thread.sleep(9000);
			action.clickButton(driver, xpath, "click cancel notification button");
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("click cancel notification button.", "click cancel notification button.", driver, test);
			Extent_Reporting.Log_Pass("click cancel notification button. passed.", "click cancel notification button. passed.", test);
			}
	catch (Exception e) {
		Extent_Reporting.Log_Fail("click cancel notification button on configuration page failed.", "click cancel notification button on configuration page failed..", driver, test);
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
		}
	}
	
	/*
	 * @jacob: Create quote link for IBM
	 * 
	 */
	public void FilterOnGoingonMyQuote() throws Exception{
		
		ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
		
		Thread.sleep(5000);
		try {
			action.clickButton(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/myquotes-page/div/div[2]/div[3]/div[1]/table[2]/tbody/tr[5]/td/span[1]/span[3]", "");
			Thread.sleep(5000);
			action.clickButton(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/myquotes-page/div/div[2]/div[3]/div[1]/table[2]/tbody/tr[5]/td/span[2]/span/table/tbody/tr[1]/td[1]/input", "");
		
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("filter failed.", "filter failed.", driver, test);
		
		}
}

	//CDT DEV has different SDE codes from CDT MAINT
	public void actiononApprovaltabCDTDEV(String approve_or_reject) throws Throwable {
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementClickable(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove);

			if (approve_or_reject.equalsIgnoreCase("approve")) {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove,
						"click approval button");

			} else if (approve_or_reject.equalsIgnoreCase("reject")) {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioreject,
						"click reject button");
			} else {
				action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalradioapprove,
						"click approval button");
			}

			action.clearAndInputTextValue(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalLvl1emailid,
					"test@in.ibm.com", "input level 1 mail id");
			Thread.sleep(5000);
			if (action.CheckifExist(driver, nAIBMCreateAQuotePageObjects.specialBidCode)) {
				action.selectDropBoxByVisibleText(driver, nAIBMCreateAQuotePageObjects.specialBidCode,"R,Not applicable – Rejected quote", "specialBidCode");
			}			
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabapprovalsubmitbutton,
					"click submit button");

			Thread.sleep(5000);
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMtabsubmitcancelnotification,
					"click cancel notification button");
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("click submit button.", "click save button.", driver, test);
			Extent_Reporting.Log_Pass("click save button. passed.", "click save button. passed.", test);

		} catch (Exception e) {			
			Extent_Reporting.Log_Fail("click save button on configuration page failed.","click save button on configuration page failed..", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

}



