package com.provilac.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.provilac.utilities.ReadConfigProperty;

public class BaseClass {

	public static WebDriver driver = null;
	public static Logger logger = LogManager.getLogger(BaseClass.class);

	public void lanchingApplication() {
		logger.info("lunching an application");
		driver.get(ReadConfigProperty.getAppURL());
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	public WebDriver initialization() {
		String browser = ReadConfigProperty.readProperty("browser");
		logger.info("Initializing browser with name :- " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			lanchingApplication();
			logger.info("Chrome browser initialize");
			return driver;
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			lanchingApplication();
			logger.info("firefox browser initialize");
			return driver;
		}
		return null;

	}
}
