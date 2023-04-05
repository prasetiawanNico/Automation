package org.nicoprasetiawan;

import java.time.Duration;
import java.util.List;

import org.nicoprasetiawan.pageObjects.android.CartPage;
import org.nicoprasetiawan.pageObjects.android.FormPage;
import org.nicoprasetiawan.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestCase extends BaseTest {
	
	
	@Test
	public void sumPrice() throws InterruptedException {
		
		//FormPage formPage = new FormPage(driver);
		formPage.setNameField("Nico");
		formPage.setGender("female");
		formPage.setCountrySelection("Bahrain");
		ProductCatalogue productCatalogue = formPage.submitForm();
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCartPage();
				
		
		Thread.sleep(3000);
				
		
		double totalSum = cartPage.getProductSum();
		double getTotalAmountDisplayed = cartPage.getTotalAmountDisplayed();
		
		Assert.assertEquals(totalSum, getTotalAmountDisplayed);
		
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
		
		
		
	}
}
