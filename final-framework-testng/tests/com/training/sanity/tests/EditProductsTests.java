package com.training.sanity.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DeleteProductsPOM;
import com.training.pom.EditProductsPOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductsFilterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditProductsTests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ProductsFilterPOM productsFilterPOM;
	private DeleteProductsPOM deleteProductsPOM;
	private EditProductsPOM editProductsPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String actualVerify = "arun";
	
	@BeforeClass
	public void setUpBrowser() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		productsFilterPOM = new ProductsFilterPOM(driver);
		deleteProductsPOM = new DeleteProductsPOM(driver);
		editProductsPOM = new EditProductsPOM(driver);
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
	
	//Method to filter the products
	@Test(priority=2)
	public void productFilterTest() {
		productsFilterPOM.mouseOverCatlog();
		productsFilterPOM.clickProducts();
		screenShot.captureScreenShot("3.ProductsPage");
		productsFilterPOM.sendProductName(actualVerify);
		productsFilterPOM.clickFilterBtn();
		screenShot.captureScreenShot("4.FilteredItemsList");
		String expectedVerify = productsFilterPOM.resultVerifyGetText();
		Assert.assertEquals(actualVerify, expectedVerify);
	}
	
	//Method to edit the product
	@Test(priority=3)
	public void editProductTest() {
		deleteProductsPOM.selectCheckBox();
		screenShot.captureScreenShot("5.ProductSelectedList");
		editProductsPOM.clickEditBtn();
		screenShot.captureScreenShot("6.GeneralTab");
		editProductsPOM.clickDataTab();
		screenShot.captureScreenShot("7.DataTab");
		String upatedQuantity = "20";
		editProductsPOM.editQuantity(upatedQuantity);
		screenShot.captureScreenShot("8.UpdatedQuantity");
		editProductsPOM.clickSaveBtn();
		String expected = "Success: You have modified products!";
		String actualText = editProductsPOM.successMessageGetText();
		Boolean expectedText = actualText.contains(expected);
		Assert.assertTrue(expectedText);
		screenShot.captureScreenShot("9.ModifiedConfirmationMessage");
	}
}
