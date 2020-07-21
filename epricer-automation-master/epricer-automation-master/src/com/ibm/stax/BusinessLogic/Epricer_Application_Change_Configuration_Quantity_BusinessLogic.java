package com.ibm.stax.BusinessLogic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.stax.PageObjects.Epricer_Application_Change_Configuration_Quantity_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

public class Epricer_Application_Change_Configuration_Quantity_BusinessLogic {
	ElementAction action = new ElementAction();
	Common_Functions Function = new Common_Functions();
	public WebDriver driver;
	public String TC_ID;
	public String manageConfTotalPriceString = null;
	Epricer_Application_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_Change_Configuration_Quantity_PageObjects ePricerChangeConfigurationPageObjects = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic createASBOQuoteIncompleteAndAcceptBusinessLogic = null;
	Epricer_Application_CreateAQuote_BusinessLogic ePricerCreateAQuoteBusinessLogic = null;
	private ExtentTest test;

	public Epricer_Application_Change_Configuration_Quantity_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for entering data For
	 * EPricerAddProductManuallyScreenwithMultipleFeature.
	 * 
	 * @throws Throwable
	 */
	public void dataForEPricerAddProductManuallyScreenwithMultipleFeature() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerChangeConfigurationPageObjects = new Epricer_Application_Change_Configuration_Quantity_PageObjects(
					driver, TC_ID);
			ePricerCreateAQuoteBusinessLogic = new Epricer_Application_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			Thread.sleep(5000);
			
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,ePricerCreateAQuotePageObjects.selectCategorySelected,
					Excel_Handling.Get_Data(TC_ID, "SelectCategorySelected"), "Select Category Selected");
			Thread.sleep(2000);
			
			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField1,Excel_Handling.Get_Data(TC_ID, "TypeModelField1"), "typeModelField1");
			Thread.sleep(3000);
			action.inputText(driver, ePricerCreateAQuotePageObjects.typeModelField2,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField2"), "TypeModelField2");
			
			action.inputText(driver, ePricerChangeConfigurationPageObjects.featureRPQField,
					Excel_Handling.Get_Data(TC_ID, "FeatureOne"), "FeatureOne");
			action.inputText(driver, ePricerChangeConfigurationPageObjects.quantityField,
					Excel_Handling.Get_Data(TC_ID, "QuantityField"), "QuantityField");
			Thread.sleep(2000);
			action.Javascriptexecutor_forClick(driver, ePricerChangeConfigurationPageObjects.addNewFeatureButton,
					"AddNewFeatureButton");
			Thread.sleep(5000);
			action.inputText(driver, ePricerChangeConfigurationPageObjects.featureRPQField,
					Excel_Handling.Get_Data(TC_ID, "FeatureTwo"), "FeatureTwo");
			action.inputText(driver, ePricerChangeConfigurationPageObjects.quantityField,
					Excel_Handling.Get_Data(TC_ID, "QuantityField"), "QuantityField");
			Thread.sleep(5000);
			action.Javascriptexecutor_forClick(driver, ePricerChangeConfigurationPageObjects.addNewFeatureButton,
					"AddNewFeatureButton");

			// action.selectCheckBox(driver, ePricerChangeConfigurationPageObjects.selectFeatureCheckBox, "SelectFeatureCheckBox");
			// action.Javascriptexecutor_forClick(driver, ePricerChangeConfigurationPageObjects.addNCloseButton, "addAndCloseButton");
			 

			// workaround for add and add and close btn
			ePricerCreateAQuoteBusinessLogic.addBTNClick();
			Thread.sleep(10000);
			//ePricerCreateAQuoteBusinessLogic.componentAddedSuccessMsg();
			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.closeBTN, "CloseButton");

			Extent_Reporting.Log_Pass("AddProductManuallyScreen Provided.",	"AddProductManuallyS Provided.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("dataForEPricerAddProductManuallyScreenwithMultipleFeature not Provided.",
					"dataForEPricerAddProductManuallyScreenwithMultipleFeature not Provided.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for selecting Tab ManageConfigurationPolygon Screen From
	 * DetialsPricing.
	 * 
	 * @throws Throwable
	 */
	public void selectTabManageConfigurationPolygonScreenFromDetialsPricing() throws Throwable {
		// TODO Auto-generated method stub
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerChangeConfigurationPageObjects = new Epricer_Application_Change_Configuration_Quantity_PageObjects(
					driver, TC_ID);
			Thread.sleep(2000);
			action.Javascriptexecutor_forClick(driver, ePricerChangeConfigurationPageObjects.viewAndEditConfiguration,
					"Manage Config");
			Thread.sleep(300);
			Extent_Reporting.Log_report_img("manageConfigurationPolygon tab clicked.",
					"manageConfigurationPolygon tab clicked.", driver, test);
			Extent_Reporting.Log_Pass("manageConfigurationPolygon tab clicked.",
					"manageConfigurationPolygon tab clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("manageConfigurationPolygon tab not clicked.",
					"manageConfigurationPolygon tab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
		}

	}

	/**
	 * This method is for selecting Tab ManageConfigurationPolygon Screen From
	 * registration screen.
	 * 
	 * @throws Throwable
	 */
	public void selectTabManageConfigurationPolygonScreenFromReg() throws Throwable {
		// TODO Auto-generated method stub
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerChangeConfigurationPageObjects = new Epricer_Application_Change_Configuration_Quantity_PageObjects(
					driver, TC_ID);
			action.Javascriptexecutor_forClick(driver, ePricerChangeConfigurationPageObjects.goBackButton,
					"Manage Config");
			Thread.sleep(300);
			Extent_Reporting.Log_report_img("manageConfigurationPolygon button clicked.",
					"manageConfigurationPolygon button clicked.", driver, test);
			Extent_Reporting.Log_Pass("manageConfigurationPolygon button clicked.",
					"manageConfigurationPolygon button clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("manageConfigurationPolygon tab not clicked.",
					"manageConfigurationPolygon tab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
		}

	}

	/**
	 * This method is for changing the Quantity Of Feature.
	 * 
	 * @throws Throwable
	 */
	public void changeQuantityOfFeature() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerChangeConfigurationPageObjects = new Epricer_Application_Change_Configuration_Quantity_PageObjects(
					driver, TC_ID);

			List<WebElement> e = driver
					.findElements(By.xpath(ePricerChangeConfigurationPageObjects.dropDownFeatureButtonManageConfig));

			for (int i = 0; i <= 7; i++) {
				if (i == 3) {
					e.get(i).click();
					Extent_Reporting.Log_Pass("Feature drop down is clicked.", "feature drop down is clicked.", test);
					Extent_Reporting.Log_report_img("Feature drop down is clicked..", "Feature drop down is clicked.",
							driver, test);
					break;
				}
			}
			action.selectCheckBox(driver, ePricerChangeConfigurationPageObjects.feature1CheckBox, "Feature1CheckBox");

			List<WebElement> j = driver
					.findElements(By.xpath(ePricerChangeConfigurationPageObjects.featureQuantiyFieldManageConfig));

			for (int i = 0; i <= 7; i++) {
				if (i == 3) {
					j.get(i).click();
					j.get(i).clear();
					j.get(i).sendKeys("2");
					Extent_Reporting.Log_Pass("Feature quatity is changed.", "Feature quatity is changed.", test);
					Extent_Reporting.Log_report_img("Feature quatity is changed.", "Feature quatity is changed.",
							driver, test);
					break;
				}
			}

			action.Javascriptexecutor_forClick(driver, ePricerChangeConfigurationPageObjects.updateQuantityButton,
					"updateQuantity");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("updateQuantity button clicked.", "updateQuantity button clicked.", driver,
					test);
			Extent_Reporting.Log_Pass("updateQuantity button clicked.", "updateQuantity button clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("updateQuantity tab not clicked.", "updateQuantity tab not clicked.", driver,
					test);
			driver.quit();
			e.printStackTrace();
		}
	}

	/**
	 * This method is for entering data For checking Detail PricingTab.
	 * 
	 * @throws Throwable
	 * 
	 *                   public void checkDetailPricingTab() throws Throwable { //
	 *                   TODO Auto-generated method stub driver.findElement(
	 *                   By.xpath(
	 *                   "/html/body/div[1]/div[2]/main/div/div/div/div/div/div/div/div/main/div/div/div/div/div/div/div[2]/div/div/quoteedit-page/div/div/div/quotecustomer-page/form/div[4]/div/button[2]"
	 *                   )) .click(); String listPriceValue = driver .findElement(
	 *                   By.xpath(
	 *                   "/html/body/div[1]/div[2]/main/div/div/div/div/div/div/div/div/main/div/div/div/div/div/div/div[2]/div/div/quoteedit-page/div/div/div/quoteprices-page/div[1]/div[3]/table/tbody/tr[3]/td[2]/span"
	 *                   )) .getText(); manageConfTotalPriceString =
	 *                   action.getInputValue(driver,
	 *                   ePricerCreateAQuotePageObjects.pricingValue, "value of
	 *                   Total Manage Cof"); if
	 *                   (listPriceValue.equalsIgnoreCase(manageConfTotalPriceString))
	 *                   { System.out.println("values are equal"); } else {
	 *                   System.out.println("values are not equal"); }
	 * 
	 *                   }
	 */
	/**
	 * This method is for entering data For changing CFR Quantity.
	 * 
	 * @throws Throwable
	 */
	public void changeCFRQuantity() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerChangeConfigurationPageObjects = new Epricer_Application_Change_Configuration_Quantity_PageObjects(
					driver, TC_ID);
			Thread.sleep(3000);
			List<WebElement> e = driver
					.findElements(By.xpath(ePricerChangeConfigurationPageObjects.dropDownFeatureButtonManageConfig));

			for (int i = 0; i <= 7; i++) {
				if (i == 4) {
					e.get(i).click();
					Extent_Reporting.Log_Pass("Feature drop down is clicked.", "feature drop down is clicked.", test);
					Extent_Reporting.Log_report_img("Feature drop down is clicked..", "Feature drop down is clicked.",
							driver, test);
					break;
				}
			}

			List<WebElement> j = driver
					.findElements(By.xpath(ePricerChangeConfigurationPageObjects.featureQuantiyFieldManageConfig));

			for (int i = 0; i <= 10; i++) {
				if (i == 8) {
					j.get(i).click();
					j.get(i).clear();
					j.get(i).sendKeys("2");
					Extent_Reporting.Log_Pass("CFR quatity is changed.", "CFR quatity is changed.", test);
					Extent_Reporting.Log_report_img("CFR quatity is changed.", "CFR quatity is changed.", driver, test);
					break;
				}
			}
			action.selectCheckBox(driver, ePricerChangeConfigurationPageObjects.feature1CheckBox, "Feature1CheckBox");
			Thread.sleep(1000);
			action.Javascriptexecutor_forClick(driver, ePricerChangeConfigurationPageObjects.updateQuantityButton,
					"updateQuantity");
			Thread.sleep(4000);

			Extent_Reporting.Log_report_img("updateQuantityCFR button clicked.", "updateQuantityCFR button clicked.",
					driver, test);
			Extent_Reporting.Log_Pass("updateQuantityCFR button clicked.", "updateQuantityCFR button clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("updateQuantityCFR button not clicked.", "updateQuantityCFR button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
		}
	}

	/**
	 * This method is for entering data For to move To ManageConfiguration tab.
	 * 
	 * @throws Throwable
	 */
	public void moveToManageConfiguration() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(20000);
			// action.Clickbtn(driver,
			// ePricerCreateAQuotePageObjects.manageConfigurationPolygon,"manageConfigurationPolygon");
			action.Clickbtn(driver, "//*[contains(text(),'Manage configuration')]", "Manage configuration");
			Thread.sleep(4000);

			Extent_Reporting.Log_report_img("manageConfigurationPolygon button clicked.",
					"manageConfigurationPolygon button clicked.", driver, test);
			Extent_Reporting.Log_Pass("manageConfigurationPolygon button clicked.",
					"manageConfigurationPolygon button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("manageConfigurationPolygon button not clicked.",
					"manageConfigurationPolygon button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
		}

	}

	/**
	 * This method is for entering data For to move To change quantity.
	 * 
	 * @throws Throwable
	 */
	public void changeQuantity() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerChangeConfigurationPageObjects = new Epricer_Application_Change_Configuration_Quantity_PageObjects(
					driver, TC_ID);
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
					Extent_Reporting.Log_report_img("updateQuantity displayed.", "updateQuantity displayed.", driver,
							test);
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
		}
	}

	/**
	 * This method is for entering data to click requestValueSellerOfferButton.
	 * 
	 * @throws Throwable
	 */
	public void requestValueSellerOfferButtonClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(2000);
			action.Javascriptexecutor_forClick(driver,
					ePricerChangeConfigurationPageObjects.requesttValueSellerOfferButton,
					"requesttValueSellerOffer Button Clicked");
			Thread.sleep(5000);
			action.acceptAlert(driver);
			Extent_Reporting.Log_report_img("requesttValueSellerOffer Button Clicked",
					"requesttValueSellerOffer Button Clicked", driver, test);
			Extent_Reporting.Log_Pass("requesttValueSellerOffer Button Clicked",
					"requesttValueSellerOffer Button Clicked", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("requesttValueSellerOffer Button not Clicked",
					"requesttValueSellerOffer Button not Clicked", driver, test);
			driver.quit();
			e.printStackTrace();
		}
	}

	public void sendMailButtonClicked() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);

			driver.switchTo().parentFrame();
			action.waitForElementVisible(driver, ePricerCreateAQuotePageObjects.sendMailButton);
			action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.sendMailButton,
					"sendMailButton is displayed.");

			action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.sendMailButton,
					"sendMail Button Clicked");

			action.handleAlert(driver);
			// driver.switchTo().alert().accept();

			Thread.sleep(4000);
			action.handleAlert(driver);
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

	public void myQuotesLinkAndPageVerification() throws Throwable {
		try {
			ePricerChangeConfigurationPageObjects = new Epricer_Application_Change_Configuration_Quantity_PageObjects(
					driver, TC_ID);
			Thread.sleep(20000);
			if (action.isElementDisplayed(driver, ePricerChangeConfigurationPageObjects.myQuotesLink, "myQuotesLink")) {
				action.Javascriptexecutor_forClick(driver, ePricerChangeConfigurationPageObjects.myQuotesLink,
						"myQuotesLink");
				Extent_Reporting.Log_report_img("myQuotesLink Clicked", "myQuotesLink Clicked", driver, test);
				Extent_Reporting.Log_Pass("myQuotesLink Clicked", "myQuotesLink Clicked", test);
			} else {
				Extent_Reporting.Log_Fail("MyQuotesLink not Clicked", "MyQuotesLink not Clicked", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			Thread.sleep(10000);
			action.waitForPageToLoad(driver);
			if (action.isElementDisplayed(driver, "//*[@translate='My_Quotes']", "MyQuotesPageExists")) {
				Extent_Reporting.Log_report_img("myQuotesPageExists displayed.", "myQuotesPageExists displayed.",
						driver, test);
				Extent_Reporting.Log_Pass("myQuotesPageExists displayed.", "myQuotesPageExists displayed.", test);
				Extent_Reporting.Log_Pass("MyQuotesLinkAndPageVerification done.",
						"MyQuotesLinkAndPageVerification done.", test);
			} else {
				Extent_Reporting.Log_Fail("myQuotesPageExists not displayed.", "myQuotesPageExists not displayed.",
						driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("MyQuotesLinkAndPageVerification not done.",
					"MyQuotesLinkAndPageVerification not done.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
}