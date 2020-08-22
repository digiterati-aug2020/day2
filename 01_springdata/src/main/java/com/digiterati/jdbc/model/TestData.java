package com.digiterati.jdbc.model;

public class TestData {
	
	private Integer testId;
	
	private String remarks;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
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
