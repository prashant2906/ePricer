package com.ibm.stax.BusinessLogic.EMEAIBM;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.NAIBM.Epricer_Application_NAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Neha Upadhyay
 *
 */
public class Epricer_Application_EMEAIBM_AddServListMainPreAfterQuotingHWSW_BusinessLogic {
	ElementAction action = new ElementAction();
	Common_Functions Function = new Common_Functions();
	public WebDriver driver;
	public String TC_ID;
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;
	Epricer_Application_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_NAIBM_CreateAQuote_PageObjects nAIBMCreateAQuotePageObjects = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	private ExtentTest test;

	public Epricer_Application_EMEAIBM_AddServListMainPreAfterQuotingHWSW_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.driver = d;
		this.TC_ID = tcId;
		this.test = test;
	}

	public void dataForEPricerMultipleAddProductManually() throws Exception {
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

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.addAnotherComponentButton,
					"addAnotherComponentButton");
			Thread.sleep(40000);
			// action.isElementDisplayed(driver,ePricerEMEAIBMCreateAQuotePageObjects.componentTypeDropDown,"select
			// Category Selected");
			action.waitForPageToLoad(driver);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					ePricerEMEAIBMCreateAQuotePageObjects.componentTypeDropDown, "Software - OTC",
					"Select Category Selected");
			Thread.sleep(4000);
			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField1,
					Excel_Handling.Get_Data(TC_ID, "FeatureOne"), "FeatureOne");
			Extent_Reporting.Log_report_img("FeatureOne entered.", "FeatureOne entered.", driver, test);
			Thread.sleep(4000);
			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField2,
					Excel_Handling.Get_Data(TC_ID, "FeatureTwo"), "FeatureTwo");
			Extent_Reporting.Log_report_img("FeatureTwo entered.", "FeatureTwo entered.", driver, test);
			Thread.sleep(8000);

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.addComponentButton,
					"addComponentButton");
			if (action.isAlertPresent(driver)) {
				action.acceptAlert(driver);
			}
			Thread.sleep(10000);
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("add and close button clicked.", "add and close button clicked.", driver, test);
			Extent_Reporting.Log_Pass("add and close button clicked.", "add and close button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("add and close button not clicked.", "add and close button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void pricingScreenUpdateDisCountData() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices,
					"pricingPrices");

			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingCheckBoxClick);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingCheckBoxClick,
					"pricingCheckBoxClick");
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyButton);

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyButton,
					"quickApplyButton");

			action.waitForPageToLoad(driver);
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.quickApplyField,
					Excel_Handling.Get_Data(TC_ID, "RequestedEndUserDiscountTwo"), "quickApplyPriceUpdateField");
			Thread.sleep(4000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.applyAfterDiscount,
					"applyAfterDiscount");// apply30%Discount

			// action.acceptAlert(driver);
			// action.clickFirst(driver, nAIBMCreateAQuotePageObjects.matchApprovePricesOne,
			// "matchApprovePricesOne");
