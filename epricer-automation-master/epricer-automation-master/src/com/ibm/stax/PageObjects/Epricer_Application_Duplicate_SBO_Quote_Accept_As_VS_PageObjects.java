/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects {
	
	ElementAction action=new ElementAction();
	
	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath(); 
	
	
	public WebDriver driver;
	public String TC_ID;	
	
	public String removeFromHoldRadioBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RemoveFromHoldRadioBtn");
	public String pricingTabIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PricingTabIbmGui");
	public String approvalTabIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApprovalTabIbmGui");
	public String approvalSectionScreenIBMGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApprovalSectionScreenIBMGui");
	public String approveRadioBtnIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApproveRadioBtnIbmGui");
	public String requestPricingStatusIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequestPricingStatusIbmGui");
	public String submitApprovalIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SubmitApprovalIbmGui");
	public String iBMApprovedStatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMApprovedStatus");
	
	public String multicheckBox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MulticheckBox");
	public String checkBoxForDuplicatingQuote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CheckBoxForDuplicatingQuote");
	public String quoteActionDD = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteActionDD");
	public String duplicatingQuoteGoBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DuplicatingQuoteGoBtn");

	public String firstCompCheckBox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "FirstCompCheckBox");

	public String firstCFRCheckBox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "FirstCFRCheckBox" );

	public String deleteItemButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DeleteItemButton");

	public String manageConfigurationPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ManageConfigurationPolygon");
	
	
	public Epricer_Application_Duplicate_SBO_Quote_Accept_As_VS_PageObjects(WebDriver d,String tcId){
		
		this.driver = d;
		this.TC_ID=tcId;
		}
}

