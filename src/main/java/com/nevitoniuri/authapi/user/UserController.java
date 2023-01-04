package com.nevitoniuri.authapi.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService service;
    private final UserAssembler assembler;

    @GetMapping
    public Page<UserResponse> list(Pageable pageable) {
        return service.list(pageable).map(assembler::toResponse);
    }

    @PostMapping
    public void create(@RequestBody @Valid UserCreate user) {
        service.save(assembler.toEntity(user));
    }

}
