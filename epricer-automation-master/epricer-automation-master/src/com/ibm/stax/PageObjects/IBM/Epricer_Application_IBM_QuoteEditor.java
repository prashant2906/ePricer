/**
  *  
 *
 */
package com.ibm.stax.PageObjects.IBM;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_IBM_QuoteEditor {
	

	ElementAction action=new ElementAction();
	
	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath(); 
	
	
	public WebDriver driver;
	public String TC_ID;	
	

	public String IBMCommentsStatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMCommentsStatus");
	public String IBMChangeStautsRadio = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMChangeStautsRadio");
	public String IBMChangeStautsdropdownlist = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMChangeStautsdropdownlist");
	public String IBMChangeStautsSaveButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMChangeStautsSaveButton");
	public String IBMChangeStautsreasoncodedropdownlist = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMChangeStautsreasoncodedropdownlist");
	public String IBMRemovefromonhold = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMremovefromonhold");
	public String IBMapprovelink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMapprovelink");
	public String IBMCOPRAlink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMCOPRAlink");
	public String IBMPriceslink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMPriceslink");
	public String IBMRequestapprovallink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMRequestapprovallink");
	
	
	public String IBMApproveRadio = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMApproveRadio");
	public String IBMWithdrawRadio=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMWithdrawRadio");
	public String BPWithrawDropBox= new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "BPWithrawDropBox");
	public String IBMApprovesubmit = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMApprovesubmit");
	public String TableView = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "TableView");
	public String NotfoundComponentLink= new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "NotfoundComponentLink");
	public String ListPriceforNotfoundComponent =new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ListPriceforNotfoundComponent");
	public String ApplyButtonClickNotFound=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApplyButtonClickNotFound");
	public String CloseLPApplied=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "CloseLPApplied");
	public String IBMuploadattachment=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMuploadattachment");
	public String IBMuploadallbutton=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMuploadallbutton");
	public String IBMaddendumselectdropdown=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMaddendumselectdropdown");
	
	public String IBMnonstandardTC=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMnonstandardTC");
	
	public String IBMgetReportAddendum=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMgetReportAddendum");
	public String IBMexceptiontextinAddendum=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMexceptiontextinAddendum");
	public String IBMOptimalprice=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMOptimalprice");
	public String IBMdisplaycriteria=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMdisplaycriteria");
	public String IBMquotestatus=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMquotestatus");
	public String PSATBPapprovedpriceonCoprascreen=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATBPapprovedpriceonCoprascreen");
	
	public String PSATtotalcheckbox=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATtotalcheckbox");
	public String PSATQuick_apply=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATQuick_apply");
	public String PSATmanualOrPoints=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATmanualOrPoints");
	public String PSATOptimalprice=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATOptimalprice");
	public String PSATPriceapplybutton=new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATPriceapplybutton");
	public String ApprovedPriceAmount= new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ApprovedPriceAmount");
	public String OptimalPriceAmount= new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "OptimalPriceAmount");
	
	public String IBMrefreshrealcost = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMrefreshrealcost");
	public String IBMexportimport = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMexportimport");
	public String approvalhistory = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "approvalhistory");
		
	public Epricer_Application_IBM_QuoteEditor(WebDriver d,String tcId){
		
		this.driver = d;
		this.TC_ID=tcId;
		}
}

