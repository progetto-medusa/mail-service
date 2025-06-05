package com.progetto_medusa.mail_service.service;

import com.progetto_medusa.mail_service.model.NewCourseMailRequest;
import com.progetto_medusa.mail_service.model.components.UserGuiDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MailServiceImpl {

    private static final String ADMIN_1_EMAIL = "luigiasalvemini7@gmail.com";
 //   private static final String ADMIN_2_EMAIL = "";

    private final JavaMailSender emailSender;
    private final ExternalCallingService externalCallingService;

    public void sendContactRequestMessage(String to, String subject, String text) throws MessagingException {
        MimeMessage message = messageSetup();
        MimeMessageHelper helper = helperSetup(message);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        emailSender.send(message);
        adminSender(message, helper, ADMIN_1_EMAIL);
     //   adminSender(message, helper, ADMIN_2_EMAIL);
    }

    public void sendSimpleMessage(String to, String subject, String text) throws MessagingException {
        MimeMessage message = messageSetup();
        MimeMessageHelper helper = helperSetup(message);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        emailSender.send(message);
    }

    private MimeMessage messageSetup(){
        return emailSender.createMimeMessage();
    }

    private MimeMessageHelper helperSetup(MimeMessage message) throws MessagingException {
        return new MimeMessageHelper(message, true);
    }

    private void adminSender(MimeMessage message, MimeMessageHelper helper, String adminMail) throws MessagingException {
        helper.setTo(adminMail);
        emailSender.send(message);
    }

}
