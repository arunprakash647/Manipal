package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteMultipleProductsPOM {
	private WebDriver driver; 	
	
	public DeleteMultipleProductsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//We element for selecting multiple check boxes
	@FindBy(xpath="//thead//input")
	private WebElement checkMultipleBox;
	
	//Method for selecting multiple check boxes
	public void selectMultipleCheckBox() {
		this.checkMultipleBox.click();
	}
}
