package com.ibm.stax.BusinessLogic;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.ibm.stax.PageObjects.Epricer_Application_Login_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.ibm.stax.Utilities.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class Epricer_Application_Login_BusinessLogic {

	private ElementAction action = new ElementAction();
	private ExtentTest test;
	private WebDriver driver;
	private String TC_ID;
	private Epricer_Application_Login_PageObjects ePricerLoginPageObjects = null;

	public Epricer_Application_Login_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is for verifying ePricer Login screen
	 * @throws Exception 
	 */
	public boolean ePricerLoginscreen() throws Exception  {

		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			//action.waitForElementVisible(driver, ePricerLoginPageObjects.selectARoleDD);
			Thread.sleep(30000);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerLoginPageObjects.selectARoleDD,
					Excel_Handling.Get_Data(TC_ID, "SelectARole"), "select A Role DD");

			//Extent_Reporting.Log_report_img("selectARoleDD selected", "selectARoleDD selected", driver, test);
			Thread.sleep(6000);
			action.waitForElementClickable(driver, ePricerLoginPageObjects.startButton);
			action.Javascriptexecutor_forClick(driver, ePricerLoginPageObjects.startButton, "startButton");
			Thread.sleep(4000);
			//Extent_Reporting.Log_report_img("ePricer Login screen", "ePricer Login screen", driver, test);
			Extent_Reporting.Log_Pass("ePricer Login screen is displayed.", "ePricer Login screen is displayed.", test);

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
			Thread.sleep(4000);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.dashboardLink);
			action.isElementDisplayed(driver, ePricerLoginPageObjects.dashboardLink, "dashboardLink is displayed.");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("dashboardLink is displayed.", "dashboardLink is displayed.", driver, test);
			Extent_Reporting.Log_Pass("dashboardLink is displayed.", "dashboardLink is displayed.", test);

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
			driver.findElement(By.xpath("/html/body/form/div[4]/div/div/div[2]/input")).click();

			// driver.findElement(By.xpath("//input[@id='ctl00_MainContent_buttonPSATLogin']")).click();
			action.inputText(driver, ePricerLoginPageObjects.userName, Excel_Handling.Get_Data(TC_ID, "userName"),"UserName");
			action.inputTextForPassword(driver, ePricerLoginPageObjects.password,Excel_Handling.Get_Data(TC_ID, "password"), "Password");
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
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.ePricerGoTab);
			if (action.isElementDisplayed(driver, ePricerLoginPageObjects.ePricerGoTab,
					"ePricerGoTestScreen is displayed.")) {
				Extent_Reporting.Log_report_img("Clicking on ePricerGoTab ", "Clicking on ePricerGoTab", driver, test);
				action.Javascriptexecutor_forClick(driver, ePricerLoginPageObjects.ePricerGoTab, "ePricerGo Tab");
			} else {
				Extent_Reporting.Log_Fail("ePricerGoTab not clicked.", "ePricerGoTab not clicked.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			Extent_Reporting.Log_Pass("ePricerGoTabClick is clicked.", "ePricerGoTabClick is clicked.", test);

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
			Extent_Reporting.Log_Pass("ePricerGoTestScreen is displayed.", "ePricerGoTestScreen is displayed.", test);

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
			action.Javascriptexecutor_forClick(driver, ePricerLoginPageObjects.generateXMLButton,"generateXML Button click");
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
			Extent_Reporting.Log_Pass("ePricer homePage and epricerLogoScreen is displayed.",
					"ePricer homePage and epricerLogoScreen is displayed.", test);

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
	 * Neha Upadhyay: This method is for IBM ID page login
	 * 
	 * @throws Throwable
	 */
	public void ibmIDPageData(String env) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			boolean iBMidUserName = action.isElementDisplay(driver, ePricerLoginPageObjects.iBMidUserName);
			if (iBMidUserName) {
				action.inputText(driver, ePricerLoginPageObjects.iBMidUserName,	Excel_Handling.GetSecureData(2, 0,0,env), "UserName");
				action.waitForElementClickable(driver, "//button[@type='submit']");
				action.Javascriptexecutor_forClick(driver, "//button[@type='submit']", "submit");
				action.inputTextForPassword(driver, ePricerLoginPageObjects.iBMidPwd,Excel_Handling.GetSecureData(2, 1,0,env), "Password");
				Thread.sleep(9000);
				action.waitForElementClickable(driver, "//button[@type='submit']");
				action.Javascriptexecutor_forClick(driver, "//button[@type='submit']", "submit");
				Thread.sleep(4000);
			}

			Extent_Reporting.Log_Pass("ibmIDPageData Login screen", "ibmIDPageData Login screen", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("IBMid continue button not clicked.", "IBMid continue button not clicked.",
					driver, test);
			System.out.println(e.getMessage().toString());
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
			action.waitForPageToLoad(driver);
			Extent_Reporting.Log_report_img("ePricer Login screen", "ePricer Login screen", driver, test);
			Extent_Reporting.Log_Pass("ePricer Login screen", "ePricer Login screen", test);

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
			action.isElementDisplayed(driver, ePricerLoginPageObjects.SelectedCountryforPCS,
					"PCS country select dropdown list");

			action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerLoginPageObjects.SelectedCountryforPCS,
					"United States - English", "PCS country select dropdown list");

			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("PCS country select dropdown list", "PCS country select dropdown list",
					driver, test);

			action.Clickbtn(driver, ePricerLoginPageObjects.PCSContinuebutton, "PCSContinuebutton");
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("PCS Login screen", "PCS Login screen", driver, test);
			Extent_Reporting.Log_Pass("PCS Login screen", "PCS Login screen", test);

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
	public boolean pcsENVSelect() throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.MaintLink);

			action.clickLink(driver, ePricerLoginPageObjects.MaintLink, "Maint link");

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
	 * Jacob: This method is for PSAT log in
	 * 
	 * @throws Throwable
	 */
	public boolean PSATLaunch(String PSATURL, String CTY, String env) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, ePricerLoginPageObjects.MaintLink);

			boolean display = false;
			boolean display1 = false;
			epricerNavigatetoPSAT(PSATURL);
			display1 = action.CheckifExist(driver, ePricerLoginPageObjects.buttonPSATLogin);
			if (display1) {
				action.clickButton(driver, ePricerLoginPageObjects.buttonPSATLogin, "CDT maint button");

			}
			display = action.CheckifExist(driver, ePricerLoginPageObjects.LoginMainUserName);
			if (display) {

				this.PSATSignin(Excel_Handling.Get_Data(TC_ID, "userName"), Excel_Handling.Get_Data(TC_ID, "password"));

			}

			this.PSATLaunchpageCTRYSelect(CTY);

			this.PSATLaunchpage();

			try {

				this.PSATIBMIDs(env);

			} catch (Exception e) {
			}
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("PSAT Launch Pass", "PSAT Launch Pass", driver, test);
			Extent_Reporting.Log_Pass("PSAT Launch Pass", "PSAT Launch Pass", test);
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PSAT Launch failed", "PSAT Launch failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

		return true;
	}

	/**
	 * Jacob : This method is to navigate to PSAT.
	 * 
	 * @throws Throwable
	 */

	public void epricerNavigatetoPSAT(String MySAURL) throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			System.out.println("Navigate to the URL " + MySAURL);
			driver.get(MySAURL);
			Extent_Reporting.Log_report_img("ePricer homePage and epricerLogoScreen is displayed.",
					"ePricer homePage and epricerLogoScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("ePricer homePage and epricerLogoScreen is displayed.", "ePricer homePage and epricerLogoScreen is displayed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("ePricer homePage and epricerLogoScreen is not displayed.","ePricer homePage and epricerLogoScreen is not displayed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * Author Jaocb This method is to in put UAT test id.
	 * 
	 * @throws Exception
	 * 
	 * @throws Throwable
	 */
	public void PSATSignin(String Username, String Password) throws Exception {
		try {
			Thread.sleep(5000);
			action.clearAndInputTextValue(driver, ePricerLoginPageObjects.LoginMainUserName, Username,
					"Input user name");

			Thread.sleep(5000);
			action.clearAndInputTextValue(driver, ePricerLoginPageObjects.LoginMainPassword, Password,
					"Input password");

			Thread.sleep(5000);
			action.clickButton(driver, ePricerLoginPageObjects.buttonPSATSignin, "click log in button");

			Extent_Reporting.Log_report_img("IBM ID login", "IBM ID login", driver, test);
			Extent_Reporting.Log_Pass("IBM ID login.", "IBM ID logine.", test);
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("IBM ID log in failed", "IBM ID login failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * Author Jaocb This method is to select the country on the xml generation page
	 * 
	 * @throws Exception
	 * @throws Throwable
	 */
	public void PSATLaunchpageCTRYSelect(String ctry) throws Exception {
		try {
			action.clickButton(driver, ePricerLoginPageObjects.epricerGObutton, "click on epricer go button");

			String ctryvalue = "";
			switch (ctry) {
			case "JP":
				ctryvalue = "Japanese (Japan)";
				break;
			case "UK":
				ctryvalue = "English (United Kingdom)";
				break;
			}
			System.out.println(ctryvalue);

			action.selectDropBoxByVisibleText(driver, ePricerLoginPageObjects.countryselectdropdownlist, ctryvalue,
					"select country");

			if (ctry.equals("JP")) {
				action.selectDropBoxByVisibleText(driver, ePricerLoginPageObjects.companyselectdropdownlist,
						"NIandC Partners Inc.", "change company");
				// action.selectDropBoxValue(driver,
				// ePricerLoginPageObjects.countryselectdropdownlist, "243", "change company");

			}
			action.clickButton(driver, ePricerLoginPageObjects.countryselectbutton,
					"click the select button to select the country");

			Extent_Reporting.Log_report_img("country select on xml generation page",
					"country select on xml generation page", driver, test);
			Extent_Reporting.Log_Pass("country select on xml generation page.", "country select on xml generation page.", test);
		}

		catch (Exception e) {
			Extent_Reporting.Log_Fail("country select on XML generation page failed",
					"country select on XML generation page failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Author Jaocb This method is to input the info and generate XML
	 * 
	 * @throws Exception
	 * 
	 * @throws Throwable
	 */
	public void PSATLaunchpage() throws Exception {
		try {
			action.clickButton(driver, ePricerLoginPageObjects.countryselectbutton, "click the select button");

			action.clearAndInputTextValue(driver, ePricerLoginPageObjects.XMLphone, "945325", "send phone number");
			action.clearAndInputTextValue(driver, ePricerLoginPageObjects.XMLemail, "epbpauto@in.ibm.com", "send email");
			action.clearAndInputTextValue(driver, ePricerLoginPageObjects.XMLuniqueid,
					Excel_Handling.Get_Data(TC_ID, "IBMUniqueID"), "send uniqueid");
			action.clickButton(driver, ePricerLoginPageObjects.generateXMLbutton, "generate xml");
			Thread.sleep(10000);
			action.clickButton(driver, ePricerLoginPageObjects.sendXMLbutton, "send xml");
			Thread.sleep(20000);

			Extent_Reporting.Log_report_img("XML generated and send to PSAT", "XML generated and send to PSAT", driver, test);
			Extent_Reporting.Log_Pass("XML generated and send to PSAT.", "XML generated and send to PSAT.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("XML generated and send to PSAT failed", "XML generated and send to PSAT failed",
					driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * Author Jaocb This method is to login with IBMID
	 * 
	 * @throws Throwable
	 */
	public void PSATIBMIDs(String env) throws Throwable {
		try {
			Thread.sleep(15000);
			boolean display = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDname);
			if (display) {
				Thread.sleep(5000);
				action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDname,
						Excel_Handling.GetSecureData(1, 0, 0,env), "IBMID name");
				Thread.sleep(5000);
				boolean display1 = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton);
				if (display1) {
					action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton,
							"click continue button");					
				}				
				Thread.sleep(10000);
				action.inputTextForPassword(driver, ePricerLoginPageObjects.PSATIBMIDpassword,Excel_Handling.GetSecureData(1, 1, 0,env), "IBMID password");
				// System.out.println("Password is " + Excel_Handling.Get_Data(TC_ID,
				// "IBMIDPassword"));
				Thread.sleep(5000);
				action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDsigninbutton, "click signin button");
			}
			Extent_Reporting.Log_report_img("mySA Login completed.", "mySA Login completed.", driver, test);
			Extent_Reporting.Log_Pass("mySA Login completed.", "mySA Login completed.", test);
		}

		catch (Exception e) {
			Extent_Reporting.Log_Fail("mySA Login not completed.", "mySA Login not completed.", driver, test);
			//System.out.println(e.getMessage().toString());
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
				action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDname,Excel_Handling.Get_Data(TC_ID, "IBMIDName" + user), "IBMID name");
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
			Extent_Reporting.Log_Pass("mySA Login completed.", "mySA Login completed.", test);
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
	 * Author Jaocb This method is to launch group
	 * 
	 * @throws Exception
	 * 
	 * @throws Throwable
	 */
	public void LaunchGroup() throws Exception {
		try {
			for (int i = 0; i < 10; i++) {
				boolean display = action.CheckifExist(driver, ePricerLoginPageObjects.PSATGroup);

				//System.out.println("i = " + i);
				//System.out.println("Display = " + display);

				if (display) {
					break;
				} else {
					Thread.sleep(60000);
				}

				if (i == 9) {

				}
			}
			Thread.sleep(10000);
			action.selectDropBoxByVisibleText(driver, ePricerLoginPageObjects.PSATGroup,Excel_Handling.Get_Data(TC_ID, "SelectARole"), "select Group");
			action.clickButton(driver, ePricerLoginPageObjects.PSATGrouplaunchbutton, "click the button launch");
			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("PSAT group launch", "PSAT group launch", driver, test);
			Extent_Reporting.Log_Pass("PSAT group launch", "PSAT group launch", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PSAT group launch failed", "PSAT group launch failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * Author Jaocb This method is to launch group
	 * 
	 * @throws Exception
	 * 
	 * @throws Throwable
	 */
	public void LaunchGroupLegal(String Groupname) throws Exception {
		ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
		try {
			for (int i = 0; i < 10; i++) {
				boolean display = action.CheckifExist(driver, ePricerLoginPageObjects.PSATGroup);
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
			Extent_Reporting.Log_Pass("PSAT group launch", "PSAT group launch", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PSAT group launch failed", "PSAT group launch failed", driver, test);
			//System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is to navigate to EMEABP.
	 * 
	 * @throws Throwable
	 */
	public void epricerNavigateURL(String bPURL) throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			// driver.get(Excel_Handling.Get_Data(TC_ID, "EMEAIBMUrl"));

			driver.get(bPURL);
			Thread.sleep(4000);

			Extent_Reporting.Log_report_img("BPURL url opened.", "BPURL url opened.", driver, test);
			Extent_Reporting.Log_Pass("BPURL url opened.", "BPURL url opened.", test);
			
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("BPURL url not opened.", "BPURL url not opened.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void epricerNavigatetoEMEABP(String AppURL) throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			System.out.println("Navigate to the URL " + AppURL);
			driver.get(AppURL);
			Extent_Reporting.Log_report_img("ePricer homePage and epricerLogoScreen is displayed.","ePricer homePage and epricerLogoScreen is displayed.", driver, test);
			Extent_Reporting.Log_Pass("ePricer homePage and epricerLogoScreen is displayed.", "ePricer homePage and epricerLogoScreen is displayed.", test);

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
	 * Jacob: This method is for emeaBP log in
	 * 
	 * @throws Throwable
	 */
	public boolean emeaBPENVSelect(String ENV) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			if (ENV.equalsIgnoreCase("MAINT")) {
				action.waitForElementVisible(driver, ePricerLoginPageObjects.MaintLink);
				action.clickLink(driver, ePricerLoginPageObjects.MaintLink, "Maint link");
			}
			if (ENV.equalsIgnoreCase("DEV")) {
				action.waitForElementVisible(driver, ePricerLoginPageObjects.DevLink);
				action.clickLink(driver, ePricerLoginPageObjects.DevLink, "Dev link");
			}

			Thread.sleep(2000);
			Extent_Reporting.Log_report_img("PCS env select", "PCS env select", driver, test);
			Extent_Reporting.Log_Pass("PCS env select Passed.", "PCS env select Passed.", test);
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
	 * Jacob: This method is for MySA log in
	 * 
	 * @throws Throwable
	 */
	public boolean MySALaunch(String MySAURL, String ENV) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			epricerNavigatetoPSAT(MySAURL);
			this.PSATIBMIDs(ENV);
			this.MySAlogin(ENV);
			Thread.sleep(9000);
			Extent_Reporting.Log_report_img("MySA Launch Pass", "MySA Launch Pass", driver, test);
			Extent_Reporting.Log_Pass("MySA Launch Passed.", "MySA Launch Passed.", test);
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
			Extent_Reporting.Log_Fail("MySA Launch failed", "MySA Launch failed", driver, test);
			throw new Exception("Failed");
		}

		return true;
	}

	/**
	 * Jacob: This method is for MySA log in with different userid and password
	 * 
	 * @throws Throwable
	 */
	public boolean MySALaunch(String MySAURL, String ENV, String user) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			epricerNavigatetoPSAT(MySAURL);
			try {

				this.PSATIBMID(user);

			} catch (Exception e) {
			}

			this.MySAlogin(ENV);

			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("MySA Launch Pass", "MySA Launch Pass", driver, test);
			Extent_Reporting.Log_Pass("MySA LaunchPassed.", "MySA Launch Passed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("MySA Launch failed", "MySA Launch failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

		return true;
	}

	/**
	 * Author Jaocb This method is to perform action on MySA
	 * 
	 * @throws Throwable
	 */
	public void MySAlogin(String ENV) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			Thread.sleep(20000);
			String currentrole = action.getInputTextValue(driver, ePricerLoginPageObjects.MySAcurrentrole,"get current logged role");
			System.out.println("current company get from web page is " + currentrole);
			String company = Excel_Handling.Get_Data(TC_ID, "MySACompany");
			String xPathString = "//"+"a[contains(.,"+"'"+company+"')]";
			
			if (currentrole.contains(company)) {
				Log.debug("company get from data file is " + company);
			} else {
				action.mouseHoverAction(driver, ePricerLoginPageObjects.MySAcurrentrole,"move and hold to the current role");
				Thread.sleep(35000);
				try {
					for (int i = 1; i < 10; i++) {
						//String xpath = ".//*[@id='ibm-signin-minimenu-container']/li[" + i + "]/a";

						System.out.println(xPathString);
						Thread.sleep(15000);
						String listrole = "";
						try{
							boolean rolecanbefound = driver.findElement(By.xpath(xPathString)).isDisplayed();
						
							if(rolecanbefound)
							{
								listrole = action.getInputTextValue(driver, xPathString, "get list role");
							}else{
								 System.out.println("the xpath is not valid, can not get the role from the xpath generated");
							}
							
						} catch (Exception e) {
							 System.out.println("there isn't any company can be switched to");
							 break;
						}
						
						 System.out.println("role get from webpage is "+ listrole);
						 System.out.println("company get from data file is " + company);
						if (listrole == null) {
							 System.out.println("listrole is empty");
							break;
						}
						if (listrole.contains(company)) {
							action.clickButton(driver, xPathString, "click on the role");
							String currentrole2 = action.getInputTextValue(driver, ePricerLoginPageObjects.MySAcurrentrole,"get current logged role");
							System.out.println("current company get from web page is now" + currentrole2);
							break;
						}

					}
				} catch (Exception e) {
					 System.out.println("there is no valid company can be selected");
				}
//				Thread.sleep(10000);
//				Actions BpCompanydd = new Actions(driver);
//				WebElement menu = driver.findElement(By.xpath("//*[@id='ibm-universal-nav']/div[2]/ul/li[1]/button"));
//				Thread.sleep(2000);
//				BpCompanydd.moveToElement(menu).moveToElement(driver.findElement(By.xpath(xPathString))).click().build().perform();

			}
			Thread.sleep(10000);
			action.clickLinkByLinkText(driver, "Systems pricing", "Click on ePricer Link");
			Log.debug("click on the MySAePricer link");

			Thread.sleep(5000);

			action.selectDropBoxByVisibleText(driver, ePricerLoginPageObjects.MySARolelist,
					Excel_Handling.Get_Data(TC_ID, "MySARole"), "select role");

			if (ENV.equalsIgnoreCase("MAINT")) {
				action.Javascriptexecutor_forClick(driver, ePricerLoginPageObjects.MySAMAINT, "click on maint link");
			} else if (ENV.equalsIgnoreCase("DEV")) {
				action.clickButton(driver, ePricerLoginPageObjects.MySADEV, "click on DEV link");
			} else if (ENV.equalsIgnoreCase("IVT")) {
				action.clickButton(driver, ePricerLoginPageObjects.MySAIVT, "click on IVT link");
			} else {
				throw new Exception("ENV not valid");
			}
			Thread.sleep(10000);
			if (action.CheckifExist(driver, ePricerLoginPageObjects.MySALoginbutton)) {
				action.clickButton(driver, ePricerLoginPageObjects.MySALoginbutton, "click the Submit button");
			} else {
				Thread.sleep(30000);
				action.clickButton(driver, ePricerLoginPageObjects.MySALoginbutton, "click the Submit button");
			}
			driver.switchTo().parentFrame();
			Extent_Reporting.Log_Pass("MySA log in Passed.", "MySA log in Passed.", test);
			Extent_Reporting.Log_report_img("MySA log in passed", "MySA log in passed", driver, test);
		}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("MySA log in failed", "MySA log in failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			fail("MySA log in failed for ENV: " + ENV, e);
			throw new Exception("Failed");
		}

	}

	/**
	 * Author Jaocb This method is to perform action on MySA
	 * 
	 * @throws Throwable
	 */
	public void MySAlogout() throws Throwable {
		ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
		try {
			Thread.sleep(25000);
			String currentrole = action.getInputTextValue(driver, ePricerLoginPageObjects.MySAcurrentrole,"get current logged role");
			System.out.println("current company get from web page is " + currentrole);
			String company = "Sign out";
			if (currentrole.contains(company)) {
				System.out.println("company get from data file is " + company);
			} else {
				Actions BpCompanydd = new Actions(driver);
				WebElement menu = driver.findElement(By.xpath("//*[@id='ibm-universal-nav']/div[2]/ul/li[1]/button"));
				Thread.sleep(20000);
				BpCompanydd.moveToElement(menu);
				BpCompanydd.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Sign out')]")));			
				BpCompanydd.click();
				Thread.sleep(8000);
				Extent_Reporting.Log_Pass("MySA Sing out Selected.", "MySA Sing out Selected.", test);
			}
			Thread.sleep(60000);
			driver.switchTo().parentFrame();
			Extent_Reporting.Log_Pass("MySA log out Passed.", "MySA log out Passed.", test);
			Extent_Reporting.Log_report_img("MySA log out passed", "MySA log out passed", driver, test);
		}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("MySA log out failed", "MySA log out failed", driver, test);
			//System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Author Jaocb This method is to perform action on MySA
	 * 
	 * @throws Exception
	 * @throws Throwable
	 */
	public void MySAlogin_backup() throws Exception {
		try {
			Thread.sleep(5000);
			// action.waitForElementVisible(driver,
			// ePricerLoginPageObjects.MySAePricerlink);

			// action.clickLink(driver, ePricerLoginPageObjects.MySAePricerlink, "click on
			// epricer link");
			action.clickLinkByLinkText(driver, "Systems pricing", "click on epricer link");
			System.out.println("click on the MySAePricer link");

			Thread.sleep(5000);

			action.selectDropBoxByVisibleText(driver, ePricerLoginPageObjects.MySARolelist,
					Excel_Handling.Get_Data(TC_ID, "MySARole"), "select role");
			/*
			 * action.clickButton(driver, ePricerLoginPageObjects.MySARolelist, "test");
			 * Thread.sleep(5000); Actions action1 = new Actions(driver);
			 * action1.sendKeys(Keys.ENTER).perform();
			 */
			Thread.sleep(5000);

			action.clickButton(driver, ePricerLoginPageObjects.MySALoginbutton, "click the Submit button");

			driver.switchTo().parentFrame();

			Extent_Reporting.Log_report_img("MySA log in passed", "MySA log in passed", driver, test);
			Extent_Reporting.Log_Pass("MySA log in Passed.", "MySA log in Passed.", test);
		}

		catch (Exception e) {
			Extent_Reporting.Log_Fail("MySA log in failed", "MySA log in failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * Author Kajal This method is to loginPSAT
	 */
	public void loginPSAT() throws Exception {
		try {
			loginEpricer();
			ePricerGoTabClick();
			ePricerGoTestScreen();
			selectButtonClick();
			dataForEPricerGoTestScreen();
			generateXMLButtonClick();
			sendXMLButtonClick();

			Extent_Reporting.Log_report_img("loginPSAT passed", "loginPSAT passed", driver, test);
			Extent_Reporting.Log_Pass("loginPSAT Passed.", "loginPSAT Passed.", test);
		}

		catch (Exception e) {
			Extent_Reporting.Log_Fail("loginPSAT failed", "loginPSAT failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is to navigate to envURL.
	 * 
	 * @throws Throwable
	 */
	public void envURL(String ENV, String MySAURL, String BPURL) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);

			if (ENV.equalsIgnoreCase("DEV")) {
				epricerNavigateURL(BPURL);
				loginPSAT();
				Extent_Reporting.Log_Pass("Env is DEV.", "Env is DEV.", test);
			} else {
				epricerNavigateURL(BPURL);
				loginPSAT();
				MySALaunch(MySAURL, ENV);
				Extent_Reporting.Log_Pass("Env is MAINT.", "Env is MAINT.", test);
			}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Env is not selected.", "Env is not selected.", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void MySAPRODLaunch(String mySAURL, String eNV) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			epricerNavigatetoPSAT(mySAURL);
			Thread.sleep(8000);
			if (eNV.equalsIgnoreCase("IVT")) {
				action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDname,Excel_Handling.GetSecureData(1, 0, 1,eNV), "IBMID name");
			} else {
				Thread.sleep(5000);
				action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDname,Excel_Handling.GetSecureData(1, 0, 0,eNV), "IBMID name");
			}
			Thread.sleep(5000);
			boolean display1 = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton);
			if (display1) {
				action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton,"click continue button");
				Thread.sleep(4000);
				String uNElement = "//*[@name='username']";
				if (eNV.equalsIgnoreCase("IVT")) {
					action.clearAndInputTextValue(driver, uNElement,Excel_Handling.GetSecureData(1, 0, 1,eNV), "IBMID name");
				} else {
					action.clearAndInputTextValue(driver, uNElement,Excel_Handling.GetSecureData(1, 0, 0,eNV), "IBMID name");
				}
			}			
			Thread.sleep(4000);
			String pwdElement = "//*[@name='password']";
			if (eNV.equalsIgnoreCase("IVT")) {
				action.inputTextForPassword(driver, pwdElement,Excel_Handling.GetSecureData(1, 1, 1,eNV), "IBMID name");
			} else {
				action.inputTextForPassword(driver, pwdElement,Excel_Handling.GetSecureData(1, 1, 0,eNV), "IBMID name");
			}			
			Thread.sleep(2000);
			String signinButtonString = ".//*[@id='btn_signin']";
			action.clickButton(driver, signinButtonString, "click signin button");
			Extent_Reporting.Log_report_img("MySA Launch Pass", "MySA Launch Pass", driver, test);
			Thread.sleep(18000);
			if (eNV.equalsIgnoreCase("IVT")) {
				this.MySAlogin(eNV);
			}else {
				action.clickLinkByLinkText(driver, "Systems pricing", "Click on ePricer Link");
				Log.debug("click on the MySAePricer link");
				Thread.sleep(5000);
				action.selectDropBoxByVisibleText(driver, ePricerLoginPageObjects.MySARolelist,Excel_Handling.Get_Data(TC_ID, "MySARole"), "select role");				
				Thread.sleep(8000);
				String submitButtonString = "/html/body/div[4]/div[2]/div/e-pricer-popup/form/div[2]/div/div[2]/button";
				action.Javascriptexecutor_forClick(driver, submitButtonString, "click the Submit button");
			}						
			Extent_Reporting.Log_Pass("MySAPROD Launch Passed.", "MySAPROD Launch Passed.", test);		
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("MySAPROD Launch failed", "MySAPROD Launch failed", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("MySA Launch failed");
			//fail("MySA Launch failed");
		}	
	}

	public void LaunchProdGroup(String role) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			Thread.sleep(10000);
			action.selectDropBoxByVisibleText(driver, ePricerLoginPageObjects.PSATGroup,Excel_Handling.Get_Data(TC_ID, role), "select Group");
			action.clickButton(driver, ePricerLoginPageObjects.PSATGrouplaunchbutton, "click the button launch");
			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("PSAT group launch", "PSAT group launch", driver, test);
			Extent_Reporting.Log_Pass("Launch Prod Group Passed.", "Launch Prod Group Passed.", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("PSAT group launch failed", "PSAT group launch failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public boolean MySALaunchwithSecondUser(String mySAURL, String eNV) throws Throwable {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			epricerNavigatetoPSAT(mySAURL);
			this.PSATIDsSecondUser(eNV);
			this.MySAlogin(eNV);
			Thread.sleep(4000);
			Extent_Reporting.Log_report_img("MySA Launch Pass", "MySA Launch Pass", driver, test);
			Extent_Reporting.Log_Pass("MySA Launch Passed.", "MySA Launch Passed.", test);
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
			Extent_Reporting.Log_Fail("MySA Launch failed", "MySA Launch failed", driver, test);
			throw new Exception("Failed");
		}

		return true;
	}

	private void PSATIDsSecondUser(String eNV) throws Throwable {
		try {
			Thread.sleep(5000);
			boolean display = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDname);
			if (display) {
				Thread.sleep(15000);
				action.clearAndInputTextValue(driver, ePricerLoginPageObjects.PSATIBMIDname,Excel_Handling.GetSecureData(3, 0, 0,eNV), "IBMID name");
				Thread.sleep(15000);
				boolean display1 = action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton);
				if (display1) {
					action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDcontinuebutton,"click continue button");					
				}				
				Thread.sleep(10000);
				action.inputTextForPassword(driver, ePricerLoginPageObjects.PSATIBMIDpassword,Excel_Handling.GetSecureData(3, 1, 0,eNV), "IBMID password");
				Thread.sleep(8000);
				if (action.CheckifExist(driver, ePricerLoginPageObjects.PSATIBMIDsigninbutton)) {
					action.clickButton(driver, ePricerLoginPageObjects.PSATIBMIDsigninbutton, "click signin button");
				}
			}
			Extent_Reporting.Log_report_img("mySA Login completed.", "mySA Login completed.", driver, test);
			Extent_Reporting.Log_Pass("mySA Login completed.", "mySA Login completed.", test);
		}

		catch (Exception e) {
			Extent_Reporting.Log_Fail("mySA Login not completed.", "mySA Login not completed.", driver, test);
			//System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");

		}
	}

}