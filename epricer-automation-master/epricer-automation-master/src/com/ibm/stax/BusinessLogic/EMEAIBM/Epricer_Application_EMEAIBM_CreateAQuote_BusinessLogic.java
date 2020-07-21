/**
 * @author Neha Upadhyay
 *
 */
package com.ibm.stax.BusinessLogic.EMEAIBM;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.PageObjects.Epricer_Application_Change_Configuration_Quantity_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

public class Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic {

	ElementAction action = new ElementAction();
	Common_Functions Function = new Common_Functions();
	public WebDriver driver;
	public String TC_ID;
	public static String quoteIdForTestData;
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;
	Epricer_Application_CreateAQuote_NotRequiring_BusinessLogic createAQuoteNotRequiringBusinessLogic = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = null;
	Epricer_Application_Change_Configuration_Quantity_PageObjects ePricerChangeConfigurationPageObjects = null;
	private ExtentTest test;

	public Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/*
	 * @Abhishek: Create quote link for IBM EMEA
	 * 
	 */
	public void createQuoteLink() throws Exception {

		ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
		action.waitForElementVisible(driver, ePricerEMEAIBMCreateAQuotePageObjects.ibmEMEACreateQuoteLink);
		Thread.sleep(5000);
		try {
			Extent_Reporting.Log_report_img("Clicking on ibmEMEACreateQuoteLink ", "Clicking on ibmEMEACreateQuoteLink",
					driver, test);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.ibmEMEACreateQuoteLink,
					"ibmEMEACreateQuoteLink Tab");
			action.waitForPageToLoad(driver);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("ibmEMEACreateQuoteLink not clicked.", "ibmEMEACreateQuoteLink not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void ibmEMEAOverviewScreenData(String env) throws Exception {

		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			
			action.waitForPageToLoad(driver);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.requesterPhone);
			boolean isTitleClickable = action.checkElementClickableFluent(driver,
					ePricerEMEAIBMCreateAQuotePageObjects.requesterPhone, "requesterPhone");
			Extent_Reporting.Log_Pass(isTitleClickable + "Element is clickable or not.",
					isTitleClickable + "Element is clickable or not.", test);
			if (isTitleClickable) {
				action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.selectCountryDropDown,
						Excel_Handling.Get_Data(TC_ID, "Countryonoverview"), "Country");
				action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.requesterPhone);
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.requesterPhone,
						Excel_Handling.Get_Data(TC_ID, "ContactPhone"), "requesterPhone");
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.quoteTitleInternal,
						Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "quoteTitleInternal");
				action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.opportunityId);
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.opportunityId,
						Excel_Handling.Get_Data(TC_ID, "IBMUniqueID"), "opportunityId");
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.opportunityOwnerEmail,
						Excel_Handling.Get_Data(TC_ID, "ContactEmail"), "opportunityOwnerEmail");
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.opportunityOwnerName,
						Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "opportunityOwnerName");

				action.selectDropBoxByVisibleText(driver,
						ePricerEMEAIBMCreateAQuotePageObjects.selectChannelIndicatorDropDown,
						Excel_Handling.Get_Data(TC_ID, "SelectChannelIndicatorDropDown"),
						"selectChannelIndicatorDropDown");
				action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.selectSolutionType,
				Excel_Handling.Get_Data(TC_ID, "SelectSolutionType"), "selectSolutionType");
				Calendar c = Calendar.getInstance();
				c.add(Calendar.MONTH, 1);
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
				String strDate= formatter.format(c.getTime());  
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");
				// Opportunity Id
				Extent_Reporting.Log_Pass("requesterPhone entered in 1st Time.",
						"requesterPhone entered in 1st Time.", test);
			} else {
				driver.navigate().refresh();
				action.handleAlert(driver);
				Extent_Reporting.Log_report_img("Page Refreshed.", "Page Refreshed.", driver, test);
				loginBusinessLogic.ePricerLoginscreen();
				loginBusinessLogic.ePRICERMainScreen();
				createQuoteLink();
				createAQuoteBusinessLogic.overviewPolygonScreen();

				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.requesterPhone,
						Excel_Handling.Get_Data(TC_ID, "ContactPhone"), "requesterPhone");
				Extent_Reporting.Log_report_img("requesterPhone entered in 2nd time.",
						"requesterPhone entered in 2nd time.", driver, test);
			}

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.saveOverviewButton,
					"saveOverviewButton");

			Extent_Reporting.Log_report_img("save and Continue button clicked.", "save and Continue button clicked.",
					driver, test);
			Extent_Reporting.Log_Pass("OverviewData entered and save and Continue button clicked.",
					"OverviewData entered and save and Continue button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("RequesterPhone entered and save and Continue button not clicked.",
					"RequesterPhone entered and save and Continue button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void searchCustomer() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchForACustomer);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchForACustomer,
					"searchForACustomer");// EndUserCustomerName
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerEMEAIBMCreateAQuotePageObjects.customerSelectionByCompanyName,
					Excel_Handling.Get_Data(TC_ID, "CompanySearchOnDropdown"), "customerSelectionByCompanyName");
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchForName,
					Excel_Handling.Get_Data(TC_ID, "Search Customer Name"), "searchForName");

			// SearchForName
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchInternalCustomer,
					"searchInternalCustomer");
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.customerSelectionForInternal);
			action.Javascriptexecutor_forClick(driver,
					ePricerEMEAIBMCreateAQuotePageObjects.customerSelectionForInternal, "customerSelectionForInternal");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.selectCustomerClick,
					"selectCustomerClick");
			action.Javascriptexecutor_forClick(driver,
					ePricerEMEAIBMCreateAQuotePageObjects.customerPageSaveAndContinue, "customerPageSaveAndContinue");
			Extent_Reporting.Log_report_img("searchCustomer is Successful.", "searchCustomer is Successful.", driver, test);
			Extent_Reporting.Log_Pass("searchCustomer is Successful.", "searchCustomer is Successful.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("RequesterPhone entered and save and Continue button not clicked.",
					"RequesterPhone entered and save and Continue button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	public void manageConfigurationInternalPolygonScreen() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			Thread.sleep(10000);
			action.waitForElementVisible(driver,
					ePricerEMEAIBMCreateAQuotePageObjects.mnageInternaConfigurationPolygon);
			action.isElementDisplayed(driver, ePricerEMEAIBMCreateAQuotePageObjects.mnageInternaConfigurationPolygon,
					"Manage Internal Configuration Polygon is displayed.");

			Extent_Reporting.Log_report_img("Manage Internal Configuration Polygon is displayed.",
					"Manage Internal Configuration Polygon is displayed.", driver, test);
			Extent_Reporting.Log_Pass("Manage Internal Configuration Polygon is displayed.",
					"Manage Internal Configuration Polygon is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Manage Internal Configuration Polygon is not displayed.",
					"Manage Internal Configuration Polygon is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void uploadInternalCFR() throws Exception {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			ClassLoader classLoader = getClass().getClassLoader();
			File cfr = new File(classLoader.getResource("PWR1TSS3yr_Ed.cfr").getFile());
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr.getAbsolutePath());

			action.waitForPageToLoad(driver);

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.disableChecksum,
					"disableChecksum");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.workWithOtherCountryCFR,
					"workWithOtherCountryCFR");
			Thread.sleep(3000);

			if (action.CheckifExist(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn)) {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
			} else {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtnDEV, "uploadCFRBtnDEV");
			}
			Thread.sleep(3000);
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("uploadCFR Successfully done.", "uploadCFR Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("uploadCFR Successfully done.", "uploadCFR Successfully done.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CFR Upload Failed.", "CFR Upload Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			
			throw new Exception("Failed");
		}

	}

	public void configurationSaveAndClick() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(30000);

			List<WebElement> e = driver.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.configurationSaveButton));
			for (int i = 1; i <= 4; i++) {
				if (i == 1) {
					Thread.sleep(4000);
					e.get(i).click();
					Thread.sleep(4000);
					action.waitForPageToLoad(driver);
					Extent_Reporting.Log_report_img("save and Continue button clicked.","save and Continue button clicked.", driver, test);
					Extent_Reporting.Log_Pass("save and Continue button clicked. clicked.","save and Continue button clicked. clicked.", test);
					break;
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("save and Continue button not clicked.", "save and Continue button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void pricingScreenData() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);
			action.waitForElementVisible(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices);
			Thread.sleep(10000);
			action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices, "pricingPrices");

			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingCheckBoxClick);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingCheckBoxClick,
					"pricingCheckBoxClick");
			Extent_Reporting.Log_Pass("pricingCheckBoxClick Successfully done.", "pricingCheckBoxClick Successfully done.", test);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyButton);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyButton,
					"quickApplyButton");
			Thread.sleep(7000);
			action.waitForPageToLoad(driver);
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyField,
					Excel_Handling.Get_Data(TC_ID, "RequestedEndUserDiscount"), "QuickApplyField");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.applyAfterDiscount,
					"applyAfterDiscount");// requestApproval
			Extent_Reporting.Log_Pass("applyAfterDiscount Successfully done.", "applyAfterDiscount Successfully done.", test);
			
			Thread.sleep(9000);
			if (action.isAlertPresent(driver)) {
				action.acceptAlert(driver);
			}			
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("pricingScreenData Successfully done.",	"pricingScreenData Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("pricingScreenData Successfully done.", "pricingScreenData Successfully done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("pricing screen not completed", "pricing screen not completed", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	public void selectCreateNewCustomer() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.newCustomerToIBM);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.newCustomerToIBM,
					"NewCustomerToIBM");// EndUserCustomerName
			action.acceptAlert(driver);
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.endUserCustomerName,
					Excel_Handling.Get_Data(TC_ID, "EndUserCustomerName"), "EndUserCustomerName");
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.nonLegacyCustomerNumberField,
					"00" + Excel_Handling.Get_Data(TC_ID, "NonLegacyCustomerNumberField"),
					"NonLegacyCustomerNumberField");
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.affiliateNumberField,
					Excel_Handling.Get_Data(TC_ID, "AffiliateNumberField"), "AffiliateNumberField");
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cMRNumberField,
					Excel_Handling.Get_Data(TC_ID, "CMRNumberField"), "CMRNumberField");

			Thread.sleep(1000);
			action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.regionField,
					Excel_Handling.Get_Data(TC_ID, "RegionField"), "RegionField");
			action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.coverageModelField,
					Excel_Handling.Get_Data(TC_ID, "CoverageModelField"), "CoverageModelField");
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.coverageIDField,
					Excel_Handling.Get_Data(TC_ID, "CoverageIDField"), "CoverageIDField");

			action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.industryClassificationField,
					Excel_Handling.Get_Data(TC_ID, "IndustryClassificationField"), "IndustryClassificationField");
			action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.iNACSIANumberTypeField,
					Excel_Handling.Get_Data(TC_ID, "INA CSIA NumberTypeField"), "INA CSIA NumberTypeField");

			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.iNACSIANumberField,
					Excel_Handling.Get_Data(TC_ID, "INACSIANumberField"), "INACSIANumberField");

			action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.customerTypeField,
					Excel_Handling.Get_Data(TC_ID, "CustomerTypeField"), "CustomerTypeField");
			Thread.sleep(6000);
			List<WebElement> e = driver
					.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.saveAndContinueButton));
			for (int i = 1; i <= 4;) {
				if (i == 1) {
					e.get(i).click();
					Extent_Reporting.Log_report_img("save and Continue button clicked.",
							"save and Continue button clicked.", driver, test);
					Extent_Reporting.Log_Pass("save and Continue button clicked. clicked.",
							"save and Continue button clicked. clicked.", test);
					break;
				} else {
					Extent_Reporting.Log_Fail("save and Continue button not clicked.",
							"save and Continue button not clicked.", driver, test);
					throw new Exception("Failed");
				}
			}

			Extent_Reporting.Log_report_img("CreateNewCustomer Successfully done.",
					"CreateNewCustomer Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("CreateNewCustomer Successfully done.", "CreateNewCustomer Successfully done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CreateNewCustomern not completed", "CreateNewCustomer not completed", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	public void requestApproval() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.waitForPageToLoad(driver);
			Thread.sleep(5000);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.requestApproval);
			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.requestApproval,
					"requestApproval");

			action.handleAlert(driver);
			action.waitForPageToLoad(driver);
			Thread.sleep(15000);

			// applyAfterDiscount
			List<WebElement> e = driver.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.configurationSaveButton));
			for (int i = 1; i <= 4;) {
				if (i == 1) {
					e.get(i).click();
					Thread.sleep(6000);
					action.handleAlert(driver);
					Extent_Reporting.Log_report_img("save and Continue button clicked.","save and Continue button clicked.", driver, test);
					Extent_Reporting.Log_Pass("save and Continue button clicked. clicked.","save and Continue button clicked. clicked.", test);
					break;
				} else {
					Extent_Reporting.Log_Fail("save and Continue button not clicked.","save and Continue button not clicked.", driver, test);
					throw new Exception("Failed");
				}
			}
			action.waitForPageToLoad(driver);
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.enterEmailAddress,
					Excel_Handling.Get_Data(TC_ID, "addToListMailId"), "addToListMailId");
			Thread.sleep(5000);

			List<WebElement> d = driver.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.addToButton));
			for (int k = 2; k <= 4;) {
				if (k == 2) {
					d.get(k).click();
					Thread.sleep(5000);
					Extent_Reporting.Log_report_img("Add To button clicked.", "Add To button clicked.", driver, test);
					Extent_Reporting.Log_Pass("Add To button clicked.", "Add To button clicked.", test);
					break;
				} else {
					Extent_Reporting.Log_Fail("Add To button not clicked.", "Add To button not clicked.", driver, test);
					throw new Exception("Failed");
				}
			}
			action.waitForPageToLoad(driver);
			Thread.sleep(9000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.sendEmailButton,
					"sendEmailButton");
			action.waitForPageToLoad(driver);
			action.acceptAlert(driver);
			Thread.sleep(10000);
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("sendMail Button Clicked", "sendMail Button Clicked", driver, test);
			Extent_Reporting.Log_Pass("sendMail Button Clicked", "sendMail Button Clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendMail Button not Clicked", "sendMail Button not Clicked", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");

		}

	}

	public void relogin() {
		driver.navigate().refresh();
	}

	public void clickOnIBMSearchQuote(String ColumnNameForQuoteID) throws Exception {
		ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
		ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
		Thread.sleep(9000);
		action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.searchQuote);
		try {
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.searchQuote,	"searchQuoteLink Tab");
			Thread.sleep(7000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.searchField);
			
			action.inputText(driver, ePricerCreateAQuotePageObjects.searchField,Excel_Handling.Get_Data(TC_ID, ColumnNameForQuoteID), "SearchQuote");

			Thread.sleep(20000);
			List<WebElement> e = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.searchQuoteButton));
			if (e != null) {
				for (int i = 0; i <= 14; i++) {
					if (i == 3) {
						e.get(i).click();
						action.waitForPageToLoad(driver);
						Extent_Reporting.Log_Pass("searchQuoteButton is displayed", "searchQuoteButton is displayed", test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Fail("searchQuoteButton is not displayed", "searchQuoteButton is not displayed",driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			action.waitForPageToLoad(driver);
			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("IBMSearchQuote Successfully done.", "IBMSearchQuote Successfully done.",driver, test);
			Extent_Reporting.Log_Pass("IBMSearchQuote Successfully done.", "IBMSearchQuote Successfully done.", test);
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("searchQuoteLink not clicked.", "searchQuoteLink not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void getQuoteIdandSaveInDatasheet() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			driver.switchTo().parentFrame();
			List<WebElement> e = driver.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.quoteIdIBM));
			for (int i = 1; i <= 10;) {
				if (i == 1) {
					quoteIdForTestData = e.get(i).getText();
					Excel_Handling.Put_Data(TC_ID, "ExpiredValueQuote", quoteIdForTestData);
					System.out.println(Excel_Handling.Get_Data(TC_ID, "ExpiredValueQuote"));
					break;
				} else {
					Extent_Reporting.Log_Fail("quoteId Fetched is not Fetched", "quoteId  is not Fetched", driver, test);
					driver.quit();
					throw new Exception("Failed");
				}
			}
			Extent_Reporting.Log_report_img("quoteId Fetched.", "quoteId Fetched.", driver, test);
			Extent_Reporting.Log_Pass("quoteId Fetched.", "quoteId Fetched.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteId not Fetched.", "quoteId not Fetched.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void pricingScreenUpdateData() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices,
					"pricingPrices");

			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingCheckBoxClick);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingCheckBoxClick,
					"pricingCheckBoxClick");
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyButton);

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyButton,
					"quickApplyButton");
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyPriceUpdateField, "2000",
					"quickApplyPriceUpdateField");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.applyAfterDiscount,
					"applyAfterDiscount");// requestApproval

			action.acceptAlert(driver);
			action.isAlertPresent(driver);

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingCheckBoxClick,
					"pricingCheckBoxClick");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.RecalculateButton,
					"RecalculateButton");
			action.acceptAlert(driver);
			action.isAlertPresent(driver);
			Extent_Reporting.Log_report_img("pricingScreenUpdateData discount added Successfully.",
					"pricingScreenUpdateData discount added Successfully.", driver, test);
			Extent_Reporting.Log_Pass("pricingScreenUpdateData discount added Successfully.",
					"pricingScreenUpdateData discount added Successfully.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("pricing screen not completed", "pricing screen not completed", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	public void pricingPolygon() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(50000);

			List<WebElement> e = driver.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.pricingPolygon));
			for (int i = 1; i <= 9;) {
				if (i == 1) {
					Thread.sleep(4000);
					e.get(i).click();
					Extent_Reporting.Log_report_img("pricingPolygon clicked.", "pricingPolygon clicked", driver, test);
					Extent_Reporting.Log_Pass("pricingPolygon is clicked.", "pricingPolygon is clicked", test);
					break;
				} else {
					Extent_Reporting.Log_Fail("pricingPolygon is not clicked.", "pricingPolygon is not clicked.",
							driver, test);
					driver.quit();
					throw new Exception("Failed");
				}
			}
			Thread.sleep(8000);
			action.waitForPageToLoad(driver);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PricingPolygon screen not clicked", "PricingPolygon screen not clicked", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	public void goToReports() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			Thread.sleep(10000);
			action.WaitUntilExist(driver, ePricerEMEAIBMCreateAQuotePageObjects.reportsLettersPolygon);
			Thread.sleep(10000);
			action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.reportsLettersPolygon,
					"ReportsLetters Polygon");
			Thread.sleep(1000);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PricingPolygon screen not clicked", "PricingPolygon screen not clicked", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void uploadMultipleInternalCFR() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ClassLoader classLoader = getClass().getClassLoader();
			File cfr = new File(
					classLoader.getResource("4_Barclays_Opt1_DS8886F_MES_3.2TB_Flash_Drive_Set.cfr").getFile());
			File cfr2 = new File(classLoader.getResource("Aegon_GB_VEBsnH6064_FC4016nFC4017mes_24aug15.cfr").getFile());
			Thread.sleep(10000);
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr.getAbsolutePath());

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.disableChecksum,
					"disableChecksum");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.workWithOtherCountryCFR,
					"workWithOtherCountryCFR");
			Thread.sleep(2000);
			if (action.CheckifExist(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn)) {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
			} else {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtnDEV, "uploadCFRBtnDEV");
			}

			if (action.isAlertPresent(driver)) {
				action.acceptAlert(driver);
			}
			action.waitForPageToLoad(driver);
			Thread.sleep(7000);
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr2.getAbsolutePath());

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.disableChecksum,
					"disableChecksum");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.workWithOtherCountryCFR,
					"workWithOtherCountryCFR");

			if (action.CheckifExist(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn)) {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
			} else {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtnDEV, "uploadCFRBtnDEV");
			}
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);

			Extent_Reporting.Log_report_img("uploadCFR Successfully done.", "uploadCFR Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("uploadCFR Successfully done.", "uploadCFR Successfully done.", test);
			// System.out.println("try executed for methoduploadInternalCFR");

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CFR Upload Failed.", "CFR Upload Failed.", driver, test);
			e.printStackTrace();
			System.out.println("catch executed for methoduploadInternalCFR");
			driver.quit();
			throw new Exception("Failed");
		}
	}

	public void attachDocs() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(8000);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.commentsAttachmentsTab);
			Thread.sleep(20000);
			action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.commentsAttachmentsTab,
					"commentsAttachmentsTab");
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);
			ClassLoader classLoader = getClass().getClassLoader();
			File cfr = new File(classLoader.getResource("TestFile.txt").getFile());
			action.selectRadio(driver, ePricerEMEAIBMCreateAQuotePageObjects.everyoneRadioButton,
					"everyoneRadioButton");

			driver.findElement(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.browseButton))
					.sendKeys(cfr.getAbsolutePath());
			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.uploadDocBtn,
					"uploadDocBtn");
			action.waitForPageToLoad(driver);
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("uploadDoc Successfully done.", "uploadDoc Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("uploadDoc Successfully done.", "uploadDoc Successfully done.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Doc Upload Failed.", "Doc Upload Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void clickOnIBMSearchQuoteToDuplicate() throws Exception {
		ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
		ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
		ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

		Thread.sleep(3000);
		action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.searchQuote);
		try {
			Extent_Reporting.Log_report_img("Clicking on searchQuoteLink ", "Clicking on searchQuoteLink", driver, test);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.searchQuote,
					"searchQuoteLink Tab");
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.searchField);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.searchField, "Search Field is displayed.");
			Thread.sleep(5000);
			action.selectCheckBox(driver, ePricerEMEAIBMCreateAQuotePageObjects.checkBox, "checkBox");
			Thread.sleep(3000);
			action.inputText(driver, ePricerCreateAQuotePageObjects.searchField,
					Excel_Handling.Get_Data(TC_ID, "ExpiredValueQuote"), "SearchQuote");
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);
			List<WebElement> e = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.searchQuoteButton));
			if (e != null) {
				for (int i = 0; i <= 14; i++) {
					if (i == 3) {
						e.get(i).click();
						Extent_Reporting.Log_report_img("searchQuoteButton clicked", "searchQuoteButton clicked",
								driver, test);
						Extent_Reporting.Log_Pass("searchQuoteButton is displayed", "searchQuoteButton is displayed", test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Fail("searchQuoteButton is not displayed", "searchQuoteButton is not displayed",
						driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			Thread.sleep(2000);
			action.isAlertPresent(driver);
			Extent_Reporting.Log_report_img("IBMSearchQuoteToDuplicate Successfully done.",
					"IBMSearchQuoteToDuplicate Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("IBMSearchQuoteToDuplicate Successfully done.",
					"IBMSearchQuoteToDuplicate Successfully done.", test);
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("searchQuoteLink not clicked.", "searchQuoteLink not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
		}
	}

	public void duplicatQuoteWithNoAttachment() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.selectCheckBox(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchedCustomerResult,
					"searchedCustomerResult");
			action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.quoteActionsDropDown,
					Excel_Handling.Get_Data(TC_ID, "QuoteActionCheckBox"), "Select Quote action Criteria Selected");
			Thread.sleep(500);
			action.isElementDisplayed(driver, ePricerEMEAIBMCreateAQuotePageObjects.duplicatingQuoteGoButton,
					"duplicatingQuoteGoButton is present.");
			List<WebElement> q = driver
					.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.duplicatingQuoteGoButton));
			if (q != null) {
				for (int i = 0; i <= 14; i++) {
					if (i == 1) {
						q.get(i).click();
						Extent_Reporting.Log_report_img("duplicatingQuoteGoButton clicked",
								"duplicatingQuoteGoButton clicked", driver, test);
						Extent_Reporting.Log_Pass("duplicatingQuoteGoButton is displayed",
								"duplicatingQuoteGoButton is displayed", test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Fail("duplicatingQuoteGoButton is not displayed",
						"duplicatingQuoteGoButton is not displayed", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.popUpNoButton,
					"popUpNoButton");
			Thread.sleep(5000);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.commentsAttachmentsTab);
			Thread.sleep(8000);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.commentsAttachmentsTab);
			action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.commentsAttachmentsTab,
					"commentsAttachmentsTab");

			Extent_Reporting.Log_report_img("duplicating Quote Go Button clicked",
					"duplicating Quote Go Button clicked", driver, test);
			Extent_Reporting.Log_Pass("duplicating Quote Go Button clicked", "duplicating Quote Go Button clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("duplicating Quote Go Button not clicked",
					"duplicating Quote Go Button not clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void duplicatQuoteWithAttachment() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.selectCheckBox(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchedCustomerResult,
					"searchedCustomerResult");
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.quoteActionsDropDown);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerEMEAIBMCreateAQuotePageObjects.quoteActionsDropDown,
					Excel_Handling.Get_Data(TC_ID, "QuoteActionCheckBox"), "Select Quote action Criteria Selected");
			Thread.sleep(500);
			action.isElementDisplayed(driver, ePricerEMEAIBMCreateAQuotePageObjects.duplicatingQuoteGoButton,
					"duplicatingQuoteGoButton is present.");
			List<WebElement> q = driver
					.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.duplicatingQuoteGoButton));
			if (q != null) {
				for (int i = 0; i <= 14; i++) {
					if (i == 1) {
						q.get(i).click();
						Extent_Reporting.Log_report_img("duplicatingQuoteGoButton clicked",
								"duplicatingQuoteGoButton clicked", driver, test);
						Extent_Reporting.Log_Pass("duplicatingQuoteGoButton is displayed",
								"duplicatingQuoteGoButton is displayed", test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Fail("duplicatingQuoteGoButton is not displayed",
						"duplicatingQuoteGoButton is not displayed", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			Thread.sleep(10000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.popUpYesButton,
					"popUpYesButton");
			//action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.commentsAttachmentsTab);
			Thread.sleep(25000);
			action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.commentsAttachmentsTab,
					"commentsAttachmentsTab");

//			if (action.isElementDisplay(driver, ePricerEMEAIBMCreateAQuotePageObjects.attachedFiles)){
//				Extent_Reporting.Log_report_img("Attachment is Available", "duplicating Quote Go Button clicked",driver);
//				Extent_Reporting.Log_Pass("Attachment is Available", "Attachment is Available");				
//			} else {
//				Extent_Reporting.Log_Fail("Attachment is not Available", "Attachment is not Available", driver);
//			}
			Extent_Reporting.Log_report_img("duplicatQuoteWithAttachment Successfully done.",
					"duplicatQuoteWithAttachment Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("duplicatQuoteWithAttachment Successfully done.",
					"duplicatQuoteWithAttachment Successfully done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("duplicating Quote Go Button not clicked",
					"duplicating Quote Go Button not clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void MoveToConfigurationTab() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);
			// action.waitForElementClickable(driver,
			// ePricerEMEAIBMCreateAQuotePageObjects.manageConfiguration);
			action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.manageConfiguration,
					"ManageConfigurationPolygon");
			action.waitForPageToLoad(driver);
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("MoveToConfigurationTab Successfully done.",
					"MoveToConfigurationTab Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("MoveToConfigurationTab Successfully done.",
					"MoveToConfigurationTab Successfully done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("MoveToConfigurationTab failed", "MoveToConfigurationTab failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void changeQuantityOfManualCOmponent() throws Exception {
		try {
			ePricerChangeConfigurationPageObjects = new Epricer_Application_Change_Configuration_Quantity_PageObjects(
					driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.waitForPageToLoad(driver);
			Thread.sleep(5000);

			List<WebElement> e = driver
					.findElements(By.xpath(ePricerChangeConfigurationPageObjects.dropDownFeatureButtonManageConfig));
			for (int i = 3; i <= 14;) {
				if (i == 3) {
					e.get(i).click();
					Extent_Reporting.Log_Pass("Feature drop down is clicked.", "feature drop down is clicked.", test);
					Extent_Reporting.Log_report_img("Feature drop down is clicked.", "Feature drop down is clicked.",
							driver, test);
					break;
				} else {
					Extent_Reporting.Log_Fail("Feature drop down is not clicked.", "Feature drop down is not clicked.",
							driver, test);
					throw new Exception("Failed");
				}
			}

			action.selectCheckBox(driver, ePricerEMEAIBMCreateAQuotePageObjects.manualComponentCheckBox,
					"manualComponentCheckBox");
			Thread.sleep(5000);

			List<WebElement> j = driver
					.findElements(By.xpath(ePricerChangeConfigurationPageObjects.featureQuantiyFieldManageConfig));

			for (int i = 1; i <= 7;) {
				if (i == 1) {
					j.get(i).click();
					j.get(i).clear();
					j.get(i).sendKeys("2");
					Extent_Reporting.Log_Pass("Feature quatity is changed.", "Feature quatity is changed.", test);
					Extent_Reporting.Log_report_img("Feature quatity is changed.", "Feature quatity is changed.",
							driver, test);
					break;
				} else {
					Extent_Reporting.Log_Fail("Feature quatity is not changed.", "Feature quatity is not changed.",
							driver, test);
					driver.quit();
					throw new Exception("Failed");
				}
			}
			action.waitForPageToLoad(driver);
			action.Javascriptexecutor_forClick(driver, ePricerChangeConfigurationPageObjects.updateQuantityButton,
					"updateQuantity");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("updateQuantity button clicked.", "updateQuantity button clicked.", driver, test);
			Extent_Reporting.Log_Pass("updateQuantity button clicked.", "updateQuantity button clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("updateQuantity tab not clicked.", "updateQuantity tab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void deleteCFR() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.waitForPageToLoad(driver);
			Thread.sleep(9000);
			List<WebElement> j = driver.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.cFRCheckBox));

			for (int i = 1; i <= 5;) {
				if (i == 1) {
					Thread.sleep(2000);
					action.waitForPageToLoad(driver);
					j.get(i).click();
					Extent_Reporting.Log_Pass("CFRCheckBox is selected.", "CFRCheckBox is selected.", test);
					Extent_Reporting.Log_report_img("CFRCheckBox is selected.", "CFRCheckBox is selected.", driver, test);
					break;
				} else {
					Extent_Reporting.Log_Fail("CFRCheckBox is not selected.", "CFRCheckBox is not selected.", driver, test);
					driver.quit();
					throw new Exception("Failed");
				}
			}
			action.clickButton(driver, ePricerEMEAIBMCreateAQuotePageObjects.deleteItemButton, "deleteItemButton");
			action.acceptAlert(driver);
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("Delete CFR successful.", "Delete CFR successful.", driver, test);
			Extent_Reporting.Log_Pass("Delete CFR successful.", "Delete CFR successful.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("updateQuantity tab not clicked.", "updateQuantity tab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void dataForEPricerAddProductManually() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField1,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField1"), "typeModelField1");
			Extent_Reporting.Log_report_img("TypeModelField1 entered.", "TypeModelField1 entered.", driver, test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField2,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField2"), "TypeModelField2");
			Extent_Reporting.Log_report_img("TypeModelField2 entered.", "TypeModelField2 entered.", driver, test);

			Thread.sleep(10000);

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.addComponentButton,
					"addComponentButton");
			Thread.sleep(8000);
			if (action.CheckifExist(driver, ePricerCreateAQuotePageObjects.typeModelField1)) {
				action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.cancelAndCloseButton2, "closeButton");
			}

			if (action.isAlertPresent(driver)) {
				action.acceptAlert(driver);
			}
			Thread.sleep(9000);

			Extent_Reporting.Log_report_img("add and close button clicked.", "add and close button clicked.", driver, test);
			Extent_Reporting.Log_Pass("add and close button clicked.", "add and close button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("add and close button not clicked.", "add and close button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void uploadCFRSecondTime() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ClassLoader classLoader = getClass().getClassLoader();
			File cfr = new File(
					classLoader.getResource("4_Barclays_Opt1_DS8886F_MES_3.2TB_Flash_Drive_Set.cfr").getFile());

			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr.getAbsolutePath());

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.disableChecksum,
					"disableChecksum");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.workWithOtherCountryCFR,
					"workWithOtherCountryCFR");

			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");

			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("uploadCFR Successfully done.", "uploadCFR Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("uploadCFR Successfully done.", "uploadCFR Successfully done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CFR Upload Failed.", "CFR Upload Failed.", driver, test);
			e.printStackTrace();
			System.out.println("catch executed for methoduploadInternalCFR");
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void moveToPricingPolygon() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(40000);
			List<WebElement> e = driver.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.pricingPolygon));
			for (int i = 1; i <= 9;) {
				if (i == 1) {
					Thread.sleep(5000);
					e.get(i).click();
					Extent_Reporting.Log_report_img("pricingPolygon clicked.", "pricingPolygon clicked", driver, test);
					Extent_Reporting.Log_Pass("pricingPolygon is clicked.", "pricingPolygon is clicked", test);
					break;
				} else {
					Extent_Reporting.Log_Fail("pricingPolygon is not clicked.", "pricingPolygon is not clicked.",
							driver, test);
					driver.quit();
					throw new Exception("Failed");
				}
			}
			Thread.sleep(10000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices,
					"pricingPrices");
			action.waitForPageToLoad(driver);
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("move to pricing Successfully done.", "move to pricing Successfully done.",
					driver, test);
			Extent_Reporting.Log_Pass("move to pricing Successfully done.", "move to pricing Successfully done.", test);
			Thread.sleep(5000);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PricingPolygon screen not clicked", "PricingPolygon screen not clicked", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	public void applyApprovedPrice() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.componentViewTable,
					"Component", "Component");
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("componentViewTable Successfully done.","componentViewTable Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("componentViewTable Successfully done.", "componentViewTable Successfully done.", test);
			Thread.sleep(500);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("applyApprovedPrice not clicked", "applyApprovedPrice  not clicked", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	public void switchToTotalView() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.waitForPageToLoad(driver);
			action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.componentViewTable, "Total",
					"Total");
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("switchToTotalView Successfully done.",
					"switchToTotalView Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("switchToTotalView Successfully done.", "switchToTotalView Successfully done.", test);
			Thread.sleep(500);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("switchToTotalView not clicked", "switchToTotalView  not clicked", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	public void CreateQuoteForFrance(String env) throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			action.waitForPageToLoad(driver);
			// action.waitForElementClickable(driver,
			// ePricerEMEAIBMCreateAQuotePageObjects.quoteTitle);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.requesterPhone);
			boolean isTitleClickable = action.checkElementClickableFluent(driver,
					ePricerEMEAIBMCreateAQuotePageObjects.requesterPhone, "requesterPhone");
			Extent_Reporting.Log_Pass(isTitleClickable + "Element is clickable or not.",
					isTitleClickable + "Element is clickable or not.", test);
			if (isTitleClickable) {
				action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.selectCountryDropDown,
						"France", "Country");
				action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.requesterPhone);
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.requesterPhone,
						Excel_Handling.Get_Data(TC_ID, "ContactPhone"), "requesterPhone");
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.quoteTitleInternal,
						Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "quoteTitleInternal");
				action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.opportunityId);
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.opportunityId,
						Excel_Handling.Get_Data(TC_ID, "IBMUniqueID"), "opportunityId");
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.opportunityOwnerEmail,
						Excel_Handling.Get_Data(TC_ID, "ContactEmail"), "opportunityOwnerEmail");
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.opportunityOwnerName,
						Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "opportunityOwnerName");

				action.selectDropBoxByVisibleText(driver,
						ePricerEMEAIBMCreateAQuotePageObjects.selectChannelIndicatorDropDown, "Telesales",
						"selectChannelIndicatorDropDown");
				action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.selectSolutionType,
						"OLTP", "selectSolutionType");
				Calendar c = Calendar.getInstance();
				c.add(Calendar.MONTH, 1);
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
				String strDate= formatter.format(c.getTime());  
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");
			
				// Opportunity Id
				Extent_Reporting.Log_report_img("requesterPhone entered in 1st Time.",
						"requesterPhone entered in 1st Time.", driver, test);
			} else {
				driver.navigate().refresh();
				action.handleAlert(driver);
				Extent_Reporting.Log_report_img("Page Refreshed.", "Page Refreshed.", driver, test);
				loginBusinessLogic.ePricerLoginscreen();
				loginBusinessLogic.ePRICERMainScreen();
				createQuoteLink();
				createAQuoteBusinessLogic.overviewPolygonScreen();

				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.requesterPhone,
						Excel_Handling.Get_Data(TC_ID, "ContactPhone"), "requesterPhone");
				
				Extent_Reporting.Log_report_img("requesterPhone entered in 2nd time.",
						"requesterPhone entered in 2nd time.", driver, test);
			}

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.saveOverviewButton,
					"saveOverviewButton");

			Extent_Reporting.Log_report_img("save and Continue button clicked.", "save and Continue button clicked.",
					driver, test);
			Extent_Reporting.Log_Pass("OverviewData entered and save and Continue button clicked.",
					"OverviewData entered and save and Continue button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("RequesterPhone entered and save and Continue button not clicked.",
					"RequesterPhone entered and save and Continue button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void searchCustomerByCMR() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,TC_ID);
			action.waitForPageToLoad(driver);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchForACustomer);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchForACustomer,
					"searchForACustomer");
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerEMEAIBMCreateAQuotePageObjects.customerSelectionByCompanyName,
					Excel_Handling.Get_Data(TC_ID, "CompanySearchOnDropdown"), "customerSelectionByCompanyName");
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cMRCustomerName, "001021",
					"CMRCustomerName");

			// SearchForName
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.searchInternalCustomer,
					"searchInternalCustomer");
			Thread.sleep(20000);
			if (action.CheckifExist(driver, ePricerEMEAIBMCreateAQuotePageObjects.customerSelectionByCompanyName)) {
				action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.customerSelectionForInternal);
				action.Javascriptexecutor_forClick(driver,ePricerEMEAIBMCreateAQuotePageObjects.customerSelectionForInternal, "customerSelectionForInternal");
				Thread.sleep(10000);
				action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.selectCustomerClick,
						"selectCustomerClick");
				Thread.sleep(10000);				
			}
			action.Javascriptexecutor_forClick(driver,ePricerEMEAIBMCreateAQuotePageObjects.customerPageSaveAndContinue, "customerPageSaveAndContinue");
			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("Search Customer By CMR Successflly Done.",
					"Search Customer By CMR Successflly Done.", driver, test);
			Extent_Reporting.Log_Pass("Search Customer By CMR Successflly Done.",
					"Search Customer By CMR Successflly Done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Search Customer By CMR Failed.", "Search Customer By CMR Failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

}
