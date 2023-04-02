package apkDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{
	
	@Test
	public void browserTest() throws InterruptedException {
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Jambi");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(9000);
		
	}

}
