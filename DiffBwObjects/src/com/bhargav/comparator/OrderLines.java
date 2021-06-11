package com.bhargav.comparator;

public class OrderLines {

	public String orderLineId;
	public CustomFields customFields;
	
	
	public OrderLines(String orderLineId, CustomFields customFields) {
		super();
		this.orderLineId = orderLineId;
		this.customFields = customFields;
	}
	
	public String getOrderLineId() {
		return orderLineId;
	}
	
	public void setOrderLineId(String orderLineId) {
		this.orderLineId = orderLineId;
	}
	
	public CustomFields getCustomFields() {
		return customFields;
	}
	public void setCustomFields(CustomFields customFields) {
		this.customFields = customFields;
	}
	
	
}
