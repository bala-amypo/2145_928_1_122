package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        // 🔹 generate JWT
        String token = userService.login(
                request.getEmail(),
                request.getPassword()
        );

        // 🔹 fetch user
        User user = userService.findByEmail(request.getEmail());

        // 🔹 RETURN RESPONSE BODY (THIS WAS MISSING / WRONG)
        return new LoginResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
