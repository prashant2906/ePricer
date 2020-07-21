package com.ibm.stax.BusinessLogic.PCS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ibm.stax.PageObjects.Epricer_Application_Login_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

import ch.ethz.ssh2.crypto.Base64;

public class Epricer_Application_PCS_Login_BusinessLogic {

	private ElementAction action = new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;
	private Epricer_Application_Login_PageObjects ePricerLoginPageObjects = null;

	public Epricer_Application_PCS_Login_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for verifying ePricer Login screen
	 * 
	 * @throws Throwable
	 */
	public boolean ePricerLoginscreen() throws Throwable {

		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.waitForElementVisible(driver,ePricerLoginPageObjects.selectARoleDD);
			action.selectDropBoxByVisibleText(driver, ePricerLoginPageObjects.selectARoleDD, Excel_Handling.Get_Data(TC_ID, "SelectARole"), "select A Role DD");
			
			Extent_Reporting.Log_Pass("selectARoleDD selected.", "selectARoleDD selected.", test);
			Extent_Reporting.Log_report_img("selectARoleDD selected", "selectARoleDD selected", driver, test);
			Thread.sleep(6000);
			action.waitForElementClickable(driver, ePricerLoginPageObjects.startButton);
			action.clickButton(driver, ePricerLoginPageObjects.startButton, "startButton");
			Thread.sleep(4000);
			Extent_Reporting.Log_Pass("start button clicked.", "start button clicked.", test);
			Extent_Reporting.Log_report_img("ePricer Login screen", "ePricer Login screen", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("start button not clicked.", "start button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		return true;
	}

	/**
	 * This method is for verifying ePricer Login screen
	 * 
	 * @throws Throwable
	 */
	public boolean ePricerLoginscreen(String Role, String Env) throws Throwable {

		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.selectARoleDD);
			if (Env.contentEquals("PROD")) {
				Thread.sleep(10000);
				action.selectDropBoxByVisibleText(driver, ePricerLoginPageObjects.selectARoleDD,Excel_Handling.Get_Data(TC_ID, Role), "select Prod Role DD");
			} else {
				action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerLoginPageObjects.selectARoleDD,
						Excel_Handling.Get_Data(TC_ID, Role), "select A Role DD");
			}
			Thread.sleep(10000);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.startButton);
			action.Javascriptexecutor_forClick(driver, ePricerLoginPageObjects.startButton, "startButton");
			Thread.sleep(4000);
			Extent_Reporting.Log_Pass("start button clicked.", "start button clicked.",test);
			Extent_Reporting.Log_report_img("ePricer Login screen", "ePricer Login screen", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("start button not clicked.", "start button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		return true;
	}

	/**
	 * This method is for verifying ePRICERMainScreen.
	 * 
	 * @throws Throwable
	 */
	public void ePRICERMainScreen() throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.dashboardLink);
			action.isElementDisplayed(driver, ePricerLoginPageObjects.dashboardLink, "dashboardLink is displayed.");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("dashboardLink is displayed.", "dashboardLink is displayed.", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("dashboardLink is not displayed.", "dashboardLink is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for login into EPRICER application.
	 * 
	 * @throws Throwable
	 */
	public void loginEpricer() throws Exception

	{
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			Thread.sleep(3000);
			// click on IBM PartnerCommerce / Servers radiobutton
			// driver.findElement(By.xpath("/html/body/form/div[4]/div/div/div[2]/input")).click();

			driver.findElement(By.xpath("//input[@id='ctl00_MainContent_buttonPSATLogin']")).click();
			action.inputText(driver, ePricerLoginPageObjects.userName, Excel_Handling.Get_Data(TC_ID, "userName"),
					"UserName");
			action.inputText(driver, ePricerLoginPageObjects.password, Excel_Handling.Get_Data(TC_ID, "password"),
					"Password");
			Extent_Reporting.Log_report_img("UserName and Password entered.", "UserName and Password entered.", driver, test);
			action.mouseHoverAction(driver, ePricerLoginPageObjects.loginButton, "login Button");
			action.waitForPageToLoad(driver);

			boolean flag = action.isElementDisplayed(driver, ePricerLoginPageObjects.ePricerGoTab, "ePricerGoTab");

			action.waitForPageToLoad(driver);

			if (flag) {
				Extent_Reporting.Log_report_img("IBM Pre-Sales Advisor page", "IBM Pre-Sales Advisor page", driver, test);
				Extent_Reporting.Log_Pass("Login Successful", "Login Successful", test);
			} else {
				Extent_Reporting.Log_Fail("Login Failed", "Login Failed", driver, test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Login Failed", "Login Failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for clicking ePricerGoTab.
	 * 
	 * @throws Throwable
	 */
	public void ePricerGoTabClick() throws Exception {
		ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
		action.waitForElementVisible(driver, ePricerLoginPageObjects.ePricerGoTab);
		try {
			Extent_Reporting.Log_report_img("Clicking on ePricerGoTab ", "Clicking on ePricerGoTab", driver, test);
			action.Javascriptexecutor_forClick(driver, ePricerLoginPageObjects.ePricerGoTab, "ePricerGo Tab");

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("ePricerGoTab not clicked.", "ePricerGoTab not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying ePricerGoTestScreen.
	 * 
	 * @throws Throwable
	 */
	public void ePricerGoTestScreen() throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.ePricerGoTestScreen);
			action.isElementDisplayed(driver, ePricerLoginPageObjects.ePricerGoTestScreen,
					"ePricerGoTestScreen is displayed.");
			Extent_Reporting.Log_report_img("ePricerGoTestScreen is displayed.", "ePricerGoTestScreen is displayed.",
					driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("ePricerGoTestScreen is not displayed.", "ePricerGoTestScreen is not displayed.",
					driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for clicking selectButtonClick.
	 * 
	 * @throws Throwable
	 */
	public void selectButtonClick() throws Exception {
		ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
		action.waitForElementVisible(driver, ePricerLoginPageObjects.selectButton);
		try {
			action.Javascriptexecutor_forClick(driver, ePricerLoginPageObjects.selectButton, "select Button click");
			Extent_Reporting.Log_report_img("Clicking on selectButton ", "Clicking on selectButton", driver, test);
			Extent_Reporting.Log_Pass("selectButton clicked.", "selectButton clicked.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("selectButton not clicked.", "selectButton not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for dataForEPricerGoTestScreen
	 * 
	 * @throws Throwable
	 */
	public void dataForEPricerGoTestScreen() throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.inputText(driver, ePricerLoginPageObjects.contactPhone,
					Excel_Handling.Get_Data(TC_ID, "ContactPhone"), "ContactPhone");
			action.inputText(driver, ePricerLoginPageObjects.contactEmail,
					Excel_Handling.Get_Data(TC_ID, "ContactEmail"), "ContactEmail");
			action.inputText(driver, ePricerLoginPageObjects.iBMUniqueID, Excel_Handling.Get_Data(TC_ID, "IBMUniqueID"),
					"IBMUniqueID");

			Extent_Reporting.Log_report_img("ContactPhone , ContactEmail and iBMUniqueID entered.",
					"ContactPhone , ContactEmail and iBMUniqueID entered.", driver, test);
			Extent_Reporting.Log_Pass("ContactPhone , ContactEmail and iBMUniqueID entered.",
					"ContactPhone , ContactEmail and iBMUniqueID entered.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("ContactPhone , ContactEmail and iBMUniqueID not entered.",
					"ContactPhone , ContactEmail and iBMUniqueID not entered.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for clicking generateXMLButtonClick.
	 * 
	 * @throws Throwable
	 */
	public void generateXMLButtonClick() throws Exception {
		ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
		action.waitForElementVisible(driver, ePricerLoginPageObjects.generateXMLButton);
		try {
			action.Javascriptexecutor_forClick(driver, ePricerLoginPageObjects.generateXMLButton,
					"generateXML Button click");
			Extent_Reporting.Log_report_img("Clicking on generateXMLButton ", "Clicking on generateXMLButton", driver, test);
			Extent_Reporting.Log_Pass("generateXMLButton clicked.", "generateXMLButton clicked.", test);

			if (ePricerLoginPageObjects.XmlCheck != null) {
				Extent_Reporting.Log_report_img("Xml Generated successfully.", "Xml Generated successfully.", driver, test);
				Extent_Reporting.Log_Pass("Xml Generated successfully.", "Xml Generated successfully.", test);
			} else {
				Extent_Reporting.Log_Fail("Xml not Generated", "Xml not Generated", driver, test);
				driver.quit();
			}

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("generateXMLButton not clicked.", "generateXMLButton not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for clicking sendXMLButtonClick.
	 * 
	 * @throws Throwable
	 */
	public void sendXMLButtonClick() throws Exception {
		ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
		action.waitForElementVisible(driver, ePricerLoginPageObjects.sendXMLButton);
		try {
			action.Javascriptexecutor_forClick(driver, ePricerLoginPageObjects.sendXMLButton, "sendXML Button click");
			Extent_Reporting.Log_report_img("Clicking on sendXMLButton ", "Clicking on sendXMLButton", driver, test);
			Extent_Reporting.Log_Pass("sendXMLButton clicked.", "sendXMLButton clicked.", test);

		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("sendXMLButton not clicked.", "sendXMLButton not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for verifying epricerLogoScreen.
	 * 
	 * @throws Throwable
	 */
	public void epricerLogoScreen() throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.homePage);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.epricerLogoScreen);
			action.isElementDisplayed(driver, ePricerLoginPageObjects.homePage, "ePricer homePage is displayed.");
			action.isElementDisplayed(driver, ePricerLoginPageObjects.epricerLogoScreen,
					"epricerLogoScreen is displayed.");
			Extent_Reporting.Log_report_img("ePricer homePage and epricerLogoScreen is displayed.",
					"ePricer homePage and epricerLogoScreen is displayed.", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("ePricer homePage and epricerLogoScreen is not displayed.",
					"ePricer homePage and epricerLogoScreen is not displayed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is to navigate to PCS.
	 * 
	 * @throws Throwable
	 */

	public void epricerNavigatetoPCS(String PCSURL) throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			System.out.println("Navigate to the URL " + PCSURL);
			driver.get(PCSURL);
			Thread.sleep(5000);
			Extent_Reporting.Log_Pass("ePricer homePage and epricerLogoScreen is displayed.",
					"ePricer homePage and epricerLogoScreen is displayed.",test);
			Extent_Reporting.Log_report_img("ePricer homePage and epricerLogoScreen is displayed.",
					"ePricer homePage and epricerLogoScreen is displayed.", driver, test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("ePricer homePage and epricerLogoScreen is not displayed.",
					"ePricer homePage and epricerLogoScreen is not displayed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is to navigate to IBM GUI.
	 * 
	 * @throws Throwable
	 */
	public void epricerNavigatetoIBM(String IBMURL) throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			// System.out.println("IBM URL " + Excel_Handling.Get_Data(TC_ID, "iBMGuiUrl"));
			// System.out.println("Navigate to the URL " + IBMURL);
			driver.get(IBMURL);
			Extent_Reporting.Log_Pass("Navigation IBM GUI passed.", "Navigation IBM GUI passed.",test);
			Extent_Reporting.Log_report_img("Navigation IBM GUI", "Navigation IBM GUI.", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Navigation IBM GUI failed.", "Navigation IBM GUI failed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}
	
	public void epricerNavigatetoIBMWithSecondUser(String IBMURL, String ENV) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			//action.handleAlert(driver);
				if (ENV.equalsIgnoreCase("PROD")) {
					String passwordString = Excel_Handling.GetSecureData(1, 1, 0,ENV);
					char[] encypwdString = passwordString.toCharArray();
					byte[] actualpwdByte= Base64.decode(encypwdString);
					String actualpwdString= new String(actualpwdByte);
					//System.out.println("https://"+Excel_Handling.GetSecureData(2, 0,0,ENV)+":"+actualpwdString+"@"+iBMURL);
					driver.get("https://"+Excel_Handling.GetSecureData(1, 0,0,ENV)+":"+actualpwdString+"@"+IBMURL);
				} else {
					String passwordString = Excel_Handling.GetSecureData(1, 1, 0,ENV);
					char[] encypwdString = passwordString.toCharArray();
					byte[] actualpwdByte= Base64.decode(encypwdString);
					String actualpwdString= new String(actualpwdByte);
					//System.out.println("https://"+Excel_Handling.GetSecureData(1, 0,0, ENV)+":"+actualpwdString+"@"+IBMURL);
					driver.get("https://"+Excel_Handling.GetSecureData(2, 0,0,ENV)+":"+actualpwdString+"@"+IBMURL);
				}
				Thread.sleep(4000);
				if (action.isAlertPresent(driver)) {
					action.acceptAlert(driver);
				}
				Thread.sleep(8000);
				Extent_Reporting.Log_Pass("IBMid continue button clicked.", "IBMid continue button clicked.", test);

			} catch (Exception e) {
				Extent_Reporting.Log_Fail("IBMid continue button not clicked.", "IBMid continue button not clicked.",driver, test);
				driver.quit();
				e.printStackTrace();
				throw new Exception("Failed");
			}
	}
	
	

	/**
	 * Neha Upadhyay: This method is for IBM ID page login
	 * @param eNV 
	 * 
	 * @throws Throwable
	 */
	public void ibmIDPageData(String eNV) throws Throwable {
		try {
		ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
		if (eNV.equalsIgnoreCase("IVT"))  {
			Thread.sleep(5000);
			action.inputText(driver, ePricerLoginPageObjects.iBMidUserName,Excel_Handling.GetSecureData(1, 0,1,eNV), "UserName");
			action.clickButton(driver, ePricerLoginPageObjects.PCSContinuebutton1, "click on continue");
			Thread.sleep(5000);
			String userNameString = ".//*[@name='username']";
			action.inputText(driver,userNameString ,Excel_Handling.GetSecureData(1,0,1,eNV), "UserName");
			String pwdString = ".//*[@name='password']";
			action.waitForElementVisible(driver, ePricerLoginPageObjects.iBMidPwd);
			action.inputTextForPassword(driver, pwdString,Excel_Handling.GetSecureData(1, 1, 1,eNV), "Password");
			Thread.sleep(4000);
			action.waitForElementClickable(driver, "//button[@type='submit']");
			action.Javascriptexecutor_forClick(driver, "//button[@type='submit']", "submit");
			Thread.sleep(4000);
			
		}else if (eNV.equalsIgnoreCase("Prod")) {
			Thread.sleep(5000);
			action.inputText(driver, ePricerLoginPageObjects.iBMidUserName,Excel_Handling.GetSecureData(1, 0,0,eNV), "UserName");
			action.clickButton(driver, ePricerLoginPageObjects.PCSContinuebutton1, "click on continue");
			Thread.sleep(5000);
			String userNameString = ".//*[@name='username']";
			action.inputText(driver,userNameString ,Excel_Handling.GetSecureData(1, 0,0,eNV), "UserName");
			String pwdString = ".//*[@name='password']";
			action.waitForElementVisible(driver, ePricerLoginPageObjects.iBMidPwd);
			action.inputTextForPassword(driver, pwdString,Excel_Handling.GetSecureData(1, 1,0,eNV), "Password");
			Thread.sleep(4000);
			action.waitForElementClickable(driver, "//button[@type='submit']");
			action.Javascriptexecutor_forClick(driver, "//button[@type='submit']", "submit");
			Thread.sleep(4000);
		}
		else {
			Thread.sleep(4000);
			boolean display = action.isElementDisplay(driver, ePricerLoginPageObjects.iBMidUserName);
			//System.out.println("ibmid displayed " + display);
			
				if (display) {
					Thread.sleep(5000);
					action.inputText(driver, ePricerLoginPageObjects.iBMidUserName,Excel_Handling.GetSecureData(1, 0,0,eNV), "UserName");
					boolean display1 = action.isElementDisplay(driver, ePricerLoginPageObjects.PCSContinuebutton1);
					if (display1) {
						action.clickButton(driver, ePricerLoginPageObjects.PCSContinuebutton1, "click on continue");
						Thread.sleep(5000);
					}
					action.waitForElementVisible(driver, ePricerLoginPageObjects.iBMidPwd);
					action.inputTextForPassword(driver, ePricerLoginPageObjects.iBMidPwd,Excel_Handling.GetSecureData(1, 1,0,eNV), "Password");
					Thread.sleep(4000);
					if (action.CheckifExist(driver, "//button[@type='submit']")) {
						action.Javascriptexecutor_forClick(driver, "//button[@type='submit']", "submit");
						Thread.sleep(4000);
					}					
		}
			}
				Extent_Reporting.Log_Pass("IBMid continue button clicked.", "IBMid continue button clicked.",test);
		
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("IBMid continue button not clicked.", "IBMid continue button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Neha Upadhyay: This method is for ePricerLoginWithDistributorProfile
	 * 
	 * @throws Throwable
	 */
	public boolean ePricerLoginWithDistributorProfile() throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerLoginPageObjects.selectARoleDD);
			action.isElementDisplayed(driver, ePricerLoginPageObjects.selectARoleDD, "select A Role DD");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerLoginPageObjects.selectARoleDD,
					Excel_Handling.Get_Data(TC_ID, "SelectADistributorRole"), "select A Role DD");
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("selectARoleDD selected", "selectARoleDD selected", driver, test);
			action.waitForElementClickable(driver, ePricerLoginPageObjects.startButton);
			action.Clickbtn(driver, ePricerLoginPageObjects.startButton, "startButton");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("ePricer Login screen", "ePricer Login screen", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("start button not clicked.", "start button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		return true;
	}

	/**
	 * Jacob: This method is for PCS log in
	 * 
	 * @throws Throwable
	 */
	public boolean pcsloggin() throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.SelectedCountryforPCS);
			// action.isElementDisplayed(driver,ePricerLoginPageObjects.SelectedCountryforPCS,
			// "PCS country select dropdown list");
			Thread.sleep(5000);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerLoginPageObjects.SelectedCountryforPCS,
					"United States - English", "PCS country select dropdown list");

			Thread.sleep(8000);
			Extent_Reporting.Log_Pass("PCS country select dropdown list clicked.", "PC Scountry select dropdown list clicked.",test);
			Extent_Reporting.Log_report_img("PCS country select dropdown list", "PCS country select dropdown list",
					driver, test);

			action.Clickbtn(driver, ePricerLoginPageObjects.PCSContinuebutton, "PCSContinuebutton");
			Thread.sleep(9000);
			Extent_Reporting.Log_Pass("PCSContinuebutton button clicked.", "PCSContinuebutton button clicked.",test);
			Extent_Reporting.Log_report_img("PCS Login screen", "PCS Login screen", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCSContinuebutton button not clicked.", "PCSContinuebutton button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		return true;
	}

	/**
	 * Jacob: This method is for PCS log in
	 * 
	 * @throws Throwable
	 */
	public boolean pcsENVSelect(String ENV) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			if (ENV.equalsIgnoreCase("MAINT")) {
				// action.waitForElementVisible(driver, ePricerLoginPageObjects.MaintLink);
				Thread.sleep(20000);
				// action.clickLink(driver, ePricerLoginPageObjects.MaintLink, "Maint link");
				if (action.CheckifExist(driver, ePricerLoginPageObjects.MaintLink)) {
					Thread.sleep(10000);
					action.clickLink(driver, ePricerLoginPageObjects.MaintLink, "Maint link");
				} else {
					driver.navigate().refresh();
					action.handleAlert(driver);
					Thread.sleep(12000);
					action.clickLink(driver, ePricerLoginPageObjects.MaintLink, "Maint link");
				}

			}
			if (ENV.equalsIgnoreCase("DEV")) {
				Thread.sleep(9000);
				action.waitForElementVisible(driver, ePricerLoginPageObjects.DevLink);
				action.clickLink(driver, ePricerLoginPageObjects.DevLink, "Dev link");
				// action.clickLinkByLinkText(driver, "ePricer CDT DEV", "DEV link");
			}
			if (ENV.equalsIgnoreCase("PROD"))  {
				Thread.sleep(7000);
				action.waitForElementVisible(driver, ePricerLoginPageObjects.PRODLink);
				action.clickLink(driver, ePricerLoginPageObjects.PRODLink, "PROD link");
			}
			if (ENV.equalsIgnoreCase("IVT"))  {
				Thread.sleep(7000);
				action.waitForElementVisible(driver, ePricerLoginPageObjects.IVTLink);
				action.clickLink(driver, ePricerLoginPageObjects.IVTLink, "IVT link");
			}

			Thread.sleep(2000);
			Extent_Reporting.Log_Pass("PCS env selected", "PCS env selected", test);			
			Extent_Reporting.Log_report_img("PCS env select", "PCS env select", driver, test);

			Thread.sleep(4000);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCS env not selected", "PCS env not selected", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		return true;
	}

	public boolean select_role_ibm_gui() throws Throwable {

		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerLoginPageObjects.selectARoleDD);
			
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerLoginPageObjects.selectARoleDD,
					Excel_Handling.Get_Data(TC_ID, "SelectADistributorRole"), "select A Role DD");

			Extent_Reporting.Log_report_img("selectARoleDD selected", "selectARoleDD selected", driver, test);
			Thread.sleep(6000);
			action.waitForElementClickable(driver, ePricerLoginPageObjects.startButton);
			action.Clickbtn(driver, ePricerLoginPageObjects.startButton, "startButton");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("ePricer Login screen", "ePricer Login screen", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("start button not clicked.", "start button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		return true;
	}

	public boolean pcsENVSelect_devlink() throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.DevLink);

			action.clickLink(driver, ePricerLoginPageObjects.DevLink, "Dev link");
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("PCS env select", "PCS env select", driver, test);
			Thread.sleep(4000);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCS env not selected", "PCS env not selected", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		return true;
	}

	/**
	 * Author Jaocb This method is to launch group
	 * 
	 * @throws Exception
	 * 
	 * @throws Throwable
	 */
	public void LaunchGroupLegal(String Groupname) throws Exception {
		try {
			for (int i = 0; i < 10; i++) {
				boolean display = action.CheckifExist(driver, ePricerLoginPageObjects.PSATGroup);

				System.out.println("i = " + i);
				System.out.println("Display = " + display);

				if (display) {
					break;
				} else {
					Thread.sleep(60000);
				}
				if (i == 9) {
				}
			}
			action.selectDropBoxByVisibleText(driver, ePricerLoginPageObjects.PSATGroup, Groupname, "select Group");
			action.clickButton(driver, ePricerLoginPageObjects.PSATGrouplaunchbutton, "click the button launch");
			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("PSAT group launch", "PSAT group launch", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PSAT group launch failed", "PSAT group launch failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * Jacob: This method is for PCS sign out
	 * 
	 * @throws Throwable
	 */
	public void pcsSignout() throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.clickButton(driver, ePricerLoginPageObjects.PCSSignout, "click sign out");
			Thread.sleep(20000);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("pcsSignout failed", "pcsSignout failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Author Jaocb This method is to login with IBMID
	 * 
	 * @throws Exception
	 * 
	 * @throws Throwable
	 */
	// public void PSATIBMID(String Username,String pwd, String user) throws
	// Exception {
	public void PSATIBMID(String user) throws Exception {
		try {
			Thread.sleep(15000);
			boolean display = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDname);
			System.out.println(display);
			if (display) {
				Thread.sleep(5000);
				action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDname,
						Excel_Handling.Get_Data(TC_ID, "IBMIDName" + user), "IBMID name");
				// System.out.println("User name is " + Excel_Handling.Get_Data(TC_ID,
				// "IBMIDName"));
				Thread.sleep(5000);
				boolean display1 = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton);
				if (display1) {
					action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton,
							"click continue button");
				}
				Thread.sleep(5000);
				action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDpassword,
						Excel_Handling.Get_Data(TC_ID, "IBMIDPassword" + user), "IBMID name");
				// System.out.println("Password is " + Excel_Handling.Get_Data(TC_ID,
				// "IBMIDPassword"));
				Thread.sleep(5000);
				action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDsigninbutton, "click signin button");
			} else {
				Thread.sleep(30000);
				boolean display2 = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDname);
				if (display2) {

					Thread.sleep(5000);
					action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDname,
							Excel_Handling.Get_Data(TC_ID, "IBMIDName" + user), "IBMID name");
					// System.out.println("User name is " + Excel_Handling.Get_Data(TC_ID,
					// "IBMIDName"));
					Thread.sleep(5000);
					boolean display1 = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton);
					if (display1) {
						action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton,
								"click continue button");
					}
					Thread.sleep(5000);
					action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDpassword,
							Excel_Handling.Get_Data(TC_ID, "IBMIDPassword" + user), "IBMID name");
					// System.out.println("Password is " + Excel_Handling.Get_Data(TC_ID,
					// "IBMIDPassword"));
					Thread.sleep(5000);
					action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDsigninbutton, "click signin button");

				}
			}
			Extent_Reporting.Log_report_img("mySA Login completed.", "mySA Login completed.", driver, test);
		}

		catch (Exception e) {
			Extent_Reporting.Log_Fail("mySA Login not completed.", "mySA Login not completed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * Author Jaocb This method is to login with IBMID
	 * 
	 * @throws Exception
	 * 
	 * @throws Throwable
	 */
	// public void PSATIBMID(String Username,String pwd, String user) throws
	// Exception {
	public void PSATIBMID() throws Exception {
		try {
			Thread.sleep(15000);
			boolean display = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDname);
			System.out.println(display);
			if (display) {
				Thread.sleep(5000);
				action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDname,
						Excel_Handling.Get_Data(TC_ID, "IBMIDName"), "IBMID name");
				// System.out.println("User name is " + Excel_Handling.Get_Data(TC_ID,
				// "IBMIDName"));
				Thread.sleep(5000);
				boolean display1 = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton);
				if (display1) {
					action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton,
							"click continue button");
				}
				Thread.sleep(5000);
				action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDpassword,
						Excel_Handling.Get_Data(TC_ID, "IBMIDPassword"), "IBMID name");
				// System.out.println("Password is " + Excel_Handling.Get_Data(TC_ID,
				// "IBMIDPassword"));
				Thread.sleep(5000);
				action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDsigninbutton, "click signin button");
			} else {
				Thread.sleep(30000);
				boolean display2 = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDname);
				if (display2) {

					Thread.sleep(5000);
					action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDname,
							Excel_Handling.Get_Data(TC_ID, "IBMIDName"), "IBMID name");
					// System.out.println("User name is " + Excel_Handling.Get_Data(TC_ID,
					// "IBMIDName"));
					Thread.sleep(5000);
					boolean display1 = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton);
					if (display1) {
						action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton,
								"click continue button");
					}
					Thread.sleep(5000);
					action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDpassword,
							Excel_Handling.Get_Data(TC_ID, "IBMIDPassword"), "IBMID name");
					// System.out.println("Password is " + Excel_Handling.Get_Data(TC_ID,
					// "IBMIDPassword"));
					Thread.sleep(5000);
					action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDsigninbutton, "click signin button");

				}
			}
			Extent_Reporting.Log_report_img("mySA Login completed.", "mySA Login completed.", driver, test);
		}

