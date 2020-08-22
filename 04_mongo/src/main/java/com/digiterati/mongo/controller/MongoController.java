package com.digiterati.mongo.controller;

import java.util.List;

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

import com.digiterati.mongo.entity.MongoData;
import com.digiterati.mongo.model.ErrorException;
import com.digiterati.mongo.repository.TestMongoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="/services")
public class MongoController {
	
	@Autowired
	private TestMongoRepository testMongoRepository;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping(value="/Mongo",produces = "application/json")
	public MongoData getMongoData(@RequestParam(name="name")String name) {
		List<MongoData> dataList = testMongoRepository.findByName(name);
		if(!dataList.isEmpty()) {
			return dataList.get(0);
		}
		throw new ErrorException("no records");
	}
	
	
	@PostMapping(value="/Mongo",produces = "application/json",consumes="application/json")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public String updateSubject(@RequestBody MongoData mongoData) {
		try {
			MongoData data = new MongoData();
			List<MongoData> dataList = testMongoRepository.findByName(mongoData.getName());
			String id = null;
			if(!dataList.isEmpty()) {
				id = dataList.get(0).getId();
				data=dataList.get(0);
			} 
			BeanUtils.copyProperties(mongoData, data);
			data.setId(id);
			
			testMongoRepository.save(data);
			return mapper.writeValueAsString("success");
		} catch(JsonProcessingException ex) {
			throw new ErrorException("system error while updating mongodb");
		}
	}

}
