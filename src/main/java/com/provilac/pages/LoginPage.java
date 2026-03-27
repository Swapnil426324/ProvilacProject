package com.provilac.pages;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.provilac.objrepository.LoginPage_ObjectRepository;
import com.provilac.utilities.ReadProperties;

public class LoginPage extends LoginPage_ObjectRepository{

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void typeMobileNumber(String mobile) {
		mobileNumber.sendKeys(mobile);
	}
	
	public void click_mobile_BTN() {
		verifyMobileNumber.click();
	}

	public void clickVerifyOTP_BTN() {
		verifyOTP_BTN.click();
	}
	
	
	// mobile error method
	public String mobileError(String mobile) {
		typeMobileNumber(mobile);
		return mobileError.getText();	
	}

	// mobile check Privacy policy
	public boolean check_Privacy_policy() {
		return terms_of_use_Privacy_policy.isSelected();
	}
	
	
	public String invalid_OTP() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		typeMobileNumber(ReadProperties.readConfig("mobile"));
		click_mobile_BTN();
		otpInputBox.sendKeys(ReadProperties.readConfig("invalidOTP"));
		clickVerifyOTP_BTN();
		Alert al =driver.switchTo().alert();
		String actualText = al.getText();
		al.accept();
		return actualText;
	}
	
	
	public void enter_Valid_OTP() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		typeMobileNumber(ReadProperties.readConfig("mobile"));
		click_mobile_BTN();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter OTP : ");
		String otp = sc.next();
		otpInputBox.sendKeys(otp);
		clickVerifyOTP_BTN();
		sc.close();
	}
	
	
	
	public boolean checkSetupProfileText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(nameInputbox));
		return ele.isEnabled();
	}
	
	
	public boolean check_referralCodeInputbox() {
		return referralCodeInputbox.isEnabled();
	}
	
	public String checkMobileError() {
		return mobileErrorMSG.getText();
	}
}
