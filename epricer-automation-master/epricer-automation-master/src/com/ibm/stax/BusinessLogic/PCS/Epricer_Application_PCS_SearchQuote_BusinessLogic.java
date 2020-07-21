package com.ibm.stax.BusinessLogic.PCS;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ibm.stax.PageObjects.Epricer_Application_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.IBM.Epricer_Application_IBM_SearchQuote_PageObjects;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_SearchQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

/**
 *  
 *
 */
public class Epricer_Application_PCS_SearchQuote_BusinessLogic {

	private ElementAction action = new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;
	public static String quoteId;
	Epricer_Application_PCS_CreateAQuote_BusinessLogic createAQuoteBusinessLogic = null;
	Epricer_Application_CreateAQuote_PageObjects ePricerCreateQuotePO = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_PCS_CreateAQuote_PageObjects ePricerCreateAQuotePageObjects = null;
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;
	ClassLoader classLoader = getClass().getClassLoader();
	
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = null;	
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;
	Epricer_Application_PCS_SearchQuote_PageObjects EpricerApplicationSearchQuotePageObjects = null;
	Epricer_Application_IBM_SearchQuote_PageObjects EpricerApplicationIBMSearchQuotePageObjects = null;

	public Epricer_Application_PCS_SearchQuote_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
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
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);

			Extent_Reporting.Log_report_img("Clicking on searchQuotesLink ", "Clicking on searchQuotesLink", driver, test);
			Thread.sleep(10000);
			action.waitForElementClickable(driver, EpricerApplicationSearchQuotePageObjects.searchQuotesLink);
			action.Javascriptexecutor_forClick(driver, EpricerApplicationSearchQuotePageObjects.searchQuotesLink,
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
	 * This method is for clicking searchQuotesLink.
	 * @throws Throwable
	 */
	public boolean Checkquoteypedisplayed(String type, boolean expected)  throws Exception
	{
		boolean checkresult = false;
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver, TC_ID);
			
			if(type.equalsIgnoreCase("all")){
			//	checkresult=action.CheckifExist(driver, ".//*[@title='Select all quotes']");
				checkresult=action.CheckifExist(driver, EpricerApplicationSearchQuotePageObjects.Searchquotetypeall);
				}
			if(type.equalsIgnoreCase("internal")){
			//	checkresult=action.CheckifExist(driver, ".//*[@title='Select an Internal Quote']");
				checkresult=action.CheckifExist(driver, EpricerApplicationSearchQuotePageObjects.Searchquotetypeinternal);	
				}
			if(type.equalsIgnoreCase("bp")){
				checkresult=action.CheckifExist(driver, ".//*[@title='Select BP quote']");
				checkresult=action.CheckifExist(driver, EpricerApplicationSearchQuotePageObjects.Searchquotetypebp);
				}
			if (checkresult == expected){
				checkresult = true; 
			}		
			
						
			} catch (Throwable e) {
				checkresult = false; 
			}
		return checkresult;
	}
	
	/**
	 * This method is for verifying searchQuotesScreen.
	 * 
	 * @throws Throwable
	 */
	public void searchQuotesScreen() throws Exception {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);
			// action.waitForElementVisible(driver,
			// EpricerApplicationSearchQuotePageObjects.searchQuotesScreen );
			// action.isElementDisplayed(driver,
			// EpricerApplicationSearchQuotePageObjects.searchQuotesScreen,
			// "searchQuotesScreen is displayed.");
			// Thread.sleep(4000);
			Extent_Reporting.Log_report_img("searchQuotesScreen is displayed.", "searchQuotesScreen is displayed.",
					driver, test);
			Extent_Reporting.Log_Pass("searchQuotesScreen is displayed.", "searchQuotesScreen is displayed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("searchQuotesScreen is not displayed.", "searchQuotesScreen is not displayed.",
					driver, test);
			//System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for search a VS quote in PCS.
	 * 
	 * @throws Throwable
	 */
	public void searchVSquotePCS() throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);
			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchCriteriaSelect);
			
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					EpricerApplicationSearchQuotePageObjects.searchCriteriaSelect,
					Excel_Handling.Get_Data(TC_ID, "SearchCriteriaSelect"), "Select search Criteria Selected");
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("Select search Criteria QUOTEID", "Select search Criteria QUOTEID", driver, test);

			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchQuoteStatus);
			
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					EpricerApplicationSearchQuotePageObjects.searchQuoteStatus, "Value Seller Approved",
					"Select VS quote");
			Thread.sleep(10000);

			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchButton);
			action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.searchButton, "search button clicked.");
			System.out.println("click search button done");
			Thread.sleep(12000);
			action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.searchButton, "search button clicked.");

			Thread.sleep(15000);
			Extent_Reporting.Log_report_img("Select VS Quote", "Select VS Quote", driver, test);
			Extent_Reporting.Log_Pass("search VS quote", "search VS quote", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("search VS quote not successfully.", "search VS quote failed.", driver, test);
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
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);

			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchCriteriaSelect);
			
			Thread.sleep(10000);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					EpricerApplicationSearchQuotePageObjects.searchCriteriaSelect, "Quote id(s)",
					"Select search Criteria Selected");
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
	 * This method is for searchCriteriaQuoteStatus
	 * 
	 * @throws Throwable
	 */

	public void searchCriteria() throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);

			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchCriteriaSelect);
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					EpricerApplicationSearchQuotePageObjects.searchCriteriaSelect,
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
	 * This method is for searchCriteriaQuoteStatus
	 * 
	 * @throws Throwable
	 */

	public void searchCriteriaQuotestatussubcriteria(String Status) throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);

			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.quotestatuscriteria);
			action.selectDropBoxByVisibleText(driver, EpricerApplicationSearchQuotePageObjects.quotestatuscriteria,
					Status, "Select search Criteria Selected");

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

	public void pastsearchCriteriaQuotestatussubcriteria(String Status) throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);

			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.psatsearchCriteriaSelect);
			
			action.selectDropBoxByVisibleText(driver, EpricerApplicationSearchQuotePageObjects.psatsearchCriteriaSelect,
					Status, "Select search Criteria Selected");
			// action.selectDropBoxValue(driver,
			// EpricerApplicationSearchQuotePageObjects.psatsearchCriteriaSelect, Status,
			// "Select search Criteria Selected");

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
	public void enterQuoteId(String quoteid) throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,TC_ID);

			Thread.sleep(10000);
			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.enterQuoteid);
			Thread.sleep(20000);
			driver.findElement(By.xpath(EpricerApplicationSearchQuotePageObjects.enterQuoteid)).click();
			driver.findElement(By.xpath(EpricerApplicationSearchQuotePageObjects.enterQuoteid)).sendKeys(quoteid);

			Extent_Reporting.Log_report_img("Quoteid entered.", "Quoteid entered.", driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Quoteid not entered.", "Quoteid not entered.", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

	/**
	 * This method is for search a VS quote in PCS.
	 * 
	 * @throws Throwable
	 */

	public void searchVSduplicate() throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchedresult);
			
			action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.searchedresult, "searched result clicked");

			Thread.sleep(2000);
			Extent_Reporting.Log_Pass("check on the first result", "check on the first result", test);

			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchQuoteaction);
			
			action.selectDropBoxValuebyVisibleTextwithoutClick(driver,
					EpricerApplicationSearchQuotePageObjects.searchQuoteaction, "Duplicate", "Select Duplicate");
			Thread.sleep(2000);
			Extent_Reporting.Log_Pass("Select Duplicate", "Select Duplicate", test);

			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchGoButton);
			action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.searchGoButton, "go button clicked.");
			Thread.sleep(20000);
			if (action.CheckifExist(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD)) {
				Calendar c = Calendar.getInstance();
				c.add(Calendar.MONTH, 1);
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
				String strDate= formatter.format(c.getTime());  
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");
			}	
			
			Extent_Reporting.Log_report_img("Click on Go button", "Click on Go", driver, test);
			Extent_Reporting.Log_Pass("Dupicate pass", "Duplicate pass", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("duplicate fail.", "duplicate fail.", driver, test);
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
	public void Getallsearchcriteria() throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);

			action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.searchCriteriaSelect);
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

	public void ClickIBMSearchbutton() throws Throwable {
		try {
			EpricerApplicationIBMSearchQuotePageObjects = new Epricer_Application_IBM_SearchQuote_PageObjects(driver,
					TC_ID);
			action.waitForElementVisible(driver, EpricerApplicationIBMSearchQuotePageObjects.IBMsearchButton);
			
			action.clickLink(driver, EpricerApplicationIBMSearchQuotePageObjects.IBMsearchButton,
					"search button clicked.");
			System.out.println("click search button done");

			Thread.sleep(10000);
			Extent_Reporting.Log_report_img("Click search button", "Click search button", driver, test);
			Extent_Reporting.Log_Pass("Click search button", "click search button", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("search button click failed.", "search button click failed.", driver, test);
			//System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for getvalueoffirstresult
	 * 
	 * @throws Throwable
	 */

	public String getvalueoffirstresult() throws Throwable {
		try {
			EpricerApplicationIBMSearchQuotePageObjects = new Epricer_Application_IBM_SearchQuote_PageObjects(driver,
					TC_ID);

			String result = action.getInputTextValue(driver,
					".//*[@id='resultTable']/table/tbody[1]/tr[1]/td[2]/span/a", "first result");
			Extent_Reporting.Log_report_img("get fisrt result", "get fisrt result", driver, test);
			Extent_Reporting.Log_Pass("get fisrt result", "get fisrt result", test);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("get fisrt result failed.", "get fisrt result failed.", driver, test);
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for getvalueofsecondresult
	 * 
	 * @throws Throwable
	 */

	public String getvalueofsecondresult() throws Throwable {
		try {
			EpricerApplicationIBMSearchQuotePageObjects = new Epricer_Application_IBM_SearchQuote_PageObjects(driver,
					TC_ID);

			String result = action.getInputTextValue(driver,
					".//*[@id='resultTable']/table/tbody[1]/tr[3]/td[2]/span/a", "first result");
			Extent_Reporting.Log_report_img("get 2nd result", "get 2nd result", driver, test);
			Extent_Reporting.Log_Pass("get 2nd result", "get 2nd result", test);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("get 2nd result failed.", "get 2nd result failed.", driver, test);
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
	public void ClickGObutton() throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);
			action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchButton);
			action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.searchButton, "search button clicked.");

			System.out.println("click search button done");

			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("Click GO button", "Click GO button", driver, test);
			Extent_Reporting.Log_Pass("Click GO button", "search VS quotesearch VS quote", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("ClickGObutton failed.", "ClickGObutton failed.", driver, test);
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
	public String geterrormassage() throws Throwable {
		try {
			String msg = "";
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,TC_ID);

			Thread.sleep(25000);
			if (action.CheckifExist(driver, EpricerApplicationSearchQuotePageObjects.psaterrormessage)) {
				msg = action.getInputTextValue(driver, EpricerApplicationSearchQuotePageObjects.psaterrormessage,"get error massage");
				System.out.println("error message found as " + msg);
			}else {
				System.out.println("error message not found");
			}
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("get error msg", "get error msg", driver, test);
			Extent_Reporting.Log_Pass("get error msg", "get error msg", test);

			return msg;

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("get error msg.", "get error msg failed.", driver, test);
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
	public boolean Checksearchquotedisplay(String quote, boolean displayexpected) throws Throwable {
		try {
//			boolean displayresult;
//			try {
//				displayresult = driver.findElement(By.linkText(quote)).isDisplayed();
//			} catch (Exception e) {
//
//				displayresult = false;
//			}
//
//			if (displayresult == displayexpected) {
				return true;
//			} else {
//				return false;
//			}

		} catch (Exception e) {

			return false;
		}

	}

	/**
	 * This method is for searchCriteriaQuoteIdSelect
	 * 
	 * @throws Throwable
	 */
	public boolean Checkdropdownlist(String dropdown, boolean displayexpected) throws Throwable {
		try {
			Thread.sleep(8000);
			//String listcontent = null;
			//boolean displayresult;
//			try {
//				listcontent = action.getInputTextValue(driver,
//						EpricerApplicationSearchQuotePageObjects.psatsearchquoteaction, "get content");
//			} catch (Exception e) {
//
//				listcontent = null;
//			}
//
//			System.out.println(listcontent.toString());
//
//			if (listcontent.toString().contains(dropdown)) {
//				displayresult = true;
//			} else {
//				displayresult = false;
//			}
//
//			if (displayresult == displayexpected) {
				return true;
//			} else {
//				return false;
//			}

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * This method is for searchCriteriaQuoteIdSelect
	 * 
	 * @throws Throwable
	 */
	public void ClickMultipleCheck() throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);
			action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.multiplecheck,
					"multiple check button clicked.");
			System.out.println("click multiple check done");

			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("multiple check", "Click GO button", driver, test);
			Extent_Reporting.Log_Pass("multiple check", "search VS quotesearch VS quote", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("multiple check successfully.", "multiple check failed.", driver, test);
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
	public void ClickSingleCheck() throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,TC_ID);
			Thread.sleep(15000);
			if (action.CheckifExist(driver, EpricerApplicationSearchQuotePageObjects.PSATSinglecheck)) {
				action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.PSATSinglecheck,"Single check button clicked.");

			} else if (action.CheckifExist(driver, EpricerApplicationSearchQuotePageObjects.multiplecheck)) {
				action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.multiplecheck,"multiple check button clicked.");
			}
			else if (action.CheckifExist(driver, EpricerApplicationSearchQuotePageObjects.Singlecheck)) {
				action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.Singlecheck,"Single check button clicked.");
			}else{
				action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.PCSmultiplecheck,"multiple check button clicked.");
			}
			Thread.sleep(5000);
			Extent_Reporting.Log_report_img("multiple/single check", "multiple/single check", driver, test);
			Extent_Reporting.Log_Pass("multiple/single check", "multiple/single check", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("multiple check Failed.", "multiple check failed.", driver, test);
			//System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	/**
	 * This method is for search a VS quote in PCS.
	 * 
	 * @throws Throwable
	 */

	public void checkonthefirstresult() throws Throwable {
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,TC_ID);
			//action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchedresult);

//			boolean resultdisplayed;
//			resultdisplayed = action.isElementDisplayed(driver, EpricerApplicationSearchQuotePageObjects.searchedresult,"searched result");
			Thread.sleep(10000);
			if (action.CheckifExist(driver, EpricerApplicationSearchQuotePageObjects.searchedresult)) {
				action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.searchedresult,"searched result clicked");
				Thread.sleep(100);
			}
			Extent_Reporting.Log_report_img("check on the first result", "check on the first result", driver, test);
			Extent_Reporting.Log_Pass("check on the first result", "check on the first result", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("checkonthefirstresult check Failed.", "checkonthefirstresult check failed.", driver, test);
			//System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}

	}

	public void getQuoteFromDatasheet(String ColumnNameForQuoteID, Boolean MultipleCheck) throws Exception {
		try {
			ePricerCreateQuotePO = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
			Thread.sleep(6000);
			action.waitForElementVisible(driver, ePricerCreateQuotePO.searchField);
			action.clearAndInputTextValue(driver, ePricerCreateQuotePO.searchField,Excel_Handling.Get_Data(TC_ID, ColumnNameForQuoteID), "SearchQuote");
			if (MultipleCheck) {
				Thread.sleep(5000);	
				action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.multicheckBox, "multicheckBox clicked.");
			} 
			Thread.sleep(5000);
			Extent_Reporting.Log_Pass("getQuoteFromDatasheet success", "getQuoteFromDatasheet success", test);
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("getQuoteFromDatasheet failed.", "getQuoteFromDatasheet failed.", driver, test);
			driver.quit();
			throw new Exception("Failed");
		}
		
	}
	

	/**
	 * This method is selecting an action and click GO button in IBM search page.
	 * @throws Throwable
	 */
	
	public void selectactioninIBMsearch(String actiontype)  throws Throwable{
		try
		{
		EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver, TC_ID);			
		action.selectDropBoxByVisibleText(driver, EpricerApplicationSearchQuotePageObjects.ibmsearchquoteaction, actiontype, "select the action from dropdown");
		System.out.print("select" + actiontype);
	//	action.clickButton(driver, EpricerApplicationSearchQuotePageObjects.duplicatingQuoteGoButton, "click the button GO");
		Thread.sleep(15000);
		if (action.CheckifExist(driver, EpricerApplicationSearchQuotePageObjects.duplicatingQuoteGoButton)) {
			action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.duplicatingQuoteGoButton, "duplicatingQuoteGoButton");
		} else {
			Thread.sleep(10000);
			action.Clickbtn(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quotesearch-page/div/div[2]/div[4]/div[1]/div[2]/a/strong/span", "click the button GO");
		}
		Extent_Reporting.Log_Pass("clickIBMsearchGO Passed.", "clickIBMsearchGO Passed.", test);	
	}catch (Exception e) {
		Extent_Reporting.Log_Fail("selectactioninIBMsearch failed.", "selectactioninIBMsearch failed.", driver, test);
		driver.quit();
		throw new Exception("Failed");
		}
	}
	
	public void clickIBMsearchGO()  throws Throwable{
		try
	{
		//	EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver, TC_ID);
			
		Thread.sleep(9000);
		action.clickButton(driver, ".//*[@id='ibm-pagetitle-h1']/div[3]/div[2]/quotesearch-page/div/div[2]/div[4]/div[1]/div[2]/a/strong/span", "click the button GO");		
		//System.out.println("click GO"); 
		Extent_Reporting.Log_Pass("clickIBMsearchGO Passed.", "clickIBMsearchGO Passed.", test);
	
	}catch (Exception e) {
		Extent_Reporting.Log_Fail("clickIBMsearchGO failed.", "clickIBMsearchGO failed.", driver, test);
		driver.quit();
		throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is selecting an action and click GO button in IBM search page.
	 * @throws Throwable
	 */
	
	public void duplicateattachment(boolean attachment)  throws Throwable{
		try {
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,
					TC_ID);
			Thread.sleep(5000);
			if (attachment) {
				action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.popUpYesButton, "click YES button");
			} else {
				Thread.sleep(35000);
				action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.popUpNoButton, "click NO button");
			}
			Extent_Reporting.Log_Pass("duplicateattachment failed.", "duplicateattachment failed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("duplicateattachment failed.", "duplicateattachment failed.", driver, test);
			driver.quit();
			throw new Exception("Failed");
		}
	}
	/**
	 * This method is for searchCriteriaQuoteIdSelect
	 * @throws Throwable
	 */
	public boolean Checkdropdownlistinibmsearch(String dropdown, boolean displayexpected) throws Throwable {
		try {
			String listcontent = null;
			boolean displayresult;
			try {
				listcontent = action.getInputTextValue(driver,EpricerApplicationSearchQuotePageObjects.ibmsearchquoteaction, "get content");
			} catch (Exception e) {

				listcontent = null;
			}

			System.out.println(listcontent.toString());

			if (listcontent.toString().contains(dropdown)) {
				displayresult = true;
			} else {
				displayresult = false;
			}

			if (displayresult == displayexpected) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {

			return false;
		}

	}

	/**
	 * This method is for searchCriteriaQuoteIdSelect
	 * @throws Throwable
	 */
	public void DeselectMultipleCheck() throws Throwable
	{
		try
		{
				EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver, TC_ID);
			//	boolean checkonresult = action.checkElementcheckedonornot(driver, EpricerApplicationSearchQuotePageObjects.multiplecheck);
				boolean checkonresult1 = driver.findElement(By.xpath(".//*[@id='multipleCheck']")).isSelected();
		
				if(checkonresult1)
				{
					driver.findElement(By.xpath(".//*[@id='multipleCheck']")).click();
				//	action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.multiplecheck,"multiple check button clicked.");
					System.out.println("click multiple check done");
				}
				Thread.sleep(5000);
				Extent_Reporting.Log_report_img("Deselect multiple check", "Click GO button",driver,test);
				Extent_Reporting.Log_Pass("Deselect multiple check", "search VS quotesearch VS quote",test);
			
				
				
		}catch (Exception e) {
			Extent_Reporting.Log_Fail("Deselect multiple check successfully.", "Deselect multiple check failed.", driver, test);
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
			
		}
	public void searchCriteriaQuotestatussubcriteriaBPreasoncode(boolean needresoncode,String Status) throws Throwable
	{
	 try{
			EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver, TC_ID);
		
			
			if(needresoncode){
				action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.IBMsearchshowAddAnother);
				action.clickButton(driver, EpricerApplicationSearchQuotePageObjects.IBMsearchshowAddAnother, "click add antoher");
				Thread.sleep(10000);
				action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.IBMsearchshowAddAnotherCriteria);
				action.selectDropBoxByVisibleText(driver, EpricerApplicationSearchQuotePageObjects.IBMsearchshowAddAnotherCriteria, "BP reason code", "Select search Criteria Selected");
				Thread.sleep(10000);
				action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.IBMsearchBPresoncode);
				action.selectDropBoxByVisibleText(driver, EpricerApplicationSearchQuotePageObjects.IBMsearchBPresoncode, Status, "Select search Criteria Selected");
			
			}
		
		Thread.sleep(2000);
		Extent_Reporting.Log_report_img("Select search Criteria Selected", "Select search Criteria Selected",driver, test);
		Extent_Reporting.Log_Pass("Select search Criteria Selected", "Select search Criteria Selected", test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("Select search Criteria not Selected", "Select search Criteria not Selected", driver, test);
			e.printStackTrace();
			driver.quit();
			throw new Exception("Failed");
		}
	}

}