package com.digiterati.data.lab.instructor.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.digiterati.data.lab.instructor.configuration.SubjectConfiguration;
import com.digiterati.data.lab.instructor.entity.Subject;

@SpringBootTest(classes = SubjectConfiguration.class)
@RunWith(SpringRunner.class)
@DirtiesContext
public class SubjectRepositoryTest {
	
	@Autowired
	private SubjectRepository repository;
	
	@Test
	public void testGetSubject_with_available_subjectNumber() {
		String subjectNumber = "100";
		Subject subject = createNewSubject(subjectNumber);
		repository.save(subject);
		Subject fetchedSubject = repository.findBySubjectNumber(subjectNumber);
		Assert.assertTrue(subject.getSubjectNumber().equals(fetchedSubject.getSubjectNumber()));
	}
	
	@Test
	public void testGetSubject_with_not_available_subjectNumber() {
		String subjectNumber = "100";
		Subject fetchedSubject = repository.findBySubjectNumber(subjectNumber);
		Assert.assertTrue(fetchedSubject==null);
	}
	
	@Test
	public void testUpsertSubject() {
		String subjectNumber = "100";
		Subject subject = createNewSubject(subjectNumber);
		repository.save(subject);
		Assert.assertTrue(true);
	}
	
	private Subject createNewSubject(String subjectNumber) {
		Subject subject = new Subject();
		subject.setSubjectNumber(subjectNumber);
		subject.setDateOfTheTest("2020-08-08");
		subject.setTestDescription("test");
		subject.setTestLocation("test location");
		return subject;
	}

}
