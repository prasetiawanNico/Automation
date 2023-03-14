package NicoPrasetiawan.Appium;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestCase3 extends BaseTest{
	
	@Test
	public void scrollPage() throws MalformedURLException, InterruptedException{
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Where the scroll is known prior
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Search View\"));"));
		
		Thread.sleep(1000);
		
		// No idea how the scroll is
		scrollToEndAction();
	
		
		
		
	}
	
	

}
