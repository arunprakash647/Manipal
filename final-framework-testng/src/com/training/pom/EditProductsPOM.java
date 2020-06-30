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
	
	@FindBy(xpath="//td[@class='text-right']//a[@class='btn btn-primary']")
	WebElement editBtn;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	WebElement dataTab;
	
	@FindBy(id="input-quantity")
	WebElement quantityField;
	
	@FindBy(xpath="//i[@class='fa fa-save']")
	WebElement saveBtn;
	
	public void clickEditBtn() {
		this.editBtn.click();
	}
	
	public void clickDataTab() {
		this.dataTab.click();
	}
	
	public void editQuantity(String quantity) {
		this.quantityField.clear();
		this.quantityField.sendKeys(quantity);
	}
	
	public void clickSaveBtn() {
		this.saveBtn.click();
	}

}
