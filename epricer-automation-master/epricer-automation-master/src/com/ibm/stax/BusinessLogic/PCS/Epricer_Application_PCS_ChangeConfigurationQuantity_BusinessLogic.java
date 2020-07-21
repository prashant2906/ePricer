package com.ibm.stax.BusinessLogic.PCS;
 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_ChangeConfigurationQuantity;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_CreateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

/* 
 * @author Meenal Dixit
 */
public class Epricer_Application_PCS_ChangeConfigurationQuantity_BusinessLogic {

	ElementAction action = new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;
	public String manageConfTotalPriceString = null;
	
	
	Epricer_Application_PCS_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_PCS_ChangeConfigurationQuantity ePricerChangeConfigurationPageObjects = null;
	
	
	public Epricer_Application_PCS_ChangeConfigurationQuantity_BusinessLogic(WebDriver d, String tcId,ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}
	
	/*Test case #5- Change configuration quantity*/
	public void dataForEPricerAddProductManuallyScreenwithMultipleFeature()
			throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerChangeConfigurationPageObjects = new Epricer_Application_PCS_ChangeConfigurationQuantity(driver, TC_ID);

			action.waitForElementVisible(driver,ePricerCreateAQuotePageObjects.selectCategorySelected);
			action.isElementDisplayed(driver,ePricerCreateAQuotePageObjects.selectCategorySelected,"select Category Selected");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,ePricerCreateAQuotePageObjects.selectCategorySelected,
					Excel_Handling.Get_Data(TC_ID, "SelectCategorySelected"),"Select Category Selected");
			Thread.sleep(1000);
			Extent_Reporting.Log_report_img("Select Category Selected",	"Select Category Selected", driver, test);

			action.inputText(driver,ePricerCreateAQuotePageObjects.typeModelField1,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField1"),"typeModelField1");
			Extent_Reporting.Log_report_img("TypeModelField1 entered.","TypeModelField1 entered.", driver, test);

			action.inputText(driver,ePricerCreateAQuotePageObjects.typeModelField2,
					Excel_Handling.Get_Data(TC_ID, "TypeModelField2"),"TypeModelField2");
			Extent_Reporting.Log_report_img("TypeModelField2 entered.","TypeModelField2 entered.", driver, test);

			action.inputText(driver,
					ePricerChangeConfigurationPageObjects.featureRPQField,Excel_Handling.Get_Data(TC_ID, "FeatureOne"), "FeatureOne");
			action.inputText(driver,
					ePricerChangeConfigurationPageObjects.quantityField,Excel_Handling.Get_Data(TC_ID, "QuantityField"),
					"QuantityField");
			Extent_Reporting.Log_report_img("FeatureOne entered.","FeatureOne entered.", driver, test);

			action.Javascriptexecutor_forClick(driver,
					ePricerChangeConfigurationPageObjects.addNewFeatureButton,"AddNewFeatureButton");

			action.inputText(driver,
					ePricerChangeConfigurationPageObjects.featureRPQField,Excel_Handling.Get_Data(TC_ID, "FeatureTwo"), "FeatureTwo");
			action.inputText(driver,
					ePricerChangeConfigurationPageObjects.quantityField,
					Excel_Handling.Get_Data(TC_ID, "QuantityField"),"QuantityField");
			Extent_Reporting.Log_report_img("FeatureTwo entered.","FeatureTwo entered.", driver, test);

			action.Javascriptexecutor_forClick(driver,
					ePricerChangeConfigurationPageObjects.addNewFeatureButton,"AddNewFeatureButton");

			// action.selectCheckBox(driver,
			// ePricerChangeConfigurationPageObjects.selectFeatureCheckBox,
			// "SelectFeatureCheckBox");

			action.Javascriptexecutor_forClick(driver,
					ePricerChangeConfigurationPageObjects.addNCloseButton,"addAndCloseButton");

			Extent_Reporting.Log_report_img("add and close button clicked.","add and close button clicked.", driver, test);
			Extent_Reporting.Log_Pass("add and close button clicked.","add and close button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("add and close button not clicked.",	"add and close button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	
	/**
	 * This method is for changing the Quantity Of Feature.
	 * 
	 * @throws Throwable
	 */
	public void changeQuantityOfFeature() throws Throwable {
		try {
			ePricerCreateAQuotePageObjects = new Epricer_Application_PCS_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerChangeConfigurationPageObjects = new Epricer_Application_PCS_ChangeConfigurationQuantity(driver, TC_ID);
			Thread.sleep(10000);
			List<WebElement> e = driver.findElements(By.xpath(ePricerChangeConfigurationPageObjects.dropDownFeatureButtonManageConfig));
			for (int i = 1; i <= 15; i++) {
				if (i == 4) {
					e.get(i).click();
					Extent_Reporting.Log_Pass("Feature drop down is clicked.","feature drop down is clicked.", test);
					Extent_Reporting.Log_report_img("Feature drop down is clicked..","Feature drop down is clicked.", driver, test);
					break;
				}
			}
			WebElement elementcb = driver.findElement(By.id("chckBoxFeatureCode2-1"));
			elementcb.click();
			//action.selectCheckBox(driver,ePricerChangeConfigurationPageObjects.feature1CheckBox,"Feature1CheckBox");
			Thread.sleep(8000);
			List<WebElement> j = driver.findElements(By.xpath(ePricerChangeConfigurationPageObjects.featureQuantiyFieldManageConfig));
			for (int i = 0; i <= 7; i++) {
				if (i == 3) {
					j.get(i).click();
					j.get(i).clear();
					j.get(i).sendKeys("3");
					Extent_Reporting.Log_Pass("Feature quatity is changed.","Feature quatity is changed.", test);
					Extent_Reporting.Log_report_img("Feature quatity is changed.","Feature quatity is changed.", driver, test);
					break;
				} 
			}

			action.Javascriptexecutor_forClick(driver,ePricerChangeConfigurationPageObjects.updateQuantityButton,"updateQuantity");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("updateQuantity button clicked.","updateQuantity button clicked.", driver, test);
			Extent_Reporting.Log_Pass("updateQuantity button clicked.",	"updateQuantity button clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("updateQuantity tab not clicked.","updateQuantity tab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	/**
	 * This method is for entering data For changing CFR Quantity.
	 * 
	 * @throws Throwable
	 */
	public void changeCFRQuantity() throws Throwable {
		try {
			ePricerChangeConfigurationPageObjects = new Epricer_Application_PCS_ChangeConfigurationQuantity(driver, TC_ID);
			Thread.sleep(10000);
			List<WebElement> e = driver.findElements(By.xpath(ePricerChangeConfigurationPageObjects.dropDownFeatureButtonManageConfig));

			for (int i = 1; i <= 7; i++) {
				if (i == 4) {
					Thread.sleep(10000);
					e.get(i).click();
					Extent_Reporting.Log_Pass("Feature drop down is clicked.","feature drop down is clicked.", test);
					Extent_Reporting.Log_report_img("Feature drop down is clicked..","Feature drop down is clicked.", driver, test);					break;
				}
			}
			Thread.sleep(10000);
			List<WebElement> j = driver.findElements(By.xpath(ePricerChangeConfigurationPageObjects.featureQuantiyFieldManageConfig));
			for (int i = 0; i <= 10; i++) {
				if (i == 8) {
					Thread.sleep(10000);
					j.get(i).click();
					j.get(i).clear();
					j.get(i).sendKeys("3");
					Extent_Reporting.Log_Pass("CFR quatity is changed.","CFR quatity is changed.", test);
					Extent_Reporting.Log_report_img("CFR quatity is changed.","CFR quatity is changed.", driver, test);
					break;
				}
			}
			Thread.sleep(10000);
			WebElement elementcb2 = driver.findElement(By.id("chckBoxFeatureCode2-2"));
			elementcb2.click();
			//action.selectCheckBox(driver,ePricerChangeConfigurationPageObjects.feature1CheckBox,"Feature1CheckBox");
			Thread.sleep(1000);
			action.Javascriptexecutor_forClick(driver,ePricerChangeConfigurationPageObjects.updateQuantityButton,"updateQuantity");
			Thread.sleep(4000);

			Extent_Reporting.Log_report_img("updateQuantityCFR button clicked.","updateQuantityCFR button clicked.", driver, test);
			Extent_Reporting.Log_Pass("updateQuantityCFR button clicked.","updateQuantityCFR button clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("updateQuantityCFR button not clicked.","updateQuantityCFR button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	/**
	 * This method is for selecting Tab ManageConfigurationPolygon Screen From
	 * DetialsPricing.
	 * 
	 * @throws Throwable
	 */
	public void selectTabManageConfigurationPolygonScreenFromDetialsPricing()
			throws Throwable {
		// TODO Auto-generated method stub
		try {
			ePricerChangeConfigurationPageObjects = new Epricer_Application_PCS_ChangeConfigurationQuantity(driver, TC_ID);
			Thread.sleep(2000);
			action.Javascriptexecutor_forClick(driver,ePricerChangeConfigurationPageObjects.viewAndEditConfiguration,"Manage Config");
			Thread.sleep(3000);
			Extent_Reporting.Log_report_img("manageConfigurationPolygon tab clicked.","manageConfigurationPolygon tab clicked.", driver, test);
			Extent_Reporting.Log_Pass("manageConfigurationPolygon tab clicked.","manageConfigurationPolygon tab clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("manageConfigurationPolygon tab not clicked.","manageConfigurationPolygon tab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

}
