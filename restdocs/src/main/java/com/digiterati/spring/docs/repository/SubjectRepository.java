package com.digiterati.spring.docs.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.digiterati.spring.docs.model.Subject;

@Repository
public class SubjectRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7679479337676527977L;
	
	private Map<String,Subject> mapSubjectsBySubjectNumber = new HashMap<String,Subject>();
	
	
	public void upsert(String subjectNumber,Subject subject) {
		mapSubjectsBySubjectNumber.put(subjectNumber,subject);
	}
	
	public Subject getSubject(String subjectNumber) {
		return mapSubjectsBySubjectNumber.get(subjectNumber);
	}
	

}
