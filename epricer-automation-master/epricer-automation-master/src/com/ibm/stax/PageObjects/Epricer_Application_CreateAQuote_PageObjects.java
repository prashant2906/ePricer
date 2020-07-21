/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_CreateAQuote_PageObjects {

	ElementAction action = new ElementAction();

	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml")
			.getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath();

	public WebDriver driver;
	public String TC_ID;

	public String createANewQuoteLink = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "CreateANewQuoteLink");
	
	//public String bidType = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "bidType");
	public String overviewPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "OverviewPolygon");
	public String selectCountry = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectCountry");
	public String selectCountryDropDown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectCountryDropDown");
	public String quoteTitle = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteTitle");
	public String selectBidType = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectBidType");
	public String saveOverviewButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveOverviewButton");

	public String manageConfigurationPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ManageConfigurationPolygon");
	public String addProductManuallyButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddProductManuallyButton");

	public String selectCategorySelected = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectCategorySelected");
	public String typeModelField1 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TypeModelField1");
	public String typeModelField2 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TypeModelField2");
	public String componentQuantity = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ComponentQuantity");
	public String addAndCloseButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddAndCloseButton");
	public String addButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddButton");
	public String componentAddedSuccessMsg = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ComponentAddedSuccessMsg");

	public String collectPricingButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CollectPricingButton");
	public String pricingValue = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PricingValue");

	public String registrationCustomerPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RegistrationCustomerPolygon");
	public String registrationNumber = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RegistrationNumber");
	
	public String searchCustomer = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchCustomer");
	public String searchCustomerSelected = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchCustomerSelected");
	public String searchCustomerName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchCustomerName");
	public String searchCustomerButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchCustomerButton");
	public String searchCustomerNumber = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CustomerNumber");
	public String finalSelectCustomer = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "FinalSelectCustomer");
	public String CEID = new Common_Functions().GetXMLTagValue(xmlLocatorsPath,"CEID");
	public String BPCompanyName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "BPCompanyName");
	public String PCS_BPCompanyName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCS_BPCompanyName");
	// public String SaveContinueButton = new
	// Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveContinueButton");
	public String retrieveButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RetrieveButton");

	public String detailsPricingPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DetailsPricingPolygon");
	public String previewValueSellerOfferButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PreviewValueSellerOfferButton");

	public String iBMBusinessPartnerValueSellerScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath,"IBMBusinessPartnerValueSellerScreen");
	public String closeIBMBusinessPartnerValueSellerScreenBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath,"CloseIBMBusinessPartnerValueSellerScreenBtn");

	public String searchQuote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuote");
	public String searchButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchButton");

	public String listPriceTotalValue = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ListPriceTotalValue");
	public String acceptValueSellerOfferButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AcceptValueSellerOfferButton");

	public String searchField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchField");

	public String viewQuoteDataTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ViewQuoteDataTab");
	public String valueSellerApprovedStatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ValueSellerApprovedStatus");

	public String selectQuoteCheckBox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectQuoteCheckBox");

	public String quoteDetailHeading = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteDetailHeading");
	public String registrationHeading = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RegistrationHeading");
	public String endUserCustomerHeading = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EndUserCustomerHeading");
	public String channelInformationHeading = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ChannelInformationHeading");
	public String productsAndPricesHeading = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ProductsAndPricesHeading");
	public String requestPriceExceptionCheckBox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequestPriceeExceptionChkbox");
	public String submitPriceRequest = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SubmitPriceRequestBtn");

	public String addendumTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddendumTab");
	public String brandTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "BrandTab");

	public String editAddendumButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EditAddendumButton");
	public String brandCheckbox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "BrandCheckbox");

	public String goButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "GoButton");
	public String checkBox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MulticheckBox");

	public String quoteActions = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteActionsDropDown");

	public String cancelAndCloseButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CancelAndCloseButton");
	public String cancelAndCloseButton2 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CancelAndCloseButton2");

	public String sendAddendumButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SendAddendumButton");
	public String sendValueSellerAddendumScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SendValueSellerAddendumScreen");
	public String addToListMailId = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddToListMailId");
	public String sendMailButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SendMailButton");
	public String mailBody = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MailBody");

	public String justificationTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "JustificationAttachmentsTab");
	public String justificationComment = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CommentsSection");
	public String returnToRequester = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ReturnToRequestor");
	public String commentsSection = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CommentsSection");
	public String returnToDistributorButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ReturnToDistributorButton");
	public String Countryonoverview = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Countryonoverview");
	public String bidtypeonoverview = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "bidtypeonoverview");
	public String PCSregistrationNumber = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSRegistrationNumber");
	public String PCSretrieveButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSRetrieveButton");
	public String PCSSearchcustomer = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSearchcustomer");
	public String PCSSearchcustomerid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSearchcustomerid");
	public String PCSSearchcustomersearchbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSearchcustomersearchbutton");
	public String PCSSavecustomerbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSavecustomerbutton");
	
	public String PCSBPContactName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSBPContactName");
	public String PCSBPContactEmail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSBPContactEmail");
	
	public String PCSAcceptVSbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSAcceptVSbutton");
	public String PCSSaveContinueREG = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSaveContinueREG");
	public String SaveContinueREG = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveContinueREG");
	
	public String DecisionMakerName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DecisionMakerName");
	public String DecisionMakerEmail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DecisionMakerEmail");
	public String DecisionMakerTitle = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DecisionMakerTitle");
	public String ProjectName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ProjectName");
	public String Name = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Name");
	public String Phonenumber = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Phonenumber");
	public String PCS_ContactEmail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCS_ContactEmail");
	public String PCS_SubmitButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCS_SubmitButton"); 
	public String PCS_discount = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCS_discount");
	
	public  String PCSManageconfigurationTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSmanageconfigurationtab");
	
	public String addBTN = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddBTN"); 
	public String closeBTN = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CloseBTN");
	
	
	public String PSATofferdropdown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATofferdropdown"); 
	public String PSATapplyoffer = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATapplyoffer");
	
	public String PSATDisablecliplevelcheck = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATDisablecliplevelcheck"); 
	public String PSATSubmitpricerequestbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATSubmitpricerequestbutton");
	public String PSATrequestexceptioncheckbox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATrequestexceptioncheckbox");

	public String PSATdiscountinputtext = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATdiscountinputtext");
	public String PSATdiscountapplybutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATdiscountapplybutton");
	public String PSATchannelinfoname = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATchannelinfoname");
	public String PSATchannelinfophone = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATchannelinfophone");
	public String PSATchannelinfoemail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATchannelinfoemail");
	public String PSATrequestsubmitbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATrequestsubmitbutton");

	public  String PCSGetquoteid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSgetquoteid");
	
	public  String PSATCustomersearchbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATCustomersearchbutton");
	public  String PSATCustomernamedropdown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATCustomernamedropdown");
	public  String PSATCustomernameinput = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATCustomernameinput");
	public  String PSATCustomersearchcustomerbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATCustomersearchcustomerbutton");
	public  String PSATCustomerfirstrecord = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATCustomerfirstrecord");
	public  String PSATCustomerretrievebutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATCustomerretrievebutton");
	
	
	public  String PSATCustomercontirnuebutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATCustomercontirnuebutton");
	public  String PSATlogout = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATlogout");
	public  String PSATclosecurrentquote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATclosecurrentquote");
	public  String psatmyquoterefinebyquotestatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "psatmyquoterefinebyquotestatus");
	
	
	public Epricer_Application_CreateAQuote_PageObjects(WebDriver d, String tcId) {

		this.driver = d;
		this.TC_ID = tcId;
	}
}
