package com.digiterati.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digiterati.mongo.entity.MongoData;

@Repository
public interface TestMongoRepository extends MongoRepository<MongoData, String>{
	
	@Transactional(readOnly = true)
	List<MongoData> findByName(String name);

}
