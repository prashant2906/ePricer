/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.BusinessLogic;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.stax.PageObjects.Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

public class Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_BusinessLogic {

	ElementAction action = new ElementAction();
	Common_Functions Function = new Common_Functions();
	public WebDriver driver;
	public String TC_ID;
	Epricer_Application_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_PageObjects duplicateAVSQuote = null;
	Epricer_Application_CreateAQuote_BusinessLogic ePricerCreateAQuoteBusinessLogic = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	private ExtentTest test;

	public Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_BusinessLogic(WebDriver d, String tcId,
			ExtentTest test) {
		this.test= test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for dataForEPricerAddProductManuallyScreen
	 * 
	 * @throws Throwable
	 */
	public void dataForEPricerAddProductManuallyScreen() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			duplicateAVSQuote = new Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_PageObjects(
					driver, TC_ID);
			ePricerCreateAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.selectCategorySelected);
			
			for (int i = 0; i <= 1; i++) {
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

				if (i == 0) {
					ePricerCreateAQuoteBusinessLogic.componentAddedSuccessMsg();
					action.Javascriptexecutor_forClick(driver,duplicateAVSQuote.addManualComponentBtn,
							"addAndCloseButton");
				}

			}

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

	/**
	 * This method is for uploadCFR
	 * 
	 * @throws Throwable
	 */
	public void uploadCFR() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			
			ClassLoader classLoader = getClass().getClassLoader();
			File cfr = new File(classLoader.getResource("Aegon_GB_VEBsnH6064_FC4016nFC4017mes_24aug15.cfr").getFile());
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr.getAbsolutePath());

			File cfr1 = new File(
					classLoader.getResource("4_Barclays_Opt1_DS8886F_MES 3.2TB_Flash_Drive_Set.cfr").getFile());
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr1.getAbsolutePath());

			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.disableChecksumChkbox,
					"disableChecksumChkbox");
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.workWithOtherCountryCFRChkbox,
					"workWithOtherCountryCFRChkbox");

			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");

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

	/**
	 * This method is for collectPricingButtonClick
	 * 
	 * @throws Throwable
	 */
	public void collectPricingButtonClick() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(3000);
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.collectPricingButton,
					"collectPricingButton");
			Thread.sleep(3000);
			Extent_Reporting.Log_report_img("collectPricing button clicked.", "collectPricing button clicked.", driver,
					test);
			Extent_Reporting.Log_Pass("collectPricing button clicked.", "collectPricing button clicked.", test);
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
	 * This method is for verifying registrationCustomerPolygonScreen.
	 * 
	 * @throws Throwable
	 */
	public void registrationCustomerPolygon() throws Exception {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.registrationCustomerPolygon);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.registrationCustomerPolygon,
					"registrationCustomerPolygon Screen is displayed.");
			Extent_Reporting.Log_report_img("registrationCustomerPolygonScreen is displayed.",
					"registrationCustomerPolygonScreen is displayed.", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("registrationCustomerPolygonScreen is not displayed.",
					"registrationCustomerPolygonScreen is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
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
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("saveOverviewButton not clicked.", "saveOverviewButton not clicked.", driver,
					test);
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

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.detailsPricingPolygon);
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
			System.out.println(e.getMessage().toString());
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.iBMBusinessPartnerValueSellerScreen);

			Extent_Reporting.Log_report_img("iBMBusinessPartnerValueSellerScreen is displayed.",
					"iBMBusinessPartnerValueSellerScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("iBMBusinessPartnerValueSellerScreen is displayed.",
					"iBMBusinessPartnerValueSellerScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMBusinessPartnerValueSellerScreen is not displayed.",
					"iBMBusinessPartnerValueSellerScreen is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
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
			action.waitForElementVisible(driver,
					ePricerCreateAQuotePageObjects.closeIBMBusinessPartnerValueSellerScreenBtn);

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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			// action.waitForElementVisible(driver,
			// ePricerCreateAQuotePageObjects.listPriceTotalValue );

			Extent_Reporting.Log_report_img("listPriceTotalValue is displayed.", "listPriceTotalValue is displayed.",
					driver, test);
			Extent_Reporting.Log_Pass("listPriceTotalValue is displayed.", "listPriceTotalValue is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("listPriceTotalValue is not displayed.", "listPriceTotalValue is not displayed.",
					driver, test);
			System.out.println(e.getMessage().toString());
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
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.acceptValueSellerOfferButton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.acceptValueSellerOfferButton,
					"acceptValueSellerOfferButtonClicked is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.acceptValueSellerOfferButton,
					"acceptValueSellerOffer Button Clicked");

			Extent_Reporting.Log_report_img("acceptValueSellerOffer Button Clicked",
					"acceptValueSellerOffer Button Clicked", driver, test);
			Extent_Reporting.Log_Pass("acceptValueSellerOffer Button Clicked", "acceptValueSellerOffer Button Clicked",
					test);

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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

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
			System.out.println(e.getMessage().toString());
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
			System.out.println(e.getMessage().toString());
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
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.addendumTab);
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.brandTab);
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.brandTab);

			Extent_Reporting.Log_report_img("brandTabCheck is displayed.", "brandTabCheck is displayed.", driver, test);
			Extent_Reporting.Log_Pass("brandTabCheck is displayed.", "brandTabCheck is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("brandTabCheck is not displayed.", "brandTabCheck is not displayed.", driver,
					test);
			System.out.println(e.getMessage().toString());
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
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.editAddendumButton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.editAddendumButton,
					"editAddendumButton is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.editAddendumButton,
					"editAddendumButtonClicked");

			Extent_Reporting.Log_report_img("editAddendum Button Clicked", "editAddendum Button Clicked", driver, test);
			Extent_Reporting.Log_Pass("editAddendum Button Clicked", "editAddendum Button Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("editAddendum Button not Clicked", "editAddendum Button not Clicked", driver,
					test);
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

			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.brandCheckbox);

			Extent_Reporting.Log_report_img("brandCheckbox is displayed.", "brandCheckbox is displayed.", driver, test);

			String win = driver.getTitle();

			if (win.contains("e-Pricer")) {

				List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.brandCheckbox));

				for (int i = 0; i <= 10; i++) {
					if (i == 0) {
						e.get(i).click();
						Extent_Reporting.Log_report_img("brandCheckbox clicked.", "brandCheckbox clicked.", driver,
								test);
						Extent_Reporting.Log_Pass("brandCheckbox clicked.", "brandCheckbox clicked.", test);
						break;
					}
				}
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("brandCheckbox not clicked.", "brandCheckbox not clicked.", driver, test);
			System.out.println(e.getMessage().toString());
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
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.cancelAndCloseButton,
					"cancelAndCloseButton is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.cancelAndCloseButton,
					"cancelAndCloseButtonClicked");

			Extent_Reporting.Log_report_img("cancelAndClose Button Clicked", "cancelAndClose Button Clicked", driver,
					test);

			// driver.switchTo().alert().accept();

			Extent_Reporting.Log_Pass("cancelAndClose Button Clicked", "cancelAndClose Button Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("cancelAndClose Button not Clicked", "cancelAndClose Button not Clicked", driver,
					test);
			driver.quit();
			e.printStackTrace();
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
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.sendAddendumButton,
					"sendAddendumButton is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.sendAddendumButton,
					"sendAddendum Button Clicked");

			Extent_Reporting.Log_report_img("sendAddendum Button Clicked", "sendAddendum Button Clicked", driver, test);

			// driver.switchTo().alert().accept();

			Extent_Reporting.Log_Pass("sendAddendum Button Clicked", "sendAddendum Button Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("sendAddendum Button not Clicked", "sendAddendum Button not Clicked", driver,
					test);
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
			System.out.println(e.getMessage().toString());
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

	public void moveToDetailsPricing() {
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
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
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
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

	/*
	 * * This method is for requestValueSellerOfferBTNClicked
	 * 
	 * @throws Throwable
	 */
	public void requestValueSellerOfferBTNClicked() throws Throwable {
		try {
			duplicateAVSQuote = new Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_PageObjects(
					driver, TC_ID);
			List<WebElement> e = driver.findElements(By.xpath(duplicateAVSQuote.requestValueSellerOfferBTN));
			if (e != null) {
				for (int i = 0; i <= 3; i++) {
					if (i == 0) {
						Thread.sleep(5000);
						e.get(i).click();
						Extent_Reporting.Log_report_img("requestValueSellerOfferBTN clicked",
								"requestValueSellerOfferBTN clicked", driver, test);
						Extent_Reporting.Log_Pass("requestValueSellerOfferBTN is clicked",
								"requestValueSellerOfferBTN is clicked", test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Fail("requestValueSellerOfferBTN not clicked","requestValueSellerOfferBTN not clicked", driver, test);
				driver.quit();
				throw new Exception("Failed");

			}

			action.handleAlert(driver);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("requestValueSellerOfferBTN not clicked",
					"requestValueSellerOfferBTN not clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

}
