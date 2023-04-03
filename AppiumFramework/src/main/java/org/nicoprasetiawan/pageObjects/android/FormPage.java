package org.nicoprasetiawan.pageObjects.android;

import org.nicoprasetiawan.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement radioMale;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement radioFemale;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		if (gender.contains("Male")) {
			radioMale.click();
		} else {
			radioFemale.click();
		}
	}
	
	public void setCountrySelection(String countryName) {
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	public void submitForm() {
		shopButton.click();
	}
	

}
