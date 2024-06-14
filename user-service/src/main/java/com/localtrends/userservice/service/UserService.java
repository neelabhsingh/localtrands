package com.localtrends.userservice.service;

import com.localtrends.userservice.model.User;
import com.localtrends.userservice.repository.RedisUserRepository;
import com.localtrends.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisUserRepository redisUserRepository;

    public User createUser(User user){
        User savedUser = userRepository.save(user);
        redisUserRepository.save(savedUser);
        return savedUser;
    }

    public User getUser(Long id){
        // You can decide whether to fetch from Redis or the relational database
        // Here's an example of fetching from Redis first, and if not found, then fetching from the relational database
        User user = redisUserRepository.findById(id);
        if (user == null) {
            user = userRepository.findById(id).orElse(null);
        }
        return user;
    }
}
