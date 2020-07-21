/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.PageObjects.PCS;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;
 
public class Epricer_Application_PCS_CreateAQuote_PageObjects {



	ElementAction action = new ElementAction();
	// Common_Functions Function = new Common_Functions();
	// private String xmlLocatorsPath =
	// Constants.xmlLocatorsPath+"Locators.xml";

	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml")
			.getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath();

	public WebDriver driver;
	public String TC_ID;

	public String createANewQuoteLink = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "CreateANewQuoteLink");

	public String overviewPolygon = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "OverviewPolygon");
	public String selectCountry = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SelectCountry");

	public String quoteTitle = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "QuoteTitle");
	public String selectBidType = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SelectBidType");
	public String saveOverviewButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SaveOverviewButton");

	public String manageConfigurationPolygon = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "ManageConfigurationPolygon");
	public String addProductManuallyButton = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "AddProductManuallyButton");

	public String selectCategorySelected = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "SelectCategorySelected");
	public String typeModelField1 = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "TypeModelField1");
	public String typeModelField2 = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "TypeModelField2");
	public String componentQuantity = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "ComponentQuantity");
	public String addAndCloseButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "AddAndCloseButton");
	public String componentAddedSuccessMsg = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "ComponentAddedSuccessMsg");

	public String collectPricingButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "CollectPricingButton");
	public String pricingValue = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PricingValue");

	public String registrationCustomerPolygon = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "RegistrationCustomerPolygon");
	public String registrationNumber = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "RegistrationNumber");
	public String searchCustomer = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SearchCustomer");
	public String searchCustomerSelected = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "SearchCustomerSelected");
	public String searchCustomerName = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SearchCustomerName");
	public String searchCustomerButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SearchCustomerButton");
	public String searchCustomerNumber = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "CustomerNumber");
	public String finalSelectCustomer = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "FinalSelectCustomer");
	public String CEID = new Common_Functions().GetXMLTagValue(xmlLocatorsPath,
			"CEID");
	public String BPCompanyName = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "BPCompanyName");
	public String PCS_BPCompanyName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCS_BPCompanyName");
	// public String SaveContinueButton = new
	// Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveContinueButton");
	public String retrieveButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "RetrieveButton");

	public String detailsPricingPolygon = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "DetailsPricingPolygon");
	public String previewValueSellerOfferButton = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "PreviewValueSellerOfferButton");

	public String iBMBusinessPartnerValueSellerScreen = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath,
					"IBMBusinessPartnerValueSellerScreen");
	public String closeIBMBusinessPartnerValueSellerScreenBtn = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath,
					"CloseIBMBusinessPartnerValueSellerScreenBtn");

	public String searchQuote = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SearchQuote");
	public String searchButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SearchButton");

	public String listPriceTotalValue = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "ListPriceTotalValue");
	public String acceptValueSellerOfferButton = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "AcceptValueSellerOfferButton");

	public String searchField = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SearchField");

	public String viewQuoteDataTab = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "ViewQuoteDataTab");
	public String valueSellerApprovedStatus = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "ValueSellerApprovedStatus");

	public String selectQuoteCheckBox = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SelectQuoteCheckBox");

	public String quoteDetailHeading = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "QuoteDetailHeading");
	public String registrationHeading = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "RegistrationHeading");
	public String endUserCustomerHeading = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "EndUserCustomerHeading");
	public String channelInformationHeading = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "ChannelInformationHeading");
	public String productsAndPricesHeading = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "ProductsAndPricesHeading");
	public String requestPriceExceptionCheckBox = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "RequestPriceeExceptionChkbox");
	public String submitPriceRequest = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SubmitPriceRequestBtn");

	public String addendumTab = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "AddendumTab");
	public String brandTab = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "BrandTab");

	public String editAddendumButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "EditAddendumButton");
	public String brandCheckbox = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "BrandCheckbox");

	public String goButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "GoButton");
	public String checkBox = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "CheckBox");

	public String quoteActions = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "QuoteActionsDropDown");

	public String cancelAndCloseButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "CancelAndCloseButton");

	public String sendAddendumButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SendAddendumButton");
	public String sendValueSellerAddendumScreen = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "SendValueSellerAddendumScreen");
	public String addToListMailId = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "AddToListMailId");
	public String sendMailButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "SendMailButton");
	public String mailBody = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "MailBody");

	public String justificationTab = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "JustificationAttachmentsTab");
	public String additionalQuestionsTab = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "AdditionalQuestionsTab");
	
	public String justificationComment = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "CommentsSection");
	public String returnToRequester = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "ReturnToRequestor");
	public String commentsSection = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "CommentsSection");
	public String returnToDistributorButton = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "ReturnToDistributorButton");
	public String Countryonoverview = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "Countryonoverview");
	public String bidtypeonoverview = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "bidtypeonoverview");
	public String PCSregistrationNumber = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSRegistrationNumber");
	public String PCSretrieveButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSRetrieveButton");
	public String PCSDRcheckbox = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSDRcheckbox");
	public String PCSDRremovebutton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSDRremovebutton");
	public String PCSSearchcustomer = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSSearchcustomer");
	public String PCSSearchcustomerid = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSSearchcustomerid");
	public String PCSSearchcustomersearchbutton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSSearchcustomersearchbutton");
	public String PCSSavecustomerbutton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSSavecustomerbutton");
	
	public String PCSBPContactName = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSBPContactName");
	public String PCSBPContactEmail = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSBPContactEmail");
	public String PCSBPCompanyName = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSBPCompanyName");
	public String PCSBPCompanyEmail = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSBPCompanyEmail");
	public String PCSAcceptVSbutton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSAcceptVSbutton");
	public String PCSRequestVSbutton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSRequestVSbutton");
	public String PCSSaveContinueREG = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSSaveContinueREG");
	public  String PCSGetquoteid = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSgetquoteid");
	public  String quoteId = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "QuoteId");
	public  String PCSDetailPricingTab = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSdetailpricingtab");
	public  String PCSReturntorequesterButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSreturntorequester");
	
	public  String PCSReturnButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSreturnbutton");
	public  String PCSOverviewTab = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSoverviewtab");
	public  String PCSpricesubmitTab = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSpricesubmittab");
	public  String PCSManageconfigurationTab = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSmanageconfigurationtab");
	
	public  String PCSSaveandcontinueonconfig = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSSaveContinueConfig");
	
	public  String PCSSubmitpricerequest = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSgotosubmitSBquotepage");
	
	public  String PCSDecisionmakername = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSdecisionmakername");
	public  String PCSMakertitle = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSmakertitle");
	public  String PCSDecisionmakeremail = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSdecisionmakeremail");
	public  String PCSProjectname = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSprojectname");
	public  String PCSIBMcontactname = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSIBMcontactname");
	public  String PCSIBMphoneNumber = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSIBMphoneNumber");
	public  String PCSIBMenterContactEmail = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSIBMenterContactEmail");
	public  String PCSSubmitSBquotebutton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "PCSsubmitSBquotebutton");
	
	
	public Epricer_Application_PCS_CreateAQuote_PageObjects(WebDriver d, String tcId) {

		this.driver = d;
		this.TC_ID = tcId;
	}
}
