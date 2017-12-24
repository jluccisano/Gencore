package com.gencore.backend.java.service.admin.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gencore.backend.java.context.AppContext;
import com.gencore.backend.java.dao.admin.RoleDAO;
import com.gencore.backend.java.dao.admin.UserDAO;
import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.entity.UserRole;
import com.gencore.backend.java.exception.FlexServiceException;
import com.gencore.backend.java.exception.IllegalPasswordException;
import com.gencore.backend.java.service.admin.UserService;
import com.gencore.backend.java.service.mail.MailService;
import com.gencore.backend.java.utils.ImageUtils;
import com.gencore.backend.java.utils.PasswordGenerator;

import flex.messaging.FlexContext;

public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private MailService mail;
    private ApplicationContext context;

    UserDAO userDAO;
    RoleDAO roleDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public UserProfile getConnection(String login, String password) throws UsernameNotFoundException, FlexServiceException {

        try {

            Authentication authentication;
            ApplicationContext context;
            AuthenticationManager authManager;

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password);

            context = WebApplicationContextUtils.getWebApplicationContext(FlexContext.getServletConfig()
                    .getServletContext());

            authManager = (AuthenticationManager) context.getBean("authManager");

            authentication = authManager.authenticate(token);

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (UsernameNotFoundException ex) {

        }

        return this.getCurrentUser();
    }

    public UserProfile getUser(Long id) {
        return userDAO.getUser(id);
    }

    public UserProfile getUserByLogin(String login) throws FlexServiceException {
        return userDAO.getUserByLogin(login);
    }

    public UserProfile getSimpleUser(String login) {
        return userDAO.getSimpleUser(login);
    }

    public UserProfile getUserEmail(String email) throws FlexServiceException {
        return userDAO.getUserEmail(email);
    }

    public List<UserProfile> getUsers() {
        return userDAO.getUsers();
    }

    public void addUser(UserProfile user) throws FlexServiceException {

        user.setCreationDate(new Date());
        user.setEnabled(false);

        // Check if login doesn't already exist
        if (userDAO.checkUserByLogin(user.getLogin())) {
            throw new FlexServiceException("login.already.exist");
        }
        
        // Check if email doesn't already exist
        if (userDAO.checkUserEmail(user.getEmail())) {
            throw new FlexServiceException("email.already.exist");
        }

        // String login = user.getFirstName().substring(0, 1).toLowerCase() + user.getLastName().toLowerCase();
        // user.setLogin(user.getLogin());

        user.setLastName(user.getLastName().toUpperCase());

        //user.setPassword(PasswordGenerator.generateNewPassword(user.getLogin()));
        user.setPassword(PasswordGenerator.generateHashedPassword(user.getLogin(),user.getPassword()));
        
        UserRole role = roleDAO.getRoleByName("ROLE_USER");  
        user.setRole(role);

        userDAO.insertUser(user);
        
        
        
        //Send an email for confirmation
    }
    
    public void registrationUser(UserProfile user) throws FlexServiceException {

        this.addUser(user);
        context = AppContext.getApplicationContext();
        mail = (MailService) context.getBean("registrationService");
        mail.registrationUser(user);
        
    }

    public void updateUser(UserProfile user) {
        userDAO.updateUser(user);
    }

    public void updateUser(UserProfile user, Map<String, String> data) throws FlexServiceException {

        UserProfile _user = null;
        String actualPassword = null;
        String newPassword = null;

        if (data != null) {

            actualPassword = PasswordGenerator.generateHashedPassword(user.getLogin(), data.get("actualPassword"));

            _user = userDAO.getUserByLogin(user.getLogin());

            if (_user.getPassword().equals(actualPassword)) {

                newPassword = PasswordGenerator.generateHashedPassword(user.getLogin(), data.get("newPassword"));

                user.setPassword(newPassword);

                userDAO.updateUser(user);
            } else {
                throw new IllegalPasswordException();
            }
        }
    }

    public void deleteUser(UserProfile user) {
        userDAO.deleteUser(user);

    }

    public UserProfile getCurrentUser() throws FlexServiceException {

        SecurityContext securityContext = SecurityContextHolder.getContext();

        org.springframework.security.core.userdetails.User springSecurityUser = (org.springframework.security.core.userdetails.User) securityContext
                .getAuthentication().getPrincipal();

        String login = springSecurityUser.getUsername();

        return this.getUserByLogin(login);
    }

  

    public void forgotPassword(String email) throws FlexServiceException {

        UserProfile user = null;

        context = AppContext.getApplicationContext();

        mail = (MailService) context.getBean("registrationService");

        try {
            user = getUserEmail(email);
        } catch (NullPointerException e) {
            throw new FlexServiceException("user.not.exist");
        }

        if (user != null) {

            String newNotHashedPassword = PasswordGenerator.generateNewPassword(user.getLogin());

            user.setPassword(PasswordGenerator.generateHashedPassword(user.getLogin(), newNotHashedPassword));

            userDAO.updateUser(user);

            mail.forgotPassword(user, newNotHashedPassword);
        }

    }

    @Override
    public void deleteUsers(List<UserProfile> users) {
        userDAO.deleteUsers(users);

    }
    
    public byte[] compressImage (byte [] image) {  
        return ImageUtils.compressImage(image);
    }

}
