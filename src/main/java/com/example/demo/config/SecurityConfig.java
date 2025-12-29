// package com.example.demo.config;

// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class SecurityConfig {
// }
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF for REST APIs
            .csrf(csrf -> csrf.disable())

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                // Public endpoints (no authentication needed)
                .requestMatchers(
                        "/auth/register",
                        "/auth/login",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/h2-console/**"
                ).permitAll()

                // All other APIs are allowed (for now)
                .anyRequest().permitAll()
            )

            // Disable default login pages
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable());

        return http.build();
    }

    // Password encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
