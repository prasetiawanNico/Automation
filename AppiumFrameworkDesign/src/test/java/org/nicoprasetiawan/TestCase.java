package org.nicoprasetiawan;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.nicoprasetiawan.pageObjects.android.CartPage;
import org.nicoprasetiawan.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends AndroidBaseTest {
	
	
	@Test
	public void sumPrice() throws InterruptedException {
		
		//FormPage formPage = new FormPage(driver);
		formPage.setNameField("TestCase");
		formPage.setGender("female");
		formPage.setCountrySelection("Bahrain");
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
	}
	
}
