package com.digiterati.data.lab.instructor.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject_info")
public class Subject implements Serializable,Comparable<Subject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8576881455445756377L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subject_id")
	private Integer subjectId;
	
	@Column(name="subject_number")
	private String subjectNumber;
	
	@Column(name="test_description")
	private String testDescription;
	
	@Column(name="test_location")
	private String testLocation;
	
	@Column(name="status")
	private String status;
	
	@Column(name="date_of_test")
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
		if(o.getSubjectId()!=null && this.getSubjectId()!=null) {
			return o.getSubjectId().compareTo(this.getSubjectId());
		}
		return 0;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "Subject [subjectNumber=" + subjectNumber + ", testDescription=" + testDescription + ", testLocation="
				+ testLocation + ", status=" + status + ", dateOfTheTest=" + dateOfTheTest + "]";
	}
	
	
	
	
	

}
