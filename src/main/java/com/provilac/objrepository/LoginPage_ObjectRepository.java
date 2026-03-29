package com.provilac.objrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_ObjectRepository {

	@FindBy(xpath = "//input[@name='mobileNumber']")
	protected WebElement mobileNumber;
	
	@FindBy(xpath = "//button[@id='otp-btn']")
	protected WebElement verifyMobileNumber;

	@FindBy(xpath = "//input[@inputmode='numeric']")
	protected WebElement otpInputBox;
	
	@FindBy(xpath = "//button[@class='retry-btn-outline-primary-orange']")
	protected WebElement verifyOTP_BTN;
	
	@FindBy(xpath = "//input[@placeholder='Enter Name']")
	protected WebElement nameInputbox;
	
	@FindBy(xpath = "//input[@id='check-terms']")
	protected WebElement terms_of_use_Privacy_policy;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']/child::div")
	protected WebElement mobileError;
	
	@FindBy(xpath = "//input[@formcontrolname='referralCode']")
	protected WebElement referralCodeInputbox;
	
	@FindBy(xpath = "//div[contains(text(),'Please enter')]")
	protected WebElement mobileErrorMSG;
}
