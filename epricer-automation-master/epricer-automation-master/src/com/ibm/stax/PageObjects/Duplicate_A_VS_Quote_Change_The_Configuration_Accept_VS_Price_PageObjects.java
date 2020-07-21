/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_PageObjects {
	
	ElementAction action=new ElementAction();
	
	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath(); 
	
	
	public WebDriver driver;
	public String TC_ID;	
	
	public String addManualComponentBtn = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "AddManualComponentBtn");
	public String requestValueSellerOfferBTN = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "RequestValueSellerOfferBTN");
	
	public Duplicate_A_VS_Quote_Change_The_Configuration_Accept_VS_Price_PageObjects(WebDriver d,String tcId){
		
		this.driver = d;
		this.TC_ID=tcId;
		}
}

