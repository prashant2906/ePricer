package com.ibm.stax.BusinessLogic;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Login_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

public class CFR_With_TSS_Components_Business_Logic {
	ElementAction action = new ElementAction();
	Common_Functions Function = new Common_Functions();
	public WebDriver driver;
	public String TC_ID;
	public static String quoteIdForTestData;
	Epricer_Application_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuote = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;
	Epricer_Application_Login_PageObjects ePricerLoginPageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = null;
	private ExtentTest test;

	public CFR_With_TSS_Components_Business_Logic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for clicking createANewQuoteLinkClick.
	 * 
	 * @throws Throwable
	 */
	public void uploadCFRForm() throws Throwable {
		try {
			File cfr = null;
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ClassLoader classLoader = getClass().getClassLoader();

			cfr = new File(classLoader.getResource("SSG1TSS4yr.cfr").getFile());

			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr.getAbsolutePath());

			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.disableChecksumChkbox,
					"disableChecksumChkbox");
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.workWithOtherCountryCFRChkbox,
					"workWithOtherCountryCFRChkbox");

			if (action.CheckifExist(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn)) {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
			} else {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtnDEV, "uploadCFRBtnDEV");
			}
			Extent_Reporting.Log_report_img("uploadCFR Successfully done.", "uploadCFR Successfully done.", driver,
					test);
			Extent_Reporting.Log_Pass("uploadCFR Successfully done.", "uploadCFR Successfully done.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CFR Upload Failed.", "CFR Upload Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void dataForEPricerOverviewScreenTab() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			/*
			 * boolean isTitleClickable =
			 * createAQuoteBusinessLogic.checkElementClickableFluent(driver,
			 * ePricerCreateAQuotePageObjects.quoteTitle, "quoteTitle"); // TODO - log pass
			 * messsage Extent_Reporting.Log_Pass(isTitleClickable
			 * +"Element is clickable or not.", isTitleClickable +
			 * "Element is clickable or not."); if(isTitleClickable) {
			 * action.inputText(driver, ePricerCreateAQuotePageObjects.quoteTitle,
			 * Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "quoteTitle");
			 * Extent_Reporting.Log_report_img("QuoteTitle entered in 1st Time.",
			 * "QuoteTitle entered in 1st Time.", driver); }else {
			 * driver.navigate().refresh(); action.handleAlert(driver);
			 * Extent_Reporting.Log_report_img("Page Refreshed.", "Page Refreshed.",
			 * driver); loginBusinessLogic.ePricerLoginscreen();
			 * loginBusinessLogic.ePRICERMainScreen();
			 * 
			 * createAQuoteBusinessLogic.createANewQuoteLinkClick();
			 * createAQuoteBusinessLogic.overviewPolygonScreen();
			 * 
			 * action.inputText(driver, ePricerCreateAQuotePageObjects.quoteTitle,
			 * Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "quoteTitle");
			 * Extent_Reporting.Log_report_img("QuoteTitle entered in 2nd time.",
			 * "QuoteTitle entered in 2nd time.", driver); }
			 */

			Thread.sleep(10000);
			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.selectBidType,
					Excel_Handling.Get_Data(TC_ID, "SelectBidType"), "SelectBidType");
			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.Countryonoverview,
					Excel_Handling.Get_Data(TC_ID, "Countryonoverview"), "Country");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.saveOverviewButton,
					"saveOverviewButton");

			Extent_Reporting.Log_report_img("dataForEPricerOverviewScreenTab provided.",
					"dataForEPricerOverviewScreenTab provided.", driver, test);
			Extent_Reporting.Log_Pass("dataForEPricerOverviewScreenTab provided.",
					"dataForEPricerOverviewScreenTab provided.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("dataForEPricerOverviewScreenTab not provided.",
					"dataForEPricerOverviewScreenTab not provided.", driver, test);
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

	public void checkAddFeatureEnable() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			if (action.isElementEnabled(driver, ePricerUpdateAQuotePageObjects.addFeatureBtn, "addFeatureBtn"))

				Extent_Reporting.Log_Pass("AddFeatureEnable button is Enabled.", "AddFeatureEnable button is Enabled.",
						test);

			else {
				Extent_Reporting.Log_Fail("AddFeatureEnable button is not Enabled.",
						"AddFeatureEnable button is not Enabled.", driver, test);
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("AddFeatureEnable button is not Enabled.",
					"AddFeatureEnable button is not Enabled.", driver, test);
			driver.quit();
			e.printStackTrace();
		}
	}

	public void clickOnSubmitPriceRequestPolygon() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			action.clickButton(driver, ePricerUpdateAQuotePageObjects.submitPriceRequestPolygon,
					"submitPriceRequestPolygon");
			Extent_Reporting.Log_Pass("submitPriceRequestPolygon button is Clicked.",
					"submitPriceRequestPolygon button is Clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("submitPriceRequestPolygon button is not Clicked.",
					"submitPriceRequestPolygon button is not Clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
		}

	}

	public void quoteIdFetchedAndDataSavedInExcelTSS() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			driver.switchTo().parentFrame();
			List<WebElement> e = driver
					.findElements(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.quoteId));
			for (int i = 0; i <= 10; i++) {
				if (i == 0) {
					quoteIdForTestData = e.get(i).getText();
					Extent_Reporting.Log_report_img("quoteId Fetched.", "quoteId Fetched.", driver, test);
					Extent_Reporting.Log_Pass("quoteId Fetched.", "quoteId Fetched.", test);
					Excel_Handling.Put_Data("CFR_With_TSS_Components", "EnterQuoteid", quoteIdForTestData);
					System.out.println(Excel_Handling.Get_Data("CFR_With_TSS_Components", "EnterQuoteid"));

					break;
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteId not Fetched.", "quoteId not Fetched.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void openIBMGUI() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
						
			driver.switchTo().frame("ui-tinymce-0_ifr");
			action.inputText(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.mailBody,"test", "commentSection");
			Extent_Reporting.Log_Pass("mailBody is displayed", "mailBody is displayed", test);
			driver.switchTo().parentFrame();

			action.selectCheckBox(driver, ePricerUpdateAQuotePageObjects.removeFromHold, "RemoveFromHold");
			Extent_Reporting.Log_Pass("removeFromHold is displayed", "removeFromHold is displayed", test);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.applyButton, "applyButton");
			Extent_Reporting.Log_Pass("applyButton clicked.", "applyButton clicked.", test);			

			Thread.sleep(7000);

			if (action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.reportsLettersTab,"reportsLettersTab is displayed.")) {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.reportsLettersTab,"reportsLettersTab");
				Extent_Reporting.Log_Pass("reportsLettersTab is displayed", "reportsLettersTab is displayed", test);
				Thread.sleep(5000);
			} else {
				Extent_Reporting.Log_Fail("reportsLettersTab not clicked.", "reportsLettersTab not clicked.", driver,test);
				driver.quit();
				throw new Exception("Failed");
			}

			driver.close();
			Extent_Reporting.Log_Pass("iBMGui Opened", "iBMGui Opened", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMGui not Opened", "iBMGui not Opened", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}
}
