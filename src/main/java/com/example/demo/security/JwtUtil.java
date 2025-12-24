package com.example.demo.security;

public class JwtUtil {

    // Dummy implementation ONLY for tests

    public String generateToken(String email, String role, long userId) {
        return email + "|" + role + "|" + userId;
    }

    public String extractRole(String token) {
        return token.split("\\|")[1];
    }

    public Long extractUserId(String token) {
        return Long.parseLong(token.split("\\|")[2]);
    }
}
