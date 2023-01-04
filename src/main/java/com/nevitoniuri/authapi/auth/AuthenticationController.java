package com.nevitoniuri.authapi.auth;

import jakarta.validation.Valid;
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

    @PostMapping
    public AuthenticationResponse authenticate(@RequestBody @Valid AuthenticationRequest request) {
        return service.authenticate(request);
    }
}
