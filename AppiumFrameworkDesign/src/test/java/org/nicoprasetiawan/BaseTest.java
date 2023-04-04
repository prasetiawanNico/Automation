package org.nicoprasetiawan;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.nicoprasetiawan.pageObjects.android.FormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	
	@BeforeClass
	// Start Appium server
	public void startExecution() throws MalformedURLException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\GPay-User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				//.withAppiumJS(new File ("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();
	
		
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setDeviceName("Pixel_6_Pro"); //executed on emulator
		//caps.setDeviceName("Android Device"); //executed on real / plugged device
		
		//caps.setChromedriverExecutable("/Users/nicoprasetiawan/Documents/drivers/chromedriver/chromedriver91");
		caps.setChromedriverExecutable("D:\\Driver\\chromedriver.exe");
		caps.setApp("D:\\GitStuff\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		//caps.setApp("/Users/nicoprasetiawan/Documents/Eclipse-workspace/GitStuffPersonal/Automation/Appium/src/test/java/resources/General-Store.apk");
		
		//caps.setCapability("autoGrantPermissions", "true");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		formPage = new FormPage(driver);
	}
	
		
	
	@AfterClass
	public void stopExecution() {
		driver.quit();
		service.stop();
	}
	
}
