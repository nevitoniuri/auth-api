package com.nevitoniuri.authapi.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("register")
    public AuthenticationResponse register(@RequestBody RegisterRequest request) {
        return service.register(request);
    }

    @PostMapping("authenticate")
    public AuthenticationResponse aunthenticate(@RequestBody AuthenticationRequest request) {
        return service.aunthenticate(request);
    }
}
