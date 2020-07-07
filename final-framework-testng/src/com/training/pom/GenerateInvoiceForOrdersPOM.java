package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenerateInvoiceForOrdersPOM {
private WebDriver driver; 	
	
	public GenerateInvoiceForOrdersPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Web element for View button
	@FindBy(xpath="//tr[1]//td[8]//a[1]")
	WebElement viewBtn;
	
	//Web element for Generate button
	@FindBy(xpath="//button[@id='button-invoice']//i[@class='fa fa-cog']")
	WebElement generateBtn;
	
	//Web element for Invoice number
	@FindBy(xpath="//td[@id='invoice']")
	WebElement invoiceNumber;
	
	//Method to click on View button
	public void clickViewBtn() {
		this.viewBtn.click();
	}
	
	//Method to click on Generate button
	public void clickGenerateBtn() {
		this.generateBtn.click();
	}
	
	//Method to check if Invoice number is displayed
	public boolean invoiceNumberDisplayed() {
		return this.invoiceNumber.isDisplayed();
	}
}
