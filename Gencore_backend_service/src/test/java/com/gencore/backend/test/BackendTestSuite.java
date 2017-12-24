package com.gencore.backend.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.gencore.backend.test.dao.DaoTestSuite;
import com.gencore.backend.test.db.DbTestSuite;

@RunWith(Suite.class)
@SuiteClasses( { DbTestSuite.class, DaoTestSuite.class })
public class BackendTestSuite {

}
