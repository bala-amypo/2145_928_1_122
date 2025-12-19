package com.example.demo.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public class UserRepository {

    private Map<Long, User> users = new HashMap<>();

    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public Optional<User> findByEmail(String email) {
        return users.values()
                .stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
    }
}
