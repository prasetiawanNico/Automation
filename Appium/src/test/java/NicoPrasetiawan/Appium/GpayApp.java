package NicoPrasetiawan.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class GpayApp extends BaseTest{
	
	@Test
	public void login() throws InterruptedException {
		
		
		driver.findElement(AppiumBy.accessibilityId("Selanjutnya")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.accessibilityId("Selanjutnya")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(AppiumBy.accessibilityId("Selanjutnya")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@text = 'Nomor Tanpa Kode Negara']")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@text = 'Nomor Tanpa Kode Negara']")).sendKeys("85717361690");
		
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Selanjutnya\"]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.EditText")).click();
		
		driver.hideKeyboard();
		
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("172839");
		
		Thread.sleep(3000);
		
	}
	
	
	@Test
	public void pulsa() {
		
		driver.findElement(AppiumBy.accessibilityId("Pulsa")).click();
		
		
		
	}

}
