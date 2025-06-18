package com.progetto_medusa.mail_service.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestForm {

    @NotBlank
    private String mail;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmationToken;
}
