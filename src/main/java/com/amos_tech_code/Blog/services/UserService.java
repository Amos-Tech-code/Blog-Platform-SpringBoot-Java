package com.amos_tech_code.Blog.services;

import com.amos_tech_code.Blog.domain.entities.User;

import java.util.UUID;

public interface UserService {

    User getUserById(UUID id);

}
