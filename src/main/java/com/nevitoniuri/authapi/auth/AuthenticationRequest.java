package com.nevitoniuri.authapi.auth;

import lombok.Builder;

@Builder
public record AuthenticationRequest(String email, String password) {
}
