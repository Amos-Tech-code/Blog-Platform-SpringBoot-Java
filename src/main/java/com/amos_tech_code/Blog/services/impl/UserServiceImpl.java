package com.amos_tech_code.Blog.services.impl;

import com.amos_tech_code.Blog.domain.entities.User;
import com.amos_tech_code.Blog.repositories.UserRepository;
import com.amos_tech_code.Blog.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
}
