package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    // ✅ REGISTER USER
    @Override
    public String registerUser(RegisterRequest request) {

        // 🔴 Duplicate email check
        if (repo.findByEmail(request.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Email already exists");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        repo.save(user);

        return "User registered successfully";
    }

    // ✅ LOGIN USER
    @Override
    public String login(LoginRequest request) {

        User user = repo.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new ResourceNotFoundException("Invalid password");
        }

        return "Login successful";
    }
}
//lsof -i :9001  , kill -9 143120

