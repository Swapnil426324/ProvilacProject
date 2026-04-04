package com.provilac.objrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provilac.base.BaseClass;

public class LandingPage_ObjectRepository extends BaseClass{

	@FindBy(xpath = "//a[text()='Pune']")
	protected WebElement selectCity;

	@FindBy(xpath = "//img[@alt='cross'])[2]")
	protected WebElement crossButton;

	@FindBy(xpath = "//a[normalize-space()='Guest']")
	protected WebElement guestUser;

	@FindBy(xpath = "//div[@class='dropdown-item cursor-pointer']")
	protected WebElement clickLogin;

	@FindBy(xpath = "//li[@class='nav-item']")
	protected List<WebElement> navItem;

	@FindBy(xpath = "//img[@alt='Provilac']")
	protected WebElement provilacLogo;
	
	@FindBy(xpath = "//div[@class='btn_text_div']/a")
	protected List<WebElement> allCities;
	
	@FindBy(xpath = "//div[@class='dropdown-menu user-profile-menu show']/child::a")
	protected List<WebElement> allDropdown;
	
	@FindBy(xpath = "//h2[text()='Get started']")
	protected WebElement heading;

}
