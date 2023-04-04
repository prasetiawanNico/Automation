package org.nicoprasetiawan;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.nicoprasetiawan.pageObjects.android.FormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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
		formPage.setNameField("Nico");
		formPage.setGender("female");
		formPage.submitForm();
		
		
		
//		driver.findElement(By.id("android:id/text1")).click();
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahrain\"));"));
//		driver.findElement(By.xpath("//android.widget.TextView[@text='Bahrain']")).click();
//		
//		
//		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);

		
	}
}
