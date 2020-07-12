package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "db-inputs-productdetails")
	public Object [][] getDBDataProduct() {

		List<LoginBean> list = new ELearningDAO().getProductDetails(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getProductName(); 
			obj[1] = temp.getMetaTagTitle(); 
			obj[2] = temp.getModel();
			obj[3] = temp.getPrice();
			obj[4] = temp.getQuantity();
			obj[5] = temp.getCategory();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="/Users/arunpsajapuram/git/Manipal/final-framework-testng/TestData.xlsx"; 
		String sheetName = "Login";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-addproduct")
	public Object[][] getExcelData1(){
		String fileName ="/Users/arunpsajapuram/git/Manipal/final-framework-testng/TestData.xlsx"; 
		String sheetName = "ProductDetails";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-applogin")
	public Object[][] getExcelData2(){
		String fileName ="/Users/arunpsajapuram/git/Manipal/final-framework-testng/TestData.xlsx"; 
		String sheetName = "ShopLogin";//ReturnProduct
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-returnproduct")
	public Object[][] getExcelData3(){
		String fileName ="/Users/arunpsajapuram/git/Manipal/final-framework-testng/TestData.xlsx"; 
		String sheetName = "ReturnProduct";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs-createorder")
	public Object[][] getExcelData4(){
		String fileName ="/Users/arunpsajapuram/git/Manipal/final-framework-testng/TestData.xlsx"; 
		String sheetName = "CreateOrder";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("/Users/arunpsajapuram/git/Manipal/final-framework-testng/TestData.xls", "Sheet1"); 
	}
}
