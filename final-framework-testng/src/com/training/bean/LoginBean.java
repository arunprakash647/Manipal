package com.training.bean;

public class LoginBean {
	private String userName;
	private String password;
	private String productName;
	private String metaTagTitle;
	private String model;
	private String price;
	private String quantity;
	private String category;

	public LoginBean() {
	}

	public LoginBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getProductName() {
		return productName;
	}
	
	public String getMetaTagTitle() {
		return metaTagTitle;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	}

}
