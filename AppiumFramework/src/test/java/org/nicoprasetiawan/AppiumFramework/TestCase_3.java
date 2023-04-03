package org.nicoprasetiawan.AppiumFramework;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.nicoprasetiawan.pageObjects.android.FormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestCase_3 extends BaseTest {
	
	
	@Test
	public void sumPrice() throws InterruptedException {
		
		FormPage formPage = new FormPage(driver);
		
		formPage.setNameField("Nico Prasetiawan");
		formPage.setGender("Male");
		formPage.setCountrySelection("Bahrain");
		formPage.submitForm();
		
		
		
		
		
		Thread.sleep(3000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// wait until the page fully loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		//com.androidsample.generalstore:id/productPrice"
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int productCount = productPrices.size();
		double totalSum = 0;
		
		for (int i = 0; i < productCount; i++) {
			String priceAmount = productPrices.get(i).getText();
			Double price = getFormatedAmount(priceAmount, 1);;
			totalSum = totalSum + price;
		}
		
		System.out.println(totalSum);
		
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		Double formatedSum = getFormatedAmount(displaySum, 1);
		
		Assert.assertEquals(totalSum, formatedSum);
		
		WebElement element = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPress(element);
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(8000);
		
		
		Set <String> contexts = driver.getContextHandles();
		for (String contextName :contexts) {
			System.out.println(contextName);
		}
		
		// switch the context to webview
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Automation test");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		// switch back to native
		driver.context("NATIVE_APP");
		
	}
}
