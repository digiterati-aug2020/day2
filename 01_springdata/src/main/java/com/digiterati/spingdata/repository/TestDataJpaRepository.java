package com.digiterati.spingdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digiterati.jdbc.model.TestData;
import com.digiterati.jpa.entity.TestJpaData;

@Repository
@Transactional
public interface TestDataJpaRepository extends JpaRepository<TestJpaData,Integer>{
	

	@Transactional(readOnly = false)
	TestData findByTestId(Integer testId);

}
