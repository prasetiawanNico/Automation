package org.nicoprasetiawan;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

import org.testng.AssertJUnit;
import org.nicoprasetiawan.pageObjects.android.CartPage;
import org.nicoprasetiawan.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends AndroidBaseTest {
	
	@BeforeMethod
	public void setHomePage() {
		formPage.setActivity();
	}
	
	
	@Test(dataProvider = "getData")
	public void sumPrice(String name, String gender, String country) throws InterruptedException {
		
		//FormPage formPage = new FormPage(driver);
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountrySelection(country);
		ProductCatalogue productCatalogue = formPage.submitForm();
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCartPage();
				
		
		cartPage.waitForElement("text", "Cart");
				
		
		double totalSum = cartPage.getProductSum();
		double TotalAmountDisplayed = cartPage.getTotalAmountDisplayed();
		
		AssertJUnit.assertEquals(totalSum, TotalAmountDisplayed);
		
		cartPage.acceptTerms();
		cartPage.submitOrder();
		
		Thread.sleep(3000);
	}
	
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			{"Sandra", "female", "Bahrain"},
			{"Nico", "male", "Argentina"}
		};
	}
	
	
}
