/**
 * @author Kajal Shakya
 *
 */
package com.ibm.stax.PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_Login_PageObjects {

	ElementAction action = new ElementAction();

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

	// add for PCS log in
	public String SelectedCountryforPCS = new Common_Functions().GetXMLTagValue(xmlLocatorsPath,
			"SelectedCountryforPCS");
	public String PCSContinuebutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSContinuebutton");
	public String PCSContinuebutton1 = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSContinuebutton1");
	public String MaintLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MaintLink");
	public String DevLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DevLink");
	public String PRODLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PRODLink");
	public String IVTLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "IVTLink");
	public String PCSSignout = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PCSSignout");

	public String ByPassPCS = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ByPassPCS");
	public String ByPassPCSdisrole = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ByPassPCSdisrole");
	public String ByPassData = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ByPassData");
	public String ByPassePricergo = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "ByPassePricergo");

	// add for PSAT log in
	public String buttonPSATLogin = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "buttonPSATLogin");
	public String buttonPSATSignin = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "buttonPSATSignin");
	public String LoginMainUserName = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "LoginMainUserName");
	public String LoginMainPassword = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "LoginMainPassword");
	public String epricerGObutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "epricerGObutton");
	public String countryselectdropdownlist = new Common_Functions().GetXMLTagValue(xmlLocatorsPath,
			"countryselectdropdownlist");
	public String companyselectdropdownlist = new Common_Functions().GetXMLTagValue(xmlLocatorsPath,
			"companyselectdropdownlist");
	public String countryselectbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "countryselectbutton");
	public String XMLphone = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "XMLphone");
	public String XMLemail = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "XMLemail");
	public String XMLuniqueid = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "XMLuniqueid");
	public String generateXMLbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "generateXMLbutton");
	public String sendXMLbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "sendXMLbutton");

	public String PSATIBMIDname = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATIBMIDname");
	public String PSATIBMIDpassword = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATIBMIDpassword");
	public String PSATIBMIDcontinuebutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath,
			"PSATIBMIDcontinuebutton");
	public String PSATIBMIDsigninbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath,
			"PSATIBMIDsigninbutton");

	public String PSATGroup = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "PSATGroup");
	public String PSATGrouplaunchbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath,
			"PSATGrouplaunchbutton");

	public String MySAePricerlink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MySAePricerlink");
	public String MySARolelist = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MySARolelist");
	public String MySALoginbutton = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MySALoginbutton");

	public String MySAcurrentrole = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MySAcurrentrole");
	public String MySAMAINT = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MySAMAINT");
	public String MySADEV = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MySADEV");
	public String MySAIVT = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MySAIVT");

	public Epricer_Application_Login_PageObjects(WebDriver d, String tcId) {

		this.driver = d;
		this.TC_ID = tcId;
	}
}
