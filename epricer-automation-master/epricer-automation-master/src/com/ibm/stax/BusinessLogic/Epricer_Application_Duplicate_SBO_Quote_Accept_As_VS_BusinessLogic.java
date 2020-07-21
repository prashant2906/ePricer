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
import com.ibm.stax.PageObjects.Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_Login_PageObjects;
import com.ibm.stax.PageObjects.Epricer_Application_UpdateAQuote_PageObjects;
import com.ibm.stax.PageObjects.EMEAIBM.Epricer_Application_EMEAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.NAIBM.Epricer_Application_NAIBM_CreateAQuote_PageObjects;
import com.ibm.stax.PageObjects.PCS.Epricer_Application_PCS_SearchQuote_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.ibm.stax.TestData.Excel_Handling;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

public class Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic {
	
	private ElementAction action=new ElementAction();
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;	
	public static String quoteId;
	public static String duplicateQuoteId;
	
	ClassLoader classLoader = getClass().getClassLoader();
	File authenticationIBMGUI = new File(classLoader.getResource("AuthenticationIBMGUI.exe").getFile());
	
	Epricer_Application_EMEAIBM_CreateAQuote_PageObjects ePricerEMEAIBMCreateAQuotePageObjects = null;
	Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = null;
	Epricer_Application_UpdateAQuote_PageObjects ePricerUpdateAQuotePageObjects = null;
	Epricer_Application_CreateAQuote_PageObjects  ePricerCreateAQuotePageObjects = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = null;
	Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_ReSubmit_A_SBO_BusinessLogic ePricerCreateASBOQuoteIncompleteItAndReSubmitASBOBBusinessLogic = null;
	Epricer_Application_Login_PageObjects ePricerLoginPageObjects = null;
	Epricer_Application_NAIBM_CreateAQuote_PageObjects nAIBMCreateAQuotePageObjects = null;
	Epricer_Application_PCS_SearchQuote_PageObjects EpricerApplicationSearchQuotePageObjects = null;
	public Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_BusinessLogic(WebDriver d,String tcId, ExtentTest test){
		this.test = test;
		this.driver = d;
		this.TC_ID=tcId;
		}
	
	/**
	 * This method is for clicking removeFromHoldRadioBtnClick.
	 * @throws Throwable
	 */
	public void removeFromHoldRadioBtnClick()  throws Exception
	{
		try {
				ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
				ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);
				Thread.sleep(10000);
				driver.switchTo().frame("ui-tinymce-0_ifr");
				
				action.inputText(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.mailBody, Excel_Handling.Get_Data(TC_ID, "commentSection"), "commentSection");
				
				driver.switchTo().parentFrame();
				Thread.sleep(10000);

				action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.removeFromHoldRadioBtn, "removeFromHoldRadioBtn clicked");
				Thread.sleep(10000);

				action.Javascriptexecutor_forClick(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusApplyBtn, "commentsStatusApplyBtn");
				Thread.sleep(10000);

