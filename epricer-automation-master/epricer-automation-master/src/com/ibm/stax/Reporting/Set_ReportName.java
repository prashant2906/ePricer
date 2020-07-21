package com.ibm.stax.Reporting;

public class Set_ReportName {	
	
	public static String reportname ;
		
	
	
		public Set_ReportName(String Test)
		{
			Test = "ePricer"+Test+".HTML";
			Set_ReportName.reportname=Test;
		}
		
		public String getApp()
		{
			return Set_ReportName.reportname;
		}
	
        
}
	
