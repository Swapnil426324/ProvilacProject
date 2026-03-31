package com.provilac.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provilac.objrepository.LoginPage_ObjectRepository;

public class LoginPage extends LoginPage_ObjectRepository{

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// enter mobile number
	public void enter_Mobile_Number(String mobile) {
		mobileNumber.sendKeys(mobile);
	}
	
	// clcik Verify Mobile Number With OTP button
	public void click_mobileNumberWithOTP_BTN() {
		verifyMobileNumber.click();
	}
	
	// enter otp
	public void enterOTP(String otp) {
		otpInputBox.sendKeys(otp);
	}

	//click Verify with OTP button
	public void clickVerifywithOTP_BTN() {
		verifyOTP_BTN.click();
	}
	
	// mobile check Privacy policy
	public boolean check_Privacy_policy() {
		return terms_of_use_Privacy_policy.isSelected();
	}
	
    //check enter name input box enable
	public boolean checkEnterNameInputBox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(nameInputbox));
		return ele.isEnabled();
	}
	
	
	//check referral Code Inputbox is enale
	public boolean check_referralCodeInputbox() {
		return referralCodeInputbox.isEnabled();
	}
	
	public String checkMobileErrorMSG() {
		return mobileErrorMSG.getText();
	}
}
