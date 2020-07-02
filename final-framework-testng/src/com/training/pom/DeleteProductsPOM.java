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
	
	//Web element for selecting check box
	@FindBy(xpath="//tbody//tr[1]//td[1]//input[1]")
	private WebElement checkBox;
	
	//Web element for delete button
	@FindBy(xpath="//i[@class='fa fa-trash-o']")
	private WebElement deleteBtn;
	
	//Web element for Success message
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMessage;
	
	//Method to select the desired check box
	public void selectCheckBox() {
		this.checkBox.click();
	}
	
	//Method to click delete button
	public void clickDeleteBtn() {
		this.deleteBtn.click();
	}
	
	//Method to get the success message text
	public String successMessageGetText() {
		return this.successMessage.getText();
	}

}
