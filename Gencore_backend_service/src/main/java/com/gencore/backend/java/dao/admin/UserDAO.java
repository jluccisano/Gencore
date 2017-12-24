package com.gencore.backend.java.dao.admin;

import java.util.List;

import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.exception.FlexServiceException;

public interface UserDAO {

    List<UserProfile> getUsers();

    UserProfile getUser(Long id);

    UserProfile getUserByLogin(String login) throws FlexServiceException;

    void insertUser(UserProfile user);

    void deleteUser(UserProfile user);

    void deleteUsers(List<UserProfile> users);

    void updateUser(UserProfile user);

    UserProfile getUserEmail(String email) throws FlexServiceException;

    UserProfile getSimpleUser(String id);
    
    boolean checkUserByLogin(String login);
    
    boolean checkUserEmail(String email);

}
