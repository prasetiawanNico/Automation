package org.nicoprasetiawan;

import org.nicoprasetiawan.pageObjects.android.CartPage;
import org.nicoprasetiawan.pageObjects.android.FormPage;
import org.nicoprasetiawan.pageObjects.android.ProductCatalogue;
import org.testng.annotations.Test;

public class TestCase_3 extends BaseTest {
	
	
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

		
	}
}
