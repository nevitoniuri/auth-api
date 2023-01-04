package com.nevitoniuri.authapi.auth;

import lombok.Builder;

@Builder
public record AuthenticationResponse(String token) {

}
