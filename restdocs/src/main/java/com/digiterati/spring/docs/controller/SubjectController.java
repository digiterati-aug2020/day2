package com.digiterati.spring.docs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digiterati.spring.docs.model.ErrorException;
import com.digiterati.spring.docs.model.Subject;
import com.digiterati.spring.docs.repository.SubjectRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="/services")
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping(value="/Subject",produces = "application/json")
	public Subject getSubject(@RequestParam(name="subjectNumber")String subjectNumber) {
		Subject subject = subjectRepository.getSubject(subjectNumber);
		if(subject==null) {
			throw new ErrorException("unable to find the subject number");
		}
		return subject;
	}
	
	
	@PostMapping(value="/Subject",produces = "application/json",consumes="application/json")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public String updateSubject(@RequestBody Subject subject) {
		try {
			subjectRepository.upsert(subject.getSubjectNumber(),subject);
			return mapper.writeValueAsString("success");
		} catch(JsonProcessingException ex) {
			throw new ErrorException("system error while updating subject");
		}
	}
	
}
