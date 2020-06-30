package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.elearningPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class elearningTest {
	
	private WebDriver driver;
	private String elearningURL;
	private elearningPOM elearningPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private LoginPOM loginPOM;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		elearningPOM = new elearningPOM(driver);
		elearningURL = properties.getProperty("elearningURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(elearningURL);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validRegisterTeacherTest() {
		
		elearningPOM.clickSignupTeacher();
		elearningPOM.selectTeachcourses();
		elearningPOM.sendFirstname("manzoor");
		elearningPOM.sendlastname("mehadi");
		elearningPOM.sendemail("manzoor@gmail.com");
		elearningPOM.sendusername("manzoor");
		elearningPOM.sendPassword("manzoor");
		elearningPOM.sendconfirmpassword("manzoor");
		elearningPOM.sendPhone("9876543210");
		elearningPOM.selectLanguage("English");
		elearningPOM.clickRegisterBtn();
		System.out.println("Your personal settings have been registered.\r\n" +
				"\r\n" +
				"An email has been sent to help you remember your login and password");
		
		screenShot.captureScreenShot("RegisteredTeacher");
	}

}
