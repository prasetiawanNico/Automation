package apkDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{
	
	@Test
	public void browserTest() throws InterruptedException {
		
//		driver.get("http://google.com");
//		driver.findElement(By.name("q")).sendKeys("Jambi");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		Thread.sleep(9000);
		
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class=\"navbar-toggler-icon\"]")).click();
		
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", ""); //scroll the page
		driver.findElement(By.cssSelector("a[href*='products/3']")).click();
		Thread.sleep(9000);
		
	}

}
