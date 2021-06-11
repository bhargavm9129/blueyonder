package com.bhargav.comparator;

public class CustomFields {

	public String orderName;
	public String productName;

	public CustomFields(String orderName, String productName) {
		super();
		this.orderName = orderName;
		this.productName = productName;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
