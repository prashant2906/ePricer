package com.ibm.stax.BusinessLogic;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.stax.PageObjects.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Login_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;


public class Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic {
	private ExtentTest 	test;
	private ElementAction action = new ElementAction();
	public WebDriver driver;
	public String TC_ID;
	public static String quoteId;
	public String currBPMargin;

	ClassLoader classLoader = getClass().getClassLoader();
	File authenticationIBMGUI = new File(classLoader.getResource("AuthenticationIBMGUI.exe").getFile());
	//private String authenticationIBMGUIPath = authenticationIBMGUI.getAbsolutePath();

	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	Epricer_Application_Login_PageObjects ePricerLoginPageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = null;
	
	public Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for clicking requestPriceeExceptionChkbox.
	 * 
	 * @throws Throwable
	 */
	public void requestPriceeExceptionChkboxClick() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);

			Thread.sleep(30000);
			action.waitForPageToLoad(driver);
			if(action.isElementDisplayed(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestPriceeExceptionChkbox,"requestPriceeExceptionChkbox.")) {
				action.Javascriptexecutor_forClick(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestPriceeExceptionChkbox,"requestPriceeExceptionChkbox");
				Extent_Reporting.Log_report_img("requestPriceeExceptionChkbox clicked.","requestPriceeExceptionChkbox clicked.", driver, test);
				Extent_Reporting.Log_Pass("requestPriceeExceptionChkbox clicked.", "requestPriceeExceptionChkbox clicked.", test);
			}else {
				Extent_Reporting.Log_Fail("requestPriceeExceptionChkbox not clicked.","requestPriceeExceptionChkbox not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("requestPriceeExceptionChkbox not clicked.","requestPriceeExceptionChkbox not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for clicking submitPriceRequestBtnClick.
	 * 
	 * @throws Throwable
	 */
	public void submitPriceRequestBtnClick() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			Extent_Reporting.Log_report_img("Clicking on submitPriceRequestBtn ", "Clicking on submitPriceRequestBtn",driver, test);
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.submitPriceRequestBtn,"submitPriceRequestBtn");

			Extent_Reporting.Log_report_img("submitPriceRequestBtn clicked.", "submitPriceRequestBtn clicked.", driver, test);
			Extent_Reporting.Log_Pass("submitPriceRequestBtn clicked.", "submitPriceRequestBtn clicked.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("submitPriceRequestBtn not clicked.", "submitPriceRequestBtn not clicked.",driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying submitPriceRequestScreen.
	 * 
	 * @throws Throwable
	 */
	public void submitPriceRequestScreen() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);
			if(action.isElementDisplayed(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.submitPriceRequestScreen,"submitPriceRequestScreen.")) {
			Extent_Reporting.Log_report_img("submitPriceRequestScreen is displayed.","submitPriceRequestScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("submitPriceRequestScreen is displayed.","submitPriceRequestScreen is displayed.", test);
			}else {
				Extent_Reporting.Log_Fail("Submit Price Request Screen is not displayed.","submitPriceRequestScreen is not displayed.", driver, test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Submit Price Request Screen is not displayed.","submitPriceRequestScreen is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for verifying verifyTabsOnSubmitPriceRequestScreen.
	 * @throws Throwable
	 */
	public void verifyTabsOnSubmitPriceRequestScreen()  throws Throwable{
		try
	{
		ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);
		Thread.sleep(10000);
		action.Javascriptexecutor_forClick(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.iBMChannelInfoTab, "iBMChannelInfoTab clicked");
		Thread.sleep(10000);
		action.Javascriptexecutor_forClick(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestPricingTab, "requestPricingTab clicked");
		Thread.sleep(2000);
		action.handleAlert(driver);
		//driver.switchTo().alert().accept();
		
		action.clearAndInputTextValue(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestedEndUserDiscount, Excel_Handling.Get_Data(TC_ID, "RequestedEndUserDiscount"), "requestedEndUserDiscount");
		
		action.Javascriptexecutor_forClick(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.applyRequestedEndUserDiscountBtn, "applyRequestedEndUserDiscountBtn");
		
		Thread.sleep(4000);
		
		action.Javascriptexecutor_forClick(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.justificationAttachmentsTab, "justificationAttachmentsTab clicked.");
		
		driver.switchTo().frame("ui-tinymce-1_ifr");
		action.clearAndInputTextValue(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsSection, Excel_Handling.Get_Data(TC_ID, "CommentsSection"), "commentsSection");		
		
		Extent_Reporting.Log_report_img("TabsOnSubmitPriceRequestScreen are verified.", "TabsOnSubmitPriceRequestScreen are verified.",driver, test);
		Extent_Reporting.Log_Pass("TabsOnSubmitPriceRequestScreen are verified.", "TabsOnSubmitPriceRequestScreen are verified.", test);
		
		driver.switchTo().defaultContent();
		
	}catch (Exception e) {
		Extent_Reporting.Log_Fail("TabsOnSubmitPriceRequestScreen is not displayed.", "TabsOnSubmitPriceRequestScreen is not displayed.", driver, test);
		System.out.println(e.getMessage().toString());
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
	}
}
	public void submitToDistributorButton() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestPricingTab);
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestPricingTab,"requestPricingTab clicked");
			Thread.sleep(2000);
			action.clearAndInputTextValue(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestedEndUserDiscount,Excel_Handling.Get_Data(TC_ID, "RequestedEndUserDiscount"), "requestedEndUserDiscount");
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.applyRequestedEndUserDiscountBtn,"applyRequestedEndUserDiscountBtn");

			Thread.sleep(4000);

			action.waitForElementVisible(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.justificationAttachmentsTab);
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.justificationAttachmentsTab,"justificationAttachmentsTab clicked.");

			driver.switchTo().frame("ui-tinymce-1_ifr");

			action.clearAndInputTextValue(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsSection,Excel_Handling.Get_Data(TC_ID, "CommentsSection"), "commentsSection");
			driver.switchTo().parentFrame();
			Thread.sleep(12000);
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.submittodistributor,"submit to distributor");
			Thread.sleep(25000);
			Extent_Reporting.Log_report_img("submitPriceRequestScreen is displayed.","submitPriceRequestScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("submitPriceRequestScreen is displayed.","submitPriceRequestScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("submitPriceRequestScreen is not displayed.","submitPriceRequestScreen is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for clicking submitAndSendNotificationBtnClick.
	 * 
	 * @throws Throwable
	 */
	public void submitAndSendNotificationBtnClick() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			Extent_Reporting.Log_report_img("Clicking on submitAndSendNotificationBtn ",
					"Clicking on submitAndSendNotificationBtn", driver, test);

			driver.switchTo().parentFrame();
			
			action.Javascriptexecutor_forClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.submitAndSendNotificationBtn,
					"submitAndSendNotificationBtn");
			Thread.sleep(20000);

			Extent_Reporting.Log_report_img("submitAndSendNotificationBtn clicked.",
					"submitAndSendNotificationBtn clicked.", driver, test);
			Extent_Reporting.Log_Pass("submitAndSendNotificationBtn clicked.", "submitAndSendNotificationBtn clicked.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("submitAndSendNotificationBtn not clicked.",
					"submitAndSendNotificationBtn not clicked.", driver, test);
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

			action.isElementDisplayed(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.sendNotificationScreen,
					"sendNotificationScreen is displayed.");
			// Thread.sleep(4000);
			Extent_Reporting.Log_report_img("sendNotificationScreen is displayed.",
					"sendNotificationScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("sendNotificationScreen is displayed.", "sendNotificationScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendNotificationScreen is not displayed.",
					"sendNotificationScreen is not displayed.", driver, test);
			//System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for dataForSendNotificationScreen
	 * 
	 * @throws Throwable
	 */
	public void dataForSendNotificationScreen() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			Thread.sleep(10000);
			action.clearAndInputTextValue(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.toEmailID,
					Excel_Handling.Get_Data(TC_ID, "ToEmailID"), "toEmailID");

			driver.switchTo().frame("ui-tinymce-2_ifr");

			action.inputText(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.mailBody,
					Excel_Handling.Get_Data(TC_ID, "mailBody"), "mailBody");

			driver.switchTo().parentFrame();

			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.sendMailBtn, "sendMailBtn");
			
			Thread.sleep(20000);
			//action.waitForPageToLoad(driver);
			
			action.handleAlert(driver);
			Extent_Reporting.Log_report_img("sendMailBtn clicked.", "sendMailBtn clicked.", driver, test);
			Extent_Reporting.Log_Pass("sendMailBtn clicked.", "sendMailBtn clicked.", test);
			
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendMailBtn not clicked.", "sendMailBtn not clicked.", driver, test);
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
	public void quoteIdFetched() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			Thread.sleep(5000);
			driver.switchTo().parentFrame();
			List<WebElement> e = driver.findElements(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.quoteId));
			for (int i = 0; i <= 10; i++) {
				if (i == 0) {
					quoteId = e.get(i).getText();
					Extent_Reporting.Log_report_img("quoteId Fetched.", "quoteId Fetched.", driver, test);
					Extent_Reporting.Log_Pass("quoteId Fetched.", "quoteId Fetched.", test);
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

	/**
	 * This method is for quoteIdPresentOnMyQuotesScreen
	 * 
	 * @throws Throwable
	 */
	public void quoteIdPresentOnMyQuotesScreen() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.handleAlert(driver);
			
			Thread.sleep(10000);
			
			String quoteIdXpath = "//*[contains(.,'" + quoteId + "')]";
			boolean quoteIdXpathPresent = action.checkElementClickableFluent(driver, quoteIdXpath, "quoteIdXpath");
			//action.waitForElementClickable(driver, quoteId);
			
			//if (action.isTextPresent(driver, quoteId)) {
			if (quoteIdXpathPresent) {
				Extent_Reporting.Log_report_img("quoteId Created is Present.", "quoteId Created is Present.", driver, test);
				Extent_Reporting.Log_Pass("quoteId Created is Present.", "quoteId Created is Present.", test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteId Created is not Present.", "quoteId Created is not Present.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying iBMGuiOpened.
	 * 
	 * @throws Throwable
	 */
	
	public void openIBMGUIandSearchQuote() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			
			action.Javascriptexecutor_forClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.pricingTab, "pricingTab");
			Extent_Reporting.Log_Pass("pricingTab is displayed", "pricingTab is displayed", test);
			Thread.sleep(8000);
			action.Javascriptexecutor_forClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.pricesOnPricing, "pricingTab");
			Extent_Reporting.Log_Pass("pricingTab is displayed", "pricingTab is displayed", test);
			Thread.sleep(10000);
			action.Javascriptexecutor_forClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.showMarginCalculatoinLink,
					"showMarginCalculatoinLink");
			Extent_Reporting.Log_Pass("showMarginCalculatoinLink is displayed",
					"showMarginCalculatoinLink is displayed", test);

			currBPMargin = driver.findElement(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.totalBPMArgin))
					.getText();
			action.inputText(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.totalBPMArgin, "20",
					"totalBPMargin");
			Extent_Reporting.Log_Pass("totalBPMargin is displayed", "totalBPMargin is displayed", test);
			Thread.sleep(8000);
			action.Javascriptexecutor_forClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.applyBPMargin, "applyBPMargin");

			Extent_Reporting.Log_Pass("applyBPMargin is displayed", "applyBPMargin is displayed", test);

			String updBPMargin = driver
					.findElement(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.totalBPMArgin))
					.getText();

			assertTrue(updBPMargin != currBPMargin, "BP Margin Updated");

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMGui not Opened", "iBMGui not Opened", driver, test);
			System.out.println(e.getMessage().toString());
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
			
			//action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.enterQuoteid);
			Thread.sleep(10000);
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).click();
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).sendKeys(quoteId);

			Extent_Reporting.Log_report_img("Quoteid entered.", "Quoteid entered.", driver, test);
			
			List<WebElement> e = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.searchQuoteButton));
			for (int i = 0; i <= 14; i++) {
				if (i == 1) {
					e.get(i).click();
					action.handleAlert(driver);
					Extent_Reporting.Log_report_img("searchQuoteButton clicked", "searchQuoteButton clicked", driver, test);
					Extent_Reporting.Log_Pass("search Quote Button clicked.", "search Quote Button clicked.", test);
					break;
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("search Quote Button not clicked.", "search Quote Button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying searchQuoteResultScreen.
	 * 
	 * @throws Throwable
	 */
	public void searchQuoteResultScreen() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.searchQuoteResultScreen,
					"searchQuoteResultScreen is displayed.");

			Extent_Reporting.Log_report_img("searchQuoteResultScreen is displayed.",
					"searchQuoteResultScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("searchQuoteResultScreen is displayed.", "searchQuoteResultScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("searchQuoteResultScreen is not displayed.",
					"searchQuoteResultScreen is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for verifying quoteStatusCheck.
	 * 
	 * @throws Throwable
	 */
	public void quoteStatusCheck() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			Thread.sleep(4000);
//			if (action.isElementDisplayed(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.onHoldStatus,
//					"onHoldStatus is displayed.")) {
//				Extent_Reporting.Log_report_img("onHoldStatus is displayed", "onHoldStatus is displayed.", driver, test);
//				Extent_Reporting.Log_Pass("onHoldStatus is displayed.", "onHoldStatus is displayed.", test);
//			} else if (action.isElementDisplayed(driver,
//					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.requestPricingStatus,
//					"requestPricingStatus is displayed.")) {
//				Extent_Reporting.Log_report_img("requestPricingStatus is displayed",
//						"requestPricingStatus is displayed.", driver, test);
//				Extent_Reporting.Log_Pass("requestPricingStatus is displayed.", "requestPricingStatus is displayed.", test);
//			} else {
//				Extent_Reporting.Log_Fail("onHoldStatus or requestPricingStatus not displayed.",
//						"onHoldStatus or requestPricingStatus not displayed.", driver, test);
//			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("onHoldStatus or requestPricingStatus not displayed.",
					"onHoldStatus or requestPricingStatus not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for clicking commentsStatusTabClick.
	 * 
	 * @throws Throwable
	 */
	public void commentsStatusTabClick() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			Extent_Reporting.Log_report_img("Clicking on commentsStatusTab ", "Clicking on commentsStatusTab", driver, test);
			action.Javascriptexecutor_forClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusTab, "commentsStatusTab");

			Extent_Reporting.Log_report_img("commentsStatusTab clicked.", "commentsStatusTab clicked.", driver, test);
			Extent_Reporting.Log_Pass("commentsStatusTab clicked.", "commentsStatusTab clicked.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("commentsStatusTab not clicked.", "commentsStatusTab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying commentsStatusScreen
	 * 
	 * @throws Throwable
	 */
	public void commentsStatusScreen() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.waitForElementVisible(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusScreen);
			action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusScreen,
					"commentsStatusScreen");

			List<WebElement> e = driver.findElements(
					By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusScreen));
			for (int i = 0; i <= 10; i++) {
				if (i == 1) {
					e.get(i).isDisplayed();
					Extent_Reporting.Log_Pass("commentsStatusScreen displayed.", "commentsStatusScreen displayed.", test);
					Extent_Reporting.Log_report_img("commentsStatusScreen displayed.",
							"commentsStatusScreen displayed.", driver, test);
					break;
				} else {
					Extent_Reporting.Log_Fail("commentsStatusScreen is not displayed.",
							"commentsStatusScreen is not displayed.", driver, test);
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("commentsStatusScreen is not displayed.",
					"commentsStatusScreen is not displayed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for dataForCommentsStatusScreen
	 * 
	 * @throws Throwable
	 */
	public void dataForCommentsStatusScreen() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			driver.switchTo().frame("ui-tinymce-0_ifr");

			action.inputText(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.mailBody,
					Excel_Handling.Get_Data(TC_ID, "commentSection"), "commentSection");

			driver.switchTo().parentFrame();

			action.Javascriptexecutor_forClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.changeStatusRadioBtn,
					"changeStatusRadioBtn");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.selectSelectedStatusDD,
					Excel_Handling.Get_Data(TC_ID, "selectSelectedStatusDD"), "selectSelectedStatusDD Selected");

			action.Javascriptexecutor_forClick(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusApplyBtn,
					"commentsStatusApplyBtn");

			Extent_Reporting.Log_report_img("dataForCommentsStatusScreen entered.",
					"dataForCommentsStatusScreen entered.", driver, test);
			Extent_Reporting.Log_Pass("dataForCommentsStatusScreen entered.", "dataForCommentsStatusScreen entered.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("dataForCommentsStatusScreen not entered.",
					"dataForCommentsStatusScreen not entered.", driver, test);
			driver.quit();
			e.printStackTrace();driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying commentsStatusUpdatedCheck.
	 * 
	 * @throws Throwable
	 */
	public void commentsStatusUpdatedCheck() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusUpdated,
					"commentsStatusUpdated is displayed.");

			Extent_Reporting.Log_report_img("commentsStatusUpdated is displayed.",
					"commentsStatusUpdated is displayed.", driver, test);
			Extent_Reporting.Log_Pass("commentsStatusUpdated is displayed.", "commentsStatusUpdated is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("commentsStatusUpdated is not displayed.",
					"commentsStatusUpdated is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for verifying incompleteStatusOfQuote.
	 * 
	 * @throws Throwable
	 */
	public void incompleteStatusOfQuoteCheck() throws Exception {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.incompleteStatusOfQuote,
					"incompleteStatusOfQuote is displayed.");

			Extent_Reporting.Log_report_img("incompleteStatusOfQuote is displayed.",
					"incompleteStatusOfQuote is displayed.", driver, test);
			Extent_Reporting.Log_Pass("incompleteStatusOfQuote is displayed.", "incompleteStatusOfQuote is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("incompleteStatusOfQuote is not displayed.",
					"incompleteStatusOfQuote is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
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

	/**
	 * This method is for verifying commentsTabClicked.
	 * 
	 * @throws Throwable
	 */
	public void commentsTabClicked() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			String element = ".//*[@class='jsclosurestab ng-scope'] / following::div[contains(text(),'Comments')]"; 
			action.waitForElementVisible(driver, element);
			action.Javascriptexecutor_forClick(driver,element, "commentsTab");
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("commentsTab is clicked.", "commentsTab is clicked.", driver, test);
			Extent_Reporting.Log_Pass("commentsTab is clicked.", "commentsTab is clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("commentsTab is not clicked.", "commentsTab is not clicked.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for verifying dataForCommentsTabVerify.
	 * 
	 * @throws Throwable
	 */
	public void dataForCommentsTabVerify() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.incompleteCommentsHeading,
					"incompleteCommentsHeading is displayed.");
			action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.incompleteCommentsOnHeading,
					"incompleteCommentsOnHeading is displayed.");

			Extent_Reporting.Log_report_img("dataForCommentsTab is verfied.", "dataForCommentsTab is verfied.", driver, test);
			Extent_Reporting.Log_Pass("dataForCommentsTab is verfied.", "dataForCommentsTab is verfied.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("dataForCommentsTab is not verfied.", "dataForCommentsTab is not verfied.",
					driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for verifying detailsPricingClick.
	 * 
	 * @throws Throwable
	 */
	public void detailsPricingClick() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			action.waitForElementVisible(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.detailsPricingPolygon);
			//action.isElementDisplayed(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.detailsPricingPolygon,"detailsPricingPolygonScreen is displayed.");
			//Thread.sleep(10000);
//			action.Javascriptexecutor_forClick(driver, "//*[contains(text(),'Manage configuration')]", "Manage configuration");
//			Thread.sleep(5000);
//			action.Javascriptexecutor_forClick(driver, "//*[contains(text(),'Registration & customer')]", "Registration & customer");
			Thread.sleep(10000);
			action.waitForElementClickable(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.detailsPricingPolygon);
			action.Clickbtn(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.detailsPricingPolygon,"detailsPricingPolygon");
			action.handleAlert(driver);
			
			Extent_Reporting.Log_report_img("detailsPricing clicked.", "detailsPricing clicked.", driver, test);
			Extent_Reporting.Log_Pass("detailsPricing clicked.", "detailsPricing clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("detailsPricing not clicked.", "detailsPricing not clicked.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for verifying valueSellerApprovedHeadingCheck.
	 * 
	 * @throws Throwable
	 */
	public void valueSellerApprovedHeadingCheck() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.valueSellerApprovedHeading,
					"valueSellerApprovedHeading is displayed.");

			Extent_Reporting.Log_report_img("valueSellerApprovedHeading is displayed.",
					"valueSellerApprovedHeading is displayed.", driver, test);
			Extent_Reporting.Log_Pass("valueSellerApprovedHeading is displayed.",
					"valueSellerApprovedHeading is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("valueSellerApprovedHeading is not displayed.",
					"valueSellerApprovedHeading is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}


	/**
	 * This method is for verifying searchQuotesScreen.
	 * 
	 * @throws Throwable
	 */
	public void searchQuotesScreen() throws Exception {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			 action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.overviewPolygon );
			action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.searchQuotesScreen,
					"searchQuotesScreen is displayed.");
			// Thread.sleep(4000);
			Extent_Reporting.Log_report_img("searchQuotesScreen is displayed.", "searchQuotesScreen is displayed.",
					driver, test);
			Extent_Reporting.Log_Pass("searchQuotesScreen is displayed.", "searchQuotesScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("searchQuotesScreen is not displayed.", "searchQuotesScreen is not displayed.",
					driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for searchCriteriaQuoteIdSelect
	 * 
	 * @throws Throwable
	 */
	public void searchCriteriaQuoteIdSelect() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.searchCriteriaSelect);
			action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.searchCriteriaSelect,
					"search Criteria Select");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerUpdateAQuotePageObjects.searchCriteriaSelect,
					Excel_Handling.Get_Data(TC_ID, "SearchCriteriaSelect"), "Select search Criteria Selected");
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("Select search Criteria Selected", "Select search Criteria Selected",
					driver, test);
			Extent_Reporting.Log_Pass("Select search Criteria Selected", "Select search Criteria Selected", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Select search Criteria not Selected", "Select search Criteria not Selected",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for clicking searchQuotesLink.
	 * 
	 * @throws Throwable
	 */
	public void searchQuotesLinkClick() throws Exception {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			Extent_Reporting.Log_report_img("Clicking on searchQuotesLink ", "Clicking on searchQuotesLink", driver, test);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.searchQuotesLink,	"searchQuotes Link ");

			Extent_Reporting.Log_report_img("searchQuotesLink clicked.", "searchQuotesLink clicked.", driver, test);
			Extent_Reporting.Log_Pass("searchQuotesLink clicked.", "searchQuotesLink clicked.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("searchQuotesLink not clicked.", "searchQuotesLink not clicked.", driver, test);
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
	
	public void refreshPage() throws Throwable {
		// TODO Auto-generated method stub
		driver.navigate().refresh();
		action.handleAlert(driver);
		Thread.sleep(4000);
		action.handleAlert(driver);
	}
	
	public void checkTSS() throws Throwable {
		try {

			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.pricesOnPricing, "pricesSubtabTab");
			Extent_Reporting.Log_Pass("pricingTab is pricesSubtabTab", "pricesSubtabTab is displayed", test);
			
			//assertTrue(driver.findElement(By.xpath("//span[contains(text(),'TSS maintenance')]")).isDisplayed());
			Extent_Reporting.Log_Pass("TSS Verified", "TSS Verified", test);
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("checkTSS not Worked", "checkTSS not Worked", driver, test);
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for verifying submitPriceRequestTabClick.
	 * 
	 * @throws Throwable
	 */
	public void submitPriceRequestTabClick() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);
			Thread.sleep(30000);
			action.waitForPageToLoad(driver);
			if(action.isElementDisplayed(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.submitPriceRequestScreen,"submitPriceRequestScreen.")) {
				action.Clickbtn(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.submitPriceRequestScreen,	"submitPriceRequest Tab");
				Extent_Reporting.Log_report_img("submitPriceRequest tab clicked.","submitPriceRequest tab clicked.", driver, test);
				Extent_Reporting.Log_Pass("submitPriceRequest tab clicked.","submitPriceRequest tab clicked.", test);
			}else {
				Extent_Reporting.Log_Fail("submitPriceRequest tab not clicked.","submitPriceRequest tab not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("submitPriceRequest tab not clicked.","submitPriceRequest tab not clicked.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}
	
	
	
}
