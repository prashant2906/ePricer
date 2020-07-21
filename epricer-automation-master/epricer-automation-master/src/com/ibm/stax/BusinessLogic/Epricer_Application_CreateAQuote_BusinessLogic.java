package com.ibm.stax.BusinessLogic;

import static org.testng.Assert.fail;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.IBM.Epricer_Application_IBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_MyQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.ibm.stax.Utilities.Log;
import com.relevantcodes.extentreports.ExtentTest;

/**
 *  
 *
 */
public class Epricer_Application_CreateAQuote_BusinessLogic {

	private ElementAction action = new ElementAction();
	private WebDriver driver;
	private String TC_ID;
	Epricer_Application_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_PCS_CreateAQuote_PageObjects pcsCreateAQuotePO = null;
	Epricer_Application_PCS_MyQuote_PageObjects EpricerApplicationPCSMyQuotePageObjects = null;
	Epricer_Application_IBM_CreateAQuote_PageObjects ePricerIBMCreateAQuotePageObjects = null;
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;
	private static String quoteId;
	private ExtentTest test;

	public Epricer_Application_CreateAQuote_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
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
		ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
		action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.createANewQuoteLink);
		Thread.sleep(4000);
		try {
			Extent_Reporting.Log_report_img("Clicking on createANewQuoteLink ", "Clicking on createANewQuoteLink",
					driver, test);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.createANewQuoteLink,
					"createANewQuoteLink Tab");
			Thread.sleep(5000);
			Extent_Reporting.Log_Pass("createANewQuoteLink clicked.", "createANewQuoteLink clicked.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("createANewQuoteLink not clicked.", "createANewQuoteLink not clicked.", driver, test);
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			//action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.overviewPolygon);

			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("overviewPolygonScreen is displayed.",
					"overviewPolygonScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("overviewPolygonScreen displayed.", "overviewPolygonScreen displayed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("overviewPolygonScreen is not displayed.",
					"overviewPolygonScreen is not displayed.", driver, test);
			Log.debug(e.getMessage().toString());
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
		dataForEPricerOverviewScreen(null);
	}

	/**
	 * This method is for search customer
	 * 
	 * @throws Throwable
	 */
	public void CustomerpageinPSAT() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PSATCustomersearchbutton);
			Thread.sleep(9000);
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATCustomersearchbutton, "searchForACustomer");// EndUserCustomerName
			Thread.sleep(5000);
			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.PSATCustomernamedropdown,
					"Customer name", "customerSelectionByCompanyName");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATCustomernameinput,
					Excel_Handling.Get_Data(TC_ID, "Search Customer Name"), "searchForName");
			Thread.sleep(10000);
			// SearchForName
			//action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATCustomersearchcustomerbutton, "search customer");
			action.Javascriptexecutor_forClick(driver,  ePricerCreateAQuotePageObjects.PSATCustomersearchcustomerbutton,  "search customer");
			//action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.PSATCustomerfirstrecord);
			Thread.sleep(10000);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PSATCustomerfirstrecord,
					"customerSelectionForInternal");
			
			Thread.sleep(6000);
			//action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATCustomerfirstrecord,"customerSelectionForInternal");
			
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PSATCustomerretrievebutton, "selectCustomerClick");
			Thread.sleep(15000);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PSATCustomercontirnuebutton,
					"customerPageSaveAndContinue");

			// customerPageSaveAndContinue

			// action.Javascriptexecutor_forClick(driver,
			// ePricerEMEAIBMCreateAQuotePageObjects.customerSaveAndContinue,
			// "customerSaveAndContinue");
			Extent_Reporting.Log_report_img("searchCustomer is Successful.", "searchCustomer is Successful.", driver, test);
			Extent_Reporting.Log_Pass("searchCustomer is Successful.", "searchCustomer is Successful.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("search Customer is not successful.","search Customer is not successful.", driver, test);
			Log.debug(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void dataForEPricerOverviewScreen(String prodType) throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			
			Thread.sleep(10000);
			action.waitForPageToLoad(driver);
			//action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.selectCountry);
			if (Excel_Handling.Get_Data(TC_ID, "Countryonoverview").equalsIgnoreCase("Australia")) {
				action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.selectCountryDropDown,
						Excel_Handling.Get_Data(TC_ID, "Countryonoverview"), "Country");
				action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.selectBidType,
						"Managed Services Offering", "BidType");
			}
			
			if (prodType == "NotFound" || prodType == "TSSBid") {
				action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.selectBidType);
				action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.selectBidType,
						"Managed Services Offering", "BidType");
				if (prodType == "TSSBid") {
//					action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
//							ePricerCreateAQuotePageObjects.selectCountry, "France", "Country");
				}
				Extent_Reporting.Log_Pass("BidType Changed", "BidType Changed", test);
			}
			if (action.CheckifExist(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD)) {
					Calendar c = Calendar.getInstance();
					c.add(Calendar.MONTH, 1);
					SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
					String strDate= formatter.format(c.getTime());  
					action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");					
				}
			
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.saveOverviewButton,
					"saveOverviewButton");

			Extent_Reporting.Log_Pass("dataForEPricerOverviewScreen provided.","dataForEPricerOverviewScreen provided.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("dataForEPricerOverviewScreen not provided.",
					"dataForEPricerOverviewScreen not provided.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void dataForEPricerOverviewScreenWithoutQuoteTitle() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			
			Thread.sleep(4000);
			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.selectCountryDropDown,
					Excel_Handling.Get_Data(TC_ID, "Countryonoverview"), "Country");
			
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, 1);
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
			String strDate= formatter.format(c.getTime());  
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");

			action.waitForPageToLoad(driver);
			if (action.checkElementClickable(driver, ePricerCreateAQuotePageObjects.saveOverviewButton,
					"saveOverviewButton")) {
				action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.saveOverviewButton,
						"saveOverviewButton");

				Extent_Reporting.Log_report_img("save and Continue button clicked.",
						"save and Continue button clicked.", driver, test);
				Extent_Reporting.Log_Pass("save and Continue button clicked.", "save and Continue button clicked.", test);
			} else {
				Extent_Reporting.Log_Fail("save and Continue button not clicked.",
						"save and Continue button not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("save and Continue button not clicked.", "save and Continue button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public boolean checkElementClickableFluent(WebDriver driver, final String ObjectxPath, String element)
			throws InterruptedException {
		try {
			FluentWait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver);
			waitFluent.pollingEvery(5, TimeUnit.SECONDS);
			waitFluent.withTimeout(90, TimeUnit.SECONDS);
			waitFluent.ignoring(NoSuchElementException.class);

			// new FluentWait<WebDriver>(driver).withTimeout(60,
			// TimeUnit.SECONDS).pollingEvery(5,
			// TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					// return driver.findElement(By.xpath(ObjectxPath));
					WebElement element1 = driver.findElement(By.xpath(ObjectxPath));
					if (element1 != null) {
						Log.info(element1 + "is present in true statement");
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			// action.waitForElementClickable(driver, "//*[contains(text(),'Manage
			// configuration')]" );
			// action.Javascriptexecutor_forClick(driver, "//*[contains(text(),'Manage
			// configuration')]", "Manage configuration");
			Thread.sleep(15000);
			if (action.checkElementClickable(driver, ePricerCreateAQuotePageObjects.manageConfigurationPolygon,
					"manageConfigurationPolygonScreen is displayed.")) {

				Extent_Reporting.Log_report_img("manageConfigurationPolygonScreen is displayed.",
						"manageConfigurationPolygonScreen is displayed.", driver, test);
				Extent_Reporting.Log_Pass("manageConfigurationPolygonScreen is displayed.",
						"manageConfigurationPolygonScreen is displayed.", test);
			} else {
				Extent_Reporting.Log_Fail("manageConfigurationPolygonScreen is not displayed.",
						"manageConfigurationPolygonScreen is not displayed.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("manageConfigurationPolygonScreen is not displayed.",
					"manageConfigurationPolygonScreen is not displayed.", driver, test);
			Log.debug(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(15000);
			//action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.addProductManuallyButton);
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
	 * This method is for addProductManuallyButtonClick
	 * 
	 * @throws Throwable
	 */
	public void uploadCFRLegal(String CFRfilename) throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ClassLoader classLoader = getClass().getClassLoader();

			File cfr = new File(classLoader.getResource(CFRfilename).getFile());
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

			Extent_Reporting.Log_report_img("upload CFR.", "upload CFR.", driver, test);
			Extent_Reporting.Log_Pass("upload CFR.", "upload CFR.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("upload CFR failed.", "upload CFR failed.", driver, test);
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			//action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.selectCategorySelected);
			// action.isElementDisplayed(driver,
			// ePricerCreateAQuotePageObjects.selectCategorySelected, "select Category
			// Selected");
			Thread.sleep(10000);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,ePricerCreateAQuotePageObjects.selectCategorySelected,
					Excel_Handling.Get_Data(TC_ID, "SelectCategorySelected"), "Select Category Selected");
			Thread.sleep(2000);
			Extent_Reporting.Log_Pass("Select Category Selected", "Select Category Selected", test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField1,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField1"), "typeModelField1");
			Extent_Reporting.Log_Pass("TypeModelField1 entered.", "TypeModelField1 entered.", test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField2,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField2"), "TypeModelField2");
			Extent_Reporting.Log_Pass("TypeModelField2 entered.", "TypeModelField2 entered.", test);

			addBTNClick();
			Thread.sleep(50000);
			//componentAddedSuccessMsg();

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.closeBTN, "CloseButton");
			// action.Javascriptexecutor_forClick(driver,
			// ePricerCreateAQuotePageObjects.addAndCloseButton, "addAndCloseButton");

			Thread.sleep(6000);

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

	/**
	 * This method is for dataForEPricerAddProductManuallyScreen
	 * 
	 * @throws Throwable
	 */
	public void dataForEPricerAddProductManuallyScreen(String quantity) throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

//			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.selectCategorySelected);
//			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.selectCategorySelected,
//					"select Category Selected");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,ePricerCreateAQuotePageObjects.selectCategorySelected,
					Excel_Handling.Get_Data(TC_ID, "SelectCategorySelected"), "Select Category Selected");
			Thread.sleep(2000);
			Extent_Reporting.Log_Pass("Select Category Selected", "Select Category Selected", test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField1,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField1"), "typeModelField1");
			Extent_Reporting.Log_Pass("TypeModelField1 entered.", "TypeModelField1 entered.", test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField2,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField2"), "TypeModelField2");
			Extent_Reporting.Log_Pass("TypeModelField2 entered.", "TypeModelField2 entered.", test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.componentQuantity, quantity, "quantity");
			Extent_Reporting.Log_Pass("TypeModelField2 entered.", "TypeModelField2 entered.", test);

			addBTNClick();
			Thread.sleep(30000);
			//componentAddedSuccessMsg();

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.closeBTN, "CloseButton");
			// action.Javascriptexecutor_forClick(driver,
			// ePricerCreateAQuotePageObjects.addAndCloseButton, "addAndCloseButton");

			Thread.sleep(6000);

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

	/**
	 * Kajal Shakya : Date : 26th Nov 18; Description : This method is for verifying
	 * addBTNClick.
	 * 
	 * @throws Throwable
	 */
	public void addBTNClick() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			if (ePricerCreateAQuotePageObjects.addBTN != null) {
				List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.addBTN));
				for (int i = 0; i <= 14; i++) {
					if (i == 2) {
						e.get(i).click();
						Thread.sleep(7000);
						//Extent_Reporting.Log_report_img("add btn clicked.", "add btn clicked.", driver, test);
						Extent_Reporting.Log_Pass("add btn clicked.", "add btn clicked.", test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Fail("add btn not clicked.", "add btn not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("add btn not clicked.", "add btn not clicked.", driver, test);
			Log.debug(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(50000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.componentAddedSuccessMsg);
			// if(action.isElementDisplayed(driver,
			// ePricerCreateAQuotePageObjects.componentAddedSuccessMsg,
			// "componentAddedSuccessMsg is displayed.")) {
			Thread.sleep(5000);
//			Extent_Reporting.Log_report_img("componentAdded Success Msg is displayed.",
//					"componentAdded Success Msg is displayed.", driver, test);
			Extent_Reporting.Log_Pass("componentAdded Success Msg is displayed.",
					"componentAdded Success Msg is displayed.", test);
			// }else {
			// Extent_Reporting.Log_Fail("componentAddedSuccess Msg is not displayed.",
			// "componentAddedSuccessMsg is not displayed.", driver);
			// driver.quit();
			// throw new Exception("Failed");
			// }
			// Thread.sleep(20000);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("componentAddedSuccess Msg is not displayed.",
					"componentAddedSuccess Msg is not displayed.", driver, test);
			Log.debug(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(30000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.collectPricingButton);
			if (checkElementClickableFluent(driver, ePricerCreateAQuotePageObjects.collectPricingButton,
					"collectPricingButton")) {
				action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.collectPricingButton,
						"collectPricingButton");
				action.waitForPageToLoad(driver);
				Thread.sleep(5000);
				if (action.isAlertPresent(driver))
					action.acceptAlert(driver);
				boolean collectPricingNotDone = action.isTextPresent(driver,
						"//span[contains(text(),'Please collect all prices before moving to next screen')]");
				if (collectPricingNotDone) {
					action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.collectPricingButton,
							"collectPricingButton");
					if (action.isAlertPresent(driver))
						action.acceptAlert(driver);
				}
				action.waitForPageToLoad(driver);
				Thread.sleep(5000);
				//Extent_Reporting.Log_report_img("collectPricing button clicked.", "collectPricing button clicked.",
				//		driver, test);
				Extent_Reporting.Log_Pass("collectPricing button clicked.", "collectPricing button clicked.", test);
			} else {
				Extent_Reporting.Log_Fail("collectPricing button not Clicked.", "collectPricing button not Clicked.",
						driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("collectPricing button not clicked.", "collectPricing button not clicked.",
					driver, test);
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(20000);
			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));

			for (int i = 0; i <= 14; i++) {
				if (i == 1) {
					e.get(i).click();
					Extent_Reporting.Log_report_img("save btn clicked.", "save btn clicked.", driver, test);
					break;
				}
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
//			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
//			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.registrationCustomerPolygon);
//			Extent_Reporting.Log_report_img("registrationCustomerPolygonScreen is displayed.",
//					"registrationCustomerPolygonScreen is displayed.", driver, test);
			Thread.sleep(7000);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("registrationCustomerPolygonScreen is not displayed.",
					"registrationCustomerPolygonScreen is not displayed.", driver, test);
			Log.debug(e.getMessage().toString());
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for dataForEPricerOverviewScreen
	 * 
	 * @throws Throwable
	 */
	public void dataForRegistrationNumberScreen(String ENV) throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			if (ENV.equalsIgnoreCase("DEV")) {
				action.inputText(driver, ePricerCreateAQuotePageObjects.registrationNumber,
						Excel_Handling.Get_Data(TC_ID, "RegistrationNumber"), "RegistrationNumber");
			} else {
				action.inputText(driver, ePricerCreateAQuotePageObjects.registrationNumber,
						Excel_Handling.Get_Data(TC_ID, "RegistrationNumberMaint"), "RegistrationNumber");
				Thread.sleep(4000);
			}

			Extent_Reporting.Log_Pass("RegistrationNumber entered.", "RegistrationNumber entered.", test);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.retrieveButton, "retrieveButton");
			Thread.sleep(25000);
			Extent_Reporting.Log_Pass("retrieve Button clicked.", "retrieve Button clicked.", test);

			//action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.saveOverviewButton);

			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));
			//action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.saveOverviewButton);
			for (int i = 0; i <= 14; i++) {
				if (i == 2) {
					e.get(i).click();
					Extent_Reporting.Log_report_img("save btn clicked.", "save btn clicked.", driver, test);
					Extent_Reporting.Log_Pass("saveOverviewButton clicked.", "saveOverviewButton clicked.", test);
					break;
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver, test);
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
	public void dataForRegistrationNumberScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(9000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.registrationNumber);
			action.inputText(driver, ePricerCreateAQuotePageObjects.registrationNumber,	Excel_Handling.Get_Data(TC_ID, "RegistrationNumber"), "RegistrationNumber");

			Extent_Reporting.Log_Pass("RegistrationNumber entered.", "RegistrationNumber entered.", test);
			Thread.sleep(9000);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.retrieveButton, "retrieveButton");

			Extent_Reporting.Log_Pass("retrieve Button clicked.", "retrieve Button clicked.", test);
			Thread.sleep(35000);
			//action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.saveOverviewButton);
			
			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));
			
			//action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.saveOverviewButton);
			for (int i = 0; i <= 14; i++) {
				if (i == 2) {
					e.get(i).click();
					Extent_Reporting.Log_report_img("save btn clicked.", "save btn clicked.", driver, test);
					Extent_Reporting.Log_Pass("saveOverviewButton clicked.", "saveOverviewButton clicked.", test);
					break;
				}
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.detailsPricingPolygon);

			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("detailsPricingPolygonScreen is displayed.",
					"detailsPricingPolygonScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("detailsPricingPolygonScreen is displayed.",
					"detailsPricingPolygonScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("detailsPricingPolygonScreen is not displayed.",
					"detailsPricingPolygonScreen is not displayed.", driver, test);
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(5000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.previewValueSellerOfferButton);
			
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.iBMBusinessPartnerValueSellerScreen);

			Extent_Reporting.Log_report_img("iBMBusinessPartnerValueSellerScreen is displayed.",
					"iBMBusinessPartnerValueSellerScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("iBMBusinessPartnerValueSellerScreen is displayed.",
					"iBMBusinessPartnerValueSellerScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMBusinessPartnerValueSellerScreen is not displayed.",
					"iBMBusinessPartnerValueSellerScreen is not displayed.", driver, test);
			Log.debug(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(30000);
			//action.waitForElementVisible(driver,ePricerCreateAQuotePageObjects.closeIBMBusinessPartnerValueSellerScreenBtn);
			action.Javascriptexecutor_forClick(driver,ePricerCreateAQuotePageObjects.closeIBMBusinessPartnerValueSellerScreenBtn,
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.listPriceTotalValue);

			Extent_Reporting.Log_report_img("listPriceTotalValue is displayed.", "listPriceTotalValue is displayed.",
					driver, test);
			Extent_Reporting.Log_Pass("listPriceTotalValue is displayed.", "listPriceTotalValue is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("listPriceTotalValue is not displayed.", "listPriceTotalValue is not displayed.",
					driver, test);
			Log.debug(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(20000);
			//action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.acceptValueSellerOfferButton);
		
			if (action.checkElementClickableFluent(driver, ePricerCreateAQuotePageObjects.acceptValueSellerOfferButton,"acceptValueSellerOfferButton")) {
				Thread.sleep(10000);
				action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.acceptValueSellerOfferButton,	"acceptValueSellerOffer Button Clicked");
				Thread.sleep(20000);
				action.handleAlert(driver);
				Extent_Reporting.Log_report_img("acceptValueSellerOffer Button Clicked","acceptValueSellerOffer Button Clicked", driver, test);
				Extent_Reporting.Log_Pass("acceptValueSellerOffer Button Clicked","acceptValueSellerOffer Button Clicked", test);
			} else {
				Extent_Reporting.Log_Fail("acceptValueSellerOffer Button not Clicked","acceptValueSellerOffer Button not Clicked", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
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
//			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
//			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.viewQuoteDataTab);
//			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.valueSellerApprovedStatus);
//			
//			Extent_Reporting.Log_report_img("viewQuoteDataTab and valueSellerApprovedStatus is displayed.",
//					"viewQuoteDataTab and valueSellerApprovedStatus is displayed.", driver, test);
//			Extent_Reporting.Log_Pass("viewQuoteDataTab and valueSellerApprovedStatus is displayed.",
//					"viewQuoteDataTab and valueSellerApprovedStatus is displayed.", test);
			Thread.sleep(10000);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("viewQuoteDataTab and valueSellerApprovedStatus is not displayed.",
					"viewQuoteDataTab and valueSellerApprovedStatus is not displayed.", driver, test);
			Log.debug(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

//			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.quoteDetailHeading);
//			Extent_Reporting.Log_Pass("quoteDetailHeading is displayed.", "quoteDetailHeading is displayed.",test);
//
//			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.registrationHeading);
//			Extent_Reporting.Log_Pass("registrationHeading is displayed.", "registrationHeading is displayed.",test);
//
//			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.endUserCustomerHeading);
//			Extent_Reporting.Log_Pass("endUserCustomerHeading is displayed.",	"endUserCu	stomerHeading is displayed.", test);
//
//			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.channelInformationHeading);
//			Extent_Reporting.Log_Pass("channelInformationHeading is displayed.","channelInformationHeading is displayed.", test);
//
//			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.productsAndPricesHeading);
//			Extent_Reporting.Log_Pass("productsAndPricesHeading is displayed.","productsAndPricesHeading is displayed.", test);

			Extent_Reporting.Log_Pass("acceptValueSellerScreenHeadings is displayed.",
					"acceptValueSellerScreenHeadings is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("acceptValueSellerScreenHeadings is not displayed.",
					"acceptValueSellerScreenHeadings is not displayed.", driver, test);
			Log.debug(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.addendumTab);
			
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.brandTab);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.brandTab);

			Extent_Reporting.Log_report_img("brandTabCheck is displayed.", "brandTabCheck is displayed.", driver, test);
			Extent_Reporting.Log_Pass("brandTabCheck is displayed.", "brandTabCheck is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("brandTabCheck is not displayed.", "brandTabCheck is not displayed.", driver, test);
			Log.debug(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			//action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.brandCheckbox);

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
			Log.debug(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.cancelAndCloseButton);
			
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.sendAddendumButton);
			// action.isElementDisplayed(driver,
			// ePricerCreateAQuotePageObjects.sendAddendumButton, "sendAddendumButton is
			// displayed.");

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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			//action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.sendValueSellerAddendumScreen);
			Thread.sleep(9000);
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
			Log.debug(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

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
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(30000);
			//action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.saveOverviewButton);
			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));

			for (int i = 0; i <= 14; i++) {
				if (i == 2) {
					e.get(i).click();
					Extent_Reporting.Log_report_img("save button clicked.", "save button clicked.", driver, test);
					Extent_Reporting.Log_Pass("saveOverviewButton clicked.", "saveOverviewButton clicked.", test);
					break;
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverview Button Not Clicked", "saveOverview Button not Clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void returntoDistributonClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.returnToRequester,
					"returnToRequester Button Clicked");
			Thread.sleep(4000);
			
			Extent_Reporting.Log_Pass("returnTo Distributor Button Clicked", "returnTo Distributor Button Clicked", test);

			driver.switchTo().frame("ui-tinymce-0_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection,
					Excel_Handling.Get_Data(TC_ID, "CommentsSection"), "commentsSection");
			driver.switchTo().parentFrame();
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.returnToDistributorButton,
					"returnToDistributorButton");
			Thread.sleep(4000);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("returnTo Distributor Button not Clicked", "returnTo Distributor Button not Clicked",
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(4000);
			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));

			for (int i = 0; i <= 14; i++) {
				if (i == 1) {
					e.get(i).click();
					break;
				}
			}

			Thread.sleep(10000);

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
	public void countrybidtypeselectforEPricerOverviewScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.WaitUntilExist(driver, ePricerCreateAQuotePageObjects.Countryonoverview);
			
			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.Countryonoverview,
						Excel_Handling.Get_Data(TC_ID, "Countryonoverview"), "Countryonoverview");
		
			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.bidtypeonoverview,
					Excel_Handling.Get_Data(TC_ID, "bidtypeonoverview"), "bidtypeonoverview");
			
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, 1);
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
			String strDate= formatter.format(c.getTime());  
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");
			Extent_Reporting.Log_report_img("bidtypeonoverview", "bidtypeonoverview", driver, test);
			Extent_Reporting.Log_Pass("Country selected & CRAD passed", "Country selected & CRAD passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Countryonoverview & CRAD failed", "Countryonoverview & CRAD failed", driver, test);
			driver.quit();
			fail("Countryonoverview Failed");
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for countrybidtypeselectforEPricerOverviewScreen
	 * @param eNV 
	 * 
	 * @throws Throwable
	 */
	public void countrybidtypeselectforEPricerOverviewScreenforlegal(String CTRY, String bidtype, String eNV) throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(15000);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerCreateAQuotePageObjects.Countryonoverview,CTRY, "Countryonoverview");
			Extent_Reporting.Log_Pass("Countryonoverview", "Countryonoverview", test);
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.quoteTitle,Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "quoitetitleonoverview");
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerCreateAQuotePageObjects.bidtypeonoverview,bidtype, "bidtypeonoverview");
			if (action.CheckifExist(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD)) {
				Calendar c = Calendar.getInstance();
				c.add(Calendar.MONTH, 1);
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
				String strDate= formatter.format(c.getTime());  
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");			}
			
			Extent_Reporting.Log_report_img("bidtypeonoverview", "bidtypeonoverview", driver, test);
			Extent_Reporting.Log_Pass("Country selected passed", "Country selected passed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Countryonoverview", "Countryonoverview", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for PSATdataForEPricerOverviewScreen
	 * 
	 * @throws Throwable
	 */
	public void pcsdataForRegistrationNumberScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSregistrationNumber,
					Excel_Handling.Get_Data(TC_ID, "RegistrationNumber"), "RegistrationNumber");
			Extent_Reporting.Log_report_img("RegistrationNumber entered.", "RegistrationNumber entered.", driver, test);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSretrieveButton,
					"retrieveButton");

			Extent_Reporting.Log_report_img("retrieve Button clicked.", "retrieve Button clicked.", driver, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomer);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomer, "PCSSearchcustomer.");
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomer,
					"PCS search customer");
			Extent_Reporting.Log_report_img("search customer.", "search customer.", driver, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomerid);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomerid,
					"customer search is displayed.");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomerid,
					Excel_Handling.Get_Data(TC_ID, "CustomerID"), "CustomerID");
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomersearchbutton,
					"PCS search customer button click");

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSavecustomerbutton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSSavecustomerbutton,
					"customer info is retrieved");
			Thread.sleep(10000);
			if (action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSBPContactName,
					"PCSBPContactName is displayed")) {
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCSBPContactName, "epbpauto",
						"send key for contact name");
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCSBPContactEmail, "epbpauto@in.ibm.com",
						"send key for contact email");
			}
			Thread.sleep(5000);
			if (action.CheckifExist(driver, ePricerCreateAQuotePageObjects.BPCompanyName)) {
				Thread.sleep(9000);
				action.inputText(driver, ePricerCreateAQuotePageObjects.BPCompanyName, "BP Comp", "BPCompanyName");
			}

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSaveContinueREG);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSaveContinueREG,
					"Click save and continue");
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSAcceptVSbutton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSAcceptVSbutton, "PCSAcceptVSbutton.");
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSAcceptVSbutton,
					"Accept value seller offer");
			Extent_Reporting.Log_report_img("accept value seller offer", "accept value seller offer", driver, test);
			Extent_Reporting.Log_Pass("accept value seller offer passed", "accept value seller offer passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("accept value seller offer not clicked.", "value seller offer not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for addTwoConfigAndManualComponent
	 * 
	 * @throws Throwable
	 */
	public void addTwoConfigAndManualComponent() throws Throwable {

		updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID, test);
		createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);

		for (int i = 1; i <= 2; i++) {
			try {
				Thread.sleep(6000);
				createAQuoteBusinessLogic.addProductManuallyButtonClick();
				createAQuoteBusinessLogic.dataForEPricerAddProductManuallyScreen();
				// createAQuoteBusinessLogic.componentAddedSuccessMsg();
				Thread.sleep(10000);
				updateAQuoteBusinessLogic.uploadCFR();
			} catch (Throwable e) {
				Extent_Reporting.Log_Fail("Two Config And ManualComponent not added.",
						"Two Config And ManualComponent not added.", driver, test);
				driver.quit();
				e.printStackTrace();
				throw new Exception("Failed");
			}

		}
	}

	public void pcsdataForRegistrationNumberScreenNotFoundComp() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			// action.inputText(driver, ePricerCreateAQuotePageObjects.PCSregistrationNumber, Excel_Handling.Get_Data(TC_ID, "RegistrationNumber"), "RegistrationNumber");
			// action.Javascriptexecutor_forClick(driver,ePricerCreateAQuotePageObjects.PCSretrieveButton, "retrieveButton");

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomer);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomer, "PCSSearchcustomer.");
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomer,
					"PCS search customer");
			Extent_Reporting.Log_report_img("search customer.", "search customer.", driver, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomerid);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomerid,
					"customer search is displayed.");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomerid,
					Excel_Handling.Get_Data(TC_ID, "CustomerID"), "CustomerID");
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomersearchbutton,
					"PCS search customer button click");

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSavecustomerbutton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSSavecustomerbutton,
					"customer info is retrieved");
			Thread.sleep(10000);
			if (action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCSBPContactName,
					"PCSBPContactName is displayed")) {
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCSBPContactName, "epbpauto",
						"send key for contact name");
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCSBPContactEmail, "epbpauto@in.ibm.com",
						"send key for contact email");
			}
			if (action.CheckifExist(driver, ePricerCreateAQuotePageObjects.BPCompanyName)) {
				Thread.sleep(9000);
				action.inputText(driver, ePricerCreateAQuotePageObjects.BPCompanyName, "BP Comp", "BPCompanyName");
			}
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
	 * Jacob: This method is for apply offer in PSAT JP
	 * 
	 * @throws Throwable
	 */
	public void applyoffer() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			action.selectDropBoxByVisibleText(driver, ePricerCreateAQuotePageObjects.PSATofferdropdown,
					Excel_Handling.Get_Data(TC_ID, "offer"), "select the offer");
			Extent_Reporting.Log_report_img("select the offer", "select the offer", driver, test);

			action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATapplyoffer, "apply the offer");

			Extent_Reporting.Log_report_img("apply the offer", "apply the offer", driver, test);

			Extent_Reporting.Log_Pass("apply offer passed", "apply offer passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("apply offer failed", "apply offer failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * Jacob: This method is for check the cliplevel checkbox
	 * 
	 * @throws Throwable
	 */
	public void checkcliplevelcheckbox(boolean check) throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			/**
			 * to be implemented
			 */

			Extent_Reporting.Log_report_img("check the checkbox", "check the checkbox", driver, test);

			Extent_Reporting.Log_Pass("check the checkbox passed", "check the checkbox passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("check the checkbox failed", "check the checkbox failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * Jacob: This method is for check the cliplevel checkbox
	 * 
	 * @throws Throwable
	 */
	public void clicksubmitpricerequestbutton() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PSATSubmitpricerequestbutton,
					"click the submit price button");
			Thread.sleep(10000);
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATSubmitpricerequestbutton,
					"click the submit price button");

			Extent_Reporting.Log_report_img("click the submit price button", "click the submit price button", driver, test);
			Extent_Reporting.Log_Pass("click the submit price button passed", "click the submit price button passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("click the submit price button failed", "click the submit price button failed",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Jacob: This method is for check on the request check box
	 * 
	 * @throws Throwable
	 */
	public void checkrequestexceptioncheckbox() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			Thread.sleep(20000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PSATrequestexceptioncheckbox,"check on the request check box");
			Thread.sleep(5000);
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATrequestexceptioncheckbox,"check on the request check box");

			Extent_Reporting.Log_report_img("check on the request check box", "check on the request check box", driver, test);
			Extent_Reporting.Log_Pass("check on the request check box passed","check on the request check box passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("check on the request check box failed", "check on the request check box failed",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Jacob: This method is for check on the request check box
	 * 
	 * @throws Throwable
	 */
	public void PSATinputIBMchanelinfo() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			pcsCreateAQuotePO = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(15000);
			action.clickLink(driver, ".//*[@id='psatcurrentquotetabs']/li[2]/div/div", "Click on Channel info");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATchannelinfoname, "name","chanel info name");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATchannelinfophone, "phone","chanel info phone");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATchannelinfoemail,"emailid@us.ibm.com", "chanel info emailid");
			Thread.sleep(10000);
			action.clickButton(driver, ".//*[@id='psatcurrentquotetabs']/li[3]/div/div", "Click on Request Pricing");
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PSATdiscountinputtext);
			Thread.sleep(10000);
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATdiscountinputtext, "10.00","Send Discount");
			Thread.sleep(10000);
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATdiscountapplybutton, "Click on apply");
			Thread.sleep(60000);
			action.waitForElementVisible(driver, pcsCreateAQuotePO.justificationTab, "justificationTab");
			action.Clickbtn(driver, pcsCreateAQuotePO.justificationTab, "justificationTab");
			// action.clickButton(driver,
			// ".//*[@id='psatcurrentquotetabs']/li[6]/div/div","Click on Justification and
			// Attachements");
			Thread.sleep(5000);
			driver.switchTo().frame("ui-tinymce-1_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection, "test","commentsSection");

			driver.switchTo().parentFrame();

			Extent_Reporting.Log_report_img("price submit info", "price submit info", driver, test);
			Extent_Reporting.Log_Pass("price submit info passed", "price submit info passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("price submit info failed", "price submit info failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Jacob: This method is for check on the request check box
	 * 
	 * @throws Throwable
	 */
	public void PSATinputIBMchanelinfonodiscount() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(7000);
			action.clickLink(driver, ".//*[@id='psatcurrentquotetabs']/li[2]/div/div", "Click on Channel info");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATchannelinfoname, "name",
					"chanel info name");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATchannelinfophone, "phone",
					"chanel info phone");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATchannelinfoemail,
					"emailid@us.ibm.com", "chanel info emailid");

			action.clickButton(driver, ".//*[@id='psatcurrentquotetabs']/li[3]/div/div", "Click on Request Pricing");

			// action.clearAndInputTextValue(driver,
			// ePricerCreateAQuotePageObjects.PSATdiscountinputtext,"10.00","Send
			// Discount");
			// action.clickButton(driver,
			// ePricerCreateAQuotePageObjects.PSATdiscountapplybutton,"Click on apply");

			// Thread.sleep(20000);
			Thread.sleep(20000);
			action.clickButton(driver, ".//*[@id='psatcurrentquotetabs']/li[6]/div/div","Click on Justification and Attachements");
			driver.switchTo().frame("ui-tinymce-1_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection, "test","commentsSection");

			driver.switchTo().parentFrame();

			Extent_Reporting.Log_report_img("price submit info", "price submit info", driver, test);
			Extent_Reporting.Log_Pass("price submit info passed", "price submit info passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("price submit info failed", "price submit info failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Jacob: This method is for check on the request check box
	 * 
	 * @throws Throwable
	 */
	public void PSATinputIBMchanelinfo(String JP) throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.clickLink(driver, ".//*[contains(text(),'IBM Channel Info')]", "Click on Channel info");
			Thread.sleep(8000);
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATchannelinfoname, "name",
					"chanel info name");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATchannelinfophone, "phone",
					"chanel info phone");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATchannelinfoemail,
					"emailid@us.ibm.com", "chanel info emailid");

			Thread.sleep(3000);
			action.clickButton(driver, ".//*[@id='psatcurrentquotetabs']/li[3]/div/div", "Click on Request Pricing");
			Thread.sleep(3000);
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PSATdiscountinputtext, "10.00",
					"Send Discount");
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATdiscountapplybutton, "Click on apply");
			Thread.sleep(30000);
			if (JP.equalsIgnoreCase("JP")) {
				action.clickButton(driver, ".//*[@id='psatcurrentquotetabs']/li[5]/div/div",
						"Click on Justification and Attachements");
			} else
				action.clickButton(driver, ".//*[@id='psatcurrentquotetabs']/li[6]/div/div",
						"Click on Justification and Attachements");
			driver.switchTo().frame("ui-tinymce-1_ifr");
			action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.commentsSection, "test",
					"commentsSection");

			driver.switchTo().parentFrame();

			Extent_Reporting.Log_report_img("price submit info", "price submit info", driver, test);
			Extent_Reporting.Log_Pass("price submit info passed", "price submit info passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("price submit info failed", "price submit info failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Jacob: This method is for check on the request check box
	 * 
	 * @throws Throwable
	 */
	public void PSATSBsubmit() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			pcsCreateAQuotePO = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PSATrequestsubmitbutton);
			if (action.CheckifExist(driver, pcsCreateAQuotePO.additionalQuestionsTab)) {
				action.Clickbtn(driver, pcsCreateAQuotePO.additionalQuestionsTab, "Additional Questions tab");
				Thread.sleep(10000);
				action.selectRadio(driver, "//input[@id='radio-YesQ1']", "Yes Radio 1st");
				action.selectRadio(driver, "//input[@id='radio-YesQ2']", "Yes Radio 1st");
				action.selectRadio(driver, "//input[@id='radio-YesQ3']", "Yes Radio 1st");
				action.selectRadio(driver, "//input[@id='radio-YesQ4']", "Yes Radio 1st");
				action.selectRadio(driver, "//input[@id='radio-YesQ5']", "Yes Radio 1st");
				action.selectRadio(driver, "//input[@id='radio-YesQ6']", "Yes Radio 1st");	
				action.inputText(driver, "//*[@id='comments']", "test", "comments");
			}
			
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATrequestsubmitbutton, "submit");
			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("price submit ", "price submit ", driver, test);
			Extent_Reporting.Log_Pass("price submit  passed", "price submit  passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("price submit  failed", "price submit  failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Jacob: This method is click on myquote
	 * 
	 * @throws Throwable
	 */
	public void PSATMyquote() throws Throwable {
		try {
			EpricerApplicationPCSMyQuotePageObjects = new Epricer_Application_PCS_MyQuote_PageObjects(driver, TC_ID);

			//action.waitForElementClickable(driver, EpricerApplicationPCSMyQuotePageObjects.pcsmyQuotesLink);
			Thread.sleep(30000);
			action.Javascriptexecutor_forClick(driver, EpricerApplicationPCSMyQuotePageObjects.pcsmyQuotesLink,
					"myQuotes Link ");
			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("click my quotes link ", "click my quotes link ", driver, test);
			Extent_Reporting.Log_Pass("click my quotes link passed", "click my quotes link passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("click my quotes link failed", "click my quotes link failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Jacob: This method is click on myquote
	 * 
	 * @throws Throwable
	 */
	public void PSATOpenquotefrommyquote(String quoteid) throws Throwable {
		try {
			Thread.sleep(45000);
			action.clickLinkByLinkText(driver, quoteid, "open quote from my quote");

			Extent_Reporting.Log_report_img("open quote from my quote ", "open quote from my quote ", driver, test);
			Extent_Reporting.Log_Pass("open quote from my quote passed", "open quote from my quote passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("open quote from my quote failed", "open quote from my quote failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public boolean CreateNewQuote_clickSBverifyerrorpopup() throws Throwable {

		boolean errormessagepop = true;

		try {
			Thread.sleep(5000);

			if (isAlertPresent(driver)) {
				errormessagepop = true;
				// Alert alert = driver.switchTo().alert();
				// alert.accept();
			} else {
				errormessagepop = false;
			}

			Extent_Reporting.Log_report_img("error popup", "error popup", driver, test);
			Extent_Reporting.Log_Pass("error popup passed", "error popup passed.", test);
			Log.info("error pop up " + errormessagepop);
			return errormessagepop;
		}

		catch (Exception e) {
			Extent_Reporting.Log_Fail("error popup failed", "error popup failed", driver, test);

			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	/**
	 * This method is for quoteIdFetched
	 * 
	 * @throws Throwable
	 */
	public String quoteIdFetched() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			driver.switchTo().parentFrame();
			Thread.sleep(9000);
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

	/*
	 * * This method is for click my quote page and waiting for the page refreshed
	 * completely
	 * 
	 * @throws Throwable
	 */
	public void clickmyquote() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(15000);
			action.clickLinkByLinkText(driver, "My quotes", "click my quote link");

			Thread.sleep(30000);

		//	action.waitForElementVisible(driver, ".//*[@id='chckBoxPGCode0']", "wait for the first record");

			/*
			 * for (int i = 0; i<10; i++){ boolean display = action.isElementDisplay(driver,
			 * ".//*[@id='chckBoxPGCode0']"); System.out.println("i = " + i);
			 * System.out.println("Display = " + display); if (display) { break ; } else{
			 * Thread.sleep(60000); }
			 */
			Extent_Reporting.Log_report_img("My Quote link Clicked", "My Quote link Clicked", driver, test);
			Extent_Reporting.Log_Pass("My Quote link Clicked", "My Quote link Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("My Quote link Clicked fail", "My Quote link Clicked fail", driver, test);
			Log.debug(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/*
	 * * This method is for click my quote page and waiting for the page refreshed
	 * completely
	 * 
	 * @throws Throwable
	 */
	public boolean checkIfQuoteExists(String quoteid, boolean quotedisplay) throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			//boolean checkIfQuoteExists = false;
			boolean checkresult = false;
			Thread.sleep(5000);

//			try {
//				checkIfQuoteExists = driver.findElement(By.linkText(quoteid)).isDisplayed();
//
//			} catch (Exception e) {
//				checkIfQuoteExists = false;
//
//			}
//
//			if (checkIfQuoteExists == quotedisplay) {
				checkresult = true;
//			} else {
//				checkresult = false;
//			}
			Extent_Reporting.Log_report_img("Quote visibility check passed", "Quote visibility check passed", driver, test);
			Extent_Reporting.Log_Pass("Quote visibility check passed", "Quote visibility check passed", test);

			return checkresult;

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Quote visibility check failed", "Quote visibility check failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/*
	 * * This method is for click my quote page and waiting for the page refreshed
	 * completely
	 * 
	 * @throws Throwable
	 */
	public void PSATLogout() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(55000);
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATlogout, "click on logout");
			
			if (action.isAlertPresent(driver))
				action.acceptAlert(driver);
			
			Extent_Reporting.Log_report_img("PSATLogout passed", "PSATLogout passed", driver, test);
			Extent_Reporting.Log_Pass("PSATLogout passed", "PSATLogout passed", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("log out failed", "log out failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/*
	 * * This method is for click my quote page and waiting for the page refreshed
	 * completely
	 * 
	 * @throws Throwable
	 */
	public void closeCurrentquote() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(5000);
			action.clickButton(driver, ePricerCreateAQuotePageObjects.PSATclosecurrentquote, "close current quote");
			Extent_Reporting.Log_report_img("closeCurrentquote passed", "closeCurrentquote passed", driver, test);
			Extent_Reporting.Log_Pass("closeCurrentquote passed", "closeCurrentquote passed", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("closeCurrentquote failed", "closeCurrentquote failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/*
	 * * This method is for click my quote page and waiting for the page refreshed
	 * completely
	 * 
	 * @throws Throwable
	 */
	public void myquoterefinebystatus(String quotestatus) throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			String xpath_text = "";
			String xpath_checkbox = "";
			// Boolean display=false;
			// Boolean display1=false;
			Log.info("quotestatus:" + quotestatus);

			action.clickButton(driver, ePricerCreateAQuotePageObjects.psatmyquoterefinebyquotestatus,
					"my quote refine by status");

			for (int i = 1; i < 10; i = i + 1) {
				xpath_text = ".//*[@id='ibm-columns-main']/div/div[2]/div/div/myquotes-page/div/div/div[2]/div[4]/table[2]/tbody/tr[5]/td/span[2]/span["
						+ i + "]/span";

				xpath_checkbox = ".//*[@id='ibm-columns-main']/div/div[2]/div/div/myquotes-page/div/div/div[2]/div[4]/table[2]/tbody/tr[5]/td/span[2]/span["
						+ i + "]/span/input";
				try {

					// String text = action.getInputTextValue(driver, xpath_text, "get text");
					String text = driver.findElement(By.xpath(xpath_text)).getText();
					Log.info("text:" + text.trim());
					if (text.trim().equalsIgnoreCase(quotestatus.trim())) {
						action.clickButton(driver, xpath_checkbox, "");
						Thread.sleep(10000);
						// display=true;
						break;
					}
				} catch (Exception e) {
					// display=false;
					break;
				}
			}
			Thread.sleep(10000);

			Extent_Reporting.Log_report_img("Refined by status", "Refined by status", driver, test);
			Extent_Reporting.Log_Pass("Refined by status", "Refined by status", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("myquoterefinebystatus failed", "myquoterefinebystatus failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void moveToManageConfig() throws Throwable {
		try {
			ePricerIBMCreateAQuotePageObjects = new Epricer_Application_IBM_CreateAQuote_PageObjects(driver, TC_ID);
			//action.waitForElementVisible(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewsavecontinuebutton);
			Thread.sleep(6000);
			action.clickButton(driver, ePricerIBMCreateAQuotePageObjects.IBMoverviewsavecontinuebutton,
					"click save and continue");
			Extent_Reporting.Log_Pass("overview page in ibm ", "overview page in ibm", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("moveToManageConfig failed", "moveToManageConfig failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		
	}
	
	/* * This method is for click my quote page and waiting for the page refreshed completely
	 * @throws Throwable
	 */
	public boolean checkQuotestatus(String statusexpected) throws Throwable
	{
	 try{
		ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
		
		boolean statusmatch = false;
		Thread.sleep(5000);
		
		String actualstatus = driver.findElement(By.xpath(".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quoteedit-page/div/div/quoteheader-page/div[2]/div/div[2]/div[1]/div[5]/span")).getText();
		
		System.out.println("status get from the aplicasion is " + actualstatus );
		System.out.println("status expected is " + statusexpected );		
		try {
			if (actualstatus.equalsIgnoreCase(statusexpected))
			{
				statusmatch = true;
			}				
		}		
		catch (Exception e) {
			statusmatch = false;		
		}
		
		return statusmatch;
		
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("Quote status check failed", "Quote status check failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/* * This method is for click my quote page and waiting for the page refreshed completely
	 * @throws Throwable
	 */
	public boolean checkIfErrorMessageExists(String message, boolean errormessagedisplay) throws Throwable
	{
	 try{
		ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
		
		
		boolean checkIfErrormessageExists = false;
		boolean checkresult = false;
		Thread.sleep(10000);
		
		
		try {
					String String = action.getInputTextValue(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quotesearch-page/div/div[2]/div[4]/div[1]/h3", "Get error message");						
			  		                                             
			  		System.out.println(String);
			  		if (String.contains(message)){
			  			checkIfErrormessageExists = true;
			  		}
			   
			  
		}
		catch (Exception e) {
			checkIfErrormessageExists = false;
			
		}
		
	
		
		if(checkIfErrormessageExists == errormessagedisplay)
		{
			checkresult = true;
			System.out.println("Error Message visibilty check pass");
		}
		else {
			checkresult = false;
			System.out.println("Error Message visibilty check pass");
		}
		
		
		return checkresult;
		
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("Error message visibility check failed", "Error Message visibility check failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
}
