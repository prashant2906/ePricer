package com.ibm.stax.BusinessLogic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

public class Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic {

	private ExtentTest test;
	private ElementAction action = new ElementAction();
	public WebDriver driver;
	public String TC_ID;
	Epricer_Application_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;
	
	public Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for dataForEPricerOverviewScreen
	 * 
	 * @throws Throwable
	 */
	public void dataForEPricerOverviewScreenTab() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			Thread.sleep(40000);
			action.waitForPageToLoad(driver);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.selectCountry);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.quoteTitle);
			boolean isTitleClickable = createAQuoteBusinessLogic.checkElementClickableFluent(driver,
					ePricerCreateAQuotePageObjects.quoteTitle, "quoteTitle");
			// TODO - log pass messsage
			Extent_Reporting.Log_Pass(isTitleClickable + "Element is clickable or not.",
					isTitleClickable + "Element is clickable or not.", test);
			if (isTitleClickable) {
				action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.quoteTitle);
				action.inputText(driver, ePricerCreateAQuotePageObjects.quoteTitle,
						Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "quoteTitle");

			} else {
				driver.navigate().refresh();
				action.handleAlert(driver);
				Extent_Reporting.Log_report_img("Page Refreshed.", "Page Refreshed.", driver, test);
				loginBusinessLogic.ePricerLoginscreen();
				loginBusinessLogic.ePRICERMainScreen();

				createAQuoteBusinessLogic.createANewQuoteLinkClick();
				createAQuoteBusinessLogic.overviewPolygonScreen();

				action.inputText(driver, ePricerCreateAQuotePageObjects.quoteTitle,
						Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "quoteTitle");
				Extent_Reporting.Log_report_img("QuoteTitle entered in 2nd time.", "QuoteTitle entered in 2nd time.",
						driver, test);
			}

			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.selectBidType,
					"Managed Services Offering", "SelectBidType");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.saveOverviewButton,
					"saveOverviewButton");

			Extent_Reporting.Log_report_img("save and Continue button clicked.", "save and Continue button clicked.",
					driver, test);
			Extent_Reporting.Log_Pass("QuoteTitle entered and save and Continue button clicked.",
					"QuoteTitle entered and save and Continue button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("QuoteTitle entered and save and Continue button not clicked.",
					"QuoteTitle entered and save and Continue button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
		}
	}

	public void dataForEPricerOverviewWithoutQuoteTitle() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(2000);
			if (action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.selectBidType, "selectBidType")) {
				action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.selectBidType,
						Excel_Handling.Get_Data(TC_ID, "SelectBidType"), "SelectBidType");
				Extent_Reporting.Log_report_img("selectBidType selected.", "selectBidType selected.", driver, test);
				Extent_Reporting.Log_Pass("selectBidType selected.", "selectBidType selected.", test);
			} else {
				Extent_Reporting.Log_Fail("selectBidType not selected.", "selectBidType not selected.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, 1);
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
			String strDate= formatter.format(c.getTime());  
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");

			if (action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.saveOverviewButton,
					"saveOverviewButton")) {
				action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.saveOverviewButton,
						"saveOverviewButton");
				Extent_Reporting.Log_report_img("save and Continue button clicked.",
						"save and Continue button clicked.", driver, test);
				Extent_Reporting.Log_Pass("dataForEPricerOverviewWithoutQuoteTitle Provided.",
						"dataForEPricerOverviewWithoutQuoteTitle Provided.", test);
			} else {
				Extent_Reporting.Log_Fail("save and Continue button is not clicked",
						"save and Continue button is not clicked", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("dataForEPricerOverviewWithoutQuoteTitle not Provided.",
					"dataForEPricerOverviewWithoutQuoteTitle not Provided.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void searchCustomerButtonClick() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(4000);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.searchCustomer, "searchCustomer");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("searchCustomer button clicked.", "searchCustomer button clicked.", driver,
					test);
			Extent_Reporting.Log_Pass("searchCustomer button clicked.", "searchCustomer button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("searchCustomer button not clicked.", "searchCustomer button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
		}
	}

	public void dataForSearchCustomerScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(3000);

			action.inputText(driver, ePricerCreateAQuotePageObjects.searchCustomerName,
					Excel_Handling.Get_Data(TC_ID, "Search Customer Name"), "Search Customer Name");
			Extent_Reporting.Log_report_img("Search Customer Name entered.", "Search Customer Name entered.", driver,
					test);

			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.searchCustomerButton));

			for (int i = 0; i <= 14; i++) {
				if (i == 1) {
					e.get(i).click();
					Extent_Reporting.Log_report_img("search btn clicked.", "search btn clicked.", driver, test);
					break;
				}
			}
			action.waitForPageToLoad(driver);
			Thread.sleep(9000);
			action.selectRadio(driver, ePricerCreateAQuotePageObjects.searchCustomerNumber, "selectedCustomer");
			Thread.sleep(1000);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.finalSelectCustomer,
					"Final Select Customer");
			Thread.sleep(10000);

			Extent_Reporting.Log_report_img("search Customer Button clicked.", "search Customer button clicked.",
					driver, test);
			Extent_Reporting.Log_Pass("search Customer button clicked.", "search Customer button clicked.", test);

			/*
			 * action.inputText(driver, ePricerCreateAQuotePageObjects.CEID,
			 * Excel_Handling.Get_Data(TC_ID, "CEID"), "CEID"); action.inputText(driver,
			 * ePricerCreateAQuotePageObjects.BPCompanyName, Excel_Handling.Get_Data(TC_ID,
			 * "BPCompanyName"), "BPCompanyName");
			 */
			Thread.sleep(4000);

			List<WebElement> g = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));

			for (int i = 0; i <= 14; i++) {
				if (i == 2) {
					g.get(i).click();
					Extent_Reporting.Log_report_img("save btn clicked.", "save btn clicked.", driver, test);
					Extent_Reporting.Log_Pass("saveOverviewButton clicked.", "saveOverviewButton clicked.", test);
					break;
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("search Customer button not clicked.", "search Customer button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
		}
	}

	/*-------------------*********************__________________________*/

	public void clickOnSearchQuote() throws Throwable {
		ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
		Thread.sleep(3000);
		action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.searchQuote);
		try {
			Extent_Reporting.Log_report_img("Clicking on searchQuoteLink ", "Clicking on searchQuoteLink", driver,
					test);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.searchQuote,
					"searchQuoteLink Tab");
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.searchField);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.searchField, "Search Field is displayed.");

			action.inputText(driver, ePricerCreateAQuotePageObjects.searchField,
					Excel_Handling.Get_Data(TC_ID, "ExpiredValueQuote"), "SearchQuote");

			action.selectCheckBox(driver, ePricerCreateAQuotePageObjects.checkBox, "Check Box");
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.searchButton, "SearchButton");
			Thread.sleep(1000);
			action.selectCheckBox(driver, ePricerCreateAQuotePageObjects.selectQuoteCheckBox, "selectQuoteCheckBox");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerCreateAQuotePageObjects.quoteActions,
					Excel_Handling.Get_Data(TC_ID, "QuoteActionCheckBox"), "QuoteActionCheckBox");
			Thread.sleep(2000);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.goButton, "Go Button");
			Thread.sleep(2000);
			action.acceptAlert(driver);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("searchQuoteLink not clicked.", "searchQuoteLink not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
		}
	}
}
