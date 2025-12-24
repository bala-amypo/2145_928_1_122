// package com.example.demo.service;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.RegisterRequest;

// public interface UserService {

//     String registerUser(RegisterRequest request);

//     String login(LoginRequest request);
// }
package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User registerUser(User user);
    User findByEmail(String email);
    User findById(Long id);
}
