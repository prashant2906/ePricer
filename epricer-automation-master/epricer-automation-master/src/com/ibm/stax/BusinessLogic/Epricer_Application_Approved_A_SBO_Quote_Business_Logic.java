package com.ibm.stax.BusinessLogic;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ibm.stax.PageObjects.Epricer_Application_Change_Configuration_Quantity_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Login_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

public class Epricer_Application_Approved_A_SBO_Quote_Business_Logic {
	ElementAction action = new ElementAction();
	Common_Functions Function = new Common_Functions();
	public WebDriver driver;
	public String TC_ID;
	public String manageConfTotalPriceString = null;
	public static String newWindow = null;
	public static String quoteIdForTestData;
	Epricer_Application_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_Change_Configuration_Quantity_PageObjects ePricerChangeConfigurationPageObjects = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic createASBOQuoteIncompleteAndAcceptBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = null;
	Epricer_Application_Login_PageObjects ePricerLoginPageObjects = null;

	private ExtentTest test;
	ClassLoader classLoader = getClass().getClassLoader();
	File authenticationIBMGUI = new File(classLoader.getResource("AuthenticationIBMGUI.exe").getFile());

	public Epricer_Application_Approved_A_SBO_Quote_Business_Logic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	@SuppressWarnings("unused")
	public void openIBMGUI() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			if (action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.bPInformationTab, "bPInformationTab")) {
				action.Javascriptexecutor_forClick(driver,
						ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.bPInformationTab, "bPInformationTab");
				Extent_Reporting.Log_report_img("bPInformationTab Clicked.", "bPInformationTab Clicked.", driver, test);
				Extent_Reporting.Log_Pass("bPInformationTab Clicked.", "bPInformationTab Clicked.", test);
			}

			if (action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusTab, "commentsStatusTab")) {
				action.Javascriptexecutor_forClick(driver,
						ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusTab, "commentsStatusTab");
				Extent_Reporting.Log_report_img("commentsStatusTab Clicked.", "commentsStatusTab Clicked.", driver,
						test);
				Extent_Reporting.Log_Pass("commentsStatusTab Clicked.", "commentsStatusTab Clicked.", test);
			}

			action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusScreen,
					"commentsStatusScreen");
			Extent_Reporting.Log_report_img("commentsStatusScreen displayed", "commentsStatusScreen displayed", driver,
					test);
			Extent_Reporting.Log_Pass("commentsStatusScreen is displayed", "commentsStatusScreen is displayed", test);

			List<WebElement> f = driver.findElements(
					By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusScreen));
			for (int g = 0; g <= 9; g++) {
				if (g == 0) {
					f.get(g).isDisplayed();
					Extent_Reporting.Log_Pass("commentsStatusScreen displayed.", "commentsStatusScreen displayed.",
							test);
					Extent_Reporting.Log_report_img("commentsStatusScreen displayed.",
							"commentsStatusScreen displayed.", driver, test);
					break;
				} else {
					Extent_Reporting.Log_Fail("commentsStatusScreen displayed.", "commentsStatusScreen displayed.",
							driver, test);
					driver.quit();
					throw new Exception("Failed");
				}
			}

			driver.switchTo().frame("ui-tinymce-0_ifr");

			action.inputText(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.mailBody,
					Excel_Handling.Get_Data(TC_ID, "commentSection"), "commentSection");
			Extent_Reporting.Log_report_img("mailBody displayed", "mailBody displayed", driver, test);
			Extent_Reporting.Log_Pass("mailBody is displayed", "mailBody is displayed", test);

			driver.switchTo().parentFrame();

			action.selectCheckBox(driver, ePricerUpdateAQuotePageObjects.removeFromHold, "RemoveFromHold");
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.applyButton, "applyButton");
			Thread.sleep(7000);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.pricingTab, "Pricing");
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.pricesOnPricing, "Prices");
			action.selectDropBoxByVisibleText(driver, ePricerUpdateAQuotePageObjects.tableViewDropDown, "Component",
					"Component view");
			action.selectDropBoxByVisibleText(driver, ePricerUpdateAQuotePageObjects.tableViewDropDown, "Division code",
					"Division code view");
			action.selectDropBoxByVisibleText(driver, ePricerUpdateAQuotePageObjects.tableViewDropDown, "Component",
					"Component view");
			Thread.sleep(5000);
			action.clickFirst(driver, ePricerUpdateAQuotePageObjects.approvedPriceField, "ApprovedPriceField");
			action.clearAndInputTextValue(driver, ePricerUpdateAQuotePageObjects.approvedPriceField, "1000",
					"ApprovedPriceField");
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.recalculateButton,
					"RecalculateButton");

			Extent_Reporting.Log_Pass("iBMGui Opened", "iBMGui Opened", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMGui not Opened", "iBMGui not Opened", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void searchQuote() throws Throwable {
		try {

			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(
					driver, TC_ID, test);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			driver.switchTo().window(newWindow);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Search Quote Failed", "Search Quote Failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void dataForSearchQuote() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			// Thread.sleep(2000);

			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.enterQuoteid);
			
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).click();
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid))
					.sendKeys(Excel_Handling.Get_Data(TC_ID, "EnterQuoteid"));

			Extent_Reporting.Log_report_img("Quoteid entered.", "Quoteid entered.", driver, test);
			action.selectCheckBox(driver, ePricerCreateAQuotePageObjects.checkBox, "Check Box");
			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.searchQuoteButton);
			action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.searchQuoteButton, "searchQuoteButton");

			List<WebElement> e = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.searchQuoteButton));
			for (int i = 0; i <= 4; i++) {
				if (i == 1) {
					e.get(i).isDisplayed();
					e.get(i).click();
					Extent_Reporting.Log_report_img("searchQuoteButton clicked", "searchQuoteButton clicked", driver,
							test);
					Extent_Reporting.Log_Pass("search Quote Button clicked.", "search Quote Button clicked.", test);
					break;
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("search Quote Button not clicked.", "search Quote Button not clicked.", driver,
					test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	public void submitTheduplicatedQuote() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));
			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.saveOverviewButton);
			for (int i = 0; i <= 10; i++) {
				if (i == 2) {
					e.get(i).click();
					Extent_Reporting.Log_report_img("save btn clicked.", "save btn clicked.", driver, test);
					Extent_Reporting.Log_Pass("saveOverviewButton clicked.", "saveOverviewButton clicked.", test);
					break;
				}
			}
			action.Javascriptexecutor_forClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.submitPriceRequestBtn,
					"submitPriceRequestBtn");

			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.submitOnSubmitPriceRequest,
					"submitOnSubmitPriceRequest");

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("submit Quote Failed.", "submit Quote Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void dataForEPricerAddProductManuallyScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementClickable(driver, ePricerCreateAQuotePageObjects.selectCategorySelected);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.selectCategorySelected,
					"select Category Selected");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerCreateAQuotePageObjects.selectCategorySelected,
					Excel_Handling.Get_Data(TC_ID, "SelectCategorySelected"), "Select Category Selected");
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("Select Category Selected", "Select Category Selected", driver, test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField1,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField1"), "typeModelField1");
			Extent_Reporting.Log_report_img("TypeModelField1 entered.", "TypeModelField1 entered.", driver, test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField2,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField2"), "TypeModelField2");
			Extent_Reporting.Log_report_img("TypeModelField2 entered.", "TypeModelField2 entered.", driver, test);

			List<WebElement> f = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.addButton));
			for (int i = 0; i <= 5; i++) {
				if (i == 4) {
					f.get(i).click();
					Extent_Reporting.Log_Pass("addButton Clicked.", "addButton Clicked.", test);
					Extent_Reporting.Log_report_img("addButton Clicked.", "addButton Clicked.", driver, test);
					break;
				}
			}

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerCreateAQuotePageObjects.selectCategorySelected,
					Excel_Handling.Get_Data(TC_ID, "SelectCategorySelected"), "Select Category Selected");
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("Select Category Selected", "Select Category Selected", driver, test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField1, "5334", "typeModelField3");
			Extent_Reporting.Log_report_img("TypeModelField1 entered.", "TypeModelField1 entered.", driver, test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField2, "85E", "TypeModelField4");
			Extent_Reporting.Log_report_img("TypeModelField2 entered.", "TypeModelField2 entered.", driver, test);

			List<WebElement> g = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.addButton));
			for (int i = 0; i <= 5; i++) {
				if (i == 4) {
					g.get(i).click();
					Extent_Reporting.Log_Pass("addButton Clicked.", "addButton Clicked.", test);
					Extent_Reporting.Log_report_img("addButton Clicked.", "addButton Clicked.", driver, test);
					break;
				}
			}

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.addProductManuallyButton,
					"addProductManuallyButton");
			Thread.sleep(4000);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerCreateAQuotePageObjects.selectCategorySelected,
					Excel_Handling.Get_Data(TC_ID, "SelectCategorySelected"), "Select Category Selected");
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("Select Category Selected", "Select Category Selected", driver, test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField1, "5334", "typeModelField5");
			Extent_Reporting.Log_report_img("TypeModelField1 entered.", "TypeModelField1 entered.", driver, test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField2, "985", "TypeModelField6");
			Extent_Reporting.Log_report_img("TypeModelField2 entered.", "TypeModelField2 entered.", driver, test);

			List<WebElement> h = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.addButton));
			for (int i = 0; i <= 5; i++) {
				if (i == 4) {
					h.get(i).click();
					Extent_Reporting.Log_Pass("addButton Clicked.", "addButton Clicked.", test);
					Extent_Reporting.Log_report_img("addButton Clicked.", "addButton Clicked.", driver, test);
					break;
				}
			}
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.addProductManuallyButton,
					"addProductManuallyButton");
			Thread.sleep(4000);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerCreateAQuotePageObjects.selectCategorySelected,
					Excel_Handling.Get_Data(TC_ID, "SelectCategorySelected"), "Select Category Selected");
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("Select Category Selected", "Select Category Selected", driver, test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField1, "9049", "typeModelField7");
			Extent_Reporting.Log_report_img("TypeModelField1 entered.", "TypeModelField1 entered.", driver, test);

			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField2, "FF8", "TypeModelField8");
			Extent_Reporting.Log_report_img("TypeModelField2 entered.", "TypeModelField2 entered.", driver, test);

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.addAndCloseButton,
					"addAndCloseButton");

			Extent_Reporting.Log_report_img("add and close button clicked.", "add and close button clicked.", driver,
					test);
			Extent_Reporting.Log_Pass("add and close button clicked.", "add and close button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("add and close button not clicked.", "add and close button not clicked.", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void submitButtonClickedOnSubmitPriceRequest() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.submitOnSubmitPriceRequest,
					"submitOnSubmitPriceRequest");
			Thread.sleep(60000);
			Extent_Reporting.Log_report_img("submit button On SubmitPriceRequest clicked.",
					"submit button On SubmitPriceRequest clicked.", driver, test);
			Extent_Reporting.Log_Pass("submit button On SubmitPriceRequest clicked.",
					"submit button On SubmitPriceRequest clicked.", test);

			action.handleAlert(driver);
			Thread.sleep(60000);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("submit button On SubmitPriceRequest Failed.",
					"submit button On SubmitPriceRequest Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void iBMGuiOpened() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			driver.switchTo().frame("ui-tinymce-0_ifr");
			action.inputText(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.mailBody,Excel_Handling.Get_Data(TC_ID, "commentSection"), "commentSection");
			Extent_Reporting.Log_Pass("mailBody is displayed", "mailBody is displayed", test);		

			driver.switchTo().parentFrame();

			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.removeFromHoldRadioBtn,
						"removeFromHoldRadioBtn");
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusApplyBtn,
						"commentsStatusApplyBtn");			
			Thread.sleep(5000);

			if (action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.reportsLettersTab,
					"reportsLettersTab is displayed.")) {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.reportsLettersTab,
						"reportsLettersTab");
				Extent_Reporting.Log_report_img("reportsLettersTab displayed", "reportsLettersTab displayed", driver,
						test);
				Extent_Reporting.Log_Pass("reportsLettersTab is displayed", "reportsLettersTab is displayed", test);
			} else {
				Extent_Reporting.Log_Fail("reportsLettersTab not displayed", "reportsLettersTab not displayed", driver,
						test);
				driver.quit();
				throw new Exception("Failed");
			}

			if (action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.addendumButton,
					"addendumButton is displayed.")) {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.addendumButton,
						"addendumButton");
				Extent_Reporting.Log_report_img("addendumButton clicked", "addendumButton clicked", driver, test);
				Extent_Reporting.Log_Pass("addendumButton is clicked", "addendumButton is clicked", test);
			} else {
				Extent_Reporting.Log_Fail("addendumButton not clicked", "addendumButton not clicked", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			Thread.sleep(5000);
			driver.close();

			Extent_Reporting.Log_Pass("iBMGui Closed.", "iBMGui Closed.", test);

			// action.handleAlert(driver);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMGui not Opened", "iBMGui not Opened", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void quoteIdFetchedandSavedInDatasheet() throws Throwable {
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
					Excel_Handling.Put_Data(TC_ID, "EnterQuoteid", quoteIdForTestData);
					System.out.println(Excel_Handling.Get_Data(TC_ID, "EnterQuoteid"));
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

	public void quoteIdFetchedAndDataSavedInExcel(String testcaseString) throws Throwable {
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
					Excel_Handling.Put_Data(testcaseString, "EnterQuoteid", quoteIdForTestData);
					Thread.sleep(5000);
					//System.out.println(Excel_Handling.Get_Data(testcaseString, "EnterQuoteid"));
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

	public void IBMGUIReviewerWorkflow() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			createASBOQuoteIncompleteAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(
					driver, TC_ID, test);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
	
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.reviewersTab, "ReviewersTab");
			Thread.sleep(5000);
			action.clickButton(driver, ePricerUpdateAQuotePageObjects.showSelectedReviewerButton,
					"ShowSelectedReviewerButton");
			Thread.sleep(5000);
			// action.select
			action.inputText(driver, ePricerUpdateAQuotePageObjects.quotemanagerchange, "epibautom@in.ibm.com",
					"quote Manager change");
			Thread.sleep(1000);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.addToListButton,
					"addToListButton");
			Thread.sleep(1000);
			action.inputText(driver, ePricerUpdateAQuotePageObjects.quotemanagerchange, "epbpauto@in.ibm.com",
					"quote Manager change");
			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.addToListButton,
					"addToListButton");

			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.saveNSubmitButton,
					"saveNSubmitButton");
			Extent_Reporting.Log_report_img("saveNSubmitButton is clicked", "saveNSubmitButton is clicked", driver,
					test);
			Extent_Reporting.Log_Pass("saveNSubmitButton is clicked", "saveNSubmitButton is clicked", test);

			Thread.sleep(5000);
			//driver.close();

			Extent_Reporting.Log_Pass("iBMGui reviewer workflow Closed.", "iBMGui reviewer workflow Closed.", test);
			Thread.sleep(5000);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMGui not Opened", "iBMGui not Opened", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void IBMGUILoginFromReviewerID() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			createASBOQuoteIncompleteAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(
					driver, TC_ID, test);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			
			
			///reviewer tab
			action.selectCheckBox(driver, ePricerUpdateAQuotePageObjects.concurIdRadioButton, "concurIdRadioButton");

			driver.switchTo().frame("ui-tinymce-3_ifr");
			if (action.isElementDisplayed(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.mailBody,
					"mailBody is displayed.")) {
				action.inputText(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.mailBody,
						Excel_Handling.Get_Data(TC_ID, "commentSection"), "commentSection");
				Extent_Reporting.Log_report_img("mailBody displayed", "mailBody displayed", driver, test);
				Extent_Reporting.Log_Pass("mailBody is displayed", "mailBody is displayed", test);

			} else {
				Extent_Reporting.Log_Fail("mailBody not displayed", "mailBody not displayed", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			driver.switchTo().parentFrame();

			ClassLoader classLoader = getClass().getClassLoader();
			File attachment = new File(classLoader.getResource("ReviewerWorkFlowAttachemnt.txt").getFile());
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn))
					.sendKeys(attachment.getAbsolutePath());
			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.saveNSubmitButton,
					"saveNSubmitButton");
			Extent_Reporting.Log_report_img("saveNSubmitButton is clicked", "saveNSubmitButton is clicked", driver,
					test);
			Extent_Reporting.Log_Pass("saveNSubmitButton is clicked", "saveNSubmitButton is clicked", test);

			Thread.sleep(5000);
			driver.close();

			Extent_Reporting.Log_Pass("iBMGui reviewer workflow Closed.", "iBMGui reviewer workflow Closed.", test);
			Thread.sleep(5000);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("IBMGUILoginFromReviewerID not Opened", "IBMGUILoginFromReviewerID not Opened",
					driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void IBMGUILoginFromInitiatorID() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			createASBOQuoteIncompleteAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(
					driver, TC_ID, test);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			

			if (action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.reviewersTab,
					"reviewersTab is displayed.")) {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.reviewersTab, "ReviewersTab");
				Extent_Reporting.Log_report_img("reviewersTab Clicked", "reviewersTab Clicked", driver, test);
				Extent_Reporting.Log_Pass("reviewersTab is Clicked", "reviewersTab is Clicked", test);
				Thread.sleep(3000);
			} else {
				Extent_Reporting.Log_Fail("reviewersTab is not Clicked", "reviewersTab is not Clicked", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

//			/**Download File ---- windwo pop up handeling ------
//			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.downloadAttachmentReviewer, "downloadAttachmentReviewer");
//			Thread.sleep(3000);
//			**\

			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.reportsLettersTab,
					"reportsLettersTab");
			Extent_Reporting.Log_report_img("reportsLettersTab displayed", "reportsLettersTab displayed", driver, test);
			Extent_Reporting.Log_Pass("reportsLettersTab is displayed", "reportsLettersTab is displayed", test);

			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.reviewerReport, "ReviewerReport");
			Extent_Reporting.Log_report_img("reviewerReport displayed", "reviewerReport displayed", driver, test);
			Extent_Reporting.Log_Pass("reviewerReport is displayed", "reviewerReport is displayed", test);

			Thread.sleep(3000);
			driver.close();

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("IBMGUILoginFromInitiatorID not Opened", "IBMGUILoginFromInitiatorID not Opened",
					driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

}
