package com.progetto_medusa.mail_service.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewPasswordRequest {
    @JsonProperty("application_id")
    private String applicationId;
    @NotBlank
    private String email;
    @NotBlank
    private String token;
}
