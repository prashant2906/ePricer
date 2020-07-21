package com.ibm.stax.PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.ibm.stax.Utilities.Common_Functions;
import com.ibm.stax.Utilities.ElementAction;

public class Epricer_Application_Change_Configuration_Quantity_PageObjects {

	ElementAction action = new ElementAction();
	// Common_Functions Function = new Common_Functions();
	// private String xmlLocatorsPath =
	// Constants.xmlLocatorsPath+"Locators.xml";

	ClassLoader classLoader = getClass().getClassLoader();
	File locatorsXml = new File(classLoader.getResource("Locators.xml")
			.getFile());
	private String xmlLocatorsPath = locatorsXml.getAbsolutePath();

	public WebDriver driver;
	public String TC_ID;

	public String featureRPQField = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "FeatureRPQField");
	public String quantityField = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "QuantityField");
	public String addNewFeatureButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "AddNewFeatureButton");
	public String selectFeatureCheckBox = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "SelectFeatureCheckBox");
	public String addNCloseButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "AddNCloseButton");
	public String uploadCFRButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "UploadCFRButton");
	public String disableChecksumBox = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "DisableChecksumBox");
	public String otherCountryCFRCheckBox = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "OtherCountryCFRCheckBox");
	public String chooseFileButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "ChooseFileButton");
	public String updateQuantityButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "UpdateQuantityButton");
	public String viewAndEditConfiguration = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "ViewAndEditConfiguration");
	public String goBackButton = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "GoBackButton");
	public String dropDownFeatureButton = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "DropDownFeatureButton");
	public String updateQuantity1 = new Common_Functions().GetXMLTagValue(
			xmlLocatorsPath, "updateQuantity1");
	public String requesttValueSellerOfferButton = new Common_Functions()
			.GetXMLTagValue(xmlLocatorsPath, "RequesttValueSellerOfferButton");
	public String dropDownFeatureButtonManageConfig = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "DropDownFeatureButtonManageConfig");
	public String feature1CheckBox = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "Feature1CheckBox");
	public String featureQuantiyFieldManageConfig = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "FeatureQuantiyFieldManageConfig");
	public String myQuotesLink = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MyQuotesLink");
	public String myQuotesPageExists = new Common_Functions().GetXMLTagValue(xmlLocatorsPath, "MyQuotesPageExists");
	
	public Epricer_Application_Change_Configuration_Quantity_PageObjects(
			WebDriver d, String tcId) {

		this.driver = d;
		this.TC_ID = tcId;
	}
}
