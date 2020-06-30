package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

	@BeforeClass
	public void setUpBrowser() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
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
	
	@Test(priority=1)
	public void loginTest() {
		screenShot.captureScreenShot("1.LoginPage");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("2.HomePage");
	}
	
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
		Assert.assertEquals(actualListDate, expectedListDate);
	}
}
