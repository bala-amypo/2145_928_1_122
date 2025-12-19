package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String registerUser(RegisterRequest request) {

        // example duplicate check
        if ("admin@gmail.com".equals(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        return "User registered successfully";
    }

    @Override
    public String login(LoginRequest request) {

        if (!"admin@gmail.com".equals(request.getEmail())) {
            throw new ResourceNotFoundException("User not found");
        }

        if (!"admin".equals(request.getPassword())) {
            throw new ResourceNotFoundException("Invalid password");
        }

        return "Login successful";
    }
}
