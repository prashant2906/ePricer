/**
 *  
 *
 */
package com.ibm.stax.PageObjects.IBM;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_IBM_CreateAQuote_PageObjects {

	ElementAction action = new ElementAction();

	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath();

	public WebDriver driver;
	public String TC_ID;
	
	public String ibmEMEACreateQuoteLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMEMEACreateQuoteLink");
	public String requesterPhone = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequesterPhone");
	public String quoteTitleInternal = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteTitleInternal"); //opportunityId
	public String opportunityId = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "OpportunityId");
	public String opportunityOwnerEmail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "OpportunityOwnerEmail");
	public String opportunityOwnerName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "OpportunityOwnerName");
	public String searchForACustomer = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchForACustomer");
	public String ibmMasterCustomerRadio = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMMasterCustomerRadio");
	public String customerSelectionByCompanyName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CustomerSelectionByCompanyName"); 
	public String IBMselectdisplaycritriabutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMselectdisplaycritriabutton");
	public String IBMtabsubmitcancelnotificationduplicate = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabsubmitcancelnotificationduplicate");

	public String searchForName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchForName");//MnageInternaConfigurationPolygon
	public String searchInternalCustomer = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchInternalCustomer");//CustomerSelectionForInternal
	public String customerSelectionForInternal = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CustomerSelectionForInternal");
	public String selectCustomerClick = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectCustomerClick");//CustomerPageSaveAndContinue
	public String customerPageSaveAndContinue = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CustomerPageSaveAndContinue");//searchForName
	public String mnageInternaConfigurationPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MnageInternaConfigurationPolygon");//DisableChecksum
	public String disableChecksum = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DisableChecksum");//WorkWithOtherCountryCFR
	public String workWithOtherCountryCFR = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "WorkWithOtherCountryCFR");//ConfigurationSaveButton
	public String configurationSaveButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ConfigurationSaveButton");//PricingPrices
	public String pricingPrices = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PricingPrices");
	public String pricingCheckBoxClick = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PricingCheckBoxClick");//QuickApplyButton
	public String quickApplyButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuickApplyButton");
	public String approveDiscountField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApproveDiscountField");
	public String applyAfterDiscount = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApplyAfterDiscount");//ApplyAfterDiscount
	public String RecalculateButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RecalculateButton");//TSSCheckBOX
	public String requestApproval = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequestApproval");
	
	public String newCustomerToIBM = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "NewCustomerToIBM");
	public String endUserCustomerName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EndUserCustomerName");
	public String enterEmailAddress = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EnterEmailAddress");
	public String addToButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddToButton");
	public String sendEmailButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SendEmailButton");
	public String quoteIdIBM = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteIdIBM");
	public String quickApplyField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuickApplyField");
	public String selectChannelIndicatorDropDown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectChannelIndicatorDropDown");
	public String selectSolutionType = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectSolutionType");
	public String pricingPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PricingPolygon");
	public String quickApplyPriceUpdateField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuickApplyPriceUpdateField");
	public String reportsLettersPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ReportsLettersPolygon");
	public String searchButtonForQuote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchButtonForQuote");
	public String browseButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "BrowseButton");
	public String uploadDocBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "UploadDocBtn");
	
	public String commentsAttachmentsTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CommentsAttachmentsTab");
	public String checkBox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CheckBox");
	public String searchedCustomerResult = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchedCustomerResult");
	public String quoteActionsDropDown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteActionDropDown");
	public String duplicatingQuoteGoButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DuplicatingQuoteGoButton");
	public String popUpNoButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PopUpNoButton");	
	public String popUpYesButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PopUpYesButton");
	public String attachedFiles = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AttachedFiles");
	
	public String manageConfiguration = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ManageConfiguration");
	public String manualComponentCheckBox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ManualComponentCheckBox");
	public String cFRCheckBox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CFRCheckBox");
	public String deleteItemButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DeleteItemButton");
	public String addComponentButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddComponentButton");
	public String componentViewTable = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ComponentViewTable");
	public String CopraTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CopraTab");
	public String applyApprovedPrice = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApplyApprovedPrice");
	public String nonLegacyCustomerNumberField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "NonLegacyCustomerNumberField");
	public String affiliateNumberField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AffiliateNumberField");
	public String cMRNumberField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CMRNumberField");
	public String regionField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RegionField");
	public String coverageModelField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CoverageModelField");
	public String coverageIDField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CoverageIDField");
	public String industryClassificationField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IndustryClassificationField");
	public String iNACSIANumberTypeField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "INACSIANumberTypeField");
	public String iNACSIANumberField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "INACSIANumberField");
	public String customerTypeField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CustomerTypeField");
	public String saveAndContinueButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveAndContinueButton");
	
	public String addAnotherComponentButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddAnotherComponentButton");
	public String componentTypeDropDown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ComponentTypeDropDown");
	public String approvalRadioButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApprovalRadioButton");
	public String level1InranetID = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Level1InranetID");
	
	public String administrationTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AdministrationTab");
	public String adminNameField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AdminNameField");
	public String cPINumberField = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CPINumberField");
	public String maintainanceOfferedRadioButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MaintainanceOfferedRadioButton");
	public String cashModePaymentRadioButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CashModePaymentRadioButton");
	public String adminSaveAndSendButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AdminSaveAndSendButton");
	public String typeOfSend = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TypeOfSend");
	public String defaultTypeOfSend = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DefaultTypeOfSend");
	public String quoteStatusCheck = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteStatusCheck");
	public String quoteStatusCheck2 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteStatusCheck2");
	
	public String financialTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "FinancialTab");
	public String commentsSection = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CommentsSection");
	public String attachStandardReportButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AttachStandardReportButton");
	public String uploadTextFileBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "UploadTextFileBtn");
	public String closeQuote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CloseQuote");
	public String sTDReport = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "STDReport");
	public String removeConfidentialDoc = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RemoveConfidentialDoc");
	public String proceedForReviewButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ProceedForReviewButton");
	public String downloadSummaryButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DownloadSummaryButton");
	public String saveCommentsButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveCommentsButton");
	public String selectCountryDropDown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectCountryDropDown");
	public String cMRCustomerName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CMRCustomerName");
	public String tSSCheckBOX = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TSSCheckBOX");
	public String standardReport = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "StandardReport");
	public String reviewerReport = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ReviewerReport");
	public String saveAndView = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SaveAndView");
	public String everyoneRadioButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EveryoneRadioButton");

	public String IBMoverviewcradnumber = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMoverviewcradnumber");
	public String IBMoverviewrequestphone = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMoverviewrequestphone");
	public String IBMoverviewcountryselectdropdown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMoverviewcountryselectdropdown");
	public String IBMoverviewquotetile = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMoverviewquotetile");
	public String IBMoverviewoppid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMoverviewoppid");
	public String IBMoverviewOOemail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMoverviewOOemail");
	public String IBMoverviewOOname = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMoverviewOOname");
	public String IBMoverviewchannelindicatordropdown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMoverviewchannelindicatordropdown");
	public String IBMoverviewsolusiontypedropdown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMoverviewsolusiontypedropdown");
	public String IBMoverviewsavecontinuebutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMoverviewsavecontinuebutton");

	public String IBMcomponentdropdown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMcomponentdropdown");
	public String IBMcomponenttype = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMcomponenttype");
	public String IBMcomponentmodel = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMcomponentmodel");
	public String IBMcomponentaddclose = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMcomponentaddclose");
	public String IBMcomponentsaveclosebutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMcomponentsaveclosebutton");
	public String IBMtabrequestapprovalsavebutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabrequestapprovalsavebutton");
	public String IBMtabrequestapprovalcancelnotification = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabrequestapprovalcancelnotification");
	public String IBMtabsubmitcancelnotification = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabsubmitcancelnotification");
	
	public String IBMtabapprovalradioapprove = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabapprovalradioapprove");
	public String IBMtabapprovalradioreject = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabapprovalradioreject");
	public String IBMtabapprovalLvl1emailid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabapprovalLvl1emailid");
	public String IBMtabapprovalsubmitbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabapprovalsubmitbutton");
	
	public String IBMtabapprovalSBClist = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabapprovalSBClist");
	public String IBMtabapprovalSBClistoption1 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabapprovalSBClistoption1");
	
	
	
	public String IBMtabAdministration = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabAdministration");
	public String IBMtabPricing = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabPricing");
	
	public String IBMtabAdministrationothernumberid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabAdministrationothernumberid");
	public String IBMtabAdministrationmaintainofferno = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabAdministrationmaintainofferno");
	public String IBMtabAdministrationsigntypecash = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabAdministrationsigntypecash");
	public String IBMtabAdministrationsavebutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabAdministrationsavebutton");
	
	public String IBMtabpricesviewdropdown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabpricesviewdropdown");
	public String IBMtabpricesrecalculatebutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabpricesrecalculatebutton");

	public String IBMLAQ1 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ1");
	public String IBMLAQ2 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ2");
	public String IBMLAQ3 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ3");
	public String IBMLAQ4 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ4");
	public String IBMLAQ5 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ5");
	public String IBMLAQ6 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ6");
	public String IBMLAQ7 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ7");
	public String IBMLAQ8 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ8");
	public String IBMLAQ9 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ9");
	public String IBMLAQ10 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ10");
	public String IBMLAQ11 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ11");
	public String IBMLAQ12 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ12");
	public String IBMLAQ13 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ13");
	public String IBMLAQ13_1 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ13_1");
	public String IBMLAQ14 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ14");
	public String IBMLAQ15 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ15");
	public String IBMLAQ16 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ16");
	public String IBMLAQ17 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ17");
	public String IBMLAQ18 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ18");
	public String IBMLAQ19 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMLAQ19");
	
	public String IBMclosecurrnetquote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMclosecurrnetquote");
	public String IBMselectinternalquote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMselectinternalquote");
	public String IBMsearchcriteria = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMsearchcriteria");
	public String IBMquoteidinput = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMquoteidinput");
	public String IBMmultipleCheck = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMmultipleCheck");
	public String IBMsearchbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMsearchbutton");
	
	
	public String IBMtabAdministrationname = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabAdministrationname");
	public String IBMtabAdministrationpreparecontract = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabAdministrationpreparecontract");
	public String IBMtabAdministrationsign = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabAdministrationsign");
	public String IBMtabAdministrationsavenosendbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabAdministrationsavenosendbutton");
	public String IBMrefreshrealcost = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMrefreshrealcost");
		
	public String BPCRAD = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "BPCRAD");
	public String IBMtabrequestapprovalcancelnotificationforduplicatequote = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMtabrequestapprovalcancelnotificationforduplicatequote");
	
	public Epricer_Application_IBM_CreateAQuote_PageObjects(WebDriver d, String tcId) {

		this.driver = d;
		this.TC_ID = tcId;
	}
}
