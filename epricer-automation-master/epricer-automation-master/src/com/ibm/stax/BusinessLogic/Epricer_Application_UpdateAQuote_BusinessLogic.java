package com.ibm.stax.BusinessLogic;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ibm.stax.PageObjects.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Login_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Kajal Shakya
 *
 */
public class Epricer_Application_UpdateAQuote_BusinessLogic {

	private ElementAction action = new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;
	public static String quoteId;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	ClassLoader classLoader = getClass().getClassLoader();
	File authenticationIBMGUI = new File(classLoader.getResource("AuthenticationIBMGUI.exe").getFile());
	// private String authenticationIBMGUIPath =
	// authenticationIBMGUI.getAbsolutePath();

	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = null;
	Epricer_Application_Login_PageObjects ePricerLoginPageObjects = null;

	public Epricer_Application_UpdateAQuote_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for clicking searchQuotesLink.
	 * 
	 * @throws Throwable
	 */
	public void searchQuotesLinkClick() throws Exception {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			Extent_Reporting.Log_report_img("Clicking on searchQuotesLink ", "Clicking on searchQuotesLink", driver,
					test);
			action.waitForElementClickable(driver, ePricerUpdateAQuotePageObjects.searchQuotesLink);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.searchQuotesLink,
					"searchQuotes Link ");

