package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User u) {
        return service.insertUser(u);
    }

    @PostMapping("/login")
    public String login(@RequestBody User u) {
        User user = service.getUserByEmail(u.getEmail());
        if (user != null && user.getPassword().equals(u.getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }
}
