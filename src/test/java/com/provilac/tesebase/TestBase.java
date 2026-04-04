package com.provilac.tesebase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.provilac.base.BaseClass;
import com.provilac.pages.LoginPage;
import com.provilac.pages.Provilac_LandingPage;

public class TestBase extends BaseClass{

	public Provilac_LandingPage plp = null;
	public LoginPage lp;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = initialization();
		plp = new Provilac_LandingPage(driver);
		lp = new LoginPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
