// package com.example.demo.security;

// import org.springframework.stereotype.Component;

// @Component
// public class JwtUtil {

//     public String generateToken(String email, String role, Long userId) {
//         return "mock.jwt.token";
//     }

//     public boolean validateToken(String token) {
//         return true;
//     }

//     public String extractEmail(String token) {
//         return "user@mail.com";
//     }

//     public String extractRole(String token) {
//         return "ADMIN";
//     }

//     public Long extractUserId(String token) {
//         return 1L;
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "secretkey123";

    public String generateToken(String email, String role, Long userId) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}
