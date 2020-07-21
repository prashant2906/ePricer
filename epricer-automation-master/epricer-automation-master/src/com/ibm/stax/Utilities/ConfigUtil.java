package com.ibm.stax.Utilities;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ConfigUtil {
	public WebDriver driver;
	
	public ConfigUtil(WebDriver d){
		
		this.driver = d;
		}
	
	/*************************************************************************************************
	 * Type: Method
	 * Author: Kajal
	 * Parameter: path
	 * Return: Properties prop
	 * Create date: 2018/08/08
	 * Load the Configuration from config.properites, return a Properties
	 ************************************************************************************************/
	public static Properties loadConfig(String path){
		InputStream in = null;
		Properties prop = new Properties(); 
		try {
			in = new BufferedInputStream(new FileInputStream(path));
			try {
				prop.load(in);
			} catch (IOException e) {
				Log.error("Read Configuration File Failed");
				//LogUtil.error("Read Configuration File Failed");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			Log.error("Load Configuration File path: " + System.getProperty("user.dir") + "/config/config.properties Not Found}");
			//LogUtil.error("Load Configuration File path: " + System.getProperty("user.dir") + "/config/config.properties Not Found}");
		}   
		return prop;
	}
	
	/*************************************************************************************************
	 * Type: Method
	 * Author: Henry
	 * Parameter: Properties prop
	 * Return: Map<String, String> configMap
	 * Create date: 2015/11/11
	 * Put the key and value from prop into a hash map configMap, then return the map
	 ************************************************************************************************/
	public static Map<String,String> initConfig(Properties prop){
		Map<String, String> configMap = new HashMap<String, String>();
		if(prop.isEmpty()){
			Log.error("Load Configuration Failed");
			//LogUtil.error("Load Configuration Failed");
		}
		else{
			Enumeration<?> enu = prop.propertyNames();  
		    while (enu.hasMoreElements()) {
		    	Object key = enu.nextElement();  
		        configMap.put((String) key, prop.getProperty((String) key));
		    }
		    Log.info("Load Configuration Succeed");
		    //LogUtil.frameLog("Load Configuration Succeed");
		}
	    return configMap;
	}
}
