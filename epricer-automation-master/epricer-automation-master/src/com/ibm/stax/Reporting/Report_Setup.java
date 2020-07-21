package com.ibm.stax.Reporting;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.ibm.stax.Utilities.FrameConfig;
import com.ibm.stax.Utilities.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Report_Setup {

	public static Map<String, ExtentTest> testMap = new HashMap<String, ExtentTest>();
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	private static Date date = new Date();
	private static String d = dateFormat.format(date);

	private static String reportPath = FrameConfig.getInstance().getConfig("ReportFolderPath");
	private static String snapshotsPath = FrameConfig.getInstance().getConfig("SnapshotFolderPath");

	private static Report_Setup reportSetup;
	private static ExtentReports extent;

	private Report_Setup() {
		// do nothing
	}
	
	public static ExtentReports getExtent() {
		return extent;
	}

	public static Report_Setup getInstance() {
		if (reportSetup == null) {
			reportSetup = new Report_Setup();
			cleanUpReports();
		}
		return reportSetup;
	}
	public void initializeReport(String testCaseName) {
		ExtentTest test = extent.startTest(testCaseName, "Execution started for : " + testCaseName);
		testMap.put(testCaseName, test);
	}

	
	public static Map<String, ExtentTest> getTestMap() {
		return testMap;
	}

	public static ExtentTest getTest(String testName) {
		return testMap.get(testName);
	}

	public static void cleanUpReports() {
		System.out.println("d: " + d);
		System.out.println("Report Path : " + reportPath);
		System.out.println("snapshots Path : " + snapshotsPath);

		File f = new File(reportPath);
		if (f != null && f.isDirectory()) {
			try {
				FileUtils.cleanDirectory(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		File f1 = new File(snapshotsPath);
		if (f1 != null && f1.isDirectory()) {
			try {
				FileUtils.cleanDirectory(f1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void endTests() {
		for (String test: testMap.keySet()) {
			extent.endTest(testMap.get(test));
		}
	}
	public static void setReportName(String nameReport) {
		extent = new ExtentReports(reportPath + nameReport, true);
	}
	public static void flush() {
		if (extent != null) {
			extent.flush();
		} else {
			Log.error("A extent report was never generated!");
		}
		
	}
}
