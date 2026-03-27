package com.provilac.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import com.provilac.base.BaseClass;


public class ReadProperties extends BaseClass {

public static String readConfig(String key) {
	    logger.info("Read the property file from properties file");
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}
}
