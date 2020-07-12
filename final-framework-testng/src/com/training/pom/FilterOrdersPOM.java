package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterOrdersPOM {
	private WebDriver driver; 	
	
	public FilterOrdersPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Web element for Sales icon
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fa-fw']")
	private WebElement salesIcon;
	
	//Web element for orders icon
	@FindBy(xpath="//li[@id='sale']//li[@class='active open']//a[contains(text(),'Orders')]")
	private WebElement ordersIcon;
	
	//Web element for Date modified field
	@FindBy(id="input-date-modified")
	private WebElement dateModified;
	
	//Web element for Date added field
	@FindBy(id="input-date-added")
	private WebElement dateAdded;
	
	//Web element for filter button
	@FindBy(id="button-filter")
	private WebElement filterBtn;
	
	//Web element for Date added column in the list
	@FindBy(xpath="//div[@id='container']//tbody//td[6]")
	private WebElement listDateAdded;
	
	//Method to mouse over Sales icon
	public void moveOverSales() {
		Actions action = new Actions(driver);
		action.moveToElement(salesIcon).build().perform();
	}
	
	//Method to click on Order icon
//	public void clickOrders() {
//		Actions action = new Actions(driver);
//		action.moveToElement(ordersIcon).click().build().perform();
//	}
	
	public void clickOrders() {
		this.ordersIcon.click();
	}
	
	//Method to enter date in Date Added field
	public void sendDateAdded(String date) {
		this.dateAdded.sendKeys(date);
	}
	
	//Method to enter date in Date modified field
	public void sendDateModified(String date) {
		this.dateModified.sendKeys(date);
	}
	
	//Method to click on filter button
	public void clickFilterBtn() {
		this.filterBtn.click();
	}
	
	//Method to get text for Date added column
	public String listDateAddedGetText() {
		return this.listDateAdded.getText();
	}
}
