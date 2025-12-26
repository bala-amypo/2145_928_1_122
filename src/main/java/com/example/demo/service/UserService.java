// package com.example.demo.service;

// import com.example.demo.model.User;

// public interface UserService {

//     User register(User user);

//     LoginResponse login(String email, String password);

//     User findByEmail(String email);
// }
package com.example.demo.service;

import com.example.demo.dto.LoginResponse;
import com.example.demo.model.User;

public interface UserService {

    User register(User user);

    LoginResponse login(String email, String password);

    User findByEmail(String email);
}
