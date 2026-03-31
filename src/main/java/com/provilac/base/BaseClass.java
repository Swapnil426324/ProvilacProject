package com.provilac.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.provilac.exception.Browser_NullException;
import com.provilac.utilities.ReadConfigProperty;

public class BaseClass {

	public static WebDriver driver = null;
	public static Logger logger = LogManager.getLogger(BaseClass.class);

	public void lanchingApplication() {
		logger.info("lunching an application");
		driver.get(ReadConfigProperty.getAppURL());
	}

	public WebDriver initialization() throws Exception {
		String browser = ReadConfigProperty.readProperty("browser");
		logger.info("Initializing browser with name :- " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} 
		else {
			throw new Browser_NullException("Browser value is null in config file: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lanchingApplication();
		logger.info(browser + " browser initialized successfully");
		return driver;
	}
}
