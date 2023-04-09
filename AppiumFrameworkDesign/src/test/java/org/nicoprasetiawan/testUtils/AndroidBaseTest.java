package org.nicoprasetiawan.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.nicoprasetiawan.pageObjects.android.FormPage;
import org.nicoprasetiawan.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils{
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	
	@BeforeClass
	// Start Appium server
	public void startExecution() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//nicoprasetiawan//resources//data.properties");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		
		service = startAppiumServer(ipAddress, Integer.parseInt(port));
	
		
		UiAutomator2Options caps = new UiAutomator2Options();
		caps.setDeviceName(prop.getProperty("androidDeviceName")); //executed on emulator
		//caps.setDeviceName("Android Device"); //executed on real / plugged device
		
		//caps.setChromedriverExecutable("/Users/nicoprasetiawan/Documents/drivers/chromedriver/chromedriver91");
		//caps.setChromedriverExecutable("D:\\Driver\\chromedriver.exe"); 
		caps.setChromedriverExecutable(System.getProperty("user.dir")+"//src//test//java//driver//chromedriver91_IOS");
		//caps.setApp("D:\\GitStuff\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		//caps.setApp("/Users/nicoprasetiawan/Documents/Eclipse-workspace/GitStuffPersonal/Automation/Appium/src/test/java/resources/General-Store.apk");
		caps.setApp(System.getProperty("user.dir")+"//src//test//java//org//nicoprasetiawan//resources//General-Store.apk");
		
		//caps.setCapability("autoGrantPermissions", "true");
		
		
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
		driver = new AndroidDriver(service.getUrl(), caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		formPage = new FormPage(driver);
	}
	
		
	
	@AfterClass
	public void stopExecution() {
		driver.quit();
		service.stop();
	}
	
}
