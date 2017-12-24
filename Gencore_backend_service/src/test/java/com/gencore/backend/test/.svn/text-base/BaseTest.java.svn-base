package com.gencore.backend.test;



import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/com/gencore/backend/resources/spring/spring-conf-hibernate.xml",
		"classpath:/com/gencore/backend/resources/spring/spring-conf-dao.xml",
	    "classpath:/com/gencore/backend/test/resources/spring/spring-conf-test-properties.xml",
	    "classpath:/com/gencore/backend/test/resources/spring/spring-conf-test.xml"})
public class BaseTest {

	private DataSource testDataSource;

	private JdbcTemplate jdbcTemplate;

	
	public DataSource getTestDataSource() {
		return testDataSource;
	}
	
	@Autowired
	public void setTestDataSource(@Qualifier("testDataSource") DataSource testDataSource) {
		this.testDataSource = testDataSource;
		this.jdbcTemplate = new JdbcTemplate(testDataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
