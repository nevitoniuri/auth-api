package com.nevitoniuri.authapi.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAssembler {

    private final PasswordEncoder passwordEncoder;

    public User toEntity(UserCreate userCreate) {
        return User.builder()
                .firstname(userCreate.firstName())
                .lastname(userCreate.lastName())
                .email(userCreate.email())
                .password(passwordEncoder.encode(userCreate.password()))
                .role(Role.USER)
                .build();
    }

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstname())
                .lastName(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
