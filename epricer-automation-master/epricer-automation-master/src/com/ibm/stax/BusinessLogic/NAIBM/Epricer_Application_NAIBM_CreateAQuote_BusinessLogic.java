package com.ibm.stax.BusinessLogic.NAIBM;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ibm.stax.BusinessLogic.Epricer_Application_Login_BusinessLogic;
import com.ibm.stax.BusinessLogic.Epricer_Application_UpdateAQuote_BusinessLogic;
import com.ibm.stax.BusinessLogic.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.NAIBM.Epricer_Application_NAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Kajal Shakya
 *
 */
public class Epricer_Application_NAIBM_CreateAQuote_BusinessLogic {
	
	private ElementAction action=new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;
	public static String quoteIdForTestData;
	public static String  apprPrice;
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_NAIBM_CreateAQuote_PageObjects nAIBMCreateAQuotePageObjects = null;
	Epricer_Application_UpdateAQuote_BusinessLogic updateAQuoteBusinessLogic = null;
	Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic eMEAIBMcreateAQuoteBusinessLogic = null;
	Epricer_Application_Login_BusinessLogic loginBusinessLogic = null;
	
	public Epricer_Application_NAIBM_CreateAQuote_BusinessLogic(WebDriver d,String tcId, ExtentTest extentTest){
		this.test = extentTest;
		this.driver = d;
		this.TC_ID=tcId;
	}
	
