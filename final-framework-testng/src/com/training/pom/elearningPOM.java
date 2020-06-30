package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class elearningPOM {
	WebDriver driver;
	public elearningPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath="//a[contains(text(),'Sign up!')]")
		private WebElement SignupTeacher;
		
		@FindBy(xpath="/html[1]/body[1]/main[1]/section[1]/div[1]/div[2]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[2]/label[1]/input[1]")
		private WebElement Teachcourses;
		
		@FindBy(name="firstname")
		private WebElement Firstname;
		
		@FindBy(name="lastname")
		private WebElement lastname;
		
		@FindBy(name="email")
		private WebElement email;
		
		@FindBy(name="username")
		private WebElement Username;
		
		@FindBy(name="pass1")
		private WebElement Password;
		
		@FindBy(name="pass2")
		private WebElement ConfirmPassword;
		
		@FindBy(name="phone")
		private WebElement Phone;
		
		@FindBy(xpath="//div[text()='English']")
		private WebElement Language;
		
		@FindBy(name="submit")
		private WebElement RegisterBtn;
		
		public void sendFirstname(String Firstname) {
			this.Firstname.clear();
			this.Firstname.sendKeys(Firstname);
		}
		
		public void sendlastname(String lastname) {
			this.lastname.clear();
			this.lastname.sendKeys(lastname);
		}
		
		public void sendemail(String email) {
			this.email.clear();
			this.email.sendKeys(email);
		}
		
		public void sendusername(String Username) {
			this.Username.clear();
			this.Username.sendKeys(Username);
		}
		
		public void sendPassword(String Password) {
			this.Password.clear();
			this.Password.sendKeys(Password);
		}
		
		public void sendconfirmpassword(String confirmpassword) {
			this.ConfirmPassword.clear();
			this.ConfirmPassword.sendKeys(confirmpassword);
		}
		
		public void sendPhone( String string) {
			this.Phone.clear();
			this.Phone.sendKeys(string);
		}
		
		
		public void selectLanguage(String Language) {
			this.Language.isSelected();
		}
		
		public void selectTeachcourses() {
			this.Teachcourses.click();
		}
		
		public void clickRegisterBtn() {
			this.RegisterBtn.click();
		}
		public void clickSignupTeacher() {
			this.SignupTeacher.click();
		}

}
