package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // 🔐 SECRET KEY (keep same everywhere)
    private static final String SECRET_KEY = "mySecretKey12345";

    // ⏱ Token validity (24 hours)
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    // ================= GENERATE TOKEN =================
    public String generateToken(Long userId, String email, String role) {

        return Jwts.builder()
                .setSubject(email)                 // email as subject
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // ================= EXTRACT EMAIL =================
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    // ================= EXTRACT CLAIMS =================
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    // ================= VALIDATE TOKEN =================
    public boolean validateToken(String token, String email) {
        String extractedEmail = extractEmail(token);
        return extractedEmail.equals(email) && !isTokenExpired(token);
    }

    // ================= CHECK EXPIRY =================
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }
}
