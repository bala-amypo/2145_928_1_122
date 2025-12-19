package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    public User insertUser(User u) {
        return repo.save(u);
    }

    public User getUserByEmail(String email) {
        return repo.findByEmail(email).orElse(null);
    }
}
