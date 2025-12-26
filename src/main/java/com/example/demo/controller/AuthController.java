package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        String token = userService.login(
                request.getEmail(),
                request.getPassword()
        );

        User user = userService.findByEmail(request.getEmail());

        return ResponseEntity.ok(
                new LoginResponse(
                        token,
                        user.getId(),
                        user.getEmail(),
                        user.getRole()
                )
        );
    }
}
