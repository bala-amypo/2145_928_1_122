// package com.example.demo.controller;

// import jakarta.validation.Valid;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.service.UserService;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService service;

//     public AuthController(UserService service) {
//         this.service = service;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<String> register(
//             @Valid @RequestBody RegisterRequest request) {

//         return ResponseEntity.ok(service.registerUser(request));
//     }

//     @PostMapping("/login")
//     public ResponseEntity<String> login(
//             @Valid @RequestBody LoginRequest request) {

//         return ResponseEntity.ok(service.login(request));
//     }
// }
package com.example.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        User user = userService.findByEmail(request.getEmail());

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                user.getId(), user.getEmail(), user.getRole());

        return new AuthResponse(
                token, user.getId(), user.getEmail(), user.getRole());
    }
}
