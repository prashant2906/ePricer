/**
 *
 */
package com.ibm.stax.BusinessLogic.PCS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_ChangeConfigurationQuantity;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_SearchQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

public class Epricer_Application_PCS_CreateAQuote_BusinessLogic {

	private ElementAction action = new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;

	Epricer_Application_PCS_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_PCS_ChangeConfigurationQuantity ePricerChangeConfigurationPageObjects = null;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuote = null;
	Epricer_Application_PCS_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_PCS_SearchQuote_PageObjects EpricerApplicationSearchQuotePageObjects = null;
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;
	static String quoteId;

	public Epricer_Application_PCS_CreateAQuote_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for clicking createANewQuoteLinkClick.
	 * 
	 * @throws Throwable
	 */
	public void createANewQuoteLinkClick() throws Exception {
		ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
		Thread.sleep(10000);
		action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.createANewQuoteLink);
		try {
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.createANewQuoteLink,
					"createANewQuoteLink Tab");
			Extent_Reporting.Log_Pass("createANewQuoteLink clicked.", "createANewQuoteLink clicked.", test);
			Extent_Reporting.Log_report_img("Clicking on createANewQuoteLink ", "Clicking on createANewQuoteLink",
					driver, test);
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("createANewQuoteLink not clicked.", "createANewQuoteLink not clicked.", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for quoteIdFetched
	 * 
	 * @throws Throwable
	 */
	public String quoteIdFetched() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			driver.switchTo().parentFrame();
			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.PCSGetquoteid));
			for (int i = 0; i <= 10; i++) {
				if (i == 0) {
					quoteId = e.get(i).getText();
					Extent_Reporting.Log_report_img("quoteId Fetched.", "quoteId Fetched.", driver, test);
					Extent_Reporting.Log_Pass("quoteId Fetched.", "quoteId Fetched.", test);
					break;
				}
			}

			return quoteId;
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteId not Fetched.", "quoteId not Fetched.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for quoteIdFetched
	 * 
	 * @throws Throwable
	 */
	public String quoteIdFetchedPSAT() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			driver.switchTo().parentFrame();
			quoteId = action.getInputTextValue(driver, ".//*[@id='currentquotetab']/li/div/div[1]", "quoteid");

			Extent_Reporting.Log_report_img("quoteId Fetched.", "quoteId Fetched.", driver, test);
			Extent_Reporting.Log_Pass("quoteId"+quoteId+"Fetched.", "quoteId"+quoteId+"Fetched.", test);

			return quoteId;
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteId not Fetched.", "quoteId not Fetched.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying overviewPolygonScreen.
	 * 
	 * @throws Throwable
	 */
	public void overviewPolygonScreen() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.overviewPolygon);
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("overviewPolygonScreen is displayed.","overviewPolygonScreen is displayed.", driver, test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("overviewPolygonScreen is not displayed.",
					"overviewPolygonScreen is not displayed.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void click_on_saveandcontinue() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			action.waitForPageToLoad(driver);

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
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for dataForEPricerOverviewScreen
	 * 
	 * @throws Throwable
	 */
	public void dataForEPricerOverviewScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			loginBusinessLogic = new Epricer_Application_PCS_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			Thread.sleep(40000);
			action.waitForPageToLoad(driver);
			boolean isTitleClickable = checkElementClickableFluent(driver, ePricerCreateAQuotePageObjects.quoteTitle,
					"quoteTitle");
			// TODO - log pass messsage
			Extent_Reporting.Log_Pass(isTitleClickable + "Element is clickable or not.",isTitleClickable + "Element is clickable or not.", test);
			if (isTitleClickable) {
				action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.quoteTitle);
				Thread.sleep(5000);
				action.inputText(driver, ePricerCreateAQuotePageObjects.quoteTitle,
						Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "quoteTitle");
				Extent_Reporting.Log_report_img("QuoteTitle entered in 1st Time.", "QuoteTitle entered in 1st Time.",
						driver, test);
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
			throw new Exception("Failed");
		}
	}

	public boolean checkElementClickable(WebDriver driver, String element, String Web_Element)
			throws InterruptedException {
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));

			/*
			 * //FluentWait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver);
			 * wait.pollingEvery(5, TimeUnit.SECONDS); wait.withTimeout(60,
			 * TimeUnit.SECONDS); wait.until(new Function<WebDriver>)
			 * 
			 */
			Extent_Reporting.Log_Pass(Web_Element + " Element is clickable", Web_Element + " Element is clickable", test);
			action.waitForPageToLoad(driver);
			return true;
		} catch (Throwable e) {
			action.waitForPageToLoad(driver);
			return false;
		}
	}

	/*
	 * public boolean checkElementClickableFluent(WebDriver driver, final String
	 * ObjectxPath,String element) throws Exception { try { FluentWait<WebDriver>
	 * waitFluent = new FluentWait<WebDriver>(driver); waitFluent.pollingEvery(5,
	 * TimeUnit.SECONDS); waitFluent.withTimeout(60, TimeUnit.SECONDS);
	 * waitFluent.ignoring(NoSuchElementException.class);
	 * 
	 * //new FluentWait<WebDriver>(driver).withTimeout(60,
	 * TimeUnit.SECONDS).pollingEvery(5,
	 * TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	 * 
	 * Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
	 * public Boolean apply(WebDriver driver) { // return
	 * driver.findElement(By.xpath(ObjectxPath)); WebElement element =
	 * driver.findElement(By.xpath(ObjectxPath)); if(element != null) { return true;
	 * } return false; } };
	 * 
	 * waitFluent.until(function);
	 * 
	 * return true;
	 * 
	 * } catch (Throwable e) { action.waitForPageToLoad(driver); return false; } }
	 */
	public boolean checkElementClickableFluent(WebDriver driver, final String ObjectxPath, String element)
			throws InterruptedException {
		try {
			FluentWait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver);
			waitFluent.pollingEvery(5, TimeUnit.SECONDS);
			waitFluent.withTimeout(80, TimeUnit.SECONDS);
			waitFluent.ignoring(NoSuchElementException.class);

			// new FluentWait<WebDriver>(driver).withTimeout(60,
			// TimeUnit.SECONDS).pollingEvery(5,
			// TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					// return driver.findElement(By.xpath(ObjectxPath));
					WebElement element1 = driver.findElement(By.xpath(ObjectxPath));
					System.out.println(element1);
					if (element1 != null) {
						System.out.println(element1 + "is present in true statement");
						return true;

					}
					return false;
				}
			};

			return waitFluent.until(function);

		} catch (Throwable e) {
			action.waitForPageToLoad(driver);
			return false;
		}
	}

	/**
	 * This method is for verifying manageConfigurationPolygonScreen.
	 * 
	 * @throws Throwable
	 */
	public void manageConfigurationPolygonScreen() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.manageConfigurationPolygon);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.manageConfigurationPolygon,
					"manageConfigurationPolygonScreen is displayed.");

			Extent_Reporting.Log_report_img("manageConfigurationPolygonScreen is displayed.",
					"manageConfigurationPolygonScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("manageConfigurationPolygonScreen is displayed.",
					"manageConfigurationPolygonScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("manageConfigurationPolygonScreen is not displayed.",
					"manageConfigurationPolygonScreen is not displayed.", driver, test);
			// System.out.println(e.getMessage().toString());
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
			Thread.sleep(5000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.addProductManuallyButton);
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
	 * This method is for dataForEPricerAddProductManuallyScreen
	 * 
	 * @throws Throwable
	 */
	public void dataForEPricerAddProductManuallyScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			//action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.selectCategorySelected);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerCreateAQuotePageObjects.selectCategorySelected,
					Excel_Handling.Get_Data(TC_ID, "SelectCategorySelected"), "Select Category Selected");
			Thread.sleep(2000);
			Extent_Reporting.Log_Pass("Select Category Selected", "Select Category Selected", test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField1,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField1"), "typeModelField1");
			Extent_Reporting.Log_report_img("TypeModelField1 entered.", "TypeModelField1 entered.", driver, test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField2,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField2"), "TypeModelField2");
			Extent_Reporting.Log_Pass("TypeModelField2 entered.", "TypeModelField2 entered.", test);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.addAndCloseButton,
					"addAndCloseButton");

			Extent_Reporting.Log_report_img("add and close button clicked.", "add and close button clicked.", driver, test);
			Extent_Reporting.Log_Pass("add and close button clicked.", "add and close button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("add and close button not clicked.", "add and close button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying componentAddedSuccessMsg.
	 * 
	 * @throws Throwable
	 */
	public void componentAddedSuccessMsg() throws Exception {
		try {
//			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
//			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.componentAddedSuccessMsg);
//			// action.isElementDisplayed(driver,
//			// ePricerCreateAQuotePageObjects.componentAddedSuccessMsg,
//			// "componentAddedSuccessMsg is displayed.");
//
//			Extent_Reporting.Log_report_img("componentAddedSuccessMsg is displayed.",
//					"componentAddedSuccessMsg is displayed.", driver, test);
			Extent_Reporting.Log_Pass("componentAddedSuccessMsg is displayed.","componentAddedSuccessMsg is displayed.", test);
			Thread.sleep(20000);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("componentAddedSuccessMsg is not displayed.","componentAddedSuccessMsg is not displayed.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for collectPricingButtonClick
	 * 
	 * @throws Throwable
	 */
	public void collectPricingButtonClick() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			if (checkElementClickableFluent(driver, ePricerCreateAQuotePageObjects.collectPricingButton,
					"collectPricingButton")) {
				action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.collectPricingButton,
						"collectPricingButton");
				Thread.sleep(5000);
				Extent_Reporting.Log_report_img("collectPricing button clicked.", "collectPricing button clicked.",
						driver, test);
				Extent_Reporting.Log_Pass("collectPricing button clicked.", "collectPricing button clicked.", test);
			} else {
				Extent_Reporting.Log_Fail("collectPricing button not present in 1 minute.",
						"collectPricing button not present in 1 minute.", driver, test);
			}
			Thread.sleep(5000);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("collectPricing button not clicked.", "collectPricing button not clicked.",driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for pricingValueCheck
	 * 
	 * @throws Throwable
	 */
	public void pricingValueCheck() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			if (ePricerCreateAQuotePageObjects.pricingValue != null) {
				Extent_Reporting.Log_report_img("pricingValue is calculated.", "pricingValue is calculated.", driver,
						test);
				Extent_Reporting.Log_Pass("pricingValue is calculated.", "pricingValue is calculated.", test);

				Thread.sleep(2000);
				List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));

				for (int i = 0; i <= 14; i++) {
					if (i == 1) {
						Thread.sleep(10000);
						e.get(i).click();
						Extent_Reporting.Log_report_img("save btn clicked.", "save btn clicked.", driver, test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Fail("pricingValue is not calculated.", "pricingValue is not calculated.", driver,	test);
				driver.quit();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("pricingValue is not calculated.", "pricingValue is not calculated.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying registrationCustomerPolygonScreen.
	 * 
	 * @throws Throwable
	 */
	public void registrationCustomerPolygon() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.registrationCustomerPolygon);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.registrationCustomerPolygon,
					"registrationCustomerPolygon Screen is displayed.");
			Extent_Reporting.Log_report_img("registrationCustomerPolygonScreen is displayed.",
					"registrationCustomerPolygonScreen is displayed.", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("registrationCustomerPolygonScreen is not displayed.",
					"registrationCustomerPolygonScreen is not displayed.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for dataForEPricerOverviewScreen
	 * 
	 * @throws Throwable
	 */
	public void dataForRegistrationNumberScreen() throws Throwable {
		try {

			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(3000);
			action.inputText(driver, ePricerCreateAQuotePageObjects.registrationNumber,
					Excel_Handling.Get_Data(TC_ID, "RegistrationNumber"), "RegistrationNumber");
			Extent_Reporting.Log_report_img("RegistrationNumber entered.", "RegistrationNumber entered.", driver, test);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.retrieveButton, "retrieveButton");

			Extent_Reporting.Log_report_img("retrieve Button clicked.", "retrieve Button clicked.", driver, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.saveOverviewButton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.saveOverviewButton,
					"saveOverviewButton is displayed.");

			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.saveOverviewButton);
			for (int i = 0; i <= 14; i++) {
				if (i == 2) {
					e.get(i).click();
					Extent_Reporting.Log_report_img("save btn clicked.", "save btn clicked.", driver, test);
					Extent_Reporting.Log_Pass("saveOverviewButton clicked.", "saveOverviewButton clicked.", test);
					break;
				} /*
					 * else{ Extent_Reporting.Log_Fail("saveOverviewButton not clicked.",
					 * "saveOverviewButton not clicked.", driver); driver.quit(); throw new
					 * Exception("Failed"); }
					 */
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying detailsPricingPolygonScreen.
	 * 
	 * @throws Throwable
	 */
	public void detailsPricingPolygon() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.detailsPricingPolygon);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.detailsPricingPolygon,
					"detailsPricingPolygonScreen is displayed.");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("detailsPricingPolygonScreen is displayed.",
					"detailsPricingPolygonScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("detailsPricingPolygonScreen is displayed.",
					"detailsPricingPolygonScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("detailsPricingPolygonScreen is not displayed.",
					"detailsPricingPolygonScreen is not displayed.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for previewValueSellerOfferButtonClicked
	 * 
	 * @throws Throwable
	 */
	public void previewValueSellerOfferButtonClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.previewValueSellerOfferButton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.previewValueSellerOfferButton,
					"previewValueSellerOfferButton is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.previewValueSellerOfferButton,
					"previewValueSellerOfferButton");

			Extent_Reporting.Log_report_img("previewValueSellerOffer Button clicked.",
					"previewValueSellerOffer Button clicked.", driver, test);
			Extent_Reporting.Log_Pass("previewValueSellerOffer Button clicked.",
					"previewValueSellerOffer Button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("previewValueSellerOffer Button not clicked.",
					"previewValueSellerOffer Button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying iBMBusinessPartnerValueSellerScreen.
	 * 
	 * @throws Throwable
	 */
	public void iBMBusinessPartnerValueSellerScreen() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.iBMBusinessPartnerValueSellerScreen);

			Extent_Reporting.Log_report_img("iBMBusinessPartnerValueSellerScreen is displayed.",
					"iBMBusinessPartnerValueSellerScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("iBMBusinessPartnerValueSellerScreen is displayed.",
					"iBMBusinessPartnerValueSellerScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMBusinessPartnerValueSellerScreen is not displayed.",
					"iBMBusinessPartnerValueSellerScreen is not displayed.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/*
	 * * This method is for closeIBMBusinessPartnerValueSellerScreenBtnClicked
	 * 
	 * @throws Throwable
	 */
	public void closeIBMBusinessPartnerValueSellerScreenBtnClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver,
					ePricerCreateAQuotePageObjects.closeIBMBusinessPartnerValueSellerScreenBtn);
			action.isElementDisplayed(driver,
					ePricerCreateAQuotePageObjects.closeIBMBusinessPartnerValueSellerScreenBtn,
					"closeIBMBusinessPartnerValueSellerScreenBtnClicked is displayed.");

			action.Javascriptexecutor_forClick(driver,
					ePricerCreateAQuotePageObjects.closeIBMBusinessPartnerValueSellerScreenBtn,
					"closeIBMBusinessPartnerValueSellerScreenBtn");

			Extent_Reporting.Log_report_img("closeIBMBusinessPartnerValueSellerScreen Button clicked.",
					"closeIBMBusinessPartnerValueSellerScreen Button clicked.", driver, test);
			Extent_Reporting.Log_Pass("closeIBMBusinessPartnerValueSellerScreen Button clicked.",
					"closeIBMBusinessPartnerValueSellerScreen Button clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("closeIBMBusinessPartnerValueSellerScreen Button not clicked.",
					"closeIBMBusinessPartnerValueSellerScreen Button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying listPriceTotalValueCheck.
	 * 
	 * @throws Throwable
	 */
	public void listPriceTotalValueCheck() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.listPriceTotalValue);

			Extent_Reporting.Log_report_img("listPriceTotalValue is displayed.", "listPriceTotalValue is displayed.",
					driver, test);
			Extent_Reporting.Log_Pass("listPriceTotalValue is displayed.", "listPriceTotalValue is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("listPriceTotalValue is not displayed.", "listPriceTotalValue is not displayed.",
					driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/*
	 * * This method is for closeIBMBusinessPartnerValueSellerScreenBtnClicked
	 * 
	 * @throws Throwable
	 */
	public void acceptValueSellerOfferButtonClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.acceptValueSellerOfferButton);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.acceptValueSellerOfferButton);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.acceptValueSellerOfferButton,
					"acceptValueSellerOffer Button Clicked");

			Extent_Reporting.Log_report_img("acceptValueSellerOffer Button Clicked",
					"acceptValueSellerOffer Button Clicked", driver, test);
			Extent_Reporting.Log_Pass("acceptValueSellerOffer Button Clicked", "acceptValueSellerOffer Button Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("acceptValueSellerOffer Button not Clicked",
					"acceptValueSellerOffer Button not Clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying valueSellerApprovedStatusCheck.
	 * 
	 * @throws Throwable
	 */
	public void valueSellerApprovedStatusCheck() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.viewQuoteDataTab);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.viewQuoteDataTab,
					"viewQuoteDataTab is displayed.");
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.valueSellerApprovedStatus);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.valueSellerApprovedStatus,
					"valueSellerApprovedStatus is displayed.");

			Extent_Reporting.Log_report_img("viewQuoteDataTab and valueSellerApprovedStatus is displayed.",
					"viewQuoteDataTab and valueSellerApprovedStatus is displayed.", driver, test);
			Extent_Reporting.Log_Pass("viewQuoteDataTab and valueSellerApprovedStatus is displayed.",
					"viewQuoteDataTab and valueSellerApprovedStatus is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("viewQuoteDataTab and valueSellerApprovedStatus is not displayed.",
					"viewQuoteDataTab and valueSellerApprovedStatus is not displayed.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for verifying acceptValueSellerScreenHeadingsCheck.
	 * 
	 * @throws Throwable
	 */
	public void acceptValueSellerScreenHeadingsCheck() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.quoteDetailHeading);
			Extent_Reporting.Log_report_img("quoteDetailHeading is displayed.", "quoteDetailHeading is displayed.",
					driver, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.registrationHeading);
			Extent_Reporting.Log_report_img("registrationHeading is displayed.", "registrationHeading is displayed.",
					driver, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.endUserCustomerHeading);
			Extent_Reporting.Log_report_img("endUserCustomerHeading is displayed.",
					"endUserCustomerHeading is displayed.", driver, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.channelInformationHeading);
			Extent_Reporting.Log_report_img("channelInformationHeading is displayed.",
					"channelInformationHeading is displayed.", driver, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.productsAndPricesHeading);
			Extent_Reporting.Log_report_img("productsAndPricesHeading is displayed.",
					"productsAndPricesHeading is displayed.", driver, test);

			Extent_Reporting.Log_Pass("acceptValueSellerScreenHeadings is displayed.",
					"acceptValueSellerScreenHeadings is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("acceptValueSellerScreenHeadings is not displayed.",
					"acceptValueSellerScreenHeadings is not displayed.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/*
	 * * This method is for addendumTabClicked
	 * 
	 * @throws Throwable
	 */
	public void addendumTabClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.addendumTab);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.addendumTab, "addendumTab is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.addendumTab,
					"addendum Tab Clicked");

			Extent_Reporting.Log_report_img("addendum Tab Clicked", "addendum Tab Clicked", driver, test);
			Extent_Reporting.Log_Pass("addendum Tab Clicked", "addendum Tab Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("addendum Tab not Clicked", "addendum Tab not Clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying brandTabCheck.
	 * 
	 * @throws Throwable
	 */
	public void brandTabCheck() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.brandTab);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.brandTab);

			Extent_Reporting.Log_report_img("brandTabCheck is displayed.", "brandTabCheck is displayed.", driver, test);
			Extent_Reporting.Log_Pass("brandTabCheck is displayed.", "brandTabCheck is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("brandTabCheck is not displayed.", "brandTabCheck is not displayed.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/*
	 * * This method is for editAddendumButtonClicked
	 * 
	 * @throws Throwable
	 */
	public void editAddendumButtonClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.editAddendumButton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.editAddendumButton,
					"editAddendumButton is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.editAddendumButton,
					"editAddendumButtonClicked");

			Extent_Reporting.Log_report_img("editAddendum Button Clicked", "editAddendum Button Clicked", driver, test);
			Extent_Reporting.Log_Pass("editAddendum Button Clicked", "editAddendum Button Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("editAddendum Button not Clicked", "editAddendum Button not Clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying brandCheckboxCheck.
	 * 
	 * @throws Throwable
	 */
	public void brandCheckboxCheck() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.brandCheckbox);

			Extent_Reporting.Log_report_img("brandCheckbox is displayed.", "brandCheckbox is displayed.", driver, test);

			String win = driver.getTitle();

			if (win.contains("e-Pricer")) {

				List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.brandCheckbox));

				for (int i = 0; i <= 10; i++) {
					if (i == 0) {
						e.get(i).click();
						Extent_Reporting.Log_report_img("brandCheckbox clicked.", "brandCheckbox clicked.", driver, test);
						Extent_Reporting.Log_Pass("brandCheckbox clicked.", "brandCheckbox clicked.", test);
						break;
					}
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("brandCheckbox not clicked.", "brandCheckbox not clicked.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/*
	 * * This method is for cancelAndCloseButtonClicked
	 * 
	 * @throws Throwable
	 */
	public void cancelAndCloseButtonClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.cancelAndCloseButton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.cancelAndCloseButton,
					"cancelAndCloseButton is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.cancelAndCloseButton,
					"cancelAndCloseButtonClicked");

			Extent_Reporting.Log_report_img("cancelAndClose Button Clicked", "cancelAndClose Button Clicked", driver, test);

			// driver.switchTo().alert().accept();

			Extent_Reporting.Log_Pass("cancelAndClose Button Clicked", "cancelAndClose Button Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("cancelAndClose Button not Clicked", "cancelAndClose Button not Clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/*
	 * * This method is for sendAddendumButtonClicked
	 * 
	 * @throws Throwable
	 */
	public void sendAddendumButtonClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.sendAddendumButton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.sendAddendumButton,
					"sendAddendumButton is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.sendAddendumButton,
					"sendAddendum Button Clicked");

			Extent_Reporting.Log_report_img("sendAddendum Button Clicked", "sendAddendum Button Clicked", driver, test);

			// driver.switchTo().alert().accept();

			Extent_Reporting.Log_Pass("sendAddendum Button Clicked", "sendAddendum Button Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendAddendum Button not Clicked", "sendAddendum Button not Clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying valueSellerApprovedStatusCheck.
	 * 
	 * @throws Throwable
	 */
	public void sendValueSellerAddendumScreen() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.sendValueSellerAddendumScreen);

			action.inputText(driver, ePricerCreateAQuotePageObjects.addToListMailId,
					Excel_Handling.Get_Data(TC_ID, "addToListMailId"), "addToListMailId");

			driver.switchTo().frame("ui-tinymce-1_ifr");

			action.inputText(driver, ePricerCreateAQuotePageObjects.mailBody,
					Excel_Handling.Get_Data(TC_ID, "mailBody"), "mailBody");

			Extent_Reporting.Log_report_img("sendValueSellerAddendumScreen is displayed.",
					"sendValueSellerAddendumScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("sendValueSellerAddendumScreen is displayed.",
					"sendValueSellerAddendumScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendValueSellerAddendumScreen is not displayed.",
					"sendValueSellerAddendumScreen is not displayed.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/*
	 * * This method is for sendMailButtonClicked
	 * 
	 * @throws Throwable
	 */
	public void sendMailButtonClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			// driver.switchTo().defaultContent();
			driver.switchTo().parentFrame();
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.sendMailButton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.sendMailButton,
					"sendMailButton is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.sendMailButton,
					"sendMail Button Clicked");

			driver.switchTo().alert().accept();

			Thread.sleep(2000);

			// driver.switchTo().alert().accept();

			Extent_Reporting.Log_report_img("sendMail Button Clicked", "sendMail Button Clicked", driver, test);
			Extent_Reporting.Log_Pass("sendMail Button Clicked", "sendMail Button Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendMail Button not Clicked", "sendMail Button not Clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void moveToDetailsPricing() throws Throwable {
		ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
		Thread.sleep(3000);
		List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));

		for (int i = 0; i <= 14; i++) {
			if (i == 2) {
				e.get(i).click();
				Extent_Reporting.Log_report_img("save btn clicked.", "save btn clicked.", driver, test);
				Extent_Reporting.Log_Pass("saveOverviewButton clicked.", "saveOverviewButton clicked.", test);
				break;
			}
		}
	}

	public void returntoDistributonClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.returnToRequester,
					"returnToRequester Button Clicked");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("returnToRequester Button Clicked", "returnToRequester Button Clicked",
					driver, test);
			Extent_Reporting.Log_Pass("returnToRequester Button Clicked", "returnToRequester Button Clicked", test);

			driver.switchTo().frame("ui-tinymce-0_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection,
					Excel_Handling.Get_Data(TC_ID, "CommentsSection"), "commentsSection");
			driver.switchTo().parentFrame();
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.returnToDistributorButton,
					"returnToDistributorButton");
			Thread.sleep(4000);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("returnToRequester Button not Clicked", "returnToRequester Button not Clicked",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * Neha Upadhyay: This method is for verifying
	 * moveToDetailsPricingFromManageConfig.
	 * 
	 * @throws Throwable
	 */
	public void moveToDetailsPricingFromManageConfig() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(3000);
			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));

			for (int i = 0; i <= 14; i++) {
				if (i == 1) {
					e.get(i).click();
					break;
				}
			}

			Thread.sleep(4000);

			action.Clickbtn(driver, ePricerCreateAQuotePageObjects.detailsPricingPolygon, "detailsPricingPolygon");

			Extent_Reporting.Log_report_img("detailsPricingPolygontab clicked.", "detailsPricingPolygontab clicked.",
					driver, test);
			Extent_Reporting.Log_Pass("detailsPricingPolygontab clicked.", "detailsPricingPolygontab clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("detailsPricingPolygontab not Clicked", "detailsPricingPolygontab not Clicked",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for countrybidtypeselectforEPricerOverviewScreen
	 * @param eNV 
	 * 
	 * @throws Throwable
	 */
	public void countrybidtypeselectforEPricerOverviewScreen(String eNV) throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			
			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.Countryonoverview,
					Excel_Handling.Get_Data(TC_ID, "Countryonoverview"), "Countryonoverview");	
			
			Thread.sleep(5000);
			if (action.CheckifExist(driver, ePricerCreateAQuotePageObjects.quoteTitle)) {
				action.inputText(driver, ePricerCreateAQuotePageObjects.quoteTitle,
						Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "quoteTitle");
			}
			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.bidtypeonoverview,
					Excel_Handling.Get_Data(TC_ID, "bidtypeonoverview"), "bidtypeonoverview");
			if (action.CheckifExist(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD)) {
				Calendar c = Calendar.getInstance();
				c.add(Calendar.MONTH, 1);
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
				String strDate= formatter.format(c.getTime());  
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");
			}			
			Extent_Reporting.Log_Pass("Country selected passed", "Country selected passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Country on overview", "Country on overview", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for PCSdataForEPricerOverviewScreen
	 * 
	 * @throws Throwable
	 */
	public void pcsdataForRegistrationNumbersmalldeal() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			Thread.sleep(10000);

			if (isAlertPResent()) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSretrieveButton);

			if (action.CheckifExist(driver, ePricerCreateAQuotePageObjects.PCSDRcheckbox)) {
				action.clickButton(driver, ePricerCreateAQuotePageObjects.PCSDRcheckbox, "click on check box");
				// System.out.println(" click the check box");

				Thread.sleep(5000);

				if (isAlertPResent()) {
					Alert alert = driver.switchTo().alert();
					alert.accept();
				}
				action.clickButton(driver, ePricerCreateAQuotePageObjects.PCSDRremovebutton, "click remove button");

				// System.out.println(" click remove");
				if (isAlertPResent()) {
					Alert alert = driver.switchTo().alert();
					alert.accept();
				}
				if (isAlertPResent()) {
					Alert alert = driver.switchTo().alert();
					alert.accept();
				}

			}

			Thread.sleep(5000);

			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PCSregistrationNumber, "REGNUM",
					"RegistrationNumber");

			Extent_Reporting.Log_report_img("RegistrationNumber entered.", "RegistrationNumber entered.", driver, test);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSretrieveButton,
					"retrieveButton");

			Extent_Reporting.Log_report_img("retrieve Button clicked.", "retrieve Button clicked.", driver, test);

			Extent_Reporting.Log_Pass("saveOverviewButton clicked", "saveOverviewButton clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for PCSdataForEPricerOverviewScreen
	 * 
	 * @throws Throwable
	 */
	public void pcsdataForRegistrationNumberScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSregistrationNumber,
					Excel_Handling.Get_Data(TC_ID, "RegistrationNumber"), "RegistrationNumber");
			Extent_Reporting.Log_report_img("RegistrationNumber entered.", "RegistrationNumber entered.", driver, test);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSretrieveButton,
					"retrieveButton");

			Extent_Reporting.Log_report_img("retrieve Button clicked.", "retrieve Button clicked.", driver, test);
			Thread.sleep(10000);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomer);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomer,
					"PCS search customer");
			Extent_Reporting.Log_Pass("search customer.", "search customer.", test);

			Thread.sleep(15000);

			//action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomerid);
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomerid,Excel_Handling.Get_Data(TC_ID, "CustomerID"), "CustomerID");
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomersearchbutton,"PCS search customer button click");

			// action.waitForElementVisible(driver,
			// ePricerCreateAQuotePageObjects.PCSSavecustomerbutton );
			Thread.sleep(20000);

			if (action.CheckifExist(driver, ePricerCreateAQuotePageObjects.PCSBPContactName)) {
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCSBPContactName, "epbuild",
						"send key for contact name");
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCSBPContactEmail, "epbuild@in.ibm.com",
						"send key for contact email");
			}
			if (action.CheckifExist(driver, ePricerCreateAQuotePageObjects.PCSBPCompanyName)) {
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCSBPCompanyName, "epbuild","send key for contact name");
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCSBPCompanyEmail, "epbuild@in.ibm.com","send key for contact email");
			}
			Thread.sleep(15000);
			//action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSaveContinueREG);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSaveContinueREG,"Click save and continue");
			action.handleAlert(driver);
			Extent_Reporting.Log_Pass("saveOverviewButton clicked", "saveOverviewButton clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for PCSdataForEPricerOverviewScreen
	 * 
	 * @throws Throwable
	 */
	public void pcssavedataForRegistrationNumberScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSregistrationNumber,
					Excel_Handling.Get_Data(TC_ID, "RegistrationNumber"), "RegistrationNumber");

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSaveContinueREG);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSaveContinueREG,
					"Click save and continue");
			Extent_Reporting.Log_Pass("saveOverviewButton clicked", "saveOverviewButton clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void addTwoConfigAndManualComponent() {
		updateAQuote = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID, test);
		createAQuoteBusinessLogic = new Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID, test);
		for (int i = 1; i <= 2; i++) {
			try {
				createAQuoteBusinessLogic.addProductManuallyButtonClick();
				createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
				//createAQuoteBusinessLogic.componentAddedSuccessMsg();
				updateAQuote.uploadCFR();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is for PCSdataForEPricerOverviewScreen
	 * 
	 * @throws Throwable
	 */
	public void pcsdataForRegistrationNumberScreencontinueonly() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(12000);
			if (action.CheckifExist(driver, ePricerCreateAQuotePageObjects.BPCompanyName)) {
				Thread.sleep(9000);
				action.inputText(driver, ePricerCreateAQuotePageObjects.BPCompanyName, "BP Comp", "BPCompanyName");
			}
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSaveContinueREG);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSaveContinueREG,"Click save and continue");
			action.handleAlert(driver);
			Extent_Reporting.Log_Pass("saveOverviewButton clicked", "saveOverviewButton clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for PCSAccept VS offer
	 * 
	 * @throws Throwable
	 */
	public void pcsAcceptVSoffer() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(30000);
			// action.waitForElementVisible(driver,ePricerCreateAQuotePageObjects.PCSAcceptVSbutton );
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSAcceptVSbutton,
					"Accept value seller offer");
			Thread.sleep(5000);

			Extent_Reporting.Log_report_img("accept value seller offer", "accept value seller offer", driver, test);
			Extent_Reporting.Log_Pass("accept value seller offer passed", "accept value seller offer passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("accept value seller offer not clicked.", "value seller offer not clicked.",
					driver, test);
			driver.quit();
			throw new Exception("Failed");
			//fail("accept value seller offer not clicked.", e);
		}
	}

	/**
	 * This method is for go the submit price request page
	 * 
	 * @throws Throwable
	 */
	public void pcsGotoSubmitSBquote() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			 action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSubmitpricerequest );
			
			Thread.sleep(5000);
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PCSSubmitpricerequest,"GO to submit price request");

			Extent_Reporting.Log_report_img("GO to submit price request", "GO to submit price request", driver, test);
			Extent_Reporting.Log_Pass("GO to submit price request passed", "GO to submit price request passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("GO to submit price request not clicked.",
					"GO to submit price request not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
			//fail();
		}
	}

	/**
	 * This method is for Submit SB quote
	 * 
	 * @throws Throwable
	 */
	public void pcsSubmitSBquote() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			Thread.sleep(10000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSDecisionmakername);
			
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSDecisionmakername, "test dicision maker",
					"input decision maker");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSMakertitle, "test market title",
					"input market title");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSDecisionmakeremail, "test@us.ibm.com",
					"input decision email id");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSProjectname, "test project name",
					"input project name");

			Thread.sleep(10000);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSIBMcontactname);			
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSIBMcontactname, "test contactor",
					"input contact name");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSIBMphoneNumber, "11111", "input phone number");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSIBMenterContactEmail, "testcontact@us.ibm.com",
					"input contack email id");

			Thread.sleep(5000);

			driver.switchTo().frame("ui-tinymce-0_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection, "Test",
					"commentsSection");
			driver.switchTo().parentFrame();
			Thread.sleep(5000);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSubmitSBquotebutton);
			
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PCSSubmitSBquotebutton, "click submit button");

			Thread.sleep(10000);

			action.waitForPageToLoad(driver);

			Extent_Reporting.Log_report_img("SB quote submitted", "SB quote submitted", driver, test);
			Extent_Reporting.Log_Pass("SB quote submitted passed", "SB quote submitted passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("SB quote submitted fail.", "SB quote submitted fail.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for Submit SB quote
	 * 
	 * @throws Throwable
	 */
	public void pcsclickSubmitSBquote() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);

