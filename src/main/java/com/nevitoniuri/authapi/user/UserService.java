package com.nevitoniuri.authapi.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Page<User> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void save(User user) {
        repository.save(user);
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow();
    }

}
