package com.provilac.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.provilac.base.BaseClass;
import com.provilac.pages.Provilac_LandingPage;

public class LandingPageTest extends BaseClass {

	WebDriver driver;
	Provilac_LandingPage plp = null;
	
	@BeforeMethod
	public void setUp() {
		driver = initialization();
		plp = new Provilac_LandingPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verify_provilacLogo() {
		Assert.assertTrue(plp.checkProvilacLogo());
	}
	
	@Test(priority = 2)
	public void verify_checkNavItem() {
		Assert.assertTrue(plp.checkNavItem());
	}
	
	@Test(priority = 3)
	public void verify_checkAllCitiesName() {
		Assert.assertTrue(plp.checkAllCities());
	}
	
	@Test(priority = 4)
	public void verify_ClickLogin() {
		plp.getLoginPage();
		Assert.assertEquals(plp.getLoginPageHeading(), "Get started");
	}
	
	@Test(priority = 5)
	public void verify_MoveToDropdown() {
		plp.moveToAllDropwon();
	}
}


