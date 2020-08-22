package com.digiterati.data.lab.instructor.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.digiterati.data.lab.instructor.configuration.SubjectConfiguration;
import com.digiterati.data.lab.instructor.entity.Subject;
import com.digiterati.data.lab.instructor.model.ErrorException;

@SpringBootTest(classes = SubjectConfiguration.class)
@RunWith(SpringRunner.class)
@DirtiesContext
public class SubjectControllerTest {
	
	@Autowired
	private SubjectController controller;
	
	@Test
	public void testGetSubject_with_available_subjectNumber() {
		String subjectNumber = "100";
		Subject subject = createNewSubject(subjectNumber);
		controller.updateSubject(subject);
		Subject fetchedSubject = controller.getSubject(subjectNumber);
		Assert.assertTrue(subject.equals(fetchedSubject));
	}
	
	@Test(expected = ErrorException.class)
	public void testGetSubject_with_not_available_subjectNumber() {
		String subjectNumber = "100";
		controller.getSubject(subjectNumber);
	}
	
	@Test
	public void testUpdateSubject() {
		String subjectNumber = "100";
		Subject subject = createNewSubject(subjectNumber);
		controller.updateSubject(subject);
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
