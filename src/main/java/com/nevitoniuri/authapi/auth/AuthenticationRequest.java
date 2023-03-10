package com.nevitoniuri.authapi.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AuthenticationRequest(
        @Email
        @NotBlank
        String email,
        @NotBlank
        String password) {
}
