package NicoPrasetiawan.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class TestCase7_jumpToSpecificPage extends BaseTest{
	
	@Test
	public void jumpToSpecificPage() {
		
		// App package & App activity
		// mac: adb shell dumpsys window | grep -E 'mCurrentFocus'
		// windows: adb shell dumpsys window | find "mCurrentFocus"
		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		
		
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("Test");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}

}
