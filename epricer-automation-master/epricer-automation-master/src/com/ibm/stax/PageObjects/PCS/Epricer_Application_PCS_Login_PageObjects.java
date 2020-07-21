/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.PageObjects.PCS;
 
import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_PCS_Login_PageObjects {
	
	ElementAction action=new ElementAction();
	
	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml").getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath(); 
	
	public WebDriver driver;
	public String TC_ID;	
	
	public String homePage = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "HomePage");
	public String selectARoleDD = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectARole");
	public String startButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "StartButton");
	public String dashboardLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DashboardLink");
	public String userName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "UserName");
	public String password = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Password");
	public String loginButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "LoginButton");
	public String ePricerGoTab = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EPricerGoTab");

	public String ePricerGoTestScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EPricerGoTestScreen");
	public String selectButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectButton");
	public String generateXMLButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "GenerateXMLButton");

	public String contactPhone = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ContactPhone");
	public String contactEmail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ContactEmail");
	public String iBMUniqueID = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMUniqueID");
	public String XmlCheck = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "XmlCheck");

	public String sendXMLButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SendXMLButton");
	public String epricerLogoScreen = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "EpricerLogoScreen");

	public String iBMidUserName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMidUserName");
	public String iBMidPwd = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IBMidPwd");
	public String submitButton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SubmitButton");

	//add for PCS log in
	public String SelectedCountryforPCS = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "SelectedCountryforPCS");
	public String PCSContinuebutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSContinuebutton");
	public String MaintLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MaintLink");
	
	public Epricer_Application_PCS_Login_PageObjects(WebDriver d,String tcId){
		
		this.driver = d;
		this.TC_ID=tcId;
		}
}

