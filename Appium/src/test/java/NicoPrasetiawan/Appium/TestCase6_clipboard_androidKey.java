package NicoPrasetiawan.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestCase6_clipboard_androidKey extends BaseTest{

	@Test
	public void landscapeAndClipboard() {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String actualText = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actualText, "WiFi settings");
		
		// Copy to clipboard
		driver.setClipboardText("Nico Wifi");
				
		// Paste from the clipboard
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());		
		
		// Android key button
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	
	
	

}
