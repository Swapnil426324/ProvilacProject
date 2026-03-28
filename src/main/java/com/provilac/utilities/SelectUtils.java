package com.provilac.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;

public class SelectUtils {

	public static void selectCity(List<WebElement> allCities, String city) {
		for (WebElement cityName : allCities) {
			String actualCity = cityName.getText().trim();

	        if (actualCity.equalsIgnoreCase(city)) {
	        	cityName.click();
	            break;
	        }
		}
	}
}
