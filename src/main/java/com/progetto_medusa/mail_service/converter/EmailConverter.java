package com.progetto_medusa.mail_service.converter;

import com.progetto_medusa.mail_service.model.Request.NewEmailRequest;
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

}
