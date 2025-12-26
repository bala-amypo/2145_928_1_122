// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;

// import java.security.Key;
// import java.util.Date;

// @Component
// public class JwtUtil {

//     private static final String SECRET = "mysecretkeymysecretkeymysecretkey12345";
//     private static final long EXPIRATION = 1000 * 60 * 60; // 1 hour

//     private Key getSigningKey() {
//         return Keys.hmacShaKeyFor(SECRET.getBytes());
//     }

//     // ✅ Generate token
//     public String generateToken(Long userId, String email, String role) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("userId", userId)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
//                 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     // ✅ REQUIRED BY TESTS
//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                     .setSigningKey(getSigningKey())
//                     .build()
//                     .parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     // ✅ REQUIRED BY TESTS
//     public String extractRole(String token) {
//         Claims claims = getClaims(token);
//         return claims.get("role", String.class);
//     }

//     // ✅ REQUIRED BY TESTS
//     public Long extractUserId(String token) {
//         Claims claims = getClaims(token);
//         return claims.get("userId", Long.class);
//     }

//     // ✅ REQUIRED BY FILTER
//     public String extractEmail(String token) {
//         return getClaims(token).getSubject();
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(getSigningKey())
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkeymysecretkey";

    private static final long EXPIRATION = 1000 * 60 * 60;

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // ✅ EXACT ORDER REQUIRED BY TESTS
    public String generateToken(String email, String role, Long userId) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            parse(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        return parse(token).getSubject();
    }

    public String extractRole(String token) {
        return parse(token).get("role", String.class);
    }

    public Long extractUserId(String token) {
        return parse(token).get("userId", Long.class);
    }

    private Claims parse(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
