
package com.ibm.stax.BusinessLogic.EMEAIBM;
 
import org.openqa.selenium.WebDriver;

import com.ibm.stax.PageObjects.Epricer_Application_Login_PageObjects;
import com.ibm.stax.Reporting.Extent_Reporting;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author Kajal Shakya
 *
 */
public class Epricer_Application_EMEAIBM_Login_BusinessLogic {
	private ExtentTest test;
	public WebDriver driver;
	public String TC_ID;
	Epricer_Application_Login_PageObjects ePricerLoginPageObjects = null;

	public Epricer_Application_EMEAIBM_Login_BusinessLogic(WebDriver d, String tcId, ExtentTest test) {
		this.test = test;
		this.driver = d;
		this.TC_ID = tcId;
	}

	/**
	 * This method is to navigate to EMEAIBM.
	 * 
	 * @throws Throwable
	 */
	public void epricerNavigatetoEMEAIBM(String IBMURL) throws Exception {
		try {
			ePricerLoginPageObjects = new Epricer_Application_Login_PageObjects(driver, TC_ID);
			
			//driver.get(Excel_Handling.Get_Data(TC_ID, "EMEAIBMUrl"));
			
				driver.get(IBMURL);	
				Thread.sleep(2000);

			
				Thread.sleep(4000);
	
			Extent_Reporting.Log_report_img("EMEAIBM url opened.","EMEAIBM url opened.",driver, test);

		} catch (Exception e) {
			Extent_Reporting.Log_Fail("EMEAIBM url not opened.","EMEAIBM url not opened.",driver, test);
			System.out.println(e.getMessage().toString());
			driver.quit();
			e.printStackTrace();
			throw new Exception("Failed");
		}

	}
}