package com.amos_tech_code.Blog.services;

import org.springframework.security.core.userdetails.UserDetails;


public interface AuthenticationService {

    UserDetails authenticate(String email, String password);

    String generateToken(UserDetails userDetails);

    UserDetails validateToken(String token);

}