				Extent_Reporting.Log_report_img("removeFromHoldRadioBtn clicked.", "removeFromHoldRadioBtn clicked.",driver, test);
				Extent_Reporting.Log_Pass("removeFromHoldRadioBtn clicked.", "removeFromHoldRadioBtn clicked.", test);
				
			} catch (Throwable e) {
				Extent_Reporting.Log_Fail("removeFromHoldRadioBtn not clicked.", "removeFromHoldRadioBtn not clicked.", driver, test);
				driver.quit();
				e.printStackTrace();
				throw new Exception("Failed");
			}
	}
	
	/**
	 * This method is for verifying requestPricingStatusIbmGuiCheck.
	 * @throws Throwable
	 */
	public void requestPricingStatusIbmGuiCheck()  throws Exception{
		try
	{
		ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
			
		action.isElementDisplayed(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.requestPricingStatusIbmGui, "requestPricingStatusIbmGui is displayed.");
		
		Extent_Reporting.Log_report_img("requestPricingStatusIbmGui is displayed.", "requestPricingStatusIbmGui is displayed.",driver, test);
		Extent_Reporting.Log_Pass("requestPricingStatusIbmGui is displayed.", "requestPricingStatusIbmGui is displayed.", test);
		
	}catch (Exception e) {
		Extent_Reporting.Log_Fail("requestPricingStatusIbmGui is not displayed.", "requestPricingStatusIbmGui is not displayed.", driver, test);
		System.out.println(e.getMessage().toString());
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
	}
		
	}
	
	/**
	 * This method is for pricingTabIbmGui clicked
	 * @throws Throwable
	 */
	public void pricingTabIbmGuiClicked() throws Throwable
	{
	 try{
		ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
		
		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.pricingTabIbmGui, "pricingTabIbmGui clicked");
		
		Extent_Reporting.Log_report_img("pricingTabIbmGui clicked", "pricingTabIbmGui clicked",driver, test);
		Extent_Reporting.Log_Pass("pricingTabIbmGui clicked", "pricingTabIbmGui clicked", test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("pricingTabIbmGui clicked", "pricingTabIbmGui clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for approvalTabIbmGui clicked
	 * @throws Throwable
	 */
	public void approvalTabIbmGuiClicked() throws Throwable
	{
	 try{
		ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
		
		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approvalTabIbmGui, "approvalTabIbmGui clicked");
		
		Extent_Reporting.Log_report_img("approvalTabIbmGui clicked", "approvalTabIbmGui clicked",driver, test);
		Extent_Reporting.Log_Pass("approvalTabIbmGui clicked", "approvalTabIbmGui clicked", test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("approvalTabIbmGui clicked", "approvalTabIbmGui clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for verifying dataForApprovalScreen
	 * @throws Throwable
	 */
	public void dataForApprovalScreen() throws Throwable
	{
	 try{
		 ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
		
		action.isElementDisplayed(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approvalSectionScreenIBMGui, "approvalSectionScreenIBMGui");
		
		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approveRadioBtnIbmGui, "approveRadioBtnIbmGui clicked");
		
		Extent_Reporting.Log_report_img("dataForApprovalScreen is Completed.", "dataForApprovalScreen is Completed.",driver, test);
		Extent_Reporting.Log_Pass("dataForApprovalScreen is Completed.", "dataForApprovalScreen is Completed.", test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("dataForApprovalScreen is not Completed.", "dataForApprovalScreen is not Completed.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for submitApprovalIbmGui clicked.
	 * @throws Throwable
	 */
	public void submitApprovalIbmGuiClick() throws Throwable
	{
	 try{
		ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);

		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.submitApprovalIbmGui, "submitApprovalIbmGui clicked.");
		
		Extent_Reporting.Log_report_img("submitApprovalIbmGui clicked.", "submitApprovalIbmGui clicked.",driver, test);
		Extent_Reporting.Log_Pass("submitApprovalIbmGui clicked.", "submitApprovalIbmGui clicked.", test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("submitApprovalIbmGui not clicked.", "submitApprovalIbmGui not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	
	
	/**
	 * This method is for verifying iBMApprovedStatusOfQuoteCheck.
	 * @throws Throwable
	 */
	public void iBMApprovedStatusOfQuoteCheck()  throws Exception{
		try
	{
		ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
			
		action.isElementDisplayed(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.iBMApprovedStatus, "iBMApprovedStatus is displayed.");
		
		Extent_Reporting.Log_report_img("iBMApprovedStatus is displayed.", "iBMApprovedStatus is displayed.",driver, test);
		Extent_Reporting.Log_Pass("iBMApprovedStatus is displayed.", "iBMApprovedStatus is displayed.", test);
		
	}catch (Exception e) {
 		Extent_Reporting.Log_Fail("iBMApprovedStatus is not displayed.", "iBMApprovedStatus is not displayed.", driver, test);
		System.out.println(e.getMessage().toString());
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
	}
		
	}
	/**
	 * This method is for searchQuoteButtonClicked
	 * @throws Throwable
	 */
	@SuppressWarnings("static-access")
	public void enterQuoteId() throws Throwable
	{
	 try{
		ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
		ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
		
		Thread.sleep(5000);
		//action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.enterQuoteid, "enterQuoteid");
		
		driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).click();		
		driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).clear();
		Thread.sleep(2000);	
		driver.findElement(By.xpath(ePricerUpdateAQuotePageObjects.enterQuoteid)).sendKeys(ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteId);
	
		//Extent_Reporting.Log_report_img("Quoteid entered.", "Quoteid entered.", driver, test);
		Thread.sleep(5000);	
		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.multicheckBox, "multicheckBox clicked.");
		
		Extent_Reporting.Log_Pass("Quoteid entered and multicheckBox clicked.", "Quoteid entered and multicheckBox clicked.", test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("Quoteid not entered and multicheckBox not clicked.", "Quoteid not entered and multicheckBox not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for searchQuoteButtonClicked
	 * @throws Throwable
	 */
	public void searchQuoteIdButtonClicked() throws Throwable
	{
	 try{
		ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
		action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.searchQuoteButton);
		List<WebElement> e = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.searchQuoteButton));
		for(int i=0;i<=5;i++)
		{
		      if(i==1){
		    	  e.get(i).click();
		    	   Extent_Reporting.Log_report_img("searchQuoteButton clicked", "searchQuoteButton clicked",driver, test);
		    	   Extent_Reporting.Log_Pass("search Quote Button clicked.", "search Quote Button clicked.", test);
		    	   break;
		      }
		}
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("search Quote Button not clicked.", "search Quote Button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for searchQuoteButtonClicked
	 * @throws Throwable
	 */
	public void searchQuoteIdButtonClickedForDuplicateQuote() throws Throwable
	{
	 try{
		ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
		ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
		ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);
		
		action.waitForElementVisible(driver, ePricerUpdateAQuotePageObjects.searchQuoteButton);
		action.isElementDisplayed(driver, ePricerUpdateAQuotePageObjects.searchQuoteButton, "searchQuoteButton");
		
		List<WebElement> e = driver.findElements(By.xpath(ePricerUpdateAQuotePageObjects.searchQuoteButton));
		for(int i=0;i<=5;i++)
		{
		      if(i==2){
		    	  e.get(i).click();
		    	   Extent_Reporting.Log_report_img("searchQuoteButton clicked", "searchQuoteButton clicked",driver, test);
		    	   Extent_Reporting.Log_Pass("search Quote Button clicked.", "search Quote Button clicked.", test);
		    	   break;
		      }
		}
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("search Quote Button not clicked.", "search Quote Button not clicked.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for quoteIdLinkPresent
	 * @throws Throwable
	 */
	public void quoteIdLinkPresent() throws Throwable
	{
	 try{
		//String quoteIdLinkCheckbox = "//*[contains(text(),"+Excel_Handling.Get_Data(TC_ID, "EnterQuoteid")+")]/preceding::input[@title='Check Box']";
		EpricerApplicationSearchQuotePageObjects = new Epricer_Application_PCS_SearchQuote_PageObjects(driver,TC_ID);
		action.waitForElementVisible(driver, EpricerApplicationSearchQuotePageObjects.searchedresult);

		boolean resultdisplayed;
		resultdisplayed = action.isElementDisplayed(driver, EpricerApplicationSearchQuotePageObjects.searchedresult,"searched result");

		if (resultdisplayed) {
			action.Clickbtn(driver, EpricerApplicationSearchQuotePageObjects.searchedresult,"searched result clicked");
		}
		
		Extent_Reporting.Log_Pass("quoteIdLinkCheckbox clicked", "quoteIdLinkCheckbox clicked", test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteIdLinkCheckbox not clicked", "quoteIdLinkCheckbox not clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for duplicatingQuoteGoBtnClicked
	 * @throws Throwable
	 */
	public void duplicatingQuoteGoBtnClicked() throws Throwable
	{
	 try{
		ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
		
		action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.quoteActionDD);
		action.selectDropBoxValuebyVisibleTextwithoutClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.quoteActionDD,Excel_Handling.Get_Data(TC_ID, "QuoteActionDD"), "Select Quote action Criteria Selected");
		
		action.isElementDisplayed(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.duplicatingQuoteGoBtn , "duplicatingQuoteGoBtn is present.");
		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.duplicatingQuoteGoBtn , "duplicatingQuoteGoBtn clicked");
		
		Extent_Reporting.Log_report_img("duplicatingQuoteGoBtn clicked", "duplicatingQuoteGoBtn clicked",driver, test);
		Extent_Reporting.Log_Pass("duplicatingQuoteGoBtn clicked", "duplicatingQuoteGoBtn clicked", test);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("duplicatingQuoteGoBtn not clicked", "duplicatingQuoteGoBtn not clicked", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	
	/**
	 * This method is for duplicateQouteIdFetched
	 * @throws Throwable
	 */
	public void duplicateQuoteIdFetched() throws Throwable
	{
	 try{
		ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);
		driver.switchTo().parentFrame();
		List<WebElement> e = driver.findElements(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.quoteId));
		for(int i=0;i<=10;i++)
		{
		      if(i==0){
		    	  	duplicateQuoteId = e.get(i).getText();
		    	  	Extent_Reporting.Log_report_img("duplicateQouteId Fetched.", "duplicateQouteId Fetched.", driver, test);
		  			Extent_Reporting.Log_Pass("duplicateQouteId Fetched.", "duplicateQouteId Fetched.", test);
		  			break;
		      }
		}
		System.out.println(duplicateQuoteId);
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("duplicateQouteId not Fetched.", "duplicateQouteId not Fetched.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for duplicateQouteIdCheck
	 * @throws Throwable
	 */
	@SuppressWarnings("static-access")
	public void duplicateQuoteIdCheck() throws Throwable
	{
	 try{
		ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);
		
		      if(duplicateQuoteId != ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteId){
		    	  
		    	  	Extent_Reporting.Log_report_img("duplicateQouteId and quoteId are different.", "duplicateQouteId and quoteId are different.", driver, test);
		  			Extent_Reporting.Log_Pass("duplicateQouteId and quoteId are different.", "duplicateQouteId and quoteId are different.", test);
		      }
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("duplicateQouteId and quoteId are not different.", "duplicateQouteId and quoteId are not different.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	
	/**
	 * This method is for verifying detailsPricingClick.
	 * @throws Throwable
	 */
	public void detailsPricingClick()  throws Throwable{
		try
	{
		ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
		action.isElementDisplayed(driver, ePricerCreateAQuotePageObjects.detailsPricingPolygon, "detailsPricingPolygon is clicked.");
		Thread.sleep(4000);
		
		action.Clickbtn(driver, ePricerCreateAQuotePageObjects.detailsPricingPolygon, "detailsPricingPolygon is clicked.");
		
		Extent_Reporting.Log_report_img("detailsPricingPolygon is clicked.", "detailsPricingPolygon is clicked.",driver, test);
		Extent_Reporting.Log_Pass("detailsPricingPolygon is clicked.", "detailsPricingPolygon is clicked.", test);
		
	}catch (Exception e) {
		Extent_Reporting.Log_Fail("detailsPricingPolygon not clicked.", "detailsPricingPolygon not clicked.", driver, test);
		System.out.println(e.getMessage().toString());
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
	}
		
	}
	
	
	/**
	 * This method is for verifying iBMGuiOpened.
	 * @throws Throwable
	 */
	
	public void iBMGuiOpened()  throws Throwable{
		try
	{
		ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(driver, TC_ID);
		ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
		nAIBMCreateAQuotePageObjects = new Epricer_Application_NAIBM_CreateAQuote_PageObjects(driver, TC_ID);
		Thread.sleep(8000);
		driver.switchTo().frame("ui-tinymce-0_ifr");		
		action.inputText(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.mailBody, Excel_Handling.Get_Data(TC_ID, "commentSection"), "commentSection");
		driver.switchTo().parentFrame();
		Thread.sleep(8000);
		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.removeFromHoldRadioBtn, "removeFromHoldRadioBtn");
		Extent_Reporting.Log_Pass("removeFromHoldRadioBtn clicked.", "removeFromHoldRadioBtn clicked.", test);
		
		Thread.sleep(8000);
		action.Javascriptexecutor_forClick(driver, ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.commentsStatusApplyBtn, "commentsStatusApplyBtn");
		Extent_Reporting.Log_Pass("commentsStatusApplyBtn clicked.", "commentsStatusApplyBtn clicked.", test);
		Thread.sleep(8000);
		//action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.pricingTabIbmGui);
		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.pricingTabIbmGui, "pricingTabIbmGui clicked");
		Extent_Reporting.Log_Pass("pricingTabIbmGui clicked.", "pricingTabIbmGui clicked.", test);
		
		Thread.sleep(15000);
		//action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approvalTabIbmGui);
		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approvalTabIbmGui, "approvalTabIbmGui clicked");
		Extent_Reporting.Log_Pass("approvalTabIbmGui clicked.", "approvalTabIbmGui clicked.", test);
		
		action.waitForPageToLoad(driver);
		Thread.sleep(30000);
		if (action.CheckifExist(driver, nAIBMCreateAQuotePageObjects.specialBidCode)) {
			action.selectDropBoxByVisibleText(driver, nAIBMCreateAQuotePageObjects.specialBidCode,"SDE2,GEO Specific Exemptions", "specialBidCode");
		}			
		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.approveRadioBtnIbmGui, "approveRadioBtnIbmGui clicked");
		Extent_Reporting.Log_Pass("approveRadioBtnIbmGui clicked.", "approveRadioBtnIbmGui clicked.", test);
				
		action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.submitApprovalIbmGui, "submitApprovalIbmGui clicked");
		Extent_Reporting.Log_Pass("submitApprovalIbmGui is clicked", "submitApprovalIbmGui is clicked", test);
		
        // do assert the elements in the new window
        // and then close the new window
		Extent_Reporting.Log_Pass("iBMGui Closed.", "iBMGui Closed.", test);
		
	}catch (Exception e) {
		Extent_Reporting.Log_Fail("iBMGui not Opened", "iBMGui not Opened", driver, test);
		System.out.println(e.getMessage().toString());
		driver.quit();
		e.printStackTrace();
		throw new Exception("Failed");
		}
		
	}

	public void deleteOneCFRAndComponent() throws Throwable {
		try {			
			ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
			Thread.sleep(5000);
			action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.firstCompCheckBox);
			action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.firstCompCheckBox, "firstCompCheckBox clicked");
			action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.firstCFRCheckBox);
			action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.firstCFRCheckBox, "firstCFRCheckBox clicked");
			Thread.sleep(8000);
			action.Javascriptexecutor_forClick(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.deleteItemButton, "deleteItemButton clicked");
			
			Extent_Reporting.Log_Pass("deleteOneCFRAndComponent pass", "deleteOneCFRAndComponent Passed", test);
			

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			Extent_Reporting.Log_Fail("deleteOneCFRAndComponent failed", "deleteOneCFRAndComponent failed", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}

	public void manageCofigTabClick() throws Exception {
		try{
			ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
			action.waitForElementClickable(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.manageConfigurationPolygon);
			Thread.sleep(10000);
			action.Clickbtn(driver, ePricerDuplicateSBOQuoteAcceptAsVSPageObjects.manageConfigurationPolygon, "manageConfigurationPolygon clicked");
			Extent_Reporting.Log_Pass("Manage Config clicked", "Manage Config clicked", test);
			Extent_Reporting.Log_report_img("Manage Config clicked", driver, test);
		} catch (Throwable e) {
			Extent_Reporting.Log_Fail("manageCofigTabClick is not Present.", "manageCofigTabClick is not Present.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");		}
		
	}
	
	/**
	 * This method is for duplicate quoteIdPresentOnMyQuotesScreenAfterSubmit
	 * 
	 * @throws Throwable
	 */
	public void duplicateQuoteIdPresentOnMyQuotesScreenAfterSubmit() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);

			Thread.sleep(2000);
//			if(duplicateQuoteId!=null) {
//			String quoteIdXpath = "//*[contains(text(),'" + duplicateQuoteId + "')]";
//			boolean quoteIdXpathPresent = action.checkElementClickableFluent(driver, quoteIdXpath, "quoteIdXpath");
//			//action.waitForElementClickable(driver, quoteId);
//			
//			//if (action.isTextPresent(driver, quoteId)) {
//			if (quoteIdXpathPresent) {
//				Extent_Reporting.Log_report_img("duplicateQuoteId Created is Present.", "duplicateQuoteId Created is Present.", driver, test);
//				Extent_Reporting.Log_Pass("duplicateQuoteId Created is Present.", "duplicateQuoteId Created is Present.", test);
//			}
//		}else {
//			Extent_Reporting.Log_Fail("duplicateQuoteId is Null.", "duplicateQuoteId is Null.", driver, test);
//			//driver.quit();
//			throw new Exception("Failed");
//	}
		} catch (Exception e) {
			Extent_Reporting.Log_Fail("duplicateQuoteId Created is not Present.", "duplicateQuoteId Created is not Present.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}
	
	/**
	 * This method is for verifying iBMGuiOpenedToSubmitDuplicateQuote.
	 * 
	 * @throws Throwable
	 */
	@SuppressWarnings("static-access")
	public void iBMGuiOpenedToSubmitDuplicateQuote() throws Throwable {
		try {
			ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(
					driver, TC_ID);
			ePricerUpdateAQuotePageObjects = new Epricer_Application_UpdateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_BusinessLogic(driver, TC_ID, test);
			ePricerCreateASBOQuoteIncompleteItAndReSubmitASBOBBusinessLogic = new Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_ReSubmit_A_SBO_BusinessLogic(driver, TC_ID, test);
		
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.pricingTabIbmGui, "pricingTabIbmGui");
			Extent_Reporting.Log_Pass("pricingTabIbmGui is Clicked", "pricingTabIbmGui is Clicked", test);
						
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.pricesOnPricing,"pricesOnPricing");
			Extent_Reporting.Log_Pass("pricesOnPricing Clicked", "pricesOnPricing Clicked", test);
						
			action.waitForPageToLoad(driver);
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.showMarginCalculationLink, "showMarginCalculationLink");
			Extent_Reporting.Log_Pass("showMarginCalculationLink is displayed", "showMarginCalculationLink is displayed", test);
			
			action.Javascriptexecutor_forClick(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.bPInformationTab,"bPInformationTab");
			Extent_Reporting.Log_Pass("bPInformationTab Clicked.", "bPInformationTab Clicked.", test);
			
			
			List<WebElement> e1 = driver.findElements(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.generalInformationTitle));
			if(e1.size()>1) {
				for(int i=0;i<=5;i++)
				{
					if(i==1){
						Thread.sleep(2000);
						e1.get(i).isDisplayed();
						Extent_Reporting.Log_Pass("generalInformationTitle displayed.", "generalInformationTitle displayed.", test);
						Extent_Reporting.Log_report_img("generalInformationTitle displayed.", "generalInformationTitle displayed.",driver, test);
						break;
					}
				}
			}else {
				Extent_Reporting.Log_Fail("generalInformationTitle displayed.", "generalInformationTitle displayed.", driver, test);
				driver.quit();
				throw new Exception("Failed");
			}
			
				if(action.isElementDisplayed(driver,ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.endUserPriceAndEndUserDiscount,"endUserPriceAndEndUserDiscount")) {
					List<WebElement> e4 = driver.findElements(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.endUserPriceAndEndUserDiscount));
					for(int i=0;i<=5;i++)
					{
						if(i==0){
							String endUserPrice = e4.get(i).getText();
							if(endUserPrice.equalsIgnoreCase(ePricerCreateASBOQuoteIncompleteItAndReSubmitASBOBBusinessLogic.requestedEndUserPrice)) {
								Extent_Reporting.Log_report_img("requestedEndUserPrice is equal on BP and IBM side.", "requestedEndUserPrice is equal on BP and IBM side.", driver, test);
								Extent_Reporting.Log_Pass("requestedEndUserPrice is equal on BP and IBM side.", "requestedEndUserPrice is equal on BP and IBM side.", test);
								break;
							}
						} 
					}
				}else {
					Extent_Reporting.Log_Fail("requestedEndUserPrice is not displayed", "requestedEndUserPrice is not displayed", driver, test);
					driver.quit();
					throw new Exception("Failed");
				}
				
		      WebElement e8 = driver.findElement(By.xpath(ePricerCreateASBOQuoteIncompleteItAndAcceptPageObjects.endUserDis));
		      String endUserDiscount = e8.getText();
		      String discountString = ePricerCreateASBOQuoteIncompleteItAndReSubmitASBOBBusinessLogic.requestedEndUserDiscount;
		      String finaldiscoundString = discountString.concat(".00");
		      System.out.println(discountString);
		      if(endUserDiscount.equals(finaldiscoundString)) {
		    	  Extent_Reporting.Log_report_img("requestedEndUserDiscount is equal on BP and IBM side.", "requestedEndUserDiscount is equal on BP and IBM side.", driver, test);
		    	  Extent_Reporting.Log_Pass("requestedEndUserDiscount is equal on BP and IBM side.", "requestedEndUserDiscount is equal on BP and IBM side.", test);
		      }else {
		    	  Extent_Reporting.Log_Fail("requestedEndUserDiscount is not equal on BP and IBM side.", "requestedEndUserDiscount is not equal on BP and IBM side.", driver, test);
		    	  driver.quit();
				  throw new Exception("Failed");
		      }
		      
		//	driver.close();

			Extent_Reporting.Log_Pass("iBMGui Closed.", "iBMGui Closed.", test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("iBMGui not Opened", "iBMGui not Opened", driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}
	
	/**
	 * This method is for submittedToDistributorQuoteIdLinkPresent
	 * @throws Throwable
	 */
	public void submittedToDistributorQuoteIdLinkPresent() throws Throwable
	{
	 try{
		 ePricerDuplicateSBOQuoteAcceptAsVSPageObjects = new Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(driver, TC_ID);
		
		@SuppressWarnings("static-access")
		String quoteIdLink = "//*[contains(text(),"+ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteId+")]";
		@SuppressWarnings("static-access")
		String submittedToDistributor = "//*[contains(text(),"+ePricerCreateASBOQuoteIncompleteItAndAcceptBusinessLogic.quoteId+")]/following::span[contains(text(),'Submitted to distributor')]";
		
		//*[contains(text(),"4170263")]/following::span[contains(text(),"Submitted to distributor")]
		if(quoteIdLink != null && submittedToDistributor !=null) {
			action.acceptAlert(driver);
			Extent_Reporting.Log_report_img("quoteIdLink and submittedToDistributor present.", "quoteIdLink and submittedToDistributor present.",driver, test);
			Extent_Reporting.Log_Pass("quoteIdLink and submittedToDistributor present.", "quoteIdLink and submittedToDistributor present.", test);
		}else{
			Extent_Reporting.Log_Fail("quoteIdLink and submittedToDistributor is not present.", "quoteIdLink and submittedToDistributor is not present.", driver, test);
			driver.quit();
			throw new Exception("Failed");
		}
	}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("quoteIdLink and submittedToDistributor is not present.", "quoteIdLink and submittedToDistributor is not present.", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
	}

	public void addCrad() throws Exception {
		try {
			ePricerEMEAIBMCreateAQuotePageObjects = new Epricer_Application_EMEAIBM_CreateAQuote_PageObjects(driver, TC_ID);
			ePricerCreateAQuotePageObjects = new Epricer_Application_CreateAQuote_PageObjects(driver, TC_ID);
			if (action.CheckifExist(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD)) {
				Calendar c = Calendar.getInstance();
				c.add(Calendar.MONTH, 1);
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");  
				String strDate= formatter.format(c.getTime());
				action.inputText(driver, ePricerEMEAIBMCreateAQuotePageObjects.cRAD, strDate, "crad");
				Thread.sleep(10000);
				action.Javascriptexecutor_forClick(driver, ePricerCreateAQuotePageObjects.saveOverviewButton,"saveOverviewButton");		
				Thread.sleep(20000);
				List<WebElement> e = driver.findElements(By.xpath(ePricerCreateAQuotePageObjects.saveOverviewButton));

				for (int i = 0; i <= 14; i++) {
					if (i == 1) {
						e.get(i).click();
						Extent_Reporting.Log_Pass("save btn clicked.", "save btn clicked.",  test);
						break;
					}
				}
			} else {
				Extent_Reporting.Log_Pass("Crad doesn't exist.", "Crad doesn't exist.",  test);
			}
			

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("Add crad failed", "Add crad failed", driver, test);
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}
		
	}
}



