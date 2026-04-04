package com.provilac.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import com.provilac.base.BaseClass;

public class ReadConfigProperty extends BaseClass {

	static FileInputStream fis = null;
	static Properties prop = null;
	
	public static String readConfig(String key) {
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	public static String readProperty(String key) {
		return readConfig(key);
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
