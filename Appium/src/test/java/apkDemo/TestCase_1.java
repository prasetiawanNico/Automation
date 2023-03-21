package apkDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestCase_1 extends BaseTest{
	
	@Test
	public void fillFormNegative() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		String actualToastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		String expectedToatsMesesage = "Please enter your name";
		Assert.assertEquals(actualToastMessage, expectedToatsMesesage);
	}
	
	
	@Test
	public void fillForm() throws InterruptedException {		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sandra");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahrain\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bahrain']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
	}
	
	

	
	
}
