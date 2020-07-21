/**
  *  
 *
 */
package com.ibm.stax.PageObjects.PCS;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_PCS_SearchQuote_PageObjects {
	

	ElementAction action=new ElementAction();
	
	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath(); 
	
	
	public WebDriver driver;
	public String TC_ID;	
	
	public String searchQuotesLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuotesLink");
	public String searchQuotesScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuotesScreen");
	public String searchCriteriaSelect = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSearchCriteria");
	public String searchQuoteStatus = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSearchstatus");
	public String searchButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSearchButton");
	
	public String searchedresult = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSsearchedresult");
	public String searchQuoteaction = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSsearchQuoteaction");
	public String searchGoButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSsearchGoButton");
	public String enterQuoteid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSsearchquoteid");
	public String PCSmultiplecheck = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MulticheckBox");
	public String multiplecheck = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSmultilplecheck");
	public String PSATSinglecheck = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATSinglecheck");
	public String Singlecheck = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Singlecheck");
	
	public String IBMsearchshowAddAnother = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMsearchshowAddAnother");
	public String IBMsearchshowAddAnotherCriteria = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMsearchshowAddAnotherCriteria");
	public String IBMsearchBPresoncode = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMsearchBPresoncode");
	
	public String SP2CEIDSeachQuoteScreen= new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SP2CEIDSeachQuoteScreen");
	public String quotestatuscriteria = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMJPStatusCriteria");

	public String psatsearchCriteriaSelect = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATSearchCriteriaSelect");
	public String psaterrormessage = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "psaterrormessage");
	public String psatsearchquoteaction = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSsearchQuoteaction");
	public String ibmsearchquoteaction = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMsearchquoteaction");
	public String duplicatingQuoteGoButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DuplicatingQuoteGoButton");
	public String popUpNoButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PopUpNoButton");	
	public String popUpYesButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PopUpYesButton");
	public String attachedFiles = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AttachedFiles");
	
	public String Searchquotetypeall = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Searchquotetypeall");
	public String Searchquotetypeinternal = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Searchquotetypeinternal");
	public String Searchquotetypebp = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Searchquotetypebp");
	
	
	public Epricer_Application_PCS_SearchQuote_PageObjects(WebDriver d,String tcId){
		
		this.driver = d;
		this.TC_ID=tcId;
		}
}

