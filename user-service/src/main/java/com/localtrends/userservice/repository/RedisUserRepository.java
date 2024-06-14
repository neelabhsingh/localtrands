package com.localtrends.userservice.repository;

import com.localtrends.userservice.model.User;

import java.util.Map;

public interface RedisUserRepository {
    void save(User user);
    Map<String, User> findAll();
    User findById(Long id);
    void update(User user);
    void delete(String id);
}
