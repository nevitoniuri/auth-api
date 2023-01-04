package com.nevitoniuri.authapi.auth;

import com.nevitoniuri.authapi.config.JwtService;
import com.nevitoniuri.authapi.user.Role;
import com.nevitoniuri.authapi.user.User;
import com.nevitoniuri.authapi.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.firstName())
                .lastname(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return getAuthenticationResponse(user);
    }

    public AuthenticationResponse aunthenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = userRepository.findByEmail(request.email()).orElseThrow();
        return getAuthenticationResponse(user);
    }

    private AuthenticationResponse getAuthenticationResponse(User user) {
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
