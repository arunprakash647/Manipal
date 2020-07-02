package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProductsPOM {
	
	private WebDriver driver; 	
	
	public EditProductsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Web element for edit button
	@FindBy(xpath="//td[@class='text-right']//a[@class='btn btn-primary']")
	WebElement editBtn;
	
	//Web element for data tab menu
	@FindBy(xpath="//a[contains(text(),'Data')]")
	WebElement dataTab;
	
	//Web element for quantity field
	@FindBy(id="input-quantity")
	WebElement quantityField;
	
	//Web element for Save buttin
	@FindBy(xpath="//i[@class='fa fa-save']")
	WebElement saveBtn;
	
	//Web element for Success message
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMessage;
	
	//Method to click on edit button
	public void clickEditBtn() {
		this.editBtn.click();
	}
	
	//Method to click on Data tab
	public void clickDataTab() {
		this.dataTab.click();
	}
	
	//Method to clear the data in the quantity field and update it with the desire value 
	public void editQuantity(String quantity) {
		this.quantityField.clear();
		this.quantityField.sendKeys(quantity);
	}
	
	//method to click on Save button
	public void clickSaveBtn() {
		this.saveBtn.click();
	}
	
	//Method to get the success message text
	public String successMessageGetText() {
		return this.successMessage.getText();
	}

}
