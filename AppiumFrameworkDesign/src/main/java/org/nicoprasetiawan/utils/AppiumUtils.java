package org.nicoprasetiawan.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	public AppiumDriverLocalService service;
	
//	AppiumDriver driver;
//	
//	public AppiumUtils(AppiumDriver driver) {
//		this.driver = driver;
//	}
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
		service = new AppiumServiceBuilder()
				//.withAppiumJS(new File("C:\\Users\\GPay-User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withAppiumJS(new File ("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress)
				.usingPort(port)
				.build();
		service.start();
		return service;
	}
	
	public List<HashMap<String,String>> getJasonData(String jsonFilePath) throws IOException {
		
		//convert json file content to json string
		String jsonContent = FileUtils.readFileToString(new File (jsonFilePath), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		
		return data;
	}
	
	
	public double getFormatedAmount(String amount, int startingChar) {
		Double price = Double.parseDouble(amount.substring(startingChar));
		return price;
	}
	
	public void waitForElementToAppear(WebElement ele, String attribute, String value, AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele), attribute, value));
	}

}
