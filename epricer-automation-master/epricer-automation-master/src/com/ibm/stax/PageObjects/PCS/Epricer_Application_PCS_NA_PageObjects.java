/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.PageObjects.PCS;
 
import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_PCS_NA_PageObjects {



	ElementAction action = new ElementAction();
	// Common_Functions Function = new Common_Functions();
	// private String xmlLocatorsPath =
	// Constants.xmlLocatorsPath+"Locators.xml";

	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath();

	public WebDriver driver;
	public String TC_ID;

	//save and continue function
	public String saveOverviewButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "saveOverviewButton");
	//registration screen:
	public String PCSregistrationNumber = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSregistrationNumber");
	public String PCSretrieveButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSretrieveButton");
	public String PCSSearchcustomer = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSearchcustomer");
	public String PCSSearchcustomerid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSearchcustomerid");
	
	public String PCSSearchcustomersearchbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSearchcustomersearchbutton");
	public String PCSSavecustomerbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSavecustomerbutton");
	public String PCS_BPCompanyName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCS_BPCompanyName");
	public String SaveContinueREG = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveContinueREG");
	
	//fill mandatory fields on submit screen
	public String DecisionMakerName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DecisionMakerName");
	public String DecisionMakerEmail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DecisionMakerEmail");
	public String DecisionMakerTitle = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DecisionMakerTitle");
	public String ProjectName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ProjectName");
	public String Name = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Name");
	public String Phonenumber = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Phonenumber");
	public String PCS_ContactEmail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCS_ContactEmail");
	public String PCS_SubmitButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCS_SubmitButton");
	
	//login inot ibm gui
	public String SelectARole = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectARole");
	public String StartButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "StartButton");
	public String iBMGuiScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "iBMGuiScreen");
	
	public String searchQuotesLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "searchQuotesLink");
	public String enterQuoteid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "enterQuoteid");
	public String searchQuoteButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "searchQuoteButton");
	
	public String searchQuoteResultScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "searchQuoteResultScreen");
	public String onHoldStatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "onHoldStatus");
	public String requestPricingStatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "requestPricingStatus");
	public String commentsStatusTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "commentsStatusTab");
	public String commentsStatusScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "commentsStatusScreen");
	
	public String mailBody = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "mailBody");
	public String changeStatusRadioBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "changeStatusRadioBtn");
	public String selectSelectedStatusDD = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "selectSelectedStatusDD");
	public String commentsStatusApplyBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "commentsStatusApplyBtn");
	public String commentsStatusUpdated = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "commentsStatusUpdated");
	public String incompleteStatusOfQuote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "incompleteStatusOfQuote");
	
	//approve from ibm gui
	public String removeFromHoldRadioBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "removeFromHoldRadioBtn");
	public String requestPricingStatusIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "requestPricingStatusIbmGui");
	public String pricingTabIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "pricingTabIbmGui");
	public String approvalTabIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "approvalTabIbmGui");
	
	public String approvalSectionScreenIBMGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "approvalSectionScreenIBMGui");
	public String approveRadioBtnIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "approveRadioBtnIbmGui");
	public String submitApprovalIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "submitApprovalIbmGui");
	public String iBMApprovedStatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "iBMApprovedStatus");
	
	
	
	
	
	public Epricer_Application_PCS_NA_PageObjects(WebDriver d, String tcId) {

		this.driver = d;
		this.TC_ID = tcId;
	}
}
