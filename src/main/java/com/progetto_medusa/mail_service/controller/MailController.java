package com.progetto_medusa.mail_service.controller;

import com.progetto_medusa.mail_service.model.MailFromFormDTO;

import com.progetto_medusa.mail_service.model.Request.UserRequestForm;
import com.progetto_medusa.mail_service.model.UserDTO;
import com.progetto_medusa.mail_service.service.MailServiceImpl;
import com.progetto_medusa.mail_service.util.MessageBuilder;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/mail-service")
public class MailController{
    public static final String HOST_MAIL = "pippo@pappo.com";
    public static final String OBJECT_1 = " ";
    public static final String OBJECT_2 = " ";
    public static final String OBJECT_3 = " ";
    public static final String OBJECT_4 = " ";
    public static final String OBJECT_5 = " ";
    public static final String OBJECT_6 = " ";

    private final MailServiceImpl mailService;
    private final MessageBuilder messageBuilder;


    @PostMapping ("/new-member-confirm")
    public ResponseEntity newSubscriberConfirm(HttpServletRequest httpServletRequest, @Valid @RequestBody UserRequestForm userRequestForm) throws MessagingException {
        log.info("User confirmation email sendler START -> {}", userRequestForm);
        String text = messageBuilder.confirmEmailSubcription(userRequestForm);
        mailService.sendSimpleMessage(userRequestForm.getMail(), OBJECT_6, text);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/new-member")
    public ResponseEntity newSubscriber(HttpServletRequest httpServletRequest, @Valid @RequestBody UserDTO userDTO) throws MessagingException {
        log.info("NewSubscriber Mail sender start with request -> {}", userDTO);
        String text = messageBuilder.newSubscription(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_1, text);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping ("/reset-password")
    public ResponseEntity resetPassword(HttpServletRequest httpServletRequest, @Valid @RequestBody UserRequestForm userRequestForm) throws MessagingException {
        log.info("User ResetPasswordForm START -> {}", userRequestForm);
        String text = messageBuilder.newPassword(userRequestForm);
        mailService.sendSimpleMessage(userRequestForm.getMail(), OBJECT_5, text);
        return new ResponseEntity(HttpStatus.OK);
    }


    /*@PostMapping("/new-contact")
    public ResponseEntity mailFromForm(HttpServletRequest httpServletRequest, @Valid @RequestBody MailFromFormDTO mailFromFormDTO) throws MessagingException {
        log.info("mailFromForm Mail sender start with request -> {}", mailFromFormDTO);
        String text = messageBuilder.newContact(mailFromFormDTO);
        mailService.sendContactRequestMessage(HOST_MAIL, OBJECT_2, text);
        return new ResponseEntity(HttpStatus.OK);
    }*/



}
