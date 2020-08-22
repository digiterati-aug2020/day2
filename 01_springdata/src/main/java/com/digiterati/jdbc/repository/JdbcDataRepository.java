package com.digiterati.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.digiterati.jdbc.model.TestData;

@Repository
public class JdbcDataRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(String remarks) {
		jdbcTemplate.update("insert into test_data(remarks) values(?)", remarks);
	}
	
	public List<TestData> getTestDataList() {
		return jdbcTemplate.query("select test_id as test_id,remarks from test_data", new RowMapper<TestData>() {

			@Override
			public TestData mapRow(ResultSet rs, int rowNum) throws SQLException {
				TestData data = new TestData();
				data.setRemarks(rs.getString("remarks"));
				data.setTestId(rs.getInt("test_id"));
				return data;
			}
		});
	}
	
	public void deleteAllRecords() {
		jdbcTemplate.execute("delete from test_data");
	}

}
