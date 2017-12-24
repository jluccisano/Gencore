package com.gencore.backend.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gencore.backend.java.dao.admin.RoleDAO;
import com.gencore.backend.java.entity.UserRole;

public class UserRoleInitData extends AbstractGetData {

    private static final Logger LOG = Logger.getLogger(UserRoleInitData.class);

    private static enum COLUMN_CODE {

        COLUMN_ROLE(0, "ROLE");

        private int code;
        private String label;

        private COLUMN_CODE(int code, String label) {
            this.code = code;
            this.label = label;
        }

        public int getCode() {
            return this.code;
        }

        public String getLabel() {
            return this.label;
        }
    }

    private RoleDAO roleDAO;

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Test
    public void insertUserRoleInitData() throws IOException {
        setFilePath("src/test/resources/com/gencore/backend/test/resources/csv/insert_init_data_UserRole.csv");
        this.processData();
    }

    @Override
    public void insertData(String[] line) {

        try {
            UserRole role = new UserRole();
            role.setName(line[COLUMN_CODE.COLUMN_ROLE.code]);
            roleDAO.insertRole(role);
            LOG.debug("new role: " + role.getName());
        } catch (Throwable t) {
            LOG.error("The role can be added");
        }

    }

}
