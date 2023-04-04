package org.nicoprasetiawan.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	//(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	
	//(xpath = "//android.widget.RadioButton[@text='Male']")
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	WebElement submitButton;
	
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		if (gender.contains("female")) {
			femaleOption.click();
		} else {
			maleOption.click();
		}
	}
	
	public void submitForm() {
		submitButton.click();
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}

}
