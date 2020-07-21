package com.ibm.stax.Utilities;

import com.ibm.stax.Reporting.Report_Setup;
import com.ibm.stax.TestData.Excel_Handling;
import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.annotations.Optional;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

public class Create_TestNGXML {

	public List<XmlInclude> constructIncludes(String... methodNames) {
		List<XmlInclude> includes = new ArrayList<XmlInclude>();
		for (String eachMethod : methodNames) {
			includes.add(new XmlInclude(eachMethod));
		}
		return includes;
	}

	@Parameters({ "Test", "env", "Parallel" })
	@Test
	public void createXMLfile(String Test, String env, @Optional("false") Boolean parallel) throws IOException {

		// calling out the excel datasheet instance to get all the "Y" data for
		// setting up the testngxml

		Excel_Handling excel = new Excel_Handling();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Instant instant = timestamp.toInstant();
        
        String timeStampString = instant.toString();
		ClassLoader classLoader = getClass().getClassLoader();
		//SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");  
		//Date date = new Date();  
		File dataSheet = null;
		File dataSheetResult = null;
		String nameReport = null;
		
		nameReport = env+Test+".html";
		//nameReport = env+Test+formatter.format(date)+".html";
				
		if (Test.equalsIgnoreCase("RegressionIBM")) {
			dataSheet = new File(classLoader.getResource("Datasheet_Regression_IBM.xlsx").getFile());
			dataSheetResult = new File(classLoader.getResource("Datasheet_RegressionIBM_Result.xlsx").getFile());
		}
		if (Test.equalsIgnoreCase("RegressionBP")) {
			dataSheet = new File(classLoader.getResource("Datasheet_Regression_BP.xlsx").getFile());
			dataSheetResult = new File(classLoader.getResource("Datasheet_Regression_BP_Result.xlsx").getFile());
		}
		if (Test.equalsIgnoreCase("SanityBP")) {
			System.out.println("SanityBP reader done!");
			dataSheet = new File(classLoader.getResource("Datasheet_SanityBP.xlsx").getFile());
			dataSheetResult = new File(classLoader.getResource("Datasheet_Sanity_ResultBP.xlsx").getFile());
			nameReport = "SanityBPParallel.html";
		}
		if (Test.equalsIgnoreCase("SanityIBM")) {
			System.out.println("SanityIBM reader done!");
			dataSheet = new File(classLoader.getResource("Datasheet_SanityIBM.xlsx").getFile());
			dataSheetResult = new File(classLoader.getResource("Datasheet_Sanity_ResultIBM.xlsx").getFile());
			nameReport = "SanityIBMParallel.html";
		}
		if (Test.equalsIgnoreCase("Legal_IBM"))
		{
			 dataSheet = new File(classLoader.getResource("Datasheet_Legal_IBM.xlsx").getFile());
			 dataSheetResult = new File(classLoader.getResource("Datasheet_Legal_IBM_Result.xlsx").getFile());
		}
		if (Test.equalsIgnoreCase("Legal_BP"))
		{
			 dataSheet = new File(classLoader.getResource("Datasheet_Legal_BP.xlsx").getFile());
			 dataSheetResult = new File(classLoader.getResource("Datasheet_Legal_BP_Result.xlsx").getFile());
		}
		if (Test.equalsIgnoreCase("Legal_Min"))
		{
			 dataSheet = new File(classLoader.getResource("Datasheet_Legal_Min.xlsx").getFile());
			 dataSheetResult = new File(classLoader.getResource("Datasheet_Legal_Min_Result.xlsx").getFile());
		}
		try {
			excel.ExcelReader(dataSheet.getAbsolutePath(), "Data", dataSheetResult.getAbsolutePath(), "Data");
			excel.getExcelDataAll("Data", "Execute", "Y", "TC_ID");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("excel reader done!");
		System.out.println("test env is " + env);

		Map<String, HashMap<String, String>> map = Excel_Handling.TestData;
		// creation of the testng xml based on parameters/data
		TestNG testNG = new TestNG();
		Report_Setup.getInstance();
		Report_Setup.setReportName(nameReport);
		
		XmlSuite suite = new XmlSuite();
		if (parallel) {
			suite.setParallel(ParallelMode.TESTS);
		}
		for (String key : map.keySet()) {
			File configFile = new File(classLoader.getResource("Config.xml").getFile());
			System.out.println("configFile:: " + configFile.getAbsolutePath());
			final Common_Functions commonFunctions = new Common_Functions();
			suite.setName(commonFunctions.GetXMLTagValue(configFile.getAbsolutePath(), "Regression_Suite_Name"));
			XmlTest test = new XmlTest(suite);
			test.setName(key);
			test.setPreserveOrder("true");
			test.addParameter("browserType", Excel_Handling.Get_Data(key, "Browser_Type"));
			test.addParameter("tcID", key);
			test.addParameter("ENV", env);
			test.addParameter("appURL", commonFunctions.GetXMLTagValue(configFile.getAbsolutePath(), "AppUrl"));
			test.addParameter("IBMURL", commonFunctions.GetXMLTagValue(configFile.getAbsolutePath(), env + "IBM"));
			test.addParameter("PCSURL",commonFunctions.GetXMLTagValue(configFile.getAbsolutePath(), env + "BPDirectPCS"));
			test.addParameter("MySAURL", commonFunctions.GetXMLTagValue(configFile.getAbsolutePath(), env + "MySA"));
			test.addParameter("Timestamp", timeStampString);
			XmlClass testClass = new XmlClass();

			if (Test.equalsIgnoreCase("RegressionIBM")) {
				testClass.setName("com.ibm.stax.Tests.RegressionIBM." + Excel_Handling.Get_Data(key, "Class_Name"));
			}
			if (Test.equalsIgnoreCase("RegressionBP")) {
				testClass.setName("com.ibm.stax.Tests.RegressionBP." + Excel_Handling.Get_Data(key, "Class_Name"));
			}
			if (Test.equalsIgnoreCase("SanityBP")) {
				testClass.setName("com.ibm.stax.Tests.Sanity." + Excel_Handling.Get_Data(key, "Class_Name"));
			}
			if (Test.equalsIgnoreCase("SanityIBM")) {
				testClass.setName("com.ibm.stax.Tests.Sanity." + Excel_Handling.Get_Data(key, "Class_Name"));
			}
			if (Test.equalsIgnoreCase("Legal_IBM"))	{
				testClass.setName("com.ibm.stax.Tests.Legal." + Excel_Handling.Get_Data(key, "Class_Name"));
			}
			if (Test.equalsIgnoreCase("Legal_BP")) { 
				testClass.setName("com.ibm.stax.Tests.Legal." + Excel_Handling.Get_Data(key, "Class_Name"));
			}
			if (Test.equalsIgnoreCase("Legal_Min")) {
				testClass.setName("com.ibm.stax.Tests.Legal." + Excel_Handling.Get_Data(key, "Class_Name"));
			}
			test.setXmlClasses(Arrays.asList(new XmlClass[] { testClass }));
		}
		List<String> suites = new ArrayList<String>();
		final File f1 = new File(Create_TestNGXML.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		System.out.println("f1:: " + f1.getAbsolutePath());
		File f = new File(".\\testNG.xml");
		f.createNewFile();
		FileWriter fw = new FileWriter(f.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(suite.toXml());
		bw.close();
		suites.add(f.getPath());
		testNG.setTestSuites(suites);
		testNG.run();
		f.delete();
		Report_Setup.flush();

	}

}
