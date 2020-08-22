package com.digiterati.spring.docs.model;

import java.io.Serializable;

public class Subject implements Serializable,Comparable<Subject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8576881455445756377L;
	
	private String subjectNumber;
	
	private String testDescription;
	
	private String testLocation;
	
	private String status;
	
	private String dateOfTheTest;

	public String getSubjectNumber() {
		return subjectNumber;
	}

	public void setSubjectNumber(String subjectNumber) {
		this.subjectNumber = subjectNumber;
	}

	public String getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	public String getTestLocation() {
		return testLocation;
	}

	public void setTestLocation(String testLocation) {
		this.testLocation = testLocation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateOfTheTest() {
		return dateOfTheTest;
	}

	public void setDateOfTheTest(String dateOfTheTest) {
		this.dateOfTheTest = dateOfTheTest;
	}

	@Override
	public int compareTo(Subject o) {
		if(o.getSubjectNumber()!=null && this.getSubjectNumber()!=null) {
			return o.getSubjectNumber().compareTo(this.getSubjectNumber());
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Subject [subjectNumber=" + subjectNumber + ", testDescription=" + testDescription + ", testLocation="
				+ testLocation + ", status=" + status + ", dateOfTheTest=" + dateOfTheTest + "]";
	}
	
	
	
	
	

}
