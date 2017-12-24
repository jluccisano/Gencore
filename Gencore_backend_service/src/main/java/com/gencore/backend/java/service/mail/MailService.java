package com.gencore.backend.java.service.mail;

import com.gencore.backend.java.entity.UserProfile;

public interface MailService {

    void registrationUser(com.gencore.backend.java.entity.UserProfile user);

    void forgotPassword(UserProfile user, String password);

}
