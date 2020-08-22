package com.digiterati.data.lab.instructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digiterati.data.lab.instructor.entity.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	@Transactional(readOnly = false)
	Subject findBySubjectNumber(String subjectNumber);
	
}
