package com.progetto_medusa.mail_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import lombok.*;


@Data
public class CreateUserDTO {
    @NotBlank(message = "username is mandatory")
    @JsonProperty("username")
    private String username;

}
