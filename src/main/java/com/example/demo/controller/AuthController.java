package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> request) {

        return userService.registerUser(
                request.get("fullName"),
                request.get("email"),
                request.get("password"),
                request.get("role")
        );
    }

    // ✅ LOGIN (THIS FIX RETURNS TOKEN)
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {

        String token = userService.login(
                request.get("email"),
                request.get("password")
        );

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }
}
