package com.ibm.stax.PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_UpdateAQuote_PageObjects {
	
	ElementAction action=new ElementAction();
	
	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath(); 
	
	
	public WebDriver driver;
	public String TC_ID;	
	
	public String searchQuotesLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuotesLink");
	public String searchQuotesScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuotesScreen");
	public String searchQuotesIBMGUIScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuotesIBMGUIScreen");
	public String searchCriteriaSelect = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchCriteriaSelect");
	public String enterQuoteid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EnterQuoteid");
	public String searchQuoteButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuoteButton");
	public String searchedQuote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchedQuote");
	
	public String overviewPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "OverviewPolygon");
	
	public String selectBidType = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectBidType");
	public String componentCheckbox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ComponentCheckbox");
	public String quantityUpdate = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuantityUpdate");
	
	public String saveOverviewButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveOverviewButton");
	
	public String uploadFileBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "UploadFileBtn");
	public String uploadCFRBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "UploadCFRBtn");
	public String uploadCFRBtnDEV = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "UploadCFRBtnDEV");

	public String disableChecksumChkbox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DisableChecksumChkbox");
	public String workWithOtherCountryCFRChkbox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "WorkWithOtherCountryCFRChkbox");
	
	public String downloadThisCFRIcon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DownloadThisCFRIcon");
	public String pricingTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PricingTab");
	public String pricesOnPricing = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PricesOnPricing");
	public String showMarginCalculatoinLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ShowMarginCalculatoinLink");
	public String bPInformation = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "BPInformation");
	public String removeFromHold = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RemoveFromHold");
	public String applyButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApplyButton");
	public String tableViewDropDown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TableViewDropDown");
	public String approvedPriceField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApprovedPriceField");
	public String recalculateButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RecalculateButton");
	public String exportButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ExportButton");
	public String reportsLettersTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ReportsLettersTab");	
	public String addendumButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddendumButton");	
	public String reviewersTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ReviewersTab");
	public String quotemanagerchange = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Quotemanagerchange");
	public String addToListButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddToListButton");
	public String saveNSubmitButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveNSubmitButton");	
	public String showSelectedReviewerButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ShowSelectedReviewerButton");
	public String submitOnSubmitPriceRequest = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SubmitOnSubmitPriceRequest");
	public String concurIdRadioButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ConcurIdRadioButton");
	public String downloadAttachmentReviewer = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DownloadAttachmentReviewer");
	public String reviewerReport = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ReviewerReport");
	public String addFeatureBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddFeatureBtn");

	public String submitPriceRequestPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SubmitPriceRequestPolygon");
	
	public Epricer_Application_UpdateAQuote_PageObjects(WebDriver d,String tcId){
		
		this.driver = d;
		this.TC_ID=tcId;
		}
}

