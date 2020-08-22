package com.digiterati.jdbc.repository;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.digiterati.jdbc.configuration.JdbcTestConfiguration;

@SpringBootTest(classes = JdbcTestConfiguration.class)
@Sql(scripts = "classpath:dbscripts/h2/ddl.sql")
@RunWith(SpringRunner.class)

public class JdbcDataRepositoryTest {
	
	@Autowired
	private JdbcDataRepository jdbcDataRepository;
	
	@Test
	public void testInsert_with_proper_value() {
		jdbcDataRepository.insert("test1");
		Assert.assertTrue(jdbcDataRepository.getTestDataList().size()==1);
	}
	
	
	@Test
	public void testGetTestDataList_with_proper_value() {
		jdbcDataRepository.deleteAllRecords();
		String remarks = "test_remarks";
		jdbcDataRepository.insert(remarks);
		Assert.assertTrue(jdbcDataRepository.getTestDataList().size()==1);
		Assert.assertTrue(jdbcDataRepository.getTestDataList().get(0).getRemarks().equals(remarks));
	}
}
