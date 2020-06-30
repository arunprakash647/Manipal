package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductsPOM {
	private WebDriver driver; 	
	
	public DeleteProductsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody//tr[1]//td[1]//input[1]")
	private WebElement checkBox;
	
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMessage;
	
	public void selectCheckBox() {
		this.checkBox.click();
	}
	
	public void clickDeleteBtn() {
		this.deleteBtn.click();
	}
	
	public void successMessageDisplayed() {
		this.successMessage.isDisplayed();
	}

}
