package com.ibm.stax.BusinessLogic.PCS;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ibm.stax.BusinessLogic.Epricer_Application_CreateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
//import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Kajal Shakya
 *
 */
public class Epricer_Application_PCS_NA_BusinessLogic {

	private ElementAction action = new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;

	ClassLoader classLoader = getClass().getClassLoader();
	File authenticationIBMGUI = new File(classLoader.getResource("AuthenticationIBMGUI.exe").getFile());

	Epricer_Application_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	// Epricer_Application_PCS_ChangeConfigurationQuantity
	// ePricerChangeConfigurationPageObjects=null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = null;
	// Epricer_Application_PCS_NA_PageObjects PCSNAPageObjects=null;
	Epricer_Application_PCS_NA_BusinessLogic PCSNABusinessLogic = null;

	public static String quoteId;

	public Epricer_Application_PCS_NA_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for save and continue button on overview screen written by
	 * Harsha
	 * 
	 * @throws Throwable
	 */
	public void click_on_saveandcontinue() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			// PCSNAPageObjects = new Epricer_Application_PCS_NA_PageObjects(driver, TC_ID);
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
	 * This method is for Registration screen written by Harsha
	 * 
	 * @throws Throwable
	 */
	public void pcs_RegistrationNumberScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			// PCSNAPageObjects = new Epricer_Application_PCS_NA_PageObjects(driver, TC_ID);
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
			Thread.sleep(2000);