//			String nApprovePriceString = action.getInputValue(driver, nAIBMCreateAQuotePageObjects.matchApprovePricesOne, "matchApprovePricesOne");
//			Excel_Handling.Put_Data(TC_ID, "ApprovedPrice", nApprovePriceString);
//			System.out.println(Excel_Handling.Get_Data(TC_ID, "ApprovedPrice"));
//			
//			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingCheckBoxClick, "pricingCheckBoxClick");
//			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.RecalculateButton, "RecalculateButton");
//			action.acceptAlert(driver);
//			action.isAlertPresent(driver);
			Thread.sleep(5000);
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("Applied Discount Successfully.", "Applied Discount Successfully.", driver, test);
			Extent_Reporting.Log_Pass("add and close button clicked.", "add and close button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("pricing screen not completed", "pricing screen not completed", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void addComponentManually() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			/*
			 * // to find out value of the drop down List<WebElement> allSuggestions =
			 * driver.findElements(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.
			 * componentTypeDropDown)); for (WebElement suggestion : allSuggestions) {
			 * System.out.println(suggestion.getText()); }
			 */
			action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.componentTypeDropDown,
					"Maintenance - Prepay Manual", "componentTypeDropDown");
			action.waitForPageToLoad(driver);
			Thread.sleep(3000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.addAnotherComponentButton,
					"addAnotherComponentButton");
			action.waitForPageToLoad(driver);
			Thread.sleep(3000);

			action.selectDropBoxByVisibleText(driver, ePricerEMEAIBMCreateAQuotePageObjects.componentTypeDropDown,
					"Services - List", "componentTypeDropDown");

			Thread.sleep(3000);

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.addComponentButton,
					"addComponentButton");

			Thread.sleep(3000);

			Extent_Reporting.Log_report_img("add and close button clicked.", "add and close button clicked.", driver, test);
			Extent_Reporting.Log_Pass("add and close button clicked.", "add and close button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("add and close button not clicked.", "add and close button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void approveAndSubmit(String SBCode) throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,TC_ID);
			ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approvalTabIbmGui);
			
			action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approvalTabIbmGui,
					"approvalTabIbmGui clicked");

			action.waitForPageToLoad(driver);
			action.selectRadio(driver, ePricerEMEAIBMCreateAQuotePageObjects.approvalRadioButton,
					"approvalRadioButton");
			Thread.sleep(4000);

			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.level1InranetID,
					Excel_Handling.Get_Data(TC_ID, "userName"), "UserName");
			if (SBCode.equalsIgnoreCase("Yes")) {
				if (action.isElementPresentByXpath(nAIBMCreateAQuotePageObjects.specialBidCode, driver,"specialBidCode")) {
				action.selectDropBoxByVisibleText(driver, nAIBMCreateAQuotePageObjects.specialBidCode,
						"SDE2,GEO Specific Exemptions", "specialBidCode");
			}
			}
