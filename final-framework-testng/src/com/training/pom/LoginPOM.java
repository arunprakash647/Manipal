package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//Web element for Username field
	@FindBy(id="input-username")
	private WebElement userName; 
	
	//Web element for Password field
	@FindBy(id="input-password")
	private WebElement password;
	
	//Web element for Login button field
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	//Web element for Logout button field
	@FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md']")
	private WebElement logoutBtn;
	
	//Method to Clear any data in Username field and enter the correct Username
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	//Method to Clear any data in Password field and enter the correct Password
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//Method to click on Login button
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	//Method to click on Logout button
	public void clickLogoutBtn() {
		this.logoutBtn.click(); 
	}
	
	public boolean logoutBtnDisplayed() {
		return this.logoutBtn.isDisplayed();
	}
}
