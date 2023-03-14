package NicoPrasetiawan.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestCase2 extends BaseTest{
	
	@Test
	public void longPress() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text= 'People Names']"));
		longPress(element);
		
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		String textView1 = driver.findElement(By.xpath("(//android.widget.TextView)[1]")).getText();
		Assert.assertEquals(textView1, "Sample menu");
		
		String textView2 = driver.findElement(By.xpath("(//android.widget.TextView)[2]")).getText();
		Assert.assertEquals(textView2, "Sample action");

		
	}

}
