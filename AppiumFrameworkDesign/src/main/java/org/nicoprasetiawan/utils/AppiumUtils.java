package org.nicoprasetiawan.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {
	
	AppiumDriver driver;
	
	public AppiumUtils(AppiumDriver driver) {
		this.driver = driver;
	}
	
	
	public double getFormatedAmount(String amount, int startingChar) {
		Double price = Double.parseDouble(amount.substring(startingChar));
		return price;
	}
	
	public void waitForElementToAppear(WebElement ele, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele), attribute, value));
	}

}
