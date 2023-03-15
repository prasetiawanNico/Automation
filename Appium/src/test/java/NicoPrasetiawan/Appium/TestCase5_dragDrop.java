package NicoPrasetiawan.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestCase5_dragDrop extends BaseTest{
	
	@Test
	public void dragAndDrop() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		dragDropActionn(source, 830, 740);
		
		Thread.sleep(3000);
		
		String resultText = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(resultText, "Dropped!");
		
		
	}

}
