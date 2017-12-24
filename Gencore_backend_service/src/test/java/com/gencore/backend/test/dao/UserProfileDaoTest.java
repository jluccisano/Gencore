package com.gencore.backend.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.gencore.backend.java.dao.admin.UserDAO;
import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.exception.FlexServiceException;
import com.gencore.backend.test.BaseTest;

public class UserProfileDaoTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(UserProfileDaoTest.class);

    @Autowired
    private UserDAO userDAO;

    private UserProfile userRef;

    @Before
    public void init() throws Exception {

        Long testRef_ID;
        // Get The first Element
        String query = "SELECT id FROM T_USER";
        List<Long> resultUsers = this.getJdbcTemplate().queryForList(query, Long.class);
        assertNotNull("None user", resultUsers);

        testRef_ID = resultUsers.get(0);

        userRef = this.userDAO.getUser(testRef_ID);
        assertNotNull("None user", userRef);
    }

    @Test
    public void getUserTest() {

        // query with jdbc template to get expected value
        String query = "SELECT FIRSTNAME FROM T_USER WHERE ID = ?";
        String name = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { userRef.getId() });
        assertNotNull("User of id 1 was not found", name);

        // call the UserDAO to get the actual value returned
        UserProfile user = this.userDAO.getUser(userRef.getId());

        // test if the correct record was returned
        assertNotNull("User of id 1 was not found by service", user);
        assertEquals("User first names do not match", name, user.getFirstName());
    }

    @Test
    public void getUsersTest() {

        // query with jdbc template to get expected value
        String query = "SELECT id FROM T_USER";
        List<Long> resultUsers = this.getJdbcTemplate().queryForList(query, Long.class);
        assertNotNull("None user", resultUsers);

        // call the UserDAO to get the actual value returned
        List<UserProfile> users = this.userDAO.getUsers();

        // test if the correct record was returned
        assertNotNull("None user found by DAO", users);
        assertEquals("Count users is equals", resultUsers.size(), users.size());
    }

    @Test
    public void getUserByLoginTest() throws FlexServiceException {

        // query with jdbc template to get expected value
        String query = "SELECT LOGIN FROM T_USER WHERE LOGIN = ?";
        String login = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { userRef.getLogin() });
        assertNotNull("User of id 1 was not found", login);

        // call the UserDAO to get the actual value returned
        UserProfile user = this.userDAO.getUserByLogin(userRef.getLogin());

        // test if the correct record was returned
        assertNotNull("User of id 1 was not found by service", user);
        assertEquals("User first names do not match", login, user.getLogin());
    }

    @Test
    public void getUserEmailTest() throws FlexServiceException {

        // query with jdbc template to get expected value
        String query = "SELECT EMAIL FROM T_USER WHERE EMAIL = ?";
        String email = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { userRef.getEmail() });
        assertNotNull("User of id 1 was not found", email);

        // call the UserDAO to get the actual value returned
        UserProfile user = this.userDAO.getUserEmail(userRef.getEmail());

        // test if the correct record was returned
        assertNotNull("User of id 1 was not found by service", user);
        assertEquals("User first names do not match", email, user.getEmail());
    }

    @Test
    public void updateUserTest() throws FlexServiceException {

        // query with jdbc template to get current name
        String query = "SELECT FIRSTNAME FROM T_USER WHERE LOGIN = ?";
        String actualName = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { userRef.getLogin() });
        assertNotNull("User of id 1 was not found", actualName);

        assertNotSame("Current is different than" + userRef.getFirstName(), userRef.getFirstName(), actualName);

        UserProfile user = this.userDAO.getUserByLogin(userRef.getLogin());
        // call the UserDAO to get the actual value returned
        user.setFirstName("toto");
        this.userDAO.updateUser(user);

        // query with jdbc template to get expected value
        String name = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { userRef.getLogin() });
        assertNotNull("User of id 1 was not found", name);

        // test if the correct record was returned
        assertNotNull("User of id 1 was not found by service", user);
        assertEquals("Name has been changed", name, user.getFirstName());
    }

    @Test
    public void deleteUserTest() throws Throwable {

        // Check if the user exist
        String query = "SELECT LOGIN FROM T_USER WHERE LOGIN = ?";
        String login = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { userRef.getLogin() });
        assertNotNull("User of id 1 was not found", login);

        UserProfile user = this.userDAO.getUserByLogin(userRef.getLogin());

        this.userDAO.deleteUser(user);

        String afterLogin = null;

        try {
            afterLogin = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                    new Object[] { userRef.getLogin() });
        } catch (EmptyResultDataAccessException ex) {
            assertNull(afterLogin);
        }
    }

    @Test
    public void deleteUsersTest() {
        // Check if the user exist
        String query = "SELECT count(*) FROM T_USER";
        int actual = this.getJdbcTemplate().queryForInt(query);
        assertTrue((actual > 0));
        this.userDAO.deleteUsers(userDAO.getUsers());
        int after = this.getJdbcTemplate().queryForInt(query);
        assertEquals(0, after);
    }
}
