/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects {
	
	ElementAction action=new ElementAction();
	//Common_Functions Function = new Common_Functions();
	//private String xmlLocatorsPath = Constants.xmlLocatorsPath+"Locators.xml";
	
	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath(); 
	
	
	public WebDriver driver;
	public String TC_ID;	
	
	public String requestPriceeExceptionChkbox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequestPriceeExceptionChkbox");
	public String submitPriceRequestBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SubmitPriceRequestBtn");
	
	public String submitPriceRequestScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SubmitPriceRequestScreen");
	public String generalInfoTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "GeneralInfoTab");
	public String iBMChannelInfoTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMChannelInfoTab");
	public String requestPricingTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequestPricingTab");
	public String requestedEndUserDiscount = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequestedEndUserDiscount");
	
	public String applyRequestedEndUserDiscountBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApplyRequestedEndUserDiscountBtn");
	public String justificationAttachmentsTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "JustificationAttachmentsTab");
	public String commentsSection = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CommentsSection");
	
	public String submittodistributor = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SubmitToDistributorBotton");
	public String submitAndSendNotificationBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SubmitAndSendNotificationBtn");
	public String sendNotificationScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SendNotificationScreen");
	public String toEmailID = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ToEmailID");
	public String sendMailBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "sendMailBtn");
	
	public String quoteId = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteId");
	
	public String saveOverviewButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveOverviewButton");
	
	public String uploadFileBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "UploadFileBtn");
	public String uploadCFRBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "UploadCFRBtn");
	public String disableChecksumChkbox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DisableChecksumChkbox");
	public String workWithOtherCountryCFRChkbox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "WorkWithOtherCountryCFRChkbox");
	
	public String downloadThisCFRIcon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DownloadThisCFRIcon");

	public String mailBody = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MailBody");
	public String myQuotesScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MyQuotesScreen");
	
	public String iBMGuiScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMGuiScreen");
	
	public String searchQuoteResultScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuoteResultScreen");
	public String onHoldStatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "OnHoldStatus");
	public String requestPricingStatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequestPricingStatus");
	public String commentsStatusTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CommentsStatusTab");
	public String commentsStatusScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CommentsStatusScreen");
	public String changeStatusRadioBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ChangeStatusRadioBtn");
	public String selectSelectedStatusDD = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectSelectedStatusDD");
	public String commentsStatusApplyBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CommentsStatusApplyBtn");
	public String commentsStatusUpdated = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CommentsStatusUpdated");
	public String incompleteStatusOfQuote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IncompleteStatusOfQuote");
	
	public String commentsTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CommentsTab");
	public String incompleteCommentsHeading = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IncompleteCommentsHeading");
	public String incompleteCommentsOnHeading = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IncompleteCommentsOnHeading");
	public String detailsPricingPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DetailsPricingPolygon");
	
	public String valueSellerApprovedHeading = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ValueSellerApprovedHeading");
	
	public String pricingTabIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PricingTabIbmGui");
	public String approvalTabIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApprovalTabIbmGui");
	public String approvalSectionScreenIBMGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApprovalSectionScreenIBMGui");
	public String approveRadioBtnIbmGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApproveRadioBtnIbmGui");
	
	public String searchQuotesLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuotesLink");
	public String searchCriteriaSelectIBMGui = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchCriteriaSelectIBMGui");

	public String removeFromHoldRadioBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RemoveFromHoldRadioBtn");

	public String pricingTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PricingTabIbmGui");

	public String pricesOnPricing = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PricesOnPricing");
	public String showMarginCalculatoinLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ShowMarginCalculatoinLink");

	public String totalBPMArgin = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TotalBPMargin");
	public String applyBPMargin = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApplyBPMargin");
	
	public String requestedEndUserPrice = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequestedEndUserPrice");
	public String applyBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApplyBtn");
	public String uploadTextFileBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "UploadTextFileBtn");
	public String uploadAllBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "UploadAllBtn");
	public String downloadBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DownloadBtn");
	public String submitPriceRequestBTN = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SubmitPriceRequestBTN");
	public String MaintLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MaintLink");
	public String SelectARole = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectARole");
	public String StartButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "StartButton");
	
	
	public String showMarginCalculationLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ShowMarginCalculationLink");
	public String endUserPrice = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EndUserPrice");
	public String endUserDiscount = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EndUserDiscount");
	public String attachmentsTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AttachmentsTab");
	public String bPInformationTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "BPInformationTab");
	public String generalInformationTitle = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "GeneralInformationTitle");
	public String testFileDownloadBTN = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TestFileDownloadBTN");
	public String testFile = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TestFile");
	public String endUserPriceAndEndUserDiscount = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EndUserPriceAndEndUserDiscount");
	public String endUserDis = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EndDis");
	
	public String DuplicateTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DuplicateTab");
	public String send_to_channel = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "send_to_channel");
	public String send_for_duplicate_review = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "send_for_duplicate_review");
	public String OnHoldDuplicateStatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "OnHoldDuplicateStatus");
	public String Entercustomernameonduplicate = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Entercustomernameonduplicate");
	
	
	public Epricer_Application_Create_A_SBO_Quote_Incomplete_It_And_Accept_PageObjects(WebDriver d,String tcId){
		
		this.driver = d;
		this.TC_ID=tcId;
		}
}

