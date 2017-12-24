package com.gencore.backend.java.job;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gencore.backend.java.context.AppContext;

public class QuartzServiceImpl {

    private static String DeleteAccountNotValidatedquery = "DELETE FROM t_user WHERE TO_DAYS(NOW()) - TO_DAYS(creation_date) >= 30 AND enabled = false ";

//    private ApplicationContext context;
//
//    public ApplicationContext getContext() {
//        return context;
//    }

    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void doIt() {

        //context = (ApplicationContext) AppContext.getApplicationContext();

        try {

            jdbcTemplate.update(DeleteAccountNotValidatedquery);

        } catch (Exception e) {

        }
    }

}
