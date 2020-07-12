package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.FilterOrdersPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterOrdersTests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FilterOrdersPOM filterOrdersPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	static ExtentTest extentTest;
	static ExtentReports extentReports;

	@BeforeClass
	public void setUpBrowser() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		extentReports = new ExtentReports("./test-output/TestResults.html");
		extentReports.loadConfig(new File("./test-output/extent-config.xml"));
		extentTest = extentReports.startTest("Filter Orders");
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		filterOrdersPOM = new FilterOrdersPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearBrowser() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	//Method to login to the application
	@Test(priority=1)
	public void loginTest() {
		screenShot.captureScreenShot("1.LoginPage");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("2.HomePage");
	}
	
	//Method to filter the orders
	@Test(priority=2)
	public void filterOrdersTest() {
		int day = 24;
		String month = "06";
		int year = 2020;
		filterOrdersPOM.moveOverSales();
		filterOrdersPOM.clickOrders();
		filterOrdersPOM.sendDateAdded(year+ "-" + month + "-" + day);
		filterOrdersPOM.clickFilterBtn();
		String actualListDate = filterOrdersPOM.listDateAddedGetText();
		String expectedListDate = day+ "/" + month + "/" + year;
		//Assert.assertEquals(actualListDate, expectedListDate);
		boolean assertActualText = actualListDate.contains(expectedListDate);
		if(assertActualText) {
			extentTest.log(LogStatus.PASS, "Filter Orders Successful");
		}else {
			extentTest.log(LogStatus.FAIL, "Filter Orders Un-Successful");
		}
	}
}
