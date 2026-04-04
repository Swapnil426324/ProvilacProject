package com.provilac.testcases;

import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.provilac.tesebase.TestBase;
import com.provilac.utilities.ReadConfigProperty;
import com.provilac.utilities.ReadExcel;

public class LoginTest extends TestBase{

	@Test(priority = 1, dataProvider = "mobile")
	public void verify_mobile(String mobile, String result) {
		lp = plp.clickLoginOption();
		lp.enter_Mobile_Number(mobile);
		Assert.assertEquals(lp.checkMobileErrorMSG(), result);
	}
	
	@Test(priority = 2)
	public void verify_Invalid_OTP() {
		lp = plp.clickLoginOption();
		lp.enter_Mobile_Number(ReadConfigProperty.getMobileNumber());
		lp.click_mobileNumberWithOTP_BTN();
		lp.enterOTP(ReadConfigProperty.getInvalidOTP());
		lp.clickVerifywithOTP_BTN();
		Alert al =driver.switchTo().alert();
		String actualText = al.getText();
		al.accept();
		Assert.assertEquals(actualText, "Invalid OTP.");
	}
	
	
	@Test(priority = 3)
	public void verify_validOTP() {
		lp = plp.clickLoginOption();
		lp.enter_Mobile_Number(ReadConfigProperty.getMobileNumber());
		lp.click_mobileNumberWithOTP_BTN();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter OTP : ");
		String otp = sc.next();
		lp.enterOTP(otp);
		sc.close();
		lp.clickVerifywithOTP_BTN();
		Assert.assertTrue(lp.checkEnterNameInputBox());
	}
	
	@Test(priority = 4)
	public void verify_referralCodeInputBoxIsEnable() {
		lp = plp.clickLoginOption();
		Assert.assertTrue(lp.check_referralCodeInputbox());
	}
	
	@Test(priority = 5)
	public void verify_Privacy_Policy() {
		lp = plp.clickLoginOption();
		Assert.assertTrue(lp.check_Privacy_policy());
	}
	


	
	@DataProvider(name = "mobile")
	public String[][] mobileData() throws Exception {
		return ReadExcel.excelRead("DataTest", "mobileData");
	}
	
}
