package org.nicoprasetiawan;

import org.nicoprasetiawan.pageObjects.android.CartPage;
import org.nicoprasetiawan.pageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends AndroidBaseTest {
	
	
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
				
		
		cartPage.waitForElement("text", "Cart");
				
		
		double totalSum = cartPage.getProductSum();
		double TotalAmountDisplayed = cartPage.getTotalAmountDisplayed();
		
		Assert.assertEquals(totalSum, TotalAmountDisplayed);
		
		cartPage.acceptTerms();
		cartPage.submitOrder();
		
		
		
	}
}
