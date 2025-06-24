package com.progetto_medusa.mail_service.converter;

import com.progetto_medusa.mail_service.model.Request.NewEmailRequest;
import com.progetto_medusa.mail_service.model.Request.NewPasswordRequest;
import com.progetto_medusa.mail_service.model.Request.ResetPasswordEmailRequest;
import com.progetto_medusa.mail_service.model.Request.UserRequestForm;
import com.progetto_medusa.mail_service.model.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class EmailConverter {

    public UserDTO userRequestFormToUserDTO (UserRequestForm userRequestForm){
        UserDTO userDTO= new UserDTO();
        userDTO.setMail(userRequestForm.getMail());
        userDTO.setUsername(userRequestForm.getUsername());
        userDTO.setConfirmationToken(userRequestForm.getConfirmationToken());

        return userDTO;
    }

    public UserDTO newEmailRequestToUserDTO (NewEmailRequest newEmailRequest){
        UserDTO userDTO= new UserDTO();
        userDTO.setMail(newEmailRequest.getMail());
        userDTO.setUsername(newEmailRequest.getUsername());

        return userDTO;
    }
    public UserDTO resetPasswordEmailRequestToUserDTO (NewPasswordRequest newPasswordRequest){
        UserDTO userDTO= new UserDTO();
        userDTO.setMail(newPasswordRequest.getEmail());
        userDTO.setConfirmationToken(newPasswordRequest.getToken());

        return userDTO;
    }

    public UserDTO resetPasswordConfirmed (ResetPasswordEmailRequest resetPasswordEmailRequest){
        UserDTO userDTO= new UserDTO();
        userDTO.setMail(resetPasswordEmailRequest.getEmail());

        return userDTO;
    }



}