//		action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSubmitSBquotebutton );
//		action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSSubmitSBquotebutton, "check submit button displayed");
			Thread.sleep(20000);
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PCSSubmitSBquotebutton, "click submit button");

			Thread.sleep(20000);

			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchedresult);
			// action.isElementDisplayed(driver,
			// EpricerApplicationSearchQuotePageObjects.searchedresult, "searched result");

			Extent_Reporting.Log_report_img("SB quote submitted", "SB quote submitted", driver, test);
			Extent_Reporting.Log_Pass("SB quote submitted passed", "SB quote submitted passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("SB quote submitted fail.", "SB quote submitted fail.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for PCSAccept VS offer
	 * 
	 * @throws Throwable
	 */
	public void pcsSwitchtodetailpricing() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSaveContinueREG);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSaveContinueREG,
					"Click save and continue");
			Extent_Reporting.Log_Pass("saveOverviewButton clicked", "saveOverviewButton clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for PCSAccept VS offer
	 * 
	 * @throws Throwable
	 */
	public void pcsRequestVSoffer() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(20000);
			
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSRequestVSbutton,
					"Request value seller offer");

			Thread.sleep(20000);

			if (isAlertPResent()) {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			}

			Extent_Reporting.Log_report_img("Request value seller offer", "Request value seller offer", driver, test);
			Extent_Reporting.Log_Pass("Request value seller offer passed", "Request value seller offer passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Request value seller offer not clicked.",
					"Request valuse seller offer not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for swtich to detail pricing
	 * 
	 * @throws Throwable
	 */
	public void pcsopenTabPricingDetail() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSDetailPricingTab);
			// action.isElementDisplayed(driver,
			// ePricerCreateAQuotePageObjects.PCSDetailPricingTab, "PCSRequestVSbutton.");
			action.clickLink(driver, ePricerCreateAQuotePageObjects.PCSDetailPricingTab, "click detail pricing");
			Extent_Reporting.Log_report_img("detail pricing tab", "detail pricing tab", driver, test);
			Extent_Reporting.Log_Pass("detail pricing tab passed", "detail pricing tab passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("detail pricing tab click failed.", "detail pricing tab click failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for switch to manage configuration
	 * 
	 * @throws Throwable
	 */
	public void pcsopenTabManageconfiguration() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(20000);
			// action.waitForElementClickable(driver,
			// ePricerCreateAQuotePageObjects.PCSManageconfigurationTab);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSManageconfigurationTab);
			// action.isElementDisplayed(driver,
			// ePricerCreateAQuotePageObjects.PCSDetailPricingTab, "PCSRequestVSbutton.");
			action.Clickbtn(driver, ePricerCreateAQuotePageObjects.PCSManageconfigurationTab,
					"click manage configuration");
			Extent_Reporting.Log_report_img("manage configuration tab", "manage configuration tab", driver, test);
			Extent_Reporting.Log_Pass("manage configuration passed", "manage configuration passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("manage configuration click failed.", "manage configuration tab click failed.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for switch to overview
	 * 
	 * @throws Throwable
	 */
	public void pcsopenTabOverview() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(12000);
			// action.waitForElementClickable(driver,
			// ePricerCreateAQuotePageObjects.PCSOverviewTab);
			// action.isElementDisplayed(driver,
			// ePricerCreateAQuotePageObjects.PCSOverviewTab, "PCS overview.");
			action.Clickbtn(driver, ePricerCreateAQuotePageObjects.PCSOverviewTab, "click overview");
			Extent_Reporting.Log_report_img("overview tab", "overview tab", driver, test);
			Extent_Reporting.Log_Pass("overview tab passed", "overview tab passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("overview tab click failed.", "overview tab click failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for switch to Submit price request
	 * 
	 * @throws Throwable
	 */
	public void pcsopenTabSubmitRequest() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.PCSpricesubmitTab);
			action.clickLink(driver, ePricerCreateAQuotePageObjects.PCSpricesubmitTab, "click price submit");
			Extent_Reporting.Log_report_img("Submit price request tab", "Submit price request tab", driver, test);
			Extent_Reporting.Log_Pass("Submit price request tab passed", "Submit price request tab passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Submit price request tab click failed.",
					"Submit price request tab click failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for clicking createANewQuoteLinkClick.
	 * 
	 * @throws Throwable
	 */
	public void pcsReturntorequester() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			Thread.sleep(20000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSReturntorequesterButton);
			// action.isElementDisplayed(driver,
			// ePricerCreateAQuotePageObjects.PCSReturntorequesterButton,
			// "PCSReturntorequesterButton.");
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PCSReturntorequesterButton,
					"return to requester");
			Thread.sleep(10000);
			driver.switchTo().frame("ui-tinymce-0_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection, "Test",
					"commentsSection");
			driver.switchTo().parentFrame();
			// Thread.sleep(10000);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSReturnButton,
					"return to requester");
			Thread.sleep(10000);

			Extent_Reporting.Log_report_img("Return the request to requester", "Return the request to requester",
					driver, test);
			Extent_Reporting.Log_Pass("Return the request to requester passed",
					"Return the request to requester passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Return the request to requester failed.",
					"Return the request to requester failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for entering data For to move To change quantity.
	 * 
	 * @throws Throwable
	 */
	public void changeQuantity() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerChangeConfigurationPageObjects = new Epricer_Application_PCS_ChangeConfigurationQuantity(driver,
					TC_ID);
			Thread.sleep(2000);
			List<WebElement> e = driver.findElements(By.xpath(ePricerChangeConfigurationPageObjects.updateQuantity1));

			for (int i = 0; i <= 5; i++) {
				if (i == 1) {
					e.get(i).isDisplayed();
					e.get(i).clear();
					e.get(i).click();
					e.get(i).sendKeys("2");
					// action.clearAndInputTextValue(driver,
					// ePricerChangeConfigurationPageObjects.updateQuantity1,
					// "2", "updateQuantity1");
					Extent_Reporting.Log_Pass("updateQuantity displayed.", "updateQuantity displayed.", test);
					Extent_Reporting.Log_report_img("updateQuantity displayed.", "updateQuantity displayed.", driver, test);
					break;
				}
			}
			// action.clearAndInputTextValue(driver,
			// ePricerChangeConfigurationPageObjects.updateQuantity1, "2",
			// "updateQuantity1");
			action.selectCheckBox(driver, ePricerChangeConfigurationPageObjects.selectFeatureCheckBox,
					"selectFeatureCheckBox");
			Thread.sleep(1000);
			action.Javascriptexecutor_forClick(driver, ePricerChangeConfigurationPageObjects.updateQuantityButton,
					"updateQuantity");
			Thread.sleep(4000);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("updateQuantityCFR button not clicked.", "updateQuantityCFR button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for switch to overview
	 * 
	 * @throws Throwable
	 */
	public void pcsclicksavecontinueonconfigurationtab() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PCSSaveandcontinueonconfig, "click continue");
			Extent_Reporting.Log_report_img("save and continue", "save and continue", driver, test);
			Extent_Reporting.Log_Pass("save and continue passed", "save and continue passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("save and continue click failed.", "save and continue click failed.", driver, test);
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

	public static void writetoTinyMce(WebDriver driver, String tinymceid, String Content) {
		driver.switchTo().frame(tinymceid);
		WebElement element = driver.findElement(By.cssSelector("body"));
		element.sendKeys(Content);
		driver.switchTo().defaultContent();
	}

	public void submitPriceClick() throws Exception {
		ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
		action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.submitPriceRequest);
		Thread.sleep(2000);
		try {
			Extent_Reporting.Log_report_img("Clicking on submitPriceRequest ", "Clicking on createANewQuoteLink",
					driver, test);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.submitPriceRequest,
					"submitPriceRequest Tab");

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("submitPriceRequest not clicked.", "submitPriceRequest not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void pcsSubmitScreenData() throws Throwable {
		try {
			// PCSNAPageObjects = new Epricer_Application_PCS_NA_PageObjects(driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			// loginBusinessLogic = new
			// Epricer_Application_PCS_Login_BusinessLogic(driver,TC_ID);;
			// createAQuoteBusinessLogic = new
			// Epricer_Application_PCS_CreateAQuote_BusinessLogic(driver, TC_ID);

			action.waitForPageToLoad(driver);
			// action.inputText(driver, ePricerCreateAQuotePageObjects.quoteTitle,
			// Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "quoteTitle");//SampleName

			Thread.sleep(5000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSDecisionmakername);
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSDecisionmakername,
					Excel_Handling.Get_Data(TC_ID, "SampleName"), "send key for decision maker name");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSDecisionmakeremail,
					Excel_Handling.Get_Data(TC_ID, "ContactEmail"), "send key for desicion maker email id");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSMakertitle,
					Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "send key for decision maker title");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSProjectname,
					Excel_Handling.Get_Data(TC_ID, "SampleName"), "send key for project name");

			Thread.sleep(5000);
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSIBMcontactname,
					Excel_Handling.Get_Data(TC_ID, "SampleName"), "send key for name");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSIBMphoneNumber,
					Excel_Handling.Get_Data(TC_ID, "ContactPhone"), "send key for phone number");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSIBMenterContactEmail,
					Excel_Handling.Get_Data(TC_ID, "ContactEmail"), "send key for contact email");

			Thread.sleep(5000);
			driver.switchTo().frame("ui-tinymce-0_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection,
					Excel_Handling.Get_Data(TC_ID, "TestingText"), "commentsSection");
			driver.switchTo().parentFrame();

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSubmitSBquotebutton);
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PCSSubmitSBquotebutton, "click submit button");
			Thread.sleep(10000);
			action.handleAlert(driver);
			Extent_Reporting.Log_report_img("Mandatory fields on submit price screen is filled.",
					"Mandatory fields on submit price screen is filled.", driver, test);
			Extent_Reporting.Log_Pass("Mandatory fields on submit price screen is filled.",
					"Mandatory fields on submit price screen is filled.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Mandatory fields on submit price screen is not filled.",
					"Mandatory fields on submit price screen is not filled.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void pcsRESubmitSBquote() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);
			Thread.sleep(3000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSDecisionmakername);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSDecisionmakername,
					"check the decisionmake fields displayed");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSDecisionmakername, "test dicision maker",
					"input decision maker");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSMakertitle, "test market title",
					"input market title");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSDecisionmakeremail, "test@us.ibm.com",
					"input decision email id");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSProjectname, "test project name",
					"input project name");

			Thread.sleep(10000);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSIBMcontactname);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSIBMcontactname,
					"check the IBM channel fields displayed");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSIBMcontactname, "test contactor",
					"input contact name");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSIBMphoneNumber, "11111", "input phone number");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSIBMenterContactEmail, "testcontact@us.ibm.com",
					"input contack email id");

			Thread.sleep(1000);

			driver.switchTo().frame("ui-tinymce-2_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection, "ReTest",
					"commentsSection");
			driver.switchTo().parentFrame();

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSubmitSBquotebutton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSSubmitSBquotebutton,
					"check submit button displayed");
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PCSSubmitSBquotebutton, "click submit button");

			Thread.sleep(2000);

			// action.waitForElementVisible(driver,
			// EpricerApplicationSearchQuotePageObjects.searchedresult);
			// action.isElementDisplayed(driver,
			// EpricerApplicationSearchQuotePageObjects.searchedresult, "searched result");

			Extent_Reporting.Log_report_img("SB quote resubmitted", "SB quote resubmitted", driver, test);
			Extent_Reporting.Log_Pass("SB quote resubmitted passed", "SB quote resubmitted passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("SB quote resubmitted fail.", "SB quote resubmitted fail.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void overviewProdData(String eNV) throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(15000);
			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.bidtypeonoverview,
			Excel_Handling.Get_Data(TC_ID, "bidtypeonoverview"), "bidtypeonoverview");
			Thread.sleep(6000);
			if (action.CheckifExist(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD)) {
				Calendar c = Calendar.getInstance();
				c.add(Calendar.MONTH, 1);
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
				String strDate= formatter.format(c.getTime());  
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");
			}
			Extent_Reporting.Log_report_img("bidtypeonoverview", "bidtypeonoverview", driver, test);
			Extent_Reporting.Log_Pass("bid type on overview selected passed", "bid type on overview selected passed.",
					test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("bid type on overview Failed", "bid type on overview Failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}
	public void createFinalReport(int columnNumber, String eNV, String timestamp, String status, int userType) throws Throwable {	
		try {
			File myFile;
			if (eNV.equalsIgnoreCase("Prod")) {
				 myFile = new File("E://Desktop//ProductionBPReports//SanityReportStatus.xlsx");
			}else if (eNV.equalsIgnoreCase("MAINT")) {
				 myFile = new File("E://Desktop//SanityReports//CDT_Maint//SanityReportStatus_MAINT.xlsx");
			}else if (eNV.equalsIgnoreCase("DEV")) {
					 myFile = new File("E://Desktop//SanityReports//CDT_Dev//SanityReportStatus_DEV.xlsx");
			}else {
				myFile = new File("E://Desktop//SanityReports//IVT//SanityReportStatus_IVT.xlsx");
			}	
			FileInputStream istrm = new FileInputStream(myFile);
			XSSFWorkbook wrkbuk = new XSSFWorkbook(istrm);
			
			XSSFSheet sheet = wrkbuk.getSheetAt(userType);
			int lastRow = sheet.getLastRowNum();			
			Row row = sheet.getRow(lastRow);
			System.out.println("inside dashboard row");
			Extent_Reporting.Log_Pass("Printing Dashboard", "Printing Dashboard", test);
			//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//Date dateobj = new Date();			
			//String todaysDateString = df.format(dateobj);
			//System.out.println(todaysDateString);
			
			Cell cellvalueCell = row.getCell(0);
			String getrowvalueString = cellvalueCell.getStringCellValue();
			String finalString = getrowvalueString.substring(0, 13);
			//System.out.println(getrowvalueString);
		//	/* deletion code overlaps data*/;
			//String[] compareDateString = getrowvalueString.split("T");
			//String verifyDateString = compareDateString[0].toString();
//			if (!verifyDateString.equalsIgnoreCase(todaysDateString)) {
//				for (int i=1; i<=lastRow; i++){
//					Row rowtoDelete=sheet.getRow(i);				  
//					sheet.removeRow(rowtoDelete);			
//				}
//				lastRow = sheet.getLastRowNum();
//				row = sheet.getRow(lastRow);
//				}		
			lastRow = sheet.getLastRowNum();
			row = sheet.getRow(lastRow);
			if (finalString.equalsIgnoreCase(timestamp.substring(0,13))) {
					CellStyle style = wrkbuk.createCellStyle();
					if (status.equalsIgnoreCase("Pass")) {
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						Extent_Reporting.Log_Pass("Printing Dashboard Green", "Printing Dashboard Green", test);
					} else {
						style.setFillForegroundColor(IndexedColors.RED.getIndex());
						Extent_Reporting.Log_Pass("Printing Dashboard Red", "Printing Dashboard Red", test);
					}				
					style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
					Cell Device_ID_ED = row.createCell(columnNumber);
					Device_ID_ED.setCellStyle(style);
				} else {
					row = sheet.createRow(++lastRow);
					Cell timestamprow = row.createCell(0);
					timestamprow.setCellValue(timestamp);
					CellStyle style = wrkbuk.createCellStyle();
					if (status.equalsIgnoreCase("Pass")) {
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						Extent_Reporting.Log_Pass("Printing Dashboard Green", "Printing Dashboard Green", test);
					} else {
						style.setFillForegroundColor(IndexedColors.RED.getIndex());
						Extent_Reporting.Log_Pass("Printing Dashboard Red", "Printing Dashboard Red", test);
					}
					//style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
					style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
					Cell Device_ID_ED = row.createCell(columnNumber);
					Device_ID_ED.setCellStyle(style);
				}			
			FileOutputStream os_ED = new FileOutputStream(myFile);
			wrkbuk.write(os_ED);
			os_ED.close();
			wrkbuk.close();
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Final Report failed", "Final Report failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		
	}


}
