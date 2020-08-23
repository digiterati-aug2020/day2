package com.digiterati.spring.docs.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digiterati.spring.docs.model.Subject;
import com.digiterati.spring.docs.model.SubjectModel;
import com.digiterati.spring.docs.repository.SubjectRepository;

@RestController
@RequestMapping("/services")
public class SubjectHyperMediaController {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@RequestMapping("/Link")
	public HttpEntity<SubjectModel> fetchLinks(@RequestParam(value = "subjectNumber") String subjectNumber) {
		Subject subject = subjectRepository.getSubject(subjectNumber);

		SubjectModel subjectModel = new SubjectModel(subject.toString());
		
		subjectModel.add(linkTo(methodOn(SubjectHyperMediaController.class).fetchLinks(subjectNumber)).withSelfRel());
		Link otherLink = linkTo(methodOn(SubjectHyperMediaController.class).fetchLinks(subjectNumber)).withRel("fetchLinkUrl");
		subjectModel.add(otherLink);
		
		Link subjectControllerLink = linkTo(methodOn(SubjectController.class).getSubject(subjectNumber)).withRel("subjectFetch");
		subjectModel.add(subjectControllerLink);
		
		return new ResponseEntity<>(subjectModel, HttpStatus.OK);
	}

}
