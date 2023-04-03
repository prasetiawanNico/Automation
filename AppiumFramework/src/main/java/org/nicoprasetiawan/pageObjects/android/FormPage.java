package org.nicoprasetiawan.pageObjects.android;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage {
	
	//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sandra");
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

}
