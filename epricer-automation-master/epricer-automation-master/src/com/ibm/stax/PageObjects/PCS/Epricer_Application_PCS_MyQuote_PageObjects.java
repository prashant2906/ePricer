/**
 *  
 *
 */
package com.ibm.stax.PageObjects.PCS; 

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_PCS_MyQuote_PageObjects {
	
	ElementAction action=new ElementAction();
	
	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath(); 
	
	
	public WebDriver driver;
	public String TC_ID;	
	
	public String pcsmyQuotesLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSMyQuotesLink");
	public String pcsmyQuotesQuoteActiondropdown = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "QuoteActiononMyquote");
	
	
	public Epricer_Application_PCS_MyQuote_PageObjects(WebDriver d,String tcId){
		
		this.driver = d;
		this.TC_ID=tcId;
		}
}

