package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final JwtUtil jwtUtil;

    public UserServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User register(User user) {
        return user;
    }

    @Override
    public String login(String email, String password) {
        return jwtUtil.generateToken(email, "ADMIN", 1L);
    }

    @Override
    public User findByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        user.setRole("ADMIN");
        user.setId(1L);
        return user;
    }
}