		catch (Exception e) {
			Extent_Reporting.Log_Fail("mySA Login not completed.", "mySA Login not completed.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * Jacob: This method is for PCS log in
	 * 
	 * @throws Throwable
	 */
	public boolean pcslogginbypass(String user) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			Thread.sleep(10000);

			String textdata = "";
			String Uniqueid = "";
			if (user.equalsIgnoreCase("USER1")) {
				Uniqueid = "2700016FDM";
			} else if (user.equalsIgnoreCase("USER2")) {
				Uniqueid = "2700010465";
			} else {
				Uniqueid = "2700016FDM";
			}

			textdata = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><pcsData xmlns=\"http://w3.ibm.com/xmlns/ibmww/crm/epricer/\"><generalInformation><!--General information.--><Source>P</Source><RequestingApplicationId>PCSNA</RequestingApplicationId><UrlRedirection>https://wwwbeta-2.toronto.ca.ibm.com/partnerworld/commerce/programs/servers/EpricerRedirectionServlet.wss?command=epricerRedirection</UrlRedirection><IbmUniqueId>"
					+ Uniqueid
					+ "</IbmUniqueId><UserPCSProfileId>test_dist_avnet</UserPCSProfileId><WebIdentityUserId>pradeepkumar08@in.ibm.com</WebIdentityUserId><SelectedCountryCode>US</SelectedCountryCode><SecurityCode>UzyAWiMvirdieGZR9DRuK2whmXBJ+fLygsK5foFbMGWvzLkDP/aT/QCWKwP0DCRwT8PsRiG+Mf0=</SecurityCode></generalInformation><tier1><!--Bussiness Partner Tier One.--><Tier1CompanyName>Avnet Hall-Mark</Tier1CompanyName><Tier1CustomerNumber>286381416</Tier1CustomerNumber><Tier1TypeDescription>Distributor</Tier1TypeDescription><Tier1TypeCode>DIS</Tier1TypeCode><Tier1ContactName>Pradeep Kumar</Tier1ContactName><Tier1ContactEmail>pradeepkumar08@in.ibm.com</Tier1ContactEmail><Tier1RequestorPhone>9898989898</Tier1RequestorPhone><Tier1CountryCode>US</Tier1CountryCode><Tier1LanguageCode>en</Tier1LanguageCode></tier1><tier2><!--Bussiness Partner Tier Two.--><Tier2CompanyName /><Tier2CustomerNumber /><Tier2TypeDescription /><Tier2TypeCode /><Tier2ContactEmail /></tier2><ibmChannelContactInformation><!--Channel Contact Information.--><IbmChannelContactName>Pradeep Kumar</IbmChannelContactName><IbmChannelContactEmail>pradeepkumar08@in.ibm.com</IbmChannelContactEmail><IbmChannelContactPhone>9898989898</IbmChannelContactPhone></ibmChannelContactInformation></pcsData>";

			action.waitForElementVisible(driver, ePricerLoginPageObjects.ByPassPCS);
			action.clickButton(driver, ePricerLoginPageObjects.ByPassPCS, "click on radio pcs");
			Thread.sleep(2000);
			action.clickButton(driver, ePricerLoginPageObjects.ByPassPCSdisrole, "click on radio pcs");

			action.clearAndInputTextValue(driver, ePricerLoginPageObjects.ByPassData, textdata, "input text");
			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("PCS input text", "PCS input text", driver, test);

			action.clickButton(driver, ePricerLoginPageObjects.ByPassePricergo, "click on epricer");
			Extent_Reporting.Log_report_img("PCS Login screen", "PCS Login screen", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PCSContinuebutton button not clicked.", "PCSContinuebutton button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		return true;
	}

	public void authenticatePopUpHandle(String iBMURL, String ENV) throws Throwable {
		ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
		try {
			if (ENV.equalsIgnoreCase("PROD")) {
				String passwordString = Excel_Handling.GetSecureData(2, 1, 0,ENV);
				char[] encypwdString = passwordString.toCharArray();
				byte[] actualpwdByte= Base64.decode(encypwdString);
				String actualpwdString= new String(actualpwdByte);
				//System.out.println("https://"+Excel_Handling.GetSecureData(2, 0,0,ENV)+":"+actualpwdString+"@"+iBMURL);
				driver.get("https://"+Excel_Handling.GetSecureData(2, 0,0,ENV)+":"+actualpwdString+"@"+iBMURL);
			} else {
				String passwordString = Excel_Handling.GetSecureData(2, 1, 0,ENV);
				char[] encypwdString = passwordString.toCharArray();
				byte[] actualpwdByte= Base64.decode(encypwdString);
				String actualpwdString= new String(actualpwdByte);
				//System.out.println("https://"+Excel_Handling.GetSecureData(2, 0,0)+":"+actualpwdString+"@"+iBMURL);
				driver.get("https://"+Excel_Handling.GetSecureData(2, 0,0,ENV)+":"+actualpwdString+"@"+iBMURL);
			}
			Thread.sleep(4000);
			if (action.isAlertPresent(driver)) {
				action.acceptAlert(driver);
			}
			Thread.sleep(8000);
			Extent_Reporting.Log_Pass("IBMid continue button clicked.", "IBMid continue button clicked.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("IBMid continue button not clicked.", "IBMid continue button not clicked.",driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	
	}

	public void secondIDPageData(String eNV) throws Throwable {
		try {
		ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
		if (eNV.equalsIgnoreCase("IVT"))  {
			Thread.sleep(5000);
			action.inputText(driver, ePricerLoginPageObjects.iBMidUserName,Excel_Handling.GetSecureData(3, 0,1,eNV), "UserName");
			action.clickButton(driver, ePricerLoginPageObjects.PCSContinuebutton1, "click on continue");
			Thread.sleep(5000);
			String userNameString = ".//*[@name='username']";
			action.inputText(driver,userNameString ,Excel_Handling.GetSecureData(3,0,1,eNV), "UserName");
			String pwdString = ".//*[@name='password']";
			action.waitForElementVisible(driver, ePricerLoginPageObjects.iBMidPwd);
			action.inputTextForPassword(driver, pwdString,Excel_Handling.GetSecureData(3, 1, 1,eNV), "Password");
			Thread.sleep(4000);
			action.waitForElementClickable(driver, "//button[@type='submit']");
			action.Javascriptexecutor_forClick(driver, "//button[@type='submit']", "submit");
			Thread.sleep(4000);
			
		}else if (eNV.equalsIgnoreCase("Prod")) {
			Thread.sleep(5000);
			action.inputText(driver, ePricerLoginPageObjects.iBMidUserName,Excel_Handling.GetSecureData(3, 0,0,eNV), "UserName");
			action.clickButton(driver, ePricerLoginPageObjects.PCSContinuebutton1, "click on continue");
			Thread.sleep(5000);
			String userNameString = ".//*[@name='username']";
			action.inputText(driver,userNameString ,Excel_Handling.GetSecureData(3, 0,0,eNV), "UserName");
			String pwdString = ".//*[@name='password']";
			action.waitForElementVisible(driver, ePricerLoginPageObjects.iBMidPwd);
			action.inputTextForPassword(driver, pwdString,Excel_Handling.GetSecureData(3, 1,0,eNV), "Password");
			Thread.sleep(4000);
			action.waitForElementClickable(driver, "//button[@type='submit']");
			action.Javascriptexecutor_forClick(driver, "//button[@type='submit']", "submit");
			Thread.sleep(4000);
		}
		else {
			Thread.sleep(4000);
			boolean display = action.isElementDisplay(driver, ePricerLoginPageObjects.iBMidUserName);
			//System.out.println("ibmid displayed " + display);
			
				if (display) {
					Thread.sleep(5000);
					action.inputText(driver, ePricerLoginPageObjects.iBMidUserName,Excel_Handling.GetSecureData(3, 0,0,eNV), "UserName");
					boolean display1 = action.isElementDisplay(driver, ePricerLoginPageObjects.PCSContinuebutton1);
					if (display1) {
						action.clickButton(driver, ePricerLoginPageObjects.PCSContinuebutton1, "click on continue");
						Thread.sleep(5000);
					}
					action.waitForElementVisible(driver, ePricerLoginPageObjects.iBMidPwd);
					action.inputTextForPassword(driver, ePricerLoginPageObjects.iBMidPwd,Excel_Handling.GetSecureData(3, 1,0,eNV), "Password");
					Thread.sleep(4000);
					if (action.CheckifExist(driver, "//button[@type='submit']")) {
						action.waitForElementClickable(driver, "//button[@type='submit']");
						action.Javascriptexecutor_forClick(driver, "//button[@type='submit']", "submit");
						Thread.sleep(4000);
					}
		}
			}
				Extent_Reporting.Log_Pass("IBMid continue button clicked.", "IBMid continue button clicked.",test);
		
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("IBMid continue button not clicked.", "IBMid continue button not clicked.",
					driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

}