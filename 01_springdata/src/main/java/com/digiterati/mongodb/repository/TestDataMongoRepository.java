package com.digiterati.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digiterati.mongodb.entity.TestMongoData;

@Repository
@Transactional
public interface TestDataMongoRepository extends MongoRepository<TestMongoData,Integer>{
	

	@Transactional(readOnly = false)
	TestMongoData findByTestId(String testId);

}
