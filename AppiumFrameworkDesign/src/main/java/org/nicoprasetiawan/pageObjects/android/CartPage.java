package org.nicoprasetiawan.pageObjects.android;

import java.nio.file.WatchEvent;
import java.util.List;

import org.nicoprasetiawan.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement terms;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	private WebElement toolbatTitle;
	
	
	
	public void waitForElement(String attribute, String value) {
		waitForElementToAppear(toolbatTitle, attribute, value, driver);
	}
	
	public List<WebElement> getProductList() {
		return productList;
	}
	
	public double getProductSum() {
		int productCount = productList.size();
		double totalSum = 0;
		
		for (int i = 0; i < productCount; i++) {
			String priceAmount = productList.get(i).getText();
			Double price = getFormatedAmount(priceAmount, 1);;
			totalSum = totalSum + price;
		}
		
		return totalSum;
	}
	
	public double getTotalAmountDisplayed() {
		return getFormatedAmount(totalAmount.getText(), 1);
	}
	
	public void acceptTerms() {
		longPress(terms);
		acceptButton.click();
	}
	
	public void submitOrder() {
		checkBox.click();
		proceed.click();
	}


}
