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
	
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement catlogIcon; 
	
	@FindBy(xpath="//li[@id='catalog']//ul//li//a[contains(text(),'Products')]")
	private WebElement productsIcon;
	
	@FindBy(id="input-name")
	private WebElement productNameField;
	
	@FindBy(id="button-filter")
	private WebElement filterBtn;
	
	@FindBy(css="div.container-fluid:nth-child(2) div.panel.panel-default div.panel-body div.table-responsive table.table.table-bordered.table-hover tbody:nth-child(2) tr:nth-child(1) > td.text-left:nth-child(3)")
	private WebElement resultVerify;
	
	public void mouseOverCatlog() {
		Actions action = new Actions(driver);
		action.moveToElement(catlogIcon).build().perform();
	}
	
	public void clickProducts() {
		Actions action = new Actions(driver);
		action.moveToElement(productsIcon).click().build().perform();
	}
	
	public void sendProductName(String productName) {
		this.productNameField.sendKeys(productName);
	}
	
	public void clickFilterBtn() {
		this.filterBtn.click();
	}
	
	public String resultVerifyGetText() {
		return this.resultVerify.getText();
	}

}
