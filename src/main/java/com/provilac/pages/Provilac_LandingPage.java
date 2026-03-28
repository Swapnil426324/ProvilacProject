package com.provilac.pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.provilac.objrepository.LandingPage_ObjectRepository;
import com.provilac.utilities.ReadExcelUtils;
import com.provilac.utilities.SelectUtils;

public class Provilac_LandingPage extends LandingPage_ObjectRepository{

	WebDriver driver;
	
	public Provilac_LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectCity() {
		selectCity.click();
	}
	
	public void clickCrossButton() {
		crossButton.click();
	}
	
	public void clickGuestUser() {
		guestUser.click();
	}
	
	public void clickLoginButton() {
		clickLogin.click();
	}
	
	public boolean checkProvilacLogo() {
		return provilacLogo.isDisplayed();
	}
	
	public String getLoginPageHeading() {
		return heading.getText();
	}
	
	public LoginPage getLoginPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		SelectUtils.selectCity(allCities, "Pune");
		clickGuestUser();
		clickLoginButton();
		return new LoginPage(driver);
	}
	
	
	//check all cities
	public boolean checkAllCities() {
		ArrayList<String> actualCity = new ArrayList<>();
		for (WebElement cities : allCities) {
			String city = cities.getText();
			actualCity.add(city);
		}
		
		ArrayList<String> expectedList = new ArrayList<>();
		for(int i=7;i<=12;i++) {
			for(int j=0;j<1;j++) {
				String expectedText = ReadExcelUtils.excelRead("DataTest", "Sheet1", i, j);
				expectedList.add(expectedText);
			}
		}
		System.out.println("actualCity >> "+actualCity);
		System.out.println("expectedList >> "+expectedList);
		if(actualCity.equals(expectedList)) {
			return true;
		}
		return false;
	}
	
	
	//check navbar list
	public boolean checkNavItem() {
		ArrayList<String> actList = new ArrayList<>();
		for (WebElement items : navItem) {
			actList.add(items.getText());
		}
		
		ArrayList<String> expectedList = new ArrayList<>();
		for(int i=1;i<=4;i++) {
			for(int j=0;j<1;j++) {
				String expectedText = ReadExcelUtils.excelRead("DataTest", "Sheet1", i, j);
				expectedList.add(expectedText);
			}
		}
		System.out.println("actList >> "+actList);
		System.out.println("expectedList >> "+expectedList);
		if(actList.equals(expectedList)) {
			return true;
		}
		return false;
	}
	
	
	public void moveToAllDropwon() {
		Actions act = new Actions(driver);
		for (WebElement ele : allDropdown) {
			act.moveToElement(ele).pause(2000).build().perform();
		}
	}
	
}
