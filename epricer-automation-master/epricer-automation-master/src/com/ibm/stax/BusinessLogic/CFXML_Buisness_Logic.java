package com.ibm.stax.BusinessLogic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Login_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

public class CFXML_Buisness_Logic {
	ElementAction action = new ElementAction();
	Common_Functions Function = new Common_Functions();
	public WebDriver driver;
	public String TC_ID;
	public static String quoteIdForTestData;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;

	private ExtentTest test;

	public CFXML_Buisness_Logic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * CFXMl upload function
	 */
	public void uploadCFXML() throws Throwable {
		try {
			File cfr = null;
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ClassLoader classLoader = getClass().getClassLoader();

			cfr = new File(classLoader.getResource("2076-624TYW7_TSS.xml").getFile());

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
			Extent_Reporting.Log_report_img("uploadCFXML Successfully done.", "uploadCFXML Successfully done.", driver,
					test);
			Extent_Reporting.Log_Pass("uploadCFXML Successfully done.", "uploadCFXML Successfully done.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CFXML Upload Failed.", "CFXML Upload Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}





	public void quoteIdFetchedAndDataSavedInExcelTSS() throws Throwable {
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
					Excel_Handling.Put_Data("EM_CFXML_SB", "EnterQuoteid", quoteIdForTestData);
					System.out.println(Excel_Handling.Get_Data("EM_CFXML_SB", "EnterQuoteid"));

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

}
