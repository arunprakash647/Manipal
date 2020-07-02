package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsFilterPOM {
	private WebDriver driver; 	
	
	public ProductsFilterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Web element for Catlog icon
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement catlogIcon; 
	
	//Web element for Products icon
	@FindBy(xpath="//li[@id='catalog']//ul//li//a[contains(text(),'Products')]")
	private WebElement productsIcon;
	
	//Web element for Product Name field
	@FindBy(id="input-name")
	private WebElement productNameField;
	
	//Web element for Filter button
	@FindBy(id="button-filter")
	private WebElement filterBtn;
	
	//Web element for 
	@FindBy(css="div.container-fluid:nth-child(2) div.panel.panel-default div.panel-body div.table-responsive table.table.table-bordered.table-hover tbody:nth-child(2) tr:nth-child(1) > td.text-left:nth-child(3)")
	private WebElement resultVerify;
	
	//Method mouse over Catlog icon
	public void mouseOverCatlog() {
		Actions action = new Actions(driver);
		action.moveToElement(catlogIcon).build().perform();
	}
	
	//Method to click on Products icon
	public void clickProducts() {
		Actions action = new Actions(driver);
		action.moveToElement(productsIcon).click().build().perform();
	}
	
	//Method to enter Product name
	public void sendProductName(String productName) {
		this.productNameField.sendKeys(productName);
	}
	
	//Method to click on Filter button
	public void clickFilterBtn() {
		this.filterBtn.click();
	}
	
	//Method to check  if the filtered list is correct
	public String resultVerifyGetText() {
		return this.resultVerify.getText();
	}

}
