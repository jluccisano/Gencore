package com.gencore.backend.java.service.mail;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.service.admin.impl.UserServiceImpl;

public class MailServiceImpl extends javax.mail.Authenticator implements MailService {

    private static Logger logger = Logger.getLogger(MailServiceImpl.class);
    
    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void registrationUser(UserProfile user) {
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user", user);
        
        sendEmail(model , user.getEmail(),  "/com/gencore/backend/resources/templates/registrationTemplate_" + user.getLanguage().label() + ".html");
    }

    public void forgotPassword(UserProfile user, String notHashedPassword) {
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user", user);
        model.put("password", notHashedPassword);
        
        sendEmail(model, user.getEmail(), "/com/gencore/backend/resources/templates/forgotPasswordTemplate.html");
    }

    private void sendEmail( final Map<String, Object> model, final String email, final String template) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

                message.setTo(email);
                message.setFrom("no-reply@gencore.com");

                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, model);
                message.setText(text, true);
            }
        };

        try {
            this.mailSender.send(preparator);
        } catch (Throwable t) {
            logger.error("Mail Server connection error");
        }
        
    }
    
}