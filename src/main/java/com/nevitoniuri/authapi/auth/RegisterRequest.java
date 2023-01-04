package com.nevitoniuri.authapi.auth;

import lombok.Builder;

@Builder
public record RegisterRequest(String firstName, String lastName, String email, String password) {
}
