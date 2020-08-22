package com.digiterati.mongodb.entity;

import org.springframework.data.annotation.Id;

public class TestMongoData {
	
	@Id
	private String testId;
	
	private String remarks;

	

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "TestData [testId=" + testId + ", remarks=" + remarks + "]";
	}
	
	

}