			Extent_Reporting.Log_report_img("searchQuotesLink clicked.", "searchQuotesLink clicked.", driver, test);
			Extent_Reporting.Log_Pass("searchQuotesLink clicked.", "searchQuotesLink clicked.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("searchQuotesLink not clicked.", "searchQuotesLink not clicked.", driver, test);
			e.printStackTrace();
			driver.quit();
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
			Thread.sleep(10000);
			action.handleAlert(driver);
			// action.waitForElementVisible(driver,
			// ePricerUpdateAQuotePageObjects.overviewPolygon );
			Thread.sleep(20000);
			if (action.checkElementClickableFluent(driver, ePricerUpdateAQuotePageObjects.searchQuotesScreen,
					"searchQuotesScreen")) {
				Extent_Reporting.Log_report_img("searchQuotesScreen is displayed.", "searchQuotesScreen is displayed.",
						driver, test);
				Extent_Reporting.Log_Pass("searchQuotesScreen is displayed.", "searchQuotesScreen is displayed.", test);
			} else {
				Extent_Reporting.Log_Fail("searchQuotesScreen is not displayed.",
						"searchQuotesScreen is not displayed.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("searchQuotesScreen is not displayed.", "searchQuotesScreen is not displayed.",
					driver, test);
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
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
			
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,	ePricerUpdateAQuotePageObjects.searchCriteriaSelect,
					Excel_Handling.Get_Data(TC_ID, "SearchCriteriaSelect"), "Select search Criteria Selected");
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("Select search Criteria Selected", "Select search Criteria Selected",
					driver, test);
			Extent_Reporting.Log_Pass("Select search Criteria Selected", "Select search Criteria Selected", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Select search Criteria not Selected", "Select search Criteria not Selected",
					driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for enterQuoteId
	 * 
	 * @throws Throwable
	 */
	@SuppressWarnings("static-access")
	public void enterQuoteId() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			// Thread.sleep(2000);

			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.enterQuoteid);
			action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.enterQuoteid, "enterQuoteid");

			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).click();
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid))
					.sendKeys(ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteId);

			Extent_Reporting.Log_report_img("Quoteid entered.", "Quoteid entered.", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Quoteid not entered.", "Quoteid not entered.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for searchQuoteButtonClicked
	 * 
	 * @throws Throwable
	 */
	// @SuppressWarnings("static-access")
	public void searchQuoteButtonClicked() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.searchQuoteButton);
			action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.searchQuoteButton, "searchQuoteButton");

			List<WebElement> e = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.searchQuoteButton));
			for (int i = 0; i <= 14; i++) {
				if (i == 2) {
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

	/**
	 * This method is for verifying searchedQuotePresent.
	 * 
	 * @throws Throwable
	 */
	public void searchedQuotePresent() throws Exception {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.searchedQuote);
			action.checkElementClickable(driver, ePricerUpdateAQuotePageObjects.searchedQuote,
					"searchedQuote is displayed.");

			Extent_Reporting.Log_report_img("searchedQuote is displayed.", "searchedQuote is displayed.", driver, test);
			Extent_Reporting.Log_Pass("searchedQuote is displayed.", "searchedQuote is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("searchedQuote is not displayed.", "searchedQuote is not displayed.", driver,
					test);
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for overviewPolygonClick
	 * 
	 * @throws Throwable
	 */
	public void overviewPolygonClick() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			Thread.sleep(15000);
			action.waitForElementClickable(driver, ePricerUpdateAQuotePageObjects.overviewPolygon);
			action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.overviewPolygon, "overviewPolygon");

			if (action.checkElementClickableFluent(driver, ePricerUpdateAQuotePageObjects.overviewPolygon,
					"overviewPolygon")) {
				action.Clickbtn(driver, ePricerUpdateAQuotePageObjects.overviewPolygon, "overviewPolygon");
				Extent_Reporting.Log_report_img("overviewPolygon clicked.", "overviewPolygon clicked.", driver, test);
				Extent_Reporting.Log_Pass("overviewPolygon clicked.", "overviewPolygon clicked.", test);
				// action.Javascriptexecutor_forClick(driver,
				// ePricerUpdateAQuotePageObjects.overviewPolygon, "overviewPolygon");
			} else {
				Extent_Reporting.Log_Fail("overviewPolygon not present in 1 minute.",
						"overviewPolygon not present in 1 minute.", driver, test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("overviewPolygon not clicked.", "overviewPolygon not clicked.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for searchCriteriaQuoteIdSelect
	 * 
	 * @throws Throwable
	 */
	public void selectBidTypeUpdate() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.selectBidType);
			action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.selectBidType, "select BidType ");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerUpdateAQuotePageObjects.selectBidType,
					Excel_Handling.Get_Data(TC_ID, "SelectBidType"), "BidType Selected");
			Thread.sleep(2000);

			Extent_Reporting.Log_report_img("BidType Selected", "BidType Selected", driver, test);
			Extent_Reporting.Log_Pass("BidType Selected", "BidType Selected", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("BidType not Selected", "BidType not Selected", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for dataForEPricerOverviewScreenUpdated
	 * 
	 * @throws Throwable
	 */
	public void dataForEPricerOverviewScreenUpdated() throws Throwable {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);

			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.saveOverviewButton);
			action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.saveOverviewButton, "saveOverviewButton");

			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.saveOverviewButton,
					"saveOverviewButton");

			Extent_Reporting.Log_report_img("save and Continue button clicked.", "save and Continue button clicked.",
					driver, test);
			Extent_Reporting.Log_Pass("save and Continue button clicked.", "save and Continue button clicked.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("save and Continue button not clicked.", "save and Continue button not clicked.",
					driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for uploadCFR
	 * 
	 * @throws Throwable
	 */
	public void uploadCFR() throws Throwable {
		uploadCFR(null);

	}

	/**
	 * This method is for uploadCFR
	 * 
	 * @throws Throwable
	 */
	public void uploadCFR(String compType) throws Throwable {
		try {
			File cfr = null;
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ClassLoader classLoader = getClass().getClassLoader();

			if (compType == "TSSComp") {
				cfr = new File(classLoader.getResource("8335GTG_New_France_2.cfr").getFile());
			} else {
				cfr = new File(classLoader.getResource("Aegon_GB_VEBsnH6064_FC4016nFC4017mes_24aug15.cfr").getFile());
			}
			driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.uploadFileBtn)).sendKeys(cfr.getAbsolutePath());

			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.disableChecksumChkbox,
					"disableChecksumChkbox");
			Thread.sleep(2000);
			action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.workWithOtherCountryCFRChkbox,
					"workWithOtherCountryCFRChkbox");
			Thread.sleep(5000);
			if (action.CheckifExist(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn)) {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtn, "uploadCFRBtn");
			} else {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.uploadCFRBtnDEV, "uploadCFRBtnDEV");
			}
			Extent_Reporting.Log_report_img("uploadCFR Successfully done.", "uploadCFR Successfully done.", driver,test);
			Extent_Reporting.Log_Pass("uploadCFR Successfully done.", "uploadCFR Successfully done.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("CFR Upload Failed.", "CFR Upload Failed.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for verifying DownloadThisCFRIcon.
	 * 
	 * @throws Throwable
	 */
	public boolean downloadThisCFRIcon() throws Exception {
		try {
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.downloadThisCFRIcon);
			if (action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.downloadThisCFRIcon,
					"downloadThisCFRIcon is displayed.")) {
				Extent_Reporting.Log_report_img("downloadThisCFRIcon is displayed.",
						"downloadThisCFRIcon is displayed.", driver, test);
				Extent_Reporting.Log_Pass("downloadThisCFRIcon is displayed.", "downloadThisCFRIcon is displayed.",
						test);
				return true;
			} else {
				Extent_Reporting.Log_Fail("downloadThisCFRIcon is not displayed.",
						"downloadThisCFRIcon is not displayed.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("downloadThisCFRIcon is not displayed.", "downloadThisCFRIcon is not displayed.",
					driver, test);
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	@SuppressWarnings("static-access")
	public void openIBMGUI() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			Thread.sleep(60000);
			action.waitForPageToLoad(driver);

			action.handleAlert(driver);

			// before clicking on the link
			String parent = driver.getWindowHandle();

			WebDriver driver = new FirefoxDriver();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Runtime.getRuntime().exec(authenticationIBMGUIPath);

			driver.get(Excel_Handling.Get_Data(TC_ID, "iBMGuiUrl"));

			// after clicking on the link
			Thread.sleep(2000);
			Set<String> availableWindows = driver.getWindowHandles();
			String newWindow = null;
			for (String window : availableWindows) {
				if (!parent.equals(window)) {
					newWindow = window;
				}
			}

			assertNotNull(newWindow);

			// switch to new window
			driver.switchTo().window(newWindow);

			// iBMGuiScreen();
			if (action.isElementDisplayed(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.iBMGuiScreen,
					"iBMGuiScreen is displayed.")) {
				Extent_Reporting.Log_report_img("iBMGuiScreen is displayed", "iBMGuiScreen is displayed.", driver,
						test);
				Extent_Reporting.Log_Pass("iBMGuiScreen is displayed.", "iBMGuiScreen is displayed.", test);
			} else {
				Extent_Reporting.Log_Fail("iBMGuiScreen is not displayed.", "iBMGuiScreen is not displayed.", driver,
						test);
				driver.quit();
				throw new Exception("Failed");
			}

			if (action.checkElementClickableFluent(driver, ePricerLoginPageObjects.selectARoleDD, "select A Role DD")) {
				action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerLoginPageObjects.selectARoleDD,
						Excel_Handling.Get_Data(TC_ID, "SelectADistributorRole"), "select A Role DD");
				Thread.sleep(2000);
				Extent_Reporting.Log_report_img("selectARoleDD selected", "selectARoleDD selected", driver, test);
				Extent_Reporting.Log_Pass("selectARoleDD selected", "selectARoleDD selected", test);
			} else {
				Extent_Reporting.Log_Fail("selectARoleDD not selected", "selectARoleDD not selected", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			if (action.checkElementClickableFluent(driver, ePricerLoginPageObjects.startButton,
					"startButton is displayed.")) {
				action.Javascriptexecutor_forClick(driver, ePricerLoginPageObjects.startButton, "startButton");
				Thread.sleep(4000);
				Extent_Reporting.Log_report_img("startButton clicked.", "startButton clicked.", driver, test);
				Extent_Reporting.Log_Pass("startButton is displayed", "startButton is displayed", test);
			} else {
				Extent_Reporting.Log_Fail("startButton is not displayed", "startButton is not displayed", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

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
				driver.quit();
				throw new Exception("Failed");
			}

			if (action.checkElementClickableFluent(driver, ePricerUpdateAQuotePageObjects.searchQuotesIBMGUIScreen,
					"searchQuotesIBMGUIScreen")) {
				Extent_Reporting.Log_report_img("searchQuotesScreen is displayed", "searchQuotesScreen is displayed.",
						driver, test);
				Extent_Reporting.Log_Pass("searchQuotesScreen is displayed", "searchQuotesScreen is displayed", test);
			} else {
				Extent_Reporting.Log_Fail("searchQuotesIBMGUIScreen is not displayed.",
						"searchQuotesIBMGUIScreen is not displayed.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			action.waitForPageToLoad(driver);
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
				driver.quit();
				throw new Exception("Failed");
			}

			if (action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.enterQuoteid, "enterQuoteid")) {
				driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).click();
				if (ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteId != null) {
					driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid))
							.sendKeys(ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteId);
					Extent_Reporting.Log_report_img("Quoteid is entered.", "Quoteid is entered.", driver, test);
					Extent_Reporting.Log_Pass("Quoteid is entered.", "Quoteid is entered.", test);
				} else {
					Extent_Reporting.Log_Fail("duplicateQuoteId is not present.", "duplicateQuoteId is not present.",
							driver, test);
					driver.quit();
					throw new Exception("Failed");
				}
			} else {
				Extent_Reporting.Log_Fail("Quoteid not entered.", "Quoteid not entered.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			List<WebElement> e = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.searchQuoteButton));
			if (e != null) {
				for (int i = 0; i <= 14; i++) {
					if (i == 3) {
						e.get(i).click();
						Extent_Reporting.Log_report_img("searchQuoteButton clicked", "searchQuoteButton clicked",
								driver, test);
						Extent_Reporting.Log_Pass("searchQuoteButton is displayed", "searchQuoteButton is displayed",
								test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Fail("searchQuoteButton is not displayed", "searchQuoteButton is not displayed",
						driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			if (action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.searchQuoteResultScreen,
					"searchQuoteResultScreen is displayed.")) {
				Extent_Reporting.Log_report_img("searchQuoteResultScreen displayed",
						"searchQuoteResultScreen displayed", driver, test);
				Extent_Reporting.Log_Pass("searchQuoteResultScreen is displayed",
						"searchQuoteResultScreen is displayed", test);
			} else {
				Extent_Reporting.Log_Fail("searchQuoteResultScreen is not displayed",
						"searchQuoteResultScreen is not displayed", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			if (action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.pricesOnPricing,
					"pricesOnPricing is displayed.")) {
				action.Javascriptexecutor_forClick(driver, ePricerUpdateAQuotePageObjects.pricesOnPricing, "Prices");
				Extent_Reporting.Log_report_img("pricesOnPricing Clicked", "pricesOnPricing Clicked", driver, test);
				Extent_Reporting.Log_Pass("pricesOnPricing is Clicked", "pricesOnPricing is Clicked", test);
			} else {
				Extent_Reporting.Log_Fail("pricesOnPricing not Clicked", "pricesOnPricing not Clicked", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			action.waitForPageToLoad(driver);
			if (action.isElementDisplayed(driver,
					ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.showMarginCalculationLink,
					"showMarginCalculationLink")) {
				action.Javascriptexecutor_forClick(driver,
						ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.showMarginCalculationLink,
						"showMarginCalculationLink");
				Extent_Reporting.Log_report_img("showMarginCalculationLink displayed",
						"showMarginCalculationLink displayed", driver, test);
				Extent_Reporting.Log_Pass("showMarginCalculationLink is displayed",
						"showMarginCalculationLink is displayed", test);
			} else {
				Extent_Reporting.Log_Fail("showMarginCalculationLink is not displayed",
						"showMarginCalculationLink is not displayed", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}

			driver.close();

			Extent_Reporting.Log_Pass("iBMGui closed", "iBMGui closed", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMGui not get Opened", "iBMGui not get Opened", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

}