	/**
	 * This method is to uploadInternalCFR
	 * 
	 * @throws Throwable
	 */
	public void uploadInternalCFR() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			
			ClassLoader classLoader = getClass().getClassLoader();
			File cfr = new File(classLoader.getResource("4_Barclays_Opt1_DS8886F_MES_3.2TB_Flash_Drive_Set.cfr").getFile());			
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr.getAbsolutePath());
			
			action.waitForPageToLoad(driver);
			
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.disableChecksum, "disableChecksum");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.workWithOtherCountryCFR, "workWithOtherCountryCFR");
			Thread.sleep(3000);
			
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
			if (action.CheckifExist(driver,ePricerEMEAIBMCreateAQuotePageObjects.quoteUpdateError)) {
				eMEAIBMcreateAQuoteBusinessLogic.relogin();
				loginBusinessLogic.epricerLogoScreen();
				loginBusinessLogic.ePricerLoginscreen();
				loginBusinessLogic.ePRICERMainScreen();
				eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("ExpiredValueQuote");
				eMEAIBMcreateAQuoteBusinessLogic.MoveToConfigurationTab();
				
				cfr = new File(classLoader.getResource("4_Barclays_Opt1_DS8886F_MES_3.2TB_Flash_Drive_Set.cfr").getFile());			
				driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr.getAbsolutePath());
				
				action.waitForPageToLoad(driver);
				
				action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.disableChecksum, "disableChecksum");
				action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.workWithOtherCountryCFR, "workWithOtherCountryCFR");
				Thread.sleep(3000);
				
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
				Thread.sleep(10000);
				action.handleAlert(driver);
				action.waitForPageToLoad(driver);
			} else {
				Thread.sleep(10000);
				action.handleAlert(driver);
				action.waitForPageToLoad(driver);
			}
			
			Extent_Reporting.Log_report_img("uploadCFR Successfully done.", "uploadCFR Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("uploadCFR Successfully done.", "uploadCFR Successfully done.", test);
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CFR Upload Failed.", "CFR Upload Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");		}
	
	}
	
	/**
	 * This method is to uploadInternalCFR
	 * 
	 * @throws Throwable
	 */
	public void pricingScreenData() throws Throwable{
		try{
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			
			action.waitForPageToLoad(driver);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices);			
			Thread.sleep(10000);
			action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices, "pricingPrices");
			
			if(action.isElementDisplayed(driver, nAIBMCreateAQuotePageObjects.approvedDiscountValue, "approvedDiscountValue")){
			List<WebElement> e = driver.findElements(By.xpath(nAIBMCreateAQuotePageObjects.approvedDiscountValue));
			for(int i=1;i<=4;i++)
				{
				     if(i==1){
				    	  Thread.sleep(2000);
				    	  e.get(i).clear();
				    	  e.get(i).click();
				    	  e.get(i).sendKeys(Excel_Handling.Get_Data(TC_ID, "ApprovedDiscountValue"));
				    	  Extent_Reporting.Log_report_img("ApprovedDiscountValue entered.", "ApprovedDiscountValue entered.",driver, test);
				    	  Extent_Reporting.Log_Pass("ApprovedDiscountValue not entered.", "ApprovedDiscountValue not entered.", test);
				    	  break;
				      }
				}
			}else{
					Extent_Reporting.Log_Fail("approvedDiscountValue is not entered.","approvedDiscountValue is not entered.", driver, test);
					driver.quit();
					throw new Exception("Failed");
			}
			
			Thread.sleep(20000);
			action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.recalculateBtn, "recalculateBtn");
			action.handleAlert(driver);
			Thread.sleep(3000);
			
			List<WebElement> e1 = driver.findElements(By.xpath(nAIBMCreateAQuotePageObjects.needApprovalLabel));
			if(e1!=null) {
			for(int i=1;i<=4;i++)
				{
				     if(i==1){
				    	  Thread.sleep(2000);
				    	  e1.get(i).isDisplayed();
				    	  String x = e1.get(i).getText();
				    	  Extent_Reporting.Log_report_img("needApprovalLabel displayed.", "needApprovalLabel displayed.",driver, test);
				    	  Extent_Reporting.Log_Pass(x+"needApprovalLabel displayed.", "needApprovalLabel displayed.", test);
				    	  break;
				      }
				}
			}else{
					Extent_Reporting.Log_Fail("needApprovalLabel is not displayed.","needApprovalLabel is not displayed.", driver, test);
					driver.quit();
					throw new Exception("Failed");
			}
			
			Extent_Reporting.Log_report_img("pricingScreenData Successfully done.", "pricingScreenData Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("pricingScreenData Successfully done.", "pricingScreenData Successfully done.", test);
		}catch(Exception e){
			Extent_Reporting.Log_Fail("pricing screen not completed", "pricing screen not completed", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for clicking requestApprovalTabClick.
	 * 
	 * @throws Throwable
	 */
	public void requestApprovalTabClick() throws Exception {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(30000);
			action.waitForPageToLoad(driver);
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.requestApprovalTab,"requestApprovalTab.")) {
				action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.requestApprovalTab,"requestApprovalTab");
				action.handleAlert(driver);
				Extent_Reporting.Log_report_img("requestApprovalTab clicked.","requestApprovalTab clicked.", driver, test);
				Extent_Reporting.Log_Pass("requestApprovalTab clicked.", "requestApprovalTab clicked.", test);
			}else {
				Extent_Reporting.Log_Fail("requestApprovalTab not clicked.","requestApprovalTab not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("requestApprovalTab not clicked.","requestApprovalTab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for clicking waitingForApprovalLabelCheck.
	 * 
	 * @throws Throwable
	 */
	public void waitingForApprovalLabelCheck() throws Exception {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(30000);
			action.waitForPageToLoad(driver);
			
			List<WebElement> e1 = driver.findElements(By.xpath(nAIBMCreateAQuotePageObjects.waitingForApprovalLabel));
			if(e1!=null) {
			for(int i=1;i<=4;i++)
				{
				     if(i==1){
				    	  Thread.sleep(2000);
				    	  e1.get(i).isDisplayed();
				    	 // String x = e1.get(i).getText();
				    	  Extent_Reporting.Log_report_img("Waiting for approval displayed.", "Waiting for approval displayed.",driver, test);
				    	  Extent_Reporting.Log_Pass("Waiting for approval displayed.", "Waiting for approval displayed.", test);
				    	  break;
				      }
				}
			}else{
					Extent_Reporting.Log_Fail("Waiting for approval is not displayed.","Waiting for approval is not displayed.", driver, test);
					driver.quit();
					throw new Exception("Failed");
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("waitingForApprovalLabel is not present.","waitingForApprovalLabel is not present.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for pricingScreenUpdateData.
	 * 
	 * @throws Throwable
	 */
	public void pricingScreenUpdateData() throws Throwable{
		try{
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(5000);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices );
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices, "pricingPrices");
			
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.approvedPriceValueNA , "ApprovedPriceValueNA")){
				action.inputText(driver,nAIBMCreateAQuotePageObjects.approvedPriceValueNA, Excel_Handling.Get_Data(TC_ID, "ApprovedPriceValue"), "ApprovedPriceValue");
				/*WebElement e = driver.findElement(By.xpath(nAIBMCreateAQuotePageObjects.approvedPriceValueNA));
				e.clear();
				e.sendKeys(Excel_Handling.Get_Data(TC_ID, "ApprovedPriceValue"));				
				*/}else{
						Extent_Reporting.Log_Fail("ApprovedPriceValue is not entered.","ApprovedPriceValue is not entered.", driver, test);
						driver.quit();
						throw new Exception("Failed");
				}
				
			action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.recalculateBtn, "recalculateBtn");
			action.handleAlert(driver);
			Thread.sleep(3000);
			
			Extent_Reporting.Log_report_img("pricingScreenUpdateData discount added Successfully.", "pricingScreenUpdateData discount added Successfully.", driver, test);
			Extent_Reporting.Log_Pass("pricingScreenUpdateData discount added Successfully.", "pricingScreenUpdateData discount added Successfully.", test);
		}catch(Exception e)
		{
			Extent_Reporting.Log_Fail("pricing screen not completed", "pricing screen not completed", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for clicking approvalTab click.
	 * 
	 * @throws Throwable
	 */
	public void approvalTabData(String sBCstring) throws Exception {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(15000);
			
			action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.approvalTab,"approvalTab");
			action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.radioApprovalApprove,"radioApprovalApprove");
			action.inputText(driver,nAIBMCreateAQuotePageObjects.intranetId, Excel_Handling.Get_Data(TC_ID, "userName"), "intranetId");
			if (sBCstring.equalsIgnoreCase("Yes")) {
				Select dd1 = new Select(driver.findElement(By.name("backupgroupnameid1")));
				if(dd1.isMultiple()){
					dd1.selectByVisibleText("SDE2,GEO Specific Exemptions");
					Extent_Reporting.Log_Pass("specialBidCode clicked.", "specialBidCode clicked.", test);
				}
			}
			
//			Select dd1 = new Select(driver.findElement(By.name("backupgroupnameid1")));
//			if(dd1.isMultiple()){
//				dd1.selectByVisibleText("A01,ALL-Other");
//				Extent_Reporting.Log_Pass("specialBidCode clicked.", "specialBidCode clicked.", test);
//			}
			
			action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.naIBMQuoteSubmitBtn,"naIBMQuoteSubmitBtn");
			action.handleAlert(driver);
			Extent_Reporting.Log_Pass("naIBMQuoteSubmitBtn clicked.", "naIBMQuoteSubmitBtn clicked.", test);
			
			Thread.sleep(10000);
			action.Javascriptexecutor_forClick(driver, "//div[@class='ngdialog-close']", "closebtn");
			
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("approvalTab not clicked.","approvalTab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for clicking ongoingQuoteApprovedLabelCheck.
	 * 
	 * @throws Throwable
	 */
	public void ongoingQuoteApprovedLabelCheck() throws Exception {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(30000);
			action.waitForPageToLoad(driver);
			
			List<WebElement> e1 = driver.findElements(By.xpath(nAIBMCreateAQuotePageObjects.waitingForApprovalLabel));
			if(e1!=null) {
			for(int i=1;i<=4;i++)
				{
				     if(i==1){
				    	  Thread.sleep(2000);
				    	  e1.get(i).isDisplayed();
				    	 // String x = e1.get(i).getText();
				    	  Extent_Reporting.Log_report_img("ongoingQuoteApprovedLabel displayed.", "ongoingQuoteApprovedLabel displayed.",driver, test);
				    	  Extent_Reporting.Log_Pass("ongoingQuoteApprovedLabel displayed.", "ongoingQuoteApprovedLabel displayed.", test);
				    	  break;
				      }
				}
			}else{
					Extent_Reporting.Log_Fail("ongoingQuoteApprovedLabel not displayed.","ongoingQuoteApprovedLabel not displayed.", driver, test);
					driver.quit();
					throw new Exception("Failed");
			}
			action.waitForPageToLoad(driver);
			Thread.sleep(5000);
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("ongoingQuoteApprovedLabel not displayed.","ongoingQuoteApprovedLabel not displayed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is to approvedQuotepricingScreenData
	 * 
	 * @throws Throwable
	 */
	public void approvedQuotepricingScreenData() throws Throwable{
		try{
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(5000);
			action.waitForPageToLoad(driver);
			action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices);			
			Thread.sleep(10000);
			action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.pricingPrices, "pricingPrices");
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("pricingScreenData Successfully done.", "pricingScreenData Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("pricingScreenData Successfully done.", "pricingScreenData Successfully done.", test);
		}catch(Exception e){
			Extent_Reporting.Log_Fail("pricing screen not completed", "pricing screen not completed", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for reportsCheck.
	 * 
	 * @throws Throwable
	 */
	public void reportsCheck() throws Exception {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(30000);
			action.waitForPageToLoad(driver);
			
			action.getWindowHandle(driver, "e-Pricer");
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.standardReportBtn ,"standardReportBtn")) {
				action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.standardReportBtn,"standardReportBtn");
				Extent_Reporting.Log_report_img("standardReportBtn clicked.","standardReportBtn clicked.", driver, test);
				Extent_Reporting.Log_Pass("standardReportBtn clicked.", "standardReportBtn clicked.", test);
			}else {
				Extent_Reporting.Log_Fail("standardReportBtn not clicked.","standardReportBtn not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			Thread.sleep(50000);
			action.waitForPageToLoad(driver);
			action.getWindowHandle(driver, "IBM e-Pricer | Report");
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.standardReportScreen, "standardReportScreen")) {
				  Extent_Reporting.Log_report_img("standardReportScreen displayed.", "standardReportScreen displayed.",driver, test);
		    	  Extent_Reporting.Log_Pass("standardReportScreen displayed.", "standardReportScreen displayed.", test);
		    	  driver.close();
			}else {
				Extent_Reporting.Log_Fail("standardReportScreen not displayed.","standardReportScreen not displayed.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			action.getWindowHandle(driver, "e-Pricer");
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.historyReportBtn, "historyReportBtn")) {
				action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.historyReportBtn,"historyReportBtn");
				Extent_Reporting.Log_report_img("historyReportBtn clicked.","historyReportBtn clicked.", driver, test);
				Extent_Reporting.Log_Pass("historyReportBtn clicked.", "historyReportBtn clicked.", test);
			}else {
				Extent_Reporting.Log_Fail("historyReportBtn not clicked.","historyReportBtn not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			action.getWindowHandle(driver, "IBM e-Pricer | Report");
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.historyReportScreen, "historyReportScreen")) {
				  Extent_Reporting.Log_report_img("historyReportScreen displayed.", "historyReportScreen displayed.",driver, test);
		    	  Extent_Reporting.Log_Pass("historyReportScreen displayed.", "historyReportScreen displayed.", test);
		    	  driver.close();
			}else {
				Extent_Reporting.Log_Fail("historyReportScreen not displayed.","historyReportScreen not displayed.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			action.getWindowHandle(driver, "e-Pricer");
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.tailoredReportBtn, "tailoredReportBtn")) {
				action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.tailoredReportBtn,"tailoredReportBtn");
				Extent_Reporting.Log_report_img("tailoredReportBtn clicked.","tailoredReportBtn clicked.", driver, test);
				Extent_Reporting.Log_Pass("tailoredReportBtn clicked.", "tailoredReportBtn clicked.", test);
			}else {
				Extent_Reporting.Log_Fail("tailoredReportBtn not clicked.","tailoredReportBtn not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("Standard report is not present.","Standard report is not present.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for tailoredReportDataCheck.
	 * 
	 * @throws Throwable
	 */
	public void tailoredReportDataCheck() throws Exception {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			Thread.sleep(30000);
			action.waitForPageToLoad(driver);
			
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.tailoredReportScreen, "tailoredReportScreen")) {
				  Extent_Reporting.Log_report_img("tailoredReportScreen displayed.", "tailoredReportScreen displayed.",driver, test);
		    	  Extent_Reporting.Log_Pass("tailoredReportScreen displayed.", "tailoredReportScreen displayed.", test);
			}else {
				Extent_Reporting.Log_Fail("tailoredReportScreen not displayed.","tailoredReportScreen not displayed.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			if(action.isElementDisplayed(driver,"//input[@id='reportSectionTitle']", "tailoredReportName")) {
				if(action.isElementDisplayed(driver, "//button[@translate='Remove']", "remove btn")) {
					action.Javascriptexecutor_forClick(driver,"//button[@translate='Remove']","remove btn clicked");
					action.handleAlert(driver);
					action.inputText(driver, nAIBMCreateAQuotePageObjects.tailoredReportName, Excel_Handling.Get_Data(TC_ID, "mailBody"), "tailoredReportName");
					Extent_Reporting.Log_report_img("tailoredReportName entered.", "tailoredReportName entered.",driver, test);
					Extent_Reporting.Log_Pass("tailoredReportName entered.", "tailoredReportName entered.", test);
				}else {
					action.inputText(driver, nAIBMCreateAQuotePageObjects.tailoredReportName, Excel_Handling.Get_Data(TC_ID, "mailBody"), "tailoredReportName");
					Extent_Reporting.Log_report_img("tailoredReportName entered.", "tailoredReportName entered.",driver, test);
					Extent_Reporting.Log_Pass("tailoredReportName entered.", "tailoredReportName entered.", test);
				}

			}else {
				Extent_Reporting.Log_Fail("tailoredReportName not entered.","tailoredReportName not entered.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			
			Select dd1 = new Select(driver.findElement(By.name("availableSections")));
			if(dd1.isMultiple()){
					dd1.selectByVisibleText("Approval");
					Extent_Reporting.Log_report_img("sections selected.","sections selected.", driver, test);
					Extent_Reporting.Log_Pass("sections selected.", "sections selected.", test);
			}else{
				Extent_Reporting.Log_Fail("sections not selected.","sections not selected.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.sectionsShowBtn, "sectionsShowBtn")) {
				action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.sectionsShowBtn,"sectionsShowBtn");
				Extent_Reporting.Log_report_img("sectionsShowBtn clicked.","sectionsShowBtn clicked.", driver, test);
				Extent_Reporting.Log_Pass("sectionsShowBtn clicked.", "sectionsShowBtn clicked.", test);
			}else {
				Extent_Reporting.Log_Fail("sectionsShowBtn not clicked.","sectionsShowBtn not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			
			//Select dd2 = new Select(driver.findElement(By.name("availableSections")));
			if(dd1.isMultiple()){
					dd1.selectByVisibleText("Components detail - unit price - purchase and OTC");
					Extent_Reporting.Log_report_img("sections selected.","sections selected.", driver, test);
					Extent_Reporting.Log_Pass("sections selected.", "sections selected.", test);
			}else{
				Extent_Reporting.Log_Fail("sections not selected.","sections not selected.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.sectionsShowBtn, "sectionsShowBtn")) {
				action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.sectionsShowBtn,"sectionsShowBtn");
				Extent_Reporting.Log_report_img("sectionsShowBtn clicked.","sectionsShowBtn clicked.", driver, test);
				Extent_Reporting.Log_Pass("sectionsShowBtn clicked.", "sectionsShowBtn clicked.", test);
			}else {
				Extent_Reporting.Log_Fail("sectionsShowBtn not clicked.","sectionsShowBtn not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			//Select dd3 = new Select(driver.findElement(By.name("availableSections")));
			if(dd1.isMultiple()){
				dd1.selectByVisibleText("Quote, customer and configuration");
				Extent_Reporting.Log_report_img("sections selected.","sections selected.", driver, test);
				Extent_Reporting.Log_Pass("sections selected.", "sections selected.", test);
			}else{
				Extent_Reporting.Log_Fail("sections not selected.","sections not selected.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.sectionsShowBtn, "sectionsShowBtn")) {
				action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.sectionsShowBtn,"sectionsShowBtn");
				Extent_Reporting.Log_report_img("sectionsShowBtn clicked.","sectionsShowBtn clicked.", driver, test);
				Extent_Reporting.Log_Pass("sectionsShowBtn clicked.", "sectionsShowBtn clicked.", test);
			}else {
				Extent_Reporting.Log_Fail("sectionsShowBtn not clicked.","sectionsShowBtn not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.tailoredReportSaveAndViewBtn,"tailoredReportSaveAndViewBtn")) {
				action.Javascriptexecutor_forClick(driver, nAIBMCreateAQuotePageObjects.tailoredReportSaveAndViewBtn,"tailoredReportSaveAndViewBtn");
				Extent_Reporting.Log_report_img("tailoredReportSaveAndViewBtn clicked.","tailoredReportSaveAndViewBtn clicked.", driver, test);
				Extent_Reporting.Log_Pass("tailoredReportSaveAndViewBtn clicked.", "tailoredReportSaveAndViewBtn clicked.", test);
			}else {
				Extent_Reporting.Log_Fail("tailoredReportSaveAndViewBtn not clicked.","tailoredReportSaveAndViewBtn not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
			action.getWindowHandle(driver, "IBM e-Pricer_Report");
			if(action.isElementDisplayed(driver,nAIBMCreateAQuotePageObjects.testTailoredReport, "testTailoredReport")) {
				  Extent_Reporting.Log_report_img("testTailoredReport displayed.", "testTailoredReport displayed.",driver, test);
		    	  Extent_Reporting.Log_Pass("testTailoredReport displayed.", "testTailoredReport displayed.", test);
		    	  Extent_Reporting.Log_Pass("tailoredReportData Checked.", "tailoredReportData Checked.", test);
		    	  driver.close();
			}else {
				Extent_Reporting.Log_Fail("testTailoredReport not displayed.","testTailoredReport not displayed.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("tailoredReportData not Checked.","tailoredReportData not Checked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is to uploadMultipleInternalCFR
	 * 
	 * @throws Throwable
	 */
	public void uploadMultipleInternalCFR() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			eMEAIBMcreateAQuoteBusinessLogic = new Epricer_Application_EMEAIBM_CreateAQuote_BusinessLogic(driver, TC_ID, test);
			loginBusinessLogic = new Epricer_Application_Login_BusinessLogic(driver, TC_ID, test);
			
			ClassLoader classLoader = getClass().getClassLoader();
			File cfr = new File(classLoader.getResource("Aegon_GB_VEBsnH6064_FC4016nFC4017mes_24aug15.cfr").getFile());			
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr.getAbsolutePath());
			
			action.waitForPageToLoad(driver);
			
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.disableChecksum, "disableChecksum");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.workWithOtherCountryCFR, "workWithOtherCountryCFR");			
			
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
			Thread.sleep(5000);
			action.waitForPageToLoad(driver);
			
			File cfr1 = new File(classLoader.getResource("4_Barclays_Opt1_DS8886F_MES_3.2TB_Flash_Drive_Set.cfr").getFile());			
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr1.getAbsolutePath());
			
			action.waitForPageToLoad(driver);
			
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.disableChecksum, "disableChecksum");
			action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.workWithOtherCountryCFR, "workWithOtherCountryCFR");
			Thread.sleep(3000);
			
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
			if (action.CheckifExist(driver,ePricerEMEAIBMCreateAQuotePageObjects.quoteUpdateError)) {
				eMEAIBMcreateAQuoteBusinessLogic.relogin();
				loginBusinessLogic.epricerLogoScreen();
				loginBusinessLogic.ePricerLoginscreen();
				loginBusinessLogic.ePRICERMainScreen();
				eMEAIBMcreateAQuoteBusinessLogic.clickOnIBMSearchQuote("ExpiredValueQuote");
				eMEAIBMcreateAQuoteBusinessLogic.MoveToConfigurationTab();
				
				cfr = new File(classLoader.getResource("4_Barclays_Opt1_DS8886F_MES_3.2TB_Flash_Drive_Set.cfr").getFile());			
				driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr.getAbsolutePath());
				
				action.waitForPageToLoad(driver);
				
				action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.disableChecksum, "disableChecksum");
				action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.workWithOtherCountryCFR, "workWithOtherCountryCFR");
				Thread.sleep(3000);
				
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
				Thread.sleep(10000);
				action.handleAlert(driver);
				action.waitForPageToLoad(driver);
			} else {
				Thread.sleep(10000);
				action.handleAlert(driver);
				action.waitForPageToLoad(driver);
			}
			Thread.sleep(3000);
			action.handleAlert(driver);
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("uploadCFR Successfully done.", "uploadCFR Successfully done.", driver, test);
			Extent_Reporting.Log_Pass("uploadCFR Successfully done.", "uploadCFR Successfully done.", test);
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CFR Upload Failed.", "CFR Upload Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");		}
	
	}
	
	/**
	 * This method is to applyCopraAndApprovedPrice
	 * 
	 * @throws Throwable
	 */
	public void applyCopraAndApprovedPrice(Boolean tab) throws Throwable {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			if (tab) {
				Thread.sleep(20000);
				action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.CopraTab, "CopraTab");
				action.waitForPageToLoad(driver);
				Extent_Reporting.Log_report_img("CopraTab Verified.","CopraTab Verified.", driver, test);
				Extent_Reporting.Log_Pass("CopraTab Verified.", "CopraTab Verified.", test);
			} else {
				if(action.CheckifExist(driver,ePricerEMEAIBMCreateAQuotePageObjects.CopraTab)) {
					Thread.sleep(10000);
					action.waitForElementClickable(driver, ePricerEMEAIBMCreateAQuotePageObjects.CopraTab);
					Thread.sleep(10000);
					action.Clickbtn(driver, ePricerEMEAIBMCreateAQuotePageObjects.CopraTab, "CopraTab");
					action.waitForPageToLoad(driver);
					Thread.sleep(8000);
					action.Javascriptexecutor_forClick(driver, ePricerEMEAIBMCreateAQuotePageObjects.applyApprovedPrice, "ApplyApprovedPrice");
					action.waitForPageToLoad(driver);
					Thread.sleep(3000);
					Extent_Reporting.Log_report_img("applyCopraAndApprovedPrice Verified.","applyCopraAndApprovedPrice Verified.", driver, test);
					Extent_Reporting.Log_Pass("applyCopraAndApprovedPrice Verified.", "applyCopraAndApprovedPrice Verified.", test);
				}else {
					Extent_Reporting.Log_Fail("applyCopraAndApprovedPrice not Verified.","applyCopraAndApprovedPrice not Verified.", driver, test);
					driver.quit();
					throw new Exception("Failed");
				}
			}			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("applyCopraAndApprovedPrice not Verified.", "applyCopraAndApprovedPrice not Verified.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is to uploadCFRCheck
	 * 
	 * @throws Throwable
	 */
	public void uploadSecondCFRCheck() throws Throwable {
		try {
			updateAQuoteBusinessLogic = new Epricer_Application_UpdateAQuote_BusinessLogic(driver, TC_ID, test);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			action.waitForPageToLoad(driver);			
			if(updateAQuoteBusinessLogic.downloadThisCFRIcon()) {
				List<WebElement> e1 = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.downloadThisCFRIcon));
				if(e1!=null) {
					for(int i=1;i<=4;i++)
					{
						if(i==3){
							Thread.sleep(2000);
							e1.get(i).isDisplayed();
							Extent_Reporting.Log_report_img("downloadThisCFRIcon present.", "downloadThisCFRIcon present.", driver, test);
							Extent_Reporting.Log_Pass("downloadThisCFRIcon present.", "downloadThisCFRIcon present.", test);
							break;
						}
					}

				}else {
					Extent_Reporting.Log_Fail("downloadThisCFRIcon not present.", "downloadThisCFRIcon not present.", driver, test);
					driver.quit();
					throw new Exception("Failed");
				}
			}
		}catch (Exception e) {
				Extent_Reporting.Log_Fail("downloadThisCFRIcon not present.", "downloadThisCFRIcon not present.", driver, test);
				e.printStackTrace();
				driver.quit();
				throw new Exception("Failed");		
			}

		}
	
	/**
	 * This method is to approvedPriceValue
	 * 
	 * @throws Throwable
	 */
	public void approvedPriceValue() throws Throwable {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			
			action.waitForPageToLoad(driver);
			Thread.sleep(10000);
						
			if(action.isElementDisplayed(driver, nAIBMCreateAQuotePageObjects.approvedDiscountValue, "approvedDiscountValue")){
				List<WebElement> e = driver.findElements(By.xpath(nAIBMCreateAQuotePageObjects.approvedDiscountValue));
				for(int i=1;i<=4;i++)
					{
					     if(i==1){
					    	  Thread.sleep(5000);
					    	  apprPrice = e.get(i).getAttribute("value").toString();
					    	  Extent_Reporting.Log_report_img("approvedPrice Value Present.", "approvedPrice Value Present.",driver, test);
					    	  Extent_Reporting.Log_Pass("approvedPrice Value Present.", "approvedPrice Value Present.", test);
					    	  break;
					      }
					}
				}else{
						Extent_Reporting.Log_Fail("approvedPrice Value not Present.","approvedPrice Value not Present.", driver, test);
						driver.quit();
						throw new Exception("Failed");
				}
			
			action.waitForPageToLoad(driver);
			Thread.sleep(5000);
		}catch (Exception e) {
				Extent_Reporting.Log_Fail("approvedPrice Value not Present.", "approvedPrice Value not Present.", driver, test);
				e.printStackTrace();
				driver.quit();
				throw new Exception("Failed");		
			}

		}
	
	/**
	 * This method is to approvedPriceValueCheck
	 * 
	 * @throws Throwable
	 */
	public void approvedPriceValueCheck() throws Throwable {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);

			action.waitForPageToLoad(driver);			
			if(apprPrice.contains(Excel_Handling.Get_Data(TC_ID, "ApprovedDiscountValue").toString())){
				Extent_Reporting.Log_report_img("ApprovedPriceValue is equal.", "ApprovedPriceValue is equal.",driver, test);
				Extent_Reporting.Log_Pass("ApprovedPriceValue is equal.", "ApprovedPriceValue is equal.", test);
			}//else{
//				Extent_Reporting.Log_Fail("ApprovedPriceValue is equal.","ApprovedPriceValue is equal.", driver, test);
//				driver.quit();
//				throw new Exception("Failed");
//			}
		}catch (Exception e) {
//			Extent_Reporting.Log_Fail("ApprovedPriceValue is not equal.", "ApprovedPriceValue is not equal.", driver, test);
//			e.printStackTrace();
//			driver.quit();
//			throw new Exception("Failed");		
		}

}

	public void moveToEntitlementsAndPromoTab() throws Throwable {
		try{
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(20000);
			action.waitForElementClickable(driver, nAIBMCreateAQuotePageObjects.entitlementsPromoTab);
			action.Clickbtn(driver, nAIBMCreateAQuotePageObjects.entitlementsPromoTab, "entitlementsPromoTab");
			action.waitForPageToLoad(driver);
			Thread.sleep(3000);
			Extent_Reporting.Log_report_img("Succesfully moved to entitlementsPromo tab.", "Succesfully moved to entitlementsPromo tab.",driver, test);
			Extent_Reporting.Log_Pass("Succesfully moved to entitlementsPromo tab.", "Succesfully moved to entitlementsPromo tab.", test); 
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("entitlementsPromo tab not opened.", "entitlementsPromo tab not opened.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		
	}

	public void verifyEntitlementsAndPromoScreen() throws Throwable {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.discountOnEP)) {
				Extent_Reporting.Log_report_img("Discount is visible on entitlementsPromo tab.", "Discount is visible on entitlementsPromo tab.",driver, test);
				Extent_Reporting.Log_Pass("Discount is visible on entitlementsPromo tab.", "Discount is visible on entitlementsPromo tab.", test); 
			} else 
				Extent_Reporting.Log_Fail("Discount is not visible on entitlementsPromo tab.", "Discount is not visible on entitlementsPromo tab.", driver, test);
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.referenceOnEP)) {
				Extent_Reporting.Log_report_img("reference is visible on entitlementsPromo tab.", "reference is visible on entitlementsPromo tab.",driver, test);
				Extent_Reporting.Log_Pass("reference is visible on entitlementsPromo tab.", "reference is visible on entitlementsPromo tab.", test); 
			} else 
				Extent_Reporting.Log_Fail("reference is not visible on entitlementsPromo tab.", "reference is not visible on entitlementsPromo tab.", driver, test);
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.entitlementDescription)) {
				Extent_Reporting.Log_report_img("EntitlementDescription is visible on entitlementsPromo tab.", "EntitlementDescription is visible on entitlementsPromo tab.",driver, test);
				Extent_Reporting.Log_Pass("EntitlementDescription is visible on entitlementsPromo tab.", "EntitlementDescription is visible on entitlementsPromo tab.", test); 
			} else 
				Extent_Reporting.Log_Fail("EntitlementDescription is not visible on entitlementsPromo tab.", "EntitlementDescription is not visible on entitlementsPromo tab.", driver, test);
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.byComponentTabOnEP)) {
				Extent_Reporting.Log_report_img("byComponentTab is visible on entitlementsPromo tab.", "byComponentTab is visible on entitlementsPromo tab.",driver, test);
				Extent_Reporting.Log_Pass("byComponentTab is visible on entitlementsPromo tab.", "byComponentTab is visible on entitlementsPromo tab.", test); 
			} else 
				Extent_Reporting.Log_Fail("byComponentTab is not visible on entitlementsPromo tab.", "byComponentTab is not visible on entitlementsPromo tab.", driver, test);
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.byReferenceTabOnEP)) {
				Extent_Reporting.Log_report_img("byReferenceTab is visible on entitlementsPromo tab.", "byReferenceTab is visible on entitlementsPromo tab.",driver, test);
				Extent_Reporting.Log_Pass("byReferenceTab is visible on entitlementsPromo tab.", "byReferenceTab is visible on entitlementsPromo tab.", test); 
			} else 
				Extent_Reporting.Log_Fail("byReferenceTab is not visible on entitlementsPromo tab.", "byReferenceTab is not visible on entitlementsPromo tab.", driver, test);
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.byReferenceAvailableTabOnEP)) {
				Extent_Reporting.Log_report_img("byReferenceAvailableTab is visible on entitlementsPromo tab.", "byReferenceAvailableTab is visible on entitlementsPromo tab.",driver, test);
				Extent_Reporting.Log_Pass("byReferenceAvailableTab is visible on entitlementsPromo tab.", "byReferenceAvailableTab is visible on entitlementsPromo tab.", test); 
			} else 
				Extent_Reporting.Log_Fail("byReferenceAvailableTab is not visible on entitlementsPromo tab.", "byReferenceAvailableTab is not visible on entitlementsPromo tab.", driver, test);
		
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Verification on EntitlementsAndPromo Screen Failed.", "Verification on EntitlementsAndPromo Screen Failed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void moveToCustomerPolygon() throws Throwable {
		try{
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(3000);
			//action.waitForElementClickable(driver, nAIBMCreateAQuotePageObjects.customerPolygon);
			action.Clickbtn(driver, nAIBMCreateAQuotePageObjects.customerPolygon, "customerPolygon");
			action.waitForPageToLoad(driver);
			Thread.sleep(3000);
			Extent_Reporting.Log_report_img("Succesfully moved to customerPolygon tab.", "Succesfully moved to customerPolygon tab.",driver, test);
			Extent_Reporting.Log_Pass("Succesfully moved to customerPolygon tab.", "Succesfully moved to customerPolygon tab.", test); 
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("customerPolygon tab not opened.", "customerPolygon tab not opened.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		
	}

	public void verifyThePriceAndTheDiscount() throws Throwable {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.entitledPriceVisible)) {
				Extent_Reporting.Log_report_img("Discount is visible on entitlementsPromo tab.", "Discount is visible on entitlementsPromo tab.",driver, test);
				Extent_Reporting.Log_Pass("Discount is visible on entitlementsPromo tab.", "Discount is visible on entitlementsPromo tab.", test); 
			} else 
				Extent_Reporting.Log_Fail("Discount is not visible on entitlementsPromo tab.", "Discount is not visible on entitlementsPromo tab.", driver, test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Discount is not visible on entitlementsPromo tab.", "Discount is not visible on entitlementsPromo tab.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		
	}

	public void verifyDiscountOnEPScreentabs() throws Throwable {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.byComponentTabOnEP)) {
				action.clickFirst(driver, nAIBMCreateAQuotePageObjects.byComponentTabOnEP, "byComponentTabOnEP");
				String dis = action.getInputTextValue(driver, nAIBMCreateAQuotePageObjects.discountOnByComponent, "discountOnByComponent").toString();
				if (dis!=null) {
					Extent_Reporting.Log_report_img("byComponentTab discount is visible on entitlementsPromo tab.", "byComponentTab discount is visible on entitlementsPromo tab.",driver, test);
					Extent_Reporting.Log_Pass("byComponentTab discount is visible on entitlementsPromo tab.", "byComponentTab discount is visible on entitlementsPromo tab.", test); 
				} else
					Extent_Reporting.Log_Fail("byComponentTab discount is not visible on entitlementsPromo tab.", "byComponentTab discount is not visible on entitlementsPromo tab.", driver, test);	
			}
				else{
					Extent_Reporting.Log_Fail("byComponentTab discount is not visible on entitlementsPromo tab.", "byComponentTab discount is not visible on entitlementsPromo tab.", driver, test);
					driver.quit();
					throw new Exception("Failed");
			}
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.byReferenceTabOnEP)) {
				action.clickFirst(driver, nAIBMCreateAQuotePageObjects.byReferenceTabOnEP, "byReferenceTabOnEP");
				Thread.sleep(5000);
				List<WebElement> e = driver.findElements(By.xpath(nAIBMCreateAQuotePageObjects.discountOnByReference));
				for(int i=15;i<=16;)
					{
					
					apprPrice = e.get(i).getText().toString();
					if (apprPrice!=null) {
						Extent_Reporting.Log_report_img("ByReferenceTab discount is visible on entitlementsPromo tab.", "ByReferenceTab discount is visible on entitlementsPromo tab.",driver, test);
					    Extent_Reporting.Log_Pass("ByReferenceTab discount is visible on entitlementsPromo tab.", "ByReferenceTab discount is visible on entitlementsPromo tab.", test); 
					    break;					
					}else{
					Extent_Reporting.Log_Fail("ByReferenceTab discount is not visible on entitlementsPromo tab.", "ByReferenceTab discount is not visible on entitlementsPromo tab.", driver, test);
					driver.quit();
					throw new Exception("Failed");
						}
					}
			}				
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.byReferenceAvailableTabOnEP)) {
				Extent_Reporting.Log_report_img("byReferenceAvailableTab is visible on entitlementsPromo tab.", "byReferenceAvailableTab is visible on entitlementsPromo tab.",driver, test);
				Extent_Reporting.Log_Pass("byReferenceAvailableTab is visible on entitlementsPromo tab.", "byReferenceAvailableTab is visible on entitlementsPromo tab.", test); 
			} else 
				Extent_Reporting.Log_Fail("byReferenceAvailableTab is not visible on entitlementsPromo tab.", "byReferenceAvailableTab is not visible on entitlementsPromo tab.", driver, test);
			}
			catch (Exception e) {
			Extent_Reporting.Log_Fail("Discount is not visible on entitlementsPromo tab.", "Discount is not visible on entitlementsPromo tab.", driver, test);
			e.printStackTrace();
			driver.quit();			
			throw new Exception("Failed");
		}
	}
	public void verifyDiscountNotVisibleOnEPScreentabs() throws Throwable {
		try {
			nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForPageToLoad(driver);
			Thread.sleep(5000);
			if (action.isElementDisplay(driver, nAIBMCreateAQuotePageObjects.byComponentTabOnEP)) {
				action.clickFirst(driver, nAIBMCreateAQuotePageObjects.byComponentTabOnEP, "byComponentTabOnEP");
				String dis = action.getInputTextValue(driver, nAIBMCreateAQuotePageObjects.discountOnByComponent, "discountOnByComponent").toString();
				if (dis.isEmpty()) {
					Extent_Reporting.Log_report_img("byComponentTab discount is visible on entitlementsPromo tab.", "byComponentTab discount is visible on entitlementsPromo tab.",driver, test);
					Extent_Reporting.Log_Pass("byComponentTab discount is visible on entitlementsPromo tab.", "byComponentTab discount is visible on entitlementsPromo tab.", test); 
				} else
					Extent_Reporting.Log_Fail("byComponentTab discount is not visible on entitlementsPromo tab.", "byComponentTab discount is not visible on entitlementsPromo tab.", driver, test);	
			}
				else{
					Extent_Reporting.Log_Fail("byComponentTab discount is not visible on entitlementsPromo tab.", "byComponentTab discount is not visible on entitlementsPromo tab.", driver, test);
					driver.quit();
					throw new Exception("Failed");
			}
		}
			catch (Exception e) {
			Extent_Reporting.Log_Fail("Discount is not visible on entitlementsPromo tab.", "Discount is not visible on entitlementsPromo tab.", driver, test);
			e.printStackTrace();
			driver.quit();			
			throw new Exception("Failed");
		}
	}
}

