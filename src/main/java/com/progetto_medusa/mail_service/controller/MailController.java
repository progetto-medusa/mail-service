package com.progetto_medusa.mail_service.controller;



import com.progetto_medusa.mail_service.converter.EmailConverter;
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
import com.progetto_medusa.mail_service.model.Request.NewEmailRequest;
import com.progetto_medusa.mail_service.converter.EmailConverter;

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
    private final EmailConverter emailConverter;



    @PostMapping ("/new-member-confirm")
    public ResponseEntity newSubscriberConfirm(HttpServletRequest httpServletRequest, @Valid @RequestBody UserRequestForm userRequestForm) throws MessagingException {
        log.info("User confirmation email sendler START -> {}", userRequestForm);
        UserDTO userDTO = emailConverter.userRequestFormToUserDTO(userRequestForm);
        String text = messageBuilder.confirmEmailSubcription(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_1, text);
        return new ResponseEntity(HttpStatus.OK);
    }

   /* @PostMapping("/new-member")
    public ResponseEntity newSubscriber(HttpServletRequest httpServletRequest, @Valid @RequestBody UserRequestForm userRequestForm) throws MessagingException {
        log.info("NewSubscriber Mail sender start with request -> {}", userRequestForm);
        UserDTO userDTO = converterUserRequestToUserDTO.userRequestFormToUserDTO(userRequestForm);
        String text = messageBuilder.newSubscription(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_2, text);
        return new ResponseEntity(HttpStatus.OK);
    }*/


    @PostMapping ("/reset-password")
    public ResponseEntity<Object> resetPassword(HttpServletRequest httpServletRequest,
                                                @Valid @RequestBody UserRequestForm userRequestForm) throws MessagingException {
        log.info("User ResetPasswordForm START -> {}", userRequestForm);
        UserDTO userDTO = emailConverter.userRequestFormToUserDTO(userRequestForm);
        String text = messageBuilder.newPassword(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_3, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/new-campaign-avaliable")
    public ResponseEntity<Void> newCampaignAvaliable(HttpServletRequest request,
                                                 @Valid @RequestBody NewEmailRequest newEmailRequest) throws Exception {
        log.info("NewCampaignAvaliable Mail sender start from {} with requestForm -> {}",
                request.getRemoteAddr(), newEmailRequest);
        UserDTO userDTO = emailConverter.newEmailRequestToUserDTO(newEmailRequest);
        String text = messageBuilder.newCampaignToUser(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_4, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/game-session-start")
    public ResponseEntity<Void> gameSessionStart(HttpServletRequest request,
                                                 @Valid @RequestBody NewEmailRequest newEmailRequest) throws Exception {
        log.info("GameSessionStart Mail sender start from {} with requestForm -> {}",
                request.getRemoteAddr(), newEmailRequest);
        UserDTO userDTO = emailConverter.newEmailRequestToUserDTO(newEmailRequest);
        String text = messageBuilder.newGameSessionStart(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_5, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/custom-to-user")
    public ResponseEntity<Void> customToUser(HttpServletRequest request,
                                             @Valid @RequestBody NewEmailRequest newEmailRequest) throws Exception {
        log.info("CustomToUser Mail sender start from {} with requestForm -> {}",
                request.getRemoteAddr(), newEmailRequest);
        UserDTO userDTO = emailConverter.newEmailRequestToUserDTO(newEmailRequest);
        String text = messageBuilder.customMessage(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_6, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/maintenance-notice")
    public ResponseEntity<Void> sendMaintenanceNotice (HttpServletRequest request) throws Exception {
        log.info("MaintenanceNotice Mail sender start from {}", request.getRemoteAddr());
        String text = messageBuilder.newMaintenanceNotice();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/new-subscription-campaign")
    public ResponseEntity<Void> sendNewSubscription(HttpServletRequest request,
                                                    @Valid @RequestBody NewEmailRequest newEmailRequest) throws Exception {
        log.info("NewSubscription Mail sender start from {} with requestForm -> {}",
                request.getRemoteAddr(), newEmailRequest);
        UserDTO userDTO = emailConverter.newEmailRequestToUserDTO(newEmailRequest);
        String text = messageBuilder.newSubscriptionToCampaign(userDTO);
        mailService.sendSimpleMessage(userDTO.getMail(), OBJECT_8, text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
