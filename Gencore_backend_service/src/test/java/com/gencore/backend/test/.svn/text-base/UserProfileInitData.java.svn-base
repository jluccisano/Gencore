package com.gencore.backend.test;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gencore.backend.java.dao.admin.RoleDAO;
import com.gencore.backend.java.dao.admin.UserDAO;
import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.entity.UserRole;
import com.gencore.backend.java.utils.PasswordGenerator;

public class UserProfileInitData extends AbstractGetData {

    private static final Logger LOG = Logger.getLogger(UserProfileInitData.class);

    private static enum COLUMN_CODE {

        COLUMN_LOGIN(0, "LOGIN"), COLUMN_PASSWORD(1, "PASSWORD"), COLUMN_FIRSTNAME(2, "FIRSTNAME"), COLUMN_LASTNAME(3,
                "LASTNAME"), COLUMN_EMAIL(4, "EMAIL"), COLUMN_LANGUAGE(5, "LANGUAGE"), COLUMN_ENABLED(6, "ENABLED"),
        COLUMN_ROLE(7, "ROLE");

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
    private UserDAO userDAO;

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Test
    public void insertUserProfileInitData() throws IOException {
        setFilePath("src/test/resources/com/gencore/backend/test/resources/csv/insert_init_data_UserProfile.csv");
        this.processData();
    }

    @Override
    public void insertData(String[] line) {

        try {
            UserProfile user = new UserProfile();
            user.setCreationDate(new Date());
            user.setEmail(line[COLUMN_CODE.COLUMN_EMAIL.code]);
            user.setEnabled(Boolean.valueOf(line[COLUMN_CODE.COLUMN_ENABLED.code]));
            user.setFirstName(line[COLUMN_CODE.COLUMN_FIRSTNAME.code]);
           // user.setLanguage(line[COLUMN_CODE.COLUMN_LANGUAGE.code]);
            user.setLastName(line[COLUMN_CODE.COLUMN_LASTNAME.code]);
            user.setLogin(line[COLUMN_CODE.COLUMN_LOGIN.code]);

            String newNotHashedPassword = PasswordGenerator.generateNewPassword(line[COLUMN_CODE.COLUMN_LOGIN.code]);

            user.setPassword(PasswordGenerator.generateHashedPassword(line[COLUMN_CODE.COLUMN_LOGIN.code],
                    newNotHashedPassword));

            UserRole role = roleDAO.getRoleByName(line[COLUMN_CODE.COLUMN_ROLE.code]);
            user.setRole(role);

            userDAO.insertUser(user);

            LOG.debug("Add new User: " + user.getFirstName() + " " + user.getLastName());

        } catch (Throwable t) {

            LOG.error("The user can be added");
        }

    }

}
