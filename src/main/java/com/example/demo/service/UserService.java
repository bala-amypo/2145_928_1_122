package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User insertUser(User u);
    User getUserByEmail(String email);
}
