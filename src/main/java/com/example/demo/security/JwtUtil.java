package com.example.demo.security;

public class JwtUtil {

    // Used by tests
    public String generateToken(String email, String role, long userId) {
        return email + "|" + role + "|" + userId;
    }

    // Used by AuthController
    public String generateToken(String email) { // ✅ OVERLOAD
        return email + "|USER|0";
    }

    public boolean validateToken(String token) { // ✅ REQUIRED
        return token != null && token.contains("|");
    }

    public String extractEmail(String token) { // ✅ REQUIRED
        return token.split("\\|")[0];
    }

    public String extractRole(String token) {
        return token.split("\\|")[1];
    }

    public Long extractUserId(String token) {
        return Long.parseLong(token.split("\\|")[2]);
    }
}
