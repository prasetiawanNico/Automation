package apkDemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestCase_3 extends BaseTest {
	
	public double getFormatedAmount(String amount, int startingChar) {
		Double price = Double.parseDouble(amount.substring(startingChar));
		return price;
	}
	
	@Test
	public void sumPrice() throws InterruptedException {
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sandra");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahrain\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bahrain']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// wait until the page fully loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		//com.androidsample.generalstore:id/productPrice"
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int productCount = productPrices.size();
		double totalSum = 0;
		
		for (int i = 0; i < productCount; i++) {
			String priceAmount = productPrices.get(i).getText();
			Double price = getFormatedAmount(priceAmount, 1);;
			totalSum = totalSum + price;
		}
		
		System.out.println(totalSum);
		
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		Double formatedSum = getFormatedAmount(displaySum, 1);
		
		Assert.assertEquals(totalSum, formatedSum);
		
		
	}
}
