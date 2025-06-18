package com.progetto_medusa.mail_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class MailFromFormDTO {
    @NotBlank(message = "username is mandatory")
    @JsonProperty("username")
    private String username;
    @NotBlank(message = "email is mandatory")
    @JsonProperty("email")
    private String email;
    @NotBlank(message = "message is mandatory")
    @JsonProperty("message")
    private String message;
    @NotBlank(message = "application_id is mandatory")
    @JsonProperty("application_id")
    private String applicationId;
}
