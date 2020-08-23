package com.digiterati.spring.docs.model;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectModel extends RepresentationModel<SubjectModel>{
	
	private final String model;

	@JsonCreator
	public SubjectModel(@JsonProperty("model") String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}
	

}
