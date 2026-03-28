package com.provilac.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.provilac.base.BaseClass;


public class ReadConfigProperty extends BaseClass {


	public static File file;
	public static FileInputStream fis;
	public static Properties prop;
	/*
	 * public static String readConfig(String key) {
	 * logger.info("Read the property file from Config file"); FileInputStream fis =
	 * null; Properties prop = null; try { fis = new
	 * FileInputStream(System.getProperty("user.dir") +
	 * "/src/main/resources/Config.properties"); prop = new Properties();
	 * prop.load(fis); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return prop.getProperty(key); }
	 */
	static {

		file = new File(System.getProperty("user.dir") + "/src/main/resources/Config.properties");
		try {
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static String readProperty(String key) {
		return prop.getProperty(key);
	}

	public static String getChromeBrowser() {
		String chromepath = readProperty("chrome");
		return chromepath;
	}

	public static String getFirfoxBrowser() {
		String firepath = readProperty("firefox");
		return firepath;
	}

	public static String getIEBrowser() {
		String iepath = readProperty("ie");
		return iepath;
	}

	public static String getAppURL() {
		String baseurl = readProperty("url");
		return baseurl;
	}

	public static String selectCity() {
		String city = readProperty("city");
		return city;
	}

	
	public static String getMobileNumber() {
		String mobile = readProperty("mobile");
		return mobile;
	}
	
	public static String getInvalidMobileNumber() {
		String invalidMobile = readProperty("invalidmobile");
		return invalidMobile;
	}
	
	public static String getInvalidOTP() {
		String invalidOTP = readProperty("invalidOTP");
		return invalidOTP;
	}
}