//			if (action.isElementPresentByXpath(nAIBMCreateAQuotePageObjects.specialBidCode, driver,"specialBidCode")) {
//				action.selectDropBoxByVisibleText(driver, nAIBMCreateAQuotePageObjects.specialBidCode,
//						"", "specialBidCode");
//			}
			action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.submitApprovalIbmGui);
			action.Javascriptexecutor_forClick(driver,
					ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.submitApprovalIbmGui, "submitApprovalIbmGui clicked");

			action.waitForPageToLoad(driver);
			Thread.sleep(9000);
			// action.isElementDisplayed(driver,
			// ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.iBMApprovedStatus,
			// "iBMApprovedStatus is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.sendEmailButton,
					"sendEmailButton");
			action.acceptAlert(driver);
			Thread.sleep(8000);

			Extent_Reporting.Log_report_img("sendMail Button Clicked", "sendMail Button Clicked", driver, test);
			Extent_Reporting.Log_Pass("sendMail Button Clicked", "sendMail Button Clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendMail Button not Clicked", "sendMail Button not Clicked", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	public void MoveToAdministrationTab() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);
			action.waitForElementVisible(driver, ePricerEMEAIBMCreateAQuotePageObjects.administrationTab);
			Thread.sleep(10000);
			action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.administrationTab, "administrationTab");
			action.waitForPageToLoad(driver);
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("MoveToAdministration Tab Clicked", "MoveToAdministration Tab Clicked",
					driver, test);
			Extent_Reporting.Log_Pass("MoveToAdministration Tab Clicked", "MoveToAdministration Tab Clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("MoveToAdministration tab not Clicked", "MoveToAdministration tab not Clicked",
					driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void dataForAdminScreen() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(2000);

			action.selectRadio(driver, ePricerEMEAIBMCreateAQuotePageObjects.maintainanceOfferedRadioButton,
					"maintainanceOfferedRadioButton");
			action.selectRadio(driver, ePricerEMEAIBMCreateAQuotePageObjects.defaultTypeOfSend, "DefaultTypeOfSend");

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.adminSaveAndSendButton,
					"adminSaveAndSendButton");
			action.waitForPageToLoad(driver);

			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.enterEmailAddress,
					Excel_Handling.Get_Data(TC_ID, "addToListMailId"), "addToListMailId");
			Thread.sleep(10000);

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
			Thread.sleep(10000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.sendEmailButton,
					"sendEmailButton");

			action.acceptAlert(driver);
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("sendMail Button Clicked", "sendMail Button Clicked", driver, test);
			Extent_Reporting.Log_Pass("sendMail Button Clicked", "sendMail Button Clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendMail Button not Clicked", "sendMail Button not Clicked", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void dataForAdminScreenWithType() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(2000);

			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.adminNameField,
					Excel_Handling.Get_Data(TC_ID, "quoteTitle"), "adminNameField");
			action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cPINumberField,
					Excel_Handling.Get_Data(TC_ID, "IBMUniqueID"), "cPINumberField");
			action.selectRadio(driver, ePricerEMEAIBMCreateAQuotePageObjects.maintainanceOfferedRadioButton,
					"maintainanceOfferedRadioButton");
			action.selectRadio(driver, ePricerEMEAIBMCreateAQuotePageObjects.cashModePaymentRadioButton,
					"cashModePaymentRadioButton");
			action.selectRadio(driver, ePricerEMEAIBMCreateAQuotePageObjects.typeOfSend, "TypeOfSend");

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.adminSaveAndSendButton,
					"adminSaveAndSendButton");
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
			Thread.sleep(3000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.sendEmailButton,
					"sendEmailButton");

			action.acceptAlert(driver);
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("sendMail Button Clicked", "sendMail Button Clicked", driver, test);
			Extent_Reporting.Log_Pass("sendMail Button Clicked", "sendMail Button Clicked", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendMail Button not Clicked", "sendMail Button not Clicked", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void quoteStatusCheeck() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.waitForPageToLoad(driver);
			driver.switchTo().parentFrame();

			action.waitForElementVisible(driver, ePricerEMEAIBMCreateAQuotePageObjects.quoteStatusCheck);
			action.isElementDisplayed(driver, ePricerEMEAIBMCreateAQuotePageObjects.quoteStatusCheck,
					"ePricerEMEAIBMCreateAQuotePageObjects is displayed.");
			action.waitForPageToLoad(driver);
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("quoteStatusCheck is displayed.", "quoteStatusCheck is displayed.", driver, test);
			Extent_Reporting.Log_Pass("quoteStatusCheck is displayed.", "quoteStatusCheck is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteStatusCheck is not displayed.", "quoteStatusCheck is not displayed.",
					driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void quoteStatusCheeck2() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.waitForPageToLoad(driver);
			driver.switchTo().parentFrame();

			action.waitForElementVisible(driver, ePricerEMEAIBMCreateAQuotePageObjects.quoteStatusCheck2);
			action.isElementDisplayed(driver, ePricerEMEAIBMCreateAQuotePageObjects.quoteStatusCheck2,
					"ePricerEMEAIBMCreateAQuotePageObjects quoteStatusCheck2 is displayed.");

			Extent_Reporting.Log_report_img("quoteStatusCheck2 is displayed.", "quoteStatusCheck2 is displayed.",
					driver, test);
			Extent_Reporting.Log_Pass("quoteStatusCheck2 is displayed.", "quoteStatusCheck2 is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteStatusCheck2 is not displayed.", "quoteStatusCheck2 is not displayed.",
					driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void checkIfQuoteEditable() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.waitForPageToLoad(driver);
			if (action.isElementEnabled(driver, ePricerEMEAIBMCreateAQuotePageObjects.RecalculateButton,
					"RecalculateButton")) {
				Extent_Reporting.Log_report_img("Quote is not editable as expected.",
						"Quote is not editable as expected.", driver, test);
				Extent_Reporting.Log_Pass("Quote is not editable as expected.", "Quote is not editable as expected.", test);
			} else {
				Extent_Reporting.Log_Fail("Quote is editable.", "Quote is editable.", driver, test);
				driver.quit();
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Quote is editable.", "Quote is editable.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void moveToFinancialTab() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.financialTab);
			Thread.sleep(8000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.financialTab,
					"financialTab");
			action.waitForPageToLoad(driver);
			Thread.sleep(3000);
			Extent_Reporting.Log_report_img("Succesfully moved to Financials tab.",
					"Succesfully moved to Financials tab.", driver, test);
			Extent_Reporting.Log_Pass("Succesfully moved to Financials tab.", "Succesfully moved to Financials tab.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Financial tab not opened.", "Financial tab not opened.", driver, test);
			// System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void attachFiles() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.waitForPageToLoad(driver);
			action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.attachStandardReportButton,
					"attachStandardReportButton");
			action.waitForPageToLoad(driver);

			driver.switchTo().frame("ui-tinymce-3_ifr");
			Thread.sleep(1000);
			action.clearAndInputTextValue(driver, ePricerEMEAIBMCreateAQuotePageObjects.commentsSection,
					Excel_Handling.Get_Data(TC_ID, "CommentsSection"), "commentsSection");
			driver.switchTo().parentFrame();
			action.waitForPageToLoad(driver);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.saveCommentsButton,
					"SaveCommentsButton");
			Thread.sleep(3000);
			driver.switchTo().defaultContent();

			ClassLoader classLoader = getClass().getClassLoader();
			File cfr = new File(classLoader.getResource("TestFile.txt").getFile());
			driver.findElement(By.xpath(ePricerEMEAIBMCreateAQuotePageObjects.uploadTextFileBtn))
					.sendKeys(cfr.getAbsolutePath());
			action.waitForPageToLoad(driver);
			Thread.sleep(2000);

			Extent_Reporting.Log_report_img("attachFiles successfully Done.", "attachFiles successfully Done.", driver, test);
			Extent_Reporting.Log_Pass("attachFiles successfully Done.", "attachFiles successfully Done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("attachFiles failed.", "attachFiles failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void closeCurrentQuote() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.waitForPageToLoad(driver);

			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.closeQuote, "closeQuote");
			action.waitForPageToLoad(driver);

			Thread.sleep(2000);

			Extent_Reporting.Log_report_img("attachFiles successfully Done.", "attachFiles successfully Done.", driver, test);
			Extent_Reporting.Log_Pass("attachFiles successfully Done.", "attachFiles successfully Done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("attachFiles failed.", "attachFiles failed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void verifyFincancialTab() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			if (action.isElementDisplayed(driver, ePricerEMEAIBMCreateAQuotePageObjects.sTDReport, "sTDReport")) {
				Extent_Reporting.Log_report_img("Standard report exists.", "Standard report exists.", driver, test);
				Extent_Reporting.Log_Pass("Standard report exists.", "Standard report exists.", test);
			} else {
				Extent_Reporting.Log_Fail("Standard report dont not exists.", "Standard report does not exists.",
						driver, test);
			}
			if (action.isElementDisplay(driver, ePricerEMEAIBMCreateAQuotePageObjects.removeConfidentialDoc)) {
				Extent_Reporting.Log_report_img("Confidential doc exists.", "Confidential doc exists.", driver, test);
				Extent_Reporting.Log_Pass("Confidential doc exists.", "Confidential doc exists.", test);
			} else {
				Extent_Reporting.Log_Fail("Confidential doc does not exists.", "Confidential doc does not exists.",
						driver, test);
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("verifyFincancialTab successfully Done.",
					"verifyFincancialTab successfully Done.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void clickProceedForReviewButton() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			action.waitForPageToLoad(driver);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.proceedForReviewButton,
					"ProceedForReviewButton");
			Thread.sleep(3000);
			action.waitForPageToLoad(driver);
			action.clickButton(driver, ePricerUpdateAQuotePageObjects.showSelectedReviewerButton,
					"ShowSelectedReviewerButton");
			Thread.sleep(5000);
			action.inputText(driver, ePricerUpdateAQuotePageObjects.quotemanagerchange,
					Excel_Handling.Get_Data(TC_ID, "addToListMailId"), "quote Manager change");
			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.addToListButton,
					"addToListButton");

			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.saveNSubmitButton,
					"saveNSubmitButton");
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("clickProceedForReviewButton successfully Done.",
					"clickProceedForReviewButton successfully Done.", driver, test);
			Extent_Reporting.Log_Pass("clickProceedForReviewButton successfully Done.",
					"clickProceedForReviewButton successfully Done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("clickProceedForReviewButton failed.", "clickProceedForReviewButton failed.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void downloadSummary() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);

			action.waitForPageToLoad(driver);
			action.waitForElementVisible(driver, ePricerEMEAIBMCreateAQuotePageObjects.downloadSummaryButton);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.downloadSummaryButton,
					"downloadSummaryButton");
			action.waitForPageToLoad(driver);
			action.acceptAlert(driver);
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("downloadSummary successfully Done.", "downloadSummary successfully Done.",
					driver, test);
			Extent_Reporting.Log_Pass("downloadSummary successfully Done.", "downloadSummary successfully Done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("downloadSummary failed.", "downloadSummary failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void uploadCFR() throws Exception {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver,
					TC_ID, test);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);

			ClassLoader classLoader = getClass().getClassLoader();
			File cfr = new File(classLoader.getResource("SSG1TSS3yr_Ed.cfr").getFile());
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
			if (action.CheckifExist(driver, ePricerEMEAIBMCreateAQuotePageObjects.quoteUpdateError)) {
				eMEAIBMcreateAQuoteBusinessLogic.relogin();
				loginBusinessLogic.epricerLogoScreen();
				loginBusinessLogic.ePricerLoginscreen();
				loginBusinessLogic.ePRICERMainScreen();
				eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("ExpiredValueQuote");
				eMEAIBMcreateAQuoteBusinessLogic.MoveToConfigurationTab();

				cfr = new File(
						classLoader.getResource("4_Barclays_Opt1_DS8886F_MES_3.2TB_Flash_Drive_Set.cfr").getFile());
				driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn))
						.sendKeys(cfr.getAbsolutePath());

				action.waitForPageToLoad(driver);

				action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.disableChecksum,
						"disableChecksum");
				action.Javascriptexecutor_forClick(driver,
						ePricerEMEAIBMCreateAQuotePageObjects.workWithOtherCountryCFR, "workWithOtherCountryCFR");
				Thread.sleep(3000);

				if (action.CheckifExist(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn)) {
					action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
				} else {
					action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtnDEV, "uploadCFRBtnDEV");
				}
				Thread.sleep(10000);
				action.handleAlert(driver);
				action.waitForPageToLoad(driver);
			} else {
				Thread.sleep(10000);
				action.handleAlert(driver);
				action.waitForPageToLoad(driver);
			}
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);

			Extent_Reporting.Log_report_img("uploadCFR Successfully done.", "uploadCFR Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("uploadCFR Successfully done.", "uploadCFR Successfully done.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CFR Upload Failed.", "CFR Upload Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void selectTSSCheckBox() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.waitForElementVisible(driver, ePricerEMEAIBMCreateAQuotePageObjects.tSSCheckBOX);
			action.selectCheckBox(driver, ePricerEMEAIBMCreateAQuotePageObjects.tSSCheckBOX, "tSSCheckBOX");
			if (action.isAlertPresent(driver)) {
				action.acceptAlert(driver);				
			}
			Extent_Reporting.Log_report_img("selectTSSCheckBox Successfully done.",
					"selectTSSCheckBox Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("selectTSSCheckBox Successfully done.", "selectTSSCheckBox Successfully done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("selectTSSCheckBox Failed.", "selectTSSCheckBox Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void downloadStandardReport() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver,
					TC_ID);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.standardReport,
					"standardReport");
			action.waitForPageToLoad(driver);
			Thread.sleep(15000);
			String parent = driver.getWindowHandle();
			Set<String> availableWindows = driver.getWindowHandles();
			for (String window : availableWindows) {
				if (!parent.equals(window)) {
					Thread.sleep(8000);
					action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.reviewerReport,
							"reviewerReport");
					action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.saveAndView,
							"SaveAndView");
				} else {
					System.out.println(window);
				}
			}
			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.reviewerReport,
					"reviewerReport");

		Extent_Reporting.Log_Pass("downloadStandardReport Successfully done.",
					"downloadStandardReport Successfully done.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("downloadStandardReport Failed.", "downloadStandardReport Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void matchTheApprovedPriceValue() throws Exception {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.clickFirst(driver, nAIBMCreateAQuotePageObjects.matchApprovePricesOne, "matchApprovePricesOne");
			String nApprovePriceString = action.getInputValue(driver,
					nAIBMCreateAQuotePageObjects.matchApprovePricesOne, "matchApprovePricesOne");
			if (nApprovePriceString == Excel_Handling.Get_Data(TC_ID, "ApprovedPrice")) {
				Extent_Reporting.Log_report_img("matchTheApprovedPriceValue Successfully done.",
						"matchTheApprovedPriceValue Successfully done.", driver, test);
				Extent_Reporting.Log_Pass("matchTheApprovedPriceValue Successfully done.",
						"matchTheApprovedPriceValue Successfully done.", test);
			}
			nApprovePriceString = Excel_Handling.Get_Data(TC_ID, "ApprovedPrice");
			System.out.println(Excel_Handling.Get_Data(TC_ID, "ApprovedPrice"));

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("matchTheApprovedPriceValue Failed.", "matchTheApprovedPriceValue Failed.",
					driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

}
