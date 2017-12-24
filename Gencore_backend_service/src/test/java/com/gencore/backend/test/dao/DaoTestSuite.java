package com.gencore.backend.test.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.gencore.backend.test.BaseTest;
import com.gencore.backend.test.UserProfileInitData;
import com.gencore.backend.test.UserRoleInitData;

@RunWith(Suite.class)
@SuiteClasses( { UserRoleInitData.class, UserProfileInitData.class, UserProfileDaoTest.class, UserRoleDaoTest.class })
public class DaoTestSuite extends BaseTest {

    public void after() throws Exception {

        getJdbcTemplate().update("DELETE FROM t_user");
        getJdbcTemplate().update("DELETE FROM t_role");
    }

}
