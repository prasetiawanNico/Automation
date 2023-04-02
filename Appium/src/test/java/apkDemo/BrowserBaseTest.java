package apkDemo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	// Start Appium server
	public void startExecution() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				//.withAppiumJS(new File("C:\\Users\\GPay-User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withAppiumJS(new File ("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();
	
		
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setDeviceName("Pixel4");
		caps.setChromedriverExecutable("/Users/nicoprasetiawan/Documents/drivers/chromedriver/chromedriver91");
		caps.setCapability("browserName", "Chrome");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass
	public void stopExecution() {
		driver.quit();
		service.stop();
	}
	
}
