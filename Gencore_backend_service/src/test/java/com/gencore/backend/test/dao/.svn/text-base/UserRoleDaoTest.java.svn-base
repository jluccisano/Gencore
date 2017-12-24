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

import com.gencore.backend.java.dao.admin.RoleDAO;
import com.gencore.backend.java.entity.UserRole;
import com.gencore.backend.test.BaseTest;

public class UserRoleDaoTest extends BaseTest {

    private static final Logger LOG = Logger.getLogger(UserRoleDaoTest.class);

    @Autowired
    private RoleDAO roleDAO;

    private UserRole roleRef;

    @Before
    public void init() throws Exception {

        Long roleRef_ID;
        // Get The first Element
        String query = "SELECT id FROM T_ROLE";
        List<Long> resultRoles = this.getJdbcTemplate().queryForList(query, Long.class);
        assertNotNull("None role", resultRoles);
        roleRef_ID = resultRoles.get(0);
        roleRef = this.roleDAO.getRole(roleRef_ID);
        assertNotNull("None role", roleRef);
    }

    @Test
    public void getRolesTest() {

        // query with jdbc template to get expected value
        String query = "SELECT id FROM T_ROLE";
        List<Long> resultRoles = this.getJdbcTemplate().queryForList(query, Long.class);
        assertNotNull("None role", resultRoles);

        // call the RoleDAO to get the actual value returned
        List<UserRole> roles = this.roleDAO.getRoles();

        // test if the correct record was returned
        assertNotNull("None user found by DAO", roles);
        assertEquals("Count users is equals", resultRoles.size(), roles.size());
    }

    @Test
    public void getRoleTest() {

        // query with jdbc template to get expected value
        String query = "SELECT NAME FROM T_ROLE WHERE ID = ?";
        String name = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { roleRef.getId() });
        assertNotNull("Role of id 1 was not found", name);

        // call the RoleDAO to get the actual value returned
        UserRole role = this.roleDAO.getRole(roleRef.getId());

        // test if the correct record was returned
        assertNotNull("Role of id 1 was not found by service", role);
        assertEquals("Role first names do not match", name, role.getName());
    }

    @Test
    public void getRoleByName() {

        // query with jdbc template to get expected value
        String query = "SELECT NAME FROM T_ROLE WHERE NAME = ?";
        String name = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { roleRef.getName() });
        assertNotNull("Role of id 1 was not found", name);

        // call the RoleDAO to get the actual value returned
        UserRole role = this.roleDAO.getRoleByName(roleRef.getName());

        // test if the correct record was returned
        assertNotNull("Role of id 1 was not found by service", role);
        assertEquals("Role first names do not match", name, role.getName());
    }

    @Test
    public void updateRoleTest() {

        // query with jdbc template to get current name
        String query = "SELECT NAME FROM T_ROLE WHERE ID = ?";
        String actualName = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { roleRef.getId() });
        assertNotNull("Role of id 1 was not found", actualName);

        assertNotSame("Current is different than " + roleRef.getName(), roleRef.getName(), actualName);

        UserRole role = this.roleDAO.getRole(roleRef.getId());
        // call the UserDAO to get the actual value returned
        role.setName("ROLE_TOTO");
        this.roleDAO.updateRole(role);

        // query with jdbc template to get expected value
        String name = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { roleRef.getId() });
        assertNotNull("Role of id 1 was not found", name);

        // test if the correct record was returned
        assertNotNull("Role of id 1 was not found by service", role);
        assertEquals("Name has been changed", name, role.getName());
    }

    @Test
    public void deleteRoleTest() {
        // Check if the user exist
        String query = "SELECT NAME FROM T_ROLE WHERE ID = ?";
        String name = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                new Object[] { roleRef.getId() });
        assertNotNull("Role of id 1 was not found", name);

        UserRole role = this.roleDAO.getRole(roleRef.getId());

        this.roleDAO.deleteRole(role);

        String after = null;

        try {
            after = (String) this.getJdbcTemplate().queryForObject(query, String.class,
                    new Object[] { roleRef.getId() });
        } catch (EmptyResultDataAccessException ex) {
            assertNull(after);
        }
    }

    @Test
    public void deleteRolesTest() {
        // Check if the user exist
        String query = "SELECT count(*) FROM T_ROLE";
        int actual = this.getJdbcTemplate().queryForInt(query);
        assertTrue((actual > 0));
        this.roleDAO.deleteRoles(roleDAO.getRoles());
        int after = this.getJdbcTemplate().queryForInt(query);
        assertEquals(0, after);
    }

}
