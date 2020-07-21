package com.ibm.stax.Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FrameConfig {
	
	private  Map<String, String> config = new HashMap<String, String>();
	private Properties prop;
	private static FrameConfig instance = null;
	
	public static synchronized FrameConfig getInstance(){
		if(instance == null){
			instance = new FrameConfig();
        }
        return instance;
	}
	
	
	/*************************************************************************************************
	 * Type: Method
	 * Author: Henry
	 * Create date: 2015/11/11
	 * Read configuration from config.properties, then write to a hash map config
	 ************************************************************************************************/
	private FrameConfig(){
		prop = ConfigUtil.loadConfig(System.getProperty("user.dir")+"\\config\\regression.properties");
		config = ConfigUtil.initConfig(prop);
	}
	
	public String getConfig(String key){
		String rs = "";
		rs = this.config.get(key);
		try{
			rs.equals(null);
		}
		catch(Exception e){
			Log.warn("No '" + key + "' value Found in Configuration");
			//LogUtil.warn("No '" + key + "' value Found in Configuration");
		}
		return rs;
	}
	
	public Map<String, String> getConfig(){
		return this.config;
	}

}
