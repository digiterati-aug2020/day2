package com.digiterati.data.lab.instructor.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digiterati.data.lab.instructor.entity.Subject;
import com.digiterati.data.lab.instructor.model.ErrorException;
import com.digiterati.data.lab.instructor.repository.SubjectRepository;
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
		Subject subject = subjectRepository.findBySubjectNumber(subjectNumber);
		if(subject==null) {
			throw new ErrorException("unable to find the subject number");
		}
		return subject;
	}
	
	
	@PostMapping(value="/Subject",produces = "application/json",consumes="application/json")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public String updateSubject(@RequestBody Subject subject) {
		try {
			Subject fetchedSubject = subjectRepository.findBySubjectNumber(subject.getSubjectNumber());
			if(fetchedSubject==null) {
				subjectRepository.save(subject);
			} else {
				Integer subjectId = fetchedSubject.getSubjectId();
				BeanUtils.copyProperties(subject, fetchedSubject);
				fetchedSubject.setSubjectId(subjectId);
				subjectRepository.save(fetchedSubject);
			}
			return mapper.writeValueAsString("success");
		} catch(JsonProcessingException ex) {
			throw new ErrorException("system error while updating subject");
		}
	}
	
}
