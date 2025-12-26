// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;
//     private final JwtUtil jwtUtil;

//     public UserServiceImpl(UserRepository userRepository,
//                            PasswordEncoder passwordEncoder,
//                            JwtUtil jwtUtil) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//         this.jwtUtil = jwtUtil;
//     }

//     // ================= REGISTER =================
//     @Override
//     public User register(User user) {

//         // encrypt password
//         user.setPassword(passwordEncoder.encode(user.getPassword()));

//         return userRepository.save(user);
//     }

//     // ================= LOGIN =================
//     @Override
//     public String login(String email, String password) {

//         User user = userRepository.findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         if (!passwordEncoder.matches(password, user.getPassword())) {
//             throw new RuntimeException("Invalid password");
//         }

//         // 🔥 JWT GENERATED HERE
//         return jwtUtil.generateToken(
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );
//     }

//     // ================= FIND USER =================
//     @Override
//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("User not found"));
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.dto.LoginResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserRepository repo,
                           PasswordEncoder encoder,
                           JwtUtil jwtUtil) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public LoginResponse login(String email, String password) {

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole(),
                user.getId()
        );

        return new LoginResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email).orElseThrow();
    }
}
