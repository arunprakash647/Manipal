package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	protected WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	static ExtentTest extentTest;
	static ExtentReports extentReports;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		extentReports = new ExtentReports("./test-output/TestResults.html");
		extentReports.loadConfig(new File("./test-output/extent-config.xml"));
		extentTest = extentReports.startTest("Login");
	}
	
	//Method to launch browser and the url in the same
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	//Method to close or quit the browser
	@AfterMethod
	public void tearDown() throws Exception {
		extentReports.endTest(extentTest);
		extentReports.flush();
		Thread.sleep(1000);
		driver.quit();
	}
	
	//Method to login to the application
	@Test
	public void validLoginTest() {
		screenShot.captureScreenShot("1.LoginPage");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("2.HomePage");
		if(loginPOM.logoutBtnDisplayed()) {
			extentTest.log(LogStatus.PASS, "Login Successful");
		}else {
			extentTest.log(LogStatus.FAIL, "Login Un-Successful");
		}
		loginPOM.clickLogoutBtn();
		screenShot.captureScreenShot("3.LoginPage");
	}
}
