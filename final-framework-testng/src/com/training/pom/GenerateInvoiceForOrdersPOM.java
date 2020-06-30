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
	
	@FindBy(xpath="//tr[1]//td[8]//a[1]")
	WebElement viewBtn;
	
	@FindBy(xpath="//button[@id='button-invoice']//i[@class='fa fa-cog']")
	WebElement generateBtn;
	
	@FindBy(xpath="//td[@id='invoice']")
	WebElement invoiceNumber;
	
	public void clickViewBtn() {
		this.viewBtn.click();
	}
	
	public void clickGenerateBtn() {
		this.generateBtn.click();
	}
	
	public void invoiceNumberDisplayed() {
		this.invoiceNumber.isDisplayed();
	}
}
