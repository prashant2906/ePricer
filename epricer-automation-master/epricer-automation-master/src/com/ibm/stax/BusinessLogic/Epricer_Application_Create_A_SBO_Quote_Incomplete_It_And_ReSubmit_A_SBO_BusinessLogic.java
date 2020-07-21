package com.ibm.stax.BusinessLogic;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.stax.PageObjects.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Kajal Shakya
 *
 */
public class Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_ReSubmit_A_SBO_BusinessLogic {

	private ElementAction action = new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;
	public static String quoteId;

	ClassLoader classLoader = getClass().getClassLoader();
	public static String requestedEndUserDiscount = null;
	public static String requestedEndUserPrice = null;

	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = null;

	public Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_ReSubmit_A_SBO_BusinessLogic(WebDriver d,
			String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for clicking searchQuotesLink.
	 * 
	 * @throws Throwable
	 */
	public void requestPricingTabClick() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.checkElementClickable(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestPricingTab,"requestPricingTab is displayed.");
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestPricingTab,"requestPricingTab clicked");
			Thread.sleep(2000);
			// driver.switchTo().alert().accept();

			action.clearAndInputTextValue(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestedEndUserDiscount,Excel_Handling.Get_Data(TC_ID, "RequestedEndUserDiscount"), "requestedEndUserDiscount");

			// action.Javascriptexecutor_forClick(driver,
			// ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.applyRequestedEndUserDiscountBtn,
			// "applyRequestedEndUserDiscountBtn");

			Thread.sleep(4000);

			action.checkElementClickable(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.applyBtn,"applyBtn is clickable.");
			action.Javascriptexecutor_forClick(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.applyBtn,"applyBtn clicked");

			action.waitForPageToLoad(driver);
			//Thread.sleep(20000);

			requestedEndUserPrice = driver.findElement(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestedEndUserPrice)).getAttribute("value");
			requestedEndUserDiscount = driver.findElement(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestedEndUserDiscount)).getAttribute("value");

			action.checkElementClickable(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.justificationAttachmentsTab,"justificationAttachmentsTab is displayed.");
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.justificationAttachmentsTab,"justificationAttachmentsTab clicked.");

