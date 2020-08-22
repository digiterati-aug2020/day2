package com.digiterati.data.lab.instructor.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.digiterati.data.lab.instructor.entity.Subject;

public class SubjectClientDriver {
	
	public static void main(String[] args) {
		invokeSubjectServices();
	}
	
	private static void invokeSubjectServices() {
		RestTemplate restTemplate = new RestTemplate();
		String subjectNumber = "client10001";
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    List<MediaType> types = new ArrayList<MediaType>();
	    types.add(MediaType.APPLICATION_JSON);
	    headers.setAccept(types);
	    
	    HttpEntity<?> requestEntity = new HttpEntity<Object>(createNewSubject(subjectNumber),headers);
	    
	    ResponseEntity<String> resultSubject = restTemplate.postForEntity("http://localhost:8882/services/Subject", requestEntity, String.class);
	    System.out.print(resultSubject.getBody());
		
		ResponseEntity<Subject> result = restTemplate.getForEntity("http://localhost:8882/services/Subject?subjectNumber="+subjectNumber,Subject.class);
		System.out.print(result.getBody());
	}
	
	private static Subject createNewSubject(String subjectNumber) {
		Subject subject = new Subject();
		subject.setSubjectNumber(subjectNumber);
		subject.setDateOfTheTest("2020-08-08");
		subject.setTestDescription("test");
		subject.setTestLocation("test location");
		subject.setStatus("negative");
		return subject;
	}


}
