package org.nicoprasetiawan;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.nicoprasetiawan.pageObjects.android.CartPage;
import org.nicoprasetiawan.pageObjects.android.ProductCatalogue;

public class TestCase extends AndroidBaseTest {
	
	@BeforeMethod
	public void setHomePage() {
		formPage.setActivityToHomepage();
	}
	
	
	@Test(dataProvider = "getData")
//	public void sumPrice(String name, String gender, String country) throws InterruptedException 
	public void sumPrice(HashMap<String, String> input) throws InterruptedException
	{
		//FormPage formPage = new FormPage(driver);
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
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
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data = getJasonData(System.getProperty("user.dir")+"//src//test//java//org//nicoprasetiawan//testData//eCommerce.json");
		
//		return new Object[][] {
//			{"Sandra", "female", "Bahrain"},
//			{"Nico", "male", "Argentina"}
//		};
		
		return new Object[][] {
			{data.get(0)},
			{data.get(1)}
		};
		
	}
	
	
}