//			driver.switchTo().frame("ui-tinymce-1_ifr");
//			action.clearAndInputTextValue(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsSection,Excel_Handling.Get_Data(TC_ID, "CommentsSection"), "commentsSection");
//			driver.switchTo().defaultContent();

			Extent_Reporting.Log_report_img("submitPriceRequestScreen is displayed.","submitPriceRequestScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("submitPriceRequestScreen is displayed.","submitPriceRequestScreen is displayed.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("searchQuotesLink not clicked.", "searchQuotesLink not clicked.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for uploadTextFile
	 * 
	 * @throws Throwable
	 */
	public void uploadTextFile() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ClassLoader classLoader = getClass().getClassLoader();
			File cfr = new File(classLoader.getResource("TestFile.txt").getFile());
			// action.Clickbtn(driver, "//input[@type='file' and @title='Multiple']",
			// "uploadFileBtn");
			driver.findElement(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.uploadTextFileBtn))
					.sendKeys(cfr.getAbsolutePath());

			action.checkElementClickable(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.uploadAllBtn,
					"uploadAllBtn is displayed.");
			action.Javascriptexecutor_forClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.uploadAllBtn, "uploadAllBtn Clicked.");

			action.checkElementClickable(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.downloadBtn,
					"downloadBtn is displayed.");

			Extent_Reporting.Log_report_img("uploadTextFile Successfully done.", "uploadTextFile Successfully done.",
					driver, test);
			Extent_Reporting.Log_Pass("uploadTextFile Successfully done.", "uploadTextFile Successfully done.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Textfile Upload Failed.", "Textfile Upload Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for clicking submitAndSendNotificationBtnClick.
	 * 
	 * @throws Throwable
	 */
	public void submitPriceRequestBTNClick() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);

			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.submitPriceRequestBTN,"submitPriceRequestBTN");

			Extent_Reporting.Log_report_img("submitPriceRequestBTN clicked.", "submitPriceRequestBTN clicked.", driver,test);
			Extent_Reporting.Log_Pass("submitPriceRequestBTN clicked.", "submitPriceRequestBTN clicked.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("submitPriceRequestBTN not clicked.", "submitPriceRequestBTN not clicked.",driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying sendNotificationScreen.
	 * 
	 * @throws Throwable
	 */
	public void sendNotificationScreen() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.sendNotificationScreen,
					"sendNotificationScreen is displayed.");
			// Thread.sleep(4000);
			Extent_Reporting.Log_report_img("sendNotificationScreen is displayed.",
					"sendNotificationScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("sendNotificationScreen is displayed.", "sendNotificationScreen is displayed.",
					test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendNotificationScreen is not displayed.",
					"sendNotificationScreen is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for verifying iBMGuiOpenedToResubmit.
	 * 
	 * @throws Throwable
	 */
	public void iBMGuiOpenedToResubmit() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			
			if (action.isElementDisplayed(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.bPInformationTab, "bPInformationTab")) {
				action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.bPInformationTab, "bPInformationTab");
				Extent_Reporting.Log_report_img("bPInformationTab Clicked.", "bPInformationTab Clicked.", driver, test);
				Extent_Reporting.Log_Pass("bPInformationTab Clicked.", "bPInformationTab Clicked.", test);
			}
			List<WebElement> e1 = driver.findElements(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.generalInformationTitle));
			if (e1.size() > 1) {
				for (int i = 0; i <= 5; i++) {
					if (i == 1) {
						Thread.sleep(2000);
						e1.get(i).isDisplayed();
						Extent_Reporting.Log_Pass("generalInformationTitle displayed.",
								"generalInformationTitle displayed.", test);
						Extent_Reporting.Log_report_img("generalInformationTitle displayed.",
								"generalInformationTitle displayed.", driver, test);
						break;
					}
				}
			}

			List<WebElement> e2 = driver.findElements(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.testFile));
			if (e2.size() > 1) {
				for (int i = 0; i <= 5; i++) {
					if (i == 1) {
						Thread.sleep(2000);
						e2.get(i).isDisplayed();
						Extent_Reporting.Log_Pass("testFile displayed.", "testFile displayed.", test);
						Extent_Reporting.Log_report_img("testFile displayed.", "testFile displayed.", driver, test);
						break;
					}
				}
			}
			List<WebElement> e3 = driver
					.findElements(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.testFileDownloadBTN));
			if (e3.size() > 1) {
				for (int i = 0; i <= 5; i++) {
					if (i == 1) {
						e3.get(i).isDisplayed();
						Extent_Reporting.Log_Pass("testFileDownloadBTN displayed.", "testFileDownloadBTN displayed.",
								test);
						Extent_Reporting.Log_report_img("testFileDownloadBTN displayed.",
								"testFileDownloadBTN displayed.", driver, test);
						break;
					}
				}
			}

			if (action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.endUserPriceAndEndUserDiscount,
					"endUserPriceAndEndUserDiscount")) {
				List<WebElement> e4 = driver.findElements(By
						.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.endUserPriceAndEndUserDiscount));
				for (int i = 0; i <= 5; i++) {
					if (i == 0) {
						String endUserPrice = e4.get(i).getText();
						if (endUserPrice.equalsIgnoreCase(requestedEndUserPrice)) {
							Extent_Reporting.Log_report_img("requestedEndUserPrice is equal on BP and IBM side.",
									"requestedEndUserPrice is equal on BP and IBM side.", driver, test);
							Extent_Reporting.Log_Pass("requestedEndUserPrice is equal on BP and IBM side.",
									"requestedEndUserPrice is equal on BP and IBM side.", test);
							break;
						}
					}
				}
			} else {
				Extent_Reporting.Log_Fail("requestedEndUserPrice is not displayed",
						"requestedEndUserPrice is not displayed", driver, test);
			}

			WebElement e8 = driver.findElement(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.endUserDis));
			String endUserDiscount = e8.getText();
			if (endUserDiscount.equals(requestedEndUserDiscount)) {
				Extent_Reporting.Log_report_img("requestedEndUserDiscount is equal on BP and IBM side.",
						"requestedEndUserDiscount is equal on BP and IBM side.", driver, test);
				Extent_Reporting.Log_Pass("requestedEndUserDiscount is equal on BP and IBM side.",
						"requestedEndUserDiscount is equal on BP and IBM side.", test);
			} else {
				Extent_Reporting.Log_Fail("requestedEndUserDiscount is not equal on BP and IBM side.",
						"requestedEndUserDiscount is not equal on BP and IBM side.", driver, test);
			}

			driver.close();

			Extent_Reporting.Log_Pass("iBMGui Closed.", "iBMGui Closed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMGui not Opened", "iBMGui not Opened", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for quoteIdPresentOnMyQuotesScreenAfterSubmit
	 * 
	 * @throws Throwable
	 */
	public void quoteIdPresentOnMyQuotesScreenAfterSubmit() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			Thread.sleep(20000);

			String quoteIdXpath = "//*[contains(.,'" + quoteId + "')]";
			boolean quoteIdXpathPresent = action.checkElementClickableFluent(driver, quoteIdXpath, "quoteIdXpath");
			// action.waitForElementClickable(driver, quoteId);

			// if (action.isTextPresent(driver, quoteId)) {
			if (quoteIdXpathPresent) {
				Extent_Reporting.Log_report_img("quoteId Created is Present.", "quoteId Created is Present.", driver,
						test);
				Extent_Reporting.Log_Pass("quoteId Created is Present.", "quoteId Created is Present.", test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteId Created is not Present.", "quoteId Created is not Present.", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying iBMGuiScreen.
	 * 
	 * @throws Throwable
	 */
	public void iBMGuiScreen() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			Thread.sleep(60000);
			if (action.isElementDisplayed(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.iBMGuiScreen,
					"iBMGuiScreen is displayed.")) {
				Extent_Reporting.Log_report_img("iBMGuiScreen is displayed", "iBMGuiScreen is displayed.", driver,
						test);
				Extent_Reporting.Log_Pass("iBMGuiScreen is displayed.", "iBMGuiScreen is displayed.", test);
			} else {
				Extent_Reporting.Log_Fail("iBMGuiScreen is not displayed.", "iBMGuiScreen is not displayed.", driver,
						test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMGuiScreen is not displayed.", "iBMGuiScreen is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for searchQuotesLinkClick
	 * 
	 * @throws Throwable
	 */
	public void searchQuotesLinkClick() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(
					driver, TC_ID, test);
			String url = "https://w3alpha-2.toronto.ca.ibm.com/services/epricer/v2/ibm/#/main";
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.switchPageByURL(url);
			if (action.checkElementClickableFluent(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.searchQuotesLink, "searchQuotesLink")) {
				action.Javascriptexecutor_forClick(driver,
						ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.searchQuotesLink, "searchQuotes Link ");
				Extent_Reporting.Log_report_img("searchQuotesLink is clicked.", "searchQuotesLink is clicked.", driver,
						test);
				Extent_Reporting.Log_Pass("searchQuotesLink is clicked", "searchQuotesLink is clicked", test);
			} else {
				Extent_Reporting.Log_Fail("searchQuotesLink is not clicked", "searchQuotesLink is not clicked", driver,
						test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("searchQuotesLink is not clicked", "searchQuotesLink is not clicked", driver,
					test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying searchQuotesIBMGUIScreen.
	 * 
	 * @throws Throwable
	 */
	public void searchQuotesIBMGUIScreen() throws Exception {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(
					driver, TC_ID, test);
			String url = "https://w3alpha-2.toronto.ca.ibm.com/services/epricer/v2/ibm/#/main";
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.switchPageByURL(url);

			if (action.checkElementClickableFluent(driver, ePricerUpdateAQuotePageObjects.searchQuotesIBMGUIScreen,
					"searchQuotesIBMGUIScreen")) {
				Extent_Reporting.Log_report_img("searchQuotesScreen is displayed", "searchQuotesScreen is displayed.",
						driver, test);
				Extent_Reporting.Log_Pass("searchQuotesScreen is displayed", "searchQuotesScreen is displayed", test);
			} else {
				Extent_Reporting.Log_Fail("searchQuotesIBMGUIScreen is not displayed.",
						"searchQuotesIBMGUIScreen is not displayed.", driver, test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("searchQuotesIBMGUIScreen is not displayed.",
					"searchQuotesIBMGUIScreen is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for searchQuotesLinkClick
	 * 
	 * @throws Throwable
	 */
	public void searchCriteriaSelectIBMGui() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			Thread.sleep(60000);
			if (action.checkElementClickableFluent(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.searchCriteriaSelectIBMGui,
					"searchCriteriaSelectIBMGui")) {
				action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
						ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.searchCriteriaSelectIBMGui,
						Excel_Handling.Get_Data(TC_ID, "SearchCriteriaSelect"), "Select search Criteria Selected");
				Extent_Reporting.Log_report_img("searchCriteriaSelectIBMGui is displayed",
						"searchCriteriaSelectIBMGui is displayed.", driver, test);
				Extent_Reporting.Log_Pass("searchCriteriaSelectIBMGui is displayed",
						"searchCriteriaSelectIBMGui is displayed", test);
			} else {
				Extent_Reporting.Log_Fail("searchCriteriaSelectIBMGui is not displayed",
						"searchCriteriaSelectIBMGui is not displayed", driver, test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("searchCriteriaSelectIBMGui is not displayed",
					"searchCriteriaSelectIBMGui is not displayed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for enterQuoteidForSerach
	 * 
	 * @throws Throwable
	 */
	@SuppressWarnings("static-access")
	public void enterQuoteidForSerach() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(
					driver, TC_ID, test);

			if (action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.enterQuoteid, "enterQuoteid")) {
				driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).click();
				driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid))
						.sendKeys(ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteId);
				Extent_Reporting.Log_report_img("Quoteid is entered.", "Quoteid is entered.", driver, test);
				Extent_Reporting.Log_Pass("Quoteid is entered.", "Quoteid is entered.", test);
			} else {
				Extent_Reporting.Log_Fail("Quoteid not entered.", "Quoteid not entered.", driver, test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Quoteid not entered.", "Quoteid not entered.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for showMarginCalculationLinkClick
	 * 
	 * @throws Throwable
	 */
	public void showMarginCalculationLinkClick() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			action.waitForPageToLoad(driver);
			if (action.isElementDisplayed(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.showMarginCalculationLink,"showMarginCalculationLink")) {
				action.Javascriptexecutor_forClick(driver,
						ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.showMarginCalculationLink,"showMarginCalculationLink");
				Extent_Reporting.Log_report_img("showMarginCalculationLink displayed","showMarginCalculationLink displayed", driver, test);
				Extent_Reporting.Log_Pass("showMarginCalculationLink is displayed",	"showMarginCalculationLink is displayed", test);
			} else {
				Extent_Reporting.Log_Fail("showMarginCalculationLink is not displayed","showMarginCalculationLink is not displayed", driver, test);
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("showMarginCalculationLink is not displayed",	"showMarginCalculationLink is not displayed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for pricesCheckOnBPAndIBM
	 * 
	 * @throws Throwable
	 */
	public void pricesCheckOnBPAndIBM() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			if (action.isElementDisplayed(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.endUserPrice,
					"endUserPrice")) {
				WebElement e = driver
						.findElement(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.endUserPrice));
				String endUserPrice = e.getText();
				if (endUserPrice.equalsIgnoreCase(requestedEndUserPrice)) {
					Extent_Reporting.Log_report_img("requestedEndUserPrice is equal on BP and IBM side.",
							"requestedEndUserPrice is equal on BP and IBM side.", driver, test);
					Extent_Reporting.Log_Pass("requestedEndUserPrice is equal on BP and IBM side.",
							"requestedEndUserPrice is equal on BP and IBM side.", test);
				} else {
					Extent_Reporting.Log_Fail("requestedEndUserPrice is not equal on BP and IBM side.",
							"requestedEndUserPrice is not equal on BP and IBM side.", driver, test);
				}
			}

			if (action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.endUserDiscount, "endUserDiscount")) {
				WebElement e = driver
						.findElement(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.endUserDiscount));
				String endUserDiscount = e.getText();
				if (endUserDiscount.equalsIgnoreCase(requestedEndUserDiscount)) {
					Extent_Reporting.Log_report_img("requestedEndUserDiscount is equal on BP and IBM side.",
							"requestedEndUserDiscount is equal on BP and IBM side.", driver, test);
					Extent_Reporting.Log_Pass("requestedEndUserDiscount is equal on BP and IBM side.",
							"requestedEndUserDiscount is equal on BP and IBM side.", test);
				} else {
					Extent_Reporting.Log_Fail("requestedEndUserDiscount is not equal on BP and IBM side.",
							"requestedEndUserDiscount is not equal on BP and IBM side.", driver, test);
				}
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("pricesCheckOnBPAndIBM is not verified.",
					"pricesCheckOnBPAndIBM is not verified.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for clicking bPInformationTablick.
	 * 
	 * @throws Throwable
	 */
	public void bPInformationTablick() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			if (action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.bPInformationTab, "bPInformationTab")) {
				action.Javascriptexecutor_forClick(driver,
						ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.bPInformationTab, "bPInformationTab");
				Extent_Reporting.Log_report_img("bPInformationTab Clicked.", "bPInformationTab Clicked.", driver, test);
				Extent_Reporting.Log_Pass("bPInformationTab Clicked.", "bPInformationTab Clicked.", test);
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("bPInformationTab not clicked.", "bPInformationTab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for Verifying generalInformationTitleCheck.
	 * 
	 * @throws Throwable
	 */
	public void generalInformationTitleCheck() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			if (action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.generalInformationTitle,
					"generalInformationTitle")) {
				List<WebElement> e = driver.findElements(
						By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.generalInformationTitle));
				for (int i = 0; i <= 5; i++) {
					if (i == 2) {
						Thread.sleep(2000);
						e.get(i).isDisplayed();
						Extent_Reporting.Log_report_img("generalInformationTitle displayed.",
								"generalInformationTitle displayed.", driver, test);
						break;
					}
				}
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("generalInformationTitle is not displayed.",
					"generalInformationTitle is not displayed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for Verifying testFileCheck.
	 * 
	 * @throws Throwable
	 */
	public void testFileCheck() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			if (action.isElementDisplayed(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.testFile,
					"testFile")) {
				List<WebElement> e = driver
						.findElements(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.testFile));
				for (int i = 0; i <= 5; i++) {
					if (i == 2) {
						Thread.sleep(2000);
						e.get(i).isDisplayed();
						Extent_Reporting.Log_report_img("testFile displayed.", "testFile displayed.", driver, test);
						break;
					}
				}
			}

			if (action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.testFileDownloadBTN,
					"testFileDownloadBTN")) {
				List<WebElement> e = driver.findElements(
						By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.testFileDownloadBTN));
				for (int i = 0; i <= 5; i++) {
					if (i == 2) {
						e.get(i).isDisplayed();
						Extent_Reporting.Log_report_img("testFileDownloadBTN displayed.",
								"testFileDownloadBTN displayed.", driver, test);
						break;
					}
				}
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("testFile aand testFileDownloadBTN is not displayed.",
					"testFile and testFileDownloadBTN is not displayed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
}
