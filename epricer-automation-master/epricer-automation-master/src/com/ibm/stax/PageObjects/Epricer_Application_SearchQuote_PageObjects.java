/**
 *  
 *
 */
package com.ibm.stax.PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_SearchQuote_PageObjects {
	
	ElementAction action=new ElementAction();
	
	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath(); 
	
	
	public WebDriver driver;
	public String TC_ID;	
	
	public String searchQuotesLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuotesLink");
	public String searchQuotesScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchQuotesScreen");
	public String searchCriteriaSelect = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SearchCriteriaSelect");
	public String enterQuoteid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSsearchquoteid");
	public String SP2CEIDSeachQuoteScreen= new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SP2CEIDSeachQuoteScreen");


	
	public Epricer_Application_SearchQuote_PageObjects(WebDriver d,String tcId){
		
		this.driver = d;
		this.TC_ID=tcId;
		}
}

