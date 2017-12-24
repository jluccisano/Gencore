package com.gencore.backend.java.service.admin;

import java.util.List;
import java.util.Map;

import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.exception.FlexServiceException;
import com.gencore.backend.java.exception.IllegalPasswordException;

public interface UserService {

    List<UserProfile> getUsers();

    UserProfile getUser(Long id);

    UserProfile getUserByLogin(String login)  throws FlexServiceException;

    void addUser(UserProfile user) throws FlexServiceException;

    void deleteUser(UserProfile user);

    void deleteUsers(List<UserProfile> users);

    void updateUser(UserProfile user);

    void updateUser(UserProfile user, Map<String, String> data) throws FlexServiceException;

    UserProfile getCurrentUser() throws FlexServiceException;
    
    UserProfile getConnection(String login, String password) throws FlexServiceException;

    void registrationUser(UserProfile user) throws FlexServiceException;

    void forgotPassword(String email) throws FlexServiceException;

    UserProfile getUserEmail(String email)  throws FlexServiceException;

    UserProfile getSimpleUser(String login);

}
