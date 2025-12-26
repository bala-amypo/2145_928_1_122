package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User registerUser(String fullName, String email, String password, String role);

    String login(String email, String password);
}
