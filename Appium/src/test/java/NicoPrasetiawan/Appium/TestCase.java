package NicoPrasetiawan.Appium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestCase extends BaseTest{
	
	@Test
	public void settingWifiName() throws InterruptedException {
		
		/*
		 * If you want to use accessibilityId or androidIdUIAutomator, use command 'AppiumBy.'
		 * If you want to use xpath, use 'By.'
		 */
		
		// Click Preference
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		// Click Preference dependencies
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		// Check box
		driver.findElement(By.id("android:id/checkbox")).click();
		
		// Open up wifi settings field
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		// Ensure the pop up is appear
		String actualText = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actualText, "WiFi settings");
		
		// Typing
		driver.findElement(By.id("android:id/edit")).sendKeys("Test");
		
		// Click OK
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();		
	}

}
