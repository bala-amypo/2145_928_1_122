package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.User;

public class UserRepository {
    Map<String, User> map = new HashMap<>();

    public User save(User u) {
        map.put(u.getEmail(), u);
        return u;
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(map.get(email));
    }
}