			if (action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCS_BPCompanyName,
					"BPCompanyName is displayed")) {
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCS_BPCompanyName, "har",
						"send key for contact name");
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCSBPContactEmail, "haagarwa@cn.ibm.com",
						"send key for contact email");
			}

			if (action.isElementDisplay(driver, ePricerCreateAQuotePageObjects.PCSBPContactName)) {
				action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PCSBPContactName, "test",
						"contact name");
				action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PCSBPContactEmail,
						"test@us.ibm.com", "contact email");
			}

			Thread.sleep(5000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.SaveContinueREG);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.SaveContinueREG,
					"Click save and continue");
			Extent_Reporting.Log_Pass("saveOverviewButton clicked", "saveOverviewButton clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for fill all the mandatory fields on submit screen written by
	 * Harsha
	 * 
	 * @throws Throwable
	 */
	public void fill_mandatory_fields_on_submitscreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			
			action.waitForPageToLoad(driver);

			action.inputText(driver, ePricerCreateAQuotePageObjects.DecisionMakerName, "harsha","send key for decision maker name");
			action.inputText(driver, ePricerCreateAQuotePageObjects.DecisionMakerEmail, "haagarwa@in.ibm.com","send key for desicion maker email id");
			action.inputText(driver, ePricerCreateAQuotePageObjects.DecisionMakerTitle, "agarwal","send key for decision maker title");
			action.inputText(driver, ePricerCreateAQuotePageObjects.ProjectName, "harsha", "send key for project name");

			action.inputText(driver, ePricerCreateAQuotePageObjects.Name, "harsha", "send key for name");
			action.inputText(driver, ePricerCreateAQuotePageObjects.Phonenumber, "9870980989","send key for phone number");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCS_ContactEmail, "haagarwa@in.ibm.com","send key for contact email");

			Extent_Reporting.Log_report_img("Mandatory fields on submit price screen is filled.","Mandatory fields on submit price screen is filled.", driver, test);
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

	/**
	 * This method is for click on submit button written by Harsha
	 * 
	 * @throws Throwable
	 */
	public void click_on_submit_button() throws Throwable {
		try {
			// PCSNAPageObjects = new Epricer_Application_PCS_NA_PageObjects(driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			createAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			action.waitForPageToLoad(driver);

			// action.inputText(driver, ePricerCreateAQuotePageObjects.PCS_discount, "5",
			// "discount quick applied");
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCS_SubmitButton,
					"PCS submit button click");
			Thread.sleep(9000);
			Extent_Reporting.Log_report_img("Submit button is clicked", "Submit button is clicked", driver, test);
			Extent_Reporting.Log_Pass("Submit button is clicked", "Submit button is clicked", test);
			// Thread.sleep(6000);
			Thread.sleep(9000);

			// action.waitForElementVisible(driver,
			// ".//*[@id='currentquotetab']/li/div/div[2]/a", "close the quote page");
			// action.clickButton(driver, ".//*[@id='currentquotetab']/li/div/div[2]/a",
			// "close the quote page");

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Submit button is clicked", "Submit button is clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public String switchPageByURL(String url) throws Exception {
		if (url.equals("")) {
			return null;
		}
		try {
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle))
					continue;
				else {
					driver.switchTo().window(s);
					if (driver.getCurrentUrl().contains(url)) {
						Extent_Reporting.Log_report_img("BPGui Opened", "BPGui Opened", driver, test);
						Extent_Reporting.Log_Pass("BPGui Opened", "BPGui Opened", test);
						return currentHandle;
					} else
						continue;
				}
			}
		} catch (NoSuchWindowException e) {
			System.out.println("Window: " + url + " cound not find!!!" + e.fillInStackTrace());
			Extent_Reporting.Log_Fail("BPGui not Opened", "BPGui  not Opened", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		return null;
	}

	public String quoteIdFetched() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			driver.switchTo().parentFrame();
			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.quoteId));
			for (int i = 0; i <= 10; i++) {
				if (i == 0) {
					quoteId = e.get(i).getText();
					//System.out.println("quoteid:", quoteId[i]);
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
	 * This method is for quoteIdLinkClicked
	 * 
	 * @throws Throwable
	 */
	public void quoteIdLinkClicked() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			String quoteIdLink = "//*[contains(text()," + quoteId + ")]";

			action.Javascriptexecutor_forClick(driver, quoteIdLink, "quoteId Link clicked");

			Extent_Reporting.Log_report_img("quoteId Link clicked", "quoteId Link clicked", driver, test);
			Extent_Reporting.Log_Pass("quoteId Link clicked", "quoteId Link clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteId Link not clicked", "quoteId Link not clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void fill_BP_companyname() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			// PCSNAPageObjects = new Epricer_Application_PCS_NA_PageObjects(driver, TC_ID);
			Thread.sleep(8000);
			if (action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.PCS_BPCompanyName,
					"BPCompanyName is displayed")) {
				action.inputText(driver, ePricerCreateAQuotePageObjects.PCS_BPCompanyName, "har",
						"send key for contact name");
				// action.inputText(driver, ePricerCreateAQuotePageObjects.PCSBPContactEmail,
				// "haagarwa@cn.ibm.com", "send key for contact email");
			}
			Thread.sleep(5000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.SaveContinueREG);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.SaveContinueREG,
					"Click save and continue");
			Extent_Reporting.Log_Pass("saveOverviewButton clicked", "saveOverviewButton clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for Registration screen written by Harsha
	 * 
	 * @throws Throwable
	 */
	public void pcs_RegistrationNumberScreen_VS() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			// PCSNAPageObjects = new Epricer_Application_PCS_NA_PageObjects(driver, TC_ID);
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSregistrationNumber,
					Excel_Handling.Get_Data(TC_ID, "RegistrationNumber"), "RegistrationNumber");
			Extent_Reporting.Log_report_img("RegistrationNumber entered.", "RegistrationNumber entered.", driver, test);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSretrieveButton,
					"retrieveButton");

			Extent_Reporting.Log_report_img("retrieve Button clicked.", "retrieve Button clicked.", driver, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomer);
			// action.isElementDisplayed(driver,
			// ePricerCreateAQuotePageObjects.PCSSearchcustomer, "PCSSearchcustomer.");
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomer,
					"PCS search customer");
			Extent_Reporting.Log_report_img("search customer.", "search customer.", driver, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomerid);
			// action.isElementDisplayed(driver,
			// ePricerCreateAQuotePageObjects.PCSSearchcustomerid, "customer search is
			// displayed.");
			action.inputText(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomerid,
					Excel_Handling.Get_Data(TC_ID, "CustomerID"), "CustomerID");
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSSearchcustomersearchbutton,
					"PCS search customer button click");

			if (action.isElementDisplay(driver, ePricerCreateAQuotePageObjects.PCSBPContactName)) {
				action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PCSBPContactName, "test",
						"BP contact name");
				action.clearAndInputTextValue(driver, ePricerCreateAQuotePageObjects.PCSBPContactEmail,
						"test@us.ibm.com", "BP contact name");

			}

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSSavecustomerbutton);
			// action.isElementDisplayed(driver,
			// ePricerCreateAQuotePageObjects.PCSSavecustomerbutton, "customer info is
			// retrieved");
			Thread.sleep(2000);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.SaveContinueREG);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.SaveContinueREG,
					"Click save and continue");
			Extent_Reporting.Log_Pass("saveOverviewButton clicked", "saveOverviewButton clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for searchQuoteButtonClicked
	 * 
	 * @throws Throwable
	 */
	@SuppressWarnings("static-access")
	public void searchQuoteIdButtonClicked() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(
					driver, TC_ID);
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			Thread.sleep(7000);

			action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.enterQuoteid, "enterQuoteid");

			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).click();
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).clear();
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid))
					.sendKeys(PCSNABusinessLogic.quoteId);

			Extent_Reporting.Log_report_img("Quoteid entered.", "Quoteid entered.", driver, test);

			action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.multicheckBox,
					"multicheckBox clicked.");

			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.searchQuoteButton);
			action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.searchQuoteButton, "searchQuoteButton");

			List<WebElement> e = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.searchQuoteButton));
			for (int i = 0; i <= 5; i++) {
				if (i == 1 || i == 2) {
					e.get(i).click();
					Extent_Reporting.Log_report_img("searchQuoteIDButton clicked", "searchQuoteIDButton clicked",
							driver, test);
					break;
				}
			}
			Thread.sleep(8000);
			Extent_Reporting.Log_report_img("search QuoteID Button clicked.", "search QuoteID Button clicked.", driver,
					test);
			Extent_Reporting.Log_Pass("search QuoteID Button clicked.", "search QuoteID Button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("search QuoteID Button not clicked.", "search QuoteID Button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for searchQuoteButtonClicked
	 * 
	 * @throws Throwable
	 */
	public void searchQuoteButtonClicked() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.enterQuoteid);
			
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).click();
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).sendKeys(quoteId);

			Extent_Reporting.Log_report_img("Quoteid entered.", "Quoteid entered.", driver, test);

			List<WebElement> e = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.searchQuoteButton));
			for (int i = 0; i <= 14; i++) {
				if (i == 1) {
					e.get(i).click();
					Extent_Reporting.Log_report_img("searchQuoteButton clicked", "searchQuoteButton clicked", driver,test);
					Extent_Reporting.Log_Pass("search Quote Button clicked.", "search Quote Button clicked.", test);
					break;
				}
			}

			Extent_Reporting.Log_report_img("Quoteid displayed", "Quoteid displayed.", driver, test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("search Quote Button not clicked.", "search Quote Button not clicked.", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for quoteIdLinkPresent
	 * 
	 * @throws Throwable
	 */
	public void quoteIdLinkPresent() throws Throwable {
		try {
			ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(
					driver, TC_ID);

			// @SuppressWarnings("static-access")
			// String quoteIdLink = "//*[contains(text(),"+PCSNABusinessLogic.quoteId+")]";

			// action.isElementDisplayed(driver, quoteIdLink , "quoteIdLink is present.");
			Thread.sleep(5000);
			String quoteIdLinkCheckbox = "//*[contains(text()," + quoteId + ")]/preceding::input[@title='Check Box']";
			action.Javascriptexecutor_forClick(driver, quoteIdLinkCheckbox, "quoteIdLinkCheckbox clicked");

			Extent_Reporting.Log_report_img("quoteIdLinkCheckbox clicked", "quoteIdLinkCheckbox clicked", driver, test);
			Extent_Reporting.Log_Pass("quoteIdLinkCheckbox clicked", "quoteIdLinkCheckbox clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteIdLinkCheckbox not clicked", "quoteIdLinkCheckbox not clicked", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void save_and_cont_RegistrationScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			// PCSNAPageObjects = new Epricer_Application_PCS_NA_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.SaveContinueREG);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.SaveContinueREG,"Click save and continue");
			Extent_Reporting.Log_Pass("saveOverviewButton clicked", "saveOverviewButton clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver,test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void goto_manage_conf_screen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			// PCSNAPageObjects = new Epricer_Application_PCS_NA_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.PCSManageconfigurationTab);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.PCSManageconfigurationTab,
					"PCSManageconfigurationTab is clicked");
			Extent_Reporting.Log_Pass("PCSManageconfigurationTab clicked", "PCSManageconfigurationTab clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCSManageconfigurationTab not clicked.",
					"PCSManageconfigurationTab not clicked.", driver, test);
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
	public void pricingValueCheck_at_distributorside() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			// get the value of prices at distributor side
			WebElement price_value = driver.findElement(By.xpath(ePricerCreateAQuotePageObjects.pricingValue));
			String price_value_distributor = price_value.getText();
			System.out.println("Inner text is :" + price_value_distributor);

			if (ePricerCreateAQuotePageObjects.pricingValue != null) {
				Extent_Reporting.Log_report_img("pricingValue is calculated.", "pricingValue is calculated.", driver,
						test);
				Extent_Reporting.Log_Pass("pricingValue is calculated.", "pricingValue is calculated.", test);

				Thread.sleep(2000);
				List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));

				for (int i = 0; i <= 14; i++) {
					if (i == 1) {
						Thread.sleep(2000);
						e.get(i).click();
						Extent_Reporting.Log_report_img("save btn clicked.", "save btn clicked.", driver, test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Fail("pricingValue is not calculated.", "pricingValue is not calculated.", driver,
						test);
				driver.quit();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("pricingValue is not calculated.", "pricingValue is not calculated.", driver,
					test);
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
	public void pricingValueCheck_at_SP2_side() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			// get the value of prices at distributor side
			WebElement price_value1 = driver.findElement(By.xpath(ePricerCreateAQuotePageObjects.pricingValue));
			String price_value_distributor1 = price_value1.getText();
			System.out.println("Inner text is :" + price_value_distributor1);

			if (ePricerCreateAQuotePageObjects.pricingValue != null) {
				Extent_Reporting.Log_report_img("pricingValue is calculated.", "pricingValue is calculated.", driver,
						test);
				Extent_Reporting.Log_Pass("pricingValue is calculated.", "pricingValue is calculated.", test);

				Thread.sleep(2000);
				List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));

				for (int i = 0; i <= 14; i++) {
					if (i == 1) {
						Thread.sleep(2000);
						e.get(i).click();
						Extent_Reporting.Log_report_img("save btn clicked.", "save btn clicked.", driver, test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Fail("pricingValue is not calculated.", "pricingValue is not calculated.", driver,
						test);
				driver.quit();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("pricingValue is not calculated.", "pricingValue is not calculated.", driver,
					test);
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
	public boolean addendumTabClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			if (driver.findElement(By.id(ePricerCreateAQuotePageObjects.addendumTab)).isDisplayed())
				return false;
			else {
				return true;

			}
			// Extent_Reporting.Log_Pass("addendum Tab Clicked", "addendum Tab Clicked");

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("addendum Tab not Clicked", "addendum Tab not Clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}



	/**
	 * This method is for verifying requestPricingStatusIbmGuiCheck.
	 * 
	 * @throws Throwable
	 */
	public void requestPricingStatusIbmGuiCheck() throws Exception {
		try {
			ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(
					driver, TC_ID);
			Thread.sleep(8000);
			action.isElementDisplayed(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.requestPricingStatusIbmGui,
					"requestPricingStatusIbmGui is displayed.");

			Extent_Reporting.Log_report_img("requestPricingStatusIbmGui is displayed.",
					"requestPricingStatusIbmGui is displayed.", driver, test);
			Extent_Reporting.Log_Pass("requestPricingStatusIbmGui is displayed.",
					"requestPricingStatusIbmGui is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("requestPricingStatusIbmGui is not displayed.",
					"requestPricingStatusIbmGui is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for login in IBM GUI and approve the ibm gui quote written by
	 * Harsha
	 * 
	 * @throws Throwable
	 */
	public void change_request_pricing_to_ibm_approved() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(
					driver, TC_ID);

			action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.pricingTabIbmGui);
			action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.pricingTabIbmGui,
					"pricingTabIbmGui clicked");

			action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approvalTabIbmGui);
			action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approvalTabIbmGui,
					"approvalTabIbmGui clicked");

			action.isElementDisplayed(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approvalSectionScreenIBMGui,
					"approvalSectionScreenIBMGui is displayed.");

			action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approveRadioBtnIbmGui);
			action.Javascriptexecutor_forClick(driver,
					ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approveRadioBtnIbmGui,
					"approveRadioBtnIbmGui clicked");

			action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.submitApprovalIbmGui);
			action.Javascriptexecutor_forClick(driver,
					ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.submitApprovalIbmGui, "submitApprovalIbmGui clicked");

			action.isElementDisplayed(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.iBMApprovedStatus,
					"iBMApprovedStatus is displayed.");

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("change_request_pricing_to_ibm_approved Opened", "change_request_pricing_to_ibm_approved Opened", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}


}
