package com.progetto_medusa.mail_service.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewEmailRequest {

    @NotBlank
    private String mail;
    @NotBlank
    private String username;

}