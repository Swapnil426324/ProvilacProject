package com.provilac.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.provilac.tesebase.TestBase;

public class LandingPageTest extends TestBase {


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
	public void verify_Click_Login_Button() {
		plp.clickLoginOption();
		Assert.assertEquals(plp.getLoginPageHeading(), "Get started");
	}

	@Test(priority = 5)
	public void verify_MoveToDropdown() {
		plp.moveToAllDropwon();
	}
}
