package com.progetto_medusa.mail_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {

    @JsonProperty("mail")
    private String mail;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;


}
