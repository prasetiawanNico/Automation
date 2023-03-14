package NicoPrasetiawan.Appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestCase4 extends BaseTest{
	
	
	@Test
	public void swipeGallery() throws MalformedURLException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		
		Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
		
		swipeAction(firstImage, "left");
		
		Assert.assertEquals(firstImage.getAttribute("focusable"), "false");
		
		
	}

}
