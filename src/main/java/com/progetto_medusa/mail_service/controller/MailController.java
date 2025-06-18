package com.progetto_medusa.mail_service.controller;

import com.progetto_medusa.mail_service.model.MailFromFormDTO;

import com.progetto_medusa.mail_service.model.Request.UserRequestForm;
import com.progetto_medusa.mail_service.model.UserDTO;
import com.progetto_medusa.mail_service.service.ExternalCallingService;
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
    public static final String OBJECT_7 = " ";
    public static final String OBJECT_8 = " ";

    private final MailServiceImpl mailService;
    private final MessageBuilder messageBuilder;
    private final ExternalCallingService externalCallingService;


    @PostMapping ("/new-member-confirm")
    public ResponseEntity<Object> newSubscriberConfirm(HttpServletRequest httpServletRequest, @Valid @RequestBody UserRequestForm userRequestForm) throws MessagingException {
        log.info("User confirmation email sendler START -> {}", userRequestForm);
        String text = messageBuilder.confirmEmailSubcription(userRequestForm);
        mailService.sendSimpleMessage(userRequestForm.getMail(), OBJECT_1, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/new-member")
    public ResponseEntity<Object> newSubscriber(HttpServletRequest httpServletRequest, @Valid @RequestBody UserDTO userDTO) throws MessagingException {
        log.info("NewSubscriber Mail sender start with request -> {}", userDTO);
        String text = messageBuilder.newSubscription(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_2, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping ("/reset-password")
    public ResponseEntity<Object> resetPassword(HttpServletRequest httpServletRequest, @Valid @RequestBody UserRequestForm userRequestForm) throws MessagingException {
        log.info("User ResetPasswordForm START -> {}", userRequestForm);
        String text = messageBuilder.newPassword(userRequestForm);
        mailService.sendSimpleMessage(userRequestForm.getMail(), OBJECT_3, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/mail/game-session-start")
    public ResponseEntity<Void> gameSessionStart(HttpServletRequest request,
                                                     @Valid @RequestBody UserRequestForm userRequestForm) throws Exception {
        log.info("GameSessionStart Mail sender start from {} with requestForm -> {}",
                request.getRemoteAddr(), userRequestForm);
        UserDTO userDTO = userRequestForm.toUserDTO();
        String text = mailService.prepareGameSessionStart(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_2, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/mail/custom-to-user")
    public ResponseEntity<Void> customToUser(HttpServletRequest request,
                                                 @Valid @RequestBody UserRequestForm userRequestForm) throws Exception {
        log.info("CustomToUser Mail sender start from {} with requestForm -> {}",
                request.getRemoteAddr(), userRequestForm);
        UserDTO userDTO = userRequestForm.toUserDTO();
        String text = mailService.prepareNotification(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_3, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/mail/custom-to-all")
    public ResponseEntity<Void> sendCustomToAll(HttpServletRequest request) throws Exception {
        log.info("CustomToAll Mail sender start from {}", request.getRemoteAddr());
        mailService.sendCustomMailToAll(OBJECT_4);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/mail/maintenance-notice")
    public ResponseEntity<Void> sendMaintenanceNotice (HttpServletRequest request) throws Exception {
        log.info("MaintenanceNotice Mail sender start from {}", request.getRemoteAddr());
        mailService.sendMaintenanceNotice(OBJECT_5);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/mail/new-subscription")
    public ResponseEntity<Void> sendNewSubscription(HttpServletRequest request,
                                                    @Valid @RequestBody UserRequestForm userRequestForm) throws Exception {
        log.info("NewSubscription Mail sender start from {} with requestForm -> {}",
                request.getRemoteAddr(), userRequestForm);
        UserDTO userDTO = userRequestForm.toUserDTO();
        String text = mailService.prepareNewSubscription(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_1, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
