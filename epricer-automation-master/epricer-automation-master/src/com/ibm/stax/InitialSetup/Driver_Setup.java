
package com.ibm.stax.InitialSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ibm.stax.Reporting.Report_Setup;
import com.ibm.stax.Utilities.ElementAction;
import com.relevantcodes.extentreports.ExtentTest;

//import java.io.File;

public class Driver_Setup {
	
	public String Quoteid = null;
	public WebDriver driver;
	public ElementAction action = new ElementAction();
	
    public String TC_ID=null;
	protected ExtentTest test;
	public WebDriver getDriver() {	
		return driver;
	}

	
	@BeforeClass
	public void setUp(){
		driver=getDriver();
	}
	
	@BeforeTest
	public void setUpTestReport(ITestContext context) {
		test = Report_Setup.getTest(context.getName());
		if (test == null) {
			Report_Setup.getInstance().initializeReport(context.getName());
			test = Report_Setup.getTest(context.getName());
		
		}
	}
	
	@AfterTest
	public void endTestReport(ITestContext context) {
		test = Report_Setup.getTest(context.getName());
		if (test != null) {
			test = Report_Setup.getTest(context.getName());
			Report_Setup.getExtent().endTest(test);
		}
	}
	public void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "IE":
			driver = initIEDriver(appURL);
			break;
		case "CHROME":
			driver = initChromeDriver(appURL);
			break;
		case "FIREFOX":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as default for execution...");
			driver = initFirefoxDriver(appURL);
		}
	}

	public WebDriver initIEDriver(String appURL) {
		System.out.println("Launching Internet Explorer with new profile..");
		//System.setProperty("webdriver.ie.driver", driverPath+ "IEDriverServer.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		//Log.info(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		cap.setCapability("nativeEvents", false);    
		cap.setCapability("unexpectedAlertBehaviour", "accept");
		cap.setCapability("ignoreProtectedModeSettings", true);
		cap.setCapability("disable-popup-blocking", true);
		cap.setCapability("enablePersistentHover", true);
		cap.setCapability("ignoreZoomSetting", true);
		cap.setJavascriptEnabled(true);	
		driver = new InternetExplorerDriver(cap);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	
	private WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");		
		//System.setProperty("webdriver.chrome.driver", driverPath+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		//FirefoxOptions firefoxOptions = new FirefoxOptions();
	    //firefoxOptions.setCapability("marionette", true);
		//File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
//		FirefoxProfile firefoxProfile = new FirefoxProfile();
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
       // System.setProperty("webdriver.gecko.driver", "C:\\Users\\gecko\\NehaUpadhyay\\Desktop\\geckodriver.exe");

		//System.setProperty("webdriver.firefox.marionette", "false");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@Parameters({ "browserType", "appURL","tcID" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL,String tcID) {
		try {
			
			setDriver(browserType.toUpperCase(), appURL);
			TC_ID=tcID;

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();		
	}
	

}
