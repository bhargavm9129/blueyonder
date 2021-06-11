package com.bhargav.comparator;

import java.util.List;

public class Organisation {

	public String orgId;
	public List<OrderLines> orderLines;
	

	public Organisation(String orgId, List<OrderLines> orderLines) {
		super();
		this.orgId = orgId;
		this.orderLines = orderLines;
	}

	
	public List<OrderLines> getOrderLines() {
		return orderLines;
	}


	public void setOrderLines(List<OrderLines> orderLines) {
		this.orderLines = orderLines;
	}


	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
}
