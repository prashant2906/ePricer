/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.PageObjects.NAIBM;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_NAIBM_CreateAQuote_PageObjects {

	ElementAction action = new ElementAction();

	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath();

	public WebDriver driver;
	public String TC_ID;
	
	public String approvedDiscountValue = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApprovedDiscountValue");
	public String recalculateBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RecalculateBtn");
	public String needApprovalLabel = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "NeedApprovalLabel");
	public String requestApprovalTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequestApprovalTab");
	public String waitingForApprovalLabel = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "WaitingForApprovalLabel");
	public String approvedPriceValueNA = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApprovedPriceValueNA");
	
	public String approvalTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApprovalTab");
	public String radioApprovalApprove = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RadioApprovalApprove");
	public String naIBMQuoteSubmitBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "NaIBMQuoteSubmitBtn");
	public String intranetId = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IntranetId");
	public String specialBidCode = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SpecialBidCode");
	public String matchApprovePricesOne = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MatchApprovePricesOne");
	
	public String standardReportBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "StandardReportBtn");
	public String historyReportBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "HistoryReportBtn");
	public String tailoredReportBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TailoredReportBtn");
	
	public String standardReportScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "StandardReportScreen");
	public String historyReportScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "HistoryReportScreen");
	public String tailoredReportScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TailoredReportScreen");
	
	public String tailoredReportName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TailoredReportName");
	public String sectionsShowBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SectionsShowBtn");
	public String tailoredReportSaveAndViewBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TailoredReportSaveAndViewBtn");
	public String testTailoredReport = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TestTailoredReport");
	
	public String entitlementsPromoTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EntitlementsPromoTab");	
	public String discountOnEP = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DiscountOnEP");
	public String entitlementDescription = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EntitlementDescription");
	public String referenceOnEP = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ReferenceOnEP");	
	public String byComponentTabOnEP = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ByComponentTabOnEP");
	public String byReferenceTabOnEP = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ByReferenceTabOnEP");
	public String byReferenceAvailableTabOnEP = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ByReferenceAvailableTabOnEP");

	public String customerPolygon = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CustomerPolygon");
	public String entitledPriceVisible = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EntitledPriceVisible");
	
	public String discountOnByComponent = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DiscountOnByComponent");
	public String discountOnByReference = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DiscountOnByReference");
	public String discountOnByReferenceAvail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DiscountOnByReferenceAvail");
	
	
	public Epricer_Application_NAIBM_CreateAQuote_PageObjects(WebDriver d, String tcId) {

		this.driver = d;
		this.TC_ID = tcId;
	}
}
