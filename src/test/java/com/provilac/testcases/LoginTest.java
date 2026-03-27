package com.provilac.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.provilac.base.BaseClass;
import com.provilac.pages.LoginPage;
import com.provilac.pages.Provilac_LandingPage;
import com.provilac.utilities.ExcelUtils;
import com.provilac.utilities.ReadExcel;
import com.provilac.utilities.ReadProperties;

public class LoginTest extends BaseClass{
	
	WebDriver driver;
	
	Provilac_LandingPage plp;
	LoginPage lp;
	
	@BeforeMethod
	public void setUp() {
		driver = initialization();
		plp = new Provilac_LandingPage(driver);
		lp = plp.getLoginPage();
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void verify_Privacy_Policy() {
		Assert.assertTrue(lp.check_Privacy_policy());
	}
	
	@Test
	public void verify_MobileError() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertEquals(lp.mobileError(ReadProperties.readConfig("invalidmobile")), "Please enter valid 10 digit mobile number.");
	}
	

	@Test
	public void verify_Invalid_OTP() {
		Assert.assertEquals(lp.invalid_OTP(), "Invalid OTP.");
	}
	
	@Test
	public void verify_validOTP() {
		lp.enter_Valid_OTP();
		Assert.assertTrue(lp.checkSetupProfileText());
	}
	
	@Test
	public void verify_referralCodeInputBox() {
		Assert.assertTrue(lp.check_referralCodeInputbox());
	}
	
	@Test(dataProvider = "mobile")
	public void verify_mobile(String mobile, String result) {
		lp.typeMobileNumber(mobile);
		Assert.assertEquals(lp.checkMobileError(), result);
	}

	
	@DataProvider(name = "mobile")
	public String[][] mobileData() throws Exception {
		return ReadExcel.excelRead("DataTest", "mobileData");
	}
	
}
